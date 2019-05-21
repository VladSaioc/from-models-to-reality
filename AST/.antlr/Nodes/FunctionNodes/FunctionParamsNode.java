package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionParamsNode extends AbstractNode {
  private AbstractNode params;

  public FunctionParamsNode(AbstractNode params) {
    this.params = params;
    this.adoptChildren(params);
  }

  public AbstractNode getParams() {
    return this.params;
  }
}
