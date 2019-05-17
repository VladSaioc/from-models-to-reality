package Visitors;

import Nodes.*;
import Nodes.AccessorNodes.*;
import Nodes.ArithmeticNodes.*;
import Nodes.AssignNodes.*;
import Nodes.BlockStatements.*;
import Nodes.BooleanNodes.*;
import Nodes.ControlStatements.*;
import Nodes.ComparisonNodes.*;
import Nodes.ExpressionNodes.*;
import Nodes.FunctionNodes.*;
import Nodes.ImpexNodes.*;
import Nodes.MapNodes.*;
import Nodes.StringNodes.*;

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

  public <N extends AbstractNode> Void visitTypedSiblings(N n) {
    String baseType = n.getClass().getName();
    AbstractNode sib = n;
    while (sib != null && sib.getClass().getName().equals(baseType)) {
      visit(sib);
      sib = sib.rightSib;
    }
    return null;
  }

  public abstract T dispatch(AbstractNode n);

  public T visit(AbstractNode n) {
    return this.dispatch(n);
  }
}
