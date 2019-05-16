package Nodes.ExpressionNodes;

import Nodes.AbstractNode;
import Nodes.IAbstractNode;

public interface IUnaryExpressionNode extends IAbstractNode {
  AbstractNode getInner();
}
