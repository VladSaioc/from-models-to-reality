package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class LAccessorNode extends AbstractNode {
  private AbstractNode identifier;
  private AbstractNode indexes;
  private AbstractNode prop;

  public LAccessorNode(AbstractNode identifier, AbstractNode indexes, AbstractNode prop) {
    this.identifier = identifier;
    this.indexes = indexes;
    this.prop = prop;
    this.adoptChildren(identifier)
    .adoptChildren(indexes)
    .adoptChildren(prop);
  }

  public AbstractNode getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getProp() {
    return this.prop;
  }

  public AbstractNode getIndexes() {
    return this.indexes;
  }
}