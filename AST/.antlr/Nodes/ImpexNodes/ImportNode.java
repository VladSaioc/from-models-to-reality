package Nodes.ImpexNodes;

import Nodes.AbstractNode;

public class ImportNode extends AbstractNode {
  private String path = null;
  private AbstractNode vars = null;

  public ImportNode(String path, AbstractNode vars) {
    super();
    this.path = path;
    this.vars = vars;
    this.adoptChildren(vars);
  }

  public String getPath() {
    return this.path;
  }
  
  public AbstractNode getVars() {
    return this.vars;
  }
} 