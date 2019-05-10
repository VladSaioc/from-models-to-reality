package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ArithmeticSubNode extends BinaryExpressionNode {
  public ArithmeticSubNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}