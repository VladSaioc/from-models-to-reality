package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionDeclNode extends AbstractNode {
  private AbstractNode params;
  private AbstractNode name;
  private AbstractNode body;
  private AbstractNode returnType;

  public FunctionDeclNode(AbstractNode name, AbstractNode returnType, AbstractNode params, AbstractNode body) {
    this.params = params;
    this.name = name;
    this.returnType = returnType;
    this.body = body;
    this.adoptChildren(name)
    .adoptChildren(returnType)
    .adoptChildren(params)
    .adoptChildren(body);
  }

  public AbstractNode getName() {
    return this.name;
  }

  public AbstractNode getParams() {
    return this.params;
  }

  public AbstractNode getReturnType() {
    return this.returnType;
  }

  public AbstractNode getBody() {
    return this.body;
  }
}