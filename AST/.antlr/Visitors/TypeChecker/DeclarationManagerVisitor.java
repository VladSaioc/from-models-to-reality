package Visitors.TypeChecker;

import Helpers.FileManager;
import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.AssignNodes.AssignNode;
import Nodes.BlockStatements.BlockNode;
import Nodes.ControlStatements.IfNode;
import Nodes.ControlStatements.WhileNode;
import Nodes.ExpressionNodes.IExpressionNode;
import Nodes.FunctionNodes.FunctionBodyNode;
import Nodes.FunctionNodes.FunctionDefNode;
import Nodes.FunctionNodes.FunctionParamNode;
import Nodes.ImpexNodes.ExportNode;
import Nodes.ImpexNodes.ImportNode;
import Nodes.MapNodes.CoordinatesNode;
import Nodes.MapNodes.MapDeclarationNode;
import Nodes.MapNodes.MapPropsAssignNode;
import Nodes.MapNodes.MapQueryNode;
import Nodes.PrimitiveDeclarationNode;
import Nodes.ProgramNode;
import SymbolTable.Attr.FunctionAttr;
import SymbolTable.SymbolTable;
import SymbolTable.SymbolTableInstance;
import SymbolTable.Symbols.MapSymbol;
import SymbolTable.Symbols.Symbol;
import Visitors.BaseVisitor;

import java.util.ArrayList;
import java.util.Arrays;

public class DeclarationManagerVisitor extends BaseVisitor<Void> {
  public Void dispatch(AbstractNode n) {
    if(n instanceof ProgramNode) return visit((ProgramNode) n);
    if(n instanceof ImportNode) return visit((ImportNode) n);
    if(n instanceof ExportNode) return visit((ExportNode) n);
    if(n instanceof AssignNode) return visit((AssignNode) n);
    if(n instanceof PrimitiveDeclarationNode) return visit((PrimitiveDeclarationNode) n);
    if(n instanceof MapDeclarationNode) return visit((MapDeclarationNode) n);
    if(n instanceof MapQueryNode) return visit((MapQueryNode) n);
    if(n instanceof MapPropsAssignNode) return visit((MapPropsAssignNode) n);
    if(n instanceof CoordinatesNode) return visit((CoordinatesNode) n);
    if(n instanceof FunctionDefNode) return visit((FunctionDefNode) n);
    if(n instanceof FunctionParamNode) return visit((FunctionParamNode) n);
    if(n instanceof IfNode) return visit((IfNode) n);
    if(n instanceof WhileNode) return visit((WhileNode) n);
    if(n instanceof FunctionBodyNode) return visit((FunctionBodyNode) n);
    if(n instanceof BlockNode) return visit((BlockNode) n);
    if(n instanceof IExpressionNode) return visit((IExpressionNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(ProgramNode n) {
    SymbolTable.push();
    visitChildren(n);
    SymbolTable.pop();
    return null;
  }

  public Void visit(ImportNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    FileManager.parseFile(n.getPath(), true, false, false);
    AbstractNode vars = n.getVars();
    while(vars != null) {
      String varName = ((IdentifierNode) vars).getValue();
      MapSymbol symbol = SymbolTable.getExport(varName);
      if (symbol == null) throw new Error("Imported map " + varName + " does not exist");
      st.enterSymbol(varName, Types.MAP).init = true;
      vars = vars.rightSib;
    }
    return null;
  }

  public Void visit(ExportNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    AbstractNode vars = n.getVars();
    while(vars != null) {
      String varName = ((IdentifierNode) vars).getValue();
      Symbol symbol = st.getSymbol(varName);
      if(!symbol.type.equals(Types.MAP)) throw new Error("Can't export non-map variable " + varName);
      SymbolTable.addExport((MapSymbol) symbol);
      vars = vars.rightSib;
    }
    return null;
  }

  public Void visit(AssignNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    Symbol symbol = st.getSymbol(n.getIdentifier());
    String expType = new TypeVisitor().visit(n.getExpression());
    symbol.init = true;
    n.type = symbol.type;
    if (!symbol.type.equals(expType)) throw new Error("Mismatched type in assignment for variable " + n.getIdentifier() + ". Expected " + symbol.type + ", found " + expType + " instead.");
    return null;
  }

  public Void visit(MapDeclarationNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    TypeVisitor typeVisitor = new TypeVisitor();
    String xType = typeVisitor.visit(n.getSizeX());
    String yType = typeVisitor.visit(n.getSizeY());
    if(!xType.equals(Types.INT) || !yType.equals(Types.INT)) throw new Error("Invalid size type for map: " + n.getIdentifier());
    st.enterSymbol(n.getIdentifier(), Types.MAP).init = true;
    return null;
  }

  public Void visit(FunctionBodyNode n) {
    visitChildren(n);
    return null;
  }

  public Void visit(PrimitiveDeclarationNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    String type = n.getType();
    AbstractNode declaration = n.getDeclarations();
    while(declaration != null) {
      if(declaration instanceof IdentifierNode) st.enterSymbol(((IdentifierNode) declaration).getValue(), type);
      if(declaration instanceof AssignNode) {
        st.enterSymbol(((AssignNode) declaration).getIdentifier(), type);
        visit(declaration);
      }
      declaration = declaration.rightSib;
    }
    return null;
  }

  public Void visit(CoordinatesNode n) {
    TypeVisitor typeVisitor = new TypeVisitor();
    String xType = typeVisitor.visit(n.getX());
    String yType = typeVisitor.visit(n.getY());
    if(!xType.equals(Types.INT) || !yType.equals(Types.INT)) throw new Error("Invalid type for coordinate node.");
    return null;
  }

  public Void visit(MapQueryNode n) {
    new TypeVisitor().visitChildren(n.getCoordinates());
    return null;
  }

  public Void visit(MapPropsAssignNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    if(!st.getSymbol(n.getName()).type.equals(Types.MAP)) throw new Error("Assigning map props to non-map variable " + n.getName() + ". Found ");
    visit(n.getQuery());
    return null;
  }

  public Void visit(FunctionDefNode n) {
    SymbolTableInstance outerSt = SymbolTable.peek();
    outerSt.enterSymbol(n.getName(), Types.FUNCTION);
    TypeVisitor typeVisitor = new TypeVisitor();
    ArrayList<String> paramTypes = new ArrayList<>(Arrays.asList(typeVisitor.visit(n.getParams()).split(", ")));
    outerSt.setSymbolValue(
      n.getName(),
      new FunctionAttr(n.getType(), paramTypes)
    );
    SymbolTable.push();
    visit(n.getParams());
    visit(n.getBody());
    String returnType = typeVisitor.visit(n.getReturnExp());
    if(!returnType.equals(n.getType())) throw new Error("Function " + n.getName() + " return expression does not match return type: " + n.getType() + ". Expression type is " + returnType);
    SymbolTable.pop();
    return null;
  }

  public Void visit(FunctionParamNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    st.enterSymbol(n.getName(), n.getType()).init = true;
    return null;
  }

  public Void visit(IfNode n) {
    String predicateType = new TypeVisitor().visit(n.getPredicate());
    if(!predicateType.equals(Types.BOOL)) throw new Error("Predicate in if statement is not of type boolean. Found " + predicateType + " instead.");
    visit(n.getThenBlock());
    visit(n.getElseBlock());
    return null;
  }

  public Void visit(WhileNode n) {
    String predicateType = new TypeVisitor().visit(n.getPredicate());
    if(!predicateType.equals(Types.BOOL)) throw new Error("Predicate in if statement is not of type boolean. Found " + predicateType + " instead.");
    visit(n.getBlock());
    return null;
  }

  public Void visit(BlockNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    st.openScope();
    visitChildren(n);
    st.closeScope();
    return null;
  }

  public Void visit(IExpressionNode n) {
    new TypeVisitor().visit((AbstractNode) n);
    return null;
  }

  public Void visit(FunctionCallNode n) {
    new TypeVisitor().visit(n);
    return null;
  }

  public Void visit(IdentifierNode n) {
    new TypeVisitor().visit(n);
    return null;
  }
}
