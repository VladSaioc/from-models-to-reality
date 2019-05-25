package Visitors.CodeGeneration;

import Helpers.CodeGenerator;
import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.ComparisonNodes.*;

public class ComparisonCodeEmitVisitor extends BaseCodeEmitVisitor {
  public Void dispatch(AbstractNode n) {
    if(n instanceof ComparisonGtNode) return visit((ComparisonGtNode) n);
    if(n instanceof ComparisonGteNode) return visit((ComparisonGteNode) n);
    if(n instanceof ComparisonEqNode) return visit((ComparisonEqNode) n);
    if(n instanceof ComparisonNeqNode) return visit((ComparisonNeqNode) n);
    if(n instanceof ComparisonLtNode) return visit((ComparisonLtNode) n);
    if(n instanceof ComparisonLteNode) return visit((ComparisonLteNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(ComparisonGteNode n) {
    ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
    visitor.visit(n.getLeft());
    CodeGenerator.appendCode(">=");
    visitor.visit(n.getRight());
    return null;
  }

  public Void visit(ComparisonGtNode n) {
    ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
    visitor.visit(n.getLeft());
    CodeGenerator.appendCode(">");
    visitor.visit(n.getRight());
    return null;
  }

  public Void visit(ComparisonLteNode n) {
    ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
    visitor.visit(n.getLeft());
    CodeGenerator.appendCode("<=");
    visitor.visit(n.getRight());
    return null;
  }

  public Void visit(ComparisonLtNode n) {
    ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
    visitor.visit(n.getLeft());
    CodeGenerator.appendCode("<");
    visitor.visit(n.getRight());
    return null;
  }

  public Void visit(ComparisonEqNode n) {
    if(n.getLeft().type.equals(Types.STRING)) {
      StringCodeEmitVisitor visitor = new StringCodeEmitVisitor ();
      visitor.visit(n.getLeft());
      CodeGenerator.appendCode("==");
      visitor.visit(n.getRight());
    } else if(n.getLeft().type.equals(Types.BOOL)) {
      BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
      visitor.visit(n.getLeft());
      CodeGenerator.appendCode("==");
      visitor.visit(n.getRight());
    } else if(n.getLeft().type.equals(Types.INT)) {
      ArithmeticCodeEmitVisitor visitor= new ArithmeticCodeEmitVisitor();
      visitor.visit(n.getLeft());
      CodeGenerator.appendCode("==");
      visitor.visit(n.getRight());
    }
    return null;
  }

  public Void visit(ComparisonNeqNode n) {
    if(n.getLeft().type.equals(Types.STRING)) {
      StringCodeEmitVisitor visitor = new StringCodeEmitVisitor ();
      visitor.visit(n.getLeft());
      CodeGenerator.appendCode("!=");
      visitor.visit(n.getRight());
    } else if(n.getLeft().type.equals(Types.BOOL)) {
      BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
      visitor.visit(n.getLeft());
      CodeGenerator.appendCode("!=");
      visitor.visit(n.getRight());
    } else if(n.getLeft().type.equals(Types.INT)) {
      ArithmeticCodeEmitVisitor visitor= new ArithmeticCodeEmitVisitor();
      visitor.visit(n.getLeft());
      CodeGenerator.appendCode("!=");
      visitor.visit(n.getRight());
    }
    return null;
  }
}
