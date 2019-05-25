package Visitors.Evaluators;

import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.ComparisonNodes.*;
import Visitors.BaseVisitor;

public class ComparisonEvaluator extends BaseVisitor<Boolean> {
  public Boolean dispatch(AbstractNode n) {
    if(n instanceof ComparisonGtNode) return visit((ComparisonGtNode) n);
    if(n instanceof ComparisonGteNode) return visit((ComparisonGteNode) n);
    if(n instanceof ComparisonEqNode) return visit((ComparisonEqNode) n);
    if(n instanceof ComparisonNeqNode) return visit((ComparisonNeqNode) n);
    if(n instanceof ComparisonLtNode) return visit((ComparisonLtNode) n);
    if(n instanceof ComparisonLteNode) return visit((ComparisonLteNode) n);
    visitChildren(n);
    return null;
  }

  public Boolean visit(ComparisonGtNode n) {
    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
    Integer left = evaluator.visit(n.getLeft());
    Integer right = evaluator.visit(n.getRight());
    return left > right;
  }

  public Boolean visit(ComparisonGteNode n) {
    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
    Integer left = evaluator.visit(n.getLeft());
    Integer right = evaluator.visit(n.getRight());
    return left >= right;
  }

  public Boolean visit(ComparisonLtNode n) {
    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
    Integer left = evaluator.visit(n.getLeft());
    Integer right = evaluator.visit(n.getRight());
    return left < right;
  }

  public Boolean visit(ComparisonLteNode n) {
    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
    Integer left = evaluator.visit(n.getLeft());
    Integer right = evaluator.visit(n.getRight());
    return left <= right;
  }

  public Boolean visit(ComparisonEqNode n) {
    if(n.getLeft().type.equals(Types.STRING)) {
      StringEvaluator evaluator = new StringEvaluator();
      String left = evaluator.visit(n.getLeft());
      String right = evaluator.visit(n.getRight());
      return left.equals(right);
    } else if(n.getLeft().type.equals(Types.BOOL)) {
      BooleanEvaluator evaluator = new BooleanEvaluator();
      Boolean left = evaluator.visit(n.getLeft());
      Boolean right = evaluator.visit(n.getRight());
      return left.equals(right);
    } else if(n.getLeft().type.equals(Types.INT)) {
      ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
      Integer left = evaluator.visit(n.getLeft());
      Integer right = evaluator.visit(n.getRight());
      return left.equals(right);
    } else throw new Error("Evaluator. Unrecognized type in comparison expression: " + n.getLeft().type);
  }

  public Boolean visit(ComparisonNeqNode n) {
    if(n.getLeft().type.equals(Types.STRING)) {
      StringEvaluator evaluator = new StringEvaluator();
      String left = evaluator.visit(n.getLeft());
      String right = evaluator.visit(n.getRight());
      return !left.equals(right);
    } else if(n.getLeft().type.equals(Types.BOOL)) {
      BooleanEvaluator evaluator = new BooleanEvaluator();
      Boolean left = evaluator.visit(n.getLeft());
      Boolean right = evaluator.visit(n.getRight());
      return !left.equals(right);
    } else if(n.getLeft().type.equals(Types.INT)) {
      ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
      Integer left = evaluator.visit(n.getLeft());
      Integer right = evaluator.visit(n.getRight());
      return !left.equals(right);
    } else throw new Error("Evaluator. Unrecognized type in comparison expression: " + n.getLeft().type);
  }
}
