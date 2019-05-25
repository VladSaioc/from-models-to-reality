package Visitors.CodeGeneration;

import Helpers.CodeGenerator;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.BooleanNodes.BooleanAndNode;
import Nodes.BooleanNodes.BooleanLiteralNode;
import Nodes.BooleanNodes.BooleanNegateNode;
import Nodes.BooleanNodes.BooleanOrNode;
import Nodes.ComparisonNodes.IComparisonNode;

public class BooleanCodeEmitVisitor extends BaseCodeEmitVisitor {
  public Void dispatch(AbstractNode n) {
    if(n instanceof BooleanLiteralNode) return visit((BooleanLiteralNode) n);
    if(n instanceof BooleanAndNode) return visit((BooleanAndNode) n );
    if(n instanceof BooleanOrNode) return visit((BooleanOrNode) n);
    if(n instanceof IComparisonNode) return visit((IComparisonNode) n);
    if(n instanceof BooleanNegateNode) return visit((BooleanNegateNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(BooleanLiteralNode n) {
    CodeGenerator.appendCode(Boolean.toString(n.getValue()));
    return null;
  }

  public Void visit(BooleanNegateNode n) {
    CodeGenerator.appendCode("!");
    visit(n.getInner());
    return null;
  }

  public Void visit(BooleanAndNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode("&&");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(BooleanOrNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode("||");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(IComparisonNode n) {
    ComparisonCodeEmitVisitor visitor = new ComparisonCodeEmitVisitor();
    visitor.visit((AbstractNode) n);
    return null;
  }
}
