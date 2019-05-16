package SymbolTable;
import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;
public class SymbolTableContainer 
{
	private SymbolTable table;

	public SymbolTableContainer()
	{
		table=new SymbolTable();
	}

	public void openScope()
	{
		table.openScope();
	}
	
	public void closeScope()
	{
		table.closeScope();
	}
	
	public void addSymbol(String name, String type)
	{
		table.enterSymbol(name,type);
	}
	
	public String getType(String name) //gets type of symbolName
	{
		return table.getType(name);
	}
	
	public boolean checkType(String name, String type) //Checks if given symbolname is of given type
	{
		return table.checkType(name, type);
	}

	public boolean checkFunctionType(String name, ArrayList<String> params, String type)
	{
		return table.checkType(name, type, params);
	}

	public boolean checkType(String name, String type, int dimensions)
	{
		return table.checkType(name, type, dimensions);
	}
	
	public int getCurrentScope()
	{
		return table.getCurrentScope();
	}
	
	public SymbolTable getCurrentTable()
	{
		return table;
	}

	public void addFunctionSymbol(String name, String type, HashMap<String,String> params)
	{
		ArrayList<String> paramTypes=new ArrayList<>(params.values());
		table.enterSymbol(name, type, paramTypes);
	}
	
	public void addArraySymbol(String name, String type, int count)
	{
		table.enterSymbol(name, type, count);
	}
}
