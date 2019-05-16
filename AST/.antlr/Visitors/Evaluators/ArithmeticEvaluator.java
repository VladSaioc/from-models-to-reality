package Visitors.Evaluators;

import Nodes.AbstractNode;
import Nodes.ArithmeticNodes.*;
import Visitors.BaseVisitor;

public class ArithmeticEvaluator extends BaseVisitor<Integer> {
  public Integer dispatch(AbstractNode n) {
    if(n instanceof IntegerNode) return visit((IntegerNode) n);
    if(n instanceof ArithmeticAddNode) return visit((ArithmeticAddNode) n);
    if(n instanceof ArithmeticSubNode) return visit((ArithmeticSubNode) n);
    if(n instanceof ArithmeticModNode) return visit((ArithmeticModNode) n);
    if(n instanceof ArithmeticDivNode) return visit((ArithmeticDivNode) n);
    if(n instanceof ArithmeticMultNode) return visit((ArithmeticMultNode) n);
    if(n instanceof ArithmeticNegateNode) return visit((ArithmeticNegateNode) n);
    return null;
  }

  public Integer visit(IntegerNode n) { return n.getValue(); }

  public Integer visit(ArithmeticAddNode n) { return visit(n.getLeft()) + visit(n.getRight()); }

  public Integer visit(ArithmeticSubNode n) { return visit(n.getLeft()) - visit(n.getRight()); }

  public Integer visit(ArithmeticMultNode n) { return visit(n.getLeft()) * visit(n.getRight()); }

  public Integer visit(ArithmeticModNode n) { return visit(n.getLeft()) % visit(n.getRight()); }

  public Integer visit(ArithmeticDivNode n) { return visit(n.getLeft()) / visit(n.getRight()); }

  public Integer visit(ArithmeticNegateNode n) { return -visit(n.getInner()); }
}
