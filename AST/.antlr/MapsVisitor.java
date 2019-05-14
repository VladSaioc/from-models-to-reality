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
	 * Visit a parse tree produced by {@link MapsParser#indexedProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedProp(MapsParser.IndexedPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#propChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropChain(MapsParser.PropChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#lAccessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAccessor(MapsParser.LAccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#rAccessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAccessor(MapsParser.RAccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionExpressionChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpressionChain(MapsParser.FunctionExpressionChainContext ctx);
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
	 * Visit a parse tree produced by {@link MapsParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MapsParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(MapsParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#variableChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableChain(MapsParser.VariableChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arrayLiteralChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralChain(MapsParser.ArrayLiteralChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(MapsParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arrayDeclBrackets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclBrackets(MapsParser.ArrayDeclBracketsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(MapsParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#arrayDeclIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclIdentifier(MapsParser.ArrayDeclIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapDeclaration(MapsParser.MapDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#recordDeclarationBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDeclarationBody(MapsParser.RecordDeclarationBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#recordDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDeclaration(MapsParser.RecordDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#variableDeclChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclChain(MapsParser.VariableDeclChainContext ctx);
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
	 * Visit a parse tree produced by {@link MapsParser#negChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegChain(MapsParser.NegChainContext ctx);
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
	 * Visit a parse tree produced by {@link MapsParser#unaryMapOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMapOperand(MapsParser.UnaryMapOperandContext ctx);
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
	 * Visit a parse tree produced by {@link MapsParser#mapQueryChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapQueryChain(MapsParser.MapQueryChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapQuery(MapsParser.MapQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#mapQueryPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapQueryPredicate(MapsParser.MapQueryPredicateContext ctx);
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
	 * Visit a parse tree produced by {@link MapsParser#mapQueryAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapQueryAssignment(MapsParser.MapQueryAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#recordAssignmentBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordAssignmentBody(MapsParser.RecordAssignmentBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#recordAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordAssignment(MapsParser.RecordAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#recordAssignmentChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordAssignmentChain(MapsParser.RecordAssignmentChainContext ctx);
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
	 * Visit a parse tree produced by {@link MapsParser#nonRecordAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonRecordAssignment(MapsParser.NonRecordAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MapsParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHeader(MapsParser.FunctionHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionDeclParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclParams(MapsParser.FunctionDeclParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#functionReturnBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturnBody(MapsParser.FunctionReturnBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MapsParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapsParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(MapsParser.DataTypeContext ctx);
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