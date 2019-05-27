package SymbolTable.Attr;

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

  private void checkBounds(int x, int y) {
    if(x < 0 || x >= this.sizeX) throw new Error("Attempting to set a cell out of horizontal bounds: " + x + " should be between 0 and " + (this.sizeX - 1) + "." );
    if(y < 0 || y >= this.sizeY) throw new Error("Attempting to set a cell out of vertical bounds: " + y + " should be between 0 and " + (this.sizeY - 1) + ".");
  }

  public void setCell(int x, int y, CellAttr record) {
    this.checkBounds(x, y);
    this.cells.put(new Coords(x, y).getHash(), record);
  }

  public void setCell(String coords, CellAttr record) {
    this.cells.put(coords, record);
  }

  public void setCell(Coords pair, CellAttr record) {
    this.checkBounds(pair.getX(), pair.getY());
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
