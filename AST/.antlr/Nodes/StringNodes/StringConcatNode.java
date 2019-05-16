package Nodes.StringNodes;

import Nodes.ExpressionNodes.*;
import Nodes.AbstractNode;

public class StringConcatNode extends BinaryExpressionNode implements StringNode {
  public StringConcatNode(AbstractNode left, AbstractNode right) {
    super(left, right);
  }
}