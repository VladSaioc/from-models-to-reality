package Visitors.CodeGeneration;

import Helpers.CodeGenerator;
import Nodes.AbstractNode;
import Nodes.AccessorNodes.IdentifierNode;
import Nodes.MapNodes.*;

public class MapCodeEmitVisitor extends BaseCodeEmitVisitor {
  public Void dispatch(AbstractNode n) {
    if(n instanceof MapDropXNode) return visit((MapDropXNode) n);
    if(n instanceof MapDropYNode) return visit((MapDropYNode) n);
    if(n instanceof MapInsertXNode) return visit((MapInsertXNode) n);
    if(n instanceof MapInsertYNode) return visit((MapInsertYNode) n);
    if(n instanceof MapJoinXNode) return visit((MapJoinXNode) n);
    if(n instanceof MapJoinYNode) return visit((MapJoinYNode) n);
    if(n instanceof MapMaskNode) return visit((MapMaskNode) n);
    if(n instanceof MapMirrorXNode) return visit((MapMirrorXNode) n);
    if(n instanceof MapMirrorYNode) return visit((MapMirrorYNode) n);
    if(n instanceof MapRotateCwNode) return visit((MapRotateCwNode) n);
    if(n instanceof MapRotateCcwNode) return visit((MapRotateCcwNode) n);
    if(n instanceof IdentifierNode) return visit((IdentifierNode) n);
    visitChildren(n);
    return null;
  }

  public Void visit(MapDropXNode n) {
    CodeGenerator.appendCode("MapOps.dropX(");
    visit(n.getInner());
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    arithmVis.visit(n.getIndex());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapDropYNode n) {
    CodeGenerator.appendCode("MapOps.dropY(");
    visit(n.getInner());
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    arithmVis.visit(n.getIndex());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapInsertXNode n) {
    CodeGenerator.appendCode("MapOps.insertX(");
    visit(n.getInner());
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    arithmVis.visit(n.getIndex());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapInsertYNode n) {
    CodeGenerator.appendCode("MapOps.insertY(");
    visit(n.getInner());
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    arithmVis.visit(n.getIndex());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapMirrorXNode n) {
    CodeGenerator.appendCode("MapOps.mirrorX(");
    visit(n.getInner());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapMirrorYNode n) {
    CodeGenerator.appendCode("MapOps.mirrorY(");
    visit(n.getInner());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapRotateCwNode n) {
    CodeGenerator.appendCode("MapOps.rotateCw(");
    visit(n.getInner());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapRotateCcwNode n) {
    CodeGenerator.appendCode("MapOps.rotateCcw(");
    visit(n.getInner());
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapJoinXNode n) {
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    CodeGenerator.appendCode("MapOps.joinX(");
    visit(n.getLeft());
    CodeGenerator.appendCode(",");
    visit(n.getRight());
    CodeGenerator.appendCode(",");
    if(n.getDisplacement() != null) {
      arithmVis.visit(n.getDisplacement());
    } else CodeGenerator.appendCode("0");
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapJoinYNode n) {
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    CodeGenerator.appendCode("MapOps.joinY(");
    visit(n.getLeft());
    CodeGenerator.appendCode(",");
    visit(n.getRight());
    CodeGenerator.appendCode(",");
    if(n.getDisplacement() != null) {
      arithmVis.visit(n.getDisplacement());
    } else CodeGenerator.appendCode("0");
    CodeGenerator.appendCode(")");
    return null;
  }

  public Void visit(MapMaskNode n) {
    ArithmeticCodeEmitVisitor arithmVis = new ArithmeticCodeEmitVisitor();
    CodeGenerator.appendCode("MapOps.mask(");
    visit(n.getLeft());
    CodeGenerator.appendCode(",");
    visit(n.getRight());
    CodeGenerator.appendCode(",");
    if(n.getX() != null) {
      arithmVis.visit(n.getX());
    } else CodeGenerator.appendCode("0");
    CodeGenerator.appendCode(",");
    if(n.getY() != null) {
      arithmVis.visit(n.getY());
    } else CodeGenerator.appendCode("0");
    CodeGenerator.appendCode(")");
    return null;
  }
}
