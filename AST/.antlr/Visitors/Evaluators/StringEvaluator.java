package Visitors.Evaluators;

import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.FunctionNodes.FunctionParamNode;
import Nodes.StringNodes.StringConcatNode;
import Nodes.StringNodes.StringLiteralNode;
import SymbolTable.SymbolTable;
import SymbolTable.Symbols.FunctionSymbol;
import SymbolTable.Symbols.StringSymbol;
import Visitors.BaseVisitor;

public class StringEvaluator extends BaseVisitor<String> {
  public String dispatch(AbstractNode n) {
    if(n instanceof StringLiteralNode) return visit((StringLiteralNode) n);
    if(n instanceof StringConcatNode) return visit((StringConcatNode) n);
    if(n instanceof FunctionCallNode) return visit((FunctionCallNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    return null;
  }

  public String visit(StringLiteralNode n) { return n.getValue(); }

  public String visit(StringConcatNode n) { return visit(n.getLeft()) + visit(n.getRight()); }

  public String visit(IdentifierNode n) {
    StringSymbol symbol = (StringSymbol) SymbolTable.getSymbol(n.getValue());
    return symbol.value;
  }

  public String visit(FunctionCallNode n) {
    FunctionSymbol symbol = (FunctionSymbol) SymbolTable.getSymbol(n.getName());
    Evaluator evaluator = new Evaluator();
    SymbolTable.openScope();
    FunctionParamNode param = (FunctionParamNode) symbol.value.getParams();
    AbstractNode expr = n.getParams();
    while(param != null && expr != null) {
      String paramType = param.getType();
      if(paramType.equals(Types.BOOL)) {
        Boolean value = new BooleanEvaluator().visit(expr);
        SymbolTable.enterSymbol(param.getName(), paramType).value = value;
      } else if(paramType.equals(Types.STRING)) {
        String value = visit(expr);
        SymbolTable.enterSymbol(param.getName(), paramType).value = value;
      } else if(paramType.equals(Types.INT)) {
        Integer value = new ArithmeticEvaluator().visit(expr);
        SymbolTable.enterSymbol(param.getName(), paramType).value = value;
      } else throw new Error("Unrecognized parameter type " + paramType + " for parameter " + param.getName() + " in function " + n.getName());
      param = (FunctionParamNode) param.rightSib;
      expr = expr.rightSib;
    }
    evaluator.visit(symbol.value.getBody());
    String result = visit(symbol.value.getReturnExp());
    SymbolTable.closeScope();
    return result;
  }
}
