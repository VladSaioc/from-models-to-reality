package Nodes.BooleanNodes;

import Nodes.AbstractNode;

public class BooleanLiteralNode extends AbstractNode implements BooleanNode {
  private boolean value;

  public BooleanLiteralNode(Boolean value) {
    super();
    this.value = value;
  }

  public Boolean getValue() {
    return this.value;
  }
}