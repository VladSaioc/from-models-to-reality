package Nodes.MapNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.UnaryExpressionNode;

public class MapUnaryOperationNode extends UnaryExpressionNode implements IMapExpressionNode {
  public MapUnaryOperationNode() {
    super();
  }

  public AbstractNode setInner(AbstractNode inner) {
    this.inner = inner;
    return this.adoptChildren(inner);
  }
}