package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.UnaryExpressionNode;

public class ArithmeticNegateNode extends UnaryExpressionNode implements IArithmeticNode {
  public ArithmeticNegateNode(AbstractNode inner) {
    super(inner);
  }
}