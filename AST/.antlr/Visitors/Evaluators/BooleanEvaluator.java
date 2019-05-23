package Visitors.Evaluators;

import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.BooleanNodes.BooleanAndNode;
import Nodes.BooleanNodes.BooleanLiteralNode;
import Nodes.BooleanNodes.BooleanNegateNode;
import Nodes.BooleanNodes.BooleanOrNode;
import Nodes.ComparisonNodes.IComparisonNode;
import Nodes.FunctionNodes.FunctionParamNode;
import SymbolTable.SymbolTable;
import SymbolTable.SymbolTableInstance;
import SymbolTable.Symbols.BooleanSymbol;
import SymbolTable.Symbols.FunctionSymbol;
import Visitors.BaseVisitor;

public class BooleanEvaluator extends BaseVisitor<Boolean> {
  public Boolean dispatch(AbstractNode n) {
    if(n instanceof BooleanLiteralNode) return visit((BooleanLiteralNode) n);
    if(n instanceof BooleanNegateNode) return visit((BooleanNegateNode) n);
    if(n instanceof BooleanAndNode) return visit((BooleanAndNode) n);
    if(n instanceof BooleanOrNode) return visit((BooleanOrNode) n);
    if(n instanceof IComparisonNode) return visit((IComparisonNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    return null;
  }

  public Boolean visit(BooleanLiteralNode n) { return n.getValue(); }

  public Boolean visit(BooleanAndNode n) { return visit(n.getLeft()) && visit(n.getRight()); }

  public Boolean visit(BooleanOrNode n) { return visit(n.getLeft()) || visit(n.getRight()); }

  public Boolean visit(BooleanNegateNode n) { return !visit(n.getInner()); }

  public Boolean visit(IComparisonNode n) {
    ComparisonEvaluator evaluator = new ComparisonEvaluator();
    return evaluator.visit((AbstractNode) n);
  }

  public Boolean visit(IdentifierNode n) {
    SymbolTableInstance st = SymbolTable.peek();
    BooleanSymbol symbol = (BooleanSymbol) st.getSymbol(n.getValue());
    return symbol.value;
  }

  public Boolean visit(FunctionCallNode n) {
    SymbolTableInstance outerSt = SymbolTable.peek();
    FunctionSymbol symbol = (FunctionSymbol) outerSt.getSymbol(n.getName());
    Evaluator evaluator = new Evaluator();
    SymbolTableInstance innerSt = SymbolTable.push();
    FunctionParamNode param = (FunctionParamNode) symbol.value.getParams();
    AbstractNode expr = n.getParams();
    while(param != null && expr != null) {
      String paramType = param.getType();
      if(paramType.equals(Types.BOOL)) {
        innerSt.enterSymbol(param.getName(), paramType).value = visit(expr);
      } else if(paramType.equals(Types.STRING)) {
        innerSt.enterSymbol(param.getName(), paramType).value = new StringEvaluator().visit(expr);
      } else if(paramType.equals(Types.INT)) {
        innerSt.enterSymbol(param.getName(), paramType).value = new ArithmeticEvaluator().visit(expr);
      } else throw new Error("Unrecognized parameter type " + paramType + " for parameter " + param.getName() + " in function " + n.getName());
      param = (FunctionParamNode) param.rightSib;
      expr = expr.rightSib;
    }
    evaluator.visit(symbol.value.getBody());
    Boolean result = visit(symbol.value.getReturnExp());
    SymbolTable.pop();
    return result;
  }
}