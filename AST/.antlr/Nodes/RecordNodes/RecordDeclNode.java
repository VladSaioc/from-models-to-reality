package Nodes.RecordNodes;

import Nodes.AbstractNode;

public class RecordDeclNode extends AbstractNode {
  private AbstractNode identifier;
  private AbstractNode body;

  public RecordDeclNode(AbstractNode identifier, AbstractNode body) {
    this.identifier = identifier;
    this.body = body;
    this.adoptChildren(identifier)
    .adoptChildren(body);
  }

  public AbstractNode getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getBody() {
    return this.body;
  }
}