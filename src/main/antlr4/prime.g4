/**
 * Define a grammar called prime
 */
grammar prime;

primerequest : (command SEMICOLON)* command SEMICOLON? EOF;

command : query;

query : SELECT returnedType wherecriterias? limit? saveAs?;

returnedType : type | methodReturnType | resultSetType;
wherecriterias : WHERE (criterias | TRUE);
saveAs : SAVEAS QUOTE? field QUOTE?;

methodReturnType : objectPath;

criterias : (criteria conjunction)* criteria;
criteria : LPAREN* expression operator value RPAREN*;

expression : (ATTRIBUTE LBRACKET  field QUOTE? RBRACKET) | method LPAREN args? RPAREN;

args : namedArgs | refArgs;
namedArgs : (value COMMA)* value;
refArgs : SAVEDARGS HASH UUID;

resultSetType : (RESULTSET LBRACKET QUOTE? field QUOTE? RBRACKET);

limit : LIMIT integer;
value : (QUOTE? (WORD | number) QUOTE?) | (DQUOTE ANYTHING_BUT_DQUOTE? DQUOTE);

// non hierarchical nodes
operator : EQUALS | DIFFERENT | LIKE;
objectPath : (WORD (DOT | DOLLAR)?)+;
conjunction : OR | AND;
field : WORD;
method : WORD;
type : WORD;
number : MINUS?DIGIT+(DOT DIGIT+)?;
integer : MINUS?DIGIT+;

//keywords
SELECT : 'select';
ADD : 'add';
WHERE : 'where';
OR : 'or';
AND : 'and';
LIMIT : 'limit';
ATTRIBUTE : 'attribute';
RESULTSET : 'resultSet';
SAVEAS : 'saveAs';
SAVEDARGS : 'savedArgs';

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
TRUE : 'true';
MINUS : '-';
HASH : '#';

//pure regex
ANYTHING_BUT_DQUOTE : ([^"]|'\"')+;
WORD : [a-zA-Z][a-zA-Z0-9_]*;
WHITESPACE : [ \t\r\n]+ -> skip;
DIGIT : [0-9];
UUID : [0-9a-f]+'-'[0-9a-f]+'-'[0-9a-f]+'-'[0-9a-f]+'-'[0-9a-f]+;

        
