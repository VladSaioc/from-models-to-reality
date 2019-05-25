package Visitors.CodeGeneration;

import Helpers.CodeGenerator;
import Helpers.Types;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.FunctionCallNode;
import Nodes.AccessorNodes.IdentifierNode;
import SymbolTable.SymbolTable;
import SymbolTable.SymbolTableInstance;
import SymbolTable.Symbols.Symbol;
import Visitors.BaseVisitor;

public class BaseCodeEmitVisitor extends BaseVisitor<Void> {
  public Void dispatch(AbstractNode n) {
    return null;
  }

  public String typeString(String type) {
    switch (type) {
      case Types.INT:
        return "Integer ";
      case Types.BOOL:
        return "Boolean ";
      case Types.STRING:
        return "String ";
      case Types.MAP:
        return "MapAttr ";
      default:
        throw new Error("Didn't find required type");
    }
  }

  public static String getVarName(String name) {
    SymbolTableInstance st = SymbolTable.peek();
    Symbol symbol = st.getSymbol(name);
    String scopePrefix = "";
    for(int i = 0; i < SymbolTable.depth(); i++) {
      scopePrefix = scopePrefix.concat("$");
    }
    for(int i = 0; i <= symbol.depth; i++) {
      scopePrefix = scopePrefix.concat("_");
    }
    return scopePrefix + name;
  }


  public Void visit(IdentifierNode n) {
    String name = getVarName(n.getValue());
    CodeGenerator.appendCode(name);
    return null;
  }

  public Void visit(FunctionCallNode n) {
    CodeGenerator.appendCode(getVarName(n.getName()) + "(");
    AbstractNode param = n.getParams();
    while(param != null) {
      if(param.type.equals(Types.INT)) {
        ArithmeticCodeEmitVisitor visitor = new ArithmeticCodeEmitVisitor();
        visitor.visit(param);
      } else if(param.type.equals(Types.BOOL)) {
        BooleanCodeEmitVisitor visitor = new BooleanCodeEmitVisitor();
        visitor.visit(param);
      } else if(param.type.equals(Types.STRING)) {
        StringCodeEmitVisitor visitor = new StringCodeEmitVisitor();
        visitor.visit(param);
      }
      if(param.rightSib != null) CodeGenerator.appendCode(",");
      param = param.rightSib;
    }
    CodeGenerator.appendCode(")");
    return null;
  }
}
