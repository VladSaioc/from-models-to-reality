package Nodes.ExpressionNodes;

import Nodes.AbstractNode;

public class UnaryExpressionNode extends AbstractNode {
  private AbstractNode operations;
  private AbstractNode inner;

  public UnaryExpressionNode() {}

  public UnaryExpressionNode(AbstractNode inner) {
    this.inner = inner;
    this.adoptChildren(this.inner);
  }

  public AbstractNode addOperation(AbstractNode operation) {
    if(this.operations == null) {
      this.operations = operation;
    }
    return this.adoptChildren(operation);
  }

}