package Nodes.TypeNodes;

public class FunctionTypeNode extends TypeNode {
  private String[] params;

  public FunctionTypeNode(String typeName, String[] params) {
    super(typeName);
    this.params = params;
  }

  public String[] getParams() {
    return this.params;
  }
}
