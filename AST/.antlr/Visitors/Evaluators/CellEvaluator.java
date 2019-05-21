package Visitors.Evaluators;

import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.AssignNodes.AssignNode;
import Nodes.MapNodes.MapPropsAssignBodyNode;
import Nodes.PrimitiveDeclarationNode;
import SymbolTable.Attr.CellAttr;
import Visitors.BaseVisitor;

public class CellEvaluator extends BaseVisitor<CellAttr> {
  public CellAttr dispatch(AbstractNode n) {
    if(n instanceof MapPropsAssignBodyNode) return visit((MapPropsAssignBodyNode) n);
    if(n instanceof PrimitiveDeclarationNode) return visit((PrimitiveDeclarationNode) n);
    visitChildren(n);
    return null;
  }

  public CellAttr visit(MapPropsAssignBodyNode n) {
    CellAttr cell = new CellAttr();
    AbstractNode props = n.getProps();
    while(props != null) {
      cell.mergeProps(visit(props));
      props = props.rightSib;
    }
    return cell;
  }

  public CellAttr visit(PrimitiveDeclarationNode n) {
    CellAttr cell = new CellAttr();
    ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
    BooleanEvaluator booleanEvaluator = new BooleanEvaluator();
    StringEvaluator stringEvaluator = new StringEvaluator();
    String type = n.getType();
    AbstractNode declaration = n.getDeclarations();
    while(declaration != null) {
      if(declaration instanceof IdentifierNode) {
        if(type.equals(Types.INT)) cell.addProp(((IdentifierNode) declaration).getValue(), 0);
        if(type.equals(Types.STRING)) cell.addProp(((IdentifierNode) declaration).getValue(), "");
        if(type.equals(Types.BOOL)) cell.addProp(((IdentifierNode) declaration).getValue(), false);
      }
      if(declaration instanceof AssignNode) {
        if(type.equals(Types.INT)) cell.addProp(
            ((AssignNode) declaration).getIdentifier(),
            arithmeticEvaluator.visit(((AssignNode) declaration).getExpression())
          );
        if(type.equals(Types.STRING)) cell.addProp(
            ((AssignNode) declaration).getIdentifier(),
            stringEvaluator.visit(((AssignNode) declaration).getExpression())
          );
        if(type.equals(Types.BOOL)) cell.addProp(
            ((AssignNode) declaration).getIdentifier(),
            booleanEvaluator.visit(((AssignNode) declaration).getExpression())
          );
      }
      declaration = declaration.rightSib;
    }
    return cell;
  }
}
