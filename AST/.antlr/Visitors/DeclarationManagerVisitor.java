package Visitors;

import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.AssignNodes.AssignNode;
import Nodes.BlockStatements.BlockNode;
import Nodes.ControlStatements.IfNode;
import Nodes.ControlStatements.WhileNode;
import Nodes.FunctionNodes.FunctionDefNode;
import Nodes.FunctionNodes.FunctionParamNode;
import Nodes.MapNodes.CoordinatesNode;
import Nodes.MapNodes.MapDeclarationNode;
import Nodes.MapNodes.MapPropsAssignNode;
import Nodes.MapNodes.MapQueryNode;
import Nodes.PrimitiveDeclarationNode;
import SymbolTable.SymbolTable;

public class DeclarationManagerVisitor extends BaseVisitor<Void> {
  public Void dispatch(AbstractNode n) {
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
    if(n instanceof BlockNode) return visit((BlockNode) n);
    return null;
  }

  public Void visit(AssignNode n) {
    String symType = SymbolTable.retrieveSymbol(n.getIdentifier()).getType();
    String expType = new TypeVisitor().visit(n.getExpression());
    if (symType.equals(expType)) return null;
    throw new Error("Mismatched type in assignment for variable: " + n.getIdentifier());
  }

  public Void visit(MapDeclarationNode n) {
    TypeVisitor typeVisitor = new TypeVisitor();
    String xType = typeVisitor.visit(n.getSizeX());
    String yType = typeVisitor.visit(n.getSizeY());
    if(!xType.equals(Types.INT) || !yType.equals(Types.INT)) throw new Error("Invalid size type for map: " + n.getIdentifier());
    SymbolTable.enterSymbol(n.getIdentifier(), Types.MAP);
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
    TypeVisitor typeVisitor = new TypeVisitor();
    typeVisitor.visitChildren(n.getCoordinates());
    return null;
  }

  public Void visit(MapPropsAssignNode n) {
    if(!SymbolTable.retrieveSymbol(n.getName()).getType().equals(Types.MAP)) throw new Error("Assigning map props to non-map variable " + n.getName());
    visit(n.getQuery());
    return null;
  }

  public Void visit(FunctionDefNode n) {
    SymbolTable.enterSymbol(n.getName(), n.getType());
    SymbolTable.openScope();
    TypeVisitor typeVisitor = new TypeVisitor();
    visitTypedSiblings(n.getParams());
    visit(n.getBody());
    String returnType = typeVisitor.visit(n.getReturnExp());
    if(!returnType.equals(n.getType())) throw new Error("Function " + n.getName() + " return expression does not match return type: " + n.getType() + ". Expression type is " + returnType);
    SymbolTable.closeScope();
    return null;
  }

  public Void visit(FunctionParamNode n) {
    SymbolTable.enterSymbol(n.getName(), n.getType());
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

  public Void
}
