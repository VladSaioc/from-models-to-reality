package Nodes.ExpressionNodes;

import Nodes.AbstractNode;
import Nodes.IAbstractNode;

public interface IBinaryExpressionNode extends IAbstractNode {
  AbstractNode getLeft();

  AbstractNode getRight();
}
