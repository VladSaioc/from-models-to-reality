package Visitors;
import java.util.HashMap;
import java.util.ArrayList;

import Nodes.*;
import Nodes.BlockStatements.*;
import Nodes.FunctionNodes.*;
import Nodes.RecordNodes.*;
import Nodes.AccessorNodes.*;
import Nodes.AssignNodes.*;
import Nodes.TypeNodes.*;
import Nodes.ArrayNodes.*;
import Nodes.MapNodes.*;
import Nodes.ArithmeticNodes.*;
import SymbolTable.*;

public class TypeChecker extends BaseVisitor
{
	private SymbolTableContainer symbolTable;
	public TypeChecker()
	{
		symbolTable=new SymbolTableContainer();
	}
	
	public SymbolTableContainer getTable()
	{
		return symbolTable;
	}

	public AbstractNode getNextNode(AbstractNode n)
	{
		if (n.rightSib!=null)
		{return n.rightSib;}
		else {return getNextNode(n.parent);}
	}
	
	public void visit(PrimitiveDeclarationNode node)
	{
		populateWithDeclaration("",node);
		getNextNode(node).accept(this);
		//figure out what type of declaration it is, add type to symbol table
	}
	
	public void visit(RecordDeclNode node)
	{
		populateWithRecord("",node);
		getNextNode(node).accept(this);
	}
	
	public void visit(BlockNode node)
	{
		symbolTable.openSoftScope();
		System.out.println("Entering new Scope");
		node.leftmostChild.accept(this);
	}
	
	public void closeVisit()
	{
		symbolTable.closeSoftScope();
		System.out.println("Exiting scope");
	}
	
	public void visit(FunctionDeclNode node)
	{
		TypeNode typen=(TypeNode) node.getReturnType();
		String type=typen.getTypeName();
		IdentifierNode iden=(IdentifierNode) node.getName();
		String name=iden.getValue();
		FunctionParamNode operationNode=(FunctionParamNode)node.getParams();
		HashMap<String,String> params=new HashMap<String,String>();
		while (operationNode.rightSib.getClass()!=FunctionBodyNode.class)
		{
			String paramName=operationNode.getName();
			TypeNode paramTypeNode=(TypeNode)operationNode.getType();
			params.put(paramName, paramTypeNode.getTypeName());
			operationNode=(FunctionParamNode)operationNode.rightSib;
		}
		symbolTable.addFunctionSymbol(name, type, params);
		System.out.println("Adding "+node.leftmostChild.rightSib.toString()+" to Symbol Table");
		getNextNode(node).accept(this);
	}
	
	public void visit(ArrayDeclNode node)
	{
		TypeNode typen=(TypeNode) node.getType();
		String type=typen.getTypeName();
		String name="";
		int bracketcount=node.getDimensions();
		IdentifierNode id;
		if (node.getDeclaration().getClass()==IdentifierNode.class)
		{
			id=(IdentifierNode)node.getDeclaration();
		}
		else
		{
			AssignNode ass=(AssignNode)node.getDeclaration();
			id=(IdentifierNode)ass.getIdentifier();
		}
		name=id.getValue();
		symbolTable.addArraySymbol(name, type, bracketcount);
		getNextNode(node).accept(this);
	}
	
	public void visit(MapDeclarationNode node)
	{
		IntegerNode x=(IntegerNode)node.getSizeX();
		IntegerNode y=(IntegerNode)node.getSizeY();
		IdentifierNode name=(IdentifierNode)node.getIdentifier();
		RecordDeclBodyNode body=(RecordDeclBodyNode)node.getRecord();
	}
	
	public void populateWithDeclaration(String base, PrimitiveDeclarationNode node)
	{
		AbstractNode operationNode=node.leftmostChild;
		TypeNode typen=(TypeNode)node.getType();
		String type=typen.getTypeName();
		while (operationNode.rightSib!=null)
		{
			IdentifierNode identifier;
			operationNode=operationNode.rightSib;
			if (operationNode.getClass()==IdentifierNode.class)
			{
				identifier=(IdentifierNode)operationNode;
			}
			else
			{
				identifier=(IdentifierNode)operationNode.leftmostChild;
			}
			symbolTable.addSymbol(base+identifier.getValue(), type);
			System.out.println("Adding "+base+operationNode.leftmostChild.toString()+" to Symbol Table");
		}
	}
	
	public void populateWithRecord(String baseName, RecordDeclNode node)
	{
		ArrayList<RecordDetails> recordVariables=new ArrayList<RecordDetails>();
		IdentifierNode iden=(IdentifierNode)node.getIdentifier();
		baseName+=iden.getValue()+".";
		PrimitiveDeclarationNode operationNode=(PrimitiveDeclarationNode)node.getBody().leftmostChild;
		while (operationNode!=null)
		{
			TypeNode type=(TypeNode)operationNode.getType();
			AbstractNode currentNode=operationNode.getDeclarations();
			while (currentNode!=null)
			{
				IdentifierNode ident;
				if (currentNode.getClass()==IdentifierNode.class)
				{
					ident=(IdentifierNode)currentNode;
				}
				else
				{
					ident=(IdentifierNode)currentNode.leftmostChild;
				}
				recordVariables.add(new RecordDetails(type.getTypeName(),ident.getValue()));
				currentNode=currentNode.rightSib;
			}
			operationNode=(PrimitiveDeclarationNode)operationNode.rightSib;
		}
	}
}