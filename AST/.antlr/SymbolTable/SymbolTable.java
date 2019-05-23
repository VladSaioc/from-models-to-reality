package SymbolTable;

import Helpers.Types;
import Nodes.AbstractNode;
import SymbolTable.Symbols.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
  public static HashMap<AbstractNode, ArrayList<String>> importedNames = new HashMap<>();
  public static HashMap<String, MapSymbol> exports = new HashMap<>();
  public static int depth = -1;
  public static HashMap<String, Symbol> hashMap = new HashMap<>();
  public static Stack<Symbol> scopeDisplay = new Stack<>();

  public static void openScope() {
    depth += 1;
    scopeDisplay.push(null);
  }

  public static void addImportedName(AbstractNode imports, String name) {
    ArrayList<String> names = importedNames.get(imports);
    if(names == null) {
      names = new ArrayList<>();
      importedNames.put(imports, names);
    }
    names.add(name);
  }

  public static void addExport(MapSymbol symbol) {
    exports.put(symbol.name, symbol);
  }

  public static MapSymbol getExport(String name) {
    return exports.remove(name);
  }

  public static void clearImportedNames(AbstractNode n) {
    importedNames.get(n).clear();
  }

  public static void add(Symbol symbol) {
    Symbol collision = hashMap.get(symbol.name);
    if (collision == null) {
      hashMap.put(symbol.name, symbol);
      return;
    }
    while (collision.hash != null) {
      collision = collision.hash;
    }
    collision.hash = symbol;
  }

  public static void delete(Symbol symbol) {
    Symbol hashEntry = hashMap.get(symbol.name);
    if (hashEntry.name.equals(symbol.name)) {
      hashMap.remove(symbol.name);
      return;
    }
    while (hashEntry.hash != null) {
      if (symbol.name.equals(hashEntry.hash.name)) {
        hashEntry.hash = hashEntry.hash.hash;
      }
      hashEntry = hashEntry.hash;
    }
  }

  public static void closeScope() {
    Symbol symbol = scopeDisplay.pop();
    while (symbol != null) {
      Symbol outerScopeEntry = symbol.var;
      delete(symbol);
      if (outerScopeEntry != null)
        add(outerScopeEntry);
      symbol = symbol.level;
    }
    depth -= 1;
  }

  private static Symbol retrieveSymbol(String name) {
    Symbol hashEntry = hashMap.get(name);
    while (hashEntry != null) {
      if (hashEntry.name.equals(name))
        return hashEntry;
      hashEntry = hashEntry.hash;
    }
    return null;
  }

  public static Symbol getSymbol(String name) {
    Symbol symbol = retrieveSymbol(name);
    if(symbol == null) throw new Error("Undeclared symbol: " + name);
    return symbol;
  }

  private static void checkDuplicate(String name) {
    Symbol oldsym = retrieveSymbol(name);
    if (oldsym != null && oldsym.depth == depth) {
      throw new Error("Duplicate definition of " + name);
    }
  }

  private static void postInstantiate(Symbol newsym) {
    Symbol oldsym = retrieveSymbol(newsym.name);
    newsym.level = scopeDisplay.pop();
    scopeDisplay.push(newsym);
    if (oldsym != null) delete(oldsym);
    add(newsym);
    newsym.var = oldsym;
  }

  public static Symbol enterSymbol(String name, String type) {
    checkDuplicate(name);
    if (type.equals(Types.STRING)) {
      StringSymbol symbol = new StringSymbol(name, type, depth);
      postInstantiate(symbol);
      return symbol;
    } else if (type.equals(Types.INT)) {
      IntegerSymbol symbol = new IntegerSymbol(name, type, depth);
      postInstantiate(symbol);
      return symbol;
    } else if (type.equals(Types.BOOL)) {
      BooleanSymbol symbol = new BooleanSymbol(name, type, depth);
      postInstantiate(symbol);
      return symbol;
    } else {
      throw new Error("Tried entering non-primitive symbol through the primitive channel");
    }
  }

  public static FunctionSymbol enterFunctionSymbol(String name) {
    checkDuplicate(name);
    FunctionSymbol symbol = new FunctionSymbol(name, Types.FUNCTION, depth);
    postInstantiate(symbol);
    return symbol;
  }

  public static MapSymbol enterMapSymbol(String name) {
    checkDuplicate(name);
    MapSymbol symbol = new MapSymbol(name, Types.MAP, depth);
    postInstantiate(symbol);
    return symbol;
  }

  public static <T> void setSymbolValue(String name, T value) {
    retrieveSymbol(name).value = value;
  }

  public static Boolean declaredLocally(String name) {
    Symbol iter = hashMap.get(name);
    while (iter != null) {
      if (iter.name.equals(name) && iter.depth == depth) return true;
      iter = iter.hash;
    }
    return false;
  }
}
