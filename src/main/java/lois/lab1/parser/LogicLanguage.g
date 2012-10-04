grammar LogicLanguage;

options {
    language=Java;
}


@header {
    package lois.lab1.parser.output;
}

@lexer::header {
    package lois.lab1.parser.output;
}

@members {

	private static List<String> errorList = new ArrayList<String>();
	
	private int errorLine; 

    public static void main(String[] args) throws Exception {
    	
		//String codeFile = args[0];
    	String baseFile = "knowledgeBase/knowledgeBase.txt";
    	//String goalFile = args[1];
    	String goalFile = "knowledgeBase/goal.txt";

		//CharStream input = new ANTLRFileStream(args[0]);
		LogicLanguageLexer lexer = new LogicLanguageLexer(new ANTLRFileStream(baseFile));
        LogicLanguageParser parser = new LogicLanguageParser(new CommonTokenStream(lexer));
        parser.base();
        
        lexer = new LogicLanguageLexer(new ANTLRFileStream(goalFile));
        parser = new LogicLanguageParser(new CommonTokenStream(lexer));
        parser.goal();
        
        if (!errorList.isEmpty()) {
        	System.out.println("Next errors was found: ");
            
            for (String error : errorList) {
            	System.out.println(error);
            }
        } else {
            System.out.println("Success!");
       	}
   	}

    public String getErrorHeader(RecognitionException e) {
        errorLine = e.line;
        return "";
    }

    public void emitErrorMessage(String message) {
        errorList.add("line " + errorLine + ": " + message);
    }
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