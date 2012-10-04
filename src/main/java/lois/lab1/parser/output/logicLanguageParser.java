// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g 2012-10-04 08:01:20

    package lois.lab1.parser.output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LogicLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LOWER_SYMBOL", "UPPER_SYMBOL", "COMMENT", "WS", "'.'", "'('", "','", "')'", "'<-'", "';'", "'?'"
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



    // $ANTLR start "base"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:60:1: base : factList ( ruleList )? ;
    public final void base() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:61:2: ( factList ( ruleList )? )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:61:4: factList ( ruleList )?
            {
            pushFollow(FOLLOW_factList_in_base48);
            factList();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:61:13: ( ruleList )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==UPPER_SYMBOL) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:61:13: ruleList
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
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:64:1: factList : fact ( fact )* ;
    public final void factList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:65:2: ( fact ( fact )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:65:4: fact ( fact )*
            {
            pushFollow(FOLLOW_fact_in_factList63);
            fact();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:65:9: ( fact )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:65:9: fact
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
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:68:1: ruleList : rule ( rule )* ;
    public final void ruleList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:69:2: ( rule ( rule )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:69:4: rule ( rule )*
            {
            pushFollow(FOLLOW_rule_in_ruleList78);
            rule();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:69:9: ( rule )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==UPPER_SYMBOL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:69:9: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_ruleList80);
            	    rule();

            	    state._fsp--;


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


    // $ANTLR start "fact"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:72:1: fact : ( predicateFact | similarityRelation );
    public final void fact() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:73:2: ( predicateFact | similarityRelation )
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:73:4: predicateFact
                    {
                    pushFollow(FOLLOW_predicateFact_in_fact93);
                    predicateFact();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:73:20: similarityRelation
                    {
                    pushFollow(FOLLOW_similarityRelation_in_fact97);
                    similarityRelation();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "fact"


    // $ANTLR start "similarityRelation"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:76:1: similarityRelation : similarityName similarityNamePair '.' ;
    public final void similarityRelation() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:77:2: ( similarityName similarityNamePair '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:77:4: similarityName similarityNamePair '.'
            {
            pushFollow(FOLLOW_similarityName_in_similarityRelation109);
            similarityName();

            state._fsp--;

            pushFollow(FOLLOW_similarityNamePair_in_similarityRelation111);
            similarityNamePair();

            state._fsp--;

            match(input,8,FOLLOW_8_in_similarityRelation113); 

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
    // $ANTLR end "similarityRelation"


    // $ANTLR start "similarityNamePair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:80:1: similarityNamePair : ( predicateNamePair | constNamePair );
    public final void similarityNamePair() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:81:2: ( predicateNamePair | constNamePair )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==9) ) {
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:81:4: predicateNamePair
                    {
                    pushFollow(FOLLOW_predicateNamePair_in_similarityNamePair125);
                    predicateNamePair();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:81:24: constNamePair
                    {
                    pushFollow(FOLLOW_constNamePair_in_similarityNamePair129);
                    constNamePair();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "similarityNamePair"


    // $ANTLR start "predicateNamePair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:84:1: predicateNamePair : '(' predicateName ',' predicateName ')' ;
    public final void predicateNamePair() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:85:2: ( '(' predicateName ',' predicateName ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:85:4: '(' predicateName ',' predicateName ')'
            {
            match(input,9,FOLLOW_9_in_predicateNamePair141); 
            pushFollow(FOLLOW_predicateName_in_predicateNamePair143);
            predicateName();

            state._fsp--;

            match(input,10,FOLLOW_10_in_predicateNamePair145); 
            pushFollow(FOLLOW_predicateName_in_predicateNamePair147);
            predicateName();

            state._fsp--;

            match(input,11,FOLLOW_11_in_predicateNamePair149); 

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
    // $ANTLR end "predicateNamePair"


    // $ANTLR start "constNamePair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:88:1: constNamePair : '(' constant ',' constant ')' ;
    public final void constNamePair() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:89:2: ( '(' constant ',' constant ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:89:4: '(' constant ',' constant ')'
            {
            match(input,9,FOLLOW_9_in_constNamePair161); 
            pushFollow(FOLLOW_constant_in_constNamePair163);
            constant();

            state._fsp--;

            match(input,10,FOLLOW_10_in_constNamePair165); 
            pushFollow(FOLLOW_constant_in_constNamePair167);
            constant();

            state._fsp--;

            match(input,11,FOLLOW_11_in_constNamePair169); 

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
    // $ANTLR end "constNamePair"


    // $ANTLR start "predicateFact"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:93:1: predicateFact : predicateName '(' constList ')' '.' ;
    public final void predicateFact() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:94:2: ( predicateName '(' constList ')' '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:94:4: predicateName '(' constList ')' '.'
            {
            pushFollow(FOLLOW_predicateName_in_predicateFact184);
            predicateName();

            state._fsp--;

            match(input,9,FOLLOW_9_in_predicateFact186); 
            pushFollow(FOLLOW_constList_in_predicateFact188);
            constList();

            state._fsp--;

            match(input,11,FOLLOW_11_in_predicateFact190); 
            match(input,8,FOLLOW_8_in_predicateFact192); 

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
    // $ANTLR end "predicateFact"


    // $ANTLR start "constList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:97:1: constList : constant ( ',' constant )* ;
    public final void constList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:98:2: ( constant ( ',' constant )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:98:4: constant ( ',' constant )*
            {
            pushFollow(FOLLOW_constant_in_constList204);
            constant();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:98:13: ( ',' constant )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==10) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:98:14: ',' constant
            	    {
            	    match(input,10,FOLLOW_10_in_constList207); 
            	    pushFollow(FOLLOW_constant_in_constList209);
            	    constant();

            	    state._fsp--;


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
        return ;
    }
    // $ANTLR end "constList"


    // $ANTLR start "rule"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:101:1: rule : predicateTerm '<-' predicateTermList '.' ;
    public final void rule() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:102:2: ( predicateTerm '<-' predicateTermList '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:102:4: predicateTerm '<-' predicateTermList '.'
            {
            pushFollow(FOLLOW_predicateTerm_in_rule222);
            predicateTerm();

            state._fsp--;

            match(input,12,FOLLOW_12_in_rule224); 
            pushFollow(FOLLOW_predicateTermList_in_rule226);
            predicateTermList();

            state._fsp--;

            match(input,8,FOLLOW_8_in_rule228); 

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
    // $ANTLR end "rule"


    // $ANTLR start "predicateTermList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:105:1: predicateTermList : predicateTerm ( ';' predicateTerm )* ;
    public final void predicateTermList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:106:2: ( predicateTerm ( ';' predicateTerm )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:106:4: predicateTerm ( ';' predicateTerm )*
            {
            pushFollow(FOLLOW_predicateTerm_in_predicateTermList240);
            predicateTerm();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:106:18: ( ';' predicateTerm )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:106:19: ';' predicateTerm
            	    {
            	    match(input,13,FOLLOW_13_in_predicateTermList243); 
            	    pushFollow(FOLLOW_predicateTerm_in_predicateTermList245);
            	    predicateTerm();

            	    state._fsp--;


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
        return ;
    }
    // $ANTLR end "predicateTermList"


    // $ANTLR start "predicateTerm"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:109:1: predicateTerm : predicateName '(' argumentList ')' ;
    public final void predicateTerm() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:110:2: ( predicateName '(' argumentList ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:110:4: predicateName '(' argumentList ')'
            {
            pushFollow(FOLLOW_predicateName_in_predicateTerm259);
            predicateName();

            state._fsp--;

            match(input,9,FOLLOW_9_in_predicateTerm261); 
            pushFollow(FOLLOW_argumentList_in_predicateTerm263);
            argumentList();

            state._fsp--;

            match(input,11,FOLLOW_11_in_predicateTerm265); 

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
    // $ANTLR end "predicateTerm"


    // $ANTLR start "argumentList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:113:1: argumentList : argumentName ( ',' argumentName )* ;
    public final void argumentList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:114:2: ( argumentName ( ',' argumentName )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:114:4: argumentName ( ',' argumentName )*
            {
            pushFollow(FOLLOW_argumentName_in_argumentList277);
            argumentName();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:114:17: ( ',' argumentName )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==10) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:114:18: ',' argumentName
            	    {
            	    match(input,10,FOLLOW_10_in_argumentList280); 
            	    pushFollow(FOLLOW_argumentName_in_argumentList282);
            	    argumentName();

            	    state._fsp--;


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
        return ;
    }
    // $ANTLR end "argumentList"


    // $ANTLR start "argumentName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:117:1: argumentName : ( constant | variable );
    public final void argumentName() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:118:2: ( constant | variable )
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:118:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_argumentName295);
                    constant();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:118:15: variable
                    {
                    pushFollow(FOLLOW_variable_in_argumentName299);
                    variable();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "argumentName"


    // $ANTLR start "goal"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:121:1: goal : goalTermList ;
    public final void goal() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:122:2: ( goalTermList )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:122:4: goalTermList
            {
            pushFollow(FOLLOW_goalTermList_in_goal311);
            goalTermList();

            state._fsp--;


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
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:125:1: goalTermList : goalTerm ( ';' goalTerm )* ;
    public final void goalTermList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:126:2: ( goalTerm ( ';' goalTerm )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:126:4: goalTerm ( ';' goalTerm )*
            {
            pushFollow(FOLLOW_goalTerm_in_goalTermList322);
            goalTerm();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:126:13: ( ';' goalTerm )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==13) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:126:14: ';' goalTerm
            	    {
            	    match(input,13,FOLLOW_13_in_goalTermList325); 
            	    pushFollow(FOLLOW_goalTerm_in_goalTermList327);
            	    goalTerm();

            	    state._fsp--;


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
        return ;
    }
    // $ANTLR end "goalTermList"


    // $ANTLR start "goalTerm"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:129:1: goalTerm : predicateName '(' ( goalArgumentList )? ')' ;
    public final void goalTerm() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:130:2: ( predicateName '(' ( goalArgumentList )? ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:130:4: predicateName '(' ( goalArgumentList )? ')'
            {
            pushFollow(FOLLOW_predicateName_in_goalTerm340);
            predicateName();

            state._fsp--;

            match(input,9,FOLLOW_9_in_goalTerm342); 
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:130:22: ( goalArgumentList )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=LOWER_SYMBOL && LA11_0<=UPPER_SYMBOL)||LA11_0==14) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:130:22: goalArgumentList
                    {
                    pushFollow(FOLLOW_goalArgumentList_in_goalTerm344);
                    goalArgumentList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,11,FOLLOW_11_in_goalTerm347); 

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
    // $ANTLR end "goalTerm"


    // $ANTLR start "goalArgumentList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:133:1: goalArgumentList : goalArgumentName ( ',' goalArgumentName )* ;
    public final void goalArgumentList() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:134:2: ( goalArgumentName ( ',' goalArgumentName )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:134:4: goalArgumentName ( ',' goalArgumentName )*
            {
            pushFollow(FOLLOW_goalArgumentName_in_goalArgumentList358);
            goalArgumentName();

            state._fsp--;

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:134:21: ( ',' goalArgumentName )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==10) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:134:22: ',' goalArgumentName
            	    {
            	    match(input,10,FOLLOW_10_in_goalArgumentList361); 
            	    pushFollow(FOLLOW_goalArgumentName_in_goalArgumentList363);
            	    goalArgumentName();

            	    state._fsp--;


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
        return ;
    }
    // $ANTLR end "goalArgumentList"


    // $ANTLR start "goalArgumentName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:137:1: goalArgumentName : ( '?' | argumentName );
    public final void goalArgumentName() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:138:2: ( '?' | argumentName )
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:138:4: '?'
                    {
                    match(input,14,FOLLOW_14_in_goalArgumentName375); 

                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:138:10: argumentName
                    {
                    pushFollow(FOLLOW_argumentName_in_goalArgumentName379);
                    argumentName();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "goalArgumentName"


    // $ANTLR start "similarityName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:141:1: similarityName : ( LOWER_SYMBOL )+ ;
    public final void similarityName() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:142:2: ( ( LOWER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:142:4: ( LOWER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:142:4: ( LOWER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:142:4: LOWER_SYMBOL
            	    {
            	    match(input,LOWER_SYMBOL,FOLLOW_LOWER_SYMBOL_in_similarityName391); 

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
        return ;
    }
    // $ANTLR end "similarityName"


    // $ANTLR start "predicateName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:145:1: predicateName : ( UPPER_SYMBOL )+ ;
    public final void predicateName() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:146:2: ( ( UPPER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:146:4: ( UPPER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:146:4: ( UPPER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:146:4: UPPER_SYMBOL
            	    {
            	    match(input,UPPER_SYMBOL,FOLLOW_UPPER_SYMBOL_in_predicateName404); 

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
        return ;
    }
    // $ANTLR end "predicateName"


    // $ANTLR start "constant"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:149:1: constant : ( LOWER_SYMBOL )+ ;
    public final void constant() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:150:2: ( ( LOWER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:150:4: ( LOWER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:150:4: ( LOWER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:150:4: LOWER_SYMBOL
            	    {
            	    match(input,LOWER_SYMBOL,FOLLOW_LOWER_SYMBOL_in_constant417); 

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "constant"


    // $ANTLR start "variable"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:153:1: variable : ( UPPER_SYMBOL )+ ;
    public final void variable() throws RecognitionException {
        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:154:2: ( ( UPPER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:154:4: ( UPPER_SYMBOL )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:154:4: ( UPPER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:154:4: UPPER_SYMBOL
            	    {
            	    match(input,UPPER_SYMBOL,FOLLOW_UPPER_SYMBOL_in_variable430); 

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
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
        "\1\5\1\11\2\uffff\1\5\1\13\1\5\1\14\1\13";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1\5\uffff";
    static final String DFA2_specialS =
        "\11\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\1",
            "\1\1\3\uffff\1\4",
            "",
            "",
            "\1\5\1\2",
            "\1\5\5\uffff\1\6\1\7",
            "\1\10\1\2",
            "\1\3\3\uffff\1\2",
            "\1\10\5\uffff\1\6\1\7"
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
            return "()* loopback of 65:9: ( fact )*";
        }
    }
 

    public static final BitSet FOLLOW_factList_in_base48 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleList_in_base50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_in_factList63 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_fact_in_factList65 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule_in_ruleList78 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule_in_ruleList80 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_predicateFact_in_fact93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_similarityRelation_in_fact97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_similarityName_in_similarityRelation109 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_similarityNamePair_in_similarityRelation111 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_similarityRelation113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateNamePair_in_similarityNamePair125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constNamePair_in_similarityNamePair129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_predicateNamePair141 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateName_in_predicateNamePair143 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_predicateNamePair145 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateName_in_predicateNamePair147 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_predicateNamePair149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_constNamePair161 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constNamePair163 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_constNamePair165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constNamePair167 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_constNamePair169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateName_in_predicateFact184 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_predicateFact186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constList_in_predicateFact188 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_predicateFact190 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_predicateFact192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_constList204 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_constList207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constList209 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_predicateTerm_in_rule222 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rule224 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateTermList_in_rule226 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_rule228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateTerm_in_predicateTermList240 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_predicateTermList243 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateTerm_in_predicateTermList245 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_predicateName_in_predicateTerm259 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_predicateTerm261 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argumentList_in_predicateTerm263 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_predicateTerm265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argumentName_in_argumentList277 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_argumentList280 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argumentName_in_argumentList282 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_constant_in_argumentName295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_argumentName299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalTermList_in_goal311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalTerm_in_goalTermList322 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_goalTermList325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_goalTerm_in_goalTermList327 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_predicateName_in_goalTerm340 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_goalTerm342 = new BitSet(new long[]{0x0000000000004830L});
    public static final BitSet FOLLOW_goalArgumentList_in_goalTerm344 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_goalTerm347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalArgumentName_in_goalArgumentList358 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_goalArgumentList361 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_goalArgumentName_in_goalArgumentList363 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_14_in_goalArgumentName375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argumentName_in_goalArgumentName379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOWER_SYMBOL_in_similarityName391 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_UPPER_SYMBOL_in_predicateName404 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_LOWER_SYMBOL_in_constant417 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_UPPER_SYMBOL_in_variable430 = new BitSet(new long[]{0x0000000000000022L});

}