package Nodes.ArrayNodes;

import Nodes.AbstractNode;

public class ArrayDeclNode extends AbstractNode {
  private AbstractNode type;
  private AbstractNode declaration;
  private AbstractNode brackets;

  public ArrayDeclNode(AbstractNode type, AbstractNode brackets, AbstractNode declaration) {
    this.type = type;
    this.brackets = brackets;
    this.declaration = declaration;
    this.adoptChildren(type)
    .adoptChildren(brackets)
    .adoptChildren(declaration);
  }

  public AbstractNode getBrackets() {
    return this.brackets;
  }

  public AbstractNode getDeclaration() {
    return this.declaration;
  }

  public AbstractNode getType() {
    return this.type;
  }
}