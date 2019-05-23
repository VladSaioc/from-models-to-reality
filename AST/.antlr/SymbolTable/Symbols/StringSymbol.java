package SymbolTable.Symbols;

import SymbolTable.SymbolTable;
import SymbolTable.Symbols.Symbol;

public class StringSymbol extends Symbol<String> {
    public StringSymbol(String name, String type, int depth) {
        super(name, type, depth);
    }
}
