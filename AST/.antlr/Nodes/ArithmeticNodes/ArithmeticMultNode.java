package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ArithmeticMultNode extends BinaryExpressionNode {
  public ArithmeticMultNode() {}
  public ArithmeticMultNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}