package SymbolTable;
import SymbolTable.Symbols.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
public class SymbolTable 
{
	private int depth=0;
	private HashMap<String,Symbol> symbolTable=new HashMap<>();
	private ArrayList<Symbol> scopeDisplay=new ArrayList<>();
	
	public SymbolTable()
	{}
	
	public String getType(String name) //gets type of symbolName
	{
		Symbol symbol=retrieveSymbol(name);
		if (symbol!=null)
		{
			return symbol.type;
		}
		return "";
	}
	
	public boolean checkType(String name, String type) //Checks if given symbolname is of given type
	{
		return type.equals(getType(name));
	}


	public boolean checkType(String name, String type, ArrayList<String> paramTypes)
	{
		FunctionSymbol symbol=(FunctionSymbol)retrieveSymbol(name);
		boolean match=paramTypes.size()==symbol.paramTypes.size();
		int i=0;
		while (match && i<paramTypes.size())
		{
			match=match&&(paramTypes.get(i)==symbol.paramTypes.get(i));
			i+=1;
		}
		return match;
	}

	public boolean checkType(String name, String type, int dimensions)
	{
		ArraySymbol symbol=(ArraySymbol)retrieveSymbol(name);
		if (symbol!=null)
		{
			return type.equals(symbol.type) && dimensions==symbol.dimensions;
		}
		return false;
	}
	
	public void openScope()
	{
		depth+=1;
		scopeDisplay.add(depth,null);
	}

	public void closeScope()
	{
		Symbol prevSymbol;
		for (Symbol symbol:scopeDisplay)
		{
			prevSymbol = symbol.var;
			delete(symbol);
			if (prevSymbol!=null)
			{
				add(prevSymbol);
			}
		}
		depth-=1;
	}

	private void delete(Symbol symbol)
	{
		Symbol prevSymbol=symbolTable.get(symbol.name);
		if (prevSymbol!=null & !prevSymbol.equals(symbol))
		{
			while (!prevSymbol.hash.equals(symbol))
			{
				prevSymbol=prevSymbol.hash;
			}
			prevSymbol.hash=symbol.hash;
		}
	}

	private void add(Symbol symbol)
	{
		Symbol collisionSymbol=symbolTable.get(symbol.name);
		if (collisionSymbol==null)
		symbolTable.put(symbol.name, symbol);
		else {collisionSymbol.hash=symbol;
		}
	}

	public Symbol retrieveSymbol(String name)
	{
		Symbol symbol=symbolTable.get(name);
		while (symbol!=null)
		{
			if (symbol.name.equals(name))
			{
				return symbol;
			}
			symbol=symbol.hash;
		}
		return null;
	}

	private Symbol getOldSymbol(String name)
	{
		Symbol oldSymbol=retrieveSymbol(name);
		if (oldSymbol!=null && oldSymbol.depth==depth)
		{
			throw new Error("Error! Variable "+name+" declared in the same scope!");
		}
		return oldSymbol;
	}

	private void connectSymbols(Symbol oldSymbol, Symbol newSymbol)
	{
		newSymbol.level=scopeDisplay.get(depth);
		scopeDisplay.set(depth, newSymbol);
		if (oldSymbol==null)
		{
			add(newSymbol);
		}
		else
		{
			delete(oldSymbol);
			add(newSymbol);
			newSymbol.var=oldSymbol;
		}
	}

	public void enterSymbol(String name, String type)
	{
		Symbol oldSymbol=getOldSymbol(name);
		Symbol newSymbol=null;
		switch (type)
		{
			case "boolean":{
				newSymbol=new BooleanSymbol(name, type, depth);
			} break;
			case "int":{
				newSymbol=new IntegerSymbol(name,type,depth);
			} break;
			case "string": {
				newSymbol=new StringSymbol(name,type,depth);
			} break;
			case "double": {
				newSymbol=new DoubleSymbol(name, type, depth);
			} break;
			default: throw new Error("Type error: Cannot find type: "+type);
		}
		if (newSymbol!=null)
		{
			connectSymbols(oldSymbol, newSymbol);
		}
	}

	public int getCurrentScope()
	{
		return depth;
	}
	
	public SymbolTable getTable()
	{
		return this;
	}

	public boolean declaredLocally(String name)
	{
		Symbol symbol=retrieveSymbol(name);
		if (symbol!=null)
		{
			return depth==symbol.depth;
		}
		return false;
	}

	public void enterSymbol(String name, String type, int dimensions)
	{
		Symbol oldSymbol=getOldSymbol(name);
		Symbol newSymbol=new ArraySymbol(name,type, depth, dimensions);
		connectSymbols(oldSymbol, newSymbol);
	}

	public void enterSymbol(String name, String type, ArrayList<String> paramTypes)
	{
		Symbol oldSymbol=getOldSymbol(name);
		Symbol newSymbol=new FunctionSymbol(name, type, depth, paramTypes);
		connectSymbols(oldSymbol, newSymbol);
	}
}
