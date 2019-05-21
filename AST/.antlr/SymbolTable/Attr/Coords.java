package SymbolTable.Attr;

public class Coords {
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
