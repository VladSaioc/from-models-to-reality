package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapPropsAssignNode extends AbstractNode {
  private String name;
  private AbstractNode propBody;
  private AbstractNode query;

  public MapPropsAssignNode(String name, AbstractNode query, AbstractNode propBody) {
    this.name = name;
    this.query = query;
    this.propBody = propBody;
    this.adoptChildren(query)
    .adoptChildren(propBody);
  }

  public AbstractNode getPropBody() {
    return this.propBody;
  }

  public String getName() {
    return this.name;
  }

  public AbstractNode getQuery() {
    return this.query;
  }
}