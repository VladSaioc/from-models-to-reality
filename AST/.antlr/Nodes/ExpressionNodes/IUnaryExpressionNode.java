package Nodes.ExpressionNodes;

import Nodes.AbstractNode;

public interface IUnaryExpressionNode extends IExpressionNode {
  AbstractNode getInner();
}
