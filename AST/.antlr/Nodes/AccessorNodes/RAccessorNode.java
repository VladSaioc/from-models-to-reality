package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class RAccessorNode extends AbstractNode {
  private AbstractNode functionCall;
  private AbstractNode indexes;
  private AbstractNode prop;

  public RAccessorNode(AbstractNode functionCall, AbstractNode indexes, AbstractNode prop) {
    this.functionCall = functionCall;
    this.indexes = indexes;
    this.prop = prop;
    this.adoptChildren(functionCall)
    .adoptChildren(indexes)
    .adoptChildren(prop);
  }

  public AbstractNode getFunctionCall() {
    return this.functionCall;
  }

  public AbstractNode getProp() {
    return this.prop;
  }

  public AbstractNode getIndexes() {
    return this.indexes;
  }
}