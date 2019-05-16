package Nodes.BooleanNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.UnaryExpressionNode;

public class BooleanNegateNode extends UnaryExpressionNode implements BooleanNode {
  public BooleanNegateNode(AbstractNode inner) {
    super(inner);
  }
}