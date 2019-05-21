package Visitors.Evaluators;

import Nodes.AbstractNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.MapNodes.*;
import SymbolTable.Attr.CellAttr;
import SymbolTable.Attr.Coords;
import SymbolTable.Attr.MapAttr;
import SymbolTable.SymbolTable;
import SymbolTable.Symbols.MapSymbol;
import Visitors.BaseVisitor;
import java.util.HashMap;

public class MapEvaluator extends BaseVisitor<MapAttr> {
  public MapAttr dispatch(AbstractNode n) {
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    if(n instanceof MapJoinXNode) return visit((MapJoinXNode) n);
    if(n instanceof MapJoinYNode) return visit((MapJoinYNode) n);
    if(n instanceof MapMaskNode) return visit((MapMaskNode) n);
    if(n instanceof MapMirrorXNode) return visit((MapMirrorXNode) n);
    if(n instanceof MapMirrorYNode) return visit((MapMirrorYNode) n);
    if(n instanceof MapRotateCwNode) return visit((MapRotateCwNode) n);
    if(n instanceof MapRotateCcwNode) return visit((MapRotateCcwNode) n);
    if(n instanceof MapDropXNode) return visit((MapDropXNode) n);
    if(n instanceof MapDropYNode) return visit((MapDropYNode) n);
    if(n instanceof MapInsertXNode) return visit((MapInsertXNode) n);
    if(n instanceof MapInsertYNode) return visit((MapInsertYNode) n);
    visitChildren(n);
    return null;
  }

  public MapAttr visit(IdentifierNode n) {
    MapAttr mapAttr = ((MapSymbol) SymbolTable.getSymbol(n.getValue())).attr;
    return new MapAttr(mapAttr);
  }

  public MapAttr visit(MapRotateCcwNode n) {
    MapAttr inner = visit(n.getInner());
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

  public MapAttr visit(MapRotateCwNode n) {
    MapAttr inner = visit(n.getInner());
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

  public MapAttr visit(MapMirrorYNode n) {
    MapAttr inner = visit(n.getInner());
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

  public MapAttr visit(MapMirrorXNode n) {
    MapAttr inner = visit(n.getInner());
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

  public MapAttr visit(MapJoinXNode n) {
    MapAttr m1 = visit(n.getLeft());
    MapAttr m2 = visit(n.getRight());
    Integer d = new ArithmeticEvaluator().visit(n.getDisplacement());
    if(d == null) d = 0;
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

  public MapAttr visit(MapJoinYNode n) {
    MapAttr m1 = visit(n.getLeft());
    MapAttr m2 = visit(n.getRight());
    Integer d = new ArithmeticEvaluator().visit(n.getDisplacement());
    if(d == null) d = 0;
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

  public MapAttr visit(MapMaskNode n) {
    MapAttr m1 = visit(n.getLeft());
    MapAttr m2 = visit(n.getRight());
    ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
    Integer dx = arithmeticEvaluator.visit(n.getX());
    Integer dy = arithmeticEvaluator.visit(n.getY());
    if(dx == null) dx = 0;
    if(dy == null) dy = 0;
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

  public MapAttr visit(MapDropXNode n) {
    MapAttr inner = visit(n.getInner());
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    Integer d = new ArithmeticEvaluator().visit(n.getIndex());
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

  public MapAttr visit(MapDropYNode n) {
    MapAttr inner = visit(n.getInner());
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    Integer d = new ArithmeticEvaluator().visit(n.getIndex());
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

  public MapAttr visit(MapInsertXNode n) {
    MapAttr inner = visit(n.getInner());
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    Integer d = new ArithmeticEvaluator().visit(n.getIndex());
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

  public MapAttr visit(MapInsertYNode n) {
    MapAttr inner = visit(n.getInner());
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX();
    Integer sizeY = inner.getSizeY();
    Integer d = new ArithmeticEvaluator().visit(n.getIndex());
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
}
