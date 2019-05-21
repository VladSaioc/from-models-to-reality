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
		BOOLEAN=1, STRING=2, INT=3, MAP=4, ELSE=5, IF=6, WHILE=7, EXTEND=8, RETURN=9, 
		IMPORT=10, EXPORT=11, FROM=12, WS=13, INT_LITERAL=14, BOOL_LITERAL=15, 
		STRING_LITERAL=16, JOIN_X=17, JOIN_Y=18, INSERT_X=19, INSERT_Y=20, DROP_X=21, 
		DROP_Y=22, MASK=23, MIRROR_X=24, MIRROR_Y=25, ROTATE_CW=26, ROTATE_CCW=27, 
		IDENTIFIER=28, MLPAREN=29, MRPAREN=30, LPAREN=31, RPAREN=32, LCURLY=33, 
		RCURLY=34, HASH=35, SEMI=36, COMMA=37, DOT=38, COLON=39, ASSIGN=40, GT=41, 
		LT=42, GTE=43, LTE=44, EQ=45, NEQ=46, AND=47, OR=48, NEG=49, ADD=50, SUB=51, 
		MUL=52, DIV=53, MOD=54, CONCAT=55, COMMENT=56, LINE_COMMENT=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BOOLEAN", "STRING", "INT", "MAP", "ELSE", "IF", "WHILE", "EXTEND", "RETURN", 
			"IMPORT", "EXPORT", "FROM", "WS", "INT_LITERAL", "BOOL_LITERAL", "STRING_LITERAL", 
			"JOIN_X", "JOIN_Y", "INSERT_X", "INSERT_Y", "DROP_X", "DROP_Y", "MASK", 
			"MIRROR_X", "MIRROR_Y", "ROTATE_CW", "ROTATE_CCW", "IDENTIFIER", "MLPAREN", 
			"MRPAREN", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "HASH", "SEMI", "COMMA", 
			"DOT", "COLON", "ASSIGN", "GT", "LT", "GTE", "LTE", "EQ", "NEQ", "AND", 
			"OR", "NEG", "ADD", "SUB", "MUL", "DIV", "MOD", "CONCAT", "COMMENT", 
			"LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'boolean'", "'string'", "'int'", "'map'", "'else'", "'if'", "'while'", 
			"'extend'", "'return'", "'import'", "'export'", "'from'", null, null, 
			null, null, "'joinX'", "'joinY'", "'insertX'", "'insertY'", "'dropX'", 
			"'dropY'", "'mask'", "'mirrorX'", "'mirrorY'", "'rotateCw'", "'rotateCcw'", 
			null, "'['", "']'", "'('", "')'", "'{'", "'}'", "'#'", "';'", "','", 
			"'.'", "':'", "'='", "'>'", "'<'", "'<='", "'>='", "'=='", "'!='", "'&&'", 
			"'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOLEAN", "STRING", "INT", "MAP", "ELSE", "IF", "WHILE", "EXTEND", 
			"RETURN", "IMPORT", "EXPORT", "FROM", "WS", "INT_LITERAL", "BOOL_LITERAL", 
			"STRING_LITERAL", "JOIN_X", "JOIN_Y", "INSERT_X", "INSERT_Y", "DROP_X", 
			"DROP_Y", "MASK", "MIRROR_X", "MIRROR_Y", "ROTATE_CW", "ROTATE_CCW", 
			"IDENTIFIER", "MLPAREN", "MRPAREN", "LPAREN", "RPAREN", "LCURLY", "RCURLY", 
			"HASH", "SEMI", "COMMA", "DOT", "COLON", "ASSIGN", "GT", "LT", "GTE", 
			"LTE", "EQ", "NEQ", "AND", "OR", "NEG", "ADD", "SUB", "MUL", "DIV", "MOD", 
			"CONCAT", "COMMENT", "LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u0188\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\6\16\u00bd"+
		"\n\16\r\16\16\16\u00be\3\16\3\16\3\17\6\17\u00c4\n\17\r\17\16\17\u00c5"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d1\n\20\3\21\3\21"+
		"\7\21\u00d5\n\21\f\21\16\21\u00d8\13\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\7\35\u012e\n\35\f\35\16\35\u0131"+
		"\13\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3"+
		"&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/"+
		"\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\38\39\39\39\39\79\u0174\n9\f9\169\u0177\13"+
		"9\39\39\39\39\39\3:\3:\3:\3:\7:\u0182\n:\f:\16:\u0185\13:\3:\3:\3\u0175"+
		"\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;\3\2\b\5\2\13\f\17\17\"\"\3\2\62;\6\2\"#\60;C\\c|\4\2C\\c|\5\2"+
		"\62;C\\c|\4\2\f\f\17\17\2\u018e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u"+
		"\3\2\2\2\5}\3\2\2\2\7\u0084\3\2\2\2\t\u0088\3\2\2\2\13\u008c\3\2\2\2\r"+
		"\u0091\3\2\2\2\17\u0094\3\2\2\2\21\u009a\3\2\2\2\23\u00a1\3\2\2\2\25\u00a8"+
		"\3\2\2\2\27\u00af\3\2\2\2\31\u00b6\3\2\2\2\33\u00bc\3\2\2\2\35\u00c3\3"+
		"\2\2\2\37\u00d0\3\2\2\2!\u00d2\3\2\2\2#\u00db\3\2\2\2%\u00e1\3\2\2\2\'"+
		"\u00e7\3\2\2\2)\u00ef\3\2\2\2+\u00f7\3\2\2\2-\u00fd\3\2\2\2/\u0103\3\2"+
		"\2\2\61\u0108\3\2\2\2\63\u0110\3\2\2\2\65\u0118\3\2\2\2\67\u0121\3\2\2"+
		"\29\u012b\3\2\2\2;\u0132\3\2\2\2=\u0134\3\2\2\2?\u0136\3\2\2\2A\u0138"+
		"\3\2\2\2C\u013a\3\2\2\2E\u013c\3\2\2\2G\u013e\3\2\2\2I\u0140\3\2\2\2K"+
		"\u0142\3\2\2\2M\u0144\3\2\2\2O\u0146\3\2\2\2Q\u0148\3\2\2\2S\u014a\3\2"+
		"\2\2U\u014c\3\2\2\2W\u014e\3\2\2\2Y\u0151\3\2\2\2[\u0154\3\2\2\2]\u0157"+
		"\3\2\2\2_\u015a\3\2\2\2a\u015d\3\2\2\2c\u0160\3\2\2\2e\u0162\3\2\2\2g"+
		"\u0164\3\2\2\2i\u0166\3\2\2\2k\u0168\3\2\2\2m\u016a\3\2\2\2o\u016c\3\2"+
		"\2\2q\u016f\3\2\2\2s\u017d\3\2\2\2uv\7d\2\2vw\7q\2\2wx\7q\2\2xy\7n\2\2"+
		"yz\7g\2\2z{\7c\2\2{|\7p\2\2|\4\3\2\2\2}~\7u\2\2~\177\7v\2\2\177\u0080"+
		"\7t\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083\7i\2\2\u0083"+
		"\6\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087"+
		"\b\3\2\2\2\u0088\u0089\7o\2\2\u0089\u008a\7c\2\2\u008a\u008b\7r\2\2\u008b"+
		"\n\3\2\2\2\u008c\u008d\7g\2\2\u008d\u008e\7n\2\2\u008e\u008f\7u\2\2\u008f"+
		"\u0090\7g\2\2\u0090\f\3\2\2\2\u0091\u0092\7k\2\2\u0092\u0093\7h\2\2\u0093"+
		"\16\3\2\2\2\u0094\u0095\7y\2\2\u0095\u0096\7j\2\2\u0096\u0097\7k\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\7g\2\2\u0099\20\3\2\2\2\u009a\u009b\7g\2\2\u009b"+
		"\u009c\7z\2\2\u009c\u009d\7v\2\2\u009d\u009e\7g\2\2\u009e\u009f\7p\2\2"+
		"\u009f\u00a0\7f\2\2\u00a0\22\3\2\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7"+
		"g\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7w\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7"+
		"\7p\2\2\u00a7\24\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7o\2\2\u00aa\u00ab"+
		"\7r\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7v\2\2\u00ae"+
		"\26\3\2\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7z\2\2\u00b1\u00b2\7r\2\2\u00b2"+
		"\u00b3\7q\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7v\2\2\u00b5\30\3\2\2\2\u00b6"+
		"\u00b7\7h\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7o\2\2"+
		"\u00ba\32\3\2\2\2\u00bb\u00bd\t\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\b\16\2\2\u00c1\34\3\2\2\2\u00c2\u00c4\t\3\2\2\u00c3\u00c2\3\2\2"+
		"\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\36"+
		"\3\2\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca\7w\2\2\u00ca"+
		"\u00d1\7g\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7n\2\2"+
		"\u00ce\u00cf\7u\2\2\u00cf\u00d1\7g\2\2\u00d0\u00c7\3\2\2\2\u00d0\u00cb"+
		"\3\2\2\2\u00d1 \3\2\2\2\u00d2\u00d6\7$\2\2\u00d3\u00d5\t\4\2\2\u00d4\u00d3"+
		"\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7$\2\2\u00da\"\3\2\2\2"+
		"\u00db\u00dc\7l\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7k\2\2\u00de\u00df"+
		"\7p\2\2\u00df\u00e0\7Z\2\2\u00e0$\3\2\2\2\u00e1\u00e2\7l\2\2\u00e2\u00e3"+
		"\7q\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7[\2\2\u00e6"+
		"&\3\2\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7u\2\2\u00ea"+
		"\u00eb\7g\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7Z\2\2"+
		"\u00ee(\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7u\2"+
		"\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6"+
		"\7[\2\2\u00f6*\3\2\2\2\u00f7\u00f8\7f\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa"+
		"\7q\2\2\u00fa\u00fb\7r\2\2\u00fb\u00fc\7Z\2\2\u00fc,\3\2\2\2\u00fd\u00fe"+
		"\7f\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7r\2\2\u0101"+
		"\u0102\7[\2\2\u0102.\3\2\2\2\u0103\u0104\7o\2\2\u0104\u0105\7c\2\2\u0105"+
		"\u0106\7u\2\2\u0106\u0107\7m\2\2\u0107\60\3\2\2\2\u0108\u0109\7o\2\2\u0109"+
		"\u010a\7k\2\2\u010a\u010b\7t\2\2\u010b\u010c\7t\2\2\u010c\u010d\7q\2\2"+
		"\u010d\u010e\7t\2\2\u010e\u010f\7Z\2\2\u010f\62\3\2\2\2\u0110\u0111\7"+
		"o\2\2\u0111\u0112\7k\2\2\u0112\u0113\7t\2\2\u0113\u0114\7t\2\2\u0114\u0115"+
		"\7q\2\2\u0115\u0116\7t\2\2\u0116\u0117\7[\2\2\u0117\64\3\2\2\2\u0118\u0119"+
		"\7t\2\2\u0119\u011a\7q\2\2\u011a\u011b\7v\2\2\u011b\u011c\7c\2\2\u011c"+
		"\u011d\7v\2\2\u011d\u011e\7g\2\2\u011e\u011f\7E\2\2\u011f\u0120\7y\2\2"+
		"\u0120\66\3\2\2\2\u0121\u0122\7t\2\2\u0122\u0123\7q\2\2\u0123\u0124\7"+
		"v\2\2\u0124\u0125\7c\2\2\u0125\u0126\7v\2\2\u0126\u0127\7g\2\2\u0127\u0128"+
		"\7E\2\2\u0128\u0129\7e\2\2\u0129\u012a\7y\2\2\u012a8\3\2\2\2\u012b\u012f"+
		"\t\5\2\2\u012c\u012e\t\6\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130:\3\2\2\2\u0131\u012f\3\2\2\2"+
		"\u0132\u0133\7]\2\2\u0133<\3\2\2\2\u0134\u0135\7_\2\2\u0135>\3\2\2\2\u0136"+
		"\u0137\7*\2\2\u0137@\3\2\2\2\u0138\u0139\7+\2\2\u0139B\3\2\2\2\u013a\u013b"+
		"\7}\2\2\u013bD\3\2\2\2\u013c\u013d\7\177\2\2\u013dF\3\2\2\2\u013e\u013f"+
		"\7%\2\2\u013fH\3\2\2\2\u0140\u0141\7=\2\2\u0141J\3\2\2\2\u0142\u0143\7"+
		".\2\2\u0143L\3\2\2\2\u0144\u0145\7\60\2\2\u0145N\3\2\2\2\u0146\u0147\7"+
		"<\2\2\u0147P\3\2\2\2\u0148\u0149\7?\2\2\u0149R\3\2\2\2\u014a\u014b\7@"+
		"\2\2\u014bT\3\2\2\2\u014c\u014d\7>\2\2\u014dV\3\2\2\2\u014e\u014f\7>\2"+
		"\2\u014f\u0150\7?\2\2\u0150X\3\2\2\2\u0151\u0152\7@\2\2\u0152\u0153\7"+
		"?\2\2\u0153Z\3\2\2\2\u0154\u0155\7?\2\2\u0155\u0156\7?\2\2\u0156\\\3\2"+
		"\2\2\u0157\u0158\7#\2\2\u0158\u0159\7?\2\2\u0159^\3\2\2\2\u015a\u015b"+
		"\7(\2\2\u015b\u015c\7(\2\2\u015c`\3\2\2\2\u015d\u015e\7~\2\2\u015e\u015f"+
		"\7~\2\2\u015fb\3\2\2\2\u0160\u0161\7#\2\2\u0161d\3\2\2\2\u0162\u0163\7"+
		"-\2\2\u0163f\3\2\2\2\u0164\u0165\7/\2\2\u0165h\3\2\2\2\u0166\u0167\7,"+
		"\2\2\u0167j\3\2\2\2\u0168\u0169\7\61\2\2\u0169l\3\2\2\2\u016a\u016b\7"+
		"\'\2\2\u016bn\3\2\2\2\u016c\u016d\7-\2\2\u016d\u016e\7-\2\2\u016ep\3\2"+
		"\2\2\u016f\u0170\7\61\2\2\u0170\u0171\7,\2\2\u0171\u0175\3\2\2\2\u0172"+
		"\u0174\13\2\2\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0176\3"+
		"\2\2\2\u0175\u0173\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178"+
		"\u0179\7,\2\2\u0179\u017a\7\61\2\2\u017a\u017b\3\2\2\2\u017b\u017c\b9"+
		"\2\2\u017cr\3\2\2\2\u017d\u017e\7\61\2\2\u017e\u017f\7\61\2\2\u017f\u0183"+
		"\3\2\2\2\u0180\u0182\n\7\2\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2"+
		"\2\2\u0186\u0187\b:\2\2\u0187t\3\2\2\2\n\2\u00be\u00c5\u00d0\u00d6\u012f"+
		"\u0175\u0183\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}