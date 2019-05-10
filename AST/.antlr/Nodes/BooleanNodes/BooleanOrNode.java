package Nodes.BooleanNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class BooleanOrNode extends BinaryExpressionNode {
  public BooleanOrNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}