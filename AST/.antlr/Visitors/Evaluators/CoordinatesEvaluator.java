package Visitors.Evaluators;

import Nodes.AbstractNode;
import Nodes.MapNodes.CoordinatesNode;
import Nodes.MapNodes.MapQueryNode;
import SymbolTable.Attr.Coords;
import Visitors.BaseVisitor;

import java.util.ArrayList;

public class CoordinatesEvaluator extends BaseVisitor<ArrayList<Coords>> {
  public ArrayList<Coords> dispatch(AbstractNode n) {
    if(n instanceof MapQueryNode) return visit((MapQueryNode) n);
    if(n instanceof CoordinatesNode) return visit((CoordinatesNode) n);
    visitChildren(n);
    return null;
  }

  public ArrayList<Coords> visit(MapQueryNode n) {
    ArrayList<Coords> coordinates = new ArrayList<>();
    AbstractNode coordNode = n.getCoordinates();
    while(coordNode != null) {
      coordinates.addAll(visit(coordNode));
      coordNode = coordNode.rightSib;
    }
    return coordinates;
  }

  public ArrayList<Coords> visit(CoordinatesNode n) {
    ArithmeticEvaluator arithmeticEvaluator = new ArithmeticEvaluator();
    ArrayList<Coords> coordinate = new ArrayList<>();
    Integer x = arithmeticEvaluator.visit(n.getX());
    Integer y = arithmeticEvaluator.visit(n.getY());
    coordinate.add(new Coords(x, y));
    return coordinate;
  }
}
