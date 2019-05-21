package Nodes.BooleanNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.UnaryExpressionNode;

public class BooleanNegateNode extends UnaryExpressionNode implements IBooleanNode {
  public BooleanNegateNode(AbstractNode inner) {
    super(inner);
  }
}