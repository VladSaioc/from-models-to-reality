package ANTLR;

import Nodes.*;
import Nodes.AccessorNodes.*;
import Nodes.ArithmeticNodes.*;
import Nodes.AssignNodes.*;
import Nodes.BlockStatements.*;
import Nodes.BooleanNodes.*;
import Nodes.ComparisonNodes.*;
import Nodes.ControlStatements.*;
import Nodes.FunctionNodes.*;
import Nodes.MapNodes.*;
import Nodes.ImpexNodes.*;
import Nodes.StringNodes.*;

public class BuildASTVisitor extends MapsBaseVisitor<AbstractNode> {
  public AbstractNode visitProgram(MapsParser.ProgramContext ctx) {    
    return new ProgramNode(
      visitFunctions(ctx.functions()),
      visitImports(ctx.imports()),
      visitStatement(ctx.statement()),
      visitExports(ctx.exports())
    );
  }

  public AbstractNode visitFunctions(MapsParser.FunctionsContext ctx) {
    return ctx.functions() == null
    ? null
    : visitFunctionDef(ctx.functionDef())
      .makeSiblings(
        visitFunctions(ctx.functions())
      );
  }

  public AbstractNode visitFunctionDefParams(MapsParser.FunctionDefParamsContext ctx) {      
    return new FunctionParamNode(
      ctx.name.getText(), 
      ctx.primitiveType().getText()
    ).makeSiblings(
      ctx.functionDefParams() == null
      ? null
      : visitFunctionDefParams(ctx.functionDefParams())
    );
  }

  public AbstractNode visitFunctionDef(MapsParser.FunctionDefContext ctx) {
    return new FunctionDefNode(
      ctx.name.getText(),
      ctx.primitiveType().getText(), 
      new FunctionParamsNode(visitFunctionDefParams(ctx.functionDefParams())),
      new FunctionBodyNode(visitStatement(ctx.block().statement())),
      visitExpression(ctx.expression())
    );
  }

  public AbstractNode visitImports(MapsParser.ImportsContext ctx) {      
    return ctx.impexVarChain() == null
      ? null 
      : new ImportNode(
          ctx.path.getText().substring(
            1,
            ctx.path.getText().length() - 1
          ),
          visitImpexVarChain(ctx.impexVarChain())
        ).makeSiblings(
          visitImports(ctx.imports())
        );
  }

  public AbstractNode visitExports(MapsParser.ExportsContext ctx) {      
    return ctx.impexVarChain() == null 
    ? null
    : new ExportNode(
        visitImpexVarChain(ctx.impexVarChain())
      );
  }

  public AbstractNode visitImpexVarChain(MapsParser.ImpexVarChainContext ctx) {      
    return new IdentifierNode(ctx.var.getText())
    .makeSiblings(
      ctx.impexVarChain() == null
      ? null
      : visitImpexVarChain(ctx.impexVarChain())
    );
  }

  public AbstractNode visitRAccessor(MapsParser.RAccessorContext ctx) {      
    return ctx.functionCall() != null
    ? visitFunctionCall(ctx.functionCall())
    : new IdentifierNode(ctx.name.getText());
  }

  public AbstractNode visitFunctionCall(MapsParser.FunctionCallContext ctx) {      
    return new FunctionCallNode(
        ctx.name.getText(),
        visitFunctionParams(ctx.functionParams())
      );
  }

  public AbstractNode visitFunctionParams(MapsParser.FunctionParamsContext ctx) {
    return visitExpression(ctx.expression())
    .makeSiblings(
      ctx.functionParams() == null
      ? null
      : visitFunctionParams(ctx.functionParams())
    );
  }

  public AbstractNode visitDeclaration(MapsParser.DeclarationContext ctx) {      
    if (ctx.primitiveDeclaration() != null) {
      return visitPrimitiveDeclaration(ctx.primitiveDeclaration());
    } if (ctx.mapDeclaration() != null) {
      return visitMapDeclaration(ctx.mapDeclaration());
    }
    throw new Error("Unrecognized declaration type: " + ctx.getText());
  }

  public AbstractNode visitPrimitiveDeclaration(MapsParser.PrimitiveDeclarationContext ctx) {      
    return new PrimitiveDeclarationNode(
      ctx.primitiveType().getText(),
      visitVariableChain(ctx.variableChain())
    );
  }

  public AbstractNode visitVariableChain(MapsParser.VariableChainContext ctx) {      
    return ctx.expression() == null
    ? new IdentifierNode(ctx.var.getText())
      .makeSiblings(
        ctx.variableChain() == null
        ? null
        : visitVariableChain(ctx.variableChain())
      )
    : new AssignNode(
        ctx.var.getText(),
        visitExpression(ctx.expression())
      ).makeSiblings(
        ctx.variableChain() == null
        ? null
        : visitVariableChain(ctx.variableChain())
      );
  }

  public AbstractNode visitMapDeclaration(MapsParser.MapDeclarationContext ctx) {
    return new MapDeclarationNode(
      ctx.var.getText(),
      visitArithmeticExpression(ctx.arithmeticExpression(0)),
      visitArithmeticExpression(ctx.arithmeticExpression(1)),
      ctx.mapPropsBody() == null
      ? null
      : visitMapPropsBody(ctx.mapPropsBody())
    );
  }

  public AbstractNode visitMapPropsBody(MapsParser.MapPropsBodyContext ctx) {      
    return new MapPropsAssignBodyNode(
      visitMapPropsChain(ctx.mapPropsChain())
    );
  }

  public AbstractNode visitMapPropsChain(MapsParser.MapPropsChainContext ctx) {      
    return visitPrimitiveDeclaration(ctx.primitiveDeclaration()) 
    .makeSiblings(
      ctx.mapPropsChain() != null 
      ? visitMapPropsChain(ctx.mapPropsChain())
      : null
    );
  }

  public AbstractNode visitBoolExpression(MapsParser.BoolExpressionContext ctx) {      
    return ctx.boolExpression() != null
    ? new BooleanOrNode(
        visitBoolExpression(ctx.boolExpression()),
        visitBoolTerm(ctx.boolTerm())
      )
    : visitBoolTerm(ctx.boolTerm());
  }

  public AbstractNode visitBoolTerm(MapsParser.BoolTermContext ctx) {      
    return ctx.boolTerm() != null
    ? new BooleanAndNode(
        visitBoolTerm(ctx.boolTerm()),
        visitBoolFactor(ctx.boolFactor())
      )
    : visitBoolFactor(ctx.boolFactor());
  }

  public AbstractNode visitBoolFactor(MapsParser.BoolFactorContext ctx) {
    if(ctx.neg != null) {
      return new BooleanNegateNode(
        visitBoolExpression(ctx.boolExpression())
      );
    }
    if(ctx.comparisonExpression() != null) return visitComparisonExpression(ctx.comparisonExpression());
    if(ctx.boolExpression() != null) return visitBoolExpression(ctx.boolExpression());
    if(ctx.rAccessor() != null) return visitRAccessor(ctx.rAccessor());
    if(ctx.value != null) return new BooleanLiteralNode(Boolean.parseBoolean(ctx.value.getText()));
    throw new Error("Unrecognized boolean factor: " + ctx.getText());
  }

  public AbstractNode visitComparisonExpression(MapsParser.ComparisonExpressionContext ctx) {
    switch (ctx.op.getType()) {
      case MapsLexer.GT: 
        return new ComparisonGtNode(
          visitComparisonTerm(ctx.comparisonTerm(0)),
          visitComparisonTerm(ctx.comparisonTerm(1))
        );
      case MapsLexer.GTE:
        return new ComparisonGteNode(
          visitComparisonTerm(ctx.comparisonTerm(0)),
          visitComparisonTerm(ctx.comparisonTerm(1))
        );
      case MapsLexer.LT:
        return new ComparisonLtNode(
          visitComparisonTerm(ctx.comparisonTerm(0)),
          visitComparisonTerm(ctx.comparisonTerm(1))
        );
      case MapsLexer.LTE:
        return new ComparisonLteNode(
          visitComparisonTerm(ctx.comparisonTerm(0)),
          visitComparisonTerm(ctx.comparisonTerm(1))
        );
      case MapsLexer.EQ:
        return new ComparisonEqNode(
          visitComparisonTerm(ctx.comparisonTerm(0)),
          visitComparisonTerm(ctx.comparisonTerm(1))
        );
      case MapsLexer.NEQ:
        return new ComparisonNeqNode(
          visitComparisonTerm(ctx.comparisonTerm(0)),
          visitComparisonTerm(ctx.comparisonTerm(1))
        );
      default:
        throw new Error("Unrecognized comparison operator: " + ctx.op.getText());
    }
  }

  public AbstractNode visitComparisonTerm(MapsParser.ComparisonTermContext ctx) {
    if(ctx.neg != null) return new BooleanNegateNode(
        visitComparisonTerm(ctx.comparisonTerm())
      );
    if(ctx.rAccessor() != null) return visitRAccessor(ctx.rAccessor());
    if(ctx.BOOL_LITERAL() != null) return new BooleanLiteralNode(Boolean.parseBoolean(ctx.BOOL_LITERAL().getText()));
    if(ctx.arithmeticExpression() != null) return visitArithmeticExpression(ctx.arithmeticExpression());
    if(ctx.stringExpression() != null) return visitStringExpression(ctx.stringExpression());
    if(ctx.boolExpression() != null) return visitBoolExpression(ctx.boolExpression());
    throw new Error("Unrecognized comparison term: " + ctx.getText());
  }

  public AbstractNode visitStringTerm(MapsParser.StringTermContext ctx) {      
    if(ctx.stringExpression() != null) return visitStringExpression(ctx.stringExpression());
    if(ctx.rAccessor() != null) return visitRAccessor(ctx.rAccessor());
    if(ctx.value != null) return new StringLiteralNode(
        ctx.value.getText().substring(
          1,
          ctx.getText().length() - 1
        )
      );
    throw new Error("Unrecognized string term: " + ctx.getText());
  }

  public AbstractNode visitStringExpression(MapsParser.StringExpressionContext ctx) {      
    return ctx.stringExpression() != null
    ? new StringConcatNode(
        visitStringExpression(ctx.stringExpression()),
        visitStringTerm(ctx.stringTerm())
      )
    : visitStringTerm(ctx.stringTerm());
  }

  public AbstractNode visitArithmeticFactor(MapsParser.ArithmeticFactorContext ctx) {
    if(ctx.negated != null) return new ArithmeticNegateNode(visitArithmeticExpression(ctx.arithmeticExpression()));
    if(ctx.arithmeticExpression() != null) return visitArithmeticExpression(ctx.arithmeticExpression());
    if(ctx.rAccessor() != null) return visitRAccessor(ctx.rAccessor());
    if(ctx.value != null) return new IntegerNode(Integer.parseInt(ctx.value.getText()));
    throw new Error("Unrecognized arithmetic factor: " + ctx.getText());
  }

  public AbstractNode visitArithmeticExpression(MapsParser.ArithmeticExpressionContext ctx) {      
    if (ctx.arithmeticExpression() == null) {
      return visitArithmeticTerm(ctx.arithmeticTerm());
    }
    if (ctx.op.getType() == MapsLexer.ADD) {
      return new ArithmeticAddNode(
        visitArithmeticExpression(ctx.arithmeticExpression()),
        visitArithmeticTerm(ctx.arithmeticTerm())
      );
    }
    if (ctx.op.getType() == MapsLexer.SUB) {
      return new ArithmeticSubNode(
        visitArithmeticExpression(ctx.arithmeticExpression()),
        visitArithmeticTerm(ctx.arithmeticTerm())
      );
    }
    throw new Error("Unrecognized arithmetic expression operator: " + ctx.op.getText());
  }

  public AbstractNode visitArithmeticTerm(MapsParser.ArithmeticTermContext ctx) { 
    if (ctx.arithmeticTerm() == null) {
      return visitArithmeticFactor(ctx.arithmeticFactor());
    }
    if (ctx.op.getType() == MapsLexer.MUL) {
      return new ArithmeticMultNode(
        visitArithmeticTerm(ctx.arithmeticTerm()),
        visitArithmeticFactor(ctx.arithmeticFactor())
      );
    }
    if (ctx.op.getType() == MapsLexer.MOD) {
      return new ArithmeticModNode(
        visitArithmeticTerm(ctx.arithmeticTerm()),
        visitArithmeticFactor(ctx.arithmeticFactor())
      );
    }
    if (ctx.op.getType() == MapsLexer.DIV) {
      return new ArithmeticDivNode(
        visitArithmeticTerm(ctx.arithmeticTerm()),
        visitArithmeticFactor(ctx.arithmeticFactor())
      );
    }
    throw new Error("Unrecognized operator: " + ctx.op.getText());
  }

  public AbstractNode visitMapExpression(MapsParser.MapExpressionContext ctx) {      
    return visitJoinExpression(ctx.joinExpression());
  }

  public AbstractNode visitJoinExpression(MapsParser.JoinExpressionContext ctx) {      
    if(ctx.joinExpression() == null) {
      return visitMaskExpression(ctx.maskExpression());
    }
    switch (ctx.joinOperator().op.getType()) {
      case MapsLexer.JOIN_X:
        return new MapJoinXNode(
          visitJoinExpression(ctx.joinExpression()),
          visitMaskExpression(ctx.maskExpression()),
          ctx.joinOperator().arithmeticExpression() == null
          ? null
          : visitArithmeticExpression(
            ctx.joinOperator().arithmeticExpression()
          )
        );
      case MapsLexer.JOIN_Y:
        return new MapJoinYNode(
          visitJoinExpression(ctx.joinExpression()),
          visitMaskExpression(ctx.maskExpression()),
          ctx.joinOperator().arithmeticExpression() == null
          ? null
          : visitArithmeticExpression(
            ctx.joinOperator().arithmeticExpression()
          )
        );
      default:
        throw new Error("Unrecognized Join operator: " + ctx.joinOperator().op.getText());
    }
  }

  public AbstractNode visitMaskExpression(MapsParser.MaskExpressionContext ctx) {      
    if(ctx.maskExpression() == null) {
      return visitUnaryMapOperation(ctx.unaryMapOperation());
    }
    return new MapMaskNode(
      visitMaskExpression(ctx.maskExpression()),
      visitUnaryMapOperation(ctx.unaryMapOperation()),
      ctx.maskOperator().arithmeticExpression(0) == null
        ? null
        : visitArithmeticExpression(ctx.maskOperator().arithmeticExpression(0)),
      ctx.maskOperator().arithmeticExpression(1) == null
        ? null
        : visitArithmeticExpression(ctx.maskOperator().arithmeticExpression(1)
      )
    );
  }

  public AbstractNode visitUnaryMapOperation(MapsParser.UnaryMapOperationContext ctx) {      
    return ctx.unaryMapOperator() != null
    ? ((MapUnaryOperationNode) visitUnaryMapOperator(ctx.unaryMapOperator()))
      .setInner(
        visitJoinExpression(ctx.joinExpression())
      )
    : ctx.joinExpression() != null
    ? visitJoinExpression(ctx.joinExpression()) 
    : new IdentifierNode(ctx.name.getText());
  }

  public AbstractNode visitUnaryMapOperator(MapsParser.UnaryMapOperatorContext ctx) {      
    if(ctx.mapUnaryIndexedOperator() != null) {
      return visitMapUnaryIndexedOperator(ctx.mapUnaryIndexedOperator());
    }
    if(ctx.mapUnaryUnindexedOperator() != null) {
      return visitMapUnaryUnindexedOperator(ctx.mapUnaryUnindexedOperator());
    }
    throw new Error("Unrecognized unary map operator: " + ctx.getText());
  }

  public AbstractNode visitMapUnaryUnindexedOperator(MapsParser.MapUnaryUnindexedOperatorContext ctx) {      
    switch (ctx.op.getType()) {
      case (MapsLexer.ROTATE_CCW):
        return new MapRotateCcwNode();
      case (MapsLexer.ROTATE_CW):
        return new MapRotateCwNode();
      case (MapsLexer.MIRROR_X):
        return new MapMirrorXNode();
      case (MapsLexer.MIRROR_Y):
        return new MapMirrorYNode();
      default:
        throw new Error("Unknown unary map operand: " + ctx.op.getText());
    }
  }

  public AbstractNode visitMapUnaryIndexedOperator(MapsParser.MapUnaryIndexedOperatorContext ctx) {      
    AbstractNode index = visitArithmeticExpression(ctx.arithmeticExpression());
    switch (ctx.op.getType()) {
      case (MapsLexer.DROP_X):
        return new MapDropXNode(index);
      case (MapsLexer.DROP_Y):
        return new MapDropYNode(index);
      case (MapsLexer.INSERT_X):
        return new MapInsertXNode(index);
      case (MapsLexer.INSERT_Y):
        return new MapInsertYNode(index);
      default:
        throw new Error("Unrecognized unary indexed map operator: " + ctx.op.getText());
    }
  }

  public AbstractNode visitMapQuery(MapsParser.MapQueryContext ctx) {      
    return ctx.coordinateChain() == null
    ? null
    : new MapQueryNode( 
        visitCoordinateChain(ctx.coordinateChain())
      );
  }

  public AbstractNode visitCoordinateChain(MapsParser.CoordinateChainContext ctx) {      
    return ctx.coordinateChain() == null
    ? visitCoordinates(ctx.coordinates())
    : visitCoordinates(ctx.coordinates())
      .makeSiblings(visitCoordinateChain(ctx.coordinateChain()));
  }

  public AbstractNode visitCoordinates(MapsParser.CoordinatesContext ctx) {      
    return new CoordinatesNode(
      visitArithmeticExpression(ctx.arithmeticExpression(0)),
      visitArithmeticExpression(ctx.arithmeticExpression(1))
    );
  }

  public AbstractNode visitAssignment(MapsParser.AssignmentContext ctx) {      
    if(ctx.mapPropsAssignment() != null) {
      return visitMapPropsAssignment(ctx.mapPropsAssignment());
    } if (ctx.regularAssignment() != null) {
      return visitRegularAssignment(ctx.regularAssignment());
    }
    throw new Error("Unrecognized assignment: " + ctx.getText());
  }

  public AbstractNode visitRegularAssignment(MapsParser.RegularAssignmentContext ctx) {      
    return new AssignNode(
      ctx.name.getText(), 
      visitExpression(ctx.expression())
    );
  }

  public AbstractNode visitMapPropsAssignment(MapsParser.MapPropsAssignmentContext ctx) {
    return new MapPropsAssignNode(
      ctx.name.getText(), 
      visitMapQuery(ctx.mapQuery()), 
      visitMapPropsBody(ctx.mapPropsBody())
    );
  }

  public AbstractNode visitExpression(MapsParser.ExpressionContext ctx) {      
    if(ctx.arithmeticExpression() != null) {
      return visitArithmeticExpression(ctx.arithmeticExpression());
    } if(ctx.boolExpression() != null) {
      return visitBoolExpression(ctx.boolExpression());
    } if(ctx.comparisonExpression() != null) {
      return visitComparisonExpression(ctx.comparisonExpression());
    } if(ctx.stringExpression() != null) {
      return visitStringExpression(ctx.stringExpression());
    } if(ctx.mapExpression() != null) {
      return visitMapExpression(ctx.mapExpression());
    } 
    throw new Error("Unrecognized expression: " + ctx.getText());
  }

  public AbstractNode visitStatement(MapsParser.StatementContext ctx) {
    if(ctx.declaration() != null) {
      return visitDeclaration(ctx.declaration())
      .makeSiblings(
        visitStatement(ctx.statement())
      );
    } if(ctx.assignment() != null) {
      return visitAssignment(ctx.assignment())
      .makeSiblings(
        visitStatement(ctx.statement())
      );
    } if (ctx.expression() != null) {
      return visitExpression(ctx.expression())
      .makeSiblings(
        visitStatement(ctx.statement())
      );
    } if (ctx.ifStatement() != null) {
      return visitIfStatement(ctx.ifStatement())
      .makeSiblings(
        visitStatement(ctx.statement())
      );
    } if (ctx.whileStatement() != null) {
      return visitWhileStatement(ctx.whileStatement())
      .makeSiblings(
        visitStatement(ctx.statement())
      );
    }
    return null;
  }

  public AbstractNode visitWhileStatement(MapsParser.WhileStatementContext ctx) {      
    return new WhileNode(
      visitBoolExpression(ctx.boolExpression()), 
      visitBlock(ctx.block())
    );
  }

  public AbstractNode visitIfStatement(MapsParser.IfStatementContext ctx) {      
    return new IfNode(
      visitBoolExpression(ctx.boolExpression()),
      visitBlock(ctx.block(0)),
      ctx.block(1) == null
      ? null
      : visitBlock(ctx.block(1))
    );
  }

  public AbstractNode visitBlock(MapsParser.BlockContext ctx) {      
    return new BlockNode(
      visitStatement(ctx.statement())
    );
  }
}