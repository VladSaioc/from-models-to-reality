import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class CellAttr {
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

class MapAttr {
  private Integer sizeX;
  private Integer sizeY;
  private HashMap<String, CellAttr> cells;

  public MapAttr(MapAttr n) {
    this.sizeX = n.getSizeX();
    this.sizeY = n.getSizeY();
    this.cells = n.getCellsCopy();
  }

  public MapAttr(int sizeX, int sizeY, HashMap<String, CellAttr> cells) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.cells = cells;
  }

  public Integer getSizeX() {
    return this.sizeX;
  }

  public Integer getSizeY() {
    return this.sizeY;
  }

  public HashMap<String, CellAttr> getCellsCopy() {
    HashMap<String, CellAttr> cells = new HashMap<>();
    for(int x = 0; x < sizeX; x++) {
      for(int y = 0; y < sizeY; y++) {
        Coords coords = new Coords(x, y);
        cells.put(coords.getHash(), new CellAttr(this.cells.get(coords.getHash())));
      }
    }
    return cells;
  }

  public void setCell(int x, int y, CellAttr record) {
    this.cells.put(new Coords(x, y).getHash(), record);
  }

  public void setCell(String coords, CellAttr record) { this.cells.put(coords, record); }
  public void setCell(Coords pair, CellAttr record) {
    this.cells.put(pair.getHash(), record);
  }

  public void print() {
    System.out.println("Map of size: " + this.sizeX + " " + this.sizeY);
    for(int i = 0; i < sizeX; i++) {
      for(int j = 0; j < sizeY; j++) {
        String coords = new Coords(i, j).getHash();
        this.cells.get(coords).print(coords);
      }
    }
  }
}
class Coords {
  private Integer x;
  private Integer y;

  public Coords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return this.x;
  }

  public Integer getY() {
    return this.y;
  }

  public boolean equals(Object coord) {
    if(coord instanceof Coords) {
      return this.x == ((Coords) coord).getX() && this.y == ((Coords) coord).getY();
    }
    else return false;
  }

  public String getHash() {
    return this.x + "," + this.y;
  }
}

class MapOps {
  public static MapAttr rotateCcw(MapAttr inner) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    int sizeX = inner.getSizeX() - 1;
    int sizeY = inner.getSizeY() - 1;

    for(int x = 0; x <= sizeX; x++) {
      for(int y = 0; y <= sizeY; y++) {
        String oldCoords = new Coords(x, y).getHash();
        String newCoords = new Coords(sizeY - y, x).getHash();
        newCells.put(newCoords, oldCells.get(oldCoords));
      }
    }

    return new MapAttr(
      inner.getSizeY(),
      inner.getSizeX(),
      newCells
    );
  }

  public static MapAttr rotateCw(MapAttr inner) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    int sizeX = inner.getSizeX() - 1;
    int sizeY = inner.getSizeY() - 1;

    for(int x = 0; x <= sizeX; x++) {
      for(int y = 0; y <= sizeY; y++) {
        String oldCoords = new Coords(x, y).getHash();
        String newCoords = new Coords(y, sizeX - x).getHash();
        newCells.put(newCoords, oldCells.get(oldCoords));
      }
    }

    return new MapAttr(
      inner.getSizeY(),
      inner.getSizeX(),
      newCells
    );
  }

  public static MapAttr mirrorY(MapAttr inner) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    int sizeX = inner.getSizeX() - 1;
    int sizeY = inner.getSizeY() - 1;

    for(int x = 0; x <= sizeX; x++) {
      for(int y = 0; y <= sizeY; y++) {
        String oldCoords = new Coords(x, y).getHash();
        String newCoords = new Coords(x, sizeY - y).getHash();
        newCells.put(newCoords, oldCells.get(oldCoords));
      }
    }

    return new MapAttr(
      inner.getSizeX(),
      inner.getSizeY(),
      newCells
    );
  }

  public static MapAttr mirrorX(MapAttr inner) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    int sizeX = inner.getSizeX() - 1;
    int sizeY = inner.getSizeY() - 1;

    for(int x = 0; x <= sizeX; x++) {
      for(int y = 0; y <= sizeY; y++) {
        String oldCoords = new Coords(x, y).getHash();
        String newCoords = new Coords(sizeX - x, y).getHash();
        newCells.put(newCoords, oldCells.get(oldCoords));
      }
    }

    return new MapAttr(
      inner.getSizeX(),
      inner.getSizeY(),
      newCells
    );
  }

  public static MapAttr joinX(MapAttr m1, MapAttr m2, Integer d) {
    Integer x1 = m1.getSizeX(), y1 = m1.getSizeY();
    Integer x2 = m2.getSizeX(), y2 = m2.getSizeY();
    HashMap<String, CellAttr> cells1 = m1.getCellsCopy();
    HashMap<String, CellAttr> cells2 = m2.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();

    int x = x1 + x2;
    int y = Math.abs(Math.min(0, d)) + Math.max(y1, y2 + d);
    for(int i = 0; i < x; i++) {
      for(int j = 0; j < y; j++) {
        String coords = new Coords(i, j).getHash();
        if(i < x1) {
          if(j >= Math.abs(Math.min(0, d)) && j < Math.abs(Math.min(0, d)) + y1) {
            String oldCoords = new Coords(i, j - Math.abs(Math.min(0, d))).getHash();
            newCells.put(coords, cells1.get(oldCoords));
          }
          else newCells.put(coords, new CellAttr());
        } else {
          if(j >= Math.max(0, d) && j < Math.max(0, d) + y2) {
            String oldCoords = new Coords(i - x1, j - Math.max(0, d)).getHash();
            newCells.put(coords, cells2.get(oldCoords));
          }
          else newCells.put(coords, new CellAttr());
        }
      }
    }

    return new MapAttr(x, y, newCells);
  }

  public static MapAttr joinY(MapAttr m1, MapAttr m2, Integer d) {
    Integer x1 = m1.getSizeX(), y1 = m1.getSizeY();
    Integer x2 = m2.getSizeX(), y2 = m2.getSizeY();
    HashMap<String, CellAttr> cells1 = m1.getCellsCopy();
    HashMap<String, CellAttr> cells2 = m2.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();

    int x = Math.abs(Math.min(0, d)) + Math.max(x1, x2 + d);
    int y = y1 + y2;
    for(int i = 0; i < x; i++) {
      for(int j = 0; j < y; j++) {
        String coords = new Coords(i, j).getHash();
        if(j < y1) {
          if(i >= Math.abs(Math.min(0, d)) && i < Math.abs(Math.min(0, d)) + x1) {
            String oldCoords = new Coords(i - Math.abs(Math.min(0, d)), j).getHash();
            newCells.put(coords, cells1.get(oldCoords));
          }
          else newCells.put(coords, new CellAttr());
        } else {
          if(i >= Math.max(0, d) && i < Math.max(0, d) + x2) {
            String oldCoords = new Coords(i -  Math.max(0, d), j - y1).getHash();
            newCells.put(coords, cells2.get(oldCoords));
          }
          else newCells.put(coords, new CellAttr());
        }
      }
    }

    return new MapAttr(x, y, newCells);
  }

  public static MapAttr mask(MapAttr m1, MapAttr m2, Integer dx, Integer dy) {
    Integer x1 = m1.getSizeX(), y1 = m1.getSizeY();
    Integer x2 = m2.getSizeX(), y2 = m2.getSizeY();
    HashMap<String, CellAttr> cells1 = m1.getCellsCopy();
    HashMap<String, CellAttr> cells2 = m2.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();

    int x = Math.abs(Math.min(0, dx)) + Math.max(x1, x2 + dx);
    int y = Math.abs(Math.min(0, dy)) + Math.max(y1, y2 + dx);

    for(int i = 0; i < x; i++) {
      for(int j = 0; j < y; j++) {
        String coords = new Coords(i, j).getHash();
        if(i >= Math.max(0, dx) && i < Math.max(0, dx) + x2
          && j >= Math.max(0, dy) && j < Math.max(0, dy) + y2) {
          String oldCoords = new Coords(i -  Math.max(0, dx), j - Math.max(0, dy)).getHash();
          newCells.put(coords, cells2.get(oldCoords));
        } else if (i >= Math.abs(Math.min(0, dx)) && i < Math.abs(Math.min(0, dx)) + x1
          && j >= Math.abs(Math.min(0, dy)) && j < Math.abs(Math.min(0, dy)) + y1) {
          String oldCoords = new Coords(i - Math.abs(Math.min(0, dx)), j - Math.abs(Math.min(0, dy))).getHash();
          newCells.put(coords, cells1.get(oldCoords));
        } else {
          newCells.put(coords, new CellAttr());
        }
      }
    }

    return new MapAttr(x, y, newCells);
  }

  public static MapAttr dropX(MapAttr inner, Integer d) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    if(d < 0 || d >= sizeX) throw new Error("Attempting to drop a row out of bounds");

    for(int i = 0; i < sizeX; i++) {
      if(i == d) continue;
      for(int j = 0; j < sizeY; j++) {
        String coords = new Coords(i > d ? i - 1 : i, j).getHash();
        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));
      }
    }

    return new MapAttr(sizeX - 1, sizeY, newCells);
  }

  public static MapAttr dropY(MapAttr inner, Integer d) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    if(d < 0 || d >= sizeY) throw new Error("Attempting to drop a column out of bounds");

    for(int j = 0; j < sizeY; j++) {
      if(j == d) continue;
      for(int i = 0; i < sizeX; i++) {
        String coords = new Coords(i, j > d ? j - 1 : j).getHash();
        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));
      }
    }

    return new MapAttr(sizeX, sizeY - 1, newCells);
  }

  public static MapAttr insertX(MapAttr inner, Integer d) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    if(d < 0 || d >= sizeX) throw new Error("Attempting to drop a row out of bounds");

    for(int i = 0; i < sizeX; i++) {
      if(i == d) {
        for(int j = 0; j < sizeY; j++) {
          String coords = new Coords(i, j).getHash();
          newCells.put(coords, new CellAttr());
        }
      }
      for(int j = 0; j < sizeY; j++) {
        String coords = new Coords(i >= d ? i + 1 : i, j).getHash();
        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));
      }
    }

    return new MapAttr(sizeX + 1, sizeY, newCells);
  }

  public static MapAttr insertY(MapAttr inner, Integer d) {
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    if(d < 0 || d >= sizeX) throw new Error("Attempting to drop a row out of bounds");

    for(int j = 0; j < sizeY; j++) {
      if(j == d) {
        for(int i = 0; i < sizeX; i++) {
          String coords = new Coords(i, j).getHash();
          newCells.put(coords, new CellAttr());
        }
      }
      for(int i = 0; i < sizeX; i++) {
        String coords = new Coords(i, j >= d ? j + 1 : j).getHash();
        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));
      }
    }

    return new MapAttr(sizeX, sizeY + 1, newCells);
  }

  public static MapAttr createMap(int sizeX, int sizeY, CellAttr cellAttr) {
    HashMap<String, CellAttr> cells = new HashMap<>();
    if(cellAttr == null) cellAttr = new CellAttr();
    for(int x = 0; x < sizeX; x++) {
      for(int y = 0; y < sizeY; y++) {
        cells.put(new Coords(x, y).getHash(), cellAttr);
      }
    }
    return new MapAttr(sizeX, sizeY, cells);
  }

  public static void changeMap(MapAttr mapAttr, CellAttr cellProps, ArrayList<String> coordinates) {
    if(coordinates == null) {
      for (int x = 0; x < mapAttr.getSizeX(); x++) {
        for(int y = 0; y < mapAttr.getSizeY(); y++) {
          mapAttr.setCell(x, y, cellProps);
        }
      }
    }
    else {
      coordinates.forEach(coord -> {
        mapAttr.setCell(coord, cellProps);
      });
    }
  }
}

class _Program3 {
  public static HashMap<String, MapAttr> _body() {
    MapAttr $$$_d = MapOps.createMap(1,1,new CellAttr().addProp("curr","D"));
    MapAttr $$$_c = MapOps.createMap(1,1,new CellAttr().addProp("curr","C"));
    HashMap<String, MapAttr> _export = new HashMap<>();
    _export.put("$$$_d", $$$_d);
    _export.put("$$$_c", $$$_c);
    return _export;
  }
}
class _Program2 {
  private static HashMap<String, MapAttr> imports_Program3 = _Program3._body();
  private static MapAttr $$_d = imports_Program3.get("$$_d");
  private static MapAttr $$_c = imports_Program3.get("$$_c");
  public static HashMap<String, MapAttr> _body() {
    System.out.println($$_d);
    System.out.println($$_c);
    MapAttr $$_a = MapOps.createMap(0,0,null);
    MapAttr $$_e = MapOps.createMap(1,1,null);
    HashMap<String, MapAttr> _export = new HashMap<>();
    _export.put("$$_a", $$_a);
    _export.put("$$_e", $$_e);
    return _export;
  }
}
class _Program1 {
  private static HashMap<String, MapAttr> imports_Program2 = _Program2._body();
  private static MapAttr $_a = imports_Program2.get("$_a");
  private static MapAttr $_e = imports_Program2.get("$_e");
  public static Integer $_b(Integer $$_a,Integer $$_b){
    Integer $$_c = ($$_a + $$_b)
      ;
    return $$_c;
  }
  public static HashMap<String, MapAttr> _body() {
    System.out.println("Calling b in parent");
    System.out.println($_a);
    Integer $_c = 20
      , $_f = 40
      ;
    System.out.println($_b(30,40));
    System.out.println(($_c * $_f));
    MapAttr $_m1 = MapOps.createMap(30,40,new CellAttr().addProp("a", 0).addProp("b",true).addProp("c", "").addProp("d","ABC"));
    MapAttr $_m2 = MapOps.createMap(10,20,null);
    MapOps.joinX($_m1,MapOps.rotateCcw($_m2),$_b(30,40)).print();
    MapOps.changeMap($_m1,new CellAttr().addProp("eff","Hello my prett\\y"),new ArrayList<>(Arrays.asList(new String []{"5.20", "30.0", "10.7"})));
    System.out.println("Map e");
    HashMap<String, MapAttr> _export = new HashMap<>();
    _export.put("$_m1", $_m1);
    _export.put("$_m2", $_m2);
    return _export;
  }
}

public class TestInput {
  public static void main(String[] args) {
    _Program1._body();
  }
}