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
		SELECT=1, ADD=2, WITH=3, REMOVE=4, WHERE=5, LAZYLOADING=6, OR=7, AND=8, 
		LIMIT=9, ATTRIBUTE=10, LPAREN=11, RPAREN=12, LBRACKET=13, RBRACKET=14, 
		EQUALS=15, DIFFERENT=16, LIKE=17, SEMICOLON=18, QUOTE=19, DQUOTE=20, DOT=21, 
		DOLLAR=22, NUMBER=23, WORD=24, WHITESPACE=25, BOOLEAN=26;
	public static final String[] tokenNames = {
		"<INVALID>", "'select'", "'add'", "'with'", "'remove'", "'where'", "'lazyloading'", 
		"'or'", "'and'", "'limit'", "'attribute'", "'('", "')'", "'['", "']'", 
		"'=='", "'!='", "'~~'", "';'", "'''", "'\"'", "'.'", "'$'", "NUMBER", 
		"WORD", "WHITESPACE", "BOOLEAN"
	};
	public static final int
		RULE_primerequest = 0, RULE_command = 1, RULE_commandbody = 2, RULE_query = 3, 
		RULE_create = 4, RULE_remove = 5, RULE_wherecriterias = 6, RULE_lazyloading = 7, 
		RULE_criterias = 8, RULE_criteria = 9, RULE_operator = 10, RULE_conjunction = 11, 
		RULE_expression = 12, RULE_field = 13, RULE_method = 14, RULE_limit = 15, 
		RULE_returnedType = 16, RULE_methodReturnType = 17, RULE_type = 18, RULE_objectPath = 19, 
		RULE_value = 20;
	public static final String[] ruleNames = {
		"primerequest", "command", "commandbody", "query", "create", "remove", 
		"wherecriterias", "lazyloading", "criterias", "criteria", "operator", 
		"conjunction", "expression", "field", "method", "limit", "returnedType", 
		"methodReturnType", "type", "objectPath", "value"
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
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42); command();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << ADD) | (1L << REMOVE))) != 0) );
			setState(47); match(EOF);
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
			setState(49); commandbody();
			setState(50); match(SEMICOLON);
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
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public RemoveContext remove() {
			return getRuleContext(RemoveContext.class,0);
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
			setState(55);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(52); query();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 2);
				{
				setState(53); create();
				}
				break;
			case REMOVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(54); remove();
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
		public WherecriteriasContext wherecriterias() {
			return getRuleContext(WherecriteriasContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public LazyloadingContext lazyloading() {
			return getRuleContext(LazyloadingContext.class,0);
		}
		public ReturnedTypeContext returnedType() {
			return getRuleContext(ReturnedTypeContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(primeParser.SELECT, 0); }
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
			setState(57); match(SELECT);
			setState(58); returnedType();
			setState(60);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(59); limit();
				}
			}

			setState(63);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(62); wherecriterias();
				}
			}

			setState(66);
			_la = _input.LA(1);
			if (_la==LAZYLOADING) {
				{
				setState(65); lazyloading();
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
		public TerminalNode WITH() { return getToken(primeParser.WITH, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CriteriasContext criterias() {
			return getRuleContext(CriteriasContext.class,0);
		}
		public TerminalNode ADD() { return getToken(primeParser.ADD, 0); }
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
			setState(68); match(ADD);
			setState(69); type();
			setState(70); match(WITH);
			setState(71); criterias();
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

	public static class RemoveContext extends ParserRuleContext {
		public TerminalNode REMOVE() { return getToken(primeParser.REMOVE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public RemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remove; }
	}

	public final RemoveContext remove() throws RecognitionException {
		RemoveContext _localctx = new RemoveContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_remove);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(REMOVE);
			setState(75);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(74); type();
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

	public static class WherecriteriasContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(primeParser.WHERE, 0); }
		public CriteriasContext criterias() {
			return getRuleContext(CriteriasContext.class,0);
		}
		public WherecriteriasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherecriterias; }
	}

	public final WherecriteriasContext wherecriterias() throws RecognitionException {
		WherecriteriasContext _localctx = new WherecriteriasContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_wherecriterias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); match(WHERE);
			setState(78); criterias();
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

	public static class LazyloadingContext extends ParserRuleContext {
		public TerminalNode LAZYLOADING() { return getToken(primeParser.LAZYLOADING, 0); }
		public TerminalNode BOOLEAN() { return getToken(primeParser.BOOLEAN, 0); }
		public LazyloadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lazyloading; }
	}

	public final LazyloadingContext lazyloading() throws RecognitionException {
		LazyloadingContext _localctx = new LazyloadingContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lazyloading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(LAZYLOADING);
			setState(81); match(BOOLEAN);
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
		public TerminalNode DQUOTE(int i) {
			return getToken(primeParser.DQUOTE, i);
		}
		public List<TerminalNode> DQUOTE() { return getTokens(primeParser.DQUOTE); }
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
			setState(84);
			_la = _input.LA(1);
			if (_la==DQUOTE) {
				{
				setState(83); match(DQUOTE);
				}
			}

			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86); criteria();
					setState(87); conjunction();
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(94); criteria();
			setState(96);
			_la = _input.LA(1);
			if (_la==DQUOTE) {
				{
				setState(95); match(DQUOTE);
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
		public TerminalNode LPAREN(int i) {
			return getToken(primeParser.LPAREN, i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(primeParser.RPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(primeParser.RPAREN); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(primeParser.LPAREN); }
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LPAREN) {
				{
				{
				setState(98); match(LPAREN);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104); expression();
			setState(105); operator();
			setState(106); value();
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(107); match(RPAREN);
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public TerminalNode EQUALS() { return getToken(primeParser.EQUALS, 0); }
		public TerminalNode DIFFERENT() { return getToken(primeParser.DIFFERENT, 0); }
		public TerminalNode LIKE() { return getToken(primeParser.LIKE, 0); }
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
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << DIFFERENT) | (1L << LIKE))) != 0)) ) {
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
		public TerminalNode AND() { return getToken(primeParser.AND, 0); }
		public TerminalNode OR() { return getToken(primeParser.OR, 0); }
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
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==OR || _la==AND) ) {
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
		public TerminalNode RPAREN() { return getToken(primeParser.RPAREN, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode ATTRIBUTE() { return getToken(primeParser.ATTRIBUTE, 0); }
		public TerminalNode LPAREN() { return getToken(primeParser.LPAREN, 0); }
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
			setState(132);
			switch (_input.LA(1)) {
			case ATTRIBUTE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(117); match(ATTRIBUTE);
				setState(118); match(LBRACKET);
				setState(120);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(119); match(QUOTE);
					}
				}

				setState(122); field();
				setState(124);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(123); match(QUOTE);
					}
				}

				setState(126); match(RBRACKET);
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(128); method();
				setState(129); match(LPAREN);
				setState(130); match(RPAREN);
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
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(WORD);
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
			setState(136); match(WORD);
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
		public TerminalNode LIMIT() { return getToken(primeParser.LIMIT, 0); }
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
			setState(138); match(LIMIT);
			setState(139); match(NUMBER);
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

	public static class ReturnedTypeContext extends ParserRuleContext {
		public MethodReturnTypeContext methodReturnType() {
			return getRuleContext(MethodReturnTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReturnedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnedType; }
	}

	public final ReturnedTypeContext returnedType() throws RecognitionException {
		ReturnedTypeContext _localctx = new ReturnedTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnedType);
		try {
			setState(143);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); methodReturnType();
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

	public static class MethodReturnTypeContext extends ParserRuleContext {
		public ObjectPathContext objectPath() {
			return getRuleContext(ObjectPathContext.class,0);
		}
		public MethodReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReturnType; }
	}

	public final MethodReturnTypeContext methodReturnType() throws RecognitionException {
		MethodReturnTypeContext _localctx = new MethodReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_methodReturnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); objectPath();
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
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(WORD);
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

	public static class ObjectPathContext extends ParserRuleContext {
		public TerminalNode DOLLAR(int i) {
			return getToken(primeParser.DOLLAR, i);
		}
		public List<TerminalNode> WORD() { return getTokens(primeParser.WORD); }
		public List<TerminalNode> DOT() { return getTokens(primeParser.DOT); }
		public List<TerminalNode> DOLLAR() { return getTokens(primeParser.DOLLAR); }
		public TerminalNode DOT(int i) {
			return getToken(primeParser.DOT, i);
		}
		public TerminalNode WORD(int i) {
			return getToken(primeParser.WORD, i);
		}
		public ObjectPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPath; }
	}

	public final ObjectPathContext objectPath() throws RecognitionException {
		ObjectPathContext _localctx = new ObjectPathContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_objectPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149); match(WORD);
				setState(151);
				_la = _input.LA(1);
				if (_la==DOT || _la==DOLLAR) {
					{
					setState(150);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==DOLLAR) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				}
				setState(155); 
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode QUOTE(int i) {
			return getToken(primeParser.QUOTE, i);
		}
		public TerminalNode WORD() { return getToken(primeParser.WORD, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(primeParser.QUOTE); }
		public TerminalNode NUMBER() { return getToken(primeParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if (_la==QUOTE) {
				{
				setState(157); match(QUOTE);
				}
			}

			setState(160);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==WORD) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(162);
			_la = _input.LA(1);
			if (_la==QUOTE) {
				{
				setState(161); match(QUOTE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00a7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\6\2.\n\2\r\2\16\2/\3\2\3"+
		"\2\3\3\3\3\3\3\3\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\5\5?\n\5\3\5\5\5B\n\5"+
		"\3\5\5\5E\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\5\nW\n\n\3\n\3\n\3\n\7\n\\\n\n\f\n\16\n_\13\n\3\n\3\n\5\nc\n"+
		"\n\3\13\7\13f\n\13\f\13\16\13i\13\13\3\13\3\13\3\13\3\13\7\13o\n\13\f"+
		"\13\16\13r\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\5\16{\n\16\3\16\3\16\5"+
		"\16\177\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0087\n\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\5\22\u0092\n\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\5\25\u009a\n\25\6\25\u009c\n\25\r\25\16\25\u009d\3\26\5\26"+
		"\u00a1\n\26\3\26\3\26\5\26\u00a5\n\26\3\26\3p\2\27\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*\2\6\3\2\21\23\3\2\t\n\3\2\27\30\3\2\31\32\u00a5"+
		"\2-\3\2\2\2\4\63\3\2\2\2\69\3\2\2\2\b;\3\2\2\2\nF\3\2\2\2\fK\3\2\2\2\16"+
		"O\3\2\2\2\20R\3\2\2\2\22V\3\2\2\2\24g\3\2\2\2\26s\3\2\2\2\30u\3\2\2\2"+
		"\32\u0086\3\2\2\2\34\u0088\3\2\2\2\36\u008a\3\2\2\2 \u008c\3\2\2\2\"\u0091"+
		"\3\2\2\2$\u0093\3\2\2\2&\u0095\3\2\2\2(\u009b\3\2\2\2*\u00a0\3\2\2\2,"+
		".\5\4\3\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62"+
		"\7\2\2\3\62\3\3\2\2\2\63\64\5\6\4\2\64\65\7\24\2\2\65\5\3\2\2\2\66:\5"+
		"\b\5\2\67:\5\n\6\28:\5\f\7\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\7\3\2"+
		"\2\2;<\7\3\2\2<>\5\"\22\2=?\5 \21\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@B\5"+
		"\16\b\2A@\3\2\2\2AB\3\2\2\2BD\3\2\2\2CE\5\20\t\2DC\3\2\2\2DE\3\2\2\2E"+
		"\t\3\2\2\2FG\7\4\2\2GH\5&\24\2HI\7\5\2\2IJ\5\22\n\2J\13\3\2\2\2KM\7\6"+
		"\2\2LN\5&\24\2ML\3\2\2\2MN\3\2\2\2N\r\3\2\2\2OP\7\7\2\2PQ\5\22\n\2Q\17"+
		"\3\2\2\2RS\7\b\2\2ST\7\34\2\2T\21\3\2\2\2UW\7\26\2\2VU\3\2\2\2VW\3\2\2"+
		"\2W]\3\2\2\2XY\5\24\13\2YZ\5\30\r\2Z\\\3\2\2\2[X\3\2\2\2\\_\3\2\2\2]["+
		"\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`b\5\24\13\2ac\7\26\2\2ba\3\2\2"+
		"\2bc\3\2\2\2c\23\3\2\2\2df\7\r\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2"+
		"\2\2hj\3\2\2\2ig\3\2\2\2jk\5\32\16\2kl\5\26\f\2lp\5*\26\2mo\7\16\2\2n"+
		"m\3\2\2\2or\3\2\2\2pq\3\2\2\2pn\3\2\2\2q\25\3\2\2\2rp\3\2\2\2st\t\2\2"+
		"\2t\27\3\2\2\2uv\t\3\2\2v\31\3\2\2\2wx\7\f\2\2xz\7\17\2\2y{\7\25\2\2z"+
		"y\3\2\2\2z{\3\2\2\2{|\3\2\2\2|~\5\34\17\2}\177\7\25\2\2~}\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\20\2\2\u0081\u0087\3\2\2\2\u0082"+
		"\u0083\5\36\20\2\u0083\u0084\7\r\2\2\u0084\u0085\7\16\2\2\u0085\u0087"+
		"\3\2\2\2\u0086w\3\2\2\2\u0086\u0082\3\2\2\2\u0087\33\3\2\2\2\u0088\u0089"+
		"\7\32\2\2\u0089\35\3\2\2\2\u008a\u008b\7\32\2\2\u008b\37\3\2\2\2\u008c"+
		"\u008d\7\13\2\2\u008d\u008e\7\31\2\2\u008e!\3\2\2\2\u008f\u0092\5&\24"+
		"\2\u0090\u0092\5$\23\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092#"+
		"\3\2\2\2\u0093\u0094\5(\25\2\u0094%\3\2\2\2\u0095\u0096\7\32\2\2\u0096"+
		"\'\3\2\2\2\u0097\u0099\7\32\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2"+
		"\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0097\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e)\3\2\2\2\u009f"+
		"\u00a1\7\25\2\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3"+
		"\2\2\2\u00a2\u00a4\t\5\2\2\u00a3\u00a5\7\25\2\2\u00a4\u00a3\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5+\3\2\2\2\25/9>ADMV]bgpz~\u0086\u0091\u0099\u009d"+
		"\u00a0\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}