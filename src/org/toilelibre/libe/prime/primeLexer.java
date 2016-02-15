package org.toilelibre.libe.prime;

import org.antlr.v4.runtime.CharStream;
// Generated from prime.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings ({ "all", "warnings", "unchecked", "unused", "cast" })
public class primeLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion ("4.4", RuntimeMetaData.VERSION);
    }

    protected static final DFA []                 _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache ();
    public static final int                       SELECT              = 1, ADD = 2, WITH = 3, REMOVE = 4, WHERE = 5, LAZYLOADING = 6, OR = 7, AND = 8, LIMIT = 9, ATTRIBUTE = 10,
            LPAREN = 11, RPAREN = 12, LBRACKET = 13, RBRACKET = 14, EQUALS = 15, DIFFERENT = 16, LIKE = 17, SEMICOLON = 18, QUOTE = 19, DQUOTE = 20, DOT = 21, DOLLAR = 22,
            NUMBER = 23, WORD = 24, WHITESPACE = 25, BOOLEAN = 26;
    public static String []                       modeNames           = { "DEFAULT_MODE" };

    public static final String [] tokenNames = { "'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", "'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'",
            "'\\u000B'", "'\f'", "'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", "'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'",
            "'\\u0018'", "'\\u0019'", "'\\u001A'" };
    public static final String [] ruleNames  = { "SELECT", "ADD", "WITH", "REMOVE", "WHERE", "LAZYLOADING", "OR", "AND", "LIMIT", "ATTRIBUTE", "LPAREN", "RPAREN", "LBRACKET",
            "RBRACKET", "EQUALS", "DIFFERENT", "LIKE", "SEMICOLON", "QUOTE", "DQUOTE", "DOT", "DOLLAR", "NUMBER", "WORD", "WHITESPACE", "BOOLEAN" };

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00af\b\1\4\2"
            + "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" + "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"
            + "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" + "\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"
            + "\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3" + "\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t"
            + "\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3" + "\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21"
            + "\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27" + "\3\30\6\30\u0093\n\30\r\30\16\30\u0094\3\31\3\31\7\31\u0099\n\31\f\31"
            + "\16\31\u009c\13\31\3\32\6\32\u009f\n\32\r\32\16\32\u00a0\3\32\3\32\3\33" + "\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00ae\n\33\2\2\34\3\3\5"
            + "\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21" + "!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\6\3\2\62;\4\2"
            + "C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\u00b2\2\3\3\2\2\2\2\5\3\2\2\2\2" + "\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"
            + "\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2" + "\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"
            + "\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2" + "\2\2\65\3\2\2\2\3\67\3\2\2\2\5>\3\2\2\2\7B\3\2\2\2\tG\3\2\2\2\13N\3\2"
            + "\2\2\rT\3\2\2\2\17`\3\2\2\2\21c\3\2\2\2\23g\3\2\2\2\25m\3\2\2\2\27w\3" + "\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35}\3\2\2\2\37\177\3\2\2\2!\u0082\3\2\2"
            + "\2#\u0084\3\2\2\2%\u0087\3\2\2\2\'\u0089\3\2\2\2)\u008b\3\2\2\2+\u008d" + "\3\2\2\2-\u008f\3\2\2\2/\u0092\3\2\2\2\61\u0096\3\2\2\2\63\u009e\3\2\2"
            + "\2\65\u00ad\3\2\2\2\678\7u\2\289\7g\2\29:\7n\2\2:;\7g\2\2;<\7e\2\2<=\7" + "v\2\2=\4\3\2\2\2>?\7c\2\2?@\7f\2\2@A\7f\2\2A\6\3\2\2\2BC\7y\2\2CD\7k\2"
            + "\2DE\7v\2\2EF\7j\2\2F\b\3\2\2\2GH\7t\2\2HI\7g\2\2IJ\7o\2\2JK\7q\2\2KL" + "\7x\2\2LM\7g\2\2M\n\3\2\2\2NO\7y\2\2OP\7j\2\2PQ\7g\2\2QR\7t\2\2RS\7g\2"
            + "\2S\f\3\2\2\2TU\7n\2\2UV\7c\2\2VW\7|\2\2WX\7{\2\2XY\7n\2\2YZ\7q\2\2Z[" + "\7c\2\2[\\\7f\2\2\\]\7k\2\2]^\7p\2\2^_\7i\2\2_\16\3\2\2\2`a\7q\2\2ab\7"
            + "t\2\2b\20\3\2\2\2cd\7c\2\2de\7p\2\2ef\7f\2\2f\22\3\2\2\2gh\7n\2\2hi\7" + "k\2\2ij\7o\2\2jk\7k\2\2kl\7v\2\2l\24\3\2\2\2mn\7c\2\2no\7v\2\2op\7v\2"
            + "\2pq\7t\2\2qr\7k\2\2rs\7d\2\2st\7w\2\2tu\7v\2\2uv\7g\2\2v\26\3\2\2\2w" + "x\7*\2\2x\30\3\2\2\2yz\7+\2\2z\32\3\2\2\2{|\7]\2\2|\34\3\2\2\2}~\7_\2"
            + "\2~\36\3\2\2\2\177\u0080\7?\2\2\u0080\u0081\7?\2\2\u0081 \3\2\2\2\u0082" + "\u0083\7?\2\2\u0083\"\3\2\2\2\u0084\u0085\7\u0080\2\2\u0085\u0086\7\u0080"
            + "\2\2\u0086$\3\2\2\2\u0087\u0088\7=\2\2\u0088&\3\2\2\2\u0089\u008a\7)\2" + "\2\u008a(\3\2\2\2\u008b\u008c\7$\2\2\u008c*\3\2\2\2\u008d\u008e\7\60\2"
            + "\2\u008e,\3\2\2\2\u008f\u0090\7&\2\2\u0090.\3\2\2\2\u0091\u0093\t\2\2" + "\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"
            + "\3\2\2\2\u0095\60\3\2\2\2\u0096\u009a\t\3\2\2\u0097\u0099\t\4\2\2\u0098" + "\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"
            + "\2\2\u009b\62\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\t\5\2\2\u009e\u009d" + "\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"
            + "\u00a2\3\2\2\2\u00a2\u00a3\b\32\2\2\u00a3\64\3\2\2\2\u00a4\u00a5\7v\2" + "\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7w\2\2\u00a7\u00ae\7g\2\2\u00a8\u00a9"
            + "\7h\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7u\2\2\u00ac" + "\u00ae\7g\2\2\u00ad\u00a4\3\2\2\2\u00ad\u00a8\3\2\2\2\u00ae\66\3\2\2\2"
            + "\7\2\u0094\u009a\u00a0\u00ad\3\b\2\2";

    public static final ATN _ATN = new ATNDeserializer ().deserialize (primeLexer._serializedATN.toCharArray ());

    static {
        _decisionToDFA = new DFA [primeLexer._ATN.getNumberOfDecisions ()];
        for (int i = 0 ; i < primeLexer._ATN.getNumberOfDecisions () ; i++) {
            primeLexer._decisionToDFA [i] = new DFA (primeLexer._ATN.getDecisionState (i), i);
        }
    }

    public primeLexer (final CharStream input) {
        super (input);
        this._interp = new LexerATNSimulator (this, primeLexer._ATN, primeLexer._decisionToDFA, primeLexer._sharedContextCache);
    }

    @Override
    public ATN getATN () {
        return primeLexer._ATN;
    }

    @Override
    public String getGrammarFileName () {
        return "prime.g4";
    }

    @Override
    public String [] getModeNames () {
        return primeLexer.modeNames;
    }

    @Override
    public String [] getRuleNames () {
        return primeLexer.ruleNames;
    }

    @Override
    public String getSerializedATN () {
        return primeLexer._serializedATN;
    }

    @Override
    public String [] getTokenNames () {
        return primeLexer.tokenNames;
    }
}