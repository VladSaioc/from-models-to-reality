package Nodes.ControlStatements;

import Nodes.AbstractNode;

public class IfNode extends ControlStatementNode {
  private AbstractNode thenBlock;
  private AbstractNode elseBlock;

  public IfNode(AbstractNode predicate, AbstractNode thenBlock, AbstractNode elseBlock) {
    super(predicate);
    this.thenBlock = thenBlock;
    this.elseBlock = elseBlock;
    this.adoptChildren(thenBlock);
    this.adoptChildren(elseBlock);
  }

  public AbstractNode getThenBlock() {
    return this.thenBlock;
  }

  public AbstractNode getElseBlock() {
    return this.elseBlock;
  }
}