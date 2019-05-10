package Nodes.RecordNodes;

import Nodes.AbstractNode;

public class RecordDeleteNode extends AbstractNode {
  private AbstractNode toDelete;

  public RecordDeleteNode(AbstractNode toDelete) {
    this.toDelete = toDelete;
    this.adoptChildren(toDelete);
  }

  public AbstractNode getDelete() {
    return this.toDelete;
  }
}