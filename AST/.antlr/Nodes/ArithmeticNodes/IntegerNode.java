package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;

public class IntegerNode extends AbstractNode {
  private int value;

  public IntegerNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}