package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class IdentifierNode extends AbstractNode {
  private String value;

  public IdentifierNode(String value) {
    super();
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}