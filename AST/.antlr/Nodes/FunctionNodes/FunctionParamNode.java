package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionParamNode extends AbstractNode {
  private String type;
  private String name;

  public FunctionParamNode(String name, String type) {
    super();
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }
}