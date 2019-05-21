package SymbolTable.Symbols;

import SymbolTable.Attr.CellAttr;

public class CellSymbol extends ComplexSymbol<CellAttr> {
  public CellSymbol(String name, String type, int depth) {
    super(name, type, depth);
  }
}
