package Nodes.MapNodes;

import Nodes.AbstractNode;

public class  MapDeclarationNode extends AbstractNode {
  private AbstractNode sizeX;
  private AbstractNode sizeY;
  private String identifier;
  private AbstractNode record = null;

  public MapDeclarationNode(String identifier, AbstractNode sizeX, AbstractNode sizeY, AbstractNode record) {
    super();
    this.identifier = identifier;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.record = record;
    this.adoptChildren(sizeX)
    .adoptChildren(sizeY)
    .adoptChildren(record);
  }

  public AbstractNode getSizeX() {
    return this.sizeX;
  }

  public AbstractNode getSizeY() {
    return this.sizeY;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getRecord() {
    return this.record;
  }
}