package Nodes.ExpressionNodes;

import Nodes.AbstractNode;

public abstract class BinaryExpressionNode extends AbstractNode implements IBinaryExpressionNode {
  protected AbstractNode left;
  protected AbstractNode right;

  public BinaryExpressionNode() {}
  
  public BinaryExpressionNode(AbstractNode left, AbstractNode right) {
    super();
    this.left = left;
    this.right = right;
    this.adoptChildren(this.left)
    .adoptChildren(this.right);
  }

  public AbstractNode getLeft() {
    return this.left;
  }
  
  public AbstractNode getRight() {
    return this.right;
  }
}