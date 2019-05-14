package SymbolTable.Symbols;

public class PrimitiveSymbol<T> extends Symbol {
    public T value;

    public PrimitiveSymbol(String name, String type, int depth, T value) {
        super(name, type, depth);
        this.value = value;
    }
}
