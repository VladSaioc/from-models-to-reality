package Nodes.MapNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class MapJoinNode extends BinaryExpressionNode {
  private AbstractNode displacement = null;
  public MapJoinNode(AbstractNode left, AbstractNode right, AbstractNode displacement) {
    super(left, right);
    this.displacement = displacement;
    this.adoptChildren(displacement);
  }

  public AbstractNode getDisplacement() {
    return this.displacement;
  }
}