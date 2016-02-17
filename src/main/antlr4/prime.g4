/**
 * Define a grammar called prime
 */
grammar prime;
primerequest : (command SEMICOLON)* command SEMICOLON? EOF;

command : query;

query : SELECT returnedType limit? wherecriterias?;

wherecriterias: WHERE criterias;

criterias : DQUOTE? (criteria conjunction)* criteria DQUOTE?;
criteria : LPAREN* expression operator value RPAREN*?;

operator : EQUALS | DIFFERENT | LIKE;

conjunction: OR | AND;

expression : (ATTRIBUTE LBRACKET QUOTE? field QUOTE? RBRACKET) | method LPAREN RPAREN;

field : WORD;
method : WORD;

limit : LIMIT NUMBER;

returnedType : type | methodReturnType;
methodReturnType : objectPath;
type : WORD;
objectPath:(WORD(DOT|DOLLAR)?)+;

value : QUOTE? (WORD | NUMBER) QUOTE? ;

//keywords
SELECT:'select';
ADD:'add';
WHERE:'where';
OR:'or';
AND:'and';
LIMIT:'limit';
ATTRIBUTE:'attribute';

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
DOLLAR:'$';

NUMBER : [0-9]+;
WORD: [a-zA-Z][a-zA-Z0-9]*;

WHITESPACE : [ \t\r\n]+ -> skip ;

BOOLEAN : 'true' | 'false';

        