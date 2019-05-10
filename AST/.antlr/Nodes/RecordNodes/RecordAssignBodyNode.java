package Nodes.RecordNodes;

import Nodes.AbstractNode;

public class RecordAssignBodyNode extends AbstractNode {
  private AbstractNode statements;

  public RecordAssignBodyNode(AbstractNode statements) {
    this.statements = statements;
    this.adoptChildren(statements);
  }

  public AbstractNode getStatements() {
    return this.statements;
  }
}