package Nodes.ExpressionNodes;

import Nodes.AbstractNode;

public class UnaryExpressionNode extends AbstractNode {
  protected AbstractNode inner;

  public UnaryExpressionNode() {
    super();
  }

  public UnaryExpressionNode(AbstractNode inner) {
    super();
    this.inner = inner;
    this.adoptChildren(this.inner);
  }

  public AbstractNode getInner() {
    return this.inner;
  }
}