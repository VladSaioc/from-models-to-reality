package SymbolTable;

import SymbolTable.Symbols.*;

import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
  public static HashMap<String, MapSymbol> exports = new HashMap<>();

  private static Stack<SymbolTableInstance> symbolTables = new Stack<>();

  public static SymbolTableInstance push() {
    return symbolTables.push(new SymbolTableInstance());
  }

  public static void pop() {
    symbolTables.pop();
  }

  public static SymbolTableInstance peek() {
    return symbolTables.peek();
  }

  public static int depth() {
    return symbolTables.size();
  }

  public static void addExport(MapSymbol symbol) {
    exports.put(symbol.name, symbol);
  }

  public static MapSymbol getExport(String name) {
    return exports.remove(name);
  }
}
