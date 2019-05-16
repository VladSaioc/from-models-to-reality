package Nodes;

public class PrimitiveDeclarationNode extends AbstractNode {
  private String type;
  private AbstractNode declarations;

  public PrimitiveDeclarationNode(String type, AbstractNode declarations) {
    super();
    this.type = type;
    this.declarations = declarations;
    this.adoptChildren(declarations);
  }

  public String getType() {
    return this.type;
  }

  public AbstractNode getDeclarations() {
    return this.declarations;
  }
}