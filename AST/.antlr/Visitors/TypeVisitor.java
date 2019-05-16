package Visitors;

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
    if(n instanceof IntegerNode) return "int";
    if(n instanceof ArithmeticNegateNode) return visit((ArithmeticNegateNode) n);
    if(n instanceof IArithmeticBinaryExpressionNode) return visit((IArithmeticBinaryExpressionNode) n);
    if(n instanceof IBooleanBinaryExpressionNode) return visit((IBooleanBinaryExpressionNode) n);
    if(n instanceof BooleanNegateNode) return visit((BooleanNegateNode) n);
    if(n instanceof BooleanLiteralNode) return "boolean";
    if(n instanceof IComparisonNode) return visit((IComparisonNode) n);
    if(n instanceof StringLiteralNode) return "string";
    if(n instanceof StringConcatNode) return visit((StringConcatNode) n);
    if(n instanceof IMapBinaryExpression) return visit((IMapBinaryExpression) n);
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
    if (!leftType.equals("int") || !rightType.equals("int")) throw new Error("Invalid type in arithmetic expression");
    return "int";
  }

  public String visit(ArithmeticNegateNode n) {
    String innerType = visit(n.getInner());
    if (!innerType.equals("int")) throw new Error("Invalid type in arithmetic negation node");
    return "int";
  }

  public String visit(IBooleanBinaryExpressionNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals("boolean") || !rightType.equals("boolean")) throw new Error("Invalid type in arithmetic expression");
    return "boolean";
  }

  public String visit(BooleanNegateNode n) {
    String innerType = visit(n.getInner());
    if (!innerType.equals("boolean")) throw new Error("Invalid type in boolean negation");
    return "boolean";
  }

  public String visit(IComparisonNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals(rightType)) throw new Error("Mismatched types in comparison expression");
    return "boolean";
  }

  public String visit(IMapBinaryExpression n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals("map") || !rightType.equals("map")) throw new Error("Invalid type in map expression");
    return "map";
  }

  public String visit(MapUnaryOperationNode n) {
    String innerType = visit(n.getInner());
    if(!innerType.equals("map")) throw new Error("Invalid type in map unary operation");
    return innerType;
  }

  public String visit(MapUnaryIndexedOperationNode n) {
    String innerType = visit(n.getInner());
    String indexType = visit(n.getIndex());
    if(!indexType.equals("int")) throw new Error("Invalid index type in map operation");
    if(!innerType.equals("map")) throw new Error("Invalid type in map unary operation");
    return indexType;
  }

  public String visit(StringConcatNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if(!leftType.equals("string") || !rightType.equals("string")) throw new Error("Invalid type in string expression");
    return "string";
  }

  public String visit(FunctionCallNode n) {
    Symbol symbol = SymbolTable.retrieveSymbol(n.getName());
    String returnType = symbol.getType();
    String[] paramTypes = symbol.getParamTypes();
    AbstractNode param = n.getParams();
    int i = 0;
    while (param != null) {
      if(!paramTypes[i].equals(visit(param))) throw new Error("Parameter type mismatch in function " + n.getName());
      i++;
      param = param.rightSib;
    }
    return returnType;
  }
}