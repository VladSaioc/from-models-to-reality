package Nodes.ComparisonNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ComparisonNode extends BinaryExpressionNode {
  public ComparisonNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}