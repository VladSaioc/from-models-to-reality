package Visitors;
import Nodes.AbstractNode;
public interface TablePopulatorVisitor 
{	
	public void visit(AbstractNode node);
	
//	public void visit(DeclarationNode node);
	
//	public void visit(BlockNode node);
	
	public void closeVisit();
	
}
