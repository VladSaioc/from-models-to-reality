package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ArithmeticAddNode extends BinaryExpressionNode implements ArithmeticNode {
  public ArithmeticAddNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}