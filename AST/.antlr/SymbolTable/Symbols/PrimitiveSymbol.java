package SymbolTable.Symbols;

import java.util.HashMap;

public class PrimitiveSymbol<T> extends Symbol {
    private HashMap<String, T> props;

    public PrimitiveSymbol(String name, String type, int depth) {
        super(name, type, depth);
    }

    public void setValue(T value) {
        props.put("value", value);
    }

    public T getValue(T value) {
        return props.get("value");
    }
}
