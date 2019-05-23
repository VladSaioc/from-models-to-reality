package SymbolTable.Symbols;

import SymbolTable.Attr.FunctionAttr;

public class FunctionSymbol extends Symbol<FunctionAttr> {
   public FunctionSymbol(String name, String type, int depth) {
      super(name, type, depth);
   }
}
