package Visitors.CodeGeneration;

import Helpers.CodeGenerator;
import Helpers.FileManager;
import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.ArithmeticNodes.IArithmeticNode;
import Nodes.AssignNodes.AssignNode;
import Nodes.BlockStatements.BlockNode;
import Nodes.BooleanNodes.IBooleanNode;
import Nodes.ComparisonNodes.IComparisonNode;
import Nodes.ControlStatements.IfNode;
import Nodes.ControlStatements.WhileNode;
import Nodes.FunctionNodes.FunctionBodyNode;
import Nodes.FunctionNodes.FunctionDefNode;
import Nodes.FunctionNodes.FunctionParamNode;
import Nodes.FunctionNodes.FunctionParamsNode;
import Nodes.ImpexNodes.ExportNode;
import Nodes.ImpexNodes.ImportNode;
import Nodes.MapNodes.*;
import Nodes.PrimitiveDeclarationNode;
import Nodes.ProgramNode;
import Nodes.StringNodes.IStringNode;
import SymbolTable.SymbolTable;
import SymbolTable.SymbolTableInstance;

import java.util.ArrayList;
import java.util.HashMap;

public class CodeEmitVisitor extends BaseCodeEmitVisitor {
  public Void dispatch(AbstractNode n) {
    if(n instanceof ProgramNode) return visit((ProgramNode) n);
    if(n instanceof FunctionDefNode) return visit((FunctionDefNode) n);
    if(n instanceof PrimitiveDeclarationNode) return visit((PrimitiveDeclarationNode) n);
    if(n instanceof ImportNode) return visit((ImportNode) n);
    if(n instanceof ExportNode) return visit((ExportNode) n);
    if(n instanceof AssignNode) return visit((AssignNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof IArithmeticNode) return visit((IArithmeticNode) n);
    if(n instanceof IBooleanNode) return visit((IBooleanNode) n);
    if(n instanceof IStringNode) return visit((IStringNode) n);
    if(n instanceof IComparisonNode) return visit((IComparisonNode) n);
    if(n instanceof IMapExpressionNode) return visit((IMapExpressionNode) n);
    if(n instanceof IfNode) return visit((IfNode) n);
    if(n instanceof WhileNode) return visit((WhileNode) n);
    if(n instanceof FunctionBodyNode) return visit((FunctionBodyNode) n);
    if(n instanceof FunctionParamsNode) return visit((FunctionParamsNode) n);
    if(n instanceof FunctionParamNode) return visit((FunctionParamNode) n);
    if(n instanceof BlockNode) return visit((BlockNode) n);
    if(n instanceof MapDeclarationNode) return visit((MapDeclarationNode) n);
    if(n instanceof MapPropsAssignNode) return visit((MapPropsAssignNode) n);
    if(n instanceof MapPropsAssignBodyNode) return visit((MapPropsAssignBodyNode) n);
    if(n instanceof MapQueryNode) return visit((MapQueryNode) n);
    if(n instanceof CoordinatesNode) return visit((CoordinatesNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(ProgramNode n) {
    CodeGenerator.openProgram();
    SymbolTable.push();
    AbstractNode instruction = n.leftmostChild;
    HashMap<String, ArrayList<String>> imports = new HashMap<>();
    while(instruction instanceof ImportNode) {
      FileManager.parseFile(((ImportNode) instruction).getPath(),false, false, true);
      imports.put(CodeGenerator.getProgramName(), new ArrayList<>());
      AbstractNode identifier = ((ImportNode) instruction).getVars();
      while(identifier != null) {
        String name = ((IdentifierNode) identifier).getValue();
        SymbolTable.peek().enterSymbol(name, Types.MAP);
        imports.get(CodeGenerator.getProgramName()).add(getVarName(name));
        identifier = identifier.rightSib;
      }
      CodeGenerator.closeProgram();
      instruction = instruction.rightSib;
    }

    CodeGenerator.appendCode("class " + CodeGenerator.getProgramName() + " {\n");

    imports.forEach((k, v) -> {
      CodeGenerator.appendCode("private static HashMap<String, MapAttr> imports" + k + " = " + k + "._body();\n");
      v.forEach(s -> {
        CodeGenerator.appendCode("private static MapAttr " + s + " = imports" + k + ".get(\"" + s + "\");\n");
      });
    });

    while(instruction instanceof FunctionDefNode) {
      visit(instruction);
      instruction = instruction.rightSib;
    }

    CodeGenerator.appendCode("public static HashMap<String, MapAttr> _body() {\n");

    while(instruction != null && !(instruction instanceof ExportNode)) {
      visit(instruction);
      instruction = instruction.rightSib;
    }
    if(instruction != null) visit(instruction);
    else CodeGenerator.appendCode("return null");

    CodeGenerator.appendCode("}\n");

    SymbolTable.pop();
    CodeGenerator.appendCode("}\n");
    return null;
  }

  public Void visit(ExportNode n) {
    AbstractNode var = n.getVars();
    CodeGenerator.appendCode("HashMap<String, MapAttr> _export = new HashMap<>();\n");
    while(var != null) {
      String name = getVarName(((IdentifierNode) var).getValue());
      CodeGenerator.appendCode("_export.put(\"" + name + "\", " + name +");\n");
      var = var.rightSib;
    }
    CodeGenerator.appendCode("return _export;\n");
    return null;
  }

  public Void visit(PrimitiveDeclarationNode n) {
    CodeGenerator.appendCode(typeString(n.getType()));
    SymbolTableInstance st = SymbolTable.peek();
    AbstractNode declaration = n.getDeclarations();
    while(declaration != null) {
      if(declaration instanceof IdentifierNode) {
        st.enterSymbol(((IdentifierNode) declaration).getValue(), n.getType());
        CodeGenerator.appendCode(getVarName(((IdentifierNode) declaration).getValue()));
      }
      if(declaration instanceof AssignNode) {
        st.enterSymbol(((AssignNode) declaration).getIdentifier(), n.getType());
        visit(declaration);
      }
      if(declaration.rightSib != null) CodeGenerator.appendCode(", ");
      declaration = declaration.rightSib;
    }
    CodeGenerator.appendCode(";\n");
    return null;
  }

  public Void visit(MapDeclarationNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    st.enterSymbol(n.getIdentifier(),Types.MAP);
    CodeGenerator.appendCode("MapAttr " + getVarName(n.getIdentifier()) + " = MapOps.createMap(");
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    arithmVis.visit(n.getSizeX());
    CodeGenerator.appendCode(",");
    arithmVis.visit(n.getSizeY());
    CodeGenerator.appendCode(",");
    if(n.getRecord() != null) {
      visit(n.getRecord());
    } else CodeGenerator.appendCode("null");
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(MapPropsAssignNode n) {
    CodeGenerator.appendCode("MapOps.changeMap(");
    CodeGenerator.appendCode(getVarName(n.getName()));
    CodeGenerator.appendCode(",");
    visit(n.getPropBody());
    CodeGenerator.appendCode(",");
    if(n.getQuery() != null) {
      visit(n.getQuery());
    } else CodeGenerator.appendCode("null");
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(MapPropsAssignBodyNode n) {
    CodeGenerator.appendCode("new CellAttr()");
    AbstractNode declarations = n.getProps();
    while(declarations != null) {
      AbstractNode declaration = ((PrimitiveDeclarationNode) declarations).getDeclarations();
      String type = ((PrimitiveDeclarationNode) declarations).getType();
      while(declaration != null) {
        if(declaration instanceof IdentifierNode) {
          String varName = ((IdentifierNode) declaration).getValue();
          if(type.equals(Types.INT)) CodeGenerator.appendCode(".addProp(\"" + varName + "\", 0)");
          if(type.equals(Types.STRING)) CodeGenerator.appendCode(".addProp(\"" + varName + "\", \"\")");
          if(type.equals(Types.BOOL)) CodeGenerator.appendCode(".addProp(\"" + varName + "\", false)");
        }
        if(declaration instanceof AssignNode) {
          String varName = ((AssignNode) declaration).getIdentifier();
          AbstractNode expression = ((AssignNode) declaration).getExpression();
          if (type.equals(Types.INT)) {
            ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
            CodeGenerator.appendCode(".addProp(\"" + varName + "\",");
            visitor.visit(expression);
            CodeGenerator.appendCode(")");
          }
          if (type.equals(Types.STRING)) {
            StringCodeEmitVisitor visitor = new StringCodeEmitVisitor();
            CodeGenerator.appendCode(".addProp(\"" + varName + "\",");
            visitor.visit(expression);
            CodeGenerator.appendCode(")");
          }
          if (type.equals(Types.BOOL)) {
            BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
            CodeGenerator.appendCode(".addProp(\"" + varName + "\",");
            visitor.visit(expression);
            CodeGenerator.appendCode(")");
          }
        }
        declaration = declaration.rightSib;
      }
      declarations = declarations.rightSib;
    }
    return null;
  }

  public Void visit(MapQueryNode n) {
    CodeGenerator.appendCode("new ArrayList<>(Arrays.asList(new String []{");
    visitChildren(n);
    CodeGenerator.appendCode("}))");
    return null;
  }

  public Void visit(CoordinatesNode n) {
    ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
    CodeGenerator.appendCode("\"");
    visitor.visit(n.getX());
    CodeGenerator.appendCode(".");
    visitor.visit(n.getY());
    CodeGenerator.appendCode("\"");
    if(n.rightSib != null) CodeGenerator.appendCode(", ");
    return null;
  }

  public Void visit(FunctionDefNode n) {
    SymbolTable.peek().enterSymbol(n.getName(), Types.FUNCTION);
    String name = getVarName(n.getName());
    CodeGenerator.appendCode("public static " + typeString(n.getType()) + name);
    SymbolTable.push();
    visit(n.getParams());
    CodeGenerator.appendCode("{\n");
    visit(n.getBody());
    CodeGenerator.appendCode("return ");
    if(n.getType().equals(Types.INT)) {
      ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
      visitor.visit(n.getReturnExp());
    } else if(n.getType().equals(Types.BOOL)) {
      BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
      visitor.visit(n.getReturnExp());
    } else if(n.getType().equals(Types.STRING)) {
      StringCodeEmitVisitor visitor = new StringCodeEmitVisitor();
      visitor.visit(n.getReturnExp());
    }
    CodeGenerator.appendCode(";");
    CodeGenerator.appendCode("\n}\n");
    SymbolTable.pop();
    return null;
  }

  public Void visit(FunctionParamsNode n) {
    CodeGenerator.appendCode("(");
    AbstractNode param = n.getParams();
    visit(param);
    param = param.rightSib;
    while(param != null) {
      CodeGenerator.appendCode(",");
      visit(param);
      param = param.rightSib;
    }
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(FunctionParamNode n) {
    SymbolTable.peek().enterSymbol(n.getName(), n.getType());
    CodeGenerator.appendCode(typeString(n.getType()) + getVarName(n.getName()));
    return null;
  }

  public Void visit(FunctionBodyNode n) {
    visitChildren(n);
    return null;
  }

  public Void visit(AssignNode n) {
    String assignedName = getVarName(n.getIdentifier());
    CodeGenerator.appendCode(assignedName + " = ");
    if(n.type.equals(Types.INT)) {
      ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
      visitor.visit(n.getExpression());
    } else if(n.type.equals(Types.BOOL)) {
      BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
      visitor.visit(n.getExpression());
    } else if(n.type.equals(Types.STRING)) {
      StringCodeEmitVisitor visitor = new StringCodeEmitVisitor();
      visitor.visit(n.getExpression());
    } else if(n.type.equals(Types.MAP)) {
      MapCodeEmitVisitor visitor = new MapCodeEmitVisitor();
      visitor.visit(n.getExpression());
    }
    CodeGenerator.appendCode("\n");
    return null;
  }

  public Void visit(IdentifierNode n) {
    CodeGenerator.appendCode("System.out.println(");
    super.visit(n);
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(FunctionCallNode n) {
    CodeGenerator.appendCode("System.out.println(");
    super.visit(n);
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(IArithmeticNode n) {
    CodeGenerator.appendCode("System.out.println(");
    ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
    visitor.visit((AbstractNode) n);
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(IBooleanNode n) {
    CodeGenerator.appendCode("System.out.println(");
    BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
    visitor.visit((AbstractNode) n);
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(IStringNode n) {
    CodeGenerator.appendCode("System.out.println(");
    StringCodeEmitVisitor visitor = new StringCodeEmitVisitor();
    visitor.visit((AbstractNode) n);
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(IComparisonNode n) {
    CodeGenerator.appendCode("System.out.println(");
    ComparisonCodeEmitVisitor visitor = new ComparisonCodeEmitVisitor();
    visitor.visit((AbstractNode) n);
    CodeGenerator.appendCode(");\n");
    return null;
  }

  public Void visit(IMapExpressionNode n) {
    MapCodeEmitVisitor visitor = new MapCodeEmitVisitor();
    visitor.visit((AbstractNode) n);
    CodeGenerator.appendCode(".print();\n");
    return null;
  }

  public Void visit(BlockNode n) {
    CodeGenerator.appendCode("{\n");
    visitChildren(n);
    CodeGenerator.appendCode("\n}\n");
    return null;
  }

  public Void visit(IfNode n) {
    CodeGenerator.appendCode("if (");
    BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
    visitor.visit(n.getPredicate());
    CodeGenerator.appendCode(")\n");
    visit(n.getThenBlock());
    if(n.getElseBlock() != null) {
      CodeGenerator.appendCode("else");
      visit(n.getElseBlock());
    }
    return null;
  }

  public Void visit(WhileNode n) {
    CodeGenerator.appendCode("while (");
    BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
    visitor.visit(n.getPredicate());
    CodeGenerator.appendCode(")");
    visit(n.getBlock());
    return null;
  }
}