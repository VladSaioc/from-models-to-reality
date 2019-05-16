package Nodes.ImpexNodes;

import Nodes.AbstractNode;

public class ExportNode extends AbstractNode {
  private AbstractNode vars = null;

  public ExportNode(AbstractNode vars) {
    super();
    this.vars = vars;
    this.adoptChildren(vars);
  }

  public AbstractNode getVars() {
    return this.vars;
  }
}