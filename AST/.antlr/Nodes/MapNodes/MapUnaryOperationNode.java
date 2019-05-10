package Nodes.MapNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.UnaryExpressionNode;

public class MapUnaryOperationNode extends UnaryExpressionNode {
  public MapUnaryOperationNode() {};
  public MapUnaryOperationNode(AbstractNode inner) {
    super(inner);
  }
}