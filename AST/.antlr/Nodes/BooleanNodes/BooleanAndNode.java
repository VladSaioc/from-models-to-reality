package Nodes.BooleanNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class BooleanAndNode extends BinaryExpressionNode implements IBooleanNode, IBooleanBinaryExpressionNode {
  public BooleanAndNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}