package Visitors.Evaluators;

import Nodes.*;
import Nodes.ArithmeticNodes.IArithmeticNode;
import Nodes.BooleanNodes.BooleanNode;
import Nodes.StringNodes.StringNode;
import Visitors.BaseVisitor;

public class Evaluator extends BaseVisitor<Void> {
  public Void dispatch(AbstractNode n) {
    if(n instanceof IArithmeticNode) return visit((IArithmeticNode) n);
    if(n instanceof BooleanNode) return visit((BooleanNode) n);
    if(n instanceof  StringNode) return visit((StringNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(IArithmeticNode n) {
    ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
    System.out.println(arithmeticEvaluator.visit((AbstractNode) n));
    return null;
  }

  public Void visit(BooleanNode n) {
    BooleanEvaluator booleanEvaluator = new BooleanEvaluator();
    System.out.println(booleanEvaluator.visit((AbstractNode) n));
    return null;
  }

  public Void visit(StringNode n) {
    StringEvaluator stringEvaluator = new StringEvaluator();
    System.out.println(stringEvaluator.visit((AbstractNode) n));
    return null;
  }
}
