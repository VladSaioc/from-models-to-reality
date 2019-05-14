package SymbolTable;
import java.util.ArrayList;
public class SymbolDetails 
{
	public String type;
	public int scopeLevel;
	public ArrayList<String> parameterList=null;
	public int arrayDimensions=0;
	public ArrayList<RecordDetails> recordSymbols=null;
	public int mapSizeX=0;
	public int mapSizeY=0;
	public SymbolDetails(String type, int ScopeLevel)
	{
		this.type=type;
		scopeLevel=ScopeLevel;
	}
	
	public SymbolDetails(String type, int arrayDimensions, int scopeLevel)
	{
		this.type=type;
		this.scopeLevel=scopeLevel;
		this.arrayDimensions=arrayDimensions;
	}
	
	public SymbolDetails(String type, int scopeLevel, ArrayList<RecordDetails> recordSymbols)
	{
		this.type=type;
		this.scopeLevel=scopeLevel;
		this.recordSymbols=recordSymbols;
	}
	
	public void addParameterTypes(ArrayList<String> params)
	{
		parameterList=params;
	}
}