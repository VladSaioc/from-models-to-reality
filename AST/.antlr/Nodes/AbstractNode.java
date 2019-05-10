package Nodes;

public abstract class AbstractNode {
  public AbstractNode rightSib;
  public AbstractNode leftmostSib;
  public AbstractNode parent;
  public AbstractNode leftmostChild;

  public static AbstractNode makeNode(AbstractNode n) {
    return null;
  }

  public AbstractNode makeSiblings(AbstractNode y) {
    if(y != null) {
      AbstractNode xsibs = this;
      while (xsibs.rightSib != null) {
        xsibs = xsibs.rightSib;
      }
      AbstractNode ysibs = y.leftmostSib;
      xsibs.rightSib = ysibs;
      while (ysibs != null) {
        ysibs.leftmostSib = this.leftmostSib;
        ysibs.parent = this.parent;
        ysibs = ysibs.rightSib;
      }
    }
    return this;
  }

  public AbstractNode adoptChildren(AbstractNode y) {
    if(y != null) {
      if (this.leftmostChild != null) {
        this.leftmostChild.makeSiblings(y);
      } else {
        AbstractNode ysibs = y.leftmostSib;
        while (ysibs != null) {
          ysibs.parent = this;
          ysibs = ysibs.rightSib;
        }
        this.leftmostChild = ysibs;
      }
    }
    return this;
  }

  public AbstractNode adoptChildrenToLeft(AbstractNode y) {
    if (y != null) {
      if (this.leftmostChild != null) {
        y.makeSiblings(this.leftmostChild);
        this.leftmostChild = y;
      } else {
        AbstractNode ysibs = y.leftmostSib;
        while (ysibs != null) {
          ysibs.parent = this;
          ysibs = ysibs.rightSib;
        }
        this.leftmostChild = ysibs;
      }
    }
    return this;
  }
}