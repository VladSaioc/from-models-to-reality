package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ArithmeticMultNode extends BinaryExpressionNode implements IArithmeticNode, IArithmeticBinaryExpressionNode {
  public ArithmeticMultNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}