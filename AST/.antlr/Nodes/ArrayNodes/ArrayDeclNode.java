package Nodes.ArrayNodes;

import Nodes.AbstractNode;

public class ArrayDeclNode extends AbstractNode {
  private AbstractNode type;
  private AbstractNode declaration;
  private int dimensions;

  public ArrayDeclNode(AbstractNode type, int dimensions, AbstractNode declaration) {
    this.type = type;
    this.dimensions = dimensions;
    this.declaration = declaration;
    this.adoptChildren(type)
    .adoptChildren(declaration);
  }

  public int getDimensions() {
    return this.dimensions;
  }

  public AbstractNode getDeclaration() {
    return this.declaration;
  }

  public AbstractNode getType() {
    return this.type;
  }
}