package Visitors.CodeGeneration;

import Helpers.CodeGenerator;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.StringNodes.StringConcatNode;
import Nodes.StringNodes.StringLiteralNode;

public class StringCodeEmitVisitor extends BaseCodeEmitVisitor {
  public Void dispatch(AbstractNode n) {
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof StringLiteralNode) return visit((StringLiteralNode) n);
    if(n instanceof StringConcatNode) return visit((StringConcatNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(StringLiteralNode n) {
    String value = n.getValue().replace("\\","\\\\");
    CodeGenerator.appendCode("\"" + value + "\"");
    return null;
  }

  public Void visit(StringConcatNode n) {
    CodeGenerator.appendCode("(");
    visit(n.getLeft());
    CodeGenerator.appendCode("+");
    visit(n.getRight());
    CodeGenerator.appendCode(")");
    return null;
  }
}
