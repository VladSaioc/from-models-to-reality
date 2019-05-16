package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;

public class IntegerNode extends AbstractNode implements IArithmeticNode {
  private int value;

  public IntegerNode(int value) {
    super();
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}