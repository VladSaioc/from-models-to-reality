package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class RAccessorNode extends AbstractNode {
  private AbstractNode functionCall;
  private AbstractNode props;

  public RAccessorNode(AbstractNode functionCall, AbstractNode props) {
    this.functionCall = functionCall;
    this.props = props;
    this.adoptChildren(functionCall)
    .adoptChildren(props);
  }

  public AbstractNode getFunctionCall() {
    return this.functionCall;
  }

  public AbstractNode getProps() {
    return this.props;
  }
}