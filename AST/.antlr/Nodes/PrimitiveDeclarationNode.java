package Nodes;

public class PrimitiveDeclarationNode extends AbstractNode {
  private AbstractNode type;
  private AbstractNode declarations;

  public PrimitiveDeclarationNode() {}
  public PrimitiveDeclarationNode(AbstractNode type, AbstractNode declarations) {
    this.type = type;
    this.declarations = declarations;
    this.adoptChildren(type)
    .adoptChildren(declarations);
  }

  public AbstractNode getType() {
    return this.type;
  }

  public AbstractNode getDeclarations() {
    return this.declarations;
  }
}