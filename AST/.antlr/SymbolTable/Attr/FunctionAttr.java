package SymbolTable.Attr;

import Nodes.AbstractNode;

import java.util.ArrayList;

public class FunctionAttr {
  private ArrayList<String> paramTypes;
  private String returnType;
  private AbstractNode paramRef;
  private AbstractNode returnExpRef;
  private AbstractNode bodyRef;

  public FunctionAttr(String returnType, ArrayList<String> paramTypes) {
    this.returnType = returnType;
    this.paramTypes = paramTypes;
  }

  public FunctionAttr(String returnType, AbstractNode paramRef, AbstractNode bodyRef, AbstractNode returnExpRef) {
    this.returnType = returnType;
    this.paramRef = paramRef;
    this.bodyRef = bodyRef;
    this.returnExpRef = returnExpRef;
  }

  public ArrayList<String> getParamTypes() {
    return this.paramTypes;
  }

  public String getReturnType() {
    return this.returnType;
  }

  public AbstractNode getParams() { return this.paramRef; }

  public AbstractNode getBody() {
    return this.bodyRef;
  }

  public AbstractNode getReturnExp() {
    return this.returnExpRef;
  }
}
