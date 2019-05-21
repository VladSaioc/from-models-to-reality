package SymbolTable.Attr;

import java.util.ArrayList;
import java.util.HashMap;

public class MapAttr {
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

  public HashMap<String, CellAttr> getCells() {
    return this.cells;
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

  public CellAttr getCell(int x, int y) {
    if (x >= this.sizeX) throw new Error("Attempted to fetch cell outside of map bounds.\n Map horizontal size: " + this.sizeX + "; attempted to get " + x);
    if (y >= this.sizeY) throw new Error("Attempted to fetch cell outside of map bounds.\n Map vertical size: " + this.sizeY + "; attempted to get " + y);
    return this.cells.get(new Coords(x, y).getHash());
  }

  public CellAttr getCell(Coords pair) {
    Integer x = pair.getX();
    Integer y = pair.getY();
    if (x >= this.sizeX) throw new Error("Attempted to fetch cell outside of map bounds.\n Map horizontal size: " + this.sizeX + "; attempted to get " + x);
    if (y >= this.sizeY) throw new Error("Attempted to fetch cell outside of map bounds.\n Map vertical size: " + this.sizeY + "; attempted to get " + y);
    return this.cells.get(pair.getHash());
  }

  public void setCell(int x, int y, CellAttr record) {
    this.cells.put(new Coords(x, y).getHash(), record);
  }

  public void setCell(Coords pair, CellAttr record) {
    this.cells.put(pair.getHash(), record);
  }
}
