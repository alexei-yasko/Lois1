grammar LogicLanguage;

options {
    language=Java;
}


@header {
    package lois.lab1.parser.output;    
	
	import lois.lab1.datastructure.Variable;
	import lois.lab1.datastructure.Constant;
	import lois.lab1.datastructure.AtomSign;
	import lois.lab1.datastructure.Predicate;
	import lois.lab1.datastructure.Rule;
	import lois.lab1.datastructure.SimilarityRelation;
	import lois.lab1.datastructure.Goal;
	import lois.lab1.datastructure.KnowledgeBase;
}

@lexer::header {
    package lois.lab1.parser.output;
}

@members {

	private static List<String> errorList = new ArrayList<String>();
	
	private int errorLine;
	
	private static Goal goal;

    public static void main(String[] args) throws Exception {
    	
        //String baseFile = args[0];
        String baseFile = "knowledgeBase/knowledgeBase_0.txt";
        //String goalFile = args[1];
        String goalFile = "knowledgeBase/goal_0.txt";

        List<String> argumentsList = new ArrayList<String>();
        for (String arg : args) {
            argumentsList.add(arg);
        }

        boolean isShowTree = argumentsList.contains("-t");
        boolean isInFile = argumentsList.contains("-f");

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
            Solver solver = new Solver(KnowledgeBase.getInstance());
            List<TreeNode> solutionList = solver.solve(goal);

            for (TreeNode rootNode : solutionList) {
                String resultTable = rootNode.getRelationTable().printRelationTable();
                String tree = rootNode.printInferenceTree();

                showResult(resultTable, tree, isInFile, isShowTree);
            }
       	}
   	}

    private static void showResult(
        String resultTable, String tree, boolean isInFile, boolean isShowTree) throws IOException {

        if (isInFile) {
            File outputFile = new File("output.txt");
            FileWriter writer = new FileWriter(outputFile);
            writer.write("------------Result----------- \n\n");
            writer.write(resultTable);
            if (isShowTree) {
                writer.write("\n\n\n");
                writer.write("--------------Inference tree------------- \n\n");
                writer.write(tree);
            }
            writer.close();
        }
        else {
            System.out.println("--------------Result---------------\n");
            System.out.println(resultTable);
            if (isShowTree) {
            System.out.println("\n---------------------Inference tree------------------ \n");
            System.out.println(tree);
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
	: first=rule 
	{ KnowledgeBase.getInstance().addRule($first.object); }  
	(second=rule { KnowledgeBase.getInstance().addRule($second.object); })*
	;
	
rule returns [Rule object]
	: predicateTerm '<-' predicateTermList '.' { object = new Rule($predicateTerm.object, $predicateTermList.list); }
	;

fact returns [Predicate object]
	: predicateFact { KnowledgeBase.getInstance().addPredicate($predicateFact.object); }
	| similarityRelation { KnowledgeBase.getInstance().addSimilarityRelation($similarityRelation.object); }
	;
	
similarityRelation returns [SimilarityRelation object]
	: similarityName similarityPair '.' 
	{ $object = new SimilarityRelation($similarityName.name, $similarityPair.firstObject, $similarityPair.secondObject); }
	;
	
similarityPair returns [AtomSign firstObject, AtomSign secondObject]
	: predicateNamePair 
	{ 
		$firstObject = new Predicate($predicateNamePair.firstName); 
		$secondObject = new Predicate($predicateNamePair.secondName);
	} 
	| constantPair { $firstObject = $constantPair.firstObject; $secondObject = $constantPair.secondObject; }
	;
	
predicateNamePair returns [String firstName, String secondName]
	: '(' first=predicateName ',' second=predicateName ')' { $firstName = $first.name; $secondName = $second.name; }
	;
	
constantPair returns [Constant firstObject, Constant secondObject]
	: '(' first=constant ',' second=constant ')' { $firstObject = $first.object; $secondObject = $second.object; }
	;
	
		
predicateFact returns [Predicate object]
	: predicateName '(' constList ')' '.' { $object = new Predicate($predicateName.name, $constList.list); }
	;
	
constList returns [List<Constant> list]
@init { $list = new ArrayList<Constant>(); }
	: first=constant { $list.add($first.object); } (',' second=constant { $list.add($second.object); } )*
	;
	
predicateTermList returns [List<Predicate> list]
@init { $list = new ArrayList<Predicate>(); }
	: first=predicateTerm { $list.add($first.object); } (';' second=predicateTerm { list.add($second.object); } )*
	;
	
predicateTerm returns [Predicate object]
	: predicateName '(' argumentList ')' { $object = new Predicate($predicateName.name, $argumentList.list); } 
	;
	
argumentList returns [List<AtomSign> list]
@init { $list = new ArrayList<AtomSign>(); }
	: first=argument { $list.add($first.object); } (',' second=argument { $list.add($second.object); })*
	;

argument returns [AtomSign object]
	: constant { object = $constant.object; }
	| variable { object = $variable.object; }
	;
	
goal
	: goalTermList { goal = new Goal($goalTermList.list); } 
	;

goalTermList returns [List<Predicate> list]
@init { $list = new ArrayList<Predicate>(); }
	: first=goalTerm { $list.add($first.object); } (';' second=goalTerm { $list.add($second.object); })*
	;

goalTerm returns [Predicate object]
	: predicateName '(' goalArgumentList? ')' { $object = new Predicate($predicateName.name, $goalArgumentList.list); }
	;

goalArgumentList returns [List<AtomSign> list]
@init { $list = new ArrayList<AtomSign>(); }
	: first=goalArgument { $list.add($first.object); } (',' second=goalArgument { $list.add($second.object); })*
;

goalArgument returns [AtomSign object]
	: '?' { object = new Variable("?"); }
	| argument { object = $argument.object; }
	;
	
similarityName returns [String name]
@init { $name = ""; }
	: (LOWER_SYMBOL { $name = $name + $LOWER_SYMBOL.getText(); })+
	;
	
predicateName returns [String name]
@init { $name = ""; }
	: (UPPER_SYMBOL { $name = $name + $UPPER_SYMBOL.getText(); })+
	;
	
constant returns [Constant object]
@init { String name = "";}
@after { $object = new Constant(name); }
	: (LOWER_SYMBOL { name = name + $LOWER_SYMBOL.getText(); })+
	;
	
variable returns [Variable object]
@init { String name = "";}
@after { $object = new Variable(name); }
	: (UPPER_SYMBOL { name = name + $UPPER_SYMBOL.getText(); })+
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