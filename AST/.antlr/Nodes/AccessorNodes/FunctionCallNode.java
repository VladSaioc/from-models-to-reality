package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class FunctionCallNode extends AbstractNode {
  private AbstractNode params = null;
  private AbstractNode identifier = null;

  public FunctionCallNode(AbstractNode identifier, AbstractNode params) {
    this.identifier = identifier;
    this.params = params;
    this.adoptChildren(identifier)
    .adoptChildren(params);
  }

  public AbstractNode getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getParams() {
    return this.params;
  }
}