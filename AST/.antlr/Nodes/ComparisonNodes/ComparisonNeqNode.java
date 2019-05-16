package Nodes.ComparisonNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ComparisonNeqNode extends BinaryExpressionNode implements IComparisonNode {
  public ComparisonNeqNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}