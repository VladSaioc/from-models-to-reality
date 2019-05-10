package Nodes.TypeNodes;

import Nodes.AbstractNode;

public class TypeNode extends AbstractNode {
  private String typeName;

  public TypeNode(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeName() {
    return this.typeName;
  }
}