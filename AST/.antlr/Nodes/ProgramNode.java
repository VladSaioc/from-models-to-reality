package Nodes;

public class ProgramNode extends AbstractNode {
  private AbstractNode imports;
  private AbstractNode statements;
  private AbstractNode exports;

  public ProgramNode(AbstractNode imports, AbstractNode statements, AbstractNode exports) {
    this.imports = imports;
    this.statements = statements;
    this.exports = exports;
    this.adoptChildren(imports)
    .adoptChildren(statements)
    .adoptChildren(exports);
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