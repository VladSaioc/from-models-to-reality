package Nodes.ControlStatements;

import Nodes.AbstractNode;

public class ControlStatementNode extends AbstractNode {
  private AbstractNode predicate;

  public ControlStatementNode(AbstractNode predicate) {
    this.predicate = predicate;
    this.adoptChildren(predicate);
  }

  public AbstractNode getPredicate() {
    return this.predicate;
  }
}