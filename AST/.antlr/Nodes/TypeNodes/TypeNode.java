package Nodes.TypeNodes;

import Nodes.AbstractNode;

public class TypeNode extends AbstractNode {
  private String name;

  public TypeNode(String name) {
    this.name = name;
  }

  public String getType() {
    return this.name;
  }
}