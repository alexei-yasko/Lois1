// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g 2012-10-04 08:01:20

    package lois.lab1.parser.output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LogicLanguageLexer extends Lexer {
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

    public LogicLanguageLexer() {;} 
    public LogicLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:11:6: ( '.' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:11:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:12:6: ( '(' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:12:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:13:7: ( ',' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:14:7: ( ')' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:15:7: ( '<-' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:15:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:16:7: ( ';' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:16:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:17:7: ( '?' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:17:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "UPPER_SYMBOL"
    public final void mUPPER_SYMBOL() throws RecognitionException {
        try {
            int _type = UPPER_SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:159:2: ( 'A' .. 'Z' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:159:4: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPPER_SYMBOL"

    // $ANTLR start "LOWER_SYMBOL"
    public final void mLOWER_SYMBOL() throws RecognitionException {
        try {
            int _type = LOWER_SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:163:2: ( 'a' .. 'z' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:163:4: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOWER_SYMBOL"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:167:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:167:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:167:14: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:167:14: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:167:28: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:167:28: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:3: ( ( '\\t' | ( '\\r' )? '\\n' | ' ' )+ )
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:5: ( '\\t' | ( '\\r' )? '\\n' | ' ' )+
            {
            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:5: ( '\\t' | ( '\\r' )? '\\n' | ' ' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case '\t':
                    {
                    alt4=1;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt4=2;
                    }
                    break;
                case ' ':
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:6: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:13: ( '\\r' )? '\\n'
            	    {
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:13: ( '\\r' )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0=='\r') ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:13: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:171:26: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | UPPER_SYMBOL | LOWER_SYMBOL | COMMENT | WS )
        int alt5=11;
        switch ( input.LA(1) ) {
        case '.':
            {
            alt5=1;
            }
            break;
        case '(':
            {
            alt5=2;
            }
            break;
        case ',':
            {
            alt5=3;
            }
            break;
        case ')':
            {
            alt5=4;
            }
            break;
        case '<':
            {
            alt5=5;
            }
            break;
        case ';':
            {
            alt5=6;
            }
            break;
        case '?':
            {
            alt5=7;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt5=8;
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=9;
            }
            break;
        case '/':
            {
            alt5=10;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt5=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;
        }

        switch (alt5) {
            case 1 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:15: T__9
                {
                mT__9(); 

                }
                break;
            case 3 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:20: T__10
                {
                mT__10(); 

                }
                break;
            case 4 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:26: T__11
                {
                mT__11(); 

                }
                break;
            case 5 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:32: T__12
                {
                mT__12(); 

                }
                break;
            case 6 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:38: T__13
                {
                mT__13(); 

                }
                break;
            case 7 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:44: T__14
                {
                mT__14(); 

                }
                break;
            case 8 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:50: UPPER_SYMBOL
                {
                mUPPER_SYMBOL(); 

                }
                break;
            case 9 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:63: LOWER_SYMBOL
                {
                mLOWER_SYMBOL(); 

                }
                break;
            case 10 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:76: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 11 :
                // D:\\MyDocuments\\GitRepo\\Lois1\\src\\main\\java\\lois\\lab1\\parser\\LogicLanguage.g:1:84: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}