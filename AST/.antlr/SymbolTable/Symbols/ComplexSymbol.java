package SymbolTable.Symbols;

public class ComplexSymbol<T> extends  Symbol {
  public T attr;

  public ComplexSymbol(String name, String type, int depth) {
    super(name, type, depth);
  }

  public void setAttr(T attr) {
    this.attr = attr;
  }
}
