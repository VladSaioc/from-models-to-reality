package Nodes.ComparisonNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ComparisonEqNode extends BinaryExpressionNode {
  public ComparisonEqNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}