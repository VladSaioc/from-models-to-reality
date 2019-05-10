package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionHeaderNode extends AbstractNode {
  private AbstractNode params;

  public FunctionHeaderNode(AbstractNode params) {
    this.params = params;
    this.adoptChildren(params);
  }

  public AbstractNode getParams() {
    return this.params;
  }
}