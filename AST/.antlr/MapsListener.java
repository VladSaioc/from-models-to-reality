// Generated from ../Maps.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MapsParser}.
 */
public interface MapsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MapsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MapsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MapsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#impexVarChain}.
	 * @param ctx the parse tree
	 */
	void enterImpexVarChain(MapsParser.ImpexVarChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#impexVarChain}.
	 * @param ctx the parse tree
	 */
	void exitImpexVarChain(MapsParser.ImpexVarChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(MapsParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(MapsParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#exports}.
	 * @param ctx the parse tree
	 */
	void enterExports(MapsParser.ExportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#exports}.
	 * @param ctx the parse tree
	 */
	void exitExports(MapsParser.ExportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(MapsParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(MapsParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(MapsParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(MapsParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#functionDefParams}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefParams(MapsParser.FunctionDefParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionDefParams}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefParams(MapsParser.FunctionDefParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(MapsParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(MapsParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#functionParams}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParams(MapsParser.FunctionParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionParams}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParams(MapsParser.FunctionParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MapsParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MapsParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#rAccessor}.
	 * @param ctx the parse tree
	 */
	void enterRAccessor(MapsParser.RAccessorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#rAccessor}.
	 * @param ctx the parse tree
	 */
	void exitRAccessor(MapsParser.RAccessorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MapsParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MapsParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#primitiveDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveDeclaration(MapsParser.PrimitiveDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#primitiveDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveDeclaration(MapsParser.PrimitiveDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#variableChain}.
	 * @param ctx the parse tree
	 */
	void enterVariableChain(MapsParser.VariableChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#variableChain}.
	 * @param ctx the parse tree
	 */
	void exitVariableChain(MapsParser.VariableChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMapDeclaration(MapsParser.MapDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMapDeclaration(MapsParser.MapDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(MapsParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(MapsParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void enterBoolTerm(MapsParser.BoolTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void exitBoolTerm(MapsParser.BoolTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolFactor(MapsParser.BoolFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolFactor(MapsParser.BoolFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(MapsParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(MapsParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#stringTerm}.
	 * @param ctx the parse tree
	 */
	void enterStringTerm(MapsParser.StringTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#stringTerm}.
	 * @param ctx the parse tree
	 */
	void exitStringTerm(MapsParser.StringTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(MapsParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(MapsParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#comparisonTerm}.
	 * @param ctx the parse tree
	 */
	void enterComparisonTerm(MapsParser.ComparisonTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#comparisonTerm}.
	 * @param ctx the parse tree
	 */
	void exitComparisonTerm(MapsParser.ComparisonTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(MapsParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(MapsParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#arithmeticTerm}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticTerm(MapsParser.ArithmeticTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#arithmeticTerm}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticTerm(MapsParser.ArithmeticTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#arithmeticFactor}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticFactor(MapsParser.ArithmeticFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#arithmeticFactor}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticFactor(MapsParser.ArithmeticFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#joinOperator}.
	 * @param ctx the parse tree
	 */
	void enterJoinOperator(MapsParser.JoinOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#joinOperator}.
	 * @param ctx the parse tree
	 */
	void exitJoinOperator(MapsParser.JoinOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#maskOperator}.
	 * @param ctx the parse tree
	 */
	void enterMaskOperator(MapsParser.MaskOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#maskOperator}.
	 * @param ctx the parse tree
	 */
	void exitMaskOperator(MapsParser.MaskOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapUnaryIndexedOperator}.
	 * @param ctx the parse tree
	 */
	void enterMapUnaryIndexedOperator(MapsParser.MapUnaryIndexedOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapUnaryIndexedOperator}.
	 * @param ctx the parse tree
	 */
	void exitMapUnaryIndexedOperator(MapsParser.MapUnaryIndexedOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapUnaryUnindexedOperator}.
	 * @param ctx the parse tree
	 */
	void enterMapUnaryUnindexedOperator(MapsParser.MapUnaryUnindexedOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapUnaryUnindexedOperator}.
	 * @param ctx the parse tree
	 */
	void exitMapUnaryUnindexedOperator(MapsParser.MapUnaryUnindexedOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#unaryMapOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMapOperator(MapsParser.UnaryMapOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#unaryMapOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMapOperator(MapsParser.UnaryMapOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#unaryMapOperation}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMapOperation(MapsParser.UnaryMapOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#unaryMapOperation}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMapOperation(MapsParser.UnaryMapOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#joinExpression}.
	 * @param ctx the parse tree
	 */
	void enterJoinExpression(MapsParser.JoinExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#joinExpression}.
	 * @param ctx the parse tree
	 */
	void exitJoinExpression(MapsParser.JoinExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#maskExpression}.
	 * @param ctx the parse tree
	 */
	void enterMaskExpression(MapsParser.MaskExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#maskExpression}.
	 * @param ctx the parse tree
	 */
	void exitMaskExpression(MapsParser.MaskExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapExpression}.
	 * @param ctx the parse tree
	 */
	void enterMapExpression(MapsParser.MapExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapExpression}.
	 * @param ctx the parse tree
	 */
	void exitMapExpression(MapsParser.MapExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapQuery}.
	 * @param ctx the parse tree
	 */
	void enterMapQuery(MapsParser.MapQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapQuery}.
	 * @param ctx the parse tree
	 */
	void exitMapQuery(MapsParser.MapQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#coordinateChain}.
	 * @param ctx the parse tree
	 */
	void enterCoordinateChain(MapsParser.CoordinateChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#coordinateChain}.
	 * @param ctx the parse tree
	 */
	void exitCoordinateChain(MapsParser.CoordinateChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#coordinates}.
	 * @param ctx the parse tree
	 */
	void enterCoordinates(MapsParser.CoordinatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#coordinates}.
	 * @param ctx the parse tree
	 */
	void exitCoordinates(MapsParser.CoordinatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapPropsAssignment}.
	 * @param ctx the parse tree
	 */
	void enterMapPropsAssignment(MapsParser.MapPropsAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapPropsAssignment}.
	 * @param ctx the parse tree
	 */
	void exitMapPropsAssignment(MapsParser.MapPropsAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapPropsBody}.
	 * @param ctx the parse tree
	 */
	void enterMapPropsBody(MapsParser.MapPropsBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapPropsBody}.
	 * @param ctx the parse tree
	 */
	void exitMapPropsBody(MapsParser.MapPropsBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#mapPropsChain}.
	 * @param ctx the parse tree
	 */
	void enterMapPropsChain(MapsParser.MapPropsChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#mapPropsChain}.
	 * @param ctx the parse tree
	 */
	void exitMapPropsChain(MapsParser.MapPropsChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MapsParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MapsParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MapsParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MapsParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#regularAssignment}.
	 * @param ctx the parse tree
	 */
	void enterRegularAssignment(MapsParser.RegularAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#regularAssignment}.
	 * @param ctx the parse tree
	 */
	void exitRegularAssignment(MapsParser.RegularAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MapsParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MapsParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MapsParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MapsParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MapsParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MapsParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MapsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MapsParser.BlockContext ctx);
}