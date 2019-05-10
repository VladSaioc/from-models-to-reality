package Nodes.BooleanNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class BooleanAndNode extends BinaryExpressionNode {
  public BooleanAndNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}