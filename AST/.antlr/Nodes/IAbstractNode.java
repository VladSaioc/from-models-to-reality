package Nodes;

public interface IAbstractNode {
  AbstractNode makeSiblings(AbstractNode n);

  AbstractNode adoptChildren(AbstractNode n);
}
