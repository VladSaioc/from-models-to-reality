package SymbolTable.Symbols;

import java.util.HashMap;

public class PrimitiveSymbol<T> extends Symbol {
    public T value;

    public PrimitiveSymbol(String name, String type, int depth) {
        super(name, type, depth);
    }
}
