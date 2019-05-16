package SymbolTable.Symbols;

public class ArraySymbol extends Symbol{
    public int dimensions;
    public ArraySymbol(String name, String type, int depth, int dimensions)
    {
        super(name,type,depth);
        this.dimensions=dimensions;
    }
}
