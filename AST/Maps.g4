grammar Maps;

program : imports statement exports ; // AST Done

impexVarChain : var=IDENTIFIER COMMA impexVarChain // AST Done
	| var=IDENTIFIER
	;
imports : IMPORT LCURLY impexVarChain RCURLY FROM path=STRING_LITERAL SEMI imports // AST Done
	| 
	;
exports : EXPORT LCURLY impexVarChain RCURLY SEMI	// AST Done
	|
	;

indexedProp : LBRACK arithmeticExpression RBRACK indexedProp // AST Done
	|
	;

propChain : DOT name=IDENTIFIER indexedProp propChain // AST Done
	| DOT name=IDENTIFIER indexedProp
	;

lAccessor : name=IDENTIFIER indexedProp propChain // AST Done
	| name=IDENTIFIER indexedProp
	;
rAccessor : functionCall indexedProp propChain // AST Done
  | functionCall indexedProp
  ;
functionExpressionChain : expression COMMA functionExpressionChain // AST DONE
	| expression
	;
functionParams : LPAREN functionExpressionChain RPAREN // AST Done
	| LPAREN RPAREN
	;
functionCall : name=IDENTIFIER indexedProp functionParams // ast done
  | name=IDENTIFIER indexedProp
  ;

declaration : variableDeclaration // ast done
  | arrayDeclaration
  | mapDeclaration
  | recordDeclaration
  ;

variableDeclaration : dataType variableChain ; // ast done

variableChain : var=IDENTIFIER ASSIGN expression COMMA variableChain // ast done
  | var=IDENTIFIER ASSIGN expression																
  | var=IDENTIFIER COMMA variableChain															
  | var=IDENTIFIER																									
  ;
  
arrayLiteralChain : expression COMMA arrayLiteralChain
	| expression
	;
arrayLiteral : LBRACK arrayLiteralChain RBRACK // ast done
  | LBRACK RBRACK
  ;
arrayDeclBrackets : LBRACK RBRACK arrayDeclBrackets // ast done
	| LBRACK RBRACK
	;
arrayDeclaration : dataType arrayDeclBrackets arrayDeclIdentifier; // ast done
arrayDeclIdentifier : var=IDENTIFIER ASSIGN expression
	| var=IDENTIFIER ASSIGN arrayLiteral
	| var=IDENTIFIER
	;

mapDeclaration : MAP MLPAREN sizeX=INT_LITERAL COMMA sizeY=INT_LITERAL MRPAREN var=IDENTIFIER ASSIGN recordDeclarationBody // ast done
	| MAP MLPAREN sizeX=INT_LITERAL COMMA sizeY=INT_LITERAL MRPAREN var=IDENTIFIER
  ;

recordDeclarationBody : LCURLY variableDeclChain RCURLY ; // ast done
recordDeclaration : RECORD var=IDENTIFIER ASSIGN recordDeclarationBody // ast done
	| RECORD var=IDENTIFIER
	;
variableDeclChain : declaration SEMI variableDeclChain // ast done
	| declaration SEMI
	;

boolExpression : boolTerm OR boolExpression // ast done
	| boolTerm
	;
boolTerm : boolFactor AND boolTerm // ast done
  | boolFactor
  ;
negChain : neg=NEG negChain // ast done
	|
	;
boolFactor : comparisonExpression	 // ast done
  | negChain LPAREN boolExpression RPAREN
  | negChain rAccessor									
  | negChain value=BOOL_LITERAL					
  ;

stringExpression : stringTerm CONCAT stringExpression // ast done
	| stringTerm
	;
stringTerm : LPAREN stringExpression RPAREN // ast done
	| rAccessor															
	| value=STRING_LITERAL									
	;

comparisonExpression :  comparisonTerm op=(GT | LT | LTE | GTE | EQ | NEQ) comparisonTerm ; // ast done
comparisonTerm : negChain value=BOOL_LITERAL // ast done
  | negChain rAccessor											
  | negChain LPAREN boolExpression RPAREN		
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
  | rAccessor																					
  | value=(INT_LITERAL | DOUBLE_LITERAL)						
  ;

joinOperator : COLON op=(JOIN_X | JOIN_Y) HASH arithmeticExpression COLON // ast done
	| COLON op=(JOIN_X | JOIN_Y) COLON
	;
maskOperator : COLON MASK HASH arithmeticExpression COMMA arithmeticExpression COLON // ast done
	| COLON MASK COLON
	;
mapUnaryIndexedOperator : COLON op=(DROP_X | DROP_Y | INSERT_X | INSERT_Y) COLON arithmeticExpression ; // ast done
mapUnaryUnindexedOperator : COLON op=(ROTATE_CW | ROTATE_CCW | MIRROR_X | MIRROR_Y) ; // ast done
unaryMapOperator : mapUnaryIndexedOperator unaryMapOperator // ast done
	| mapUnaryUnindexedOperator unaryMapOperator
	;
unaryMapOperand : rAccessor // ast done
	| LPAREN joinExpression RPAREN
	;
unaryMapOperation : unaryMapOperand unaryMapOperator 
	| unaryMapOperand
	;
joinExpression : maskExpression joinOperator joinExpression // ast done
	| maskExpression
	;
maskExpression : unaryMapOperation maskOperator maskExpression // ast done
	| unaryMapOperation
	;
mapExpression : joinExpression ; // ast done

mapQueryChain: MLPAREN mapQueryPredicate MRPAREN mapQueryChain // ast done
	| MLPAREN mapQueryPredicate MRPAREN
	;
mapQuery : mapQueryChain // ast done
	| MLPAREN MRPAREN
	;
mapQueryPredicate : coordinateChain HASH boolExpression // ast done
  | boolExpression
  | coordinateChain
  ;
coordinateChain : coordinates COMMA coordinateChain // ast done
	| coordinates
	;
coordinates : LPAREN arithmeticExpression COMMA arithmeticExpression RPAREN ; // ast done

mapQueryAssignment : lAccessor mapQuery recordAssignmentBody ; // ast done

recordAssignmentBody: LCURLY recordAssignmentChain RCURLY // ast done
	| LCURLY RCURLY
	;
recordAssignment : lAccessor ASSIGN recordAssignmentBody ; // ast done
recordAssignmentChain : assignment SEMI recordAssignmentChain // ast done
	| declaration SEMI recordAssignmentChain
	| DELETE var=IDENTIFIER SEMI recordAssignmentChain
	| assignment SEMI
	| declaration SEMI
	| DELETE var=IDENTIFIER SEMI
	;

expression : arithmeticExpression	// AST Done
  | boolExpression 
  | mapExpression
  | comparisonExpression
	| stringExpression
  ;

assignment : nonRecordAssignment // AST Done
  | recordAssignment
  | mapQueryAssignment
  ;
nonRecordAssignment : lAccessor ASSIGN expression ;	// ast done

funcDataType : type=(BOOLEAN | STRING | DOUBLE | INT | MAP | RECORD);
functionDefinition : funcDataType name=IDENTIFIER functionHeader functionReturnBody
  | VOID name=IDENTIFIER functionHeader block 
  ;		    
functionHeader : LPAREN functionDeclParams RPAREN
	| LPAREN RPAREN
	;
functionDeclParams : funcDataType name=IDENTIFIER COMMA functionDeclParams
  | funcDataType name=IDENTIFIER
  ;
functionReturnBody : LCURLY statement returnStatement RCURLY ;
returnStatement : RETURN expression SEMI ;
dataType : type=(BOOLEAN | STRING | DOUBLE | INT ); // AST Done

ifStatement : IF LPAREN boolExpression RPAREN block ELSE block // AST Done
  | IF LPAREN boolExpression RPAREN block
  ;

whileStatement : WHILE LPAREN boolExpression RPAREN block; // AST Done

statement : declaration SEMI statement	// AST Done
	| expression SEMI statement
	| assignment SEMI statement
	| functionDefinition statement
	| ifStatement statement
	| whileStatement statement
	|
	;
		
block : LCURLY statement RCURLY ;

BOOLEAN:	'boolean' ;
STRING:		'string' ;
DOUBLE:		'double' ;
INT:			'int' ;
MAP:			'map' ;
VOID:     'void' ;
RECORD:		'record' ;
DELETE:		'delete' ;

ELSE:			'else' ;
FOR:			'for' ;
IF:				'if' ;
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
