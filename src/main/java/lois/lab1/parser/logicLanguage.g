grammar logicLanguage;

options {
    language=Java;
    output=AST;
}


@header {
    package lois.lab1.parser.output;
}

@lexer::header {
    package lois.lab1.parser.output;
}

base
	: factList ruleList?
	;
	
factList
	: fact fact*
	;
	
ruleList
	: rule rule*
	;
	
fact
	: predicateFact | similarityRelation
	;
	
similarityRelation
	: similarityName similarityNamePair '.'
	;
	
similarityNamePair
	: predicateNamePair | constNamePair
	;
	
predicateNamePair
	: '(' predicateName ',' predicateName ')'
	;
	
constNamePair
	: '(' constant ',' constant ')'
	;
	
		
predicateFact
	: predicateName '(' constList ')' '.'
	;
	
constList
	: constant (',' constant)*
	;

rule
	: predicateTerm '<-' predicateTermList '.'
	;
	
predicateTermList
	: predicateTerm (';' predicateTerm)*
	;
	
predicateTerm
	: predicateName '(' argumentList ')'
	;
	
argumentList
	: argumentName (',' argumentName)*
	;

argumentName
	: constant | variable
	;
	
goal
	: goalTermList
	;

goalTermList
	: goalTerm (';' goalTerm)*
	;

goalTerm
	: predicateName '(' goalArgumentList? ')'
	;

goalArgumentList
	: goalArgumentName (',' goalArgumentName)*
;

goalArgumentName
	: '?' | argumentName
	;
	
similarityName
	: LOWER_SYMBOL+
	;
	
predicateName
	: UPPER_SYMBOL+
	;
	
constant
	: LOWER_SYMBOL+
	;
	
variable
	: UPPER_SYMBOL+
	;

	
UPPER_SYMBOL
	: 'A'..'Z'
;

LOWER_SYMBOL
	: 'a'..'z'
;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

WS
 	: ('\t' | '\r'? '\n' | ' ')+ { $channel = HIDDEN; }
 	;