package Nodes.ComparisonNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ComparisonLteNode extends BinaryExpressionNode implements IComparisonNode {
  public ComparisonLteNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}