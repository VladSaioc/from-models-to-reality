package Nodes.BooleanNodes;

public class BooleanLiteralNode extends BooleanNode {
  private boolean value;

  public BooleanLiteralNode(Boolean value) {
    this.value = value;
  }

  public Boolean getValue() {
    return this.value;
  }

  public BooleanLiteralNode setValue(boolean value) {
    this.value = value;
    return this;
  }
}