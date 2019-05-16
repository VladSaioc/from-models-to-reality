package Nodes.ComparisonNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ComparisonGtNode extends BinaryExpressionNode {
  public ComparisonGtNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}