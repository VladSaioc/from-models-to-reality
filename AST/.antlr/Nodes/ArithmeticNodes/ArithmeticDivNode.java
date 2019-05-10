package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ArithmeticDivNode extends BinaryExpressionNode {
  public ArithmeticDivNode() {}
  public ArithmeticDivNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}