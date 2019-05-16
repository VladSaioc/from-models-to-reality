package Nodes.FunctionNodes;

import Nodes.AbstractNode;

public class FunctionDefNode extends AbstractNode {
  private AbstractNode params;
  private String name;
  private AbstractNode body;
  private String type;
  private AbstractNode returnExp;

  public FunctionDefNode(String name, String type, AbstractNode params, AbstractNode body, AbstractNode returnExp) {
    super();
    this.params = params;
    this.name = name;
    this.type = type;
    this.body = body;
    this.returnExp = returnExp;
    this.adoptChildren(params)
    .adoptChildren(body)
    .adoptChildren(returnExp);
  }

  public String getName() {
    return this.name;
  }

  public AbstractNode getParams() {
    return this.params;
  }

  public String getType() {
    return this.type;
  }

  public AbstractNode getBody() {
    return this.body;
  }

  public AbstractNode getReturnExp() {
    return this.returnExp;
  }
}