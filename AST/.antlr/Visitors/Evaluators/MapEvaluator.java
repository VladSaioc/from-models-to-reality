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
    return ((MapSymbol) SymbolTable.getSymbol(n.getValue())).attr;
  }

  public MapAttr visit(MapJoinXNode n) {
    ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
    Integer displacement = arithmeticEvaluator.visit(n.getDisplacement());
    if(displacement == null) displacement = 0;
    MapAttr m1 = new MapAttr(visit(n.getLeft()));
    MapAttr m2 = new MapAttr(visit(n.getRight()));
   return null;
  }

  public MapAttr visit(MapRotateCcwNode n) {
    MapAttr inner = visit(n.getInner());
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX() - 1;
    Integer sizeY = inner.getSizeY() - 1;

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
    Integer sizeX = inner.getSizeX() - 1;
    Integer sizeY = inner.getSizeY() - 1;

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
    Integer sizeX = inner.getSizeX() - 1;
    Integer sizeY = inner.getSizeY() - 1;

    for(int x = 0; x <= sizeX; x++) {
      for(int y = 0; y <= sizeY; y++) {
        String oldCoords = new Coords(x, y).getHash();
        String newCoords = new Coords(x, sizeY - y).getHash();
        newCells.put(newCoords, oldCells.get(oldCoords));
      }
    }

    return new MapAttr(
      inner.getSizeY(),
      inner.getSizeX(),
      newCells
    );
  }

  public MapAttr visit(MapMirrorXNode n) {
    MapAttr inner = visit(n.getInner());
    HashMap<String, CellAttr> oldCells = inner.getCellsCopy();
    HashMap<String, CellAttr> newCells = new HashMap<>();
    Integer sizeX = inner.getSizeX() - 1;
    Integer sizeY = inner.getSizeY() - 1;

    for(int x = 0; x <= sizeX; x++) {
      for(int y = 0; y <= sizeY; y++) {
        String oldCoords = new Coords(x, y).getHash();
        String newCoords = new Coords(sizeX - x, y).getHash();
        newCells.put(newCoords, oldCells.get(oldCoords));
      }
    }

    return new MapAttr(
      inner.getSizeY(),
      inner.getSizeX(),
      newCells
    );
  }
}
