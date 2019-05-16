package Visitors;

import Nodes.AbstractNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.AssignNodes.AssignNode;
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
    if(!xType.equals("int") || !yType.equals("int")) throw new Error("Invalid size type for map: " + n.getIdentifier());
    SymbolTable.enterSymbol(n.getIdentifier(), "map");
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
    if(!xType.equals("int") || !yType.equals("int")) throw new Error("Invalid type for coordinate node: ");
    return null;
  }

  public Void visit(MapQueryNode n) {
    TypeVisitor typeVisitor = new TypeVisitor();
    AbstractNode coords = n.getCoordinates();
    while (coords != null) {
      typeVisitor.visit(coords);
      coords = coords.rightSib;
    }
    return null;
  }

  public Void visit(MapPropsAssignNode n) {
    if(!SymbolTable.retrieveSymbol(n.getName()).getType().equals("map")) throw new Error("Assigning map props to non-map variable " + n.getName());
    visit(n.getQuery());
    return null;
  }

  public Void visit(FunctionDefNode n) {
    SymbolTable.enterSymbol(n.getName(), n.getType());
    String returnType = new TypeVisitor().visit(n.getReturnExp());
    if(!returnType.equals(n.getType())) throw new Error("Function " + n.getName() + " return expression does not match return type");
    visitTypedSiblings(n.getParams());
    visit(n.getBody());
    return null;
  }

  public Void visit(FunctionParamNode n) {
    SymbolTable.enterSymbol(n.getName(), n.getType());
    return null;
  }

  public Void visit() {

  }
}
