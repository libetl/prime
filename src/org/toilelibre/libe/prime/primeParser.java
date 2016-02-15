package org.toilelibre.libe.prime;

import java.util.List;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
// Generated from prime.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings ({ "all", "warnings", "unchecked", "unused", "cast" })
public class primeParser extends Parser {
    public static class CommandbodyContext extends ParserRuleContext {
        public CommandbodyContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public CreateContext create () {
            return this.getRuleContext (CreateContext.class, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_commandbody;
        }

        public QueryContext query () {
            return this.getRuleContext (QueryContext.class, 0);
        }

        public RemoveContext remove () {
            return this.getRuleContext (RemoveContext.class, 0);
        }
    }

    public static class CommandContext extends ParserRuleContext {
        public CommandContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public CommandbodyContext commandbody () {
            return this.getRuleContext (CommandbodyContext.class, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_command;
        }

        public TerminalNode SEMICOLON () {
            return this.getToken (primeParser.SEMICOLON, 0);
        }
    }

    public static class ConjunctionContext extends ParserRuleContext {
        public ConjunctionContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public TerminalNode AND () {
            return this.getToken (primeParser.AND, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_conjunction;
        }

        public TerminalNode OR () {
            return this.getToken (primeParser.OR, 0);
        }
    }

    public static class CreateContext extends ParserRuleContext {
        public CreateContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public TerminalNode ADD () {
            return this.getToken (primeParser.ADD, 0);
        }

        public CriteriasContext criterias () {
            return this.getRuleContext (CriteriasContext.class, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_create;
        }

        public TypeContext type () {
            return this.getRuleContext (TypeContext.class, 0);
        }

        public TerminalNode WITH () {
            return this.getToken (primeParser.WITH, 0);
        }
    }

    public static class CriteriaContext extends ParserRuleContext {
        public CriteriaContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public ExpressionContext expression () {
            return this.getRuleContext (ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_criteria;
        }

        public List<TerminalNode> LPAREN () {
            return this.getTokens (primeParser.LPAREN);
        }

        public TerminalNode LPAREN (final int i) {
            return this.getToken (primeParser.LPAREN, i);
        }

        public OperatorContext operator () {
            return this.getRuleContext (OperatorContext.class, 0);
        }

        public List<TerminalNode> RPAREN () {
            return this.getTokens (primeParser.RPAREN);
        }

        public TerminalNode RPAREN (final int i) {
            return this.getToken (primeParser.RPAREN, i);
        }

        public ValueContext value () {
            return this.getRuleContext (ValueContext.class, 0);
        }
    }

    public static class CriteriasContext extends ParserRuleContext {
        public CriteriasContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public List<ConjunctionContext> conjunction () {
            return this.getRuleContexts (ConjunctionContext.class);
        }

        public ConjunctionContext conjunction (final int i) {
            return this.getRuleContext (ConjunctionContext.class, i);
        }

        public List<CriteriaContext> criteria () {
            return this.getRuleContexts (CriteriaContext.class);
        }

        public CriteriaContext criteria (final int i) {
            return this.getRuleContext (CriteriaContext.class, i);
        }

        public List<TerminalNode> DQUOTE () {
            return this.getTokens (primeParser.DQUOTE);
        }

        public TerminalNode DQUOTE (final int i) {
            return this.getToken (primeParser.DQUOTE, i);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_criterias;
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public TerminalNode ATTRIBUTE () {
            return this.getToken (primeParser.ATTRIBUTE, 0);
        }

        public FieldContext field () {
            return this.getRuleContext (FieldContext.class, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_expression;
        }

        public TerminalNode LBRACKET () {
            return this.getToken (primeParser.LBRACKET, 0);
        }

        public TerminalNode LPAREN () {
            return this.getToken (primeParser.LPAREN, 0);
        }

        public MethodContext method () {
            return this.getRuleContext (MethodContext.class, 0);
        }

        public List<TerminalNode> QUOTE () {
            return this.getTokens (primeParser.QUOTE);
        }

        public TerminalNode QUOTE (final int i) {
            return this.getToken (primeParser.QUOTE, i);
        }

        public TerminalNode RBRACKET () {
            return this.getToken (primeParser.RBRACKET, 0);
        }

        public TerminalNode RPAREN () {
            return this.getToken (primeParser.RPAREN, 0);
        }
    }

    public static class FieldContext extends ParserRuleContext {
        public FieldContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_field;
        }

        public TerminalNode WORD () {
            return this.getToken (primeParser.WORD, 0);
        }
    }

    public static class LazyloadingContext extends ParserRuleContext {
        public LazyloadingContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public TerminalNode BOOLEAN () {
            return this.getToken (primeParser.BOOLEAN, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_lazyloading;
        }

        public TerminalNode LAZYLOADING () {
            return this.getToken (primeParser.LAZYLOADING, 0);
        }
    }

    public static class LimitContext extends ParserRuleContext {
        public LimitContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_limit;
        }

        public TerminalNode LIMIT () {
            return this.getToken (primeParser.LIMIT, 0);
        }

        public TerminalNode NUMBER () {
            return this.getToken (primeParser.NUMBER, 0);
        }
    }

    public static class MethodContext extends ParserRuleContext {
        public MethodContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_method;
        }

        public TerminalNode WORD () {
            return this.getToken (primeParser.WORD, 0);
        }
    }

    public static class MethodReturnTypeContext extends ParserRuleContext {
        public MethodReturnTypeContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_methodReturnType;
        }

        public ObjectPathContext objectPath () {
            return this.getRuleContext (ObjectPathContext.class, 0);
        }
    }

    public static class ObjectPathContext extends ParserRuleContext {
        public ObjectPathContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public List<TerminalNode> DOLLAR () {
            return this.getTokens (primeParser.DOLLAR);
        }

        public TerminalNode DOLLAR (final int i) {
            return this.getToken (primeParser.DOLLAR, i);
        }

        public List<TerminalNode> DOT () {
            return this.getTokens (primeParser.DOT);
        }

        public TerminalNode DOT (final int i) {
            return this.getToken (primeParser.DOT, i);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_objectPath;
        }

        public List<TerminalNode> WORD () {
            return this.getTokens (primeParser.WORD);
        }

        public TerminalNode WORD (final int i) {
            return this.getToken (primeParser.WORD, i);
        }
    }

    public static class OperatorContext extends ParserRuleContext {
        public OperatorContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public TerminalNode DIFFERENT () {
            return this.getToken (primeParser.DIFFERENT, 0);
        }

        public TerminalNode EQUALS () {
            return this.getToken (primeParser.EQUALS, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_operator;
        }

        public TerminalNode LIKE () {
            return this.getToken (primeParser.LIKE, 0);
        }
    }

    public static class PrimerequestContext extends ParserRuleContext {
        public PrimerequestContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public List<CommandContext> command () {
            return this.getRuleContexts (CommandContext.class);
        }

        public CommandContext command (final int i) {
            return this.getRuleContext (CommandContext.class, i);
        }

        public TerminalNode EOF () {
            return this.getToken (primeParser.EOF, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_primerequest;
        }
    }

    public static class QueryContext extends ParserRuleContext {
        public QueryContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_query;
        }

        public LazyloadingContext lazyloading () {
            return this.getRuleContext (LazyloadingContext.class, 0);
        }

        public LimitContext limit () {
            return this.getRuleContext (LimitContext.class, 0);
        }

        public ReturnedTypeContext returnedType () {
            return this.getRuleContext (ReturnedTypeContext.class, 0);
        }

        public TerminalNode SELECT () {
            return this.getToken (primeParser.SELECT, 0);
        }

        public WherecriteriasContext wherecriterias () {
            return this.getRuleContext (WherecriteriasContext.class, 0);
        }
    }

    public static class RemoveContext extends ParserRuleContext {
        public RemoveContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_remove;
        }

        public TerminalNode REMOVE () {
            return this.getToken (primeParser.REMOVE, 0);
        }

        public TypeContext type () {
            return this.getRuleContext (TypeContext.class, 0);
        }
    }

    public static class ReturnedTypeContext extends ParserRuleContext {
        public ReturnedTypeContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_returnedType;
        }

        public MethodReturnTypeContext methodReturnType () {
            return this.getRuleContext (MethodReturnTypeContext.class, 0);
        }

        public TypeContext type () {
            return this.getRuleContext (TypeContext.class, 0);
        }
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_type;
        }

        public TerminalNode WORD () {
            return this.getToken (primeParser.WORD, 0);
        }
    }

    public static class ValueContext extends ParserRuleContext {
        public ValueContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_value;
        }

        public TerminalNode NUMBER () {
            return this.getToken (primeParser.NUMBER, 0);
        }

        public List<TerminalNode> QUOTE () {
            return this.getTokens (primeParser.QUOTE);
        }

        public TerminalNode QUOTE (final int i) {
            return this.getToken (primeParser.QUOTE, i);
        }

        public TerminalNode WORD () {
            return this.getToken (primeParser.WORD, 0);
        }
    }

    public static class WherecriteriasContext extends ParserRuleContext {
        public WherecriteriasContext (final ParserRuleContext parent, final int invokingState) {
            super (parent, invokingState);
        }

        public CriteriasContext criterias () {
            return this.getRuleContext (CriteriasContext.class, 0);
        }

        @Override
        public int getRuleIndex () {
            return primeParser.RULE_wherecriterias;
        }

        public TerminalNode WHERE () {
            return this.getToken (primeParser.WHERE, 0);
        }
    }

    static {
        RuntimeMetaData.checkVersion ("4.4", RuntimeMetaData.VERSION);
    }

    protected static final DFA [] _decisionToDFA;

    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache ();

    public static final int SELECT = 1, ADD = 2, WITH = 3, REMOVE = 4, WHERE = 5, LAZYLOADING = 6, OR = 7, AND = 8, LIMIT = 9, ATTRIBUTE = 10, LPAREN = 11, RPAREN = 12,
            LBRACKET = 13, RBRACKET = 14, EQUALS = 15, DIFFERENT = 16, LIKE = 17, SEMICOLON = 18, QUOTE = 19, DQUOTE = 20, DOT = 21, DOLLAR = 22, NUMBER = 23, WORD = 24,
            WHITESPACE = 25, BOOLEAN = 26;

    public static final String [] tokenNames = { "<INVALID>", "'select'", "'add'", "'with'", "'remove'", "'where'", "'lazyloading'", "'or'", "'and'", "'limit'", "'attribute'",
            "'('", "')'", "'['", "']'", "'=='", "'!='", "'~~'", "';'", "'''", "'\"'", "'.'", "'$'", "NUMBER", "WORD", "WHITESPACE", "BOOLEAN" };

    public static final int RULE_primerequest = 0, RULE_command = 1, RULE_commandbody = 2, RULE_query = 3, RULE_create = 4, RULE_remove = 5, RULE_wherecriterias = 6,
            RULE_lazyloading = 7, RULE_criterias = 8, RULE_criteria = 9, RULE_operator = 10, RULE_conjunction = 11, RULE_expression = 12, RULE_field = 13, RULE_method = 14,
            RULE_limit = 15, RULE_returnedType = 16, RULE_methodReturnType = 17, RULE_type = 18, RULE_objectPath = 19, RULE_value = 20;

    public static final String [] ruleNames = { "primerequest", "command", "commandbody", "query", "create", "remove", "wherecriterias", "lazyloading", "criterias", "criteria",
            "operator", "conjunction", "expression", "field", "method", "limit", "returnedType", "methodReturnType", "type", "objectPath", "value" };

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00a7\4\2\t\2"
            + "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
            + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\6\2.\n\2\r\2\16\2/\3\2\3" + "\2\3\3\3\3\3\3\3\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\5\5?\n\5\3\5\5\5B\n\5"
            + "\3\5\5\5E\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\t\3\t" + "\3\t\3\n\5\nW\n\n\3\n\3\n\3\n\7\n\\\n\n\f\n\16\n_\13\n\3\n\3\n\5\nc\n"
            + "\n\3\13\7\13f\n\13\f\13\16\13i\13\13\3\13\3\13\3\13\3\13\7\13o\n\13\f" + "\13\16\13r\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\5\16{\n\16\3\16\3\16\5"
            + "\16\177\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0087\n\16\3\17\3\17\3" + "\20\3\20\3\21\3\21\3\21\3\22\3\22\5\22\u0092\n\22\3\23\3\23\3\24\3\24"
            + "\3\25\3\25\5\25\u009a\n\25\6\25\u009c\n\25\r\25\16\25\u009d\3\26\5\26" + "\u00a1\n\26\3\26\3\26\5\26\u00a5\n\26\3\26\3p\2\27\2\4\6\b\n\f\16\20\22"
            + "\24\26\30\32\34\36 \"$&(*\2\6\3\2\21\23\3\2\t\n\3\2\27\30\3\2\31\32\u00a5" + "\2-\3\2\2\2\4\63\3\2\2\2\69\3\2\2\2\b;\3\2\2\2\nF\3\2\2\2\fK\3\2\2\2\16"
            + "O\3\2\2\2\20R\3\2\2\2\22V\3\2\2\2\24g\3\2\2\2\26s\3\2\2\2\30u\3\2\2\2" + "\32\u0086\3\2\2\2\34\u0088\3\2\2\2\36\u008a\3\2\2\2 \u008c\3\2\2\2\"\u0091"
            + "\3\2\2\2$\u0093\3\2\2\2&\u0095\3\2\2\2(\u009b\3\2\2\2*\u00a0\3\2\2\2," + ".\5\4\3\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62"
            + "\7\2\2\3\62\3\3\2\2\2\63\64\5\6\4\2\64\65\7\24\2\2\65\5\3\2\2\2\66:\5" + "\b\5\2\67:\5\n\6\28:\5\f\7\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\7\3\2"
            + "\2\2;<\7\3\2\2<>\5\"\22\2=?\5 \21\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@B\5" + "\16\b\2A@\3\2\2\2AB\3\2\2\2BD\3\2\2\2CE\5\20\t\2DC\3\2\2\2DE\3\2\2\2E"
            + "\t\3\2\2\2FG\7\4\2\2GH\5&\24\2HI\7\5\2\2IJ\5\22\n\2J\13\3\2\2\2KM\7\6" + "\2\2LN\5&\24\2ML\3\2\2\2MN\3\2\2\2N\r\3\2\2\2OP\7\7\2\2PQ\5\22\n\2Q\17"
            + "\3\2\2\2RS\7\b\2\2ST\7\34\2\2T\21\3\2\2\2UW\7\26\2\2VU\3\2\2\2VW\3\2\2" + "\2W]\3\2\2\2XY\5\24\13\2YZ\5\30\r\2Z\\\3\2\2\2[X\3\2\2\2\\_\3\2\2\2]["
            + "\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`b\5\24\13\2ac\7\26\2\2ba\3\2\2" + "\2bc\3\2\2\2c\23\3\2\2\2df\7\r\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2"
            + "\2\2hj\3\2\2\2ig\3\2\2\2jk\5\32\16\2kl\5\26\f\2lp\5*\26\2mo\7\16\2\2n" + "m\3\2\2\2or\3\2\2\2pq\3\2\2\2pn\3\2\2\2q\25\3\2\2\2rp\3\2\2\2st\t\2\2"
            + "\2t\27\3\2\2\2uv\t\3\2\2v\31\3\2\2\2wx\7\f\2\2xz\7\17\2\2y{\7\25\2\2z" + "y\3\2\2\2z{\3\2\2\2{|\3\2\2\2|~\5\34\17\2}\177\7\25\2\2~}\3\2\2\2~\177"
            + "\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\20\2\2\u0081\u0087\3\2\2\2\u0082" + "\u0083\5\36\20\2\u0083\u0084\7\r\2\2\u0084\u0085\7\16\2\2\u0085\u0087"
            + "\3\2\2\2\u0086w\3\2\2\2\u0086\u0082\3\2\2\2\u0087\33\3\2\2\2\u0088\u0089" + "\7\32\2\2\u0089\35\3\2\2\2\u008a\u008b\7\32\2\2\u008b\37\3\2\2\2\u008c"
            + "\u008d\7\13\2\2\u008d\u008e\7\31\2\2\u008e!\3\2\2\2\u008f\u0092\5&\24" + "\2\u0090\u0092\5$\23\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092#"
            + "\3\2\2\2\u0093\u0094\5(\25\2\u0094%\3\2\2\2\u0095\u0096\7\32\2\2\u0096" + "\'\3\2\2\2\u0097\u0099\7\32\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2"
            + "\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0097\3\2\2\2\u009c\u009d" + "\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e)\3\2\2\2\u009f"
            + "\u00a1\7\25\2\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3" + "\2\2\2\u00a2\u00a4\t\5\2\2\u00a3\u00a5\7\25\2\2\u00a4\u00a3\3\2\2\2\u00a4"
            + "\u00a5\3\2\2\2\u00a5+\3\2\2\2\25/9>ADMV]bgpz~\u0086\u0091\u0099\u009d" + "\u00a0\u00a4";

    public static final ATN _ATN = new ATNDeserializer ().deserialize (primeParser._serializedATN.toCharArray ());

    static {
        _decisionToDFA = new DFA [primeParser._ATN.getNumberOfDecisions ()];
        for (int i = 0 ; i < primeParser._ATN.getNumberOfDecisions () ; i++) {
            primeParser._decisionToDFA [i] = new DFA (primeParser._ATN.getDecisionState (i), i);
        }
    }

    public primeParser (final TokenStream input) {
        super (input);
        this._interp = new ParserATNSimulator (this, primeParser._ATN, primeParser._decisionToDFA, primeParser._sharedContextCache);
    }

    public final CommandContext command () throws RecognitionException {
        final CommandContext _localctx = new CommandContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 2, primeParser.RULE_command);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (49);
                this.commandbody ();
                this.setState (50);
                this.match (primeParser.SEMICOLON);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final CommandbodyContext commandbody () throws RecognitionException {
        final CommandbodyContext _localctx = new CommandbodyContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 4, primeParser.RULE_commandbody);
        try {
            this.setState (55);
            switch (this._input.LA (1)) {
            case SELECT :
                this.enterOuterAlt (_localctx, 1); {
                this.setState (52);
                this.query ();
            }
                break;
            case ADD :
                this.enterOuterAlt (_localctx, 2); {
                this.setState (53);
                this.create ();
            }
                break;
            case REMOVE :
                this.enterOuterAlt (_localctx, 3); {
                this.setState (54);
                this.remove ();
            }
                break;
            default :
                throw new NoViableAltException (this);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final ConjunctionContext conjunction () throws RecognitionException {
        final ConjunctionContext _localctx = new ConjunctionContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 22, primeParser.RULE_conjunction);
        int _la;
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (115);
                _la = this._input.LA (1);
                if (! ( (_la == primeParser.OR) || (_la == primeParser.AND))) {
                    this._errHandler.recoverInline (this);
                }
                this.consume ();
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final CreateContext create () throws RecognitionException {
        final CreateContext _localctx = new CreateContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 8, primeParser.RULE_create);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (68);
                this.match (primeParser.ADD);
                this.setState (69);
                this.type ();
                this.setState (70);
                this.match (primeParser.WITH);
                this.setState (71);
                this.criterias ();
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final CriteriaContext criteria () throws RecognitionException {
        final CriteriaContext _localctx = new CriteriaContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 18, primeParser.RULE_criteria);
        int _la;
        try {
            int _alt;
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (101);
                this._errHandler.sync (this);
                _la = this._input.LA (1);
                while (_la == primeParser.LPAREN) {
                    {
                        {
                            this.setState (98);
                            this.match (primeParser.LPAREN);
                        }
                    }
                    this.setState (103);
                    this._errHandler.sync (this);
                    _la = this._input.LA (1);
                }
                this.setState (104);
                this.expression ();
                this.setState (105);
                this.operator ();
                this.setState (106);
                this.value ();
                this.setState (110);
                this._errHandler.sync (this);
                _alt = this.getInterpreter ().adaptivePredict (this._input, 10, this._ctx);
                while ( (_alt != 1) && (_alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)) {
                    if (_alt == (1 + 1)) {
                        {
                            {
                                this.setState (107);
                                this.match (primeParser.RPAREN);
                            }
                        }
                    }
                    this.setState (112);
                    this._errHandler.sync (this);
                    _alt = this.getInterpreter ().adaptivePredict (this._input, 10, this._ctx);
                }
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final CriteriasContext criterias () throws RecognitionException {
        final CriteriasContext _localctx = new CriteriasContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 16, primeParser.RULE_criterias);
        int _la;
        try {
            int _alt;
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (84);
                _la = this._input.LA (1);
                if (_la == primeParser.DQUOTE) {
                    {
                        this.setState (83);
                        this.match (primeParser.DQUOTE);
                    }
                }

                this.setState (91);
                this._errHandler.sync (this);
                _alt = this.getInterpreter ().adaptivePredict (this._input, 7, this._ctx);
                while ( (_alt != 2) && (_alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)) {
                    if (_alt == 1) {
                        {
                            {
                                this.setState (86);
                                this.criteria ();
                                this.setState (87);
                                this.conjunction ();
                            }
                        }
                    }
                    this.setState (93);
                    this._errHandler.sync (this);
                    _alt = this.getInterpreter ().adaptivePredict (this._input, 7, this._ctx);
                }
                this.setState (94);
                this.criteria ();
                this.setState (96);
                _la = this._input.LA (1);
                if (_la == primeParser.DQUOTE) {
                    {
                        this.setState (95);
                        this.match (primeParser.DQUOTE);
                    }
                }

            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final ExpressionContext expression () throws RecognitionException {
        final ExpressionContext _localctx = new ExpressionContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 24, primeParser.RULE_expression);
        int _la;
        try {
            this.setState (132);
            switch (this._input.LA (1)) {
            case ATTRIBUTE :
                this.enterOuterAlt (_localctx, 1); {
                {
                    this.setState (117);
                    this.match (primeParser.ATTRIBUTE);
                    this.setState (118);
                    this.match (primeParser.LBRACKET);
                    this.setState (120);
                    _la = this._input.LA (1);
                    if (_la == primeParser.QUOTE) {
                        {
                            this.setState (119);
                            this.match (primeParser.QUOTE);
                        }
                    }

                    this.setState (122);
                    this.field ();
                    this.setState (124);
                    _la = this._input.LA (1);
                    if (_la == primeParser.QUOTE) {
                        {
                            this.setState (123);
                            this.match (primeParser.QUOTE);
                        }
                    }

                    this.setState (126);
                    this.match (primeParser.RBRACKET);
                }
            }
                break;
            case WORD :
                this.enterOuterAlt (_localctx, 2); {
                this.setState (128);
                this.method ();
                this.setState (129);
                this.match (primeParser.LPAREN);
                this.setState (130);
                this.match (primeParser.RPAREN);
            }
                break;
            default :
                throw new NoViableAltException (this);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final FieldContext field () throws RecognitionException {
        final FieldContext _localctx = new FieldContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 26, primeParser.RULE_field);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (134);
                this.match (primeParser.WORD);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    @Override
    public ATN getATN () {
        return primeParser._ATN;
    }

    @Override
    public String getGrammarFileName () {
        return "prime.g4";
    }

    @Override
    public String [] getRuleNames () {
        return primeParser.ruleNames;
    }

    @Override
    public String getSerializedATN () {
        return primeParser._serializedATN;
    }

    @Override
    public String [] getTokenNames () {
        return primeParser.tokenNames;
    }

    public final LazyloadingContext lazyloading () throws RecognitionException {
        final LazyloadingContext _localctx = new LazyloadingContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 14, primeParser.RULE_lazyloading);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (80);
                this.match (primeParser.LAZYLOADING);
                this.setState (81);
                this.match (primeParser.BOOLEAN);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final LimitContext limit () throws RecognitionException {
        final LimitContext _localctx = new LimitContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 30, primeParser.RULE_limit);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (138);
                this.match (primeParser.LIMIT);
                this.setState (139);
                this.match (primeParser.NUMBER);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final MethodContext method () throws RecognitionException {
        final MethodContext _localctx = new MethodContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 28, primeParser.RULE_method);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (136);
                this.match (primeParser.WORD);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final MethodReturnTypeContext methodReturnType () throws RecognitionException {
        final MethodReturnTypeContext _localctx = new MethodReturnTypeContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 34, primeParser.RULE_methodReturnType);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (145);
                this.objectPath ();
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final ObjectPathContext objectPath () throws RecognitionException {
        final ObjectPathContext _localctx = new ObjectPathContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 38, primeParser.RULE_objectPath);
        int _la;
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (153);
                this._errHandler.sync (this);
                _la = this._input.LA (1);
                do {
                    {
                        {
                            this.setState (149);
                            this.match (primeParser.WORD);
                            this.setState (151);
                            _la = this._input.LA (1);
                            if ( (_la == primeParser.DOT) || (_la == primeParser.DOLLAR)) {
                                {
                                    this.setState (150);
                                    _la = this._input.LA (1);
                                    if (! ( (_la == primeParser.DOT) || (_la == primeParser.DOLLAR))) {
                                        this._errHandler.recoverInline (this);
                                    }
                                    this.consume ();
                                }
                            }

                        }
                    }
                    this.setState (155);
                    this._errHandler.sync (this);
                    _la = this._input.LA (1);
                } while (_la == primeParser.WORD);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final OperatorContext operator () throws RecognitionException {
        final OperatorContext _localctx = new OperatorContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 20, primeParser.RULE_operator);
        int _la;
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (113);
                _la = this._input.LA (1);
                if (! ( ( ( ( (_la) & ~0x3f) == 0) && ( ( (1L << _la) & ( (1L << primeParser.EQUALS) | (1L << primeParser.DIFFERENT) | (1L << primeParser.LIKE))) != 0)))) {
                    this._errHandler.recoverInline (this);
                }
                this.consume ();
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final PrimerequestContext primerequest () throws RecognitionException {
        final PrimerequestContext _localctx = new PrimerequestContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 0, primeParser.RULE_primerequest);
        int _la;
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (43);
                this._errHandler.sync (this);
                _la = this._input.LA (1);
                do {
                    {
                        {
                            this.setState (42);
                            this.command ();
                        }
                    }
                    this.setState (45);
                    this._errHandler.sync (this);
                    _la = this._input.LA (1);
                } while ( ( ( ( (_la) & ~0x3f) == 0) && ( ( (1L << _la) & ( (1L << primeParser.SELECT) | (1L << primeParser.ADD) | (1L << primeParser.REMOVE))) != 0)));
                this.setState (47);
                this.match (Recognizer.EOF);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final QueryContext query () throws RecognitionException {
        final QueryContext _localctx = new QueryContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 6, primeParser.RULE_query);
        int _la;
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (57);
                this.match (primeParser.SELECT);
                this.setState (58);
                this.returnedType ();
                this.setState (60);
                _la = this._input.LA (1);
                if (_la == primeParser.LIMIT) {
                    {
                        this.setState (59);
                        this.limit ();
                    }
                }

                this.setState (63);
                _la = this._input.LA (1);
                if (_la == primeParser.WHERE) {
                    {
                        this.setState (62);
                        this.wherecriterias ();
                    }
                }

                this.setState (66);
                _la = this._input.LA (1);
                if (_la == primeParser.LAZYLOADING) {
                    {
                        this.setState (65);
                        this.lazyloading ();
                    }
                }

            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final RemoveContext remove () throws RecognitionException {
        final RemoveContext _localctx = new RemoveContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 10, primeParser.RULE_remove);
        int _la;
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (73);
                this.match (primeParser.REMOVE);
                this.setState (75);
                _la = this._input.LA (1);
                if (_la == primeParser.WORD) {
                    {
                        this.setState (74);
                        this.type ();
                    }
                }

            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final ReturnedTypeContext returnedType () throws RecognitionException {
        final ReturnedTypeContext _localctx = new ReturnedTypeContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 32, primeParser.RULE_returnedType);
        try {
            this.setState (143);
            switch (this.getInterpreter ().adaptivePredict (this._input, 14, this._ctx)) {
            case 1 :
                this.enterOuterAlt (_localctx, 1); {
                this.setState (141);
                this.type ();
            }
                break;
            case 2 :
                this.enterOuterAlt (_localctx, 2); {
                this.setState (142);
                this.methodReturnType ();
            }
                break;
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final TypeContext type () throws RecognitionException {
        final TypeContext _localctx = new TypeContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 36, primeParser.RULE_type);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (147);
                this.match (primeParser.WORD);
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final ValueContext value () throws RecognitionException {
        final ValueContext _localctx = new ValueContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 40, primeParser.RULE_value);
        int _la;
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (158);
                _la = this._input.LA (1);
                if (_la == primeParser.QUOTE) {
                    {
                        this.setState (157);
                        this.match (primeParser.QUOTE);
                    }
                }

                this.setState (160);
                _la = this._input.LA (1);
                if (! ( (_la == primeParser.NUMBER) || (_la == primeParser.WORD))) {
                    this._errHandler.recoverInline (this);
                }
                this.consume ();
                this.setState (162);
                _la = this._input.LA (1);
                if (_la == primeParser.QUOTE) {
                    {
                        this.setState (161);
                        this.match (primeParser.QUOTE);
                    }
                }

            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }

    public final WherecriteriasContext wherecriterias () throws RecognitionException {
        final WherecriteriasContext _localctx = new WherecriteriasContext (this._ctx, this.getState ());
        this.enterRule (_localctx, 12, primeParser.RULE_wherecriterias);
        try {
            this.enterOuterAlt (_localctx, 1);
            {
                this.setState (77);
                this.match (primeParser.WHERE);
                this.setState (78);
                this.criterias ();
            }
        } catch (final RecognitionException re) {
            _localctx.exception = re;
            this._errHandler.reportError (this, re);
            this._errHandler.recover (this, re);
        } finally {
            this.exitRule ();
        }
        return _localctx;
    }
}