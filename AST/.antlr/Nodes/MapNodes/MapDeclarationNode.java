package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapDeclarationNode extends AbstractNode {
  private AbstractNode sizeX;
  private AbstractNode sizeY;
  private AbstractNode identifier;
  private AbstractNode record = null;

  public MapDeclarationNode(AbstractNode sizeX, AbstractNode sizeY, AbstractNode identifier, AbstractNode record) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.identifier = identifier;
    this.record = record;
    this.adoptChildren(sizeX)
    .adoptChildren(sizeY)
    .adoptChildren(identifier)
    .adoptChildren(record);
  }

  public AbstractNode getSizeX() {
    return this.sizeX;
  }

  public AbstractNode getSizeY() {
    return this.sizeY;
  }

  public AbstractNode getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getRecord() {
    return this.record;
  }
}