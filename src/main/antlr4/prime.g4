/**
 * Define a grammar called prime
 */
grammar prime;
primerequest : (command SEMICOLON)* command SEMICOLON? EOF;

command : query;

query : SELECT returnedType limit? wherecriterias? saveAs?;

returnedType : type | methodReturnType;
limit : LIMIT NUMBER;
wherecriterias: WHERE (criterias | ONE);
saveAs : SAVEAS field;

methodReturnType : objectPath;

criterias : (criteria conjunction)* criteria;
criteria : LPAREN* expression operator value RPAREN*;

expression : ((ATTRIBUTE | RESULTLIST) LBRACKET QUOTE? field QUOTE? RBRACKET) | method LPAREN args? RPAREN;

args : (value COMMA)* value;

operator : EQUALS | DIFFERENT | LIKE;
field : WORD;
method : WORD;

conjunction: OR | AND;
type : WORD;
objectPath:(WORD(DOT|DOLLAR)?)+;

value : QUOTE? (WORD | NUMBER) QUOTE? | DQUOTE ANYTHING_BUT_DQUOTE? DQUOTE ;

//keywords
SELECT:'select';
ADD:'add';
WHERE:'where';
OR:'or';
AND:'and';
LIMIT:'limit';
ATTRIBUTE:'attribute';
RESULTLIST:'resultList';
SAVEAS: 'saveAs';

//syntax
LPAREN: '(';
RPAREN: ')';
LBRACKET :  '[';
RBRACKET :  ']';
EQUALS:'==';
DIFFERENT:'!=';
LIKE:'~=';
SEMICOLON : ';';
QUOTE : '\'';
DQUOTE : '\"';
DOT:'.';
COMMA:',';
DOLLAR:'$';
ONE:'1';
ANYTHING_BUT_DQUOTE: ([^"]|'\"')+;

NUMBER : [0-9]+;
WORD: [a-zA-Z][a-zA-Z0-9]*;

WHITESPACE : [ \t\r\n]+ -> skip ;

BOOLEAN : 'true' | 'false';

        