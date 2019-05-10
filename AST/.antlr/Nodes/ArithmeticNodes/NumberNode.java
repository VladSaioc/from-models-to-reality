package Nodes.ArithmeticNodes;

import Nodes.AbstractNode;

public class NumberNode<T> extends AbstractNode {
  private T value;

  public NumberNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public AbstractNode setValue(T value) {
    this.value = value;
    return this;
  }
}