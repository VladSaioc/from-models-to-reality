package Visitors.Evaluators;

import Helpers.FileManager;
import Helpers.Types;
import Nodes.*;
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
import Nodes.FunctionNodes.FunctionParamsNode;
import Nodes.ImpexNodes.ExportNode;
import Nodes.ImpexNodes.ImportNode;
import Nodes.MapNodes.IMapExpressionNode;
import Nodes.MapNodes.MapDeclarationNode;
import Nodes.MapNodes.MapPropsAssignNode;
import Nodes.StringNodes.IStringNode;
import SymbolTable.SymbolTableInstance;
import SymbolTable.Attr.CellAttr;
import SymbolTable.Attr.Coords;
import SymbolTable.Attr.FunctionAttr;
import SymbolTable.Attr.MapAttr;
import SymbolTable.SymbolTable;
import SymbolTable.Symbols.*;
import Visitors.BaseVisitor;

import java.util.ArrayList;
import java.util.HashMap;

public class Evaluator extends BaseVisitor<Void> {
  public Void dispatch(AbstractNode n) {
    if(n instanceof AssignNode) return visit((AssignNode) n);
    if(n instanceof MapPropsAssignNode) return visit((MapPropsAssignNode) n);
    if(n instanceof ProgramNode) return visit((ProgramNode) n);
    if(n instanceof ImportNode) return visit((ImportNode) n);
    if(n instanceof ExportNode) return visit((ExportNode) n);
    if(n instanceof IArithmeticNode) return visit((IArithmeticNode) n);
    if(n instanceof IBooleanNode) return visit((IBooleanNode) n);
    if(n instanceof IStringNode) return visit((IStringNode) n);
    if(n instanceof IComparisonNode) return visit((IComparisonNode) n);
    if(n instanceof IMapExpressionNode) return visit((IMapExpressionNode) n);
    if(n instanceof FunctionBodyNode) return visit((FunctionBodyNode) n);
    if(n instanceof BlockNode) return visit((BlockNode) n);
    if(n instanceof PrimitiveDeclarationNode) return visit((PrimitiveDeclarationNode) n);
    if(n instanceof MapDeclarationNode) return visit((MapDeclarationNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof FunctionDefNode) return visit((FunctionDefNode) n);
    if(n instanceof IfNode) return visit((IfNode) n);
    if(n instanceof WhileNode) return visit((WhileNode) n);
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
    FileManager.parseFile(n.getPath(), false, true);
    AbstractNode vars = n.getVars();
    while(vars != null) {
      String varName = ((IdentifierNode) vars).getValue();
      MapSymbol symbol = SymbolTable.getExport(varName);
      if (symbol == null) throw new Error("Imported map " + varName + " does not exist");
      st.enterSymbol(varName, Types.MAP);
      st.setSymbolValue(varName, new MapAttr(symbol.value)).init = true;
      vars = vars.rightSib;
    }
    return null;
  }

  public Void visit(ExportNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    AbstractNode vars = n.getVars();
    while(vars != null) {
      String varName = ((IdentifierNode) vars).getValue();
      SymbolTable.addExport((MapSymbol) st.getSymbol(varName));
      vars = vars.rightSib;
    }
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

  public Void visit(MapDeclarationNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
    Integer sizeX = arithmeticEvaluator.visit(n.getSizeX());
    Integer sizeY = arithmeticEvaluator.visit(n.getSizeY());
    HashMap<String, CellAttr> cells = new HashMap<>();
    CellAttr cellAttr = new CellEvaluator().visit(n.getRecord());
    if(cellAttr == null) cellAttr = new CellAttr();
    for(int x = 0; x < sizeX; x++) {
      for(int y = 0; y < sizeY; y++) {
        cells.put(new Coords(x, y).getHash(), cellAttr);
      }
    }
    st.enterSymbol(n.getIdentifier(), Types.MAP).value = new MapAttr(
      arithmeticEvaluator.visit(n.getSizeX()),
      arithmeticEvaluator.visit(n.getSizeY()),
      cells
    );
    return null;
  }

  public Void visit(FunctionDefNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    st.enterSymbol(n.getName(), Types.FUNCTION);
    st.setSymbolValue(
      n.getName(),
      new FunctionAttr(
        n.getType(),
        ((FunctionParamsNode) n.getParams()).getParams(),
        n.getBody(),
        n.getReturnExp()
      )
    );
    return null;
  }

  public Void visit(FunctionBodyNode n) {
    visitChildren(n);
    return null;
  }

  public Void visit(BlockNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    st.openScope();
    visitChildren(n);
    st.closeScope();
    return null;
  }

  public Void visit(IfNode n) {
    Boolean predicate = new BooleanEvaluator().visit(n.getPredicate());
    if(predicate) visit(n.getThenBlock());
    else visit(n.getElseBlock());
    return null;
  }

  public Void visit(WhileNode n) {
    BooleanEvaluator booleanEvaluator = new BooleanEvaluator();
    Boolean predicate = booleanEvaluator.visit(n.getPredicate());
    while(predicate) {
      visit(n.getBlock());
      predicate = booleanEvaluator.visit(n.getPredicate());
    }
    return  null;
  }

  public Void visit(AssignNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    Symbol symbol = st.getSymbol(n.getIdentifier());
    if(symbol.type.equals(Types.STRING)) st.setSymbolValue(symbol.name, new StringEvaluator().visit(n.getExpression()));
    else if(symbol.type.equals(Types.BOOL)) st.setSymbolValue(symbol.name, new BooleanEvaluator().visit(n.getExpression()));
    else if(symbol.type.equals(Types.INT)) st.setSymbolValue(symbol.name, new ArithmeticEvaluator().visit(n.getExpression()));
    else if(symbol.type.equals(Types.MAP)) st.setSymbolValue(symbol.name, new MapEvaluator().visit(n.getExpression()));
    return null;
  }

  public Void visit(MapPropsAssignNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    ArrayList<Coords> coordinates = new CoordinatesEvaluator().visit(n.getQuery());
    CellAttr cellProps = new CellEvaluator().visit(n.getPropBody());
    MapAttr mapAttr = (MapAttr) st.getSymbol(n.getName()).value;
    if(coordinates == null) {
      for (int x = 0; x < mapAttr.getSizeX(); x++) {
        for(int y = 0; y < mapAttr.getSizeY(); y++) {
          mapAttr.setCell(x, y, cellProps);
        }
      }
    }
    else {
      coordinates.forEach(coord -> {
        mapAttr.setCell(coord, cellProps);
      });
    }
    st.getSymbol(n.getName()).value = mapAttr;
    return null;
  }

  public Void visit(IComparisonNode n) {
    ComparisonEvaluator comparisonEvaluator = new ComparisonEvaluator();
    System.out.println(comparisonEvaluator.visit((AbstractNode) n));
    return null;
  }

  public Void visit(IArithmeticNode n) {
    ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
    System.out.println(arithmeticEvaluator.visit((AbstractNode) n));
    return null;
  }

  public Void visit(IBooleanNode n) {
    BooleanEvaluator booleanEvaluator = new BooleanEvaluator();
    System.out.println(booleanEvaluator.visit((AbstractNode) n));
    return null;
  }

  public Void visit(IStringNode n) {
    StringEvaluator stringEvaluator = new StringEvaluator();
    System.out.println(stringEvaluator.visit((AbstractNode) n));
    return null;
  }

  public Void visit(IMapExpressionNode n) {
    MapEvaluator mapEvaluator = new MapEvaluator();
    mapEvaluator.visit((AbstractNode) n).print();
    return null;
  }

  public Void visit(IdentifierNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    Symbol symbol = st.getSymbol(n.getValue());
    if(symbol.type.equals(Types.BOOL)) System.out.println(new BooleanEvaluator().visit((AbstractNode) n));
    if(symbol.type.equals(Types.INT)) System.out.println(new ArithmeticEvaluator().visit((AbstractNode) n));
    if(symbol.type.equals(Types.STRING)) System.out.println(new StringEvaluator().visit((AbstractNode) n));
    if(symbol.type.equals(Types.FUNCTION)) System.out.println("function " + n.getValue());
    if(symbol.type.equals(Types.MAP)) new MapEvaluator().visit(n).print();
    return null;
  }

  public Void visit(FunctionCallNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    FunctionSymbol symbol = (FunctionSymbol) st.getSymbol(n.getName());
    if (symbol.value.getReturnType().equals(Types.BOOL)) {
      System.out.println(new BooleanEvaluator().visit(n));
    } else if(symbol.value.getReturnType().equals(Types.STRING)) {
      System.out.println(new StringEvaluator().visit(n));
    } else if(symbol.value.getReturnType().equals(Types.INT)) {
      System.out.println(new ArithmeticEvaluator().visit(n));
    }
    return null;
  }
}
