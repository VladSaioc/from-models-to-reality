// Generated from ../Maps.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, STRING=2, INT=3, MAP=4, DELETE=5, ELSE=6, FOR=7, IF=8, WHILE=9, 
		BREAK=10, EXTEND=11, RETURN=12, IMPORT=13, EXPORT=14, FROM=15, WS=16, 
		INT_LITERAL=17, BOOL_LITERAL=18, STRING_LITERAL=19, NULL=20, JOIN_X=21, 
		JOIN_Y=22, INSERT_X=23, INSERT_Y=24, DROP_X=25, DROP_Y=26, MASK=27, MIRROR_X=28, 
		MIRROR_Y=29, ROTATE_CW=30, ROTATE_CCW=31, IDENTIFIER=32, MLPAREN=33, MRPAREN=34, 
		LPAREN=35, RPAREN=36, LCURLY=37, RCURLY=38, HASH=39, SEMI=40, COMMA=41, 
		DOT=42, COLON=43, ASSIGN=44, GT=45, LT=46, GTE=47, LTE=48, EQ=49, NEQ=50, 
		AND=51, OR=52, NEG=53, ADD=54, SUB=55, MUL=56, DIV=57, MOD=58, CONCAT=59, 
		COMMENT=60, LINE_COMMENT=61;
	public static final int
		RULE_program = 0, RULE_impexVarChain = 1, RULE_imports = 2, RULE_exports = 3, 
		RULE_functions = 4, RULE_functionDef = 5, RULE_functionDefParams = 6, 
		RULE_primitiveType = 7, RULE_functionParams = 8, RULE_functionCall = 9, 
		RULE_rAccessor = 10, RULE_declaration = 11, RULE_primitiveDeclaration = 12, 
		RULE_variableChain = 13, RULE_mapDeclaration = 14, RULE_boolExpression = 15, 
		RULE_boolTerm = 16, RULE_boolFactor = 17, RULE_stringExpression = 18, 
		RULE_stringTerm = 19, RULE_comparisonExpression = 20, RULE_comparisonTerm = 21, 
		RULE_arithmeticExpression = 22, RULE_arithmeticTerm = 23, RULE_arithmeticFactor = 24, 
		RULE_joinOperator = 25, RULE_maskOperator = 26, RULE_mapUnaryIndexedOperator = 27, 
		RULE_mapUnaryUnindexedOperator = 28, RULE_unaryMapOperator = 29, RULE_unaryMapOperation = 30, 
		RULE_joinExpression = 31, RULE_maskExpression = 32, RULE_mapExpression = 33, 
		RULE_mapQuery = 34, RULE_coordinateChain = 35, RULE_coordinates = 36, 
		RULE_mapPropsAssignment = 37, RULE_mapPropsBody = 38, RULE_mapPropsChain = 39, 
		RULE_expression = 40, RULE_assignment = 41, RULE_regularAssignment = 42, 
		RULE_ifStatement = 43, RULE_whileStatement = 44, RULE_statement = 45, 
		RULE_block = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "impexVarChain", "imports", "exports", "functions", "functionDef", 
			"functionDefParams", "primitiveType", "functionParams", "functionCall", 
			"rAccessor", "declaration", "primitiveDeclaration", "variableChain", 
			"mapDeclaration", "boolExpression", "boolTerm", "boolFactor", "stringExpression", 
			"stringTerm", "comparisonExpression", "comparisonTerm", "arithmeticExpression", 
			"arithmeticTerm", "arithmeticFactor", "joinOperator", "maskOperator", 
			"mapUnaryIndexedOperator", "mapUnaryUnindexedOperator", "unaryMapOperator", 
			"unaryMapOperation", "joinExpression", "maskExpression", "mapExpression", 
			"mapQuery", "coordinateChain", "coordinates", "mapPropsAssignment", "mapPropsBody", 
			"mapPropsChain", "expression", "assignment", "regularAssignment", "ifStatement", 
			"whileStatement", "statement", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'boolean'", "'string'", "'int'", "'map'", "'delete'", "'else'", 
			"'for'", "'if'", "'while'", "'break'", "'extend'", "'return'", "'import'", 
			"'export'", "'from'", null, null, null, null, "'null'", "'joinX'", "'joinY'", 
			"'insertX'", "'insertY'", "'dropX'", "'dropY'", "'mask'", "'mirrorX'", 
			"'mirrorY'", "'rotateCw'", "'rotateCcw'", null, "'['", "']'", "'('", 
			"')'", "'{'", "'}'", "'#'", "';'", "','", "'.'", "':'", "'='", "'>'", 
			"'<'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOLEAN", "STRING", "INT", "MAP", "DELETE", "ELSE", "FOR", "IF", 
			"WHILE", "BREAK", "EXTEND", "RETURN", "IMPORT", "EXPORT", "FROM", "WS", 
			"INT_LITERAL", "BOOL_LITERAL", "STRING_LITERAL", "NULL", "JOIN_X", "JOIN_Y", 
			"INSERT_X", "INSERT_Y", "DROP_X", "DROP_Y", "MASK", "MIRROR_X", "MIRROR_Y", 
			"ROTATE_CW", "ROTATE_CCW", "IDENTIFIER", "MLPAREN", "MRPAREN", "LPAREN", 
			"RPAREN", "LCURLY", "RCURLY", "HASH", "SEMI", "COMMA", "DOT", "COLON", 
			"ASSIGN", "GT", "LT", "GTE", "LTE", "EQ", "NEQ", "AND", "OR", "NEG", 
			"ADD", "SUB", "MUL", "DIV", "MOD", "CONCAT", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Maps.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MapsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExportsContext exports() {
			return getRuleContext(ExportsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			functions();
			setState(95);
			imports();
			setState(96);
			statement();
			setState(97);
			exports();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImpexVarChainContext extends ParserRuleContext {
		public Token var;
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public ImpexVarChainContext impexVarChain() {
			return getRuleContext(ImpexVarChainContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public ImpexVarChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impexVarChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterImpexVarChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitImpexVarChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitImpexVarChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImpexVarChainContext impexVarChain() throws RecognitionException {
		ImpexVarChainContext _localctx = new ImpexVarChainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_impexVarChain);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((ImpexVarChainContext)_localctx).var = match(IDENTIFIER);
				setState(100);
				match(COMMA);
				setState(101);
				impexVarChain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((ImpexVarChainContext)_localctx).var = match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportsContext extends ParserRuleContext {
		public Token path;
		public TerminalNode IMPORT() { return getToken(MapsParser.IMPORT, 0); }
		public TerminalNode LCURLY() { return getToken(MapsParser.LCURLY, 0); }
		public ImpexVarChainContext impexVarChain() {
			return getRuleContext(ImpexVarChainContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(MapsParser.RCURLY, 0); }
		public TerminalNode FROM() { return getToken(MapsParser.FROM, 0); }
		public TerminalNode SEMI() { return getToken(MapsParser.SEMI, 0); }
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(MapsParser.STRING_LITERAL, 0); }
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imports);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(IMPORT);
				setState(106);
				match(LCURLY);
				setState(107);
				impexVarChain();
				setState(108);
				match(RCURLY);
				setState(109);
				match(FROM);
				setState(110);
				((ImportsContext)_localctx).path = match(STRING_LITERAL);
				setState(111);
				match(SEMI);
				setState(112);
				imports();
				}
				break;
			case EOF:
			case BOOLEAN:
			case STRING:
			case INT:
			case MAP:
			case IF:
			case WHILE:
			case EXPORT:
			case INT_LITERAL:
			case BOOL_LITERAL:
			case STRING_LITERAL:
			case IDENTIFIER:
			case MLPAREN:
			case LPAREN:
			case NEG:
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportsContext extends ParserRuleContext {
		public TerminalNode EXPORT() { return getToken(MapsParser.EXPORT, 0); }
		public TerminalNode LCURLY() { return getToken(MapsParser.LCURLY, 0); }
		public ImpexVarChainContext impexVarChain() {
			return getRuleContext(ImpexVarChainContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(MapsParser.RCURLY, 0); }
		public TerminalNode SEMI() { return getToken(MapsParser.SEMI, 0); }
		public ExportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterExports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitExports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitExports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportsContext exports() throws RecognitionException {
		ExportsContext _localctx = new ExportsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exports);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(EXPORT);
				setState(118);
				match(LCURLY);
				setState(119);
				impexVarChain();
				setState(120);
				match(RCURLY);
				setState(121);
				match(SEMI);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionsContext extends ParserRuleContext {
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functions);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				functionDef();
				setState(127);
				functions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefContext extends ParserRuleContext {
		public Token name;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public FunctionDefParamsContext functionDefParams() {
			return getRuleContext(FunctionDefParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(MapsParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MapsParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			primitiveType();
			setState(133);
			((FunctionDefContext)_localctx).name = match(IDENTIFIER);
			setState(134);
			match(LPAREN);
			setState(135);
			functionDefParams();
			setState(136);
			match(RPAREN);
			setState(137);
			block();
			setState(138);
			match(RETURN);
			setState(139);
			expression();
			setState(140);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefParamsContext extends ParserRuleContext {
		public Token name;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public FunctionDefParamsContext functionDefParams() {
			return getRuleContext(FunctionDefParamsContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public FunctionDefParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterFunctionDefParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitFunctionDefParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitFunctionDefParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefParamsContext functionDefParams() throws RecognitionException {
		FunctionDefParamsContext _localctx = new FunctionDefParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDefParams);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				primitiveType();
				setState(143);
				((FunctionDefParamsContext)_localctx).name = match(IDENTIFIER);
				setState(144);
				match(COMMA);
				setState(145);
				functionDefParams();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				primitiveType();
				setState(148);
				((FunctionDefParamsContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public Token type;
		public TerminalNode BOOLEAN() { return getToken(MapsParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(MapsParser.STRING, 0); }
		public TerminalNode INT() { return getToken(MapsParser.INT, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((PrimitiveTypeContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << STRING) | (1L << INT))) != 0)) ) {
				((PrimitiveTypeContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParamsContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public FunctionParamsContext functionParams() {
			return getRuleContext(FunctionParamsContext.class,0);
		}
		public FunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterFunctionParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitFunctionParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitFunctionParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamsContext functionParams() throws RecognitionException {
		FunctionParamsContext _localctx = new FunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionParams);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				expression();
				setState(155);
				match(COMMA);
				setState(156);
				functionParams();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public Token name;
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public FunctionParamsContext functionParams() {
			return getRuleContext(FunctionParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((FunctionCallContext)_localctx).name = match(IDENTIFIER);
			setState(162);
			match(LPAREN);
			setState(163);
			functionParams();
			setState(164);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RAccessorContext extends ParserRuleContext {
		public Token name;
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public RAccessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAccessor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterRAccessor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitRAccessor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitRAccessor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAccessorContext rAccessor() throws RecognitionException {
		RAccessorContext _localctx = new RAccessorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rAccessor);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				((RAccessorContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public PrimitiveDeclarationContext primitiveDeclaration() {
			return getRuleContext(PrimitiveDeclarationContext.class,0);
		}
		public MapDeclarationContext mapDeclaration() {
			return getRuleContext(MapDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaration);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				primitiveDeclaration();
				}
				break;
			case MAP:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				mapDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveDeclarationContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public VariableChainContext variableChain() {
			return getRuleContext(VariableChainContext.class,0);
		}
		public PrimitiveDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterPrimitiveDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitPrimitiveDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitPrimitiveDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveDeclarationContext primitiveDeclaration() throws RecognitionException {
		PrimitiveDeclarationContext _localctx = new PrimitiveDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primitiveDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			primitiveType();
			setState(175);
			variableChain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableChainContext extends ParserRuleContext {
		public Token var;
		public TerminalNode ASSIGN() { return getToken(MapsParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public VariableChainContext variableChain() {
			return getRuleContext(VariableChainContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public VariableChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterVariableChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitVariableChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitVariableChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableChainContext variableChain() throws RecognitionException {
		VariableChainContext _localctx = new VariableChainContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableChain);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				((VariableChainContext)_localctx).var = match(IDENTIFIER);
				setState(178);
				match(ASSIGN);
				setState(179);
				expression();
				setState(180);
				match(COMMA);
				setState(181);
				variableChain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				((VariableChainContext)_localctx).var = match(IDENTIFIER);
				setState(184);
				match(ASSIGN);
				setState(185);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				((VariableChainContext)_localctx).var = match(IDENTIFIER);
				setState(187);
				match(COMMA);
				setState(188);
				variableChain();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(189);
				((VariableChainContext)_localctx).var = match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapDeclarationContext extends ParserRuleContext {
		public Token var;
		public TerminalNode MAP() { return getToken(MapsParser.MAP, 0); }
		public TerminalNode MLPAREN() { return getToken(MapsParser.MLPAREN, 0); }
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public TerminalNode MRPAREN() { return getToken(MapsParser.MRPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(MapsParser.ASSIGN, 0); }
		public MapPropsBodyContext mapPropsBody() {
			return getRuleContext(MapPropsBodyContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public MapDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapDeclarationContext mapDeclaration() throws RecognitionException {
		MapDeclarationContext _localctx = new MapDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mapDeclaration);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(MAP);
				setState(193);
				((MapDeclarationContext)_localctx).var = match(IDENTIFIER);
				setState(194);
				match(MLPAREN);
				setState(195);
				arithmeticExpression();
				setState(196);
				match(COMMA);
				setState(197);
				arithmeticExpression();
				setState(198);
				match(MRPAREN);
				setState(199);
				match(ASSIGN);
				setState(200);
				mapPropsBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(MAP);
				setState(203);
				((MapDeclarationContext)_localctx).var = match(IDENTIFIER);
				setState(204);
				match(MLPAREN);
				setState(205);
				arithmeticExpression();
				setState(206);
				match(COMMA);
				setState(207);
				arithmeticExpression();
				setState(208);
				match(MRPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolExpressionContext extends ParserRuleContext {
		public BoolTermContext boolTerm() {
			return getRuleContext(BoolTermContext.class,0);
		}
		public TerminalNode OR() { return getToken(MapsParser.OR, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public BoolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExpressionContext boolExpression() throws RecognitionException {
		BoolExpressionContext _localctx = new BoolExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolExpression);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				boolTerm();
				setState(213);
				match(OR);
				setState(214);
				boolExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				boolTerm();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolTermContext extends ParserRuleContext {
		public BoolFactorContext boolFactor() {
			return getRuleContext(BoolFactorContext.class,0);
		}
		public TerminalNode AND() { return getToken(MapsParser.AND, 0); }
		public BoolTermContext boolTerm() {
			return getRuleContext(BoolTermContext.class,0);
		}
		public BoolTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterBoolTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitBoolTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitBoolTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolTermContext boolTerm() throws RecognitionException {
		BoolTermContext _localctx = new BoolTermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolTerm);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				boolFactor();
				setState(220);
				match(AND);
				setState(221);
				boolTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				boolFactor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolFactorContext extends ParserRuleContext {
		public Token neg;
		public Token value;
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode NEG() { return getToken(MapsParser.NEG, 0); }
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public RAccessorContext rAccessor() {
			return getRuleContext(RAccessorContext.class,0);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(MapsParser.BOOL_LITERAL, 0); }
		public BoolFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterBoolFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitBoolFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitBoolFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolFactorContext boolFactor() throws RecognitionException {
		BoolFactorContext _localctx = new BoolFactorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_boolFactor);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				comparisonExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				((BoolFactorContext)_localctx).neg = match(NEG);
				setState(228);
				boolExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				match(LPAREN);
				setState(230);
				boolExpression();
				setState(231);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				rAccessor();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				((BoolFactorContext)_localctx).value = match(BOOL_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringExpressionContext extends ParserRuleContext {
		public StringTermContext stringTerm() {
			return getRuleContext(StringTermContext.class,0);
		}
		public TerminalNode CONCAT() { return getToken(MapsParser.CONCAT, 0); }
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public StringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringExpressionContext stringExpression() throws RecognitionException {
		StringExpressionContext _localctx = new StringExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stringExpression);
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				stringTerm();
				setState(238);
				match(CONCAT);
				setState(239);
				stringExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				stringTerm();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringTermContext extends ParserRuleContext {
		public Token value;
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public RAccessorContext rAccessor() {
			return getRuleContext(RAccessorContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(MapsParser.STRING_LITERAL, 0); }
		public StringTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterStringTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitStringTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitStringTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringTermContext stringTerm() throws RecognitionException {
		StringTermContext _localctx = new StringTermContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stringTerm);
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(LPAREN);
				setState(245);
				stringExpression();
				setState(246);
				match(RPAREN);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				rAccessor();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				((StringTermContext)_localctx).value = match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonExpressionContext extends ParserRuleContext {
		public Token op;
		public List<ComparisonTermContext> comparisonTerm() {
			return getRuleContexts(ComparisonTermContext.class);
		}
		public ComparisonTermContext comparisonTerm(int i) {
			return getRuleContext(ComparisonTermContext.class,i);
		}
		public TerminalNode GT() { return getToken(MapsParser.GT, 0); }
		public TerminalNode LT() { return getToken(MapsParser.LT, 0); }
		public TerminalNode LTE() { return getToken(MapsParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(MapsParser.GTE, 0); }
		public TerminalNode EQ() { return getToken(MapsParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MapsParser.NEQ, 0); }
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comparisonExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			comparisonTerm();
			setState(253);
			((ComparisonExpressionContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTE) | (1L << LTE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
				((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(254);
			comparisonTerm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonTermContext extends ParserRuleContext {
		public Token neg;
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(MapsParser.BOOL_LITERAL, 0); }
		public RAccessorContext rAccessor() {
			return getRuleContext(RAccessorContext.class,0);
		}
		public ComparisonTermContext comparisonTerm() {
			return getRuleContext(ComparisonTermContext.class,0);
		}
		public TerminalNode NEG() { return getToken(MapsParser.NEG, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public ComparisonTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterComparisonTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitComparisonTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitComparisonTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonTermContext comparisonTerm() throws RecognitionException {
		ComparisonTermContext _localctx = new ComparisonTermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comparisonTerm);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(LPAREN);
				setState(257);
				boolExpression();
				setState(258);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(BOOL_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				rAccessor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				((ComparisonTermContext)_localctx).neg = match(NEG);
				setState(263);
				comparisonTerm();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(264);
				arithmeticExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(265);
				stringExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public Token op;
		public ArithmeticTermContext arithmeticTerm() {
			return getRuleContext(ArithmeticTermContext.class,0);
		}
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(MapsParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MapsParser.SUB, 0); }
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitArithmeticExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arithmeticExpression);
		int _la;
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				arithmeticTerm();
				setState(269);
				((ArithmeticExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ArithmeticExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(270);
				arithmeticExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				arithmeticTerm();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticTermContext extends ParserRuleContext {
		public Token op;
		public ArithmeticFactorContext arithmeticFactor() {
			return getRuleContext(ArithmeticFactorContext.class,0);
		}
		public ArithmeticTermContext arithmeticTerm() {
			return getRuleContext(ArithmeticTermContext.class,0);
		}
		public TerminalNode MUL() { return getToken(MapsParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MapsParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MapsParser.MOD, 0); }
		public ArithmeticTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterArithmeticTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitArithmeticTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitArithmeticTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticTermContext arithmeticTerm() throws RecognitionException {
		ArithmeticTermContext _localctx = new ArithmeticTermContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arithmeticTerm);
		int _la;
		try {
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				arithmeticFactor();
				setState(276);
				((ArithmeticTermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					((ArithmeticTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(277);
				arithmeticTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				arithmeticFactor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticFactorContext extends ParserRuleContext {
		public Token negated;
		public Token value;
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public TerminalNode SUB() { return getToken(MapsParser.SUB, 0); }
		public RAccessorContext rAccessor() {
			return getRuleContext(RAccessorContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(MapsParser.INT_LITERAL, 0); }
		public ArithmeticFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterArithmeticFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitArithmeticFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitArithmeticFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticFactorContext arithmeticFactor() throws RecognitionException {
		ArithmeticFactorContext _localctx = new ArithmeticFactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_arithmeticFactor);
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				match(LPAREN);
				setState(283);
				arithmeticExpression();
				setState(284);
				match(RPAREN);
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				((ArithmeticFactorContext)_localctx).negated = match(SUB);
				setState(287);
				arithmeticExpression();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				rAccessor();
				}
				break;
			case INT_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				((ArithmeticFactorContext)_localctx).value = match(INT_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinOperatorContext extends ParserRuleContext {
		public Token op;
		public TerminalNode MLPAREN() { return getToken(MapsParser.MLPAREN, 0); }
		public TerminalNode HASH() { return getToken(MapsParser.HASH, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode MRPAREN() { return getToken(MapsParser.MRPAREN, 0); }
		public TerminalNode JOIN_X() { return getToken(MapsParser.JOIN_X, 0); }
		public TerminalNode JOIN_Y() { return getToken(MapsParser.JOIN_Y, 0); }
		public JoinOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterJoinOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitJoinOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitJoinOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinOperatorContext joinOperator() throws RecognitionException {
		JoinOperatorContext _localctx = new JoinOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_joinOperator);
		int _la;
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(MLPAREN);
				setState(293);
				((JoinOperatorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==JOIN_X || _la==JOIN_Y) ) {
					((JoinOperatorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(294);
				match(HASH);
				setState(295);
				arithmeticExpression();
				setState(296);
				match(MRPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(MLPAREN);
				setState(299);
				((JoinOperatorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==JOIN_X || _la==JOIN_Y) ) {
					((JoinOperatorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(300);
				match(MRPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaskOperatorContext extends ParserRuleContext {
		public TerminalNode MLPAREN() { return getToken(MapsParser.MLPAREN, 0); }
		public TerminalNode MASK() { return getToken(MapsParser.MASK, 0); }
		public TerminalNode HASH() { return getToken(MapsParser.HASH, 0); }
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public TerminalNode MRPAREN() { return getToken(MapsParser.MRPAREN, 0); }
		public MaskOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maskOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMaskOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMaskOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMaskOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaskOperatorContext maskOperator() throws RecognitionException {
		MaskOperatorContext _localctx = new MaskOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_maskOperator);
		try {
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				match(MLPAREN);
				setState(304);
				match(MASK);
				setState(305);
				match(HASH);
				setState(306);
				arithmeticExpression();
				setState(307);
				match(COMMA);
				setState(308);
				arithmeticExpression();
				setState(309);
				match(MRPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(MLPAREN);
				setState(312);
				match(MASK);
				setState(313);
				match(MRPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapUnaryIndexedOperatorContext extends ParserRuleContext {
		public Token op;
		public TerminalNode MLPAREN() { return getToken(MapsParser.MLPAREN, 0); }
		public TerminalNode HASH() { return getToken(MapsParser.HASH, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode MRPAREN() { return getToken(MapsParser.MRPAREN, 0); }
		public TerminalNode DROP_X() { return getToken(MapsParser.DROP_X, 0); }
		public TerminalNode DROP_Y() { return getToken(MapsParser.DROP_Y, 0); }
		public TerminalNode INSERT_X() { return getToken(MapsParser.INSERT_X, 0); }
		public TerminalNode INSERT_Y() { return getToken(MapsParser.INSERT_Y, 0); }
		public MapUnaryIndexedOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapUnaryIndexedOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapUnaryIndexedOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapUnaryIndexedOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapUnaryIndexedOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapUnaryIndexedOperatorContext mapUnaryIndexedOperator() throws RecognitionException {
		MapUnaryIndexedOperatorContext _localctx = new MapUnaryIndexedOperatorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mapUnaryIndexedOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(MLPAREN);
			setState(317);
			((MapUnaryIndexedOperatorContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INSERT_X) | (1L << INSERT_Y) | (1L << DROP_X) | (1L << DROP_Y))) != 0)) ) {
				((MapUnaryIndexedOperatorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(318);
			match(HASH);
			setState(319);
			arithmeticExpression();
			setState(320);
			match(MRPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapUnaryUnindexedOperatorContext extends ParserRuleContext {
		public Token op;
		public TerminalNode MLPAREN() { return getToken(MapsParser.MLPAREN, 0); }
		public TerminalNode MRPAREN() { return getToken(MapsParser.MRPAREN, 0); }
		public TerminalNode ROTATE_CW() { return getToken(MapsParser.ROTATE_CW, 0); }
		public TerminalNode ROTATE_CCW() { return getToken(MapsParser.ROTATE_CCW, 0); }
		public TerminalNode MIRROR_X() { return getToken(MapsParser.MIRROR_X, 0); }
		public TerminalNode MIRROR_Y() { return getToken(MapsParser.MIRROR_Y, 0); }
		public MapUnaryUnindexedOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapUnaryUnindexedOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapUnaryUnindexedOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapUnaryUnindexedOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapUnaryUnindexedOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapUnaryUnindexedOperatorContext mapUnaryUnindexedOperator() throws RecognitionException {
		MapUnaryUnindexedOperatorContext _localctx = new MapUnaryUnindexedOperatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_mapUnaryUnindexedOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(MLPAREN);
			setState(323);
			((MapUnaryUnindexedOperatorContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIRROR_X) | (1L << MIRROR_Y) | (1L << ROTATE_CW) | (1L << ROTATE_CCW))) != 0)) ) {
				((MapUnaryUnindexedOperatorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(324);
			match(MRPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryMapOperatorContext extends ParserRuleContext {
		public MapUnaryIndexedOperatorContext mapUnaryIndexedOperator() {
			return getRuleContext(MapUnaryIndexedOperatorContext.class,0);
		}
		public MapUnaryUnindexedOperatorContext mapUnaryUnindexedOperator() {
			return getRuleContext(MapUnaryUnindexedOperatorContext.class,0);
		}
		public UnaryMapOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMapOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterUnaryMapOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitUnaryMapOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitUnaryMapOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMapOperatorContext unaryMapOperator() throws RecognitionException {
		UnaryMapOperatorContext _localctx = new UnaryMapOperatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unaryMapOperator);
		try {
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				mapUnaryIndexedOperator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				mapUnaryUnindexedOperator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryMapOperationContext extends ParserRuleContext {
		public Token name;
		public UnaryMapOperatorContext unaryMapOperator() {
			return getRuleContext(UnaryMapOperatorContext.class,0);
		}
		public JoinExpressionContext joinExpression() {
			return getRuleContext(JoinExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public UnaryMapOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMapOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterUnaryMapOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitUnaryMapOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitUnaryMapOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMapOperationContext unaryMapOperation() throws RecognitionException {
		UnaryMapOperationContext _localctx = new UnaryMapOperationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_unaryMapOperation);
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MLPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				unaryMapOperator();
				setState(331);
				joinExpression();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(LPAREN);
				setState(334);
				joinExpression();
				setState(335);
				match(RPAREN);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(337);
				((UnaryMapOperationContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinExpressionContext extends ParserRuleContext {
		public MaskExpressionContext maskExpression() {
			return getRuleContext(MaskExpressionContext.class,0);
		}
		public JoinOperatorContext joinOperator() {
			return getRuleContext(JoinOperatorContext.class,0);
		}
		public JoinExpressionContext joinExpression() {
			return getRuleContext(JoinExpressionContext.class,0);
		}
		public JoinExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterJoinExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitJoinExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitJoinExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinExpressionContext joinExpression() throws RecognitionException {
		JoinExpressionContext _localctx = new JoinExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_joinExpression);
		try {
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				maskExpression();
				setState(341);
				joinOperator();
				setState(342);
				joinExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				maskExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaskExpressionContext extends ParserRuleContext {
		public UnaryMapOperationContext unaryMapOperation() {
			return getRuleContext(UnaryMapOperationContext.class,0);
		}
		public MaskOperatorContext maskOperator() {
			return getRuleContext(MaskOperatorContext.class,0);
		}
		public MaskExpressionContext maskExpression() {
			return getRuleContext(MaskExpressionContext.class,0);
		}
		public MaskExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maskExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMaskExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMaskExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMaskExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaskExpressionContext maskExpression() throws RecognitionException {
		MaskExpressionContext _localctx = new MaskExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_maskExpression);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				unaryMapOperation();
				setState(348);
				maskOperator();
				setState(349);
				maskExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				unaryMapOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapExpressionContext extends ParserRuleContext {
		public JoinExpressionContext joinExpression() {
			return getRuleContext(JoinExpressionContext.class,0);
		}
		public MapExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapExpressionContext mapExpression() throws RecognitionException {
		MapExpressionContext _localctx = new MapExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_mapExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			joinExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapQueryContext extends ParserRuleContext {
		public TerminalNode MLPAREN() { return getToken(MapsParser.MLPAREN, 0); }
		public CoordinateChainContext coordinateChain() {
			return getRuleContext(CoordinateChainContext.class,0);
		}
		public TerminalNode MRPAREN() { return getToken(MapsParser.MRPAREN, 0); }
		public MapQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapQueryContext mapQuery() throws RecognitionException {
		MapQueryContext _localctx = new MapQueryContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mapQuery);
		try {
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MLPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				match(MLPAREN);
				setState(357);
				coordinateChain();
				setState(358);
				match(MRPAREN);
				}
				break;
			case EXTEND:
			case LCURLY:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CoordinateChainContext extends ParserRuleContext {
		public CoordinatesContext coordinates() {
			return getRuleContext(CoordinatesContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public CoordinateChainContext coordinateChain() {
			return getRuleContext(CoordinateChainContext.class,0);
		}
		public CoordinateChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinateChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterCoordinateChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitCoordinateChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitCoordinateChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordinateChainContext coordinateChain() throws RecognitionException {
		CoordinateChainContext _localctx = new CoordinateChainContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_coordinateChain);
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				coordinates();
				setState(364);
				match(COMMA);
				setState(365);
				coordinateChain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
				coordinates();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CoordinatesContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MapsParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public CoordinatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterCoordinates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitCoordinates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitCoordinates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordinatesContext coordinates() throws RecognitionException {
		CoordinatesContext _localctx = new CoordinatesContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_coordinates);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(LPAREN);
			setState(371);
			arithmeticExpression();
			setState(372);
			match(COMMA);
			setState(373);
			arithmeticExpression();
			setState(374);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapPropsAssignmentContext extends ParserRuleContext {
		public Token name;
		public MapQueryContext mapQuery() {
			return getRuleContext(MapQueryContext.class,0);
		}
		public MapPropsBodyContext mapPropsBody() {
			return getRuleContext(MapPropsBodyContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public MapPropsAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapPropsAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapPropsAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapPropsAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapPropsAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapPropsAssignmentContext mapPropsAssignment() throws RecognitionException {
		MapPropsAssignmentContext _localctx = new MapPropsAssignmentContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_mapPropsAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			((MapPropsAssignmentContext)_localctx).name = match(IDENTIFIER);
			setState(377);
			mapQuery();
			setState(378);
			mapPropsBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapPropsBodyContext extends ParserRuleContext {
		public Token extended;
		public TerminalNode LCURLY() { return getToken(MapsParser.LCURLY, 0); }
		public MapPropsChainContext mapPropsChain() {
			return getRuleContext(MapPropsChainContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(MapsParser.RCURLY, 0); }
		public TerminalNode EXTEND() { return getToken(MapsParser.EXTEND, 0); }
		public MapPropsBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapPropsBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapPropsBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapPropsBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapPropsBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapPropsBodyContext mapPropsBody() throws RecognitionException {
		MapPropsBodyContext _localctx = new MapPropsBodyContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_mapPropsBody);
		try {
			setState(389);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTEND:
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				((MapPropsBodyContext)_localctx).extended = match(EXTEND);
				setState(381);
				match(LCURLY);
				setState(382);
				mapPropsChain();
				setState(383);
				match(RCURLY);
				}
				break;
			case LCURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				match(LCURLY);
				setState(386);
				mapPropsChain();
				setState(387);
				match(RCURLY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapPropsChainContext extends ParserRuleContext {
		public PrimitiveDeclarationContext primitiveDeclaration() {
			return getRuleContext(PrimitiveDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MapsParser.SEMI, 0); }
		public MapPropsChainContext mapPropsChain() {
			return getRuleContext(MapPropsChainContext.class,0);
		}
		public MapPropsChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapPropsChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMapPropsChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMapPropsChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitMapPropsChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapPropsChainContext mapPropsChain() throws RecognitionException {
		MapPropsChainContext _localctx = new MapPropsChainContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_mapPropsChain);
		try {
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				primitiveDeclaration();
				setState(392);
				match(SEMI);
				setState(393);
				mapPropsChain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				primitiveDeclaration();
				setState(396);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public MapExpressionContext mapExpression() {
			return getRuleContext(MapExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_expression);
		try {
			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				arithmeticExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				boolExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(402);
				comparisonExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				stringExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				mapExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public RegularAssignmentContext regularAssignment() {
			return getRuleContext(RegularAssignmentContext.class,0);
		}
		public MapPropsAssignmentContext mapPropsAssignment() {
			return getRuleContext(MapPropsAssignmentContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_assignment);
		try {
			setState(409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				regularAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				mapPropsAssignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegularAssignmentContext extends ParserRuleContext {
		public Token name;
		public TerminalNode ASSIGN() { return getToken(MapsParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MapsParser.IDENTIFIER, 0); }
		public RegularAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterRegularAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitRegularAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitRegularAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegularAssignmentContext regularAssignment() throws RecognitionException {
		RegularAssignmentContext _localctx = new RegularAssignmentContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_regularAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			((RegularAssignmentContext)_localctx).name = match(IDENTIFIER);
			setState(412);
			match(ASSIGN);
			setState(413);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MapsParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MapsParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_ifStatement);
		try {
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(415);
				match(IF);
				setState(416);
				match(LPAREN);
				setState(417);
				boolExpression();
				setState(418);
				match(RPAREN);
				setState(419);
				block();
				setState(420);
				match(ELSE);
				setState(421);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(IF);
				setState(424);
				match(LPAREN);
				setState(425);
				boolExpression();
				setState(426);
				match(RPAREN);
				setState(427);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MapsParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MapsParser.LPAREN, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MapsParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(WHILE);
			setState(432);
			match(LPAREN);
			setState(433);
			boolExpression();
			setState(434);
			match(RPAREN);
			setState(435);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MapsParser.SEMI, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_statement);
		try {
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				declaration();
				setState(438);
				match(SEMI);
				setState(439);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(441);
				expression();
				setState(442);
				match(SEMI);
				setState(443);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(445);
				assignment();
				setState(446);
				match(SEMI);
				setState(447);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(449);
				ifStatement();
				setState(450);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(452);
				whileStatement();
				setState(453);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(MapsParser.LCURLY, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(MapsParser.RCURLY, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapsVisitor ) return ((MapsVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(LCURLY);
			setState(459);
			statement();
			setState(460);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u01d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5"+
		"\3j\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4v\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5\177\n\5\3\6\3\6\3\6\3\6\5\6\u0085\n\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0099\n"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00a2\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\5\f\u00ab\n\f\3\r\3\r\5\r\u00af\n\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c1\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00d5\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00dc"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u00e3\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00ee\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u00f5"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00fd\n\25\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u010d\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0114\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u011b"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0125\n\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0130\n\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u013d\n\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\5\37\u014b\n\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \5 \u0155\n \3!\3!\3!\3!\3!\5!\u015c\n!\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u0163\n\"\3#\3#\3$\3$\3$\3$\3$\5$\u016c\n$\3%\3%\3%\3%\3%\5%\u0173"+
		"\n%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0188"+
		"\n(\3)\3)\3)\3)\3)\3)\3)\5)\u0191\n)\3*\3*\3*\3*\3*\5*\u0198\n*\3+\3+"+
		"\5+\u019c\n+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-"+
		"\u01b0\n-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\5/\u01cb\n/\3\60\3\60\3\60\3\60\3\60\2\2\61\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^\2\t\3\2\3\5\3\2/\64\3\289\3\2:<\3\2\27\30\3\2\31\34\3\2\36!\2\u01d6"+
		"\2`\3\2\2\2\4i\3\2\2\2\6u\3\2\2\2\b~\3\2\2\2\n\u0084\3\2\2\2\f\u0086\3"+
		"\2\2\2\16\u0098\3\2\2\2\20\u009a\3\2\2\2\22\u00a1\3\2\2\2\24\u00a3\3\2"+
		"\2\2\26\u00aa\3\2\2\2\30\u00ae\3\2\2\2\32\u00b0\3\2\2\2\34\u00c0\3\2\2"+
		"\2\36\u00d4\3\2\2\2 \u00db\3\2\2\2\"\u00e2\3\2\2\2$\u00ed\3\2\2\2&\u00f4"+
		"\3\2\2\2(\u00fc\3\2\2\2*\u00fe\3\2\2\2,\u010c\3\2\2\2.\u0113\3\2\2\2\60"+
		"\u011a\3\2\2\2\62\u0124\3\2\2\2\64\u012f\3\2\2\2\66\u013c\3\2\2\28\u013e"+
		"\3\2\2\2:\u0144\3\2\2\2<\u014a\3\2\2\2>\u0154\3\2\2\2@\u015b\3\2\2\2B"+
		"\u0162\3\2\2\2D\u0164\3\2\2\2F\u016b\3\2\2\2H\u0172\3\2\2\2J\u0174\3\2"+
		"\2\2L\u017a\3\2\2\2N\u0187\3\2\2\2P\u0190\3\2\2\2R\u0197\3\2\2\2T\u019b"+
		"\3\2\2\2V\u019d\3\2\2\2X\u01af\3\2\2\2Z\u01b1\3\2\2\2\\\u01ca\3\2\2\2"+
		"^\u01cc\3\2\2\2`a\5\n\6\2ab\5\6\4\2bc\5\\/\2cd\5\b\5\2d\3\3\2\2\2ef\7"+
		"\"\2\2fg\7+\2\2gj\5\4\3\2hj\7\"\2\2ie\3\2\2\2ih\3\2\2\2j\5\3\2\2\2kl\7"+
		"\17\2\2lm\7\'\2\2mn\5\4\3\2no\7(\2\2op\7\21\2\2pq\7\25\2\2qr\7*\2\2rs"+
		"\5\6\4\2sv\3\2\2\2tv\3\2\2\2uk\3\2\2\2ut\3\2\2\2v\7\3\2\2\2wx\7\20\2\2"+
		"xy\7\'\2\2yz\5\4\3\2z{\7(\2\2{|\7*\2\2|\177\3\2\2\2}\177\3\2\2\2~w\3\2"+
		"\2\2~}\3\2\2\2\177\t\3\2\2\2\u0080\u0081\5\f\7\2\u0081\u0082\5\n\6\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0080\3\2\2\2\u0084\u0083\3\2"+
		"\2\2\u0085\13\3\2\2\2\u0086\u0087\5\20\t\2\u0087\u0088\7\"\2\2\u0088\u0089"+
		"\7%\2\2\u0089\u008a\5\16\b\2\u008a\u008b\7&\2\2\u008b\u008c\5^\60\2\u008c"+
		"\u008d\7\16\2\2\u008d\u008e\5R*\2\u008e\u008f\7*\2\2\u008f\r\3\2\2\2\u0090"+
		"\u0091\5\20\t\2\u0091\u0092\7\"\2\2\u0092\u0093\7+\2\2\u0093\u0094\5\16"+
		"\b\2\u0094\u0099\3\2\2\2\u0095\u0096\5\20\t\2\u0096\u0097\7\"\2\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0095\3\2\2\2\u0099\17\3\2\2"+
		"\2\u009a\u009b\t\2\2\2\u009b\21\3\2\2\2\u009c\u009d\5R*\2\u009d\u009e"+
		"\7+\2\2\u009e\u009f\5\22\n\2\u009f\u00a2\3\2\2\2\u00a0\u00a2\5R*\2\u00a1"+
		"\u009c\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\23\3\2\2\2\u00a3\u00a4\7\"\2"+
		"\2\u00a4\u00a5\7%\2\2\u00a5\u00a6\5\22\n\2\u00a6\u00a7\7&\2\2\u00a7\25"+
		"\3\2\2\2\u00a8\u00ab\5\24\13\2\u00a9\u00ab\7\"\2\2\u00aa\u00a8\3\2\2\2"+
		"\u00aa\u00a9\3\2\2\2\u00ab\27\3\2\2\2\u00ac\u00af\5\32\16\2\u00ad\u00af"+
		"\5\36\20\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\31\3\2\2\2\u00b0"+
		"\u00b1\5\20\t\2\u00b1\u00b2\5\34\17\2\u00b2\33\3\2\2\2\u00b3\u00b4\7\""+
		"\2\2\u00b4\u00b5\7.\2\2\u00b5\u00b6\5R*\2\u00b6\u00b7\7+\2\2\u00b7\u00b8"+
		"\5\34\17\2\u00b8\u00c1\3\2\2\2\u00b9\u00ba\7\"\2\2\u00ba\u00bb\7.\2\2"+
		"\u00bb\u00c1\5R*\2\u00bc\u00bd\7\"\2\2\u00bd\u00be\7+\2\2\u00be\u00c1"+
		"\5\34\17\2\u00bf\u00c1\7\"\2\2\u00c0\u00b3\3\2\2\2\u00c0\u00b9\3\2\2\2"+
		"\u00c0\u00bc\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\35\3\2\2\2\u00c2\u00c3"+
		"\7\6\2\2\u00c3\u00c4\7\"\2\2\u00c4\u00c5\7#\2\2\u00c5\u00c6\5.\30\2\u00c6"+
		"\u00c7\7+\2\2\u00c7\u00c8\5.\30\2\u00c8\u00c9\7$\2\2\u00c9\u00ca\7.\2"+
		"\2\u00ca\u00cb\5N(\2\u00cb\u00d5\3\2\2\2\u00cc\u00cd\7\6\2\2\u00cd\u00ce"+
		"\7\"\2\2\u00ce\u00cf\7#\2\2\u00cf\u00d0\5.\30\2\u00d0\u00d1\7+\2\2\u00d1"+
		"\u00d2\5.\30\2\u00d2\u00d3\7$\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00c2\3\2"+
		"\2\2\u00d4\u00cc\3\2\2\2\u00d5\37\3\2\2\2\u00d6\u00d7\5\"\22\2\u00d7\u00d8"+
		"\7\66\2\2\u00d8\u00d9\5 \21\2\u00d9\u00dc\3\2\2\2\u00da\u00dc\5\"\22\2"+
		"\u00db\u00d6\3\2\2\2\u00db\u00da\3\2\2\2\u00dc!\3\2\2\2\u00dd\u00de\5"+
		"$\23\2\u00de\u00df\7\65\2\2\u00df\u00e0\5\"\22\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00e3\5$\23\2\u00e2\u00dd\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3#\3\2\2\2"+
		"\u00e4\u00ee\5*\26\2\u00e5\u00e6\7\67\2\2\u00e6\u00ee\5 \21\2\u00e7\u00e8"+
		"\7%\2\2\u00e8\u00e9\5 \21\2\u00e9\u00ea\7&\2\2\u00ea\u00ee\3\2\2\2\u00eb"+
		"\u00ee\5\26\f\2\u00ec\u00ee\7\24\2\2\u00ed\u00e4\3\2\2\2\u00ed\u00e5\3"+
		"\2\2\2\u00ed\u00e7\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"%\3\2\2\2\u00ef\u00f0\5(\25\2\u00f0\u00f1\7=\2\2\u00f1\u00f2\5&\24\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f5\5(\25\2\u00f4\u00ef\3\2\2\2\u00f4\u00f3\3\2"+
		"\2\2\u00f5\'\3\2\2\2\u00f6\u00f7\7%\2\2\u00f7\u00f8\5&\24\2\u00f8\u00f9"+
		"\7&\2\2\u00f9\u00fd\3\2\2\2\u00fa\u00fd\5\26\f\2\u00fb\u00fd\7\25\2\2"+
		"\u00fc\u00f6\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd)\3"+
		"\2\2\2\u00fe\u00ff\5,\27\2\u00ff\u0100\t\3\2\2\u0100\u0101\5,\27\2\u0101"+
		"+\3\2\2\2\u0102\u0103\7%\2\2\u0103\u0104\5 \21\2\u0104\u0105\7&\2\2\u0105"+
		"\u010d\3\2\2\2\u0106\u010d\7\24\2\2\u0107\u010d\5\26\f\2\u0108\u0109\7"+
		"\67\2\2\u0109\u010d\5,\27\2\u010a\u010d\5.\30\2\u010b\u010d\5&\24\2\u010c"+
		"\u0102\3\2\2\2\u010c\u0106\3\2\2\2\u010c\u0107\3\2\2\2\u010c\u0108\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d-\3\2\2\2\u010e\u010f"+
		"\5\60\31\2\u010f\u0110\t\4\2\2\u0110\u0111\5.\30\2\u0111\u0114\3\2\2\2"+
		"\u0112\u0114\5\60\31\2\u0113\u010e\3\2\2\2\u0113\u0112\3\2\2\2\u0114/"+
		"\3\2\2\2\u0115\u0116\5\62\32\2\u0116\u0117\t\5\2\2\u0117\u0118\5\60\31"+
		"\2\u0118\u011b\3\2\2\2\u0119\u011b\5\62\32\2\u011a\u0115\3\2\2\2\u011a"+
		"\u0119\3\2\2\2\u011b\61\3\2\2\2\u011c\u011d\7%\2\2\u011d\u011e\5.\30\2"+
		"\u011e\u011f\7&\2\2\u011f\u0125\3\2\2\2\u0120\u0121\79\2\2\u0121\u0125"+
		"\5.\30\2\u0122\u0125\5\26\f\2\u0123\u0125\7\23\2\2\u0124\u011c\3\2\2\2"+
		"\u0124\u0120\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125\63"+
		"\3\2\2\2\u0126\u0127\7#\2\2\u0127\u0128\t\6\2\2\u0128\u0129\7)\2\2\u0129"+
		"\u012a\5.\30\2\u012a\u012b\7$\2\2\u012b\u0130\3\2\2\2\u012c\u012d\7#\2"+
		"\2\u012d\u012e\t\6\2\2\u012e\u0130\7$\2\2\u012f\u0126\3\2\2\2\u012f\u012c"+
		"\3\2\2\2\u0130\65\3\2\2\2\u0131\u0132\7#\2\2\u0132\u0133\7\35\2\2\u0133"+
		"\u0134\7)\2\2\u0134\u0135\5.\30\2\u0135\u0136\7+\2\2\u0136\u0137\5.\30"+
		"\2\u0137\u0138\7$\2\2\u0138\u013d\3\2\2\2\u0139\u013a\7#\2\2\u013a\u013b"+
		"\7\35\2\2\u013b\u013d\7$\2\2\u013c\u0131\3\2\2\2\u013c\u0139\3\2\2\2\u013d"+
		"\67\3\2\2\2\u013e\u013f\7#\2\2\u013f\u0140\t\7\2\2\u0140\u0141\7)\2\2"+
		"\u0141\u0142\5.\30\2\u0142\u0143\7$\2\2\u01439\3\2\2\2\u0144\u0145\7#"+
		"\2\2\u0145\u0146\t\b\2\2\u0146\u0147\7$\2\2\u0147;\3\2\2\2\u0148\u014b"+
		"\58\35\2\u0149\u014b\5:\36\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b"+
		"=\3\2\2\2\u014c\u014d\5<\37\2\u014d\u014e\5@!\2\u014e\u0155\3\2\2\2\u014f"+
		"\u0150\7%\2\2\u0150\u0151\5@!\2\u0151\u0152\7&\2\2\u0152\u0155\3\2\2\2"+
		"\u0153\u0155\7\"\2\2\u0154\u014c\3\2\2\2\u0154\u014f\3\2\2\2\u0154\u0153"+
		"\3\2\2\2\u0155?\3\2\2\2\u0156\u0157\5B\"\2\u0157\u0158\5\64\33\2\u0158"+
		"\u0159\5@!\2\u0159\u015c\3\2\2\2\u015a\u015c\5B\"\2\u015b\u0156\3\2\2"+
		"\2\u015b\u015a\3\2\2\2\u015cA\3\2\2\2\u015d\u015e\5> \2\u015e\u015f\5"+
		"\66\34\2\u015f\u0160\5B\"\2\u0160\u0163\3\2\2\2\u0161\u0163\5> \2\u0162"+
		"\u015d\3\2\2\2\u0162\u0161\3\2\2\2\u0163C\3\2\2\2\u0164\u0165\5@!\2\u0165"+
		"E\3\2\2\2\u0166\u0167\7#\2\2\u0167\u0168\5H%\2\u0168\u0169\7$\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0166\3\2\2\2\u016b\u016a\3\2"+
		"\2\2\u016cG\3\2\2\2\u016d\u016e\5J&\2\u016e\u016f\7+\2\2\u016f\u0170\5"+
		"H%\2\u0170\u0173\3\2\2\2\u0171\u0173\5J&\2\u0172\u016d\3\2\2\2\u0172\u0171"+
		"\3\2\2\2\u0173I\3\2\2\2\u0174\u0175\7%\2\2\u0175\u0176\5.\30\2\u0176\u0177"+
		"\7+\2\2\u0177\u0178\5.\30\2\u0178\u0179\7&\2\2\u0179K\3\2\2\2\u017a\u017b"+
		"\7\"\2\2\u017b\u017c\5F$\2\u017c\u017d\5N(\2\u017dM\3\2\2\2\u017e\u017f"+
		"\7\r\2\2\u017f\u0180\7\'\2\2\u0180\u0181\5P)\2\u0181\u0182\7(\2\2\u0182"+
		"\u0188\3\2\2\2\u0183\u0184\7\'\2\2\u0184\u0185\5P)\2\u0185\u0186\7(\2"+
		"\2\u0186\u0188\3\2\2\2\u0187\u017e\3\2\2\2\u0187\u0183\3\2\2\2\u0188O"+
		"\3\2\2\2\u0189\u018a\5\32\16\2\u018a\u018b\7*\2\2\u018b\u018c\5P)\2\u018c"+
		"\u0191\3\2\2\2\u018d\u018e\5\32\16\2\u018e\u018f\7*\2\2\u018f\u0191\3"+
		"\2\2\2\u0190\u0189\3\2\2\2\u0190\u018d\3\2\2\2\u0191Q\3\2\2\2\u0192\u0198"+
		"\5.\30\2\u0193\u0198\5 \21\2\u0194\u0198\5*\26\2\u0195\u0198\5&\24\2\u0196"+
		"\u0198\5D#\2\u0197\u0192\3\2\2\2\u0197\u0193\3\2\2\2\u0197\u0194\3\2\2"+
		"\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198S\3\2\2\2\u0199\u019c"+
		"\5V,\2\u019a\u019c\5L\'\2\u019b\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c"+
		"U\3\2\2\2\u019d\u019e\7\"\2\2\u019e\u019f\7.\2\2\u019f\u01a0\5R*\2\u01a0"+
		"W\3\2\2\2\u01a1\u01a2\7\n\2\2\u01a2\u01a3\7%\2\2\u01a3\u01a4\5 \21\2\u01a4"+
		"\u01a5\7&\2\2\u01a5\u01a6\5^\60\2\u01a6\u01a7\7\b\2\2\u01a7\u01a8\5^\60"+
		"\2\u01a8\u01b0\3\2\2\2\u01a9\u01aa\7\n\2\2\u01aa\u01ab\7%\2\2\u01ab\u01ac"+
		"\5 \21\2\u01ac\u01ad\7&\2\2\u01ad\u01ae\5^\60\2\u01ae\u01b0\3\2\2\2\u01af"+
		"\u01a1\3\2\2\2\u01af\u01a9\3\2\2\2\u01b0Y\3\2\2\2\u01b1\u01b2\7\13\2\2"+
		"\u01b2\u01b3\7%\2\2\u01b3\u01b4\5 \21\2\u01b4\u01b5\7&\2\2\u01b5\u01b6"+
		"\5^\60\2\u01b6[\3\2\2\2\u01b7\u01b8\5\30\r\2\u01b8\u01b9\7*\2\2\u01b9"+
		"\u01ba\5\\/\2\u01ba\u01cb\3\2\2\2\u01bb\u01bc\5R*\2\u01bc\u01bd\7*\2\2"+
		"\u01bd\u01be\5\\/\2\u01be\u01cb\3\2\2\2\u01bf\u01c0\5T+\2\u01c0\u01c1"+
		"\7*\2\2\u01c1\u01c2\5\\/\2\u01c2\u01cb\3\2\2\2\u01c3\u01c4\5X-\2\u01c4"+
		"\u01c5\5\\/\2\u01c5\u01cb\3\2\2\2\u01c6\u01c7\5Z.\2\u01c7\u01c8\5\\/\2"+
		"\u01c8\u01cb\3\2\2\2\u01c9\u01cb\3\2\2\2\u01ca\u01b7\3\2\2\2\u01ca\u01bb"+
		"\3\2\2\2\u01ca\u01bf\3\2\2\2\u01ca\u01c3\3\2\2\2\u01ca\u01c6\3\2\2\2\u01ca"+
		"\u01c9\3\2\2\2\u01cb]\3\2\2\2\u01cc\u01cd\7\'\2\2\u01cd\u01ce\5\\/\2\u01ce"+
		"\u01cf\7(\2\2\u01cf_\3\2\2\2#iu~\u0084\u0098\u00a1\u00aa\u00ae\u00c0\u00d4"+
		"\u00db\u00e2\u00ed\u00f4\u00fc\u010c\u0113\u011a\u0124\u012f\u013c\u014a"+
		"\u0154\u015b\u0162\u016b\u0172\u0187\u0190\u0197\u019b\u01af\u01ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}