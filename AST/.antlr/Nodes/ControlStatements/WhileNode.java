package Nodes.ControlStatements;

import Nodes.AbstractNode;

public class WhileNode extends ControlStatementNode {
  private AbstractNode block;

  public WhileNode(AbstractNode predicate, AbstractNode block) {
    super(predicate);
    this.block = block;
    this.adoptChildren(block);
  }

  public AbstractNode getBlock() {
    return this.block;
  }
}