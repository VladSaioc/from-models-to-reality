package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ArithmeticModNode extends BinaryExpressionNode {
  public ArithmeticModNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}