package Nodes.ExpressionNodes;

import Nodes.AbstractNode;

public class UnaryExpressionNode extends AbstractNode {
  protected AbstractNode inner;

  public UnaryExpressionNode() {}

  public UnaryExpressionNode(AbstractNode inner) {
    this.inner = inner;
    this.adoptChildren(this.inner);
  }
}