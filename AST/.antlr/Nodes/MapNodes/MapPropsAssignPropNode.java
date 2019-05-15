package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapPropsAssignPropNode extends AbstractNode {
  private String type;
  private String name;
  private AbstractNode expr;

  public MapPropsAssignPropNode(String type, String name, AbstractNode expr) {
    this.type = type;
    this.name = name;
    this.expr = expr;
    this.adoptChildren(expr);
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public AbstractNode getExpr() {
    return expr;
  }
}
