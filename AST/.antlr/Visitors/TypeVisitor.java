package Visitors;

import Helpers.Types;
import Nodes.*;
import Nodes.BooleanNodes.*;
import Nodes.ComparisonNodes.*;
import Nodes.AccessorNodes.*;
import Nodes.StringNodes.StringConcatNode;
import Nodes.StringNodes.StringLiteralNode;
import Nodes.MapNodes.*;
import Nodes.ArithmeticNodes.*;
import SymbolTable.*;
import SymbolTable.Symbols.Symbol;

public class TypeVisitor extends BaseVisitor<String> {
  public String dispatch(AbstractNode n) {
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof IntegerNode) return Types.INT;
    if(n instanceof ArithmeticNegateNode) return visit((ArithmeticNegateNode) n);
    if(n instanceof IArithmeticBinaryExpressionNode) return visit((IArithmeticBinaryExpressionNode) n);
    if(n instanceof IBooleanBinaryExpressionNode) return visit((IBooleanBinaryExpressionNode) n);
    if(n instanceof BooleanNegateNode) return visit((BooleanNegateNode) n);
    if(n instanceof BooleanLiteralNode) return Types.BOOL;
    if(n instanceof IComparisonOrdNode) return visit((IComparisonOrdNode) n);
    if(n instanceof IComparisonNode) return visit((IComparisonNode) n);
    if(n instanceof StringLiteralNode) return Types.STRING;
    if(n instanceof StringConcatNode) return visit((StringConcatNode) n);
    if(n instanceof MapJoinNode) return visit((MapJoinNode) n);
    if(n instanceof MapMaskNode) return visit((MapMaskNode) n);
    if(n instanceof MapUnaryIndexedOperationNode) return visit((MapUnaryIndexedOperationNode) n);
    if(n instanceof MapUnaryOperationNode) return visit((MapUnaryOperationNode) n);
    return null;
  }

  public String visit(IdentifierNode n) {
    return SymbolTable.retrieveSymbol(n.getValue()).getType();
  }

  public String visit(IArithmeticBinaryExpressionNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals(Types.INT)) throw new Error("Invalid type in arithmetic expression. Requires integer. Found " + leftType + " instead.");
    if (!rightType.equals(Types.INT)) throw new Error("Invalid type in arithmetic expression. Requires integer. Found " + rightType + " instead.");
    return Types.INT;
  }

  public String visit(ArithmeticNegateNode n) {
    String innerType = visit(n.getInner());
    if (!innerType.equals(Types.INT)) throw new Error("Invalid type in arithmetic negation node");
    return Types.INT;
  }

  public String visit(IBooleanBinaryExpressionNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals(Types.BOOL)) throw new Error("Invalid type in boolean expression. Found " + leftType + " instead.");
    if (!rightType.equals(Types.BOOL)) throw new Error("Invalid type in boolean expression. Found " + rightType + " instead.");
    return Types.BOOL;
  }

  public String visit(BooleanNegateNode n) {
    String innerType = visit(n.getInner());
    if (!innerType.equals(Types.BOOL)) throw new Error("Invalid type in boolean negation. Found " + innerType + " instead.");
    return Types.BOOL;
  }

  public String visit(IComparisonOrdNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals(Types.INT)) throw new Error("Invalid type in ordinal comparison operator. Requires integer. Found " + leftType + " instead.");
    if (!rightType.equals(Types.INT)) throw new Error("Invalid type in ordinal comparison operator. Requires integer. Found " + rightType + " instead.");
    return Types.BOOL;
  }

  public String visit(IComparisonNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals(rightType)) throw new Error("Mismatched types in comparison expression. Found " + leftType + " and " + rightType + " instead.");
    return Types.BOOL;
  }

  public String visit(MapJoinNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    String displacementType = visit(n.getDisplacement());
    if (!displacementType.equals(Types.INT)) throw new Error("Invalid displacement type in join expression. Requires integer. Found " + displacementType + " instead.");
    if (!leftType.equals(Types.MAP)) throw new Error("Invalid type in join expression. Requires map. Found " + leftType + " instead.");
    if (!rightType.equals(Types.MAP)) throw new Error("Invalid type in join expression. Requires map. Found " + rightType + " instead.");
    return Types.MAP;
  }

  public String visit(MapMaskNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    String xType = visit(n.getX());
    String yType = visit(n.getY());
    if(!xType.equals(Types.INT)) throw new Error("Invalid X position in mask expression. Requires integer. Found " + xType + " instead.");
    if(!yType.equals(Types.INT)) throw new Error("Invalid Y position in mask expression. Requires integer. Found " + yType + " instead.");
    if (!leftType.equals(Types.MAP)) throw new Error("Invalid type in mask expression. Requires map. Found " + leftType + " instead.");
    if (!rightType.equals(Types.MAP)) throw new Error("Invalid type in mask expression. Requires map. Found " + rightType + " instead.");
    return Types.MAP;
  }

  public String visit(MapUnaryOperationNode n) {
    String innerType = visit(n.getInner());
    if(!innerType.equals(Types.MAP)) throw new Error("Invalid type in map unary operation");
    return innerType;
  }

  public String visit(MapUnaryIndexedOperationNode n) {
    String innerType = visit(n.getInner());
    String indexType = visit(n.getIndex());
    if(!indexType.equals(Types.INT)) throw new Error("Invalid index type in map operation");
    if(!innerType.equals(Types.MAP)) throw new Error("Invalid type in map unary operation");
    return indexType;
  }

  public String visit(StringConcatNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if(!leftType.equals(Types.STRING) || !rightType.equals(Types.STRING)) throw new Error("Invalid type in string expression");
    return Types.STRING;
  }

  public String visit(FunctionCallNode n) {
    Symbol symbol = SymbolTable.retrieveSymbol(n.getName());
    String returnType = symbol.getType();
    String[] paramTypes = symbol.getParamTypes();
    AbstractNode param = n.getParams();
    int i = 0;
    while (param != null) {
      String exprType = visit(param);
      if(!paramTypes[i].equals(exprType) throw new Error("Parameter type mismatch in function " + n.getName() + ". Requires " + paramTypes[i] + ", got " + exprType + " instead.");
      i++;
      param = param.rightSib;
    }
    return returnType;
  }
}