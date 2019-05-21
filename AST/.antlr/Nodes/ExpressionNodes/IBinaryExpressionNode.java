package Nodes.ExpressionNodes;

import Nodes.AbstractNode;

public interface IBinaryExpressionNode extends IExpressionNode {
  AbstractNode getLeft();

  AbstractNode getRight();
}
