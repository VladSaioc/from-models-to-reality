package SymbolTable.Symbols;

import SymbolTable.Attr.MapAttr;

public class MapSymbol extends ComplexSymbol<MapAttr> {
  public MapSymbol(String name, String type, int depth) {
    super(name, type, depth);
  }
}
