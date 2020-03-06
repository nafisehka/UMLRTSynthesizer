package umlrtsyntesizer.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import umlrtsyntesizer.services.ConstLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalConstLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_BOOLEAN", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Context'", "'{'", "'}'", "'Init'", "'Invariant'", "'Message'", "'('", "')'", "'Pre:'", "'Post:'", "'..'", "'-'", "'.'", "':'", "'range'", "'='", "'=>'", "'or'", "'and'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'+'", "'*'", "'/'", "'%'", "'not'", "'Boolean'", "'Integer'", "'Real'", "'Server'", "'Client'"
    };
    public static final int RULE_BOOLEAN=6;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalConstLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConstLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConstLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalConstLang.g"; }



     	private ConstLangGrammarAccess grammarAccess;

        public InternalConstLangParser(TokenStream input, ConstLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Context";
       	}

       	@Override
       	protected ConstLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleContext"
    // InternalConstLang.g:65:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalConstLang.g:65:48: (iv_ruleContext= ruleContext EOF )
            // InternalConstLang.g:66:2: iv_ruleContext= ruleContext EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContextRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContext=ruleContext();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContext; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalConstLang.g:72:1: ruleContext returns [EObject current=null] : (otherlv_0= 'Context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )+ ( (lv_init_4_0= ruleInit ) ) ( (lv_systemInvariants_5_0= ruleSystemInvariant ) )* ( (lv_messageConstraints_6_0= ruleMessageConstraint ) )* otherlv_7= '}' ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_init_4_0 = null;

        EObject lv_systemInvariants_5_0 = null;

        EObject lv_messageConstraints_6_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:78:2: ( (otherlv_0= 'Context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )+ ( (lv_init_4_0= ruleInit ) ) ( (lv_systemInvariants_5_0= ruleSystemInvariant ) )* ( (lv_messageConstraints_6_0= ruleMessageConstraint ) )* otherlv_7= '}' ) )
            // InternalConstLang.g:79:2: (otherlv_0= 'Context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )+ ( (lv_init_4_0= ruleInit ) ) ( (lv_systemInvariants_5_0= ruleSystemInvariant ) )* ( (lv_messageConstraints_6_0= ruleMessageConstraint ) )* otherlv_7= '}' )
            {
            // InternalConstLang.g:79:2: (otherlv_0= 'Context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )+ ( (lv_init_4_0= ruleInit ) ) ( (lv_systemInvariants_5_0= ruleSystemInvariant ) )* ( (lv_messageConstraints_6_0= ruleMessageConstraint ) )* otherlv_7= '}' )
            // InternalConstLang.g:80:3: otherlv_0= 'Context' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )+ ( (lv_init_4_0= ruleInit ) ) ( (lv_systemInvariants_5_0= ruleSystemInvariant ) )* ( (lv_messageConstraints_6_0= ruleMessageConstraint ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
              		
            }
            // InternalConstLang.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConstLang.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConstLang.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalConstLang.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getContextAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getContextRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalConstLang.g:106:3: ( (lv_attributes_3_0= ruleAttribute ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalConstLang.g:107:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalConstLang.g:107:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalConstLang.g:108:5: lv_attributes_3_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getContextAccess().getAttributesAttributeParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getContextRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_3_0,
            	      						"umlrtsyntesizer.ConstLang.Attribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // InternalConstLang.g:125:3: ( (lv_init_4_0= ruleInit ) )
            // InternalConstLang.g:126:4: (lv_init_4_0= ruleInit )
            {
            // InternalConstLang.g:126:4: (lv_init_4_0= ruleInit )
            // InternalConstLang.g:127:5: lv_init_4_0= ruleInit
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContextAccess().getInitInitParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_init_4_0=ruleInit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContextRule());
              					}
              					set(
              						current,
              						"init",
              						lv_init_4_0,
              						"umlrtsyntesizer.ConstLang.Init");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalConstLang.g:144:3: ( (lv_systemInvariants_5_0= ruleSystemInvariant ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalConstLang.g:145:4: (lv_systemInvariants_5_0= ruleSystemInvariant )
            	    {
            	    // InternalConstLang.g:145:4: (lv_systemInvariants_5_0= ruleSystemInvariant )
            	    // InternalConstLang.g:146:5: lv_systemInvariants_5_0= ruleSystemInvariant
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getContextAccess().getSystemInvariantsSystemInvariantParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_systemInvariants_5_0=ruleSystemInvariant();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getContextRule());
            	      					}
            	      					add(
            	      						current,
            	      						"systemInvariants",
            	      						lv_systemInvariants_5_0,
            	      						"umlrtsyntesizer.ConstLang.SystemInvariant");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalConstLang.g:163:3: ( (lv_messageConstraints_6_0= ruleMessageConstraint ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalConstLang.g:164:4: (lv_messageConstraints_6_0= ruleMessageConstraint )
            	    {
            	    // InternalConstLang.g:164:4: (lv_messageConstraints_6_0= ruleMessageConstraint )
            	    // InternalConstLang.g:165:5: lv_messageConstraints_6_0= ruleMessageConstraint
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getContextAccess().getMessageConstraintsMessageConstraintParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_messageConstraints_6_0=ruleMessageConstraint();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getContextRule());
            	      					}
            	      					add(
            	      						current,
            	      						"messageConstraints",
            	      						lv_messageConstraints_6_0,
            	      						"umlrtsyntesizer.ConstLang.MessageConstraint");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getContextAccess().getRightCurlyBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRuleInit"
    // InternalConstLang.g:190:1: entryRuleInit returns [EObject current=null] : iv_ruleInit= ruleInit EOF ;
    public final EObject entryRuleInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInit = null;


        try {
            // InternalConstLang.g:190:45: (iv_ruleInit= ruleInit EOF )
            // InternalConstLang.g:191:2: iv_ruleInit= ruleInit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInit=ruleInit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInit"


    // $ANTLR start "ruleInit"
    // InternalConstLang.g:197:1: ruleInit returns [EObject current=null] : (otherlv_0= 'Init' otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )+ otherlv_3= '}' ) ;
    public final EObject ruleInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:203:2: ( (otherlv_0= 'Init' otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )+ otherlv_3= '}' ) )
            // InternalConstLang.g:204:2: (otherlv_0= 'Init' otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )+ otherlv_3= '}' )
            {
            // InternalConstLang.g:204:2: (otherlv_0= 'Init' otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )+ otherlv_3= '}' )
            // InternalConstLang.g:205:3: otherlv_0= 'Init' otherlv_1= '{' ( (lv_expressions_2_0= ruleExpression ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInitAccess().getInitKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInitAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalConstLang.g:213:3: ( (lv_expressions_2_0= ruleExpression ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_BOOLEAN)||LA4_0==18||LA4_0==23||LA4_0==41) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalConstLang.g:214:4: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalConstLang.g:214:4: (lv_expressions_2_0= ruleExpression )
            	    // InternalConstLang.g:215:5: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInitAccess().getExpressionsExpressionParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_expressions_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getInitRule());
            	      					}
            	      					add(
            	      						current,
            	      						"expressions",
            	      						lv_expressions_2_0,
            	      						"umlrtsyntesizer.ConstLang.Expression");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInitAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInit"


    // $ANTLR start "entryRuleSystemInvariant"
    // InternalConstLang.g:240:1: entryRuleSystemInvariant returns [EObject current=null] : iv_ruleSystemInvariant= ruleSystemInvariant EOF ;
    public final EObject entryRuleSystemInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemInvariant = null;


        try {
            // InternalConstLang.g:240:56: (iv_ruleSystemInvariant= ruleSystemInvariant EOF )
            // InternalConstLang.g:241:2: iv_ruleSystemInvariant= ruleSystemInvariant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemInvariantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSystemInvariant=ruleSystemInvariant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemInvariant; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemInvariant"


    // $ANTLR start "ruleSystemInvariant"
    // InternalConstLang.g:247:1: ruleSystemInvariant returns [EObject current=null] : (otherlv_0= 'Invariant' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_invariantExp_3_0= ruleExpression ) ) otherlv_4= '}' ) ) ;
    public final EObject ruleSystemInvariant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_invariantExp_3_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:253:2: ( (otherlv_0= 'Invariant' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_invariantExp_3_0= ruleExpression ) ) otherlv_4= '}' ) ) )
            // InternalConstLang.g:254:2: (otherlv_0= 'Invariant' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_invariantExp_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            {
            // InternalConstLang.g:254:2: (otherlv_0= 'Invariant' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_invariantExp_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalConstLang.g:255:3: otherlv_0= 'Invariant' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_invariantExp_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSystemInvariantAccess().getInvariantKeyword_0());
              		
            }
            // InternalConstLang.g:259:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConstLang.g:260:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConstLang.g:260:4: (lv_name_1_0= RULE_ID )
            // InternalConstLang.g:261:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getSystemInvariantAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSystemInvariantRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalConstLang.g:277:3: (otherlv_2= '{' ( (lv_invariantExp_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalConstLang.g:278:4: otherlv_2= '{' ( (lv_invariantExp_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_2=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_2, grammarAccess.getSystemInvariantAccess().getLeftCurlyBracketKeyword_2_0());
              			
            }
            // InternalConstLang.g:282:4: ( (lv_invariantExp_3_0= ruleExpression ) )
            // InternalConstLang.g:283:5: (lv_invariantExp_3_0= ruleExpression )
            {
            // InternalConstLang.g:283:5: (lv_invariantExp_3_0= ruleExpression )
            // InternalConstLang.g:284:6: lv_invariantExp_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getSystemInvariantAccess().getInvariantExpExpressionParserRuleCall_2_1_0());
              					
            }
            pushFollow(FOLLOW_10);
            lv_invariantExp_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getSystemInvariantRule());
              						}
              						set(
              							current,
              							"invariantExp",
              							lv_invariantExp_3_0,
              							"umlrtsyntesizer.ConstLang.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getSystemInvariantAccess().getRightCurlyBracketKeyword_2_2());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemInvariant"


    // $ANTLR start "entryRuleMessageConstraint"
    // InternalConstLang.g:310:1: entryRuleMessageConstraint returns [EObject current=null] : iv_ruleMessageConstraint= ruleMessageConstraint EOF ;
    public final EObject entryRuleMessageConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageConstraint = null;


        try {
            // InternalConstLang.g:310:58: (iv_ruleMessageConstraint= ruleMessageConstraint EOF )
            // InternalConstLang.g:311:2: iv_ruleMessageConstraint= ruleMessageConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessageConstraint=ruleMessageConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessageConstraint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageConstraint"


    // $ANTLR start "ruleMessageConstraint"
    // InternalConstLang.g:317:1: ruleMessageConstraint returns [EObject current=null] : (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_params_3_0= ruleAttribute ) )* otherlv_4= ')' ( ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )? (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? ) )? (otherlv_8= 'Post:' ( (lv_postConstraints_9_0= ruleExpression ) ) ) ) ;
    public final EObject ruleMessageConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_params_3_0 = null;

        Enumerator lv_WhereToApply_5_0 = null;

        EObject lv_preConstraints_7_0 = null;

        EObject lv_postConstraints_9_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:323:2: ( (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_params_3_0= ruleAttribute ) )* otherlv_4= ')' ( ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )? (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? ) )? (otherlv_8= 'Post:' ( (lv_postConstraints_9_0= ruleExpression ) ) ) ) )
            // InternalConstLang.g:324:2: (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_params_3_0= ruleAttribute ) )* otherlv_4= ')' ( ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )? (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? ) )? (otherlv_8= 'Post:' ( (lv_postConstraints_9_0= ruleExpression ) ) ) )
            {
            // InternalConstLang.g:324:2: (otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_params_3_0= ruleAttribute ) )* otherlv_4= ')' ( ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )? (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? ) )? (otherlv_8= 'Post:' ( (lv_postConstraints_9_0= ruleExpression ) ) ) )
            // InternalConstLang.g:325:3: otherlv_0= 'Message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_params_3_0= ruleAttribute ) )* otherlv_4= ')' ( ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )? (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? ) )? (otherlv_8= 'Post:' ( (lv_postConstraints_9_0= ruleExpression ) ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMessageConstraintAccess().getMessageKeyword_0());
              		
            }
            // InternalConstLang.g:329:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalConstLang.g:330:4: (lv_name_1_0= RULE_ID )
            {
            // InternalConstLang.g:330:4: (lv_name_1_0= RULE_ID )
            // InternalConstLang.g:331:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getMessageConstraintAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMessageConstraintRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMessageConstraintAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalConstLang.g:351:3: ( (lv_params_3_0= ruleAttribute ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalConstLang.g:352:4: (lv_params_3_0= ruleAttribute )
            	    {
            	    // InternalConstLang.g:352:4: (lv_params_3_0= ruleAttribute )
            	    // InternalConstLang.g:353:5: lv_params_3_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMessageConstraintAccess().getParamsAttributeParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_params_3_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMessageConstraintRule());
            	      					}
            	      					add(
            	      						current,
            	      						"params",
            	      						lv_params_3_0,
            	      						"umlrtsyntesizer.ConstLang.Attribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getMessageConstraintAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalConstLang.g:374:3: ( ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )? (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20||(LA8_0>=45 && LA8_0<=46)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalConstLang.g:375:4: ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )? (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? )
                    {
                    // InternalConstLang.g:375:4: ( (lv_WhereToApply_5_0= ruleWhereToApplyEnum ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=45 && LA6_0<=46)) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalConstLang.g:376:5: (lv_WhereToApply_5_0= ruleWhereToApplyEnum )
                            {
                            // InternalConstLang.g:376:5: (lv_WhereToApply_5_0= ruleWhereToApplyEnum )
                            // InternalConstLang.g:377:6: lv_WhereToApply_5_0= ruleWhereToApplyEnum
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getMessageConstraintAccess().getWhereToApplyWhereToApplyEnumEnumRuleCall_5_0_0());
                              					
                            }
                            pushFollow(FOLLOW_14);
                            lv_WhereToApply_5_0=ruleWhereToApplyEnum();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getMessageConstraintRule());
                              						}
                              						set(
                              							current,
                              							"WhereToApply",
                              							lv_WhereToApply_5_0,
                              							"umlrtsyntesizer.ConstLang.WhereToApplyEnum");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalConstLang.g:394:4: (otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )? )
                    // InternalConstLang.g:395:5: otherlv_6= 'Pre:' ( (lv_preConstraints_7_0= ruleExpression ) )?
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getMessageConstraintAccess().getPreKeyword_5_1_0());
                      				
                    }
                    // InternalConstLang.g:399:5: ( (lv_preConstraints_7_0= ruleExpression ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_BOOLEAN)||LA7_0==18||LA7_0==23||LA7_0==41) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalConstLang.g:400:6: (lv_preConstraints_7_0= ruleExpression )
                            {
                            // InternalConstLang.g:400:6: (lv_preConstraints_7_0= ruleExpression )
                            // InternalConstLang.g:401:7: lv_preConstraints_7_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getMessageConstraintAccess().getPreConstraintsExpressionParserRuleCall_5_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_16);
                            lv_preConstraints_7_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getMessageConstraintRule());
                              							}
                              							set(
                              								current,
                              								"preConstraints",
                              								lv_preConstraints_7_0,
                              								"umlrtsyntesizer.ConstLang.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalConstLang.g:420:3: (otherlv_8= 'Post:' ( (lv_postConstraints_9_0= ruleExpression ) ) )
            // InternalConstLang.g:421:4: otherlv_8= 'Post:' ( (lv_postConstraints_9_0= ruleExpression ) )
            {
            otherlv_8=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_8, grammarAccess.getMessageConstraintAccess().getPostKeyword_6_0());
              			
            }
            // InternalConstLang.g:425:4: ( (lv_postConstraints_9_0= ruleExpression ) )
            // InternalConstLang.g:426:5: (lv_postConstraints_9_0= ruleExpression )
            {
            // InternalConstLang.g:426:5: (lv_postConstraints_9_0= ruleExpression )
            // InternalConstLang.g:427:6: lv_postConstraints_9_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getMessageConstraintAccess().getPostConstraintsExpressionParserRuleCall_6_1_0());
              					
            }
            pushFollow(FOLLOW_2);
            lv_postConstraints_9_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getMessageConstraintRule());
              						}
              						set(
              							current,
              							"postConstraints",
              							lv_postConstraints_9_0,
              							"umlrtsyntesizer.ConstLang.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageConstraint"


    // $ANTLR start "entryRuleRange"
    // InternalConstLang.g:449:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalConstLang.g:449:46: (iv_ruleRange= ruleRange EOF )
            // InternalConstLang.g:450:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalConstLang.g:456:1: ruleRange returns [EObject current=null] : (otherlv_0= '(' ( (lv_from_1_0= ruleValue ) ) otherlv_2= '..' ( (lv_to_3_0= ruleValue ) ) otherlv_4= ')' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:462:2: ( (otherlv_0= '(' ( (lv_from_1_0= ruleValue ) ) otherlv_2= '..' ( (lv_to_3_0= ruleValue ) ) otherlv_4= ')' ) )
            // InternalConstLang.g:463:2: (otherlv_0= '(' ( (lv_from_1_0= ruleValue ) ) otherlv_2= '..' ( (lv_to_3_0= ruleValue ) ) otherlv_4= ')' )
            {
            // InternalConstLang.g:463:2: (otherlv_0= '(' ( (lv_from_1_0= ruleValue ) ) otherlv_2= '..' ( (lv_to_3_0= ruleValue ) ) otherlv_4= ')' )
            // InternalConstLang.g:464:3: otherlv_0= '(' ( (lv_from_1_0= ruleValue ) ) otherlv_2= '..' ( (lv_to_3_0= ruleValue ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalConstLang.g:468:3: ( (lv_from_1_0= ruleValue ) )
            // InternalConstLang.g:469:4: (lv_from_1_0= ruleValue )
            {
            // InternalConstLang.g:469:4: (lv_from_1_0= ruleValue )
            // InternalConstLang.g:470:5: lv_from_1_0= ruleValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeAccess().getFromValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_from_1_0=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeRule());
              					}
              					set(
              						current,
              						"from",
              						lv_from_1_0,
              						"umlrtsyntesizer.ConstLang.Value");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getFullStopFullStopKeyword_2());
              		
            }
            // InternalConstLang.g:491:3: ( (lv_to_3_0= ruleValue ) )
            // InternalConstLang.g:492:4: (lv_to_3_0= ruleValue )
            {
            // InternalConstLang.g:492:4: (lv_to_3_0= ruleValue )
            // InternalConstLang.g:493:5: lv_to_3_0= ruleValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeAccess().getToValueParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_to_3_0=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeRule());
              					}
              					set(
              						current,
              						"to",
              						lv_to_3_0,
              						"umlrtsyntesizer.ConstLang.Value");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRangeAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleValue"
    // InternalConstLang.g:518:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalConstLang.g:518:46: (iv_ruleValue= ruleValue EOF )
            // InternalConstLang.g:519:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalConstLang.g:525:1: ruleValue returns [EObject current=null] : ( ( ( (lv_minues_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) ) | ( (lv_fixedPointValue_2_0= ruleRealLiteral ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_minues_0_0=null;
        Token lv_value_1_0=null;
        EObject lv_fixedPointValue_2_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:531:2: ( ( ( ( (lv_minues_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) ) | ( (lv_fixedPointValue_2_0= ruleRealLiteral ) ) ) )
            // InternalConstLang.g:532:2: ( ( ( (lv_minues_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) ) | ( (lv_fixedPointValue_2_0= ruleRealLiteral ) ) )
            {
            // InternalConstLang.g:532:2: ( ( ( (lv_minues_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) ) | ( (lv_fixedPointValue_2_0= ruleRealLiteral ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_INT) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==24) ) {
                    alt10=2;
                }
                else if ( (LA10_2==EOF||LA10_2==19||LA10_2==22) ) {
                    alt10=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalConstLang.g:533:3: ( ( (lv_minues_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalConstLang.g:533:3: ( ( (lv_minues_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalConstLang.g:534:4: ( (lv_minues_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalConstLang.g:534:4: ( (lv_minues_0_0= '-' ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==23) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalConstLang.g:535:5: (lv_minues_0_0= '-' )
                            {
                            // InternalConstLang.g:535:5: (lv_minues_0_0= '-' )
                            // InternalConstLang.g:536:6: lv_minues_0_0= '-'
                            {
                            lv_minues_0_0=(Token)match(input,23,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_minues_0_0, grammarAccess.getValueAccess().getMinuesHyphenMinusKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getValueRule());
                              						}
                              						setWithLastConsumed(current, "minues", true, "-");
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalConstLang.g:548:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalConstLang.g:549:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalConstLang.g:549:5: (lv_value_1_0= RULE_INT )
                    // InternalConstLang.g:550:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getValueAccess().getValueINTTerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getValueRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_1_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalConstLang.g:568:3: ( (lv_fixedPointValue_2_0= ruleRealLiteral ) )
                    {
                    // InternalConstLang.g:568:3: ( (lv_fixedPointValue_2_0= ruleRealLiteral ) )
                    // InternalConstLang.g:569:4: (lv_fixedPointValue_2_0= ruleRealLiteral )
                    {
                    // InternalConstLang.g:569:4: (lv_fixedPointValue_2_0= ruleRealLiteral )
                    // InternalConstLang.g:570:5: lv_fixedPointValue_2_0= ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getValueAccess().getFixedPointValueRealLiteralParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_fixedPointValue_2_0=ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getValueRule());
                      					}
                      					set(
                      						current,
                      						"fixedPointValue",
                      						lv_fixedPointValue_2_0,
                      						"umlrtsyntesizer.ConstLang.RealLiteral");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleRealLiteral"
    // InternalConstLang.g:591:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalConstLang.g:591:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalConstLang.g:592:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // InternalConstLang.g:598:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_intPart_0_0=null;
        Token otherlv_1=null;
        Token lv_decimalPart_2_0=null;


        	enterRule();

        try {
            // InternalConstLang.g:604:2: ( ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) ) )
            // InternalConstLang.g:605:2: ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) )
            {
            // InternalConstLang.g:605:2: ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) )
            // InternalConstLang.g:606:3: ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) )
            {
            // InternalConstLang.g:606:3: ( (lv_intPart_0_0= RULE_INT ) )
            // InternalConstLang.g:607:4: (lv_intPart_0_0= RULE_INT )
            {
            // InternalConstLang.g:607:4: (lv_intPart_0_0= RULE_INT )
            // InternalConstLang.g:608:5: lv_intPart_0_0= RULE_INT
            {
            lv_intPart_0_0=(Token)match(input,RULE_INT,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_intPart_0_0, grammarAccess.getRealLiteralAccess().getIntPartINTTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRealLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"intPart",
              						lv_intPart_0_0,
              						"org.eclipse.xtext.common.Terminals.INT");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRealLiteralAccess().getFullStopKeyword_1());
              		
            }
            // InternalConstLang.g:628:3: ( (lv_decimalPart_2_0= RULE_INT ) )
            // InternalConstLang.g:629:4: (lv_decimalPart_2_0= RULE_INT )
            {
            // InternalConstLang.g:629:4: (lv_decimalPart_2_0= RULE_INT )
            // InternalConstLang.g:630:5: lv_decimalPart_2_0= RULE_INT
            {
            lv_decimalPart_2_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_decimalPart_2_0, grammarAccess.getRealLiteralAccess().getDecimalPartINTTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRealLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"decimalPart",
              						lv_decimalPart_2_0,
              						"org.eclipse.xtext.common.Terminals.INT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleAttribute"
    // InternalConstLang.g:650:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalConstLang.g:650:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalConstLang.g:651:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalConstLang.g:657:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_propertyType_2_0= ruleVarType ) ) (otherlv_3= 'range' ( (lv_range_4_0= ruleRange ) ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_propertyType_2_0 = null;

        EObject lv_range_4_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:663:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_propertyType_2_0= ruleVarType ) ) (otherlv_3= 'range' ( (lv_range_4_0= ruleRange ) ) )? ) )
            // InternalConstLang.g:664:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_propertyType_2_0= ruleVarType ) ) (otherlv_3= 'range' ( (lv_range_4_0= ruleRange ) ) )? )
            {
            // InternalConstLang.g:664:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_propertyType_2_0= ruleVarType ) ) (otherlv_3= 'range' ( (lv_range_4_0= ruleRange ) ) )? )
            // InternalConstLang.g:665:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_propertyType_2_0= ruleVarType ) ) (otherlv_3= 'range' ( (lv_range_4_0= ruleRange ) ) )?
            {
            // InternalConstLang.g:665:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalConstLang.g:666:4: (lv_name_0_0= RULE_ID )
            {
            // InternalConstLang.g:666:4: (lv_name_0_0= RULE_ID )
            // InternalConstLang.g:667:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAttributeRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getColonKeyword_1());
              		
            }
            // InternalConstLang.g:687:3: ( (lv_propertyType_2_0= ruleVarType ) )
            // InternalConstLang.g:688:4: (lv_propertyType_2_0= ruleVarType )
            {
            // InternalConstLang.g:688:4: (lv_propertyType_2_0= ruleVarType )
            // InternalConstLang.g:689:5: lv_propertyType_2_0= ruleVarType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeAccess().getPropertyTypeVarTypeEnumRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_propertyType_2_0=ruleVarType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRule());
              					}
              					set(
              						current,
              						"propertyType",
              						lv_propertyType_2_0,
              						"umlrtsyntesizer.ConstLang.VarType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalConstLang.g:706:3: (otherlv_3= 'range' ( (lv_range_4_0= ruleRange ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==26) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalConstLang.g:707:4: otherlv_3= 'range' ( (lv_range_4_0= ruleRange ) )
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getRangeKeyword_3_0());
                      			
                    }
                    // InternalConstLang.g:711:4: ( (lv_range_4_0= ruleRange ) )
                    // InternalConstLang.g:712:5: (lv_range_4_0= ruleRange )
                    {
                    // InternalConstLang.g:712:5: (lv_range_4_0= ruleRange )
                    // InternalConstLang.g:713:6: lv_range_4_0= ruleRange
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeAccess().getRangeRangeParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_range_4_0=ruleRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAttributeRule());
                      						}
                      						set(
                      							current,
                      							"range",
                      							lv_range_4_0,
                      							"umlrtsyntesizer.ConstLang.Range");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleExpression"
    // InternalConstLang.g:735:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalConstLang.g:735:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalConstLang.g:736:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalConstLang.g:742:1: ruleExpression returns [EObject current=null] : this_Assign_0= ruleAssign ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Assign_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:748:2: (this_Assign_0= ruleAssign )
            // InternalConstLang.g:749:2: this_Assign_0= ruleAssign
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_Assign_0=ruleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Assign_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssign"
    // InternalConstLang.g:760:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // InternalConstLang.g:760:47: (iv_ruleAssign= ruleAssign EOF )
            // InternalConstLang.g:761:2: iv_ruleAssign= ruleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssign=ruleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssign; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // InternalConstLang.g:767:1: ruleAssign returns [EObject current=null] : (this_Implie_0= ruleImplie ( () otherlv_2= '=' ( (lv_right_3_0= ruleImplie ) ) )* ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Implie_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:773:2: ( (this_Implie_0= ruleImplie ( () otherlv_2= '=' ( (lv_right_3_0= ruleImplie ) ) )* ) )
            // InternalConstLang.g:774:2: (this_Implie_0= ruleImplie ( () otherlv_2= '=' ( (lv_right_3_0= ruleImplie ) ) )* )
            {
            // InternalConstLang.g:774:2: (this_Implie_0= ruleImplie ( () otherlv_2= '=' ( (lv_right_3_0= ruleImplie ) ) )* )
            // InternalConstLang.g:775:3: this_Implie_0= ruleImplie ( () otherlv_2= '=' ( (lv_right_3_0= ruleImplie ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignAccess().getImplieParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_Implie_0=ruleImplie();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Implie_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstLang.g:783:3: ( () otherlv_2= '=' ( (lv_right_3_0= ruleImplie ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalConstLang.g:784:4: () otherlv_2= '=' ( (lv_right_3_0= ruleImplie ) )
            	    {
            	    // InternalConstLang.g:784:4: ()
            	    // InternalConstLang.g:785:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAssignAccess().getAssignLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAssignAccess().getEqualsSignKeyword_1_1());
            	      			
            	    }
            	    // InternalConstLang.g:795:4: ( (lv_right_3_0= ruleImplie ) )
            	    // InternalConstLang.g:796:5: (lv_right_3_0= ruleImplie )
            	    {
            	    // InternalConstLang.g:796:5: (lv_right_3_0= ruleImplie )
            	    // InternalConstLang.g:797:6: lv_right_3_0= ruleImplie
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignAccess().getRightImplieParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_right_3_0=ruleImplie();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAssignRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"umlrtsyntesizer.ConstLang.Implie");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleImplie"
    // InternalConstLang.g:819:1: entryRuleImplie returns [EObject current=null] : iv_ruleImplie= ruleImplie EOF ;
    public final EObject entryRuleImplie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplie = null;


        try {
            // InternalConstLang.g:819:47: (iv_ruleImplie= ruleImplie EOF )
            // InternalConstLang.g:820:2: iv_ruleImplie= ruleImplie EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplieRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplie=ruleImplie();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplie; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplie"


    // $ANTLR start "ruleImplie"
    // InternalConstLang.g:826:1: ruleImplie returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '=>' ( (lv_right_3_0= ruleOrExpression ) ) )* ) ;
    public final EObject ruleImplie() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_OrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:832:2: ( (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '=>' ( (lv_right_3_0= ruleOrExpression ) ) )* ) )
            // InternalConstLang.g:833:2: (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '=>' ( (lv_right_3_0= ruleOrExpression ) ) )* )
            {
            // InternalConstLang.g:833:2: (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '=>' ( (lv_right_3_0= ruleOrExpression ) ) )* )
            // InternalConstLang.g:834:3: this_OrExpression_0= ruleOrExpression ( () otherlv_2= '=>' ( (lv_right_3_0= ruleOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getImplieAccess().getOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_26);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_OrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstLang.g:842:3: ( () otherlv_2= '=>' ( (lv_right_3_0= ruleOrExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalConstLang.g:843:4: () otherlv_2= '=>' ( (lv_right_3_0= ruleOrExpression ) )
            	    {
            	    // InternalConstLang.g:843:4: ()
            	    // InternalConstLang.g:844:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getImplieAccess().getImplieLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getImplieAccess().getEqualsSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalConstLang.g:854:4: ( (lv_right_3_0= ruleOrExpression ) )
            	    // InternalConstLang.g:855:5: (lv_right_3_0= ruleOrExpression )
            	    {
            	    // InternalConstLang.g:855:5: (lv_right_3_0= ruleOrExpression )
            	    // InternalConstLang.g:856:6: lv_right_3_0= ruleOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getImplieAccess().getRightOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_right_3_0=ruleOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getImplieRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"umlrtsyntesizer.ConstLang.OrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplie"


    // $ANTLR start "entryRuleOrExpression"
    // InternalConstLang.g:878:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalConstLang.g:878:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalConstLang.g:879:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalConstLang.g:885:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:891:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalConstLang.g:892:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalConstLang.g:892:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalConstLang.g:893:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_27);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstLang.g:901:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalConstLang.g:902:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalConstLang.g:902:4: ()
            	    // InternalConstLang.g:903:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getOrKeyword_1_1());
            	      			
            	    }
            	    // InternalConstLang.g:913:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalConstLang.g:914:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalConstLang.g:914:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalConstLang.g:915:6: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"umlrtsyntesizer.ConstLang.AndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalConstLang.g:937:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalConstLang.g:937:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalConstLang.g:938:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalConstLang.g:944:1: ruleAndExpression returns [EObject current=null] : (this_ComparisonOperators_0= ruleComparisonOperators ( () otherlv_2= 'and' ( (lv_right_3_0= ruleComparisonOperators ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ComparisonOperators_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:950:2: ( (this_ComparisonOperators_0= ruleComparisonOperators ( () otherlv_2= 'and' ( (lv_right_3_0= ruleComparisonOperators ) ) )* ) )
            // InternalConstLang.g:951:2: (this_ComparisonOperators_0= ruleComparisonOperators ( () otherlv_2= 'and' ( (lv_right_3_0= ruleComparisonOperators ) ) )* )
            {
            // InternalConstLang.g:951:2: (this_ComparisonOperators_0= ruleComparisonOperators ( () otherlv_2= 'and' ( (lv_right_3_0= ruleComparisonOperators ) ) )* )
            // InternalConstLang.g:952:3: this_ComparisonOperators_0= ruleComparisonOperators ( () otherlv_2= 'and' ( (lv_right_3_0= ruleComparisonOperators ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getComparisonOperatorsParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_ComparisonOperators_0=ruleComparisonOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ComparisonOperators_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstLang.g:960:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleComparisonOperators ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==30) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalConstLang.g:961:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleComparisonOperators ) )
            	    {
            	    // InternalConstLang.g:961:4: ()
            	    // InternalConstLang.g:962:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAndKeyword_1_1());
            	      			
            	    }
            	    // InternalConstLang.g:972:4: ( (lv_right_3_0= ruleComparisonOperators ) )
            	    // InternalConstLang.g:973:5: (lv_right_3_0= ruleComparisonOperators )
            	    {
            	    // InternalConstLang.g:973:5: (lv_right_3_0= ruleComparisonOperators )
            	    // InternalConstLang.g:974:6: lv_right_3_0= ruleComparisonOperators
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightComparisonOperatorsParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_right_3_0=ruleComparisonOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"umlrtsyntesizer.ConstLang.ComparisonOperators");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleComparisonOperators"
    // InternalConstLang.g:996:1: entryRuleComparisonOperators returns [EObject current=null] : iv_ruleComparisonOperators= ruleComparisonOperators EOF ;
    public final EObject entryRuleComparisonOperators() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonOperators = null;


        try {
            // InternalConstLang.g:996:60: (iv_ruleComparisonOperators= ruleComparisonOperators EOF )
            // InternalConstLang.g:997:2: iv_ruleComparisonOperators= ruleComparisonOperators EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonOperatorsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparisonOperators=ruleComparisonOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparisonOperators; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparisonOperators"


    // $ANTLR start "ruleComparisonOperators"
    // InternalConstLang.g:1003:1: ruleComparisonOperators returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) ) ( (lv_rest_13_0= ruleAddition ) ) )* ) ;
    public final EObject ruleComparisonOperators() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject this_Addition_0 = null;

        EObject lv_rest_13_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1009:2: ( (this_Addition_0= ruleAddition ( ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) ) ( (lv_rest_13_0= ruleAddition ) ) )* ) )
            // InternalConstLang.g:1010:2: (this_Addition_0= ruleAddition ( ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) ) ( (lv_rest_13_0= ruleAddition ) ) )* )
            {
            // InternalConstLang.g:1010:2: (this_Addition_0= ruleAddition ( ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) ) ( (lv_rest_13_0= ruleAddition ) ) )* )
            // InternalConstLang.g:1011:3: this_Addition_0= ruleAddition ( ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) ) ( (lv_rest_13_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonOperatorsAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstLang.g:1019:3: ( ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) ) ( (lv_rest_13_0= ruleAddition ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==31) && (synpred1_InternalConstLang())) {
                    alt17=1;
                }
                else if ( (LA17_0==32) && (synpred1_InternalConstLang())) {
                    alt17=1;
                }
                else if ( (LA17_0==33) && (synpred1_InternalConstLang())) {
                    alt17=1;
                }
                else if ( (LA17_0==34) && (synpred1_InternalConstLang())) {
                    alt17=1;
                }
                else if ( (LA17_0==35) && (synpred1_InternalConstLang())) {
                    alt17=1;
                }
                else if ( (LA17_0==36) && (synpred1_InternalConstLang())) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalConstLang.g:1020:4: ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) ) ( (lv_rest_13_0= ruleAddition ) )
            	    {
            	    // InternalConstLang.g:1020:4: ( ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) ) )
            	    // InternalConstLang.g:1021:5: ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )=> ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) )
            	    {
            	    // InternalConstLang.g:1059:5: ( ( () otherlv_2= '>' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>=' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '==' ) | ( () otherlv_12= '!=' ) )
            	    int alt16=6;
            	    switch ( input.LA(1) ) {
            	    case 31:
            	        {
            	        alt16=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt16=2;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt16=3;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt16=4;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt16=5;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt16=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt16) {
            	        case 1 :
            	            // InternalConstLang.g:1060:6: ( () otherlv_2= '>' )
            	            {
            	            // InternalConstLang.g:1060:6: ( () otherlv_2= '>' )
            	            // InternalConstLang.g:1061:7: () otherlv_2= '>'
            	            {
            	            // InternalConstLang.g:1061:7: ()
            	            // InternalConstLang.g:1062:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getComparisonOperatorsAccess().getGTLeftAction_1_0_0_0_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_2=(Token)match(input,31,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_2, grammarAccess.getComparisonOperatorsAccess().getGreaterThanSignKeyword_1_0_0_0_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalConstLang.g:1074:6: ( () otherlv_4= '<' )
            	            {
            	            // InternalConstLang.g:1074:6: ( () otherlv_4= '<' )
            	            // InternalConstLang.g:1075:7: () otherlv_4= '<'
            	            {
            	            // InternalConstLang.g:1075:7: ()
            	            // InternalConstLang.g:1076:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getComparisonOperatorsAccess().getLTLeftAction_1_0_0_1_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_4=(Token)match(input,32,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_4, grammarAccess.getComparisonOperatorsAccess().getLessThanSignKeyword_1_0_0_1_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalConstLang.g:1088:6: ( () otherlv_6= '>=' )
            	            {
            	            // InternalConstLang.g:1088:6: ( () otherlv_6= '>=' )
            	            // InternalConstLang.g:1089:7: () otherlv_6= '>='
            	            {
            	            // InternalConstLang.g:1089:7: ()
            	            // InternalConstLang.g:1090:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getComparisonOperatorsAccess().getGELeftAction_1_0_0_2_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_6=(Token)match(input,33,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_6, grammarAccess.getComparisonOperatorsAccess().getGreaterThanSignEqualsSignKeyword_1_0_0_2_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 4 :
            	            // InternalConstLang.g:1102:6: ( () otherlv_8= '<=' )
            	            {
            	            // InternalConstLang.g:1102:6: ( () otherlv_8= '<=' )
            	            // InternalConstLang.g:1103:7: () otherlv_8= '<='
            	            {
            	            // InternalConstLang.g:1103:7: ()
            	            // InternalConstLang.g:1104:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getComparisonOperatorsAccess().getLELeftAction_1_0_0_3_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_8=(Token)match(input,34,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_8, grammarAccess.getComparisonOperatorsAccess().getLessThanSignEqualsSignKeyword_1_0_0_3_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 5 :
            	            // InternalConstLang.g:1116:6: ( () otherlv_10= '==' )
            	            {
            	            // InternalConstLang.g:1116:6: ( () otherlv_10= '==' )
            	            // InternalConstLang.g:1117:7: () otherlv_10= '=='
            	            {
            	            // InternalConstLang.g:1117:7: ()
            	            // InternalConstLang.g:1118:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getComparisonOperatorsAccess().getEQLeftAction_1_0_0_4_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_10=(Token)match(input,35,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_10, grammarAccess.getComparisonOperatorsAccess().getEqualsSignEqualsSignKeyword_1_0_0_4_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 6 :
            	            // InternalConstLang.g:1130:6: ( () otherlv_12= '!=' )
            	            {
            	            // InternalConstLang.g:1130:6: ( () otherlv_12= '!=' )
            	            // InternalConstLang.g:1131:7: () otherlv_12= '!='
            	            {
            	            // InternalConstLang.g:1131:7: ()
            	            // InternalConstLang.g:1132:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getComparisonOperatorsAccess().getNELeftAction_1_0_0_5_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_12=(Token)match(input,36,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_12, grammarAccess.getComparisonOperatorsAccess().getExclamationMarkEqualsSignKeyword_1_0_0_5_1());
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }

            	    // InternalConstLang.g:1145:4: ( (lv_rest_13_0= ruleAddition ) )
            	    // InternalConstLang.g:1146:5: (lv_rest_13_0= ruleAddition )
            	    {
            	    // InternalConstLang.g:1146:5: (lv_rest_13_0= ruleAddition )
            	    // InternalConstLang.g:1147:6: lv_rest_13_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonOperatorsAccess().getRestAdditionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_rest_13_0=ruleAddition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonOperatorsRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rest",
            	      							lv_rest_13_0,
            	      							"umlrtsyntesizer.ConstLang.Addition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonOperators"


    // $ANTLR start "entryRuleAddition"
    // InternalConstLang.g:1169:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalConstLang.g:1169:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalConstLang.g:1170:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalConstLang.g:1176:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1182:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalConstLang.g:1183:2: (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalConstLang.g:1183:2: (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalConstLang.g:1184:3: this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Multiplication_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstLang.g:1192:3: ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // InternalConstLang.g:1193:4: ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalConstLang.g:1193:4: ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) )
            	    // InternalConstLang.g:1194:5: ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    {
            	    // InternalConstLang.g:1208:5: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==37) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==23) ) {
            	        alt18=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // InternalConstLang.g:1209:6: ( () otherlv_2= '+' )
            	            {
            	            // InternalConstLang.g:1209:6: ( () otherlv_2= '+' )
            	            // InternalConstLang.g:1210:7: () otherlv_2= '+'
            	            {
            	            // InternalConstLang.g:1210:7: ()
            	            // InternalConstLang.g:1211:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0_0_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_2=(Token)match(input,37,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_0_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalConstLang.g:1223:6: ( () otherlv_4= '-' )
            	            {
            	            // InternalConstLang.g:1223:6: ( () otherlv_4= '-' )
            	            // InternalConstLang.g:1224:7: () otherlv_4= '-'
            	            {
            	            // InternalConstLang.g:1224:7: ()
            	            // InternalConstLang.g:1225:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_0_1_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_4=(Token)match(input,23,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_0_1_1());
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }

            	    // InternalConstLang.g:1238:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalConstLang.g:1239:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalConstLang.g:1239:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalConstLang.g:1240:6: lv_right_5_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_5_0,
            	      							"umlrtsyntesizer.ConstLang.Multiplication");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalConstLang.g:1262:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalConstLang.g:1262:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalConstLang.g:1263:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalConstLang.g:1269:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Unary_0 = null;

        EObject lv_right_7_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1275:2: ( (this_Unary_0= ruleUnary ( ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) )
            // InternalConstLang.g:1276:2: (this_Unary_0= ruleUnary ( ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            {
            // InternalConstLang.g:1276:2: (this_Unary_0= ruleUnary ( ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            // InternalConstLang.g:1277:3: this_Unary_0= ruleUnary ( ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_Unary_0=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Unary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstLang.g:1285:3: ( ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==38) && (synpred3_InternalConstLang())) {
                    alt21=1;
                }
                else if ( (LA21_0==39) && (synpred3_InternalConstLang())) {
                    alt21=1;
                }
                else if ( (LA21_0==40) && (synpred3_InternalConstLang())) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalConstLang.g:1286:4: ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ) ( (lv_right_7_0= ruleUnary ) )
            	    {
            	    // InternalConstLang.g:1286:4: ( ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) )
            	    // InternalConstLang.g:1287:5: ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )=> ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
            	    {
            	    // InternalConstLang.g:1307:5: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
            	    int alt20=3;
            	    switch ( input.LA(1) ) {
            	    case 38:
            	        {
            	        alt20=1;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt20=2;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt20=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt20) {
            	        case 1 :
            	            // InternalConstLang.g:1308:6: ( () otherlv_2= '*' )
            	            {
            	            // InternalConstLang.g:1308:6: ( () otherlv_2= '*' )
            	            // InternalConstLang.g:1309:7: () otherlv_2= '*'
            	            {
            	            // InternalConstLang.g:1309:7: ()
            	            // InternalConstLang.g:1310:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0_0_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_2=(Token)match(input,38,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_0_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalConstLang.g:1322:6: ( () otherlv_4= '/' )
            	            {
            	            // InternalConstLang.g:1322:6: ( () otherlv_4= '/' )
            	            // InternalConstLang.g:1323:7: () otherlv_4= '/'
            	            {
            	            // InternalConstLang.g:1323:7: ()
            	            // InternalConstLang.g:1324:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getMultiplicationAccess().getDivideLeftAction_1_0_0_1_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_4=(Token)match(input,39,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_0_1_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalConstLang.g:1336:6: ( () otherlv_6= '%' )
            	            {
            	            // InternalConstLang.g:1336:6: ( () otherlv_6= '%' )
            	            // InternalConstLang.g:1337:7: () otherlv_6= '%'
            	            {
            	            // InternalConstLang.g:1337:7: ()
            	            // InternalConstLang.g:1338:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_0_2_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_6=(Token)match(input,40,FOLLOW_8); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_0_2_1());
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }

            	    // InternalConstLang.g:1351:4: ( (lv_right_7_0= ruleUnary ) )
            	    // InternalConstLang.g:1352:5: (lv_right_7_0= ruleUnary )
            	    {
            	    // InternalConstLang.g:1352:5: (lv_right_7_0= ruleUnary )
            	    // InternalConstLang.g:1353:6: lv_right_7_0= ruleUnary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_right_7_0=ruleUnary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_7_0,
            	      							"umlrtsyntesizer.ConstLang.Unary");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // InternalConstLang.g:1375:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // InternalConstLang.g:1375:46: (iv_ruleUnary= ruleUnary EOF )
            // InternalConstLang.g:1376:2: iv_ruleUnary= ruleUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnary=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnary"


    // $ANTLR start "ruleUnary"
    // InternalConstLang.g:1382:1: ruleUnary returns [EObject current=null] : (this_UnaryExpressionNotPlusMinus_0= ruleUnaryExpressionNotPlusMinus | ( () otherlv_2= '-' ( (lv_exp_3_0= ruleUnary ) ) ) ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_UnaryExpressionNotPlusMinus_0 = null;

        EObject lv_exp_3_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1388:2: ( (this_UnaryExpressionNotPlusMinus_0= ruleUnaryExpressionNotPlusMinus | ( () otherlv_2= '-' ( (lv_exp_3_0= ruleUnary ) ) ) ) )
            // InternalConstLang.g:1389:2: (this_UnaryExpressionNotPlusMinus_0= ruleUnaryExpressionNotPlusMinus | ( () otherlv_2= '-' ( (lv_exp_3_0= ruleUnary ) ) ) )
            {
            // InternalConstLang.g:1389:2: (this_UnaryExpressionNotPlusMinus_0= ruleUnaryExpressionNotPlusMinus | ( () otherlv_2= '-' ( (lv_exp_3_0= ruleUnary ) ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_BOOLEAN)||LA22_0==18||LA22_0==41) ) {
                alt22=1;
            }
            else if ( (LA22_0==23) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalConstLang.g:1390:3: this_UnaryExpressionNotPlusMinus_0= ruleUnaryExpressionNotPlusMinus
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryAccess().getUnaryExpressionNotPlusMinusParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpressionNotPlusMinus_0=ruleUnaryExpressionNotPlusMinus();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpressionNotPlusMinus_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalConstLang.g:1399:3: ( () otherlv_2= '-' ( (lv_exp_3_0= ruleUnary ) ) )
                    {
                    // InternalConstLang.g:1399:3: ( () otherlv_2= '-' ( (lv_exp_3_0= ruleUnary ) ) )
                    // InternalConstLang.g:1400:4: () otherlv_2= '-' ( (lv_exp_3_0= ruleUnary ) )
                    {
                    // InternalConstLang.g:1400:4: ()
                    // InternalConstLang.g:1401:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryAccess().getUnaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,23,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getUnaryAccess().getHyphenMinusKeyword_1_1());
                      			
                    }
                    // InternalConstLang.g:1411:4: ( (lv_exp_3_0= ruleUnary ) )
                    // InternalConstLang.g:1412:5: (lv_exp_3_0= ruleUnary )
                    {
                    // InternalConstLang.g:1412:5: (lv_exp_3_0= ruleUnary )
                    // InternalConstLang.g:1413:6: lv_exp_3_0= ruleUnary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryAccess().getExpUnaryParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_exp_3_0=ruleUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryRule());
                      						}
                      						set(
                      							current,
                      							"exp",
                      							lv_exp_3_0,
                      							"umlrtsyntesizer.ConstLang.Unary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleUnaryExpressionNotPlusMinus"
    // InternalConstLang.g:1435:1: entryRuleUnaryExpressionNotPlusMinus returns [EObject current=null] : iv_ruleUnaryExpressionNotPlusMinus= ruleUnaryExpressionNotPlusMinus EOF ;
    public final EObject entryRuleUnaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpressionNotPlusMinus = null;


        try {
            // InternalConstLang.g:1435:68: (iv_ruleUnaryExpressionNotPlusMinus= ruleUnaryExpressionNotPlusMinus EOF )
            // InternalConstLang.g:1436:2: iv_ruleUnaryExpressionNotPlusMinus= ruleUnaryExpressionNotPlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpressionNotPlusMinus=ruleUnaryExpressionNotPlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpressionNotPlusMinus; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpressionNotPlusMinus"


    // $ANTLR start "ruleUnaryExpressionNotPlusMinus"
    // InternalConstLang.g:1442:1: ruleUnaryExpressionNotPlusMinus returns [EObject current=null] : (this_NotBooleanExpression_0= ruleNotBooleanExpression | this_PrimaryExpression_1= rulePrimaryExpression ) ;
    public final EObject ruleUnaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject this_NotBooleanExpression_0 = null;

        EObject this_PrimaryExpression_1 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1448:2: ( (this_NotBooleanExpression_0= ruleNotBooleanExpression | this_PrimaryExpression_1= rulePrimaryExpression ) )
            // InternalConstLang.g:1449:2: (this_NotBooleanExpression_0= ruleNotBooleanExpression | this_PrimaryExpression_1= rulePrimaryExpression )
            {
            // InternalConstLang.g:1449:2: (this_NotBooleanExpression_0= ruleNotBooleanExpression | this_PrimaryExpression_1= rulePrimaryExpression )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==41) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_BOOLEAN)||LA23_0==18) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalConstLang.g:1450:3: this_NotBooleanExpression_0= ruleNotBooleanExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getNotBooleanExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NotBooleanExpression_0=ruleNotBooleanExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NotBooleanExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalConstLang.g:1459:3: this_PrimaryExpression_1= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPrimaryExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_1=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimaryExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpressionNotPlusMinus"


    // $ANTLR start "entryRuleNotBooleanExpression"
    // InternalConstLang.g:1471:1: entryRuleNotBooleanExpression returns [EObject current=null] : iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF ;
    public final EObject entryRuleNotBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotBooleanExpression = null;


        try {
            // InternalConstLang.g:1471:61: (iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF )
            // InternalConstLang.g:1472:2: iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNotBooleanExpression=ruleNotBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotBooleanExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotBooleanExpression"


    // $ANTLR start "ruleNotBooleanExpression"
    // InternalConstLang.g:1478:1: ruleNotBooleanExpression returns [EObject current=null] : (otherlv_0= 'not' ( (lv_exp_1_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleNotBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1484:2: ( (otherlv_0= 'not' ( (lv_exp_1_0= rulePrimaryExpression ) ) ) )
            // InternalConstLang.g:1485:2: (otherlv_0= 'not' ( (lv_exp_1_0= rulePrimaryExpression ) ) )
            {
            // InternalConstLang.g:1485:2: (otherlv_0= 'not' ( (lv_exp_1_0= rulePrimaryExpression ) ) )
            // InternalConstLang.g:1486:3: otherlv_0= 'not' ( (lv_exp_1_0= rulePrimaryExpression ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getNotBooleanExpressionAccess().getNotKeyword_0());
              		
            }
            // InternalConstLang.g:1490:3: ( (lv_exp_1_0= rulePrimaryExpression ) )
            // InternalConstLang.g:1491:4: (lv_exp_1_0= rulePrimaryExpression )
            {
            // InternalConstLang.g:1491:4: (lv_exp_1_0= rulePrimaryExpression )
            // InternalConstLang.g:1492:5: lv_exp_1_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNotBooleanExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_exp_1_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNotBooleanExpressionRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"umlrtsyntesizer.ConstLang.PrimaryExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotBooleanExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalConstLang.g:1513:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalConstLang.g:1513:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalConstLang.g:1514:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalConstLang.g:1520:1: rulePrimaryExpression returns [EObject current=null] : (this_LiteralOrIdentifier_0= ruleLiteralOrIdentifier | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_LiteralOrIdentifier_0 = null;

        EObject this_Expression_2 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1526:2: ( (this_LiteralOrIdentifier_0= ruleLiteralOrIdentifier | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) ) )
            // InternalConstLang.g:1527:2: (this_LiteralOrIdentifier_0= ruleLiteralOrIdentifier | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) )
            {
            // InternalConstLang.g:1527:2: (this_LiteralOrIdentifier_0= ruleLiteralOrIdentifier | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_BOOLEAN)) ) {
                alt24=1;
            }
            else if ( (LA24_0==18) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalConstLang.g:1528:3: this_LiteralOrIdentifier_0= ruleLiteralOrIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralOrIdentifierParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralOrIdentifier_0=ruleLiteralOrIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralOrIdentifier_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalConstLang.g:1537:3: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    {
                    // InternalConstLang.g:1537:3: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    // InternalConstLang.g:1538:4: otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    this_Expression_2=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_3=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteralOrIdentifier"
    // InternalConstLang.g:1559:1: entryRuleLiteralOrIdentifier returns [EObject current=null] : iv_ruleLiteralOrIdentifier= ruleLiteralOrIdentifier EOF ;
    public final EObject entryRuleLiteralOrIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrIdentifier = null;


        try {
            // InternalConstLang.g:1559:60: (iv_ruleLiteralOrIdentifier= ruleLiteralOrIdentifier EOF )
            // InternalConstLang.g:1560:2: iv_ruleLiteralOrIdentifier= ruleLiteralOrIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralOrIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralOrIdentifier=ruleLiteralOrIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralOrIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralOrIdentifier"


    // $ANTLR start "ruleLiteralOrIdentifier"
    // InternalConstLang.g:1566:1: ruleLiteralOrIdentifier returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier ) ;
    public final EObject ruleLiteralOrIdentifier() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_Identifier_1 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1572:2: ( (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier ) )
            // InternalConstLang.g:1573:2: (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier )
            {
            // InternalConstLang.g:1573:2: (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_INT && LA25_0<=RULE_BOOLEAN)) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalConstLang.g:1574:3: this_Literal_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralOrIdentifierAccess().getLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalConstLang.g:1583:3: this_Identifier_1= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralOrIdentifierAccess().getIdentifierParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Identifier_1=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Identifier_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralOrIdentifier"


    // $ANTLR start "entryRuleIdentifier"
    // InternalConstLang.g:1595:1: entryRuleIdentifier returns [EObject current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final EObject entryRuleIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifier = null;


        try {
            // InternalConstLang.g:1595:51: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalConstLang.g:1596:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalConstLang.g:1602:1: ruleIdentifier returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleIdentifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalConstLang.g:1608:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalConstLang.g:1609:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalConstLang.g:1609:2: ( (otherlv_0= RULE_ID ) )
            // InternalConstLang.g:1610:3: (otherlv_0= RULE_ID )
            {
            // InternalConstLang.g:1610:3: (otherlv_0= RULE_ID )
            // InternalConstLang.g:1611:4: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getIdentifierRule());
              				}
              			
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getIdentifierAccess().getRefAttributeCrossReference_0());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLiteral"
    // InternalConstLang.g:1625:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalConstLang.g:1625:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalConstLang.g:1626:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalConstLang.g:1632:1: ruleLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_BoolLiteral_1 = null;

        EObject this_RealLiteral_2 = null;



        	enterRule();

        try {
            // InternalConstLang.g:1638:2: ( (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral ) )
            // InternalConstLang.g:1639:2: (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral )
            {
            // InternalConstLang.g:1639:2: (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral )
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_INT) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==24) ) {
                    alt26=3;
                }
                else if ( (LA26_1==EOF||(LA26_1>=RULE_ID && LA26_1<=RULE_BOOLEAN)||LA26_1==14||(LA26_1>=17 && LA26_1<=19)||LA26_1==21||LA26_1==23||(LA26_1>=27 && LA26_1<=41)) ) {
                    alt26=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA26_0==RULE_BOOLEAN) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalConstLang.g:1640:3: this_IntLiteral_0= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalConstLang.g:1649:3: this_BoolLiteral_1= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BoolLiteral_1=ruleBoolLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BoolLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalConstLang.g:1658:3: this_RealLiteral_2= ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RealLiteral_2=ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // InternalConstLang.g:1670:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalConstLang.g:1670:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalConstLang.g:1671:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // InternalConstLang.g:1677:1: ruleIntLiteral returns [EObject current=null] : ( (lv_intLiteral_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_intLiteral_0_0=null;


        	enterRule();

        try {
            // InternalConstLang.g:1683:2: ( ( (lv_intLiteral_0_0= RULE_INT ) ) )
            // InternalConstLang.g:1684:2: ( (lv_intLiteral_0_0= RULE_INT ) )
            {
            // InternalConstLang.g:1684:2: ( (lv_intLiteral_0_0= RULE_INT ) )
            // InternalConstLang.g:1685:3: (lv_intLiteral_0_0= RULE_INT )
            {
            // InternalConstLang.g:1685:3: (lv_intLiteral_0_0= RULE_INT )
            // InternalConstLang.g:1686:4: lv_intLiteral_0_0= RULE_INT
            {
            lv_intLiteral_0_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_intLiteral_0_0, grammarAccess.getIntLiteralAccess().getIntLiteralINTTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getIntLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"intLiteral",
              					lv_intLiteral_0_0,
              					"org.eclipse.xtext.common.Terminals.INT");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleBoolLiteral"
    // InternalConstLang.g:1705:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // InternalConstLang.g:1705:52: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // InternalConstLang.g:1706:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolLiteral"


    // $ANTLR start "ruleBoolLiteral"
    // InternalConstLang.g:1712:1: ruleBoolLiteral returns [EObject current=null] : ( (lv_boolLiteral_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_boolLiteral_0_0=null;


        	enterRule();

        try {
            // InternalConstLang.g:1718:2: ( ( (lv_boolLiteral_0_0= RULE_BOOLEAN ) ) )
            // InternalConstLang.g:1719:2: ( (lv_boolLiteral_0_0= RULE_BOOLEAN ) )
            {
            // InternalConstLang.g:1719:2: ( (lv_boolLiteral_0_0= RULE_BOOLEAN ) )
            // InternalConstLang.g:1720:3: (lv_boolLiteral_0_0= RULE_BOOLEAN )
            {
            // InternalConstLang.g:1720:3: (lv_boolLiteral_0_0= RULE_BOOLEAN )
            // InternalConstLang.g:1721:4: lv_boolLiteral_0_0= RULE_BOOLEAN
            {
            lv_boolLiteral_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_boolLiteral_0_0, grammarAccess.getBoolLiteralAccess().getBoolLiteralBOOLEANTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBoolLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"boolLiteral",
              					lv_boolLiteral_0_0,
              					"umlrtsyntesizer.ConstLang.BOOLEAN");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "ruleVarType"
    // InternalConstLang.g:1740:1: ruleVarType returns [Enumerator current=null] : ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Real' ) ) ;
    public final Enumerator ruleVarType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalConstLang.g:1746:2: ( ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Real' ) ) )
            // InternalConstLang.g:1747:2: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Real' ) )
            {
            // InternalConstLang.g:1747:2: ( (enumLiteral_0= 'Boolean' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Real' ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt27=1;
                }
                break;
            case 43:
                {
                alt27=2;
                }
                break;
            case 44:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalConstLang.g:1748:3: (enumLiteral_0= 'Boolean' )
                    {
                    // InternalConstLang.g:1748:3: (enumLiteral_0= 'Boolean' )
                    // InternalConstLang.g:1749:4: enumLiteral_0= 'Boolean'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVarTypeAccess().getBooleanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getVarTypeAccess().getBooleanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConstLang.g:1756:3: (enumLiteral_1= 'Integer' )
                    {
                    // InternalConstLang.g:1756:3: (enumLiteral_1= 'Integer' )
                    // InternalConstLang.g:1757:4: enumLiteral_1= 'Integer'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVarTypeAccess().getIntegerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getVarTypeAccess().getIntegerEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalConstLang.g:1764:3: (enumLiteral_2= 'Real' )
                    {
                    // InternalConstLang.g:1764:3: (enumLiteral_2= 'Real' )
                    // InternalConstLang.g:1765:4: enumLiteral_2= 'Real'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVarTypeAccess().getRealEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getVarTypeAccess().getRealEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarType"


    // $ANTLR start "ruleWhereToApplyEnum"
    // InternalConstLang.g:1775:1: ruleWhereToApplyEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'Server' ) | (enumLiteral_1= 'Client' ) ) ;
    public final Enumerator ruleWhereToApplyEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalConstLang.g:1781:2: ( ( (enumLiteral_0= 'Server' ) | (enumLiteral_1= 'Client' ) ) )
            // InternalConstLang.g:1782:2: ( (enumLiteral_0= 'Server' ) | (enumLiteral_1= 'Client' ) )
            {
            // InternalConstLang.g:1782:2: ( (enumLiteral_0= 'Server' ) | (enumLiteral_1= 'Client' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==45) ) {
                alt28=1;
            }
            else if ( (LA28_0==46) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalConstLang.g:1783:3: (enumLiteral_0= 'Server' )
                    {
                    // InternalConstLang.g:1783:3: (enumLiteral_0= 'Server' )
                    // InternalConstLang.g:1784:4: enumLiteral_0= 'Server'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getWhereToApplyEnumAccess().getSERVEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getWhereToApplyEnumAccess().getSERVEREnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalConstLang.g:1791:3: (enumLiteral_1= 'Client' )
                    {
                    // InternalConstLang.g:1791:3: (enumLiteral_1= 'Client' )
                    // InternalConstLang.g:1792:4: enumLiteral_1= 'Client'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getWhereToApplyEnumAccess().getCLIENTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getWhereToApplyEnumAccess().getCLIENTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhereToApplyEnum"

    // $ANTLR start synpred1_InternalConstLang
    public final void synpred1_InternalConstLang_fragment() throws RecognitionException {   
        // InternalConstLang.g:1021:5: ( ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) ) )
        // InternalConstLang.g:1021:6: ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) )
        {
        // InternalConstLang.g:1021:6: ( ( () '>' ) | ( () '<' ) | ( () '>=' ) | ( () '<=' ) | ( () '==' ) | ( () '!=' ) )
        int alt29=6;
        switch ( input.LA(1) ) {
        case 31:
            {
            alt29=1;
            }
            break;
        case 32:
            {
            alt29=2;
            }
            break;
        case 33:
            {
            alt29=3;
            }
            break;
        case 34:
            {
            alt29=4;
            }
            break;
        case 35:
            {
            alt29=5;
            }
            break;
        case 36:
            {
            alt29=6;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 29, 0, input);

            throw nvae;
        }

        switch (alt29) {
            case 1 :
                // InternalConstLang.g:1022:6: ( () '>' )
                {
                // InternalConstLang.g:1022:6: ( () '>' )
                // InternalConstLang.g:1023:7: () '>'
                {
                // InternalConstLang.g:1023:7: ()
                // InternalConstLang.g:1024:7: 
                {
                }

                match(input,31,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 2 :
                // InternalConstLang.g:1028:6: ( () '<' )
                {
                // InternalConstLang.g:1028:6: ( () '<' )
                // InternalConstLang.g:1029:7: () '<'
                {
                // InternalConstLang.g:1029:7: ()
                // InternalConstLang.g:1030:7: 
                {
                }

                match(input,32,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 3 :
                // InternalConstLang.g:1034:6: ( () '>=' )
                {
                // InternalConstLang.g:1034:6: ( () '>=' )
                // InternalConstLang.g:1035:7: () '>='
                {
                // InternalConstLang.g:1035:7: ()
                // InternalConstLang.g:1036:7: 
                {
                }

                match(input,33,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 4 :
                // InternalConstLang.g:1040:6: ( () '<=' )
                {
                // InternalConstLang.g:1040:6: ( () '<=' )
                // InternalConstLang.g:1041:7: () '<='
                {
                // InternalConstLang.g:1041:7: ()
                // InternalConstLang.g:1042:7: 
                {
                }

                match(input,34,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 5 :
                // InternalConstLang.g:1046:6: ( () '==' )
                {
                // InternalConstLang.g:1046:6: ( () '==' )
                // InternalConstLang.g:1047:7: () '=='
                {
                // InternalConstLang.g:1047:7: ()
                // InternalConstLang.g:1048:7: 
                {
                }

                match(input,35,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 6 :
                // InternalConstLang.g:1052:6: ( () '!=' )
                {
                // InternalConstLang.g:1052:6: ( () '!=' )
                // InternalConstLang.g:1053:7: () '!='
                {
                // InternalConstLang.g:1053:7: ()
                // InternalConstLang.g:1054:7: 
                {
                }

                match(input,36,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred1_InternalConstLang

    // $ANTLR start synpred2_InternalConstLang
    public final void synpred2_InternalConstLang_fragment() throws RecognitionException {   
        // InternalConstLang.g:1194:5: ( ( ( () '+' ) | ( () '-' ) ) )
        // InternalConstLang.g:1194:6: ( ( () '+' ) | ( () '-' ) )
        {
        // InternalConstLang.g:1194:6: ( ( () '+' ) | ( () '-' ) )
        int alt30=2;
        int LA30_0 = input.LA(1);

        if ( (LA30_0==37) ) {
            alt30=1;
        }
        else if ( (LA30_0==23) ) {
            alt30=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 30, 0, input);

            throw nvae;
        }
        switch (alt30) {
            case 1 :
                // InternalConstLang.g:1195:6: ( () '+' )
                {
                // InternalConstLang.g:1195:6: ( () '+' )
                // InternalConstLang.g:1196:7: () '+'
                {
                // InternalConstLang.g:1196:7: ()
                // InternalConstLang.g:1197:7: 
                {
                }

                match(input,37,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 2 :
                // InternalConstLang.g:1201:6: ( () '-' )
                {
                // InternalConstLang.g:1201:6: ( () '-' )
                // InternalConstLang.g:1202:7: () '-'
                {
                // InternalConstLang.g:1202:7: ()
                // InternalConstLang.g:1203:7: 
                {
                }

                match(input,23,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred2_InternalConstLang

    // $ANTLR start synpred3_InternalConstLang
    public final void synpred3_InternalConstLang_fragment() throws RecognitionException {   
        // InternalConstLang.g:1287:5: ( ( ( () '*' ) | ( () '/' ) | ( () '%' ) ) )
        // InternalConstLang.g:1287:6: ( ( () '*' ) | ( () '/' ) | ( () '%' ) )
        {
        // InternalConstLang.g:1287:6: ( ( () '*' ) | ( () '/' ) | ( () '%' ) )
        int alt31=3;
        switch ( input.LA(1) ) {
        case 38:
            {
            alt31=1;
            }
            break;
        case 39:
            {
            alt31=2;
            }
            break;
        case 40:
            {
            alt31=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 31, 0, input);

            throw nvae;
        }

        switch (alt31) {
            case 1 :
                // InternalConstLang.g:1288:6: ( () '*' )
                {
                // InternalConstLang.g:1288:6: ( () '*' )
                // InternalConstLang.g:1289:7: () '*'
                {
                // InternalConstLang.g:1289:7: ()
                // InternalConstLang.g:1290:7: 
                {
                }

                match(input,38,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 2 :
                // InternalConstLang.g:1294:6: ( () '/' )
                {
                // InternalConstLang.g:1294:6: ( () '/' )
                // InternalConstLang.g:1295:7: () '/'
                {
                // InternalConstLang.g:1295:7: ()
                // InternalConstLang.g:1296:7: 
                {
                }

                match(input,39,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 3 :
                // InternalConstLang.g:1300:6: ( () '%' )
                {
                // InternalConstLang.g:1300:6: ( () '%' )
                // InternalConstLang.g:1301:7: () '%'
                {
                // InternalConstLang.g:1301:7: ()
                // InternalConstLang.g:1302:7: 
                {
                }

                match(input,40,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred3_InternalConstLang

    // Delegated rules

    public final boolean synpred3_InternalConstLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalConstLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalConstLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalConstLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalConstLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalConstLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String dfa_1s = "\27\uffff";
    static final String dfa_2s = "\1\1\26\uffff";
    static final String dfa_3s = "\1\4\20\uffff\1\0\5\uffff";
    static final String dfa_4s = "\1\51\20\uffff\1\0\5\uffff";
    static final String dfa_5s = "\1\uffff\1\2\24\uffff\1\1";
    static final String dfa_6s = "\1\0\20\uffff\1\1\5\uffff}>";
    static final String[] dfa_7s = {
            "\3\1\7\uffff\1\1\2\uffff\3\1\1\uffff\1\1\1\uffff\1\21\3\uffff\12\1\1\26\3\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 1192:3: ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_0 = input.LA(1);

                         
                        int index19_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_0==EOF||(LA19_0>=RULE_ID && LA19_0<=RULE_BOOLEAN)||LA19_0==14||(LA19_0>=17 && LA19_0<=19)||LA19_0==21||(LA19_0>=27 && LA19_0<=36)||LA19_0==41) ) {s = 1;}

                        else if ( (LA19_0==23) ) {s = 17;}

                        else if ( (LA19_0==37) && (synpred2_InternalConstLang())) {s = 22;}

                         
                        input.seek(index19_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_17 = input.LA(1);

                         
                        int index19_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalConstLang()) ) {s = 22;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index19_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000034000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000020000840070L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000020000844070L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000600000300000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000020000A40070L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800060L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001F80000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000800002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000020000040070L});

}