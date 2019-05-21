package Nodes.StringNodes;

import Nodes.AbstractNode;

public class StringLiteralNode extends AbstractNode implements IStringNode {
  private String value;

  public StringLiteralNode(String value) {
    super();
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public StringLiteralNode setValue(String value) {
    this.value = value;
    return this;
  }
}