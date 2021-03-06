package Nodes;

import SymbolTable.Symbols.Symbol;

public abstract class AbstractNode implements IAbstractNode {
  public AbstractNode rightSib;
  public AbstractNode leftmostSib;
  public AbstractNode parent;
  public AbstractNode leftmostChild;
  public String type = "";

  public AbstractNode() {
    this.leftmostSib = this;
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
        this.leftmostChild = ysibs;
        while (ysibs != null) {
          ysibs.parent = this;
          ysibs = ysibs.rightSib;
        }
      }
    }
    return this;
  }
}