package SymbolTable.Attr;

import java.util.ArrayList;
import java.util.HashMap;

public class CellAttr {
  private ArrayList<String> propNames = new ArrayList<>();
  private HashMap<String, Integer> intProps = new HashMap<>();
  private HashMap<String, String> stringProps = new HashMap<>();
  private HashMap<String, Boolean> boolProps = new HashMap<>();

  public CellAttr() {}

  public CellAttr(CellAttr attr) {
    attr.propNames.forEach(x -> {
      this.propNames.add(x);
    });
    attr.intProps.forEach((k, v) -> {
      this.intProps.put(k, v);
    });
    attr.boolProps.forEach((k, v) -> {
      this.boolProps.put(k, v);
    });
    attr.stringProps.forEach((k, v) -> {
      this.stringProps.put(k, v);
    });
  }

  public <T> CellAttr addProp(String name, T prop) {
    intProps.remove(name);
    stringProps.remove(name);
    boolProps.remove(name);
    if(!propNames.contains(name)) propNames.add(name);
    if(prop instanceof Integer) intProps.put(name, (Integer) prop);
    if(prop instanceof Boolean) boolProps.put(name, (Boolean) prop);
    if(prop instanceof String) stringProps.put(name, (String) prop);
    return this;
  }

  public HashMap<String, Integer> getIntProps() {
    return this.intProps;
  }

  public HashMap<String, Boolean> getBoolProps() {
    return this.boolProps;
  }

  public HashMap<String, String> getStringProps() {
    return this.stringProps;
  }

  public CellAttr mergeProps(CellAttr cell) {
    cell.getIntProps().forEach((k, v) -> {
      this.addProp(k, v);
    });
    cell.getBoolProps().forEach((k, v) -> {
      this.addProp(k, v);
    });
    cell.getStringProps().forEach((k, v) -> {
      this.addProp(k, v);
    });
    return this;
  }

  public void print(String coords) {
    String toPrint = coords + " props: { ";
    for (String propName : propNames) {
      if(this.intProps.containsKey(propName)) toPrint += "int: " + propName + " = " + this.intProps.get(propName) + "; ";
      if(this.boolProps.containsKey(propName)) toPrint += "bool: " + propName + " = " + this.boolProps.get(propName) + "; ";
      if(this.stringProps.containsKey(propName)) toPrint += "string: " + propName + " = " + this.stringProps.get(propName) + "; ";
    }
    toPrint += "}";
    System.out.println(toPrint);
  }
}
