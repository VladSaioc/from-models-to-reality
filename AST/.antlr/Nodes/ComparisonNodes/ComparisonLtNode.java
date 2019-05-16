package Nodes.ComparisonNodes;

import Nodes.AbstractNode;
import Nodes.ExpressionNodes.BinaryExpressionNode;

public class ComparisonLtNode extends BinaryExpressionNode {
  public ComparisonLtNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}