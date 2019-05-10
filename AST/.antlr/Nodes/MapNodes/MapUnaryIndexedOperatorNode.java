package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapUnaryIndexedOperatorNode extends MapUnaryOperatorNode {
  private AbstractNode index = null;

  public MapUnaryIndexedOperatorNode(AbstractNode index) {
    this.index = index;
    this.adoptChildren(index);
  }

  public AbstractNode getIndex() {
    return this.index;
  }
}