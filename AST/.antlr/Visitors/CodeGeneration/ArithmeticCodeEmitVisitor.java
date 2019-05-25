package Visitors.CodeGeneration;

import Helpers.CodeGenerator;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.ArithmeticNodes.*;

public class ArithmeticCodeEmitVisitor extends BaseCodeEmitVisitor {
  public Void dispatch(AbstractNode n) {
    if(n instanceof IntegerNode) return visit((IntegerNode) n);
    if(n instanceof ArithmeticNegateNode) return visit((ArithmeticNegateNode) n);
    if(n instanceof ArithmeticSubNode) return visit((ArithmeticSubNode) n);
    if(n instanceof ArithmeticDivNode) return visit((ArithmeticDivNode) n);
    if(n instanceof ArithmeticModNode) return visit((ArithmeticModNode) n);
    if(n instanceof ArithmeticMultNode) return visit((ArithmeticMultNode) n);
    if(n instanceof ArithmeticAddNode) return visit((ArithmeticAddNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(IntegerNode n) {
    CodeGenerator.appendCode(Integer.toString(n.getValue()));
    return null;
  }

  public Void visit(ArithmeticNegateNode n) {
    CodeGenerator.appendCode("((-1) * ");
    visit(n.getInner());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(ArithmeticAddNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode(" + ");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(ArithmeticSubNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode(" - ");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(ArithmeticDivNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode(" / ");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(ArithmeticMultNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode(" * ");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(ArithmeticModNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode(" % ");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }
}
