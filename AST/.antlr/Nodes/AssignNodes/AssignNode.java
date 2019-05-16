package Nodes.AssignNodes;

import Nodes.AbstractNode;

public class AssignNode extends AbstractNode {
  private String identifier;
  private AbstractNode expression;

  public AssignNode(String identifier, AbstractNode expression) {
    super();
    this.identifier = identifier;
    this.expression = expression;
    this.adoptChildren(expression);
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getExpression() {
    return this.expression;
  }
}