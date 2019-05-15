package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapUnaryOperatorNode extends AbstractNode {
  public static class MapPropsAssignBodyNode extends AbstractNode {
    private AbstractNode vars;

    public MapPropsAssignBodyNode(AbstractNode vars) {
      this.vars = vars;
      this.adoptChildren(vars);
    }

    public AbstractNode getVars() {
      return this.vars;
    }
  }

  public static class MapPropsAssignPropNode extends AbstractNode {
    private String type;
    private String identifier;
    private AbstractNode expression;

    public MapPropsAssignPropNode(String type, String identifier, AbstractNode expression) {
      this.identifier = identifier;
      this.type = type;
      this.expression = expression;
      this.adoptChildren(expression);
    }

    public String getIdentifier() {
      return this.identifier;
    }

    public String getType() {
      return this.type;
    }

    public AbstractNode getExpression() {
      return this.expression;
    }
  }
}