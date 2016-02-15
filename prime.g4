/**
 * Define a grammar called prime
 */
grammar prime;
primerequest : (command)+ EOF;

command : commandbody SEMICOLON;

commandbody : query | create | remove;

query : SELECT returnedType limit? wherecriterias? lazyloading?;



create : ADD type WITH criterias;

remove : REMOVE type ?;

wherecriterias: WHERE criterias;
lazyloading : LAZYLOADING BOOLEAN;

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
WITH:'with';
REMOVE:'remove';
WHERE:'where';
LAZYLOADING:'lazyloading';
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
DIFFERENT:'=';
LIKE:'~~';
SEMICOLON : ';';
QUOTE : '\'';
DQUOTE : '\"';
DOT:'.';
DOLLAR:'$';

NUMBER : [0-9]+;
WORD: [a-zA-Z][a-zA-Z0-9]*;

WHITESPACE : [ \t\r\n]+ -> skip ;

BOOLEAN : 'true' | 'false';

        