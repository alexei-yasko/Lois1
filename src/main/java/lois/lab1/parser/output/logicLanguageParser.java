// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g 2012-10-04 07:37:59

    package lois.lab1.parser.output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class logicLanguageParser extends Parser {
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


        public logicLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public logicLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return logicLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g"; }


    public static class base_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "base"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:17:1: base : factList ( ruleList )? ;
    public final logicLanguageParser.base_return base() throws RecognitionException {
        logicLanguageParser.base_return retval = new logicLanguageParser.base_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicLanguageParser.factList_return factList1 = null;

        logicLanguageParser.ruleList_return ruleList2 = null;



        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:18:2: ( factList ( ruleList )? )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:18:4: factList ( ruleList )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_factList_in_base50);
            factList1=factList();

            state._fsp--;

            adaptor.addChild(root_0, factList1.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:18:13: ( ruleList )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==UPPER_SYMBOL) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:18:13: ruleList
                    {
                    pushFollow(FOLLOW_ruleList_in_base52);
                    ruleList2=ruleList();

                    state._fsp--;

                    adaptor.addChild(root_0, ruleList2.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "base"

    public static class factList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:21:1: factList : fact ( fact )* ;
    public final logicLanguageParser.factList_return factList() throws RecognitionException {
        logicLanguageParser.factList_return retval = new logicLanguageParser.factList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicLanguageParser.fact_return fact3 = null;

        logicLanguageParser.fact_return fact4 = null;



        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:22:2: ( fact ( fact )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:22:4: fact ( fact )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_fact_in_factList65);
            fact3=fact();

            state._fsp--;

            adaptor.addChild(root_0, fact3.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:22:9: ( fact )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:22:9: fact
            	    {
            	    pushFollow(FOLLOW_fact_in_factList67);
            	    fact4=fact();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fact4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "factList"

    public static class ruleList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ruleList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:25:1: ruleList : rule ( rule )* ;
    public final logicLanguageParser.ruleList_return ruleList() throws RecognitionException {
        logicLanguageParser.ruleList_return retval = new logicLanguageParser.ruleList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicLanguageParser.rule_return rule5 = null;

        logicLanguageParser.rule_return rule6 = null;



        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:26:2: ( rule ( rule )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:26:4: rule ( rule )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_rule_in_ruleList80);
            rule5=rule();

            state._fsp--;

            adaptor.addChild(root_0, rule5.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:26:9: ( rule )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==UPPER_SYMBOL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:26:9: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_ruleList82);
            	    rule6=rule();

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule6.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ruleList"

    public static class fact_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fact"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:29:1: fact : ( predicateFact | similarityRelation );
    public final logicLanguageParser.fact_return fact() throws RecognitionException {
        logicLanguageParser.fact_return retval = new logicLanguageParser.fact_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicLanguageParser.predicateFact_return predicateFact7 = null;

        logicLanguageParser.similarityRelation_return similarityRelation8 = null;



        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:30:2: ( predicateFact | similarityRelation )
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:30:4: predicateFact
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_predicateFact_in_fact95);
                    predicateFact7=predicateFact();

                    state._fsp--;

                    adaptor.addChild(root_0, predicateFact7.getTree());

                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:30:20: similarityRelation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_similarityRelation_in_fact99);
                    similarityRelation8=similarityRelation();

                    state._fsp--;

                    adaptor.addChild(root_0, similarityRelation8.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fact"

    public static class similarityRelation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "similarityRelation"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:33:1: similarityRelation : similarityName similarityNamePair '.' ;
    public final logicLanguageParser.similarityRelation_return similarityRelation() throws RecognitionException {
        logicLanguageParser.similarityRelation_return retval = new logicLanguageParser.similarityRelation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal11=null;
        logicLanguageParser.similarityName_return similarityName9 = null;

        logicLanguageParser.similarityNamePair_return similarityNamePair10 = null;


        Object char_literal11_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:34:2: ( similarityName similarityNamePair '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:34:4: similarityName similarityNamePair '.'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_similarityName_in_similarityRelation111);
            similarityName9=similarityName();

            state._fsp--;

            adaptor.addChild(root_0, similarityName9.getTree());
            pushFollow(FOLLOW_similarityNamePair_in_similarityRelation113);
            similarityNamePair10=similarityNamePair();

            state._fsp--;

            adaptor.addChild(root_0, similarityNamePair10.getTree());
            char_literal11=(Token)match(input,8,FOLLOW_8_in_similarityRelation115); 
            char_literal11_tree = (Object)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "similarityRelation"

    public static class similarityNamePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "similarityNamePair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:37:1: similarityNamePair : ( predicateNamePair | constNamePair );
    public final logicLanguageParser.similarityNamePair_return similarityNamePair() throws RecognitionException {
        logicLanguageParser.similarityNamePair_return retval = new logicLanguageParser.similarityNamePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicLanguageParser.predicateNamePair_return predicateNamePair12 = null;

        logicLanguageParser.constNamePair_return constNamePair13 = null;



        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:38:2: ( predicateNamePair | constNamePair )
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:38:4: predicateNamePair
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_predicateNamePair_in_similarityNamePair127);
                    predicateNamePair12=predicateNamePair();

                    state._fsp--;

                    adaptor.addChild(root_0, predicateNamePair12.getTree());

                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:38:24: constNamePair
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constNamePair_in_similarityNamePair131);
                    constNamePair13=constNamePair();

                    state._fsp--;

                    adaptor.addChild(root_0, constNamePair13.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "similarityNamePair"

    public static class predicateNamePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicateNamePair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:41:1: predicateNamePair : '(' predicateName ',' predicateName ')' ;
    public final logicLanguageParser.predicateNamePair_return predicateNamePair() throws RecognitionException {
        logicLanguageParser.predicateNamePair_return retval = new logicLanguageParser.predicateNamePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal14=null;
        Token char_literal16=null;
        Token char_literal18=null;
        logicLanguageParser.predicateName_return predicateName15 = null;

        logicLanguageParser.predicateName_return predicateName17 = null;


        Object char_literal14_tree=null;
        Object char_literal16_tree=null;
        Object char_literal18_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:42:2: ( '(' predicateName ',' predicateName ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:42:4: '(' predicateName ',' predicateName ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal14=(Token)match(input,9,FOLLOW_9_in_predicateNamePair143); 
            char_literal14_tree = (Object)adaptor.create(char_literal14);
            adaptor.addChild(root_0, char_literal14_tree);

            pushFollow(FOLLOW_predicateName_in_predicateNamePair145);
            predicateName15=predicateName();

            state._fsp--;

            adaptor.addChild(root_0, predicateName15.getTree());
            char_literal16=(Token)match(input,10,FOLLOW_10_in_predicateNamePair147); 
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);

            pushFollow(FOLLOW_predicateName_in_predicateNamePair149);
            predicateName17=predicateName();

            state._fsp--;

            adaptor.addChild(root_0, predicateName17.getTree());
            char_literal18=(Token)match(input,11,FOLLOW_11_in_predicateNamePair151); 
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicateNamePair"

    public static class constNamePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constNamePair"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:45:1: constNamePair : '(' constant ',' constant ')' ;
    public final logicLanguageParser.constNamePair_return constNamePair() throws RecognitionException {
        logicLanguageParser.constNamePair_return retval = new logicLanguageParser.constNamePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        Token char_literal23=null;
        logicLanguageParser.constant_return constant20 = null;

        logicLanguageParser.constant_return constant22 = null;


        Object char_literal19_tree=null;
        Object char_literal21_tree=null;
        Object char_literal23_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:46:2: ( '(' constant ',' constant ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:46:4: '(' constant ',' constant ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,9,FOLLOW_9_in_constNamePair163); 
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);

            pushFollow(FOLLOW_constant_in_constNamePair165);
            constant20=constant();

            state._fsp--;

            adaptor.addChild(root_0, constant20.getTree());
            char_literal21=(Token)match(input,10,FOLLOW_10_in_constNamePair167); 
            char_literal21_tree = (Object)adaptor.create(char_literal21);
            adaptor.addChild(root_0, char_literal21_tree);

            pushFollow(FOLLOW_constant_in_constNamePair169);
            constant22=constant();

            state._fsp--;

            adaptor.addChild(root_0, constant22.getTree());
            char_literal23=(Token)match(input,11,FOLLOW_11_in_constNamePair171); 
            char_literal23_tree = (Object)adaptor.create(char_literal23);
            adaptor.addChild(root_0, char_literal23_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constNamePair"

    public static class predicateFact_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicateFact"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:50:1: predicateFact : predicateName '(' constList ')' '.' ;
    public final logicLanguageParser.predicateFact_return predicateFact() throws RecognitionException {
        logicLanguageParser.predicateFact_return retval = new logicLanguageParser.predicateFact_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal25=null;
        Token char_literal27=null;
        Token char_literal28=null;
        logicLanguageParser.predicateName_return predicateName24 = null;

        logicLanguageParser.constList_return constList26 = null;


        Object char_literal25_tree=null;
        Object char_literal27_tree=null;
        Object char_literal28_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:51:2: ( predicateName '(' constList ')' '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:51:4: predicateName '(' constList ')' '.'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_predicateName_in_predicateFact186);
            predicateName24=predicateName();

            state._fsp--;

            adaptor.addChild(root_0, predicateName24.getTree());
            char_literal25=(Token)match(input,9,FOLLOW_9_in_predicateFact188); 
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);

            pushFollow(FOLLOW_constList_in_predicateFact190);
            constList26=constList();

            state._fsp--;

            adaptor.addChild(root_0, constList26.getTree());
            char_literal27=(Token)match(input,11,FOLLOW_11_in_predicateFact192); 
            char_literal27_tree = (Object)adaptor.create(char_literal27);
            adaptor.addChild(root_0, char_literal27_tree);

            char_literal28=(Token)match(input,8,FOLLOW_8_in_predicateFact194); 
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicateFact"

    public static class constList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:54:1: constList : constant ( ',' constant )* ;
    public final logicLanguageParser.constList_return constList() throws RecognitionException {
        logicLanguageParser.constList_return retval = new logicLanguageParser.constList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal30=null;
        logicLanguageParser.constant_return constant29 = null;

        logicLanguageParser.constant_return constant31 = null;


        Object char_literal30_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:55:2: ( constant ( ',' constant )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:55:4: constant ( ',' constant )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_constant_in_constList206);
            constant29=constant();

            state._fsp--;

            adaptor.addChild(root_0, constant29.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:55:13: ( ',' constant )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==10) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:55:14: ',' constant
            	    {
            	    char_literal30=(Token)match(input,10,FOLLOW_10_in_constList209); 
            	    char_literal30_tree = (Object)adaptor.create(char_literal30);
            	    adaptor.addChild(root_0, char_literal30_tree);

            	    pushFollow(FOLLOW_constant_in_constList211);
            	    constant31=constant();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constant31.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constList"

    public static class rule_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:58:1: rule : predicateTerm '<-' predicateTermList '.' ;
    public final logicLanguageParser.rule_return rule() throws RecognitionException {
        logicLanguageParser.rule_return retval = new logicLanguageParser.rule_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal33=null;
        Token char_literal35=null;
        logicLanguageParser.predicateTerm_return predicateTerm32 = null;

        logicLanguageParser.predicateTermList_return predicateTermList34 = null;


        Object string_literal33_tree=null;
        Object char_literal35_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:59:2: ( predicateTerm '<-' predicateTermList '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:59:4: predicateTerm '<-' predicateTermList '.'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_predicateTerm_in_rule224);
            predicateTerm32=predicateTerm();

            state._fsp--;

            adaptor.addChild(root_0, predicateTerm32.getTree());
            string_literal33=(Token)match(input,12,FOLLOW_12_in_rule226); 
            string_literal33_tree = (Object)adaptor.create(string_literal33);
            adaptor.addChild(root_0, string_literal33_tree);

            pushFollow(FOLLOW_predicateTermList_in_rule228);
            predicateTermList34=predicateTermList();

            state._fsp--;

            adaptor.addChild(root_0, predicateTermList34.getTree());
            char_literal35=(Token)match(input,8,FOLLOW_8_in_rule230); 
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule"

    public static class predicateTermList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicateTermList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:62:1: predicateTermList : predicateTerm ( ';' predicateTerm )* ;
    public final logicLanguageParser.predicateTermList_return predicateTermList() throws RecognitionException {
        logicLanguageParser.predicateTermList_return retval = new logicLanguageParser.predicateTermList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal37=null;
        logicLanguageParser.predicateTerm_return predicateTerm36 = null;

        logicLanguageParser.predicateTerm_return predicateTerm38 = null;


        Object char_literal37_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:63:2: ( predicateTerm ( ';' predicateTerm )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:63:4: predicateTerm ( ';' predicateTerm )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_predicateTerm_in_predicateTermList242);
            predicateTerm36=predicateTerm();

            state._fsp--;

            adaptor.addChild(root_0, predicateTerm36.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:63:18: ( ';' predicateTerm )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:63:19: ';' predicateTerm
            	    {
            	    char_literal37=(Token)match(input,13,FOLLOW_13_in_predicateTermList245); 
            	    char_literal37_tree = (Object)adaptor.create(char_literal37);
            	    adaptor.addChild(root_0, char_literal37_tree);

            	    pushFollow(FOLLOW_predicateTerm_in_predicateTermList247);
            	    predicateTerm38=predicateTerm();

            	    state._fsp--;

            	    adaptor.addChild(root_0, predicateTerm38.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicateTermList"

    public static class predicateTerm_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicateTerm"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:66:1: predicateTerm : predicateName '(' argumentList ')' ;
    public final logicLanguageParser.predicateTerm_return predicateTerm() throws RecognitionException {
        logicLanguageParser.predicateTerm_return retval = new logicLanguageParser.predicateTerm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal40=null;
        Token char_literal42=null;
        logicLanguageParser.predicateName_return predicateName39 = null;

        logicLanguageParser.argumentList_return argumentList41 = null;


        Object char_literal40_tree=null;
        Object char_literal42_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:67:2: ( predicateName '(' argumentList ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:67:4: predicateName '(' argumentList ')'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_predicateName_in_predicateTerm261);
            predicateName39=predicateName();

            state._fsp--;

            adaptor.addChild(root_0, predicateName39.getTree());
            char_literal40=(Token)match(input,9,FOLLOW_9_in_predicateTerm263); 
            char_literal40_tree = (Object)adaptor.create(char_literal40);
            adaptor.addChild(root_0, char_literal40_tree);

            pushFollow(FOLLOW_argumentList_in_predicateTerm265);
            argumentList41=argumentList();

            state._fsp--;

            adaptor.addChild(root_0, argumentList41.getTree());
            char_literal42=(Token)match(input,11,FOLLOW_11_in_predicateTerm267); 
            char_literal42_tree = (Object)adaptor.create(char_literal42);
            adaptor.addChild(root_0, char_literal42_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicateTerm"

    public static class argumentList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argumentList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:70:1: argumentList : argumentName ( ',' argumentName )* ;
    public final logicLanguageParser.argumentList_return argumentList() throws RecognitionException {
        logicLanguageParser.argumentList_return retval = new logicLanguageParser.argumentList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal44=null;
        logicLanguageParser.argumentName_return argumentName43 = null;

        logicLanguageParser.argumentName_return argumentName45 = null;


        Object char_literal44_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:71:2: ( argumentName ( ',' argumentName )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:71:4: argumentName ( ',' argumentName )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_argumentName_in_argumentList279);
            argumentName43=argumentName();

            state._fsp--;

            adaptor.addChild(root_0, argumentName43.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:71:17: ( ',' argumentName )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==10) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:71:18: ',' argumentName
            	    {
            	    char_literal44=(Token)match(input,10,FOLLOW_10_in_argumentList282); 
            	    char_literal44_tree = (Object)adaptor.create(char_literal44);
            	    adaptor.addChild(root_0, char_literal44_tree);

            	    pushFollow(FOLLOW_argumentName_in_argumentList284);
            	    argumentName45=argumentName();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argumentName45.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argumentList"

    public static class argumentName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argumentName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:74:1: argumentName : ( constant | variable );
    public final logicLanguageParser.argumentName_return argumentName() throws RecognitionException {
        logicLanguageParser.argumentName_return retval = new logicLanguageParser.argumentName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicLanguageParser.constant_return constant46 = null;

        logicLanguageParser.variable_return variable47 = null;



        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:75:2: ( constant | variable )
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:75:4: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_argumentName297);
                    constant46=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant46.getTree());

                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:75:15: variable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_argumentName301);
                    variable47=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable47.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argumentName"

    public static class goal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "goal"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:78:1: goal : goalTermList ;
    public final logicLanguageParser.goal_return goal() throws RecognitionException {
        logicLanguageParser.goal_return retval = new logicLanguageParser.goal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        logicLanguageParser.goalTermList_return goalTermList48 = null;



        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:79:2: ( goalTermList )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:79:4: goalTermList
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_goalTermList_in_goal313);
            goalTermList48=goalTermList();

            state._fsp--;

            adaptor.addChild(root_0, goalTermList48.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "goal"

    public static class goalTermList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "goalTermList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:82:1: goalTermList : goalTerm ( ';' goalTerm )* ;
    public final logicLanguageParser.goalTermList_return goalTermList() throws RecognitionException {
        logicLanguageParser.goalTermList_return retval = new logicLanguageParser.goalTermList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal50=null;
        logicLanguageParser.goalTerm_return goalTerm49 = null;

        logicLanguageParser.goalTerm_return goalTerm51 = null;


        Object char_literal50_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:83:2: ( goalTerm ( ';' goalTerm )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:83:4: goalTerm ( ';' goalTerm )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_goalTerm_in_goalTermList324);
            goalTerm49=goalTerm();

            state._fsp--;

            adaptor.addChild(root_0, goalTerm49.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:83:13: ( ';' goalTerm )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==13) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:83:14: ';' goalTerm
            	    {
            	    char_literal50=(Token)match(input,13,FOLLOW_13_in_goalTermList327); 
            	    char_literal50_tree = (Object)adaptor.create(char_literal50);
            	    adaptor.addChild(root_0, char_literal50_tree);

            	    pushFollow(FOLLOW_goalTerm_in_goalTermList329);
            	    goalTerm51=goalTerm();

            	    state._fsp--;

            	    adaptor.addChild(root_0, goalTerm51.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "goalTermList"

    public static class goalTerm_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "goalTerm"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:86:1: goalTerm : predicateName '(' ( goalArgumentList )? ')' ;
    public final logicLanguageParser.goalTerm_return goalTerm() throws RecognitionException {
        logicLanguageParser.goalTerm_return retval = new logicLanguageParser.goalTerm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal53=null;
        Token char_literal55=null;
        logicLanguageParser.predicateName_return predicateName52 = null;

        logicLanguageParser.goalArgumentList_return goalArgumentList54 = null;


        Object char_literal53_tree=null;
        Object char_literal55_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:87:2: ( predicateName '(' ( goalArgumentList )? ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:87:4: predicateName '(' ( goalArgumentList )? ')'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_predicateName_in_goalTerm342);
            predicateName52=predicateName();

            state._fsp--;

            adaptor.addChild(root_0, predicateName52.getTree());
            char_literal53=(Token)match(input,9,FOLLOW_9_in_goalTerm344); 
            char_literal53_tree = (Object)adaptor.create(char_literal53);
            adaptor.addChild(root_0, char_literal53_tree);

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:87:22: ( goalArgumentList )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=LOWER_SYMBOL && LA11_0<=UPPER_SYMBOL)||LA11_0==14) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:87:22: goalArgumentList
                    {
                    pushFollow(FOLLOW_goalArgumentList_in_goalTerm346);
                    goalArgumentList54=goalArgumentList();

                    state._fsp--;

                    adaptor.addChild(root_0, goalArgumentList54.getTree());

                    }
                    break;

            }

            char_literal55=(Token)match(input,11,FOLLOW_11_in_goalTerm349); 
            char_literal55_tree = (Object)adaptor.create(char_literal55);
            adaptor.addChild(root_0, char_literal55_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "goalTerm"

    public static class goalArgumentList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "goalArgumentList"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:90:1: goalArgumentList : goalArgumentName ( ',' goalArgumentName )* ;
    public final logicLanguageParser.goalArgumentList_return goalArgumentList() throws RecognitionException {
        logicLanguageParser.goalArgumentList_return retval = new logicLanguageParser.goalArgumentList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal57=null;
        logicLanguageParser.goalArgumentName_return goalArgumentName56 = null;

        logicLanguageParser.goalArgumentName_return goalArgumentName58 = null;


        Object char_literal57_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:91:2: ( goalArgumentName ( ',' goalArgumentName )* )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:91:4: goalArgumentName ( ',' goalArgumentName )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_goalArgumentName_in_goalArgumentList360);
            goalArgumentName56=goalArgumentName();

            state._fsp--;

            adaptor.addChild(root_0, goalArgumentName56.getTree());
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:91:21: ( ',' goalArgumentName )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==10) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:91:22: ',' goalArgumentName
            	    {
            	    char_literal57=(Token)match(input,10,FOLLOW_10_in_goalArgumentList363); 
            	    char_literal57_tree = (Object)adaptor.create(char_literal57);
            	    adaptor.addChild(root_0, char_literal57_tree);

            	    pushFollow(FOLLOW_goalArgumentName_in_goalArgumentList365);
            	    goalArgumentName58=goalArgumentName();

            	    state._fsp--;

            	    adaptor.addChild(root_0, goalArgumentName58.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "goalArgumentList"

    public static class goalArgumentName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "goalArgumentName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:94:1: goalArgumentName : ( '?' | argumentName );
    public final logicLanguageParser.goalArgumentName_return goalArgumentName() throws RecognitionException {
        logicLanguageParser.goalArgumentName_return retval = new logicLanguageParser.goalArgumentName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal59=null;
        logicLanguageParser.argumentName_return argumentName60 = null;


        Object char_literal59_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:95:2: ( '?' | argumentName )
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
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:95:4: '?'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal59=(Token)match(input,14,FOLLOW_14_in_goalArgumentName377); 
                    char_literal59_tree = (Object)adaptor.create(char_literal59);
                    adaptor.addChild(root_0, char_literal59_tree);


                    }
                    break;
                case 2 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:95:10: argumentName
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_argumentName_in_goalArgumentName381);
                    argumentName60=argumentName();

                    state._fsp--;

                    adaptor.addChild(root_0, argumentName60.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "goalArgumentName"

    public static class similarityName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "similarityName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:98:1: similarityName : ( LOWER_SYMBOL )+ ;
    public final logicLanguageParser.similarityName_return similarityName() throws RecognitionException {
        logicLanguageParser.similarityName_return retval = new logicLanguageParser.similarityName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOWER_SYMBOL61=null;

        Object LOWER_SYMBOL61_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:99:2: ( ( LOWER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:99:4: ( LOWER_SYMBOL )+
            {
            root_0 = (Object)adaptor.nil();

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:99:4: ( LOWER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:99:4: LOWER_SYMBOL
            	    {
            	    LOWER_SYMBOL61=(Token)match(input,LOWER_SYMBOL,FOLLOW_LOWER_SYMBOL_in_similarityName393); 
            	    LOWER_SYMBOL61_tree = (Object)adaptor.create(LOWER_SYMBOL61);
            	    adaptor.addChild(root_0, LOWER_SYMBOL61_tree);


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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "similarityName"

    public static class predicateName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicateName"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:102:1: predicateName : ( UPPER_SYMBOL )+ ;
    public final logicLanguageParser.predicateName_return predicateName() throws RecognitionException {
        logicLanguageParser.predicateName_return retval = new logicLanguageParser.predicateName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPPER_SYMBOL62=null;

        Object UPPER_SYMBOL62_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:103:2: ( ( UPPER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:103:4: ( UPPER_SYMBOL )+
            {
            root_0 = (Object)adaptor.nil();

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:103:4: ( UPPER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:103:4: UPPER_SYMBOL
            	    {
            	    UPPER_SYMBOL62=(Token)match(input,UPPER_SYMBOL,FOLLOW_UPPER_SYMBOL_in_predicateName406); 
            	    UPPER_SYMBOL62_tree = (Object)adaptor.create(UPPER_SYMBOL62);
            	    adaptor.addChild(root_0, UPPER_SYMBOL62_tree);


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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicateName"

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:106:1: constant : ( LOWER_SYMBOL )+ ;
    public final logicLanguageParser.constant_return constant() throws RecognitionException {
        logicLanguageParser.constant_return retval = new logicLanguageParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOWER_SYMBOL63=null;

        Object LOWER_SYMBOL63_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:107:2: ( ( LOWER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:107:4: ( LOWER_SYMBOL )+
            {
            root_0 = (Object)adaptor.nil();

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:107:4: ( LOWER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:107:4: LOWER_SYMBOL
            	    {
            	    LOWER_SYMBOL63=(Token)match(input,LOWER_SYMBOL,FOLLOW_LOWER_SYMBOL_in_constant419); 
            	    LOWER_SYMBOL63_tree = (Object)adaptor.create(LOWER_SYMBOL63);
            	    adaptor.addChild(root_0, LOWER_SYMBOL63_tree);


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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constant"

    public static class variable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:110:1: variable : ( UPPER_SYMBOL )+ ;
    public final logicLanguageParser.variable_return variable() throws RecognitionException {
        logicLanguageParser.variable_return retval = new logicLanguageParser.variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPPER_SYMBOL64=null;

        Object UPPER_SYMBOL64_tree=null;

        try {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:111:2: ( ( UPPER_SYMBOL )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:111:4: ( UPPER_SYMBOL )+
            {
            root_0 = (Object)adaptor.nil();

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:111:4: ( UPPER_SYMBOL )+
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
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\logicLanguage.g:111:4: UPPER_SYMBOL
            	    {
            	    UPPER_SYMBOL64=(Token)match(input,UPPER_SYMBOL,FOLLOW_UPPER_SYMBOL_in_variable432); 
            	    UPPER_SYMBOL64_tree = (Object)adaptor.create(UPPER_SYMBOL64);
            	    adaptor.addChild(root_0, UPPER_SYMBOL64_tree);


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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
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
            return "()* loopback of 22:9: ( fact )*";
        }
    }
 

    public static final BitSet FOLLOW_factList_in_base50 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleList_in_base52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_in_factList65 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_fact_in_factList67 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule_in_ruleList80 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule_in_ruleList82 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_predicateFact_in_fact95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_similarityRelation_in_fact99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_similarityName_in_similarityRelation111 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_similarityNamePair_in_similarityRelation113 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_similarityRelation115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateNamePair_in_similarityNamePair127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constNamePair_in_similarityNamePair131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_predicateNamePair143 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateName_in_predicateNamePair145 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_predicateNamePair147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateName_in_predicateNamePair149 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_predicateNamePair151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_constNamePair163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constNamePair165 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_constNamePair167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constNamePair169 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_constNamePair171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateName_in_predicateFact186 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_predicateFact188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constList_in_predicateFact190 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_predicateFact192 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_predicateFact194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_constList206 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_constList209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constant_in_constList211 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_predicateTerm_in_rule224 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rule226 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateTermList_in_rule228 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_rule230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicateTerm_in_predicateTermList242 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_predicateTermList245 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_predicateTerm_in_predicateTermList247 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_predicateName_in_predicateTerm261 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_predicateTerm263 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argumentList_in_predicateTerm265 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_predicateTerm267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argumentName_in_argumentList279 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_argumentList282 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argumentName_in_argumentList284 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_constant_in_argumentName297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_argumentName301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalTermList_in_goal313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalTerm_in_goalTermList324 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_goalTermList327 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_goalTerm_in_goalTermList329 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_predicateName_in_goalTerm342 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_goalTerm344 = new BitSet(new long[]{0x0000000000004830L});
    public static final BitSet FOLLOW_goalArgumentList_in_goalTerm346 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_goalTerm349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalArgumentName_in_goalArgumentList360 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_goalArgumentList363 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_goalArgumentName_in_goalArgumentList365 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_14_in_goalArgumentName377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argumentName_in_goalArgumentName381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOWER_SYMBOL_in_similarityName393 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_UPPER_SYMBOL_in_predicateName406 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_LOWER_SYMBOL_in_constant419 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_UPPER_SYMBOL_in_variable432 = new BitSet(new long[]{0x0000000000000022L});

}