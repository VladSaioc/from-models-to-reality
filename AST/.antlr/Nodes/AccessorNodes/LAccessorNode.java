package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class LAccessorNode extends AbstractNode {
  private AbstractNode identifier;
  private AbstractNode props;

  public LAccessorNode(AbstractNode identifier, AbstractNode props) {
    this.identifier = identifier;
    this.props = props;
    this.adoptChildren(identifier)
    .adoptChildren(props);
  }

  public AbstractNode getIdentifier() {
    return this.identifier;
  }

  public AbstractNode getProps() {
    return this.props;
  }
}