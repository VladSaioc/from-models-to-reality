package Visitors.Evaluators;

import Nodes.AbstractNode;
import Nodes.BooleanNodes.BooleanAndNode;
import Nodes.BooleanNodes.BooleanLiteralNode;
import Nodes.BooleanNodes.BooleanNegateNode;
import Nodes.BooleanNodes.BooleanOrNode;
import Visitors.BaseVisitor;

public class BooleanEvaluator extends BaseVisitor<Boolean> {
  public Boolean dispatch(AbstractNode n) {
    if(n instanceof BooleanLiteralNode) return visit((BooleanLiteralNode) n);
    if(n instanceof BooleanNegateNode) return visit((BooleanNegateNode) n);
    if(n instanceof BooleanAndNode) return visit((BooleanAndNode) n);
    if(n instanceof BooleanOrNode) return visit((BooleanOrNode) n);
    return null;
  }

  public Boolean visit(BooleanLiteralNode n) { return n.getValue(); }

  public Boolean visit(BooleanAndNode n) { return visit(n.getLeft()) && visit(n.getRight()); }

  public Boolean visit(BooleanOrNode n) { return visit(n.getLeft()) || visit(n.getRight()); }

  public Boolean visit(BooleanNegateNode n) { return !visit(n.getInner()); }
}