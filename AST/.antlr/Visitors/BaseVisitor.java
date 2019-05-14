package Visitors;

import Nodes.*;
import Nodes.AccessorNodes.*;
import Nodes.ArithmeticNodes.*;
import Nodes.ArrayNodes.*;
import Nodes.AssignNodes.*;
import Nodes.BlockStatements.*;
import Nodes.BooleanNodes.*;
import Nodes.ControlStatements.*;
import Nodes.ComparisonNodes.*;
import Nodes.ExpressionNodes.*;
import Nodes.FunctionNodes.*;
import Nodes.ImpexNodes.*;
import Nodes.MapNodes.*;
import Nodes.RecordNodes.*;
import Nodes.StringNodes.*;
import Nodes.TypeNodes.*;

public abstract class BaseVisitor {
  public void visitChildren(AbstractNode n) {
    AbstractNode child = n.leftmostChild;
    while(child != null) {
      child.accept(this);
      child = child.rightSib;
    }
  }
  
  public void visit(AbstractNode n) {
    n.accept(this);
  }

//  public abstract void visit(ProgramNode n);
//
//  public abstract void visit(ImportNode n);
//
//  public abstract void visit(ExportNode n);
//
//  public abstract void visit(IdentifierNode n);
//
//  public abstract void visit(IndexNode n);
//
//  public abstract void visit(PropertyNode n);
//
//  public abstract void visit(LAccessorNode n);
//
//  public abstract void visit(RAccessorNode n);
//
//  public abstract void visit(FunctionCallNode n);
//
//  public abstract void visit(PrimitiveDeclarationNode n);
//
//  public abstract void visit(AssignNode n);
//
//  public abstract void visit(ArrayDeclNode n);
//
//  public abstract void visit(ArrayLiteralNode n);
//
//  public abstract void visit(MapDeclarationNode n);
//
//  public abstract void visit(RecordDeclNode n);
//
//  public abstract void visit(RecordDeclBodyNode n);
//
//  public abstract void visit(BooleanOrNode n);
//
//  public abstract void visit(BooleanAndNode n);
//
//  public abstract void visit(BooleanNegationNode n);
//
//  public abstract void visit(BooleanNegateNode n);
//
//  public abstract void visit(BooleanLiteralNode n);
//
//  public abstract void visit(ComparisonGtNode n);
//
//  public abstract void visit(ComparisonLtNode n);
//
//  public abstract void visit(ComparisonGteNode n);
//
//  public abstract void visit(ComparisonLteNode n);
//
//  public abstract void visit(ComparisonEqNode n);
//
//  public abstract void visit(ComparisonNeqNode n);
//
//  public abstract void visit(IntegerNode n);
//
//  public abstract void visit(DoubleNode n);
//
//  public abstract void visit(ArithmeticAddNode n);
//
//  public abstract void visit(ArithmeticSubNode n);
//
//  public abstract void visit(ArithmeticMultNode n);
//
//  public abstract void visit(ArithmeticDivNode n);
//
//  public abstract void visit(ArithmeticModNode n);
//
//  public abstract void visit(MapJoinXNode n);
//
//  public abstract void visit(MapJoinYNode n);
//
//  public abstract void visit(MapMaskNode n);
//
//  public abstract void visit(MapUnaryOperationNode n);
//
//  public abstract void visit(MapDropXNode n);
//
//  public abstract void visit(MapDropYNode n);
//
//  public abstract void visit(MapInsertXNode n);
//
//  public abstract void visit(MapInsertYNode n);
//
//  public abstract void visit(MapRotateCcwNode n);
//
//  public abstract void visit(MapRotateCwNode n);
//
//  public abstract void visit(MapMirrorXNode n);
//
//  public abstract void visit(MapMirrorYNode n);
//
//  public abstract void visit(MapQueryPredicateNode n);
//
//  public abstract void visit(CoordinatesNode n);
//
//  public abstract void visit(MapQueryAssignmentNode n);
//
//  public abstract void visit(RecordAssignBodyNode n);
//
//  public abstract void visit(RecordAssignNode n);
//
//  public abstract void visit(RecordDeleteNode n);
//
//  public abstract void visit(WhileNode n);
//
//  public abstract void visit(IfNode n);
//
//  public abstract void visit(BlockNode n);
//
//  public abstract void visit(FunctionHeaderNode n);
//
//  public abstract void visit(FunctionParamNode n);
//
//  public abstract void visit(FunctionDeclNode n);
//
//  public abstract void visit(FunctionBodyNode n);
}
