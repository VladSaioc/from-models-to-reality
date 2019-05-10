package Nodes.AssignNodes;

import Nodes.AbstractNode;

public class AssignNode extends AbstractNode {
  private AbstractNode identifier;
  private AbstractNode expression;

  public AssignNode(AbstractNode identifier, AbstractNode expression) {
    this.identifier = identifier;
    this.expression = expression;
    this.adoptChildren(identifier)
    .adoptChildren(expression);
  }

  public AbstractNode getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getExpression() {
    return this.expression;
  }
}