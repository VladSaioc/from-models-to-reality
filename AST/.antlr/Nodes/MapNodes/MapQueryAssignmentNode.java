package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapQueryAssignmentNode extends AbstractNode {
  private AbstractNode var;
  private AbstractNode record;
  private AbstractNode queries;

  public MapQueryAssignmentNode(AbstractNode var, AbstractNode queries, AbstractNode record) {
    this.var = var;
    this.queries = queries;
    this.record = record;
    this.adoptChildren(var)
    .adoptChildren(queries)
    .adoptChildren(record);
  }

  public AbstractNode getRecord() {
    return this.record;
  }

  public AbstractNode getVar() {
    return this.var;
  }

  public AbstractNode getQueries() {
    return this.queries;
  }
}