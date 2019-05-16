package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionBodyNode extends AbstractNode {
  private AbstractNode statements;
  private AbstractNode returnStatement;

  public FunctionBodyNode(AbstractNode statements) {
    super();
    this.statements = statements;
    this.adoptChildren(statements)
    .adoptChildren(returnStatement);
  }

  public AbstractNode getStatements() {
    return this.statements;
  }
}