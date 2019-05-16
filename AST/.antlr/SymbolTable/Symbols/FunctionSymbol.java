package SymbolTable.Symbols;

import java.util.ArrayList;

public class FunctionSymbol extends Symbol {
    public ArrayList<String> paramTypes;

    public FunctionSymbol(String name, String type, int depth, ArrayList<String> paramTypes)
    {
        super(name, type, depth);
        this.paramTypes=paramTypes;
    }
}
