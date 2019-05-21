// Generated from ../Maps.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapsLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BOOLEAN", "STRING", "INT", "MAP", "DELETE", "ELSE", "FOR", "IF", "WHILE", 
			"BREAK", "EXTEND", "RETURN", "IMPORT", "EXPORT", "FROM", "WS", "INT_LITERAL", 
			"BOOL_LITERAL", "STRING_LITERAL", "NULL", "JOIN_X", "JOIN_Y", "INSERT_X", 
			"INSERT_Y", "DROP_X", "DROP_Y", "MASK", "MIRROR_X", "MIRROR_Y", "ROTATE_CW", 
			"ROTATE_CCW", "IDENTIFIER", "MLPAREN", "MRPAREN", "LPAREN", "RPAREN", 
			"LCURLY", "RCURLY", "HASH", "SEMI", "COMMA", "DOT", "COLON", "ASSIGN", 
			"GT", "LT", "GTE", "LTE", "EQ", "NEQ", "AND", "OR", "NEG", "ADD", "SUB", 
			"MUL", "DIV", "MOD", "CONCAT", "COMMENT", "LINE_COMMENT"
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


	public MapsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Maps.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u01a6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\21\6\21\u00d6\n\21\r\21\16\21\u00d7\3"+
		"\21\3\21\3\22\6\22\u00dd\n\22\r\22\16\22\u00de\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00ea\n\23\3\24\3\24\7\24\u00ee\n\24\f\24\16"+
		"\24\u00f1\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3!\3!\7!\u014c\n!\f!\16!\u014f\13!\3\"\3\"\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3<\3="+
		"\3=\3=\3=\7=\u0192\n=\f=\16=\u0195\13=\3=\3=\3=\3=\3=\3>\3>\3>\3>\7>\u01a0"+
		"\n>\f>\16>\u01a3\13>\3>\3>\3\u0193\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?\3\2\b\5\2\13\f\17\17"+
		"\"\"\3\2\62;\6\2\"#\60;C\\c|\4\2C\\c|\5\2\62;C\\c|\4\2\f\f\17\17\2\u01ac"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\3}\3\2\2\2\5\u0085\3\2\2\2\7\u008c\3\2\2\2\t\u0090\3\2\2\2\13"+
		"\u0094\3\2\2\2\r\u009b\3\2\2\2\17\u00a0\3\2\2\2\21\u00a4\3\2\2\2\23\u00a7"+
		"\3\2\2\2\25\u00ad\3\2\2\2\27\u00b3\3\2\2\2\31\u00ba\3\2\2\2\33\u00c1\3"+
		"\2\2\2\35\u00c8\3\2\2\2\37\u00cf\3\2\2\2!\u00d5\3\2\2\2#\u00dc\3\2\2\2"+
		"%\u00e9\3\2\2\2\'\u00eb\3\2\2\2)\u00f4\3\2\2\2+\u00f9\3\2\2\2-\u00ff\3"+
		"\2\2\2/\u0105\3\2\2\2\61\u010d\3\2\2\2\63\u0115\3\2\2\2\65\u011b\3\2\2"+
		"\2\67\u0121\3\2\2\29\u0126\3\2\2\2;\u012e\3\2\2\2=\u0136\3\2\2\2?\u013f"+
		"\3\2\2\2A\u0149\3\2\2\2C\u0150\3\2\2\2E\u0152\3\2\2\2G\u0154\3\2\2\2I"+
		"\u0156\3\2\2\2K\u0158\3\2\2\2M\u015a\3\2\2\2O\u015c\3\2\2\2Q\u015e\3\2"+
		"\2\2S\u0160\3\2\2\2U\u0162\3\2\2\2W\u0164\3\2\2\2Y\u0166\3\2\2\2[\u0168"+
		"\3\2\2\2]\u016a\3\2\2\2_\u016c\3\2\2\2a\u016f\3\2\2\2c\u0172\3\2\2\2e"+
		"\u0175\3\2\2\2g\u0178\3\2\2\2i\u017b\3\2\2\2k\u017e\3\2\2\2m\u0180\3\2"+
		"\2\2o\u0182\3\2\2\2q\u0184\3\2\2\2s\u0186\3\2\2\2u\u0188\3\2\2\2w\u018a"+
		"\3\2\2\2y\u018d\3\2\2\2{\u019b\3\2\2\2}~\7d\2\2~\177\7q\2\2\177\u0080"+
		"\7q\2\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2\2\u0082\u0083\7c\2\2\u0083"+
		"\u0084\7p\2\2\u0084\4\3\2\2\2\u0085\u0086\7u\2\2\u0086\u0087\7v\2\2\u0087"+
		"\u0088\7t\2\2\u0088\u0089\7k\2\2\u0089\u008a\7p\2\2\u008a\u008b\7i\2\2"+
		"\u008b\6\3\2\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v"+
		"\2\2\u008f\b\3\2\2\2\u0090\u0091\7o\2\2\u0091\u0092\7c\2\2\u0092\u0093"+
		"\7r\2\2\u0093\n\3\2\2\2\u0094\u0095\7f\2\2\u0095\u0096\7g\2\2\u0096\u0097"+
		"\7n\2\2\u0097\u0098\7g\2\2\u0098\u0099\7v\2\2\u0099\u009a\7g\2\2\u009a"+
		"\f\3\2\2\2\u009b\u009c\7g\2\2\u009c\u009d\7n\2\2\u009d\u009e\7u\2\2\u009e"+
		"\u009f\7g\2\2\u009f\16\3\2\2\2\u00a0\u00a1\7h\2\2\u00a1\u00a2\7q\2\2\u00a2"+
		"\u00a3\7t\2\2\u00a3\20\3\2\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7h\2\2\u00a6"+
		"\22\3\2\2\2\u00a7\u00a8\7y\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7k\2\2\u00aa"+
		"\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac\24\3\2\2\2\u00ad\u00ae\7d\2\2\u00ae"+
		"\u00af\7t\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7m\2\2"+
		"\u00b2\26\3\2\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7z\2\2\u00b5\u00b6\7"+
		"v\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7f\2\2\u00b9\30"+
		"\3\2\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7v\2\2\u00bd"+
		"\u00be\7w\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7p\2\2\u00c0\32\3\2\2\2\u00c1"+
		"\u00c2\7k\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5\7q\2\2"+
		"\u00c5\u00c6\7t\2\2\u00c6\u00c7\7v\2\2\u00c7\34\3\2\2\2\u00c8\u00c9\7"+
		"g\2\2\u00c9\u00ca\7z\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd"+
		"\7t\2\2\u00cd\u00ce\7v\2\2\u00ce\36\3\2\2\2\u00cf\u00d0\7h\2\2\u00d0\u00d1"+
		"\7t\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3\7o\2\2\u00d3 \3\2\2\2\u00d4\u00d6"+
		"\t\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\b\21\2\2\u00da\"\3\2\2"+
		"\2\u00db\u00dd\t\3\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc"+
		"\3\2\2\2\u00de\u00df\3\2\2\2\u00df$\3\2\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2"+
		"\7t\2\2\u00e2\u00e3\7w\2\2\u00e3\u00ea\7g\2\2\u00e4\u00e5\7h\2\2\u00e5"+
		"\u00e6\7c\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7u\2\2\u00e8\u00ea\7g\2\2"+
		"\u00e9\u00e0\3\2\2\2\u00e9\u00e4\3\2\2\2\u00ea&\3\2\2\2\u00eb\u00ef\7"+
		"$\2\2\u00ec\u00ee\t\4\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f2\u00f3\7$\2\2\u00f3(\3\2\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f6"+
		"\7w\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7n\2\2\u00f8*\3\2\2\2\u00f9\u00fa"+
		"\7l\2\2\u00fa\u00fb\7q\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7p\2\2\u00fd"+
		"\u00fe\7Z\2\2\u00fe,\3\2\2\2\u00ff\u0100\7l\2\2\u0100\u0101\7q\2\2\u0101"+
		"\u0102\7k\2\2\u0102\u0103\7p\2\2\u0103\u0104\7[\2\2\u0104.\3\2\2\2\u0105"+
		"\u0106\7k\2\2\u0106\u0107\7p\2\2\u0107\u0108\7u\2\2\u0108\u0109\7g\2\2"+
		"\u0109\u010a\7t\2\2\u010a\u010b\7v\2\2\u010b\u010c\7Z\2\2\u010c\60\3\2"+
		"\2\2\u010d\u010e\7k\2\2\u010e\u010f\7p\2\2\u010f\u0110\7u\2\2\u0110\u0111"+
		"\7g\2\2\u0111\u0112\7t\2\2\u0112\u0113\7v\2\2\u0113\u0114\7[\2\2\u0114"+
		"\62\3\2\2\2\u0115\u0116\7f\2\2\u0116\u0117\7t\2\2\u0117\u0118\7q\2\2\u0118"+
		"\u0119\7r\2\2\u0119\u011a\7Z\2\2\u011a\64\3\2\2\2\u011b\u011c\7f\2\2\u011c"+
		"\u011d\7t\2\2\u011d\u011e\7q\2\2\u011e\u011f\7r\2\2\u011f\u0120\7[\2\2"+
		"\u0120\66\3\2\2\2\u0121\u0122\7o\2\2\u0122\u0123\7c\2\2\u0123\u0124\7"+
		"u\2\2\u0124\u0125\7m\2\2\u01258\3\2\2\2\u0126\u0127\7o\2\2\u0127\u0128"+
		"\7k\2\2\u0128\u0129\7t\2\2\u0129\u012a\7t\2\2\u012a\u012b\7q\2\2\u012b"+
		"\u012c\7t\2\2\u012c\u012d\7Z\2\2\u012d:\3\2\2\2\u012e\u012f\7o\2\2\u012f"+
		"\u0130\7k\2\2\u0130\u0131\7t\2\2\u0131\u0132\7t\2\2\u0132\u0133\7q\2\2"+
		"\u0133\u0134\7t\2\2\u0134\u0135\7[\2\2\u0135<\3\2\2\2\u0136\u0137\7t\2"+
		"\2\u0137\u0138\7q\2\2\u0138\u0139\7v\2\2\u0139\u013a\7c\2\2\u013a\u013b"+
		"\7v\2\2\u013b\u013c\7g\2\2\u013c\u013d\7E\2\2\u013d\u013e\7y\2\2\u013e"+
		">\3\2\2\2\u013f\u0140\7t\2\2\u0140\u0141\7q\2\2\u0141\u0142\7v\2\2\u0142"+
		"\u0143\7c\2\2\u0143\u0144\7v\2\2\u0144\u0145\7g\2\2\u0145\u0146\7E\2\2"+
		"\u0146\u0147\7e\2\2\u0147\u0148\7y\2\2\u0148@\3\2\2\2\u0149\u014d\t\5"+
		"\2\2\u014a\u014c\t\6\2\2\u014b\u014a\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014eB\3\2\2\2\u014f\u014d\3\2\2\2"+
		"\u0150\u0151\7]\2\2\u0151D\3\2\2\2\u0152\u0153\7_\2\2\u0153F\3\2\2\2\u0154"+
		"\u0155\7*\2\2\u0155H\3\2\2\2\u0156\u0157\7+\2\2\u0157J\3\2\2\2\u0158\u0159"+
		"\7}\2\2\u0159L\3\2\2\2\u015a\u015b\7\177\2\2\u015bN\3\2\2\2\u015c\u015d"+
		"\7%\2\2\u015dP\3\2\2\2\u015e\u015f\7=\2\2\u015fR\3\2\2\2\u0160\u0161\7"+
		".\2\2\u0161T\3\2\2\2\u0162\u0163\7\60\2\2\u0163V\3\2\2\2\u0164\u0165\7"+
		"<\2\2\u0165X\3\2\2\2\u0166\u0167\7?\2\2\u0167Z\3\2\2\2\u0168\u0169\7@"+
		"\2\2\u0169\\\3\2\2\2\u016a\u016b\7>\2\2\u016b^\3\2\2\2\u016c\u016d\7>"+
		"\2\2\u016d\u016e\7?\2\2\u016e`\3\2\2\2\u016f\u0170\7@\2\2\u0170\u0171"+
		"\7?\2\2\u0171b\3\2\2\2\u0172\u0173\7?\2\2\u0173\u0174\7?\2\2\u0174d\3"+
		"\2\2\2\u0175\u0176\7#\2\2\u0176\u0177\7?\2\2\u0177f\3\2\2\2\u0178\u0179"+
		"\7(\2\2\u0179\u017a\7(\2\2\u017ah\3\2\2\2\u017b\u017c\7~\2\2\u017c\u017d"+
		"\7~\2\2\u017dj\3\2\2\2\u017e\u017f\7#\2\2\u017fl\3\2\2\2\u0180\u0181\7"+
		"-\2\2\u0181n\3\2\2\2\u0182\u0183\7/\2\2\u0183p\3\2\2\2\u0184\u0185\7,"+
		"\2\2\u0185r\3\2\2\2\u0186\u0187\7\61\2\2\u0187t\3\2\2\2\u0188\u0189\7"+
		"\'\2\2\u0189v\3\2\2\2\u018a\u018b\7-\2\2\u018b\u018c\7-\2\2\u018cx\3\2"+
		"\2\2\u018d\u018e\7\61\2\2\u018e\u018f\7,\2\2\u018f\u0193\3\2\2\2\u0190"+
		"\u0192\13\2\2\2\u0191\u0190\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0194\3"+
		"\2\2\2\u0193\u0191\3\2\2\2\u0194\u0196\3\2\2\2\u0195\u0193\3\2\2\2\u0196"+
		"\u0197\7,\2\2\u0197\u0198\7\61\2\2\u0198\u0199\3\2\2\2\u0199\u019a\b="+
		"\2\2\u019az\3\2\2\2\u019b\u019c\7\61\2\2\u019c\u019d\7\61\2\2\u019d\u01a1"+
		"\3\2\2\2\u019e\u01a0\n\7\2\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a1\3\2"+
		"\2\2\u01a4\u01a5\b>\2\2\u01a5|\3\2\2\2\n\2\u00d7\u00de\u00e9\u00ef\u014d"+
		"\u0193\u01a1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}