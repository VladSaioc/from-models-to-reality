package Visitors;

import Nodes.*;

public abstract class BaseVisitor<T> {
  public Void visitChildren(AbstractNode n) {
    if(n != null) {
      AbstractNode child = n.leftmostChild;
      while (child != null) {
        visit(child);
        child = child.rightSib;
      }
    }
    return null;
  }

  public abstract T dispatch(AbstractNode n);

  public T visit(AbstractNode n) {
    return this.dispatch(n);
  }
}
