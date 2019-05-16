package Visitors.Evaluators;

import Nodes.AbstractNode;
import Nodes.StringNodes.StringConcatNode;
import Nodes.StringNodes.StringLiteralNode;
import Visitors.BaseVisitor;

public class StringEvaluator extends BaseVisitor<String> {
  public String dispatch(AbstractNode n) {
    if(n instanceof StringLiteralNode) return visit((StringLiteralNode) n);
    if(n instanceof StringConcatNode) return visit((StringConcatNode) n);
    return null;
  }

  public String visit(StringLiteralNode n) { return n.getValue(); }

  public String visit(StringConcatNode n) { return visit(n.getLeft()) + visit(n.getRight());}
}
