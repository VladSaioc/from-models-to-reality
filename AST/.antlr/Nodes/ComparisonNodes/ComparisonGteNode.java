package Nodes.ComparisonNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ComparisonGteNode extends BinaryExpressionNode implements IComparisonNode {
  public ComparisonGteNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}