/**
 * Define a grammar called prime
 */
grammar prime;

primerequest : (command SEMICOLON)* command SEMICOLON? EOF;

command : query;

query : SELECT returnedType limit? wherecriterias? saveAs?;

returnedType : type | methodReturnType | resultListType;
wherecriterias : WHERE (criterias | ONE);
saveAs : SAVEAS field;

methodReturnType : objectPath;

criterias : (criteria conjunction)* criteria;
criteria : LPAREN* expression operator value RPAREN*;

expression : (ATTRIBUTE LBRACKET QUOTE? field QUOTE? RBRACKET) | method LPAREN args? RPAREN;

args : (value COMMA)* value;

resultListType : (RESULTLIST LBRACKET QUOTE? field QUOTE? RBRACKET);

// non hierarchical nodes
limit : LIMIT NUMBER;
operator : EQUALS | DIFFERENT | LIKE;
objectPath : (WORD (DOT | DOLLAR)?)+;
conjunction : OR | AND;
value : QUOTE? (WORD | NUMBER) QUOTE? | DQUOTE ANYTHING_BUT_DQUOTE? DQUOTE;
field : WORD;
method : WORD;
type : WORD;

//keywords
SELECT : 'select';
ADD : 'add';
WHERE : 'where';
OR : 'or';
AND : 'and';
LIMIT : 'limit';
ATTRIBUTE : 'attribute';
RESULTLIST : 'resultList';
SAVEAS : 'saveAs';

//syntax
LPAREN : '(';
RPAREN : ')';
LBRACKET : '[';
RBRACKET : ']';
EQUALS : '==';
DIFFERENT : '!=';
LIKE : '~=';
SEMICOLON : ';';
QUOTE : '\'';
DQUOTE : '\"';
DOT : '.';
COMMA : ',';
DOLLAR : '$';
ONE : '1';
BOOLEAN : 'true' | 'false';

//pure regex
ANYTHING_BUT_DQUOTE : ([^"]|'\"')+;
NUMBER : [0-9]+;
WORD : [a-zA-Z][a-zA-Z0-9_]*;
WHITESPACE : [ \t\r\n]+ -> skip;

        