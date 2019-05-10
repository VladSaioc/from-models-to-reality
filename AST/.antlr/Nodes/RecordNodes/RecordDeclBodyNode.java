package Nodes.RecordNodes;

import Nodes.AbstractNode;

public class RecordDeclBodyNode extends AbstractNode {
  private AbstractNode vars;

  public RecordDeclBodyNode(AbstractNode vars) {
    this.vars = vars;
    this.adoptChildren(vars);
  }

  public AbstractNode getVars() {
    return this.vars;
  }
}