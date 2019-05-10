package Nodes.ImpexNodes;

import Nodes.AbstractNode;

public class ImportNode extends AbstractNode {
  private AbstractNode path = null;
  private AbstractNode vars = null;

  public ImportNode(AbstractNode path, AbstractNode vars) {
    this.path = path;
    this.vars = vars;
    this.adoptChildren(path)
    .adoptChildren(vars);
  }

  public AbstractNode getPath() {
    return this.path;
  }
  
  public AbstractNode getVars() {
    return this.vars;
  }
} 