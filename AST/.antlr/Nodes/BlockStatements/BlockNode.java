package Nodes.BlockStatements;

import Nodes.AbstractNode;

public class BlockNode extends AbstractNode {
  private AbstractNode statements;

  public BlockNode(AbstractNode statements) {
    this.statements = statements;
    this.adoptChildren(statements);
  }

  public AbstractNode getStatements() {
    return this.statements;
  }
}