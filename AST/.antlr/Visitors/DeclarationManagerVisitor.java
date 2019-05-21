package Visitors;

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
import Nodes.FunctionNodes.FunctionParamsNode;
import Nodes.MapNodes.CoordinatesNode;
import Nodes.MapNodes.MapDeclarationNode;
import Nodes.MapNodes.MapPropsAssignNode;
import Nodes.MapNodes.MapQueryNode;
import Nodes.PrimitiveDeclarationNode;
import Nodes.ProgramNode;
import SymbolTable.Attr.FunctionAttr;
import SymbolTable.SymbolTable;
import SymbolTable.Symbols.PrimitiveSymbol;
import SymbolTable.Symbols.Symbol;

import java.util.ArrayList;
import java.util.Arrays;

public class DeclarationManagerVisitor extends BaseVisitor<Void> {
  public Void dispatch(AbstractNode n) {
    if(n instanceof ProgramNode) return visit((ProgramNode) n);
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
    SymbolTable.openScope();
    visitChildren(n);
    SymbolTable.closeScope();
    return null;
  }

  public Void visit(AssignNode n) {
    Symbol symbol = SymbolTable.getSymbol(n.getIdentifier());
    String expType = new TypeVisitor().visit(n.getExpression());
    symbol.init = true;
    if (symbol.type.equals(expType)) return null;
    throw new Error("Mismatched type in assignment for variable " + n.getIdentifier() + ". Expected " + symbol.type + ", found " + expType + " instead.");
  }

  public Void visit(MapDeclarationNode n) {
    TypeVisitor typeVisitor = new TypeVisitor();
    String xType = typeVisitor.visit(n.getSizeX());
    String yType = typeVisitor.visit(n.getSizeY());
    if(!xType.equals(Types.INT) || !yType.equals(Types.INT)) throw new Error("Invalid size type for map: " + n.getIdentifier());
    SymbolTable.enterMapSymbol(n.getIdentifier());
    return null;
  }

  public Void visit(FunctionBodyNode n) {
    visitChildren(n);
    return null;
  }

  public Void visit(PrimitiveDeclarationNode n) {
    String type = n.getType();
    AbstractNode declaration = n.getDeclarations();
    while(declaration != null) {
      if(declaration instanceof IdentifierNode) SymbolTable.enterSymbol(((IdentifierNode) declaration).getValue(), type);
      if(declaration instanceof AssignNode) {
        SymbolTable.enterSymbol(((AssignNode) declaration).getIdentifier(), type);
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
    if(!xType.equals(Types.INT) || !yType.equals(Types.INT)) throw new Error("Invalid type for coordinate node: ");
    return null;
  }

  public Void visit(MapQueryNode n) {
    new TypeVisitor().visitChildren(n.getCoordinates());
    return null;
  }

  public Void visit(MapPropsAssignNode n) {
    if(!SymbolTable.getSymbol(n.getName()).type.equals(Types.MAP)) throw new Error("Assigning map props to non-map variable " + n.getName() + ". Found ");
    visit(n.getQuery());
    return null;
  }

  public Void visit(FunctionDefNode n) {
    SymbolTable.enterFunctionSymbol(n.getName());
    TypeVisitor typeVisitor = new TypeVisitor();
    ArrayList<String> paramTypes = new ArrayList<>(Arrays.asList(typeVisitor.visit(n.getParams()).split(", ")));;
    SymbolTable.setSymbolAttr(
      n.getName(),
      new FunctionAttr(n.getType(), paramTypes)
    );
    SymbolTable.openScope();
    visit(n.getParams());
    visit(n.getBody());
    String returnType = typeVisitor.visit(n.getReturnExp());
    if(!returnType.equals(n.getType())) throw new Error("Function " + n.getName() + " return expression does not match return type: " + n.getType() + ". Expression type is " + returnType);
    SymbolTable.closeScope();
    return null;
  }

  public Void visit(FunctionParamNode n) {
    SymbolTable.enterSymbol(n.getName(), n.getType()).init = true;
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
    SymbolTable.openScope();
    visitChildren(n);
    SymbolTable.closeScope();
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
