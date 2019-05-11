import Nodes.*;
import Nodes.AccessorNodes.*;
import Nodes.ArithmeticNodes.*;
import Nodes.ArrayNodes.*;
import Nodes.AssignNodes.*;
import Nodes.BlockStatements.*;
import Nodes.BooleanNodes.*;
import Nodes.ComparisonNodes.*;
import Nodes.ControlStatements.*;
import Nodes.FunctionNodes.*;
import Nodes.MapNodes.*;
import Nodes.ImpexNodes.*;
import Nodes.RecordNodes.*;
import Nodes.StringNodes.*;
import Nodes.TypeNodes.*;

public class BuildAstVisitor extends MapsBaseVisitor<AbstractNode> {
  //
  // Program visit operations
  //
  public AbstractNode visitProgram(MapsParser.ProgramContext ctx) {    
    return new ProgramNode(
      visitImports(ctx.imports()),
      visitStatement(ctx.statement()),
      visitExports(ctx.exports())
    );
  }

  //
  // Import/Export visit operations
  //

  public AbstractNode visitImports(MapsParser.ImportsContext ctx) {      
    return ctx.impexVarChain() == null
    ? null 
    : new ImportNode(
        new PathNode(ctx.path.getText()),
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

  //
  // Accessor visitors.
  //

  public AbstractNode visitIndexedProp(MapsParser.IndexedPropContext ctx) {      
    return new IndexNode(
      visitArithmeticExpression(ctx.arithmeticExpression())
    ).makeSiblings(
      ctx.indexedProp() == null
      ? null
      : visitIndexedProp(ctx.indexedProp())
    );
  }

  public AbstractNode visitPropChain(MapsParser.PropChainContext ctx) {      
    return ctx.indexedProp() == null
    ? new IdentifierNode(ctx.name.getText())
      .makeSiblings(
        ctx.propChain() == null
        ? null
        : visitPropChain(ctx.propChain())
      )
    : visitIndexedProp(ctx.indexedProp())
      .makeSiblings(
        new IdentifierNode(ctx.name.getText())
      ).makeSiblings(
        ctx.propChain() == null
        ? null
        : visitPropChain(ctx.propChain())
      );
  }

  public AbstractNode visitLAccessor(MapsParser.LAccessorContext ctx) {      
    return new LAccessorNode(
      new IdentifierNode(ctx.name.getText()),
      ctx.propChain() == null
      ? null
      : visitPropChain(ctx.propChain())
    );
  }

  public AbstractNode visitRAccessor(MapsParser.RAccessorContext ctx) {      
    return new RAccessorNode(
      visitFunctionCall(ctx.functionCall()),
      ctx.propChain() == null
      ? null
      : visitPropChain(ctx.propChain())
    );
  }

  public AbstractNode visitFunctionCall(MapsParser.FunctionCallContext ctx) {      
    return ctx.functionParams() == null
    ? new IdentifierNode(ctx.name.getText())
    : new FunctionCallNode(
        new IdentifierNode(ctx.name.getText()), 
        visitFunctionParams(ctx.functionParams())
      );
  }

  public AbstractNode visitFunctionParams(MapsParser.FunctionParamsContext ctx) {      
    return ctx.functionExpressionChain() == null
    ? null
    : visitFunctionExpressionChain(ctx.functionExpressionChain());
  }

  public AbstractNode visitFunctionExpressionChain(MapsParser.FunctionExpressionChainContext ctx) {      
    return visitExpression(ctx.expression())
    .makeSiblings(
      ctx.functionExpressionChain() == null
      ? null
      : visitFunctionExpressionChain(ctx.functionExpressionChain())
    );
  }

  //
  // Declaration visitors.
  //

  public AbstractNode visitDeclaration(MapsParser.DeclarationContext ctx) {      
    if (ctx.variableDeclaration() != null) {
      return visitVariableDeclaration(ctx.variableDeclaration());
    } if (ctx.arrayDeclaration() != null) {
      return visitArrayDeclaration(ctx.arrayDeclaration());
    } if (ctx.mapDeclaration() != null) {
      return visitMapDeclaration(ctx.mapDeclaration());
    } if (ctx.recordDeclaration() != null) {
      return visitRecordDeclaration(ctx.recordDeclaration());
    }
    throw new Error("Unrecognized declaration type: " + ctx.getText());
  }

  public AbstractNode visitVariableDeclaration(MapsParser.VariableDeclarationContext ctx) {      
    return new PrimitiveDeclarationNode(
      visitDataType(ctx.dataType()),
      visitVariableChain(ctx.variableChain())
    );
  }

  public AbstractNode visitDataType(MapsParser.DataTypeContext ctx) {      
    switch (ctx.type.getType()) {
      case MapsLexer.BOOLEAN:
        return new TypeNode("boolean");
      case MapsLexer.DOUBLE:
        return new TypeNode("double");
      case MapsLexer.STRING:
        return new TypeNode("string");
      case MapsLexer.INT:
        return new TypeNode("int");
      default:
        throw new Error("Invalid data type " + ctx.type.getText());
    }
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
        new IdentifierNode(ctx.var.getText()),
        visitExpression(ctx.expression())
      ).makeSiblings(
        ctx.variableChain() == null
        ? null
        : visitVariableChain(ctx.variableChain())
      );
  }

  public AbstractNode visitArrayDeclaration(MapsParser.ArrayDeclarationContext ctx) {      
    return new ArrayDeclNode(
      visitDataType(ctx.dataType()),
      visitArrayDeclBrackets(ctx.arrayDeclBrackets()),
      visitArrayDeclIdentifier(ctx.arrayDeclIdentifier())
    );
  }

  public AbstractNode visitArrayDeclIdentifier(MapsParser.ArrayDeclIdentifierContext ctx) {      
    AbstractNode id = new IdentifierNode(ctx.var.getText()); 
    return ctx.expression() != null
    ? new AssignNode(
        id,
        visitExpression(ctx.expression())
      )
    : ctx.arrayLiteral() != null
    ? new AssignNode(
        id,
        visitArrayLiteral(ctx.arrayLiteral())
      )
    : id;
  }

  public AbstractNode visitArrayDeclBrackets(MapsParser.ArrayDeclBracketsContext ctx) {      
    return new ArrayDeclBracketNode()
    .makeSiblings(
      ctx.arrayDeclBrackets() == null
      ? null
      : visitArrayDeclBrackets(ctx.arrayDeclBrackets())
    );
  }

  public AbstractNode visitArrayLiteral(MapsParser.ArrayLiteralContext ctx) {      
    return new ArrayLiteralNode(
      ctx.arrayLiteralChain() == null 
      ? null
      : visitArrayLiteralChain(ctx.arrayLiteralChain())
    );
  }

  public AbstractNode visitArrayLiteralChain(MapsParser.ArrayLiteralChainContext ctx) {      
    return visitExpression(ctx.expression())
    .makeSiblings(
      ctx.arrayLiteralChain() == null
      ? null
      : visitArrayLiteralChain(ctx.arrayLiteralChain())
    );
  }

  public AbstractNode visitMapDeclaration(MapsParser.MapDeclarationContext ctx) {
    return new MapDeclarationNode(
      new IntegerNode(Integer.parseInt(ctx.sizeX.getText())),
      new IntegerNode(Integer.parseInt(ctx.sizeY.getText())),
      new IdentifierNode(ctx.var.getText()),
      ctx.recordDeclarationBody() == null
      ? null
      : visitRecordDeclarationBody(ctx.recordDeclarationBody())
    );
  }

  public AbstractNode visitRecordDeclarationBody(MapsParser.RecordDeclarationBodyContext ctx) {      
    return new RecordDeclBodyNode(
      visitVariableDeclChain(ctx.variableDeclChain())
    );
  }

  public AbstractNode visitVariableDeclChain(MapsParser.VariableDeclChainContext ctx) {      
    return visitVariableDeclaration(ctx.variableDeclaration())
    .makeSiblings(
      ctx.variableDeclChain() != null 
      ? visitVariableDeclChain(ctx.variableDeclChain())
      : null
    );
  }

  public AbstractNode visitRecordDeclaration(MapsParser.RecordDeclarationContext ctx) {      
    return new RecordDeclNode(
      new IdentifierNode(ctx.var.getText()),
      ctx.recordDeclarationBody() == null
      ? null
      : visitRecordDeclarationBody(ctx.recordDeclarationBody())
    );
  }

  public AbstractNode visitBoolExpression(MapsParser.BoolExpressionContext ctx) {      
    return ctx.boolExpression() != null
    ? new BooleanOrNode(
        visitBoolTerm(ctx.boolTerm()),
        visitBoolExpression(ctx.boolExpression())
      )
    : visitBoolTerm(ctx.boolTerm());
  }

  public AbstractNode visitBoolTerm(MapsParser.BoolTermContext ctx) {      
    return ctx.boolTerm() != null
    ? new BooleanAndNode(
        visitBoolFactor(ctx.boolFactor()),
        visitBoolTerm(ctx.boolTerm())
      )
    : visitBoolFactor(ctx.boolFactor());
  }

  public AbstractNode visitNegChain(MapsParser.NegChainContext ctx) {      
    return ctx.negChain() != null
    ? new BooleanNegationNode()
      .makeSiblings(
        visitNegChain(ctx.negChain())
      )
    : null;
  }

  public AbstractNode visitBoolFactor(MapsParser.BoolFactorContext ctx) {      
    if(ctx.comparisonExpression() != null) {
      return visitComparisonExpression(ctx.comparisonExpression());
    }
    AbstractNode negChain = visitNegChain(ctx.negChain());
    if(ctx.boolExpression() != null) {
      return negChain == null
      ? visitBoolExpression(ctx.boolExpression())
      :  new BooleanNegateNode(
        visitBoolExpression(ctx.boolExpression())
      ).addOperation(negChain);
    }
    if(ctx.rAccessor() != null) {
      return negChain == null
        ? visitRAccessor(ctx.rAccessor())
        : new BooleanNegateNode(
        visitRAccessor(ctx.rAccessor())
      ).addOperation(negChain);
    }
    if(ctx.value != null) {
      return negChain == null
        ? new BooleanLiteralNode(Boolean.parseBoolean(ctx.value.getText()))
        : new BooleanNegateNode(
        new BooleanLiteralNode(Boolean.parseBoolean(ctx.value.getText()))
      ).addOperation(negChain);
    }
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
    if(ctx.arithmeticExpression() != null) {
      return visitArithmeticExpression(ctx.arithmeticExpression());
    }
    if(ctx.stringExpression() != null) {
      return visitStringExpression(ctx.stringExpression());
    }
    AbstractNode negChain = visitNegChain(ctx.negChain());
    if(ctx.value != null) {
      return negChain != null
        ? new BooleanNegateNode(
            new BooleanLiteralNode(Boolean.parseBoolean(ctx.value.getText()))
          ).addOperation(negChain)
        : new BooleanLiteralNode(Boolean.parseBoolean(ctx.value.getText()));
    }
    if(ctx.rAccessor() != null) {
      return negChain != null
        ? new BooleanNegateNode(
            visitRAccessor(ctx.rAccessor())
          ).addOperation(negChain)
        : visitRAccessor(ctx.rAccessor());
    }
    if(ctx.boolExpression() != null) {
      return negChain != null
        ? new BooleanNegateNode(visitBoolExpression(ctx.boolExpression()))
        .addOperation(negChain)
        : visitBoolExpression(ctx.boolExpression());
    }
    throw new Error("Unrecognized comparison term: " + ctx.getText());
  }

  public AbstractNode visitStringTerm(MapsParser.StringTermContext ctx) {      
    if(ctx.stringExpression() != null) {
      return visitStringExpression(ctx.stringExpression());
    }
    if(ctx.rAccessor() != null) {
      return visitRAccessor(ctx.rAccessor());
    }
    if(ctx.value != null) {
      return new StringLiteralNode(ctx.value.getText());
    }
    throw new Error("Unrecognized string term: " + ctx.getText());
  }

  public AbstractNode visitStringExpression(MapsParser.StringExpressionContext ctx) {      
    return ctx.stringExpression() != null
    ? new StringConcatNode(
        visitStringTerm(ctx.stringTerm()),
        visitStringExpression(ctx.stringExpression())
      )
    : visitStringTerm(ctx.stringTerm());
  }

  //
  // Arithmetic visitors.
  //

  public AbstractNode visitArithmeticFactor(MapsParser.ArithmeticFactorContext ctx) {      
    if(ctx.arithmeticExpression() != null) {
      return visitArithmeticExpression(ctx.arithmeticExpression());
    } if(ctx.rAccessor() != null) {
      return visitRAccessor(ctx.rAccessor());
    } if(ctx.value != null) {
      if(ctx.value.getType() == MapsLexer.INT_LITERAL) {
        return new IntegerNode(Integer.parseInt(ctx.value.getText()));
      } else if (ctx.value.getType() == MapsLexer.DOUBLE_LITERAL) {
        return new DoubleNode(Double.parseDouble(ctx.value.getText()));
      }
    }
    throw new Error("Unrecognized arithmetic factor: " + ctx.getText());
  }

  public AbstractNode visitArithmeticExpression(MapsParser.ArithmeticExpressionContext ctx) {      
    if (ctx.arithmeticExpression() == null) {
      return visitArithmeticTerm(ctx.arithmeticTerm());
    }
    if (ctx.op.getType() == MapsLexer.ADD) {
      return new ArithmeticAddNode(
        visitArithmeticTerm(ctx.arithmeticTerm()),
        visitArithmeticExpression(ctx.arithmeticExpression())
      );
    }
    if (ctx.op.getType() == MapsLexer.SUB) {
      return new ArithmeticSubNode(
        visitArithmeticTerm(ctx.arithmeticTerm()),
        visitArithmeticExpression(ctx.arithmeticExpression())
      );
    }
    throw new Error("Unrecognized arithmetic expression operator: " + ctx.op.getText());
  }

  public AbstractNode visitArithmeticTerm(MapsParser.ArithmeticTermContext ctx) {      
    if (ctx.arithmeticFactor() == null) {
      return visitArithmeticFactor(ctx.arithmeticFactor());
    }
    if (ctx.op.getType() == MapsLexer.MUL) {
      return new ArithmeticMultNode(
        visitArithmeticFactor(ctx.arithmeticFactor()),
        visitArithmeticTerm(ctx.arithmeticTerm())
      );
    }
    if (ctx.op.getType() == MapsLexer.MOD) {
      return new ArithmeticModNode(
        visitArithmeticFactor(ctx.arithmeticFactor()),
        visitArithmeticTerm(ctx.arithmeticTerm())
      );
    }
    if (ctx.op.getType() == MapsLexer.DIV) {
      return new ArithmeticDivNode(
        visitArithmeticFactor(ctx.arithmeticFactor()),
        visitArithmeticTerm(ctx.arithmeticTerm())
      );
    }
    throw new Error("Unrecognized operator: " + ctx.op.getText());
  }

  //
  // Map visitors.
  //

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
          visitMaskExpression(ctx.maskExpression()),
          visitJoinExpression(ctx.joinExpression()),
          ctx.joinOperator().arithmeticExpression() == null
          ? null
          : visitArithmeticExpression(
            ctx.joinOperator().arithmeticExpression()
          )
        );
      case MapsLexer.JOIN_Y:
        return new MapJoinYNode(
          visitMaskExpression(ctx.maskExpression()),
          visitJoinExpression(ctx.joinExpression()),
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
      visitUnaryMapOperation(ctx.unaryMapOperation()),
      visitMaskExpression(ctx.maskExpression()),
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
    return ctx.unaryMapOperator() == null
    ? visitUnaryMapOperand(ctx.unaryMapOperand())
    : new MapUnaryOperationNode(
        visitUnaryMapOperand(ctx.unaryMapOperand())
      ).addOperation(
        visitUnaryMapOperator(ctx.unaryMapOperator())
      );
  }

  public AbstractNode visitUnaryMapOperand(MapsParser.UnaryMapOperandContext ctx) {      
    if(ctx.joinExpression() != null) {
      return visitJoinExpression(ctx.joinExpression());
    }
    if(ctx.rAccessor() != null) {
      return visitRAccessor(ctx.rAccessor());
    }
    throw new Error("Unrecognized unary map operand: " + ctx.getText());
  }

  public AbstractNode visitUnaryMapOperator(MapsParser.UnaryMapOperatorContext ctx) {      
    if(ctx.mapUnaryIndexedOperator() != null) {
      return visitMapUnaryIndexedOperator(ctx.mapUnaryIndexedOperator())
        .makeSiblings(
          ctx.unaryMapOperator() == null
            ? null
            : visitUnaryMapOperator(ctx.unaryMapOperator())
        );
    }
    if(ctx.mapUnaryUnindexedOperator() != null) {
      return visitMapUnaryUnindexedOperator(ctx.mapUnaryUnindexedOperator())
      .makeSiblings(
        ctx.unaryMapOperator() == null
        ? null
        : visitUnaryMapOperator(ctx.unaryMapOperator())
      );
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

  //
  // Map query visitors.
  //

  public AbstractNode visitMapQuery(MapsParser.MapQueryContext ctx) {      
    return ctx.mapQueryChain() == null
    ? null
    : visitMapQueryChain(ctx.mapQueryChain());
  }

  public AbstractNode visitMapQueryChain(MapsParser.MapQueryChainContext ctx) {      
    return visitMapQueryPredicate(ctx.mapQueryPredicate())
    .makeSiblings(
      ctx.mapQueryChain() == null
      ? null
      : visitMapQueryChain(ctx.mapQueryChain())
    );
  }

  public AbstractNode visitMapQueryPredicate(MapsParser.MapQueryPredicateContext ctx) {      
    return new MapQueryPredicateNode(
      visitBoolExpression(ctx.boolExpression()), 
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
    if(ctx.mapQueryAssignment() != null) {
      return visitMapQueryAssignment(ctx.mapQueryAssignment());
    } if(ctx.recordAssignment() != null) {
      return visitRecordAssignment(ctx.recordAssignment());
    } if (ctx.nonRecordAssignment() != null) {
      return visitNonRecordAssignment(ctx.nonRecordAssignment());
    }
    throw new Error("Unrecognized assignment: " + ctx.getText());
  }

  public AbstractNode visitMapQueryAssignment(MapsParser.MapQueryAssignmentContext ctx) {      
    return new MapQueryAssignmentNode(
      visitLAccessor(ctx.lAccessor()), 
      visitMapQuery(ctx.mapQuery()), 
      visitRecordAssignmentBody(ctx.recordAssignmentBody())
    );
  }

  public AbstractNode visitRecordAssignment(MapsParser.RecordAssignmentContext ctx) {      
    return new RecordAssignNode(
      visitLAccessor(ctx.lAccessor()),
      visitRecordAssignmentBody(ctx.recordAssignmentBody())
    );
  }

  public AbstractNode visitRecordAssignmentBody(MapsParser.RecordAssignmentBodyContext ctx) {      
    return new RecordAssignBodyNode(
      ctx.recordAssignmentChain() == null
      ? null
      : visitRecordAssignmentChain(ctx.recordAssignmentChain())
    );
  }

  public AbstractNode visitRecordAssignmentChain(MapsParser.RecordAssignmentChainContext ctx) {      
    if(ctx.assignment() != null) {
      return visitAssignment(ctx.assignment()).makeSiblings(
        ctx.recordAssignmentChain() == null
          ? null
          : visitRecordAssignmentChain(ctx.recordAssignmentChain())
      );
    }
    if(ctx.variableDeclaration() != null) {
      return visitVariableDeclaration(ctx.variableDeclaration()).makeSiblings(
        ctx.recordAssignmentChain() == null
          ? null
          : visitRecordAssignmentChain(ctx.recordAssignmentChain())
      );
    }
    if(ctx.DELETE() != null) {
      return new RecordDeleteNode(new IdentifierNode(ctx.var.getText())).makeSiblings(
        ctx.recordAssignmentChain() == null
          ? null
          : visitRecordAssignmentChain(ctx.recordAssignmentChain())
      );
    }
    throw new Error("Unrecognized record property operation: " + ctx.getText());
  }

  public AbstractNode visitExpression(MapsParser.ExpressionContext ctx) {      
    if(ctx.arithmeticExpression() != null) {
      return visitArithmeticExpression(ctx.arithmeticExpression());
    } if(ctx.boolExpression() != null) {
      return visitBoolExpression(ctx.boolExpression());
    } if(ctx.mapExpression() != null) {
      return visitMapExpression(ctx.mapExpression());
    } if(ctx.comparisonExpression() != null) {
      return visitComparisonExpression(ctx.comparisonExpression());
    } if(ctx.stringExpression() != null) {
      return visitStringExpression(ctx.stringExpression());
    } throw new Error("Unrecognized expression: " + ctx.getText());
  }

  public AbstractNode visitNonRecordAssignment(MapsParser.NonRecordAssignmentContext ctx) {      
    return new AssignNode(
      visitLAccessor(ctx.lAccessor()), 
      visitExpression(ctx.expression())
    );
  }

  public AbstractNode visitStatement(MapsParser.StatementContext ctx) {      
    if(ctx.declaration() != null) {
      return visitDeclaration(ctx.declaration())
        .makeSiblings(
          ctx.statement() == null
          ? null
          : visitStatement(ctx.statement())
        );
    } if (ctx.expression() != null) {
      return visitExpression(ctx.expression())
      .makeSiblings(
        ctx.statement() == null
        ? null
        : visitStatement(ctx.statement())
      );
    } if (ctx.functionDefinition() != null) {
      return visitFunctionDefinition(ctx.functionDefinition())
      .makeSiblings(
        ctx.statement() == null
        ? null
        : visitStatement(ctx.statement())
      );
    } if (ctx.ifStatement() != null) {
      return visitIfStatement(ctx.ifStatement())
      .makeSiblings(
        ctx.statement() == null
        ? null
        : visitStatement(ctx.statement())
      );
    } if (ctx.whileStatement() != null) {
      return visitWhileStatement(ctx.whileStatement())
      .makeSiblings(
        ctx.statement() == null
        ? null
        : visitStatement(ctx.statement())
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

  public AbstractNode visitFuncDataType(MapsParser.FuncDataTypeContext ctx) {      
    switch (ctx.type.getType()) {
      case MapsLexer.INT:
        return new TypeNode("int");
      case MapsLexer.BOOLEAN:
        return new TypeNode("boolean");
      case MapsLexer.DOUBLE:
        return new TypeNode("double");
      case MapsLexer.MAP:
        return new TypeNode("map");
      case MapsLexer.RECORD:
        return new TypeNode("record");
      case MapsLexer.STRING:
        return new TypeNode("string");
      default:
        throw new Error("Unrecognized function data type: " + ctx.type.getText());
    }
  }

  public AbstractNode visitFunctionHeader(MapsParser.FunctionHeaderContext ctx) {      
    return new FunctionHeaderNode(
      ctx.functionDeclParams() == null
      ? null
      : visitFunctionDeclParams(ctx.functionDeclParams())
    );
  }

  public AbstractNode visitFunctionDeclParams(MapsParser.FunctionDeclParamsContext ctx) {      
    return new FunctionParamNode(
      ctx.name.getText(), 
      visitFuncDataType(ctx.funcDataType())
    ).makeSiblings(
      ctx.functionDeclParams() == null
      ? null
      : visitFunctionDeclParams(ctx.functionDeclParams())
    );
  }

  public AbstractNode visitFunctionDefinition(MapsParser.FunctionDefinitionContext ctx) {      
    return new FunctionDeclNode(
      new IdentifierNode(ctx.name.getText()),
      ctx.funcDataType() == null
      ? null
      : visitFuncDataType(ctx.funcDataType()), 
      visitFunctionHeader(ctx.functionHeader()), 
      new FunctionBodyNode(
        ctx.functionReturnBody() == null
        ? ((BlockNode) visitBlock(ctx.block())).getStatements()
        : visitFunctionReturnBody(ctx.functionReturnBody()), 
        ctx.functionReturnBody() == null
        ? null
        : new FunctionReturnNode(
          visitExpression(ctx.functionReturnBody().returnStatement().expression())
        )
      )
    );
  }
}