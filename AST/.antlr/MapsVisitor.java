// Generated from ../Maps.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MapsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MapsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MapsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MapsParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#impexVarChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpexVarChain(MapsParser.ImpexVarChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(MapsParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#exports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExports(MapsParser.ExportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(MapsParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(MapsParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionDefParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefParams(MapsParser.FunctionDefParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(MapsParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParams(MapsParser.FunctionParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MapsParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#rAccessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAccessor(MapsParser.RAccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MapsParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#primitiveDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveDeclaration(MapsParser.PrimitiveDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#variableChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableChain(MapsParser.VariableChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapDeclaration(MapsParser.MapDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#boolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(MapsParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#boolTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTerm(MapsParser.BoolTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFactor(MapsParser.BoolFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#stringExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(MapsParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#stringTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringTerm(MapsParser.StringTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(MapsParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#comparisonTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonTerm(MapsParser.ComparisonTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(MapsParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arithmeticTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticTerm(MapsParser.ArithmeticTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arithmeticFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticFactor(MapsParser.ArithmeticFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#joinOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinOperator(MapsParser.JoinOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#maskOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaskOperator(MapsParser.MaskOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapUnaryIndexedOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapUnaryIndexedOperator(MapsParser.MapUnaryIndexedOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapUnaryUnindexedOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapUnaryUnindexedOperator(MapsParser.MapUnaryUnindexedOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#unaryMapOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMapOperator(MapsParser.UnaryMapOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#unaryMapOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMapOperation(MapsParser.UnaryMapOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#joinExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinExpression(MapsParser.JoinExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#maskExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaskExpression(MapsParser.MaskExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapExpression(MapsParser.MapExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapQuery(MapsParser.MapQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#coordinateChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinateChain(MapsParser.CoordinateChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#coordinates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinates(MapsParser.CoordinatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapPropsAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapPropsAssignment(MapsParser.MapPropsAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapPropsBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapPropsBody(MapsParser.MapPropsBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapPropsChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapPropsChain(MapsParser.MapPropsChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MapsParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MapsParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#regularAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularAssignment(MapsParser.RegularAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MapsParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MapsParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MapsParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MapsParser.BlockContext ctx);
}