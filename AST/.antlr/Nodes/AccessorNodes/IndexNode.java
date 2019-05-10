package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class IndexNode extends AccessorNode<AbstractNode> {
  public IndexNode(AbstractNode value) {
    super(value);
    this.adoptChildren(value);
  }
}