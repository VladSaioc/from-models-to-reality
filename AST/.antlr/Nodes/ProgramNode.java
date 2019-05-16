package Nodes;

import Visitors.BaseVisitor;

public class ProgramNode extends AbstractNode {
  private AbstractNode functions;
  private AbstractNode imports;
  private AbstractNode statements;
  private AbstractNode exports;

  public ProgramNode(AbstractNode functions, AbstractNode imports, AbstractNode statements, AbstractNode exports) {
    super();
    this.functions = functions;
    this.imports = imports;
    this.statements = statements;
    this.exports = exports;
    this.adoptChildren(functions)
    .adoptChildren(imports)
    .adoptChildren(statements)
    .adoptChildren(exports);
  }

  public AbstractNode getFunctions() {
    return this.functions;
  }

  public AbstractNode getImports() {
    return this.imports;
  }

  public AbstractNode getExports() {
    return this.exports;
  }

  public AbstractNode getStatements() {
    return this.statements;
  }
}