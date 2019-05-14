package SymbolTable;

import java.util.ArrayList;

public class RecordDetails 
{
	public String type;
	public String name;
	public ArrayList<RecordDetails> record;
	
	public RecordDetails(String type, String name)
	{
		this.type=type;
		this.name=name;
	}
}
