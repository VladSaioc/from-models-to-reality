package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapQueryPredicateNode extends AbstractNode {
  private AbstractNode boolPredicate;
  private AbstractNode coordinates;

  public MapQueryPredicateNode(AbstractNode boolPredicate, AbstractNode coordinates) {
    this.boolPredicate = boolPredicate;
    this.coordinates = coordinates;
    this.adoptChildrenToLeft(boolPredicate)
    .adoptChildren(coordinates);
  }

  public AbstractNode getCoordinates() {
    return this.coordinates;
  }

  public AbstractNode getBoolPredicate() {
    return this.boolPredicate;
  }
}