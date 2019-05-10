package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionParamNode extends AbstractNode {
  private AbstractNode type;
  private String name;

  public FunctionParamNode(String name, AbstractNode type) {
    this.name = name;
    this.type = type;
    this.adoptChildren(type);
  }

  public String getName() {
    return this.name;
  }

  public AbstractNode getType() {
    return this.type;
  }
}