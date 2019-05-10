package Nodes.MapNodes;

import Nodes.AbstractNode;

public class CoordinatesNode extends AbstractNode {
  private AbstractNode x;
  private AbstractNode y;

  public CoordinatesNode(AbstractNode x, AbstractNode y) {
    this.x = x;
    this.y = y;
    this.adoptChildren(x)
    .adoptChildren(y);
  }

  public AbstractNode getX() {
    return this.x;
  }

  public AbstractNode getY() {
    return this.y;
  }
}