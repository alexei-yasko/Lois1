// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g 2012-10-04 10:31:31

    package lois.lab1.parser.output;

	import lois.lab1.datastructure.TreeNode;
    import lois.lab1.datastructure.Variable;
	import lois.lab1.datastructure.Constant;
	import lois.lab1.datastructure.AtomSign;
	import lois.lab1.datastructure.Predicate;
	import lois.lab1.datastructure.Rule;
	import lois.lab1.datastructure.SimilarityRelation;
	import lois.lab1.datastructure.Goal;
	import lois.lab1.datastructure.KnowledgeBase;
    import lois.lab1.inference.Solver;


    import org.antlr.runtime.*;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.OutputStream;
    import java.util.List;
import java.util.ArrayList;

public class LogicLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LOWER_SYMBOL", "UPPER_SYMBOL", "COMMENT", "WS", "'<-'", "'.'", "'('", "','", "')'", "';'", "'?'"
    };
    public static final int WS=7;
    public static final int T__12=12;
    public static final int UPPER_SYMBOL=5;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int LOWER_SYMBOL=4;
    public static final int COMMENT=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;

    // delegates
    // delegators


        public LogicLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LogicLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return LogicLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g"; }



    	private static List<String> errorList = new ArrayList<String>();

    	private int errorLine;

    	private static Goal goal;

        public static void main(String[] args) throws Exception {

    		String baseFile = args[0];
        	//String baseFile = "knowledgeBase/knowledgeBase_2.txt";
        	String goalFile = args[1];
        	//String goalFile = "knowledgeBase/goal_2.txt";

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

            errorList.addAll(KnowledgeBase.getInstance().verifyKnowledgeBase());

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
        }

        public String getErrorHeader(RecognitionException e) {
            errorLine = e.line;
            return "";
        }

        public void emitErrorMessage(String message) {
            errorList.add("line " + errorLine + ": " + message);
        }



    // $ANTLR start "base"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:72:1: base : factList ( ruleList )? ;
    public final void base() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:73:2: ( factList ( ruleList )? )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:73:4: factList ( ruleList )?
            {
            pushFollow(FOLLOW_factList_in_base48);
            factList();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:73:13: ( ruleList )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==UPPER_SYMBOL) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:73:13: ruleList
                    {
                    pushFollow(FOLLOW_ruleList_in_base50);
                    ruleList();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "base"


    // $ANTLR start "factList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:76:1: factList : fact ( fact )* ;
    public final void factList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:77:2: ( fact ( fact )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:77:4: fact ( fact )*
            {
            pushFollow(FOLLOW_fact_in_factList63);
            fact();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:77:9: ( fact )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:77:9: fact
            	    {
            	    pushFollow(FOLLOW_fact_in_factList65);
            	    fact();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "factList"


    // $ANTLR start "ruleList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:80:1: ruleList : first= rule (second= rule )* ;
    public final void ruleList() throws RecognitionException {
        Rule first = null;

        Rule second = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:81:2: (first= rule (second= rule )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:81:4: first= rule (second= rule )*
            {
            pushFollow(FOLLOW_rule_in_ruleList80);
            first=rule();

            state._fsp--;

             KnowledgeBase.getInstance().addRule(first);
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:83:2: (second= rule )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==UPPER_SYMBOL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:83:3: second= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_ruleList92);
            	    second=rule();

            	    state._fsp--;

            	     KnowledgeBase.getInstance().addRule(second);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleList"


    // $ANTLR start "rule"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:86:1: rule returns [Rule object] : predicateTerm '<-' predicateTermList '.' ;
    public final Rule rule() throws RecognitionException {
        Rule object = null;

        Predicate predicateTerm1 = null;

        List<Predicate> predicateTermList2 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:87:2: ( predicateTerm '<-' predicateTermList '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:87:4: predicateTerm '<-' predicateTermList '.'
            {
            pushFollow(FOLLOW_predicateTerm_in_rule112);
            predicateTerm1=predicateTerm();

            state._fsp--;

            match(input,8,FOLLOW_8_in_rule114);
            pushFollow(FOLLOW_predicateTermList_in_rule116);
            predicateTermList2=predicateTermList();

            state._fsp--;

            match(input,9,FOLLOW_9_in_rule118);
             object = new Rule(predicateTerm1, predicateTermList2);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "rule"


    // $ANTLR start "fact"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:90:1: fact returns [Predicate object] : ( predicateFact | similarityRelation );
    public final Predicate fact() throws RecognitionException {
        Predicate object = null;

        Predicate predicateFact3 = null;

        SimilarityRelation similarityRelation4 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:91:2: ( predicateFact | similarityRelation )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==UPPER_SYMBOL) ) {
                alt4=1;
            }
            else if ( (LA4_0==LOWER_SYMBOL) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:91:4: predicateFact
                    {
                    pushFollow(FOLLOW_predicateFact_in_fact135);
                    predicateFact3=predicateFact();

                    state._fsp--;

                     KnowledgeBase.getInstance().addPredicate(predicateFact3);

                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:92:4: similarityRelation
                    {
                    pushFollow(FOLLOW_similarityRelation_in_fact142);
                    similarityRelation4=similarityRelation();

                    state._fsp--;

                     KnowledgeBase.getInstance().addSimilarityRelation(similarityRelation4);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "fact"


    // $ANTLR start "similarityRelation"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:95:1: similarityRelation returns [SimilarityRelation object] : similarityName similarityPair '.' ;
    public final SimilarityRelation similarityRelation() throws RecognitionException {
        SimilarityRelation object = null;

        String similarityName5 = null;

        LogicLanguageParser.similarityPair_return similarityPair6 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:96:2: ( similarityName similarityPair '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:96:4: similarityName similarityPair '.'
            {
            pushFollow(FOLLOW_similarityName_in_similarityRelation160);
            similarityName5=similarityName();

            state._fsp--;

            pushFollow(FOLLOW_similarityPair_in_similarityRelation162);
            similarityPair6=similarityPair();

            state._fsp--;

            match(input,9,FOLLOW_9_in_similarityRelation164);
             object = new SimilarityRelation(similarityName5, (similarityPair6!=null?similarityPair6.firstObject:null), (similarityPair6!=null?similarityPair6.secondObject:null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "similarityRelation"

    public static class similarityPair_return extends ParserRuleReturnScope {
        public AtomSign firstObject;
        public AtomSign secondObject;
    };

    // $ANTLR start "similarityPair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:100:1: similarityPair returns [AtomSign firstObject, AtomSign secondObject] : ( predicateNamePair | constantPair );
    public final LogicLanguageParser.similarityPair_return similarityPair() throws RecognitionException {
        LogicLanguageParser.similarityPair_return retval = new LogicLanguageParser.similarityPair_return();
        retval.start = input.LT(1);

        LogicLanguageParser.predicateNamePair_return predicateNamePair7 = null;

        LogicLanguageParser.constantPair_return constantPair8 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:101:2: ( predicateNamePair | constantPair )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==10) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==LOWER_SYMBOL) ) {
                    alt5=2;
                }
                else if ( (LA5_1==UPPER_SYMBOL) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:101:4: predicateNamePair
                    {
                    pushFollow(FOLLOW_predicateNamePair_in_similarityPair184);
                    predicateNamePair7=predicateNamePair();

                    state._fsp--;


                    		retval.firstObject = new Predicate((predicateNamePair7!=null?predicateNamePair7.firstName:null));
                    		retval.secondObject = new Predicate((predicateNamePair7!=null?predicateNamePair7.secondName:null));


                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:106:4: constantPair
                    {
                    pushFollow(FOLLOW_constantPair_in_similarityPair194);
                    constantPair8=constantPair();

                    state._fsp--;

                     retval.firstObject = (constantPair8!=null?constantPair8.firstObject:null); retval.secondObject = (constantPair8!=null?constantPair8.secondObject:null);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "similarityPair"

    public static class predicateNamePair_return extends ParserRuleReturnScope {
        public String firstName;
        public String secondName;
    };

    // $ANTLR start "predicateNamePair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:109:1: predicateNamePair returns [String firstName, String secondName] : '(' first= predicateName ',' second= predicateName ')' ;
    public final LogicLanguageParser.predicateNamePair_return predicateNamePair() throws RecognitionException {
        LogicLanguageParser.predicateNamePair_return retval = new LogicLanguageParser.predicateNamePair_return();
        retval.start = input.LT(1);

        String first = null;

        String second = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:110:2: ( '(' first= predicateName ',' second= predicateName ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:110:4: '(' first= predicateName ',' second= predicateName ')'
            {
            match(input,10,FOLLOW_10_in_predicateNamePair212);
            pushFollow(FOLLOW_predicateName_in_predicateNamePair216);
            first=predicateName();

            state._fsp--;

            match(input,11,FOLLOW_11_in_predicateNamePair218);
            pushFollow(FOLLOW_predicateName_in_predicateNamePair222);
            second=predicateName();

            state._fsp--;

            match(input,12,FOLLOW_12_in_predicateNamePair224);
             retval.firstName = first; retval.secondName = second;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicateNamePair"

    public static class constantPair_return extends ParserRuleReturnScope {
        public Constant firstObject;
        public Constant secondObject;
    };

    // $ANTLR start "constantPair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:113:1: constantPair returns [Constant firstObject, Constant secondObject] : '(' first= constant ',' second= constant ')' ;
    public final LogicLanguageParser.constantPair_return constantPair() throws RecognitionException {
        LogicLanguageParser.constantPair_return retval = new LogicLanguageParser.constantPair_return();
        retval.start = input.LT(1);

        Constant first = null;

        Constant second = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:114:2: ( '(' first= constant ',' second= constant ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:114:4: '(' first= constant ',' second= constant ')'
            {
            match(input,10,FOLLOW_10_in_constantPair242);
            pushFollow(FOLLOW_constant_in_constantPair246);
            first=constant();

            state._fsp--;

            match(input,11,FOLLOW_11_in_constantPair248);
            pushFollow(FOLLOW_constant_in_constantPair252);
            second=constant();

            state._fsp--;

            match(input,12,FOLLOW_12_in_constantPair254);
             retval.firstObject = first; retval.secondObject = second;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constantPair"


    // $ANTLR start "predicateFact"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:118:1: predicateFact returns [Predicate object] : predicateName '(' constList ')' '.' ;
    public final Predicate predicateFact() throws RecognitionException {
        Predicate object = null;

        String predicateName9 = null;

        List<Constant> constList10 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:119:2: ( predicateName '(' constList ')' '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:119:4: predicateName '(' constList ')' '.'
            {
            pushFollow(FOLLOW_predicateName_in_predicateFact275);
            predicateName9=predicateName();

            state._fsp--;

            match(input,10,FOLLOW_10_in_predicateFact277);
            pushFollow(FOLLOW_constList_in_predicateFact279);
            constList10=constList();

            state._fsp--;

            match(input,12,FOLLOW_12_in_predicateFact281);
            match(input,9,FOLLOW_9_in_predicateFact283);
             object = new Predicate(predicateName9, constList10);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "predicateFact"


    // $ANTLR start "constList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:122:1: constList returns [List<Constant> list] : first= constant ( ',' second= constant )* ;
    public final List<Constant> constList() throws RecognitionException {
        List<Constant> list = null;

        Constant first = null;

        Constant second = null;


         list = new ArrayList<Constant>();
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:124:2: (first= constant ( ',' second= constant )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:124:4: first= constant ( ',' second= constant )*
            {
            pushFollow(FOLLOW_constant_in_constList308);
            first=constant();

            state._fsp--;

             list.add(first);
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:124:49: ( ',' second= constant )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==11) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:124:50: ',' second= constant
            	    {
            	    match(input,11,FOLLOW_11_in_constList313);
            	    pushFollow(FOLLOW_constant_in_constList317);
            	    second=constant();

            	    state._fsp--;

            	     list.add(second);

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "constList"


    // $ANTLR start "predicateTermList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:127:1: predicateTermList returns [List<Predicate> list] : first= predicateTerm ( ';' second= predicateTerm )* ;
    public final List<Predicate> predicateTermList() throws RecognitionException {
        List<Predicate> list = null;

        Predicate first = null;

        Predicate second = null;


         list = new ArrayList<Predicate>();
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:129:2: (first= predicateTerm ( ';' second= predicateTerm )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:129:4: first= predicateTerm ( ';' second= predicateTerm )*
            {
            pushFollow(FOLLOW_predicateTerm_in_predicateTermList345);
            first=predicateTerm();

            state._fsp--;

             list.add(first);
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:129:54: ( ';' second= predicateTerm )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:129:55: ';' second= predicateTerm
            	    {
            	    match(input,13,FOLLOW_13_in_predicateTermList350);
            	    pushFollow(FOLLOW_predicateTerm_in_predicateTermList354);
            	    second=predicateTerm();

            	    state._fsp--;

            	     list.add(second);

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "predicateTermList"


    // $ANTLR start "predicateTerm"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:132:1: predicateTerm returns [Predicate object] : predicateName '(' argumentList ')' ;
    public final Predicate predicateTerm() throws RecognitionException {
        Predicate object = null;

        String predicateName11 = null;

        List<AtomSign> argumentList12 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:133:2: ( predicateName '(' argumentList ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:133:4: predicateName '(' argumentList ')'
            {
            pushFollow(FOLLOW_predicateName_in_predicateTerm375);
            predicateName11=predicateName();

            state._fsp--;

            match(input,10,FOLLOW_10_in_predicateTerm377);
            pushFollow(FOLLOW_argumentList_in_predicateTerm379);
            argumentList12=argumentList();

            state._fsp--;

            match(input,12,FOLLOW_12_in_predicateTerm381);
             object = new Predicate(predicateName11, argumentList12);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "predicateTerm"


    // $ANTLR start "argumentList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:136:1: argumentList returns [List<AtomSign> list] : first= argument ( ',' second= argument )* ;
    public final List<AtomSign> argumentList() throws RecognitionException {
        List<AtomSign> list = null;

        AtomSign first = null;

        AtomSign second = null;


         list = new ArrayList<AtomSign>();
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:138:2: (first= argument ( ',' second= argument )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:138:4: first= argument ( ',' second= argument )*
            {
            pushFollow(FOLLOW_argument_in_argumentList407);
            first=argument();

            state._fsp--;

             list.add(first);
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:138:49: ( ',' second= argument )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==11) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:138:50: ',' second= argument
            	    {
            	    match(input,11,FOLLOW_11_in_argumentList412);
            	    pushFollow(FOLLOW_argument_in_argumentList416);
            	    second=argument();

            	    state._fsp--;

            	     list.add(second);

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "argumentList"


    // $ANTLR start "argument"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:141:1: argument returns [AtomSign object] : ( constant | variable );
    public final AtomSign argument() throws RecognitionException {
        AtomSign object = null;

        Constant constant13 = null;

        Variable variable14 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:142:2: ( constant | variable )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LOWER_SYMBOL) ) {
                alt9=1;
            }
            else if ( (LA9_0==UPPER_SYMBOL) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:142:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_argument435);
                    constant13=constant();

                    state._fsp--;

                     object = constant13;

                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:143:4: variable
                    {
                    pushFollow(FOLLOW_variable_in_argument442);
                    variable14=variable();

                    state._fsp--;

                     object = variable14;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "argument"


    // $ANTLR start "goal"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:146:1: goal : goalTermList ;
    public final void goal() throws RecognitionException {
        List<Predicate> goalTermList15 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:147:2: ( goalTermList )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:147:4: goalTermList
            {
            pushFollow(FOLLOW_goalTermList_in_goal456);
            goalTermList15=goalTermList();

            state._fsp--;

             goal = new Goal(goalTermList15);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "goal"


    // $ANTLR start "goalTermList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:150:1: goalTermList returns [List<Predicate> list] : first= goalTerm ( ';' second= goalTerm )* ;
    public final List<Predicate> goalTermList() throws RecognitionException {
        List<Predicate> list = null;

        Predicate first = null;

        Predicate second = null;


         list = new ArrayList<Predicate>();
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:152:2: (first= goalTerm ( ';' second= goalTerm )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:152:4: first= goalTerm ( ';' second= goalTerm )*
            {
            pushFollow(FOLLOW_goalTerm_in_goalTermList481);
            first=goalTerm();

            state._fsp--;

             list.add(first);
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:152:49: ( ';' second= goalTerm )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==13) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:152:50: ';' second= goalTerm
            	    {
            	    match(input,13,FOLLOW_13_in_goalTermList486);
            	    pushFollow(FOLLOW_goalTerm_in_goalTermList490);
            	    second=goalTerm();

            	    state._fsp--;

            	     list.add(second);

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "goalTermList"


    // $ANTLR start "goalTerm"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:155:1: goalTerm returns [Predicate object] : predicateName '(' ( goalArgumentList )? ')' ;
    public final Predicate goalTerm() throws RecognitionException {
        Predicate object = null;

        String predicateName16 = null;

        List<AtomSign> goalArgumentList17 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:156:2: ( predicateName '(' ( goalArgumentList )? ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:156:4: predicateName '(' ( goalArgumentList )? ')'
            {
            pushFollow(FOLLOW_predicateName_in_goalTerm509);
            predicateName16=predicateName();

            state._fsp--;

            match(input,10,FOLLOW_10_in_goalTerm511);
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:156:22: ( goalArgumentList )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=LOWER_SYMBOL && LA11_0<=UPPER_SYMBOL)||LA11_0==14) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:156:22: goalArgumentList
                    {
                    pushFollow(FOLLOW_goalArgumentList_in_goalTerm513);
                    goalArgumentList17=goalArgumentList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_goalTerm516);
             object = new Predicate(predicateName16, goalArgumentList17);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "goalTerm"


    // $ANTLR start "goalArgumentList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:159:1: goalArgumentList returns [List<AtomSign> list] : first= goalArgument ( ',' second= goalArgument )* ;
    public final List<AtomSign> goalArgumentList() throws RecognitionException {
        List<AtomSign> list = null;

        AtomSign first = null;

        AtomSign second = null;


         list = new ArrayList<AtomSign>();
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:161:2: (first= goalArgument ( ',' second= goalArgument )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:161:4: first= goalArgument ( ',' second= goalArgument )*
            {
            pushFollow(FOLLOW_goalArgument_in_goalArgumentList540);
            first=goalArgument();

            state._fsp--;

             list.add(first);
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:161:53: ( ',' second= goalArgument )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==11) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:161:54: ',' second= goalArgument
            	    {
            	    match(input,11,FOLLOW_11_in_goalArgumentList545);
            	    pushFollow(FOLLOW_goalArgument_in_goalArgumentList549);
            	    second=goalArgument();

            	    state._fsp--;

            	     list.add(second);

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "goalArgumentList"


    // $ANTLR start "goalArgument"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:164:1: goalArgument returns [AtomSign object] : ( '?' | argument );
    public final AtomSign goalArgument() throws RecognitionException {
        AtomSign object = null;

        AtomSign argument18 = null;


        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:165:2: ( '?' | argument )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=LOWER_SYMBOL && LA13_0<=UPPER_SYMBOL)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:165:4: '?'
                    {
                    match(input,14,FOLLOW_14_in_goalArgument567);
                     object = new Variable("?");

                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:166:4: argument
                    {
                    pushFollow(FOLLOW_argument_in_goalArgument574);
                    argument18=argument();

                    state._fsp--;

                     object = argument18;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "goalArgument"


    // $ANTLR start "similarityName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:169:1: similarityName returns [String name] : ( LOWER_SYMBOL )+ ;
    public final String similarityName() throws RecognitionException {
        String name = null;

        Token LOWER_SYMBOL19=null;

         name = "";
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:2: ( ( LOWER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:4: ( LOWER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:4: ( LOWER_SYMBOL )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==LOWER_SYMBOL) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:5: LOWER_SYMBOL
            	    {
            	    LOWER_SYMBOL19=(Token)match(input,LOWER_SYMBOL,FOLLOW_LOWER_SYMBOL_in_similarityName598);
            	     name = name + LOWER_SYMBOL19.getText();

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end "similarityName"


    // $ANTLR start "predicateName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:174:1: predicateName returns [String name] : ( UPPER_SYMBOL )+ ;
    public final String predicateName() throws RecognitionException {
        String name = null;

        Token UPPER_SYMBOL20=null;

         name = "";
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:176:2: ( ( UPPER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:176:4: ( UPPER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:176:4: ( UPPER_SYMBOL )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==UPPER_SYMBOL) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:176:5: UPPER_SYMBOL
            	    {
            	    UPPER_SYMBOL20=(Token)match(input,UPPER_SYMBOL,FOLLOW_UPPER_SYMBOL_in_predicateName624);
            	     name = name + UPPER_SYMBOL20.getText();

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end "predicateName"


    // $ANTLR start "constant"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:179:1: constant returns [Constant object] : ( LOWER_SYMBOL )+ ;
    public final Constant constant() throws RecognitionException {
        Constant object = null;

        Token LOWER_SYMBOL21=null;

         String name = "";
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:182:2: ( ( LOWER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:182:4: ( LOWER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:182:4: ( LOWER_SYMBOL )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==LOWER_SYMBOL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:182:5: LOWER_SYMBOL
            	    {
            	    LOWER_SYMBOL21=(Token)match(input,LOWER_SYMBOL,FOLLOW_LOWER_SYMBOL_in_constant655);
            	     name = name + LOWER_SYMBOL21.getText();

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

             object = new Constant(name);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "constant"


    // $ANTLR start "variable"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:185:1: variable returns [Variable object] : ( UPPER_SYMBOL )+ ;
    public final Variable variable() throws RecognitionException {
        Variable object = null;

        Token UPPER_SYMBOL22=null;

         String name = "";
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:188:2: ( ( UPPER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:188:4: ( UPPER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:188:4: ( UPPER_SYMBOL )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==UPPER_SYMBOL) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:188:5: UPPER_SYMBOL
            	    {
            	    UPPER_SYMBOL22=(Token)match(input,UPPER_SYMBOL,FOLLOW_UPPER_SYMBOL_in_variable686);
            	     name = name + UPPER_SYMBOL22.getText();

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

             object = new Variable(name);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return object;
    }
    // $ANTLR end "variable"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\11\uffff";
    static final String DFA2_eofS =
        "\1\2\10\uffff";
    static final String DFA2_minS =
        "\1\4\1\5\2\uffff\3\4\1\10\1\4";
    static final String DFA2_maxS =
        "\1\5\1\12\2\uffff\1\5\1\14\1\5\1\11\1\14";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1\5\uffff";
    static final String DFA2_specialS =
        "\11\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\1",
            "\1\1\4\uffff\1\4",
            "",
            "",
            "\1\5\1\2",
            "\1\5\6\uffff\1\6\1\7",
            "\1\10\1\2",
            "\1\2\1\3",
            "\1\10\6\uffff\1\6\1\7"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 77:9: ( fact )*";
        }
    }


    public static final BitSet FOLLOW_factList_in_base48 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleList_in_base50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_in_factList63 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_fact_in_factList65 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule_in_ruleList80 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule_in_ruleList92 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_predicateTerm_in_rule112 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_rule114 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateTermList_in_rule116 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_rule118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateFact_in_fact135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_similarityRelation_in_fact142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_similarityName_in_similarityRelation160 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_similarityPair_in_similarityRelation162 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_similarityRelation164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateNamePair_in_similarityPair184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantPair_in_similarityPair194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_predicateNamePair212 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateName_in_predicateNamePair216 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_predicateNamePair218 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateName_in_predicateNamePair222 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_predicateNamePair224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_constantPair242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constantPair246 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_constantPair248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constantPair252 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_constantPair254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateName_in_predicateFact275 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_predicateFact277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constList_in_predicateFact279 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_predicateFact281 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_predicateFact283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_constList308 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_constList313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constList317 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_predicateTerm_in_predicateTermList345 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_predicateTermList350 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateTerm_in_predicateTermList354 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_predicateName_in_predicateTerm375 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_predicateTerm377 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argumentList_in_predicateTerm379 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_predicateTerm381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_argumentList407 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_argumentList412 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_argumentList416 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_constant_in_argument435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_argument442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalTermList_in_goal456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalTerm_in_goalTermList481 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_goalTermList486 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_goalTerm_in_goalTermList490 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_predicateName_in_goalTerm509 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_goalTerm511 = new BitSet(new long[]{0x0000000000005030L});
    public static final BitSet FOLLOW_goalArgumentList_in_goalTerm513 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_goalTerm516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalArgument_in_goalArgumentList540 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_goalArgumentList545 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_goalArgument_in_goalArgumentList549 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_14_in_goalArgument567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_goalArgument574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOWER_SYMBOL_in_similarityName598 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_UPPER_SYMBOL_in_predicateName624 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_LOWER_SYMBOL_in_constant655 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_UPPER_SYMBOL_in_variable686 = new BitSet(new long[]{0x0000000000000022L});

}