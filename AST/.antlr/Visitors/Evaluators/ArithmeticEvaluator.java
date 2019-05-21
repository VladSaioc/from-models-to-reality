package Visitors.Evaluators;

import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.ArithmeticNodes.*;
import Nodes.FunctionNodes.FunctionParamNode;
import Nodes.FunctionNodes.FunctionParamsNode;
import SymbolTable.SymbolTable;
import SymbolTable.Symbols.FunctionSymbol;
import SymbolTable.Symbols.IntegerSymbol;
import Visitors.BaseVisitor;

public class ArithmeticEvaluator extends BaseVisitor<Integer> {
  public Integer dispatch(AbstractNode n) {
    if(n instanceof IntegerNode) return visit((IntegerNode) n);
    if(n instanceof ArithmeticAddNode) return visit((ArithmeticAddNode) n);
    if(n instanceof ArithmeticSubNode) return visit((ArithmeticSubNode) n);
    if(n instanceof ArithmeticModNode) return visit((ArithmeticModNode) n);
    if(n instanceof ArithmeticDivNode) return visit((ArithmeticDivNode) n);
    if(n instanceof ArithmeticMultNode) return visit((ArithmeticMultNode) n);
    if(n instanceof ArithmeticNegateNode) return visit((ArithmeticNegateNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    return null;
  }

  public Integer visit(IntegerNode n) { return n.getValue(); }

  public Integer visit(ArithmeticAddNode n) { return visit(n.getLeft()) + visit(n.getRight()); }

  public Integer visit(ArithmeticSubNode n) { return visit(n.getLeft()) - visit(n.getRight()); }

  public Integer visit(ArithmeticMultNode n) { return visit(n.getLeft()) * visit(n.getRight()); }

  public Integer visit(ArithmeticModNode n) { return visit(n.getLeft()) % visit(n.getRight()); }

  public Integer visit(ArithmeticDivNode n) {
    Integer right = visit(n.getRight());
    if (right == 0) throw new Error("Attempted division by 0");
    return visit(n.getLeft()) / right;
  }

  public Integer visit(ArithmeticNegateNode n) { return -visit(n.getInner()); }

  public Integer visit(IdentifierNode n) {
    IntegerSymbol symbol = (IntegerSymbol) SymbolTable.getSymbol(n.getValue());
    return symbol.value;
  }

  public Integer visit(FunctionCallNode n) {
    FunctionSymbol symbol = (FunctionSymbol) SymbolTable.getSymbol(n.getName());
    Evaluator evaluator = new Evaluator();
    SymbolTable.openScope();
    FunctionParamNode param = (FunctionParamNode) symbol.attr.getParams();
    AbstractNode expr = n.getParams();
    while(param != null && expr != null) {
      String paramType = param.getType();
      if(paramType.equals(Types.BOOL)) {
        Boolean value = new BooleanEvaluator().visit(expr);
        SymbolTable.enterSymbol(param.getName(), paramType).value = value;
      } else if(paramType.equals(Types.STRING)) {
        String value = new StringEvaluator().visit(expr);
        SymbolTable.enterSymbol(param.getName(), paramType).value = value;
      } else if(paramType.equals(Types.INT)) {
        Integer value = visit(expr);
        SymbolTable.enterSymbol(param.getName(), paramType).value = value;
      } else throw new Error("Unrecognized parameter type " + paramType + " for parameter " + param.getName() + " in function " + n.getName());
      param = (FunctionParamNode) param.rightSib;
      expr = expr.rightSib;
    }
    evaluator.visit(symbol.attr.getBody());
    Integer result = visit(symbol.attr.getReturnExp());
    SymbolTable.closeScope();
    return result;
  }
}
