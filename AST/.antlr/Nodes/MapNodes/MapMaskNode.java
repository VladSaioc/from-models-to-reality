package Nodes.MapNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;;

public class MapMaskNode extends BinaryExpressionNode implements IMapBinaryExpression {
  private AbstractNode x;
  private AbstractNode y;

  public MapMaskNode(AbstractNode left, AbstractNode right, AbstractNode cornerX, AbstractNode cornerY) {
    super(left, right);
    this.x = cornerX;
    this.y = cornerY;
    this.adoptChildren(x)
    .adoptChildren(y);
  }

  public AbstractNode getX() {
    return this.x;
  }

  public AbstractNode getY() {
    return this.y;
  }
}