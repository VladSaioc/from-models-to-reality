package Nodes.ArrayNodes;

import Nodes.AbstractNode;

public class ArrayLiteralNode extends AbstractNode {
  private AbstractNode members = null;

  public ArrayLiteralNode(AbstractNode members) {
    this.members = members;
    this.adoptChildren(members);
  }

  public AbstractNode getMembers() {
    return this.members;
  }
}