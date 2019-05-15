package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapPropsAssignBodyNode extends AbstractNode {
  private AbstractNode props;

  public MapPropsAssignBodyNode(AbstractNode props) {
    this.props = props;
    this.adoptChildren(props);
  }

  public AbstractNode getProps() {
    return this.props;
  }
}
