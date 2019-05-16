package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionReturnNode extends AbstractNode {
  private AbstractNode expression;

  public FunctionReturnNode(AbstractNode expression) {
    super();
    this.expression = expression;
    this.adoptChildren(expression);
  }

  public AbstractNode getExpression() {
    return this.expression;
  }
}