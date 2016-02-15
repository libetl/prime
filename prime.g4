/**
 * Define a grammar called prime
 */
grammar prime;
primerequest : (command)+ EOF;

command : commandbody SEMICOLON;

commandbody : query | create | print;

query : 'temp' 'query' 'bus' type '* *' limit ('where' criterias)? select DUMP?;

create : 'add' 'bus' type name rev 'policy' policy 'vault' vault;

print : 'print' 'bus' OBJID '* *' limit select DUMP?;

select : 'select' selection;
selection : 'from[' field '].to.' selection | 'name' | 'id' | WORD;

criterias : '\"'? (criteria conjunction)* criteria '\"'?;
criteria : OPENCONDS? expression operator value CLOSECONDS?;

operator : '==' | '!=' | '~~';
conjunction: 'or' | 'and';
expression : ('attribute' LBRACKET QUOTE? field QUOTE? RBRACKET) | method '(' ')';

field : WORD+;
method : WORD;

limit : 'limit' NUMBER;

type : (WORD('.'|'$')?)+;
name : WORD;
rev : WORD;
policy : WORD;
vault: WORD;

value : QUOTE? (WORD | OBJID | NUMBER) QUOTE? ;

OBJID :  [0-9]+'.'[0-9]+'.'[0-9]+'.'[0-9]+;
NUMBER : [0-9]+;

DUMP : 'dump |';
OPENCONDS: ('(')+;
CLOSECONDS: (')')+;

WORD: [a-zA-Z][a-zA-Z0-9]*;

SEMICOLON : ';';
QUOTE : '\'';

WHITESPACE : [ \t\r\n]+ -> skip ;

LBRACKET :  '[';
RBRACKET :  ']';
        