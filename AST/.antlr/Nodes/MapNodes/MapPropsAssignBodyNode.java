package Nodes.MapNodes;

import Nodes.AbstractNode;

public class MapPropsAssignBodyNode extends AbstractNode {
  private AbstractNode props;

  public MapPropsAssignBodyNode(AbstractNode props) {
    super();
    this.props = props;
    this.adoptChildren(props);
  }

  public AbstractNode getProps() {
    return this.props;
  }
}
