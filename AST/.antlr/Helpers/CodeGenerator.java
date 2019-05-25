package Helpers;

import SymbolTable.Attr.CellAttr;
import SymbolTable.Attr.Coords;
import SymbolTable.Attr.MapAttr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class CodeGenerator {
  private static int programCounter = 0;

  private static Stack<String> programNames = new Stack<>();

  public static void openProgram() {
    programCounter++;
    programNames.push("_Program" + programCounter);
  }

  public static void closeProgram() {
    programNames.pop();
  }

  public static String getProgramName() {
    return programNames.peek();
  }

  public static void appendCode(String code) {
    generatedCode += code;
  }

  public static final String classBoilerplate = "import java.util.HashMap;\n" +
    "import java.util.ArrayList;\n" +
    "import java.util.Arrays;\n" +
    "\n" +
    "class CellAttr {\n" +
    "  private ArrayList<String> propNames = new ArrayList<>();\n" +
    "  private HashMap<String, Integer> intProps = new HashMap<>();\n" +
    "  private HashMap<String, String> stringProps = new HashMap<>();\n" +
    "  private HashMap<String, Boolean> boolProps = new HashMap<>();\n" +
    "\n" +
    "  public CellAttr() {}\n" +
    "\n" +
    "  public CellAttr(CellAttr attr) {\n" +
    "    attr.propNames.forEach(x -> {\n" +
    "      this.propNames.add(x);\n" +
    "    });\n" +
    "    attr.intProps.forEach((k, v) -> {\n" +
    "      this.intProps.put(k, v);\n" +
    "    });\n" +
    "    attr.boolProps.forEach((k, v) -> {\n" +
    "      this.boolProps.put(k, v);\n" +
    "    });\n" +
    "    attr.stringProps.forEach((k, v) -> {\n" +
    "      this.stringProps.put(k, v);\n" +
    "    });\n" +
    "  }\n" +
    "\n" +
    "  public <T> CellAttr addProp(String name, T prop) {\n" +
    "    intProps.remove(name);\n" +
    "    stringProps.remove(name);\n" +
    "    boolProps.remove(name);\n" +
    "    if(!propNames.contains(name)) propNames.add(name);\n" +
    "    if(prop instanceof Integer) intProps.put(name, (Integer) prop);\n" +
    "    if(prop instanceof Boolean) boolProps.put(name, (Boolean) prop);\n" +
    "    if(prop instanceof String) stringProps.put(name, (String) prop);\n" +
    "    return this;\n" +
    "  }\n" +
    "\n" +
    "  public HashMap<String, Integer> getIntProps() {\n" +
    "    return this.intProps;\n" +
    "  }\n" +
    "\n" +
    "  public HashMap<String, Boolean> getBoolProps() {\n" +
    "    return this.boolProps;\n" +
    "  }\n" +
    "\n" +
    "  public HashMap<String, String> getStringProps() {\n" +
    "    return this.stringProps;\n" +
    "  }\n" +
    "\n" +
    "  public CellAttr mergeProps(CellAttr cell) {\n" +
    "    cell.getIntProps().forEach((k, v) -> {\n" +
    "      this.addProp(k, v);\n" +
    "    });\n" +
    "    cell.getBoolProps().forEach((k, v) -> {\n" +
    "      this.addProp(k, v);\n" +
    "    });\n" +
    "    cell.getStringProps().forEach((k, v) -> {\n" +
    "      this.addProp(k, v);\n" +
    "    });\n" +
    "    return this;\n" +
    "  }\n" +
    "\n" +
    "  public void print(String coords) {\n" +
    "    String toPrint = coords + \" props: { \";\n" +
    "    for (String propName : propNames) {\n" +
    "      if(this.intProps.containsKey(propName)) toPrint += \"int: \" + propName + \" = \" + this.intProps.get(propName) + \"; \";\n" +
    "      if(this.boolProps.containsKey(propName)) toPrint += \"bool: \" + propName + \" = \" + this.boolProps.get(propName) + \"; \";\n" +
    "      if(this.stringProps.containsKey(propName)) toPrint += \"string: \" + propName + \" = \" + this.stringProps.get(propName) + \"; \";\n" +
    "    }\n" +
    "    toPrint += \"}\";\n" +
    "    System.out.println(toPrint);\n" +
    "  }\n" +
    "}\n" +
    "\n" +
    "class MapAttr {\n" +
    "  private Integer sizeX;\n" +
    "  private Integer sizeY;\n" +
    "  private HashMap<String, CellAttr> cells;\n" +
    "\n" +
    "  public MapAttr(MapAttr n) {\n" +
    "    this.sizeX = n.getSizeX();\n" +
    "    this.sizeY = n.getSizeY();\n" +
    "    this.cells = n.getCellsCopy();\n" +
    "  }\n" +
    "\n" +
    "  public MapAttr(int sizeX, int sizeY, HashMap<String, CellAttr> cells) {\n" +
    "    this.sizeX = sizeX;\n" +
    "    this.sizeY = sizeY;\n" +
    "    this.cells = cells;\n" +
    "  }\n" +
    "\n" +
    "  public Integer getSizeX() {\n" +
    "    return this.sizeX;\n" +
    "  }\n" +
    "\n" +
    "  public Integer getSizeY() {\n" +
    "    return this.sizeY;\n" +
    "  }\n" +
    "\n" +
    "  public HashMap<String, CellAttr> getCellsCopy() {\n" +
    "    HashMap<String, CellAttr> cells = new HashMap<>();\n" +
    "    for(int x = 0; x < sizeX; x++) {\n" +
    "      for(int y = 0; y < sizeY; y++) {\n" +
    "        Coords coords = new Coords(x, y);\n" +
    "        cells.put(coords.getHash(), new CellAttr(this.cells.get(coords.getHash())));\n" +
    "      }\n" +
    "    }\n" +
    "    return cells;\n" +
    "  }\n" +
    "\n" +
    "  public void setCell(int x, int y, CellAttr record) {\n" +
    "    this.cells.put(new Coords(x, y).getHash(), record);\n" +
    "  }\n" +
    "\n" +
    "  public void setCell(String coords, CellAttr record) { this.cells.put(coords, record); }" +
    "\n" +
    "  public void setCell(Coords pair, CellAttr record) {\n" +
    "    this.cells.put(pair.getHash(), record);\n" +
    "  }\n" +
    "\n" +
    "  public void print() {\n" +
    "    System.out.println(\"Map of size: \" + this.sizeX + \" \" + this.sizeY);\n" +
    "    for(int i = 0; i < sizeX; i++) {\n" +
    "      for(int j = 0; j < sizeY; j++) {\n" +
    "        String coords = new Coords(i, j).getHash();\n" +
    "        this.cells.get(coords).print(coords);\n" +
    "      }\n" +
    "    }\n" +
    "  }\n" +
    "}\n" +
    "class Coords {\n" +
    "  private Integer x;\n" +
    "  private Integer y;\n" +
    "\n" +
    "  public Coords(int x, int y) {\n" +
    "    this.x = x;\n" +
    "    this.y = y;\n" +
    "  }\n" +
    "\n" +
    "  public Integer getX() {\n" +
    "    return this.x;\n" +
    "  }\n" +
    "\n" +
    "  public Integer getY() {\n" +
    "    return this.y;\n" +
    "  }\n" +
    "\n" +
    "  public boolean equals(Object coord) {\n" +
    "    if(coord instanceof Coords) {\n" +
    "      return this.x == ((Coords) coord).getX() && this.y == ((Coords) coord).getY();\n" +
    "    }\n" +
    "    else return false;\n" +
    "  }\n" +
    "\n" +
    "  public String getHash() {\n" +
    "    return this.x + \",\" + this.y;\n" +
    "  }\n" +
    "}\n" +
    "\n";

  public static final String mapOperationsBoilerplate = "class MapOps {\n" +
    "  public static MapAttr rotateCcw(MapAttr inner) {\n" +
    "  HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "  HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "  int sizeX = inner.getSizeX() - 1;\n" +
    "  int sizeY = inner.getSizeY() - 1;\n" +
    "\n" +
    "  for(int x = 0; x <= sizeX; x++) {\n" +
    "    for(int y = 0; y <= sizeY; y++) {\n" +
    "      String oldCoords = new Coords(x, y).getHash();\n" +
    "      String newCoords = new Coords(sizeY - y, x).getHash();\n" +
    "      newCells.put(newCoords, oldCells.get(oldCoords));\n" +
    "    }\n" +
    "  }\n" +
    "\n" +
    "  return new MapAttr(\n" +
    "    inner.getSizeY(),\n" +
    "    inner.getSizeX(),\n" +
    "    newCells\n" +
    "  );\n" +
    "}\n" +
    "\n" +
    "  public static MapAttr rotateCw(MapAttr inner) {\n" +
    "    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "    int sizeX = inner.getSizeX() - 1;\n" +
    "    int sizeY = inner.getSizeY() - 1;\n" +
    "\n" +
    "    for(int x = 0; x <= sizeX; x++) {\n" +
    "      for(int y = 0; y <= sizeY; y++) {\n" +
    "        String oldCoords = new Coords(x, y).getHash();\n" +
    "        String newCoords = new Coords(y, sizeX - x).getHash();\n" +
    "        newCells.put(newCoords, oldCells.get(oldCoords));\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(\n" +
    "      inner.getSizeY(),\n" +
    "      inner.getSizeX(),\n" +
    "      newCells\n" +
    "    );\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr mirrorY(MapAttr inner) {\n" +
    "    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "    int sizeX = inner.getSizeX() - 1;\n" +
    "    int sizeY = inner.getSizeY() - 1;\n" +
    "\n" +
    "    for(int x = 0; x <= sizeX; x++) {\n" +
    "      for(int y = 0; y <= sizeY; y++) {\n" +
    "        String oldCoords = new Coords(x, y).getHash();\n" +
    "        String newCoords = new Coords(x, sizeY - y).getHash();\n" +
    "        newCells.put(newCoords, oldCells.get(oldCoords));\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(\n" +
    "      inner.getSizeX(),\n" +
    "      inner.getSizeY(),\n" +
    "      newCells\n" +
    "    );\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr mirrorX(MapAttr inner) {\n" +
    "    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "    int sizeX = inner.getSizeX() - 1;\n" +
    "    int sizeY = inner.getSizeY() - 1;\n" +
    "\n" +
    "    for(int x = 0; x <= sizeX; x++) {\n" +
    "      for(int y = 0; y <= sizeY; y++) {\n" +
    "        String oldCoords = new Coords(x, y).getHash();\n" +
    "        String newCoords = new Coords(sizeX - x, y).getHash();\n" +
    "        newCells.put(newCoords, oldCells.get(oldCoords));\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(\n" +
    "      inner.getSizeX(),\n" +
    "      inner.getSizeY(),\n" +
    "      newCells\n" +
    "    );\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr joinX(MapAttr m1, MapAttr m2, Integer d) {\n" +
    "    Integer x1 = m1.getSizeX(), y1 = m1.getSizeY();\n" +
    "    Integer x2 = m2.getSizeX(), y2 = m2.getSizeY();\n" +
    "    HashMap<String, CellAttr> cells1 = m1.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> cells2 = m2.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "\n" +
    "    int x = x1 + x2;\n" +
    "    int y = Math.abs(Math.min(0, d)) + Math.max(y1, y2 + d);\n" +
    "    for(int i = 0; i < x; i++) {\n" +
    "      for(int j = 0; j < y; j++) {\n" +
    "        String coords = new Coords(i, j).getHash();\n" +
    "        if(i < x1) {\n" +
    "          if(j >= Math.abs(Math.min(0, d)) && j < Math.abs(Math.min(0, d)) + y1) {\n" +
    "            String oldCoords = new Coords(i, j - Math.abs(Math.min(0, d))).getHash();\n" +
    "            newCells.put(coords, cells1.get(oldCoords));\n" +
    "          }\n" +
    "          else newCells.put(coords, new CellAttr());\n" +
    "        } else {\n" +
    "          if(j >= Math.max(0, d) && j < Math.max(0, d) + y2) {\n" +
    "            String oldCoords = new Coords(i - x1, j - Math.max(0, d)).getHash();\n" +
    "            newCells.put(coords, cells2.get(oldCoords));\n" +
    "          }\n" +
    "          else newCells.put(coords, new CellAttr());\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(x, y, newCells);\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr joinY(MapAttr m1, MapAttr m2, Integer d) {\n" +
    "    Integer x1 = m1.getSizeX(), y1 = m1.getSizeY();\n" +
    "    Integer x2 = m2.getSizeX(), y2 = m2.getSizeY();\n" +
    "    HashMap<String, CellAttr> cells1 = m1.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> cells2 = m2.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "\n" +
    "    int x = Math.abs(Math.min(0, d)) + Math.max(x1, x2 + d);\n" +
    "    int y = y1 + y2;\n" +
    "    for(int i = 0; i < x; i++) {\n" +
    "      for(int j = 0; j < y; j++) {\n" +
    "        String coords = new Coords(i, j).getHash();\n" +
    "        if(j < y1) {\n" +
    "          if(i >= Math.abs(Math.min(0, d)) && i < Math.abs(Math.min(0, d)) + x1) {\n" +
    "            String oldCoords = new Coords(i - Math.abs(Math.min(0, d)), j).getHash();\n" +
    "            newCells.put(coords, cells1.get(oldCoords));\n" +
    "          }\n" +
    "          else newCells.put(coords, new CellAttr());\n" +
    "        } else {\n" +
    "          if(i >= Math.max(0, d) && i < Math.max(0, d) + x2) {\n" +
    "            String oldCoords = new Coords(i -  Math.max(0, d), j - y1).getHash();\n" +
    "            newCells.put(coords, cells2.get(oldCoords));\n" +
    "          }\n" +
    "          else newCells.put(coords, new CellAttr());\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(x, y, newCells);\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr mask(MapAttr m1, MapAttr m2, Integer dx, Integer dy) {\n" +
    "    Integer x1 = m1.getSizeX(), y1 = m1.getSizeY();\n" +
    "    Integer x2 = m2.getSizeX(), y2 = m2.getSizeY();\n" +
    "    HashMap<String, CellAttr> cells1 = m1.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> cells2 = m2.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "\n" +
    "    int x = Math.abs(Math.min(0, dx)) + Math.max(x1, x2 + dx);\n" +
    "    int y = Math.abs(Math.min(0, dy)) + Math.max(y1, y2 + dy);\n" +
    "\n" +
    "    for(int i = 0; i < x; i++) {\n" +
    "      for(int j = 0; j < y; j++) {\n" +
    "        String coords = new Coords(i, j).getHash();\n" +
    "        if(i >= Math.max(0, dx) && i < Math.max(0, dx) + x2\n" +
    "          && j >= Math.max(0, dy) && j < Math.max(0, dy) + y2) {\n" +
    "          String oldCoords = new Coords(i -  Math.max(0, dx), j - Math.max(0, dy)).getHash();\n" +
    "          newCells.put(coords, cells2.get(oldCoords));\n" +
    "        } else if (i >= Math.abs(Math.min(0, dx)) && i < Math.abs(Math.min(0, dx)) + x1\n" +
    "          && j >= Math.abs(Math.min(0, dy)) && j < Math.abs(Math.min(0, dy)) + y1) {\n" +
    "          String oldCoords = new Coords(i - Math.abs(Math.min(0, dx)), j - Math.abs(Math.min(0, dy))).getHash();\n" +
    "          newCells.put(coords, cells1.get(oldCoords));\n" +
    "        } else {\n" +
    "          newCells.put(coords, new CellAttr());\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(x, y, newCells);\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr dropX(MapAttr inner, Integer d) {\n" +
    "    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "    Integer sizeX = inner.getSizeX();\n" +
    "    Integer sizeY = inner.getSizeY();\n" +
    "    if(d < 0 || d >= sizeX) throw new Error(\"Attempting to drop a row out of bounds\");\n" +
    "\n" +
    "    for(int i = 0; i < sizeX; i++) {\n" +
    "      if(i == d) continue;\n" +
    "      for(int j = 0; j < sizeY; j++) {\n" +
    "        String coords = new Coords(i > d ? i - 1 : i, j).getHash();\n" +
    "        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(sizeX - 1, sizeY, newCells);\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr dropY(MapAttr inner, Integer d) {\n" +
    "    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "    Integer sizeX = inner.getSizeX();\n" +
    "    Integer sizeY = inner.getSizeY();\n" +
    "    if(d < 0 || d >= sizeY) throw new Error(\"Attempting to drop a column out of bounds\");\n" +
    "\n" +
    "    for(int j = 0; j < sizeY; j++) {\n" +
    "      if(j == d) continue;\n" +
    "      for(int i = 0; i < sizeX; i++) {\n" +
    "        String coords = new Coords(i, j > d ? j - 1 : j).getHash();\n" +
    "        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(sizeX, sizeY - 1, newCells);\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr insertX(MapAttr inner, Integer d) {\n" +
    "    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "    Integer sizeX = inner.getSizeX();\n" +
    "    Integer sizeY = inner.getSizeY();\n" +
    "    if(d < 0 || d >= sizeX) throw new Error(\"Attempting to drop a row out of bounds\");\n" +
    "\n" +
    "    for(int i = 0; i < sizeX; i++) {\n" +
    "      if(i == d) {\n" +
    "        for(int j = 0; j < sizeY; j++) {\n" +
    "          String coords = new Coords(i, j).getHash();\n" +
    "          newCells.put(coords, new CellAttr());\n" +
    "        }\n" +
    "      }\n" +
    "      for(int j = 0; j < sizeY; j++) {\n" +
    "        String coords = new Coords(i >= d ? i + 1 : i, j).getHash();\n" +
    "        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(sizeX + 1, sizeY, newCells);\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr insertY(MapAttr inner, Integer d) {\n" +
    "    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();\n" +
    "    HashMap<String, CellAttr> newCells = new HashMap<>();\n" +
    "    Integer sizeX = inner.getSizeX();\n" +
    "    Integer sizeY = inner.getSizeY();\n" +
    "    if(d < 0 || d >= sizeX) throw new Error(\"Attempting to drop a row out of bounds\");\n" +
    "\n" +
    "    for(int j = 0; j < sizeY; j++) {\n" +
    "      if(j == d) {\n" +
    "        for(int i = 0; i < sizeX; i++) {\n" +
    "          String coords = new Coords(i, j).getHash();\n" +
    "          newCells.put(coords, new CellAttr());\n" +
    "        }\n" +
    "      }\n" +
    "      for(int i = 0; i < sizeX; i++) {\n" +
    "        String coords = new Coords(i, j >= d ? j + 1 : j).getHash();\n" +
    "        newCells.put(coords, oldCells.get(new Coords(i, j).getHash()));\n" +
    "      }\n" +
    "    }\n" +
    "\n" +
    "    return new MapAttr(sizeX, sizeY + 1, newCells);\n" +
    "  }\n" +
    "\n" +
    "  public static MapAttr createMap(int sizeX, int sizeY, CellAttr cellAttr) {\n" +
    "    HashMap<String, CellAttr> cells = new HashMap<>();\n" +
    "    if(cellAttr == null) cellAttr = new CellAttr();\n" +
    "    for(int x = 0; x < sizeX; x++) {\n" +
    "      for(int y = 0; y < sizeY; y++) {\n" +
    "        cells.put(new Coords(x, y).getHash(), cellAttr);\n" +
    "      }\n" +
    "    }\n" +
    "    return new MapAttr(sizeX, sizeY, cells);\n" +
    "  }\n" +
    "\n" +
    "  public static void changeMap(MapAttr mapAttr, CellAttr cellProps, ArrayList<String> coordinates) {\n" +
    "    if(coordinates == null) {\n" +
    "      for (int x = 0; x < mapAttr.getSizeX(); x++) {\n" +
    "        for(int y = 0; y < mapAttr.getSizeY(); y++) {\n" +
    "          mapAttr.setCell(x, y, cellProps);\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "    else {\n" +
    "      coordinates.forEach(coord -> {\n" +
    "        mapAttr.setCell(coord, cellProps);\n" +
    "      });\n" +
    "    }\n" +
    "  }\n" +
    "}\n" +
    "\n";

  public static String generatedCode = "";
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
    int y = Math.abs(Math.min(0, dy)) + Math.max(y1, y2 + dy);

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