package Nodes.FunctionNodes;

import Nodes.AbstractNode;
import Nodes.BlockStatements.BlockNode;

public class FunctionBodyNode extends BlockNode {
  public FunctionBodyNode(AbstractNode statements) {
    super(statements);
  }
}