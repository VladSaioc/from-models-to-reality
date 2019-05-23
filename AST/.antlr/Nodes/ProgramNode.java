package Nodes;

import Visitors.BaseVisitor;

public class ProgramNode extends AbstractNode {
  public ProgramNode(AbstractNode functions, AbstractNode imports, AbstractNode statements, AbstractNode exports) {
    super();
    this.adoptChildren(functions)
    .adoptChildren(imports)
    .adoptChildren(statements)
    .adoptChildren(exports);
  }
}