package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class FunctionCallNode extends AbstractNode {
  private AbstractNode params = null;
  private String name;

  public FunctionCallNode(String name, AbstractNode params) {
    this.name = name;
    this.params = params;
    this.adoptChildren(params);
  }

  public String getName() {
    return this.name;
  }

  public AbstractNode getParams() {
    return this.params;
  }
}