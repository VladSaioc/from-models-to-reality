grammar Maps;

program : imports statement exports ;

identifierChain : IDENTIFIER COMMA identifierChain
	| IDENTIFIER
	;
imports : IMPORT LCURLY identifierChain RCURLY FROM STRING_LITERAL SEMI imports
	|
	;
exports : EXPORT LCURLY identifierChain RCURLY SEMI
	|
	;

indexedProp : LBRACK expression RBRACK indexedProp
	|
	;
lAccessor : IDENTIFIER indexedProp DOT lAccessor
	| IDENTIFIER indexedProp
	;
rAccessor : functionCall indexedProp DOT lAccessor
  | functionCall indexedProp
  ;
functionExpressionChain : expression COMMA functionExpressionChain
	| expression
	;
functionCall : IDENTIFIER LPAREN functionExpressionChain RPAREN
  | IDENTIFIER LPAREN RPAREN
  | IDENTIFIER
  ;

declaration : variableDeclaration
  | arrayDeclaration
  | mapDeclaration
  | recordDeclaration
  ;

variableDeclaration : dataType variableChain ;

variableChain : IDENTIFIER ASSIGN expression COMMA variableChain
  | IDENTIFIER ASSIGN expression
  | IDENTIFIER COMMA variableChain
  | IDENTIFIER
  ;
  
arrayLiteralChain : expression COMMA arrayLiteralChain
	| expression
	;
arrayLiteral : LBRACK arrayLiteralChain RBRACK
  | LBRACK RBRACK
  ;
arrayDeclBrackets : LBRACK RBRACK arrayDeclBrackets
	| LBRACK RBRACK
	;

arrayDeclaration : dataType arrayDeclBrackets IDENTIFIER arrayDeclAssign;
arrayDeclAssign : ASSIGN expression
	| ASSIGN arrayLiteral
	| 
	;

mapDeclaration : MAP MLPAREN INT_LITERAL COMMA INT_LITERAL MRPAREN IDENTIFIER ASSIGN recordDeclarationBody
	| MAP MLPAREN INT_LITERAL COMMA INT_LITERAL MRPAREN IDENTIFIER
  ;

recordDeclarationBody : LCURLY variableDeclChain RCURLY ;
recordDeclaration : RECORD IDENTIFIER ASSIGN recordDeclarationBody ;
variableDeclChain : variableDeclaration SEMI variableDeclChain
	|
	;

boolExpression : boolTerm OR boolExpression
	| boolTerm
	;
boolTerm : boolFactor AND boolTerm
  | boolFactor
  ;
negChain : NEG negChain
	|
	;
boolFactor : comparisonExpression
  | negChain LPAREN boolExpression RPAREN
  | negChain rAccessor
  | negChain BOOL_LITERAL
  ;

stringExpression : stringTerm CONCAT stringExpression
	| stringTerm
	;
stringTerm : LPAREN stringExpression RPAREN
	| rAccessor
	| STRING_LITERAL
	;

comparisonOperator :  GT | LT | LTE | GTE | EQ | NEQ ;
comparisonExpression :  comparisonTerm comparisonOperator comparisonTerm ;
comparisonTerm : negChain BOOL_LITERAL
  | negChain rAccessor
  | negChain LPAREN boolExpression RPAREN
  | arithmeticExpression
  | stringExpression
  ;

arithmeticExpression : arithmeticTerm ADD arithmeticExpression
	| arithmeticTerm SUB arithmeticExpression
  | arithmeticTerm
  ;
arithmeticTerm : arithmeticFactor MUL arithmeticTerm
	| arithmeticFactor DIV arithmeticTerm
	| arithmeticFactor MOD arithmeticTerm
	| arithmeticFactor
	;
arithmeticFactor : LPAREN arithmeticExpression RPAREN 
  | rAccessor
  | number
  ;
number : INT_LITERAL 
  | DOUBLE_LITERAL
  ;

joinOperator : COLON JOIN_X HASH arithmeticExpression COLON
	| COLON JOIN_Y HASH arithmeticExpression COLON
	| COLON JOIN_X COLON
	| COLON JOIN_Y COLON
	;
maskOperator : COLON MASK HASH arithmeticExpression COMMA arithmeticExpression COLON
	| COLON MASK COLON
	;
dropOperator : COLON DROP_X COLON arithmeticExpression
	| COLON DROP_Y COLON arithmeticExpression
	;
insertOperator : COLON INSERT_X COLON arithmeticExpression
	| COLON INSERT_Y COLON arithmeticExpression
  ;
rotateOperator : COLON ROTATE_CW
  | COLON ROTATE_CCW
  ;
mirrorOperator : COLON MIRROR_X
  | COLON MIRROR_Y
  ;
unaryMapOperator : dropOperator unaryMapOperator
	| insertOperator unaryMapOperator
	| rotateOperator unaryMapOperator
	| mirrorOperator unaryMapOperator
	|
	;
unaryMapOperand : rAccessor
	| LPAREN joinExpression RPAREN
	;
unaryMapOperation : unaryMapOperand unaryMapOperator ;
joinExpression : maskExpression joinOperator joinExpression
	| maskExpression
	;
maskExpression : unaryMapOperation maskOperator maskExpression
	| unaryMapOperation
	;
mapExpression : joinExpression ;

mapQuery : MLPAREN mapQueryPredicate MRPAREN mapQuery
	|
	;
mapQueryPredicate : coordinateChain HASH boolExpression 
  | boolExpression
  | coordinateChain
  |
  ;
coordinateChain : coordinates COMMA coordinateChain
	| coordinates
	;
coordinates : LPAREN arithmeticExpression COMMA arithmeticExpression RPAREN ;

mapQueryAssignment : lAccessor mapQuery ASSIGN LCURLY recordAssignmentChain RCURLY ;

recordAssignment : lAccessor ASSIGN LCURLY recordAssignmentChain RCURLY ;
recordAssignmentChain : assignment SEMI recordAssignmentChain
	| variableDeclaration SEMI recordAssignmentChain
	| DELETE IDENTIFIER SEMI recordAssignmentChain
	|
	;

expression : arithmeticExpression
  | boolExpression 
  | mapExpression
  | comparisonExpression
	| stringExpression
  ;

assignment : nonRecordAssignment
  | recordAssignment
  | mapQueryAssignment
  ;
nonRecordAssignment : lAccessor ASSIGN expression ;	

functionDefinition : dataType functionHeader functionReturnBody
  | VOID functionHeader block 
  ;		    
functionHeader : IDENTIFIER LPAREN functionDeclParams RPAREN
	| IDENTIFIER LPAREN RPAREN
	;
functionDeclParams : IDENTIFIER COMMA functionDeclParams
  | dataType IDENTIFIER
  ;
functionReturnBody : LCURLY statement returnStatement RCURLY ;
returnStatement : RETURN expression SEMI ;
dataType : BOOLEAN | STRING | DOUBLE | INT ;

ifStatement : IF LPAREN boolExpression RPAREN block ELSE block
  | IF LPAREN boolExpression RPAREN block
  ;

whileStatement : WHILE LPAREN boolExpression RPAREN block;

control : ifStatement
  | whileStatement
  ;

statement : declaration SEMI statement
	| expression SEMI statement
	| assignment SEMI statement
	| functionDefinition statement
	| control statement
	|
	;
		
block : LCURLY statement RCURLY ;

BOOLEAN:		'boolean' ;
STRING:		'string' ;
DOUBLE:		'double' ;
INT:			'int' ;
MAP:			'map' ;
VOID:           'void' ;
RECORD:		'record' ;
DELETE:		'delete' ;

ELSE:			'else' ;
FOR:			'for' ;
IF:			'if' ;
WHILE:		'while' ;
BREAK:		'break' ;

RETURN:		'return' ;
IMPORT:		'import' ;
EXPORT:		'export' ;
FROM:			'from'   ;

WS: 			[ \t\r\n]+ -> skip ;
INT_LITERAL: 	'-'?[0-9]+ ;
DOUBLE_LITERAL:	'-'?[0-9]+'.'[0-9]+ ;
BOOL_LITERAL:	'true' | 'false' ;
STRING_LITERAL:	 '"' [ a-zA-Z0-9/.]+ '"' ;
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

MLPAREN:		':<' ;
MRPAREN:		'>:' ;
LPAREN:  		'(' ;
RPAREN:  		')' ;
LBRACK:  		'[' ;
RBRACK:  		']' ;
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
