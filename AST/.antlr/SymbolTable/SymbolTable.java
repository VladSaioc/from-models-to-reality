package SymbolTable;
import SymbolTable.Symbols.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
public class SymbolTable 
{
	private int scopeLevel=0;
	private HashMap<String, Stack<Symbol>> softTable;
	
	public SymbolTable()
	{}
	
	public void addSymbol(String name, String type)
	{
		if (softTable.containsKey(name)) {
			if (softTable.get(name).peek().depth != scopeLevel) {
				softTable.get(name).push(new Symbol(name, type, scopeLevel));
			}
			else
			{
				System.out.println("Can't declare same variable in same scope.");
			}
		}
		else
		{
			Stack<Symbol> newStack=new Stack<Symbol>();
			newStack.push(new Symbol(name, type, scopeLevel));
			softTable.put(name, newStack);
		}
	}
	
	public void addFunctionSymbol(String name, String functionType, ArrayList<String> paramTypes)
	{
		if (!softTable.containsKey(name))
		{
			Stack <Symbol> newStack=new Stack<Symbol>();
			Symbol functionEntry=new Symbol(name, functionType, scopeLevel);
			newStack.push(functionEntry);
			softTable.put(name, newStack);
		}
	}
	
	private void removeSymbol(String name)
	{
		if (softTable.containsKey(name))
		{
			softTable.get(name).pop();
		}
	}
	
	public String checkType(String name) //gets type of symbolName
	{
		if (softTable.containsKey(name))
		{
			return softTable.get(name).peek().type;
		}
		return "";
	}
	
	public boolean checkType(String name, String type) //Checks if given symbolname is of given type
	{
		return softTable.get(name).peek().type.equals(type);
	}
	/*
	public boolean checkFunctionType(String name, ArrayList<String> paramTypes, String type)
	{
		//ArrayList<String> functionDetails=softTable.get(name).peek().parameterList;
		boolean match=functionDetails.size()==paramTypes.size();
		if (!match) return false;
		for (int i=0;i<functionDetails.size();i++)
		{
			match=match && functionDetails.get(i).equals(paramTypes.get(i));
		}
		return match;
	}*/
	
	public void openSoftScope()
	{
		scopeLevel+=1;
	}

	public void closeSoftScope()
	{
		if (scopeLevel>0)
		{
			for(String name : softTable.keySet())
			{
				if (softTable.get(name).peek().depth ==scopeLevel)
				{
					removeSymbol(name);
				}
			}
			scopeLevel-=1;
		}
	}
	
	public int getCurrentScope()
	{
		return scopeLevel;
	}
	
	public SymbolTable getTable()
	{
		return this;
	}
	/*
	public void addArraySymbol(String name, String type, int count)
	{
		if (softTable.containsKey(name))
		{
			softTable.get(name).push(new Symbol(type, count, scopeLevel));
		}
		else
		{
			Stack<Symbol> newStack=new Stack<Symbol>();
			newStack.push(new Symbol(type, count, scopeLevel));
			softTable.put(name, newStack);
		}
	}*/
}
