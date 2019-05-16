package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapQueryNode extends AbstractNode {
  private AbstractNode coordinates;

  public MapQueryNode(AbstractNode coordinates) {
    super();
    this.coordinates = coordinates;
    this.adoptChildren(coordinates);
  }

  public AbstractNode getCoordinates() {
    return this.coordinates;
  }
}