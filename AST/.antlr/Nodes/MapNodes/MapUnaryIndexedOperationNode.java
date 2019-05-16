package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapUnaryIndexedOperationNode extends MapUnaryOperationNode {
  private AbstractNode index;

  public MapUnaryIndexedOperationNode(AbstractNode index) {
    super();
    this.adoptChildren(index);
  }

  public AbstractNode getIndex() {
    return this.index;
  }
}