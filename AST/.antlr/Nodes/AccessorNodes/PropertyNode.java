package Nodes.AccessorNodes;

import Nodes.AbstractNode;

public class PropertyNode extends LAccessorNode {
  public PropertyNode(AbstractNode identifier, AbstractNode indexes, AbstractNode prop) {
    super(identifier, indexes, prop);
  }
}