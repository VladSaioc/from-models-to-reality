package SymbolTable;
import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;
public class SymbolTableContainer 
{
	Stack<SymbolTable> mainTable=new Stack<>();
	
	public void openHardScope()
	{
		mainTable.push(new SymbolTable());
	}
	
	public void closeHardScope()
	{
		mainTable.pop();
	}
	
	public void addSymbol(String name, String type)
	{
		mainTable.peek().addSymbol(name, type);
	}
	
	public String checkType(String name) //gets type of symbolName
	{
		return mainTable.peek().checkType(name);
	}
	
	public boolean checkType(String name, String type) //Checks if given symbolname is of given type
	{
		return mainTable.peek().checkType(name, type);
	}
	
	public boolean checkFunctionType(String name, ArrayList<String> params, String type)
	{
		ArrayList<String> paramTypes = new ArrayList<>();
		for (String param:params)
		{
			paramTypes.add(checkType(param));
		}
		Stack<SymbolTable> tempTable=new Stack<>();
		boolean found=false;
		while (!found && !mainTable.isEmpty())
		{
			tempTable.push(mainTable.pop());
			//found=tempTable.peek().checkFunctionType(name, paramTypes, type);
		}
		while (!tempTable.isEmpty())
		{
			mainTable.push(tempTable.pop());
		}
		return found;
	}
	
	public void openSoftScope()
	{
		mainTable.peek().openSoftScope();
	}

	public void closeSoftScope()
	{
		mainTable.peek().closeSoftScope();
	}
	
	public int getCurrentScope()
	{
		return mainTable.peek().getCurrentScope();
	}
	
	public SymbolTableContainer getTableStack()
	{
		return this;
	}
	
	public SymbolTable getCurrentTable()
	{
		return mainTable.peek();
	}
	
	public void addFunctionSymbol(String name, String type, HashMap<String,String> params)
	{
		ArrayList<String> paramTypes=new ArrayList<>(params.values());
		mainTable.peek().addFunctionSymbol(name, type, paramTypes);
		openHardScope();
		for (String param:params.keySet())
		{
			mainTable.peek().addSymbol(param, params.get(param));
		}
	}
	
	/*public void addArraySymbol(String name, String type, int count)
	{
		mainTable.peek().addArraySymbol(name, type, count);
	}
	*/
	public void addRecordSymbol(String name, String type, ArrayList<RecordDetails> record)
	{
		
	}
}
