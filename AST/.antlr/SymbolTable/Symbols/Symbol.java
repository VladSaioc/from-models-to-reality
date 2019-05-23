package SymbolTable.Symbols;

public class Symbol<T> {
	public Boolean init = false;
	public String name;
	public String type;
	public Symbol hash;
	public Symbol level;
	public Symbol var;
	public int depth;
	public T value;

	public Symbol(String name, String type, int depth) {
		this.name = name;
		this.type = type;
		this.depth = depth;
	}
}