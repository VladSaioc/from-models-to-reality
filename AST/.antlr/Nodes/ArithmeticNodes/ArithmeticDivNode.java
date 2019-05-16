package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ArithmeticDivNode extends BinaryExpressionNode implements IArithmeticNode, IArithmeticBinaryExpressionNode {
  public ArithmeticDivNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}