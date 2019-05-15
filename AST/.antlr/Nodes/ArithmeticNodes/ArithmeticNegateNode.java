package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.UnaryExpressionNode;

public class ArithmeticNegateNode extends UnaryExpressionNode {
  public ArithmeticNegateNode(AbstractNode inner) {
    super(inner);
  }
}