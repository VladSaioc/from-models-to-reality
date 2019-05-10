package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionBodyNode extends AbstractNode {
  private AbstractNode statements;
  private AbstractNode returnStatement;

  public FunctionBodyNode(AbstractNode statements, AbstractNode returnStatement) {
    this.statements = statements;
    this.returnStatement = returnStatement;
    this.adoptChildren(statements)
    .adoptChildren(returnStatement);
  }

  public AbstractNode getStatements() {
    return this.statements;
  }

  public AbstractNode getReturnStatement() {
    return this.returnStatement;
  }  
}