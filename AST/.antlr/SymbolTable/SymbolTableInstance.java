package SymbolTable;

import Helpers.Types;
import SymbolTable.Symbols.*;
import java.util.HashMap;
import java.util.Stack;

public class SymbolTableInstance {
  private int depth = -1;
  private HashMap<String, Symbol> hashMap = new HashMap<>();
  private Stack<Symbol> scopeDisplay = new Stack<>();

  public SymbolTableInstance() {
    this.openScope();
  }

  public void openScope() {
    this.depth += 1;
    this.scopeDisplay.push(null);
  }

  private void add(Symbol symbol) {
    Symbol collision = this.hashMap.get(symbol.name);
    if (collision == null) {
      this.hashMap.put(symbol.name, symbol);
      return;
    }
    while (collision.hash != null) {
      collision = collision.hash;
    }
    collision.hash = symbol;
  }

  private void delete(Symbol symbol) {
    Symbol hashEntry = this.hashMap.get(symbol.name);
    if (hashEntry.name.equals(symbol.name)) {
      this.hashMap.remove(symbol.name);
      return;
    }
    while (hashEntry.hash != null) {
      if (symbol.name.equals(hashEntry.hash.name)) {
        hashEntry.hash = hashEntry.hash.hash;
        return;
      }
      hashEntry = hashEntry.hash;
    }
  }

  public void closeScope() {
    Symbol symbol = this.scopeDisplay.pop();
    while (symbol != null) {
      Symbol outerScopeEntry = symbol.var;
      delete(symbol);
      if (outerScopeEntry != null)
        add(outerScopeEntry);
      symbol = symbol.level;
    }
    this.depth -= 1;
  }

  private Symbol retrieveSymbol(String name) {
    Symbol hashEntry = this.hashMap.get(name);
    while (hashEntry != null) {
      if (hashEntry.name.equals(name))
        return hashEntry;
      hashEntry = hashEntry.hash;
    }
    return null;
  }

  public Symbol getSymbol(String name) {
    Symbol symbol = this.retrieveSymbol(name);
    if(symbol == null) throw  new Error("Undeclared symbol: " + name);
    return symbol;
  }

  private void checkDuplicate(String name) {
    Symbol oldsym = this.retrieveSymbol(name);
    if (oldsym != null && oldsym.depth == this.depth) {
      throw new Error("Duplicate definition of " + name);
    }
  }

  private void postInstantiate(Symbol newsym) {
    Symbol oldsym = retrieveSymbol(newsym.name);
    newsym.level = this.scopeDisplay.pop();
    this.scopeDisplay.push(newsym);
    if (oldsym != null) this.delete(oldsym);
    this.add(newsym);
    newsym.var = oldsym;
  }

  public Symbol enterSymbol(String name, String type) {
    this.checkDuplicate(name);
    if (type.equals(Types.STRING)) {
      StringSymbol symbol = new StringSymbol(name, type, depth);
      this.postInstantiate(symbol);
      return symbol;
    } else if (type.equals(Types.INT)) {
      IntegerSymbol symbol = new IntegerSymbol(name, type, depth);
      this.postInstantiate(symbol);
      return symbol;
    } else if (type.equals(Types.BOOL)) {
      BooleanSymbol symbol = new BooleanSymbol(name, type, depth);
      this.postInstantiate(symbol);
      return symbol;
    } else if (type.equals(Types.FUNCTION)) {
      FunctionSymbol symbol = new FunctionSymbol(name, type, depth);
      this.postInstantiate(symbol);
      return symbol;
    } else if (type.equals(Types.MAP)) {
      MapSymbol symbol = new MapSymbol(name, type, depth);
      this.postInstantiate(symbol);
      return symbol;
    } else {
      throw new Error("Unrecognized symbol type.");
    }
  }

  public <T> Symbol setSymbolValue(String name, T value) {
    this.retrieveSymbol(name).value = value;
    return this.retrieveSymbol(name);
  }
}
