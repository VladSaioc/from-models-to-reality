grammar Maps;

program : functions imports statement exports ; // AST Done

impexVarChain : var=IDENTIFIER COMMA impexVarChain // AST Done
	| var=IDENTIFIER
	;
imports : IMPORT LCURLY impexVarChain RCURLY FROM path=STRING_LITERAL SEMI imports // AST Done
	| 
	;
exports : EXPORT LCURLY impexVarChain RCURLY SEMI	// AST Done
	|
	;

rAccessor : functionCall
	| name=IDENTIFIER
  ;

functions : functionDef functions
	|
	;
functionDef : primitiveType name=IDENTIFIER LPAREN functionDefParams RPAREN LCURLY functionStatement RETURN expression SEMI RCURLY  ;
functionStatement : primitiveAssignment SEMI functionStatement
	| primitiveDeclaration SEMI functionStatement
	|	expression SEMI functionStatement
	|
	;
functionDefParams : primitiveType name=IDENTIFIER COMMA functionDefParams
  | primitiveType name=IDENTIFIER
  ;

primitiveType : type=( BOOLEAN | STRING | INT ); // AST Done

functionParams : expression COMMA functionParams // AST DONE
	| expression
	;

functionCall : name=IDENTIFIER LPAREN functionParams RPAREN ;

declaration : primitiveDeclaration 
  | mapDeclaration
  ;

primitiveDeclaration : primitiveType variableChain ; // ast done

variableChain : var=IDENTIFIER ASSIGN expression COMMA variableChain // ast done
  | var=IDENTIFIER ASSIGN expression																
  | var=IDENTIFIER COMMA variableChain															
  | var=IDENTIFIER																									
  ;

mapDeclaration : MAP var=IDENTIFIER MLPAREN arithmeticExpression COMMA arithmeticExpression MRPAREN ASSIGN mapPropsBody // ast done
	| MAP var=IDENTIFIER MLPAREN arithmeticExpression COMMA arithmeticExpression MRPAREN
  ;

boolExpression : boolTerm OR boolExpression // ast done
	| boolTerm
	;
boolTerm : boolFactor AND boolTerm // ast done
  | boolFactor
  ;
boolFactor : comparisonExpression	 // ast done
	| neg=NEG boolExpression
  | LPAREN boolExpression RPAREN
  | rAccessor									
  | value=BOOL_LITERAL					
  ;

stringExpression : stringTerm CONCAT stringExpression // ast done
	| stringTerm
	;
stringTerm : LPAREN stringExpression RPAREN // ast done
	| rAccessor						
	| value=STRING_LITERAL						
	;

comparisonExpression :  comparisonTerm op=(GT | LT | LTE | GTE | EQ | NEQ) comparisonTerm ; // ast done
comparisonTerm : LPAREN boolExpression RPAREN		
  | arithmeticExpression										
  | stringExpression												
  ;

arithmeticExpression : arithmeticTerm op=(ADD | SUB) arithmeticExpression // ast done
  | arithmeticTerm
  ;
arithmeticTerm : arithmeticFactor op=(MUL | DIV | MOD) arithmeticTerm // ast done
	| arithmeticFactor
	;
arithmeticFactor : LPAREN arithmeticExpression RPAREN // ast done
	| negated=SUB arithmeticExpression
  | rAccessor																					
  | value=INT_LITERAL
  ;

joinOperator : MLPAREN op=(JOIN_X | JOIN_Y) HASH arithmeticExpression MRPAREN // ast done
	| MLPAREN op=(JOIN_X | JOIN_Y) MRPAREN
	;
maskOperator : MLPAREN MASK HASH arithmeticExpression COMMA arithmeticExpression MRPAREN // ast done
	| MLPAREN MASK MRPAREN
	;
mapUnaryIndexedOperator : MLPAREN op=(DROP_X | DROP_Y | INSERT_X | INSERT_Y) HASH arithmeticExpression MRPAREN ; // ast done
mapUnaryUnindexedOperator : MLPAREN op=(ROTATE_CW | ROTATE_CCW | MIRROR_X | MIRROR_Y) MRPAREN ; // ast done
unaryMapOperator : mapUnaryIndexedOperator // ast done
	| mapUnaryUnindexedOperator
	;
unaryMapOperation : unaryMapOperator joinExpression
	| LPAREN joinExpression RPAREN
	| name=IDENTIFIER
	;
joinExpression : maskExpression joinOperator joinExpression // ast done
	| maskExpression
	;
maskExpression : unaryMapOperation maskOperator maskExpression // ast done
	| unaryMapOperation
	;
mapExpression : joinExpression ; // ast done

mapQuery : MLPAREN coordinateChain MRPAREN // ast done
	|
	;
coordinateChain : coordinates COMMA coordinateChain // ast done
	| coordinates
	;
coordinates : LPAREN arithmeticExpression COMMA arithmeticExpression RPAREN ; // ast done

mapPropsAssignment : name=IDENTIFIER mapQuery mapPropsBody ; // ast done

mapPropsBody: extended=EXTEND LCURLY mapPropsChain RCURLY // ast done
	| LCURLY mapPropsChain RCURLY
	;

mapPropsChain : primitiveType name=IDENTIFIER ASSIGN expression SEMI mapPropsChain
	| primitiveType name=IDENTIFIER ASSIGN expression SEMI
	;

expression : arithmeticExpression	// AST Done
  | boolExpression
  | comparisonExpression
	| stringExpression
  ;

assignment : primitiveAssignment // AST Done
	| mapAssignment
  | mapPropsAssignment
  ;

primitiveAssignment : name=IDENTIFIER ASSIGN expression ;	// ast done
mapAssignment : name=IDENTIFIER ASSIGN mapExpression ;

ifStatement : IF LPAREN boolExpression RPAREN block ELSE block // AST Done
  | IF LPAREN boolExpression RPAREN block
  ;

whileStatement : WHILE LPAREN boolExpression RPAREN block; // AST Done

statement : declaration SEMI statement	// AST Done
	| expression SEMI statement
	| assignment SEMI statement
	| ifStatement statement
	| whileStatement statement
	| mapExpression SEMI statement
	|
	;
		
block : LCURLY statement RCURLY ;

BOOLEAN:	'boolean' ;
STRING:		'string' ;
INT:			'int' ;
MAP:			'map' ;
VOID:     'void' ;
DELETE:		'delete' ;

ELSE:			'else' ;
FOR:			'for' ;
IF:				'if' ;
WHILE:		'while' ;
BREAK:		'break' ;
EXTEND:		'extend';

RETURN:		'return' ;
IMPORT:		'import' ;
EXPORT:		'export' ;
FROM:			'from'   ;

WS: 			[ \t\r\n]+ -> skip ;
INT_LITERAL: 	[0-9]+ ;
BOOL_LITERAL:	'true' | 'false' ;
STRING_LITERAL:	 '"' [ !a-zA-Z0-9/.]+ '"' ;
NULL:			'null' ;

JOIN_X:		'joinX' ;
JOIN_Y: 		'joinY' ;
INSERT_X:		'insertX' ;
INSERT_Y:		'insertY' ;
DROP_X:		'dropX' ;
DROP_Y:		'dropY' ;
MASK:      	'mask' ;
MIRROR_X:		'mirrorX' ;
MIRROR_Y:		'mirrorY' ;
ROTATE_CW:      'rotateCw' ;
ROTATE_CCW:     'rotateCcw' ;

IDENTIFIER:    	[a-zA-Z][a-zA-Z0-9]* ;

MLPAREN:		'[' ;
MRPAREN:		']' ;
LPAREN:  		'(' ;
RPAREN:  		')' ;
LCURLY:		'{' ;
RCURLY:		'}' ;
HASH:			'#' ;
SEMI:      	';' ;
COMMA:   		',' ;
DOT:      		'.' ;
COLON:          ':' ;

ASSIGN:         '=' ;
GT:             '>' ;
LT:             '<' ;
GTE:            '<=' ;
LTE:            '>=' ;
EQ:          	'==' ;
NEQ:   		'!=' ;
AND:          	'&&' ;
OR:       		'||' ;
NEG:			'!' ;

ADD:           	'+' ;
SUB:            '-' ;
MUL:            '*' ;
DIV:            '/' ;
MOD:			'%' ;

CONCAT: 		'++' ;

COMMENT:      '/*' .*? '*/' -> skip ;
LINE_COMMENT: '//' ~[\r\n]* -> skip ;