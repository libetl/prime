package org.toilelibre.libe.prime;
// Generated from prime.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class primeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__25=1, T__24=2, T__23=3, T__22=4, T__21=5, T__20=6, T__19=7, T__18=8, 
		T__17=9, T__16=10, T__15=11, T__14=12, T__13=13, T__12=14, T__11=15, T__10=16, 
		T__9=17, T__8=18, T__7=19, T__6=20, T__5=21, T__4=22, T__3=23, T__2=24, 
		T__1=25, T__0=26, OBJID=27, NUMBER=28, DUMP=29, OPENCONDS=30, CLOSECONDS=31, 
		WORD=32, SEMICOLON=33, QUOTE=34, WHITESPACE=35, LBRACKET=36, RBRACKET=37;
	public static final String[] tokenNames = {
		"<INVALID>", "'query'", "'select'", "'name'", "'attribute'", "'or'", "'('", 
		"'from['", "'!='", "'id'", "'and'", "'bus'", "'add'", "'~~'", "'].to.'", 
		"'$'", "'limit'", "'* *'", "')'", "'.'", "'print'", "'temp'", "'policy'", 
		"'\"'", "'vault'", "'where'", "'=='", "OBJID", "NUMBER", "'dump |'", "OPENCONDS", 
		"CLOSECONDS", "WORD", "';'", "'''", "WHITESPACE", "'['", "']'"
	};
	public static final int
		RULE_primerequest = 0, RULE_command = 1, RULE_commandbody = 2, RULE_query = 3, 
		RULE_create = 4, RULE_print = 5, RULE_select = 6, RULE_selection = 7, 
		RULE_criterias = 8, RULE_criteria = 9, RULE_operator = 10, RULE_conjunction = 11, 
		RULE_expression = 12, RULE_field = 13, RULE_method = 14, RULE_limit = 15, 
		RULE_type = 16, RULE_name = 17, RULE_rev = 18, RULE_policy = 19, RULE_vault = 20, 
		RULE_value = 21;
	public static final String[] ruleNames = {
		"primerequest", "command", "commandbody", "query", "create", "print", 
		"select", "selection", "criterias", "criteria", "operator", "conjunction", 
		"expression", "field", "method", "limit", "type", "name", "rev", "policy", 
		"vault", "value"
	};

	@Override
	public String getGrammarFileName() { return "prime.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public primeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PrimerequestContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public TerminalNode EOF() { return getToken(primeParser.EOF, 0); }
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public PrimerequestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primerequest; }
	}

	public final PrimerequestContext primerequest() throws RecognitionException {
		PrimerequestContext _localctx = new PrimerequestContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_primerequest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44); command();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__6) | (1L << T__5))) != 0) );
			setState(49); match(EOF);
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

	public static class CommandContext extends ParserRuleContext {
		public CommandbodyContext commandbody() {
			return getRuleContext(CommandbodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(primeParser.SEMICOLON, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); commandbody();
			setState(52); match(SEMICOLON);
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

	public static class CommandbodyContext extends ParserRuleContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public CommandbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandbody; }
	}

	public final CommandbodyContext commandbody() throws RecognitionException {
		CommandbodyContext _localctx = new CommandbodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_commandbody);
		try {
			setState(57);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); query();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); create();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(56); print();
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

	public static class QueryContext extends ParserRuleContext {
		public TerminalNode DUMP() { return getToken(primeParser.DUMP, 0); }
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CriteriasContext criterias() {
			return getRuleContext(CriteriasContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(T__5);
			setState(60); match(T__25);
			setState(61); match(T__15);
			setState(62); type();
			setState(63); match(T__9);
			setState(64); limit();
			setState(67);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(65); match(T__1);
				setState(66); criterias();
				}
			}

			setState(69); select();
			setState(71);
			_la = _input.LA(1);
			if (_la==DUMP) {
				{
				setState(70); match(DUMP);
				}
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

	public static class CreateContext extends ParserRuleContext {
		public PolicyContext policy() {
			return getRuleContext(PolicyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VaultContext vault() {
			return getRuleContext(VaultContext.class,0);
		}
		public RevContext rev() {
			return getRuleContext(RevContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_create);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(T__14);
			setState(74); match(T__15);
			setState(75); type();
			setState(76); name();
			setState(77); rev();
			setState(78); match(T__4);
			setState(79); policy();
			setState(80); match(T__2);
			setState(81); vault();
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode DUMP() { return getToken(primeParser.DUMP, 0); }
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public TerminalNode OBJID() { return getToken(primeParser.OBJID, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(T__6);
			setState(84); match(T__15);
			setState(85); match(OBJID);
			setState(86); match(T__9);
			setState(87); limit();
			setState(88); select();
			setState(90);
			_la = _input.LA(1);
			if (_la==DUMP) {
				{
				setState(89); match(DUMP);
				}
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

	public static class SelectContext extends ParserRuleContext {
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); match(T__24);
			setState(93); selection();
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

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selection);
		try {
			setState(103);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(95); match(T__19);
				setState(96); field();
				setState(97); match(T__12);
				setState(98); selection();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(100); match(T__23);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(101); match(T__17);
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 4);
				{
				setState(102); match(WORD);
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

	public static class CriteriasContext extends ParserRuleContext {
		public CriteriaContext criteria(int i) {
			return getRuleContext(CriteriaContext.class,i);
		}
		public List<CriteriaContext> criteria() {
			return getRuleContexts(CriteriaContext.class);
		}
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public CriteriasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_criterias; }
	}

	public final CriteriasContext criterias() throws RecognitionException {
		CriteriasContext _localctx = new CriteriasContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_criterias);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(105); match(T__3);
				}
			}

			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(108); criteria();
					setState(109); conjunction();
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(116); criteria();
			setState(118);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(117); match(T__3);
				}
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

	public static class CriteriaContext extends ParserRuleContext {
		public TerminalNode CLOSECONDS() { return getToken(primeParser.CLOSECONDS, 0); }
		public TerminalNode OPENCONDS() { return getToken(primeParser.OPENCONDS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_criteria; }
	}

	public final CriteriaContext criteria() throws RecognitionException {
		CriteriaContext _localctx = new CriteriaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_criteria);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if (_la==OPENCONDS) {
				{
				setState(120); match(OPENCONDS);
				}
			}

			setState(123); expression();
			setState(124); operator();
			setState(125); value();
			setState(127);
			_la = _input.LA(1);
			if (_la==CLOSECONDS) {
				{
				setState(126); match(CLOSECONDS);
				}
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__13) | (1L << T__0))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ConjunctionContext extends ParserRuleContext {
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		public TerminalNode QUOTE(int i) {
			return getToken(primeParser.QUOTE, i);
		}
		public List<TerminalNode> QUOTE() { return getTokens(primeParser.QUOTE); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(primeParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(primeParser.RBRACKET, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			setState(148);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(133); match(T__22);
				setState(134); match(LBRACKET);
				setState(136);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(135); match(QUOTE);
					}
				}

				setState(138); field();
				setState(140);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(139); match(QUOTE);
					}
				}

				setState(142); match(RBRACKET);
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); method();
				setState(145); match(T__20);
				setState(146); match(T__8);
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

	public static class FieldContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(primeParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(primeParser.WORD, i);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(150); match(WORD);
				}
				}
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
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

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); match(WORD);
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

	public static class LimitContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(primeParser.NUMBER, 0); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); match(T__10);
			setState(158); match(NUMBER);
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

	public static class TypeContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(primeParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(primeParser.WORD, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(160); match(WORD);
					setState(162);
					_la = _input.LA(1);
					if (_la==T__11 || _la==T__7) {
						{
						setState(161);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(166); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(WORD);
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

	public static class RevContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public RevContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rev; }
	}

	public final RevContext rev() throws RecognitionException {
		RevContext _localctx = new RevContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rev);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); match(WORD);
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

	public static class PolicyContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public PolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policy; }
	}

	public final PolicyContext policy() throws RecognitionException {
		PolicyContext _localctx = new PolicyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_policy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(WORD);
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

	public static class VaultContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public VaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vault; }
	}

	public final VaultContext vault() throws RecognitionException {
		VaultContext _localctx = new VaultContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_vault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(WORD);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode QUOTE(int i) {
			return getToken(primeParser.QUOTE, i);
		}
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(primeParser.QUOTE); }
		public TerminalNode NUMBER() { return getToken(primeParser.NUMBER, 0); }
		public TerminalNode OBJID() { return getToken(primeParser.OBJID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if (_la==QUOTE) {
				{
				setState(176); match(QUOTE);
				}
			}

			setState(179);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJID) | (1L << NUMBER) | (1L << WORD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(181);
			_la = _input.LA(1);
			if (_la==QUOTE) {
				{
				setState(180); match(QUOTE);
				}
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u00ba\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\6\2\60\n\2\r\2"+
		"\16\2\61\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5F\n\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\tj\n\t\3\n\5\nm\n\n\3\n\3\n\3\n\7\nr\n\n\f\n\16"+
		"\nu\13\n\3\n\3\n\5\ny\n\n\3\13\5\13|\n\13\3\13\3\13\3\13\3\13\5\13\u0082"+
		"\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\5\16\u008b\n\16\3\16\3\16\5\16\u008f"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0097\n\16\3\17\6\17\u009a\n"+
		"\17\r\17\16\17\u009b\3\20\3\20\3\21\3\21\3\21\3\22\3\22\5\22\u00a5\n\22"+
		"\6\22\u00a7\n\22\r\22\16\22\u00a8\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\5\27\u00b4\n\27\3\27\3\27\5\27\u00b8\n\27\3\27\2\2\30\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\6\5\2\n\n\17\17\34\34\4\2\7"+
		"\7\f\f\4\2\21\21\25\25\4\2\35\36\"\"\u00b9\2/\3\2\2\2\4\65\3\2\2\2\6;"+
		"\3\2\2\2\b=\3\2\2\2\nK\3\2\2\2\fU\3\2\2\2\16^\3\2\2\2\20i\3\2\2\2\22l"+
		"\3\2\2\2\24{\3\2\2\2\26\u0083\3\2\2\2\30\u0085\3\2\2\2\32\u0096\3\2\2"+
		"\2\34\u0099\3\2\2\2\36\u009d\3\2\2\2 \u009f\3\2\2\2\"\u00a6\3\2\2\2$\u00aa"+
		"\3\2\2\2&\u00ac\3\2\2\2(\u00ae\3\2\2\2*\u00b0\3\2\2\2,\u00b3\3\2\2\2."+
		"\60\5\4\3\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3"+
		"\2\2\2\63\64\7\2\2\3\64\3\3\2\2\2\65\66\5\6\4\2\66\67\7#\2\2\67\5\3\2"+
		"\2\28<\5\b\5\29<\5\n\6\2:<\5\f\7\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<\7\3"+
		"\2\2\2=>\7\27\2\2>?\7\3\2\2?@\7\r\2\2@A\5\"\22\2AB\7\23\2\2BE\5 \21\2"+
		"CD\7\33\2\2DF\5\22\n\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GI\5\16\b\2HJ\7\37"+
		"\2\2IH\3\2\2\2IJ\3\2\2\2J\t\3\2\2\2KL\7\16\2\2LM\7\r\2\2MN\5\"\22\2NO"+
		"\5$\23\2OP\5&\24\2PQ\7\30\2\2QR\5(\25\2RS\7\32\2\2ST\5*\26\2T\13\3\2\2"+
		"\2UV\7\26\2\2VW\7\r\2\2WX\7\35\2\2XY\7\23\2\2YZ\5 \21\2Z\\\5\16\b\2[]"+
		"\7\37\2\2\\[\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^_\7\4\2\2_`\5\20\t\2`\17\3"+
		"\2\2\2ab\7\t\2\2bc\5\34\17\2cd\7\20\2\2de\5\20\t\2ej\3\2\2\2fj\7\5\2\2"+
		"gj\7\13\2\2hj\7\"\2\2ia\3\2\2\2if\3\2\2\2ig\3\2\2\2ih\3\2\2\2j\21\3\2"+
		"\2\2km\7\31\2\2lk\3\2\2\2lm\3\2\2\2ms\3\2\2\2no\5\24\13\2op\5\30\r\2p"+
		"r\3\2\2\2qn\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2"+
		"vx\5\24\13\2wy\7\31\2\2xw\3\2\2\2xy\3\2\2\2y\23\3\2\2\2z|\7 \2\2{z\3\2"+
		"\2\2{|\3\2\2\2|}\3\2\2\2}~\5\32\16\2~\177\5\26\f\2\177\u0081\5,\27\2\u0080"+
		"\u0082\7!\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\25\3\2\2\2"+
		"\u0083\u0084\t\2\2\2\u0084\27\3\2\2\2\u0085\u0086\t\3\2\2\u0086\31\3\2"+
		"\2\2\u0087\u0088\7\6\2\2\u0088\u008a\7&\2\2\u0089\u008b\7$\2\2\u008a\u0089"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\5\34\17\2"+
		"\u008d\u008f\7$\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0091\7\'\2\2\u0091\u0097\3\2\2\2\u0092\u0093\5\36\20\2"+
		"\u0093\u0094\7\b\2\2\u0094\u0095\7\24\2\2\u0095\u0097\3\2\2\2\u0096\u0087"+
		"\3\2\2\2\u0096\u0092\3\2\2\2\u0097\33\3\2\2\2\u0098\u009a\7\"\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\35\3\2\2\2\u009d\u009e\7\"\2\2\u009e\37\3\2\2\2\u009f\u00a0"+
		"\7\22\2\2\u00a0\u00a1\7\36\2\2\u00a1!\3\2\2\2\u00a2\u00a4\7\"\2\2\u00a3"+
		"\u00a5\t\4\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a2\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9#\3\2\2\2\u00aa\u00ab\7\"\2\2\u00ab%\3\2\2\2\u00ac"+
		"\u00ad\7\"\2\2\u00ad\'\3\2\2\2\u00ae\u00af\7\"\2\2\u00af)\3\2\2\2\u00b0"+
		"\u00b1\7\"\2\2\u00b1+\3\2\2\2\u00b2\u00b4\7$\2\2\u00b3\u00b2\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\t\5\2\2\u00b6\u00b8\7$"+
		"\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8-\3\2\2\2\25\61;EI\\"+
		"ilsx{\u0081\u008a\u008e\u0096\u009b\u00a4\u00a8\u00b3\u00b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}