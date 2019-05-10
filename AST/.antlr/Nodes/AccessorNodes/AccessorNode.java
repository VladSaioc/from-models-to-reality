package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public abstract class AccessorNode<T> extends AbstractNode {
  private T value;

  public AccessorNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }
}