package Nodes.ImpexNodes;

import Nodes.AbstractNode;

public class ImportsNode extends AbstractNode {
  private AbstractNode imports;

  public ImportsNode(AbstractNode imports) {
    super();
    this.imports = imports;
    this.adoptChildren(imports);
  }

  public AbstractNode getImports() {
    return this.imports;
  }
}
