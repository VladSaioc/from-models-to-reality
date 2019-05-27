package Visitors.TypeChecker;

import Helpers.Types;
import Nodes.*;
import Nodes.BooleanNodes.*;
import Nodes.ComparisonNodes.*;
import Nodes.AccessorNodes.*;
import Nodes.FunctionNodes.FunctionParamNode;
import Nodes.FunctionNodes.FunctionParamsNode;
import Nodes.StringNodes.StringConcatNode;
import Nodes.StringNodes.StringLiteralNode;
import Nodes.MapNodes.*;
import Nodes.ArithmeticNodes.*;
import SymbolTable.*;
import SymbolTable.Symbols.FunctionSymbol;
import SymbolTable.Symbols.Symbol;
import Visitors.BaseVisitor;

import java.util.ArrayList;

public class TypeVisitor extends BaseVisitor<String> {
  public String dispatch(AbstractNode n) {
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof IntegerNode) {
      n.type = Types.INT;
      return Types.INT;
    }
    if(n instanceof ArithmeticNegateNode) {
      n.type = Types.INT;
      return visit((ArithmeticNegateNode) n);
    }
    if(n instanceof IArithmeticBinaryExpressionNode) {
      n.type = Types.INT;
      return visit((IArithmeticBinaryExpressionNode) n);
    }
    if(n instanceof IBooleanBinaryExpressionNode) {
      n.type = Types.BOOL;
      return visit((IBooleanBinaryExpressionNode) n);
    }
    if(n instanceof BooleanNegateNode) {
      n.type = Types.BOOL;
      return visit((BooleanNegateNode) n);
    }
    if(n instanceof BooleanLiteralNode) {
      n.type = Types.BOOL;
      return Types.BOOL;
    }
    if(n instanceof IComparisonOrdNode) {
      n.type = Types.BOOL;
      return visit((IComparisonOrdNode) n);
    }
    if(n instanceof IComparisonNode) {
      n.type = Types.BOOL;
      return visit((IComparisonNode) n);
    }
    if(n instanceof StringLiteralNode) {
      n.type = Types.STRING;
      return Types.STRING;
    }
    if(n instanceof StringConcatNode) {
      n.type = Types.STRING;
      return visit((StringConcatNode) n);
    }
    if(n instanceof MapJoinNode) {
      n.type = Types.MAP;
      return visit((MapJoinNode) n);
    }
    if(n instanceof MapMaskNode) {
      n.type = Types.MAP;
      return visit((MapMaskNode) n);
    }
    if(n instanceof MapUnaryIndexedOperationNode) {
      n.type = Types.MAP;
      return visit((MapUnaryIndexedOperationNode) n);
    }
    if(n instanceof MapUnaryOperationNode) {
      n.type = Types.MAP;
      return visit((MapUnaryOperationNode) n);
    }
    if(n instanceof FunctionParamsNode) return visit((FunctionParamsNode) n);
    if(n instanceof FunctionParamNode) return visit((FunctionParamNode) n);
    visitChildren(n);
    return null;
  }

  public String visit(IdentifierNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    Symbol symbol = st.getSymbol(n.getValue());
    if(symbol.type.equals(Types.FUNCTION)) throw new Error("Attempting to invoke function " + symbol.name + " as a non-functional variable.");
    if(!symbol.init) throw new Error("Attempting to use uninitialized variable " + symbol.name + ".");
    n.type = symbol.type;
    return symbol.type;
  }

  public String visit(IArithmeticBinaryExpressionNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (!leftType.equals(Types.INT)) throw new Error("Invalid type in arithmetic expression.\n Requires integer, found " + leftType + " instead.");
    if (!rightType.equals(Types.INT)) throw new Error("Invalid type in arithmetic expression.\n Requires integer, found " + rightType + " instead.");
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
    if (!leftType.equals(Types.INT)) throw new Error("Invalid type in ordinal comparison operator.\n Requires integer, found " + leftType + " instead.");
    if (!rightType.equals(Types.INT)) throw new Error("Invalid type in ordinal comparison operator.\n Requires integer, found " + rightType + " instead.");
    return Types.BOOL;
  }

  public String visit(IComparisonNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if (! (leftType.equals(Types.BOOL) || leftType.equals(Types.STRING) || leftType.equals(Types.INT))) throw new Error("Comparison expression can only hold primitive types. Found " + leftType);
    if (! (rightType.equals(Types.BOOL) || rightType.equals(Types.STRING) || rightType.equals(Types.INT))) throw new Error("Comparison expression can only hold primitive types. Found " + rightType);
    if (!leftType.equals(rightType)) throw new Error("Mismatched types in comparison expression. Found " + leftType + " and " + rightType + " instead.");
    return Types.BOOL;
  }

  public String visit(MapJoinNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    String displacementType = visit(n.getDisplacement());
    if (displacementType != null && !displacementType.equals(Types.INT)) throw new Error("Invalid displacement type in join expression.\n Requires integer, found " + displacementType + " instead.");
    if (!leftType.equals(Types.MAP)) throw new Error("Invalid type in join expression. Requires map, found " + leftType + " instead.");
    if (!rightType.equals(Types.MAP)) throw new Error("Invalid type in join expression. Requires map, found " + rightType + " instead.");
    return Types.MAP;
  }

  public String visit(MapMaskNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    String xType = visit(n.getX());
    String yType = visit(n.getY());
    if(xType != null && !xType.equals(Types.INT)) throw new Error("Invalid X position in mask expression.\n Requires integer, found " + xType + " instead.");
    if(yType != null && !yType.equals(Types.INT)) throw new Error("Invalid Y position in mask expression.\n Requires integer, found " + yType + " instead.");
    if (!leftType.equals(Types.MAP)) throw new Error("Invalid type in mask expression.\n Requires map, found " + leftType + " instead.");
    if (!rightType.equals(Types.MAP)) throw new Error("Invalid type in mask expression.\n Requires map, found " + rightType + " instead.");
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
    return innerType;
  }

  public String visit(StringConcatNode n) {
    String leftType = visit(n.getLeft());
    String rightType = visit(n.getRight());
    if(!leftType.equals(Types.STRING) || !rightType.equals(Types.STRING)) throw new Error("Invalid types in string expression: " + leftType + ", " + rightType);
    return Types.STRING;
  }

  public String visit(FunctionCallNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    FunctionSymbol symbol = (FunctionSymbol) st.getSymbol(n.getName());
    String returnType = symbol.value.getReturnType();
    ArrayList<String> paramTypes = symbol.value.getParamTypes();
    AbstractNode param = n.getParams();
    int i = 0;
    for(; param != null && i < paramTypes.size(); i++, param = param.rightSib) {
      String exprType = visit(param);
      if(!paramTypes.get(i).equals(exprType)) throw new Error("Argument " + (i + 1) + " type mismatch in function " + n.getName() + ".\n Requires " + paramTypes.get(i) + ", found " + exprType + " instead.");
    }
    if(param != null) throw new Error("Function " + n.getName() + " called with too many arguments.");
    if(i < paramTypes.size())throw new Error("Function " + n.getName() + " called with too few arguments.");
    n.type = returnType;
    return returnType;
  }

  public String visit(FunctionParamsNode n) {
    AbstractNode param = n.getParams();
    String paramTypes = visit(param);
    param = param.rightSib;
    while(param != null) {
      paramTypes = paramTypes.concat(", " + visit(param));
      param = param.rightSib;
    }
    return paramTypes;
  }

  public String visit(FunctionParamNode n) {
    return n.getType();
  }
}