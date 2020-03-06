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
import umlrtsyntesizer.services.ExecTracesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExecTracesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_BOOLEAN", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'From'", "'To'", "'Trigger'", "'Actions'", "'Status'", "'guard'", "'name'", "'id'", "'level'", "'VarData'", "'{'", "'}'", "'status'", "'constraints'", "'outgoingEdges'", "'incomingEdges'", "'='", "'.'", "'new'", "'unSafeTrans'", "'repeated'", "'Normal'", "'Error'", "'Redundant'"
    };
    public static final int RULE_BOOLEAN=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalExecTracesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExecTracesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExecTracesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExecTraces.g"; }



     	private ExecTracesGrammarAccess grammarAccess;

        public InternalExecTracesParser(TokenStream input, ExecTracesGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ExecTraces";
       	}

       	@Override
       	protected ExecTracesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleExecTraces"
    // InternalExecTraces.g:65:1: entryRuleExecTraces returns [EObject current=null] : iv_ruleExecTraces= ruleExecTraces EOF ;
    public final EObject entryRuleExecTraces() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecTraces = null;


        try {
            // InternalExecTraces.g:65:51: (iv_ruleExecTraces= ruleExecTraces EOF )
            // InternalExecTraces.g:66:2: iv_ruleExecTraces= ruleExecTraces EOF
            {
             newCompositeNode(grammarAccess.getExecTracesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExecTraces=ruleExecTraces();

            state._fsp--;

             current =iv_ruleExecTraces; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExecTraces"


    // $ANTLR start "ruleExecTraces"
    // InternalExecTraces.g:72:1: ruleExecTraces returns [EObject current=null] : ( ( (lv_ComponentName_0_0= RULE_ID ) ) ( ( (lv_Node_1_0= ruleNode ) ) | ( (lv_Edge_2_0= ruleEdge ) ) )+ ) ;
    public final EObject ruleExecTraces() throws RecognitionException {
        EObject current = null;

        Token lv_ComponentName_0_0=null;
        EObject lv_Node_1_0 = null;

        EObject lv_Edge_2_0 = null;



        	enterRule();

        try {
            // InternalExecTraces.g:78:2: ( ( ( (lv_ComponentName_0_0= RULE_ID ) ) ( ( (lv_Node_1_0= ruleNode ) ) | ( (lv_Edge_2_0= ruleEdge ) ) )+ ) )
            // InternalExecTraces.g:79:2: ( ( (lv_ComponentName_0_0= RULE_ID ) ) ( ( (lv_Node_1_0= ruleNode ) ) | ( (lv_Edge_2_0= ruleEdge ) ) )+ )
            {
            // InternalExecTraces.g:79:2: ( ( (lv_ComponentName_0_0= RULE_ID ) ) ( ( (lv_Node_1_0= ruleNode ) ) | ( (lv_Edge_2_0= ruleEdge ) ) )+ )
            // InternalExecTraces.g:80:3: ( (lv_ComponentName_0_0= RULE_ID ) ) ( ( (lv_Node_1_0= ruleNode ) ) | ( (lv_Edge_2_0= ruleEdge ) ) )+
            {
            // InternalExecTraces.g:80:3: ( (lv_ComponentName_0_0= RULE_ID ) )
            // InternalExecTraces.g:81:4: (lv_ComponentName_0_0= RULE_ID )
            {
            // InternalExecTraces.g:81:4: (lv_ComponentName_0_0= RULE_ID )
            // InternalExecTraces.g:82:5: lv_ComponentName_0_0= RULE_ID
            {
            lv_ComponentName_0_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_ComponentName_0_0, grammarAccess.getExecTracesAccess().getComponentNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExecTracesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ComponentName",
            						lv_ComponentName_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalExecTraces.g:98:3: ( ( (lv_Node_1_0= ruleNode ) ) | ( (lv_Edge_2_0= ruleEdge ) ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }
                else if ( (LA1_0==12) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalExecTraces.g:99:4: ( (lv_Node_1_0= ruleNode ) )
            	    {
            	    // InternalExecTraces.g:99:4: ( (lv_Node_1_0= ruleNode ) )
            	    // InternalExecTraces.g:100:5: (lv_Node_1_0= ruleNode )
            	    {
            	    // InternalExecTraces.g:100:5: (lv_Node_1_0= ruleNode )
            	    // InternalExecTraces.g:101:6: lv_Node_1_0= ruleNode
            	    {

            	    						newCompositeNode(grammarAccess.getExecTracesAccess().getNodeNodeParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_Node_1_0=ruleNode();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExecTracesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"Node",
            	    							lv_Node_1_0,
            	    							"umlrtsyntesizer.ExecTraces.Node");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalExecTraces.g:119:4: ( (lv_Edge_2_0= ruleEdge ) )
            	    {
            	    // InternalExecTraces.g:119:4: ( (lv_Edge_2_0= ruleEdge ) )
            	    // InternalExecTraces.g:120:5: (lv_Edge_2_0= ruleEdge )
            	    {
            	    // InternalExecTraces.g:120:5: (lv_Edge_2_0= ruleEdge )
            	    // InternalExecTraces.g:121:6: lv_Edge_2_0= ruleEdge
            	    {

            	    						newCompositeNode(grammarAccess.getExecTracesAccess().getEdgeEdgeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_Edge_2_0=ruleEdge();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExecTracesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"Edge",
            	    							lv_Edge_2_0,
            	    							"umlrtsyntesizer.ExecTraces.Edge");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExecTraces"


    // $ANTLR start "entryRuleEdge"
    // InternalExecTraces.g:143:1: entryRuleEdge returns [EObject current=null] : iv_ruleEdge= ruleEdge EOF ;
    public final EObject entryRuleEdge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEdge = null;


        try {
            // InternalExecTraces.g:143:45: (iv_ruleEdge= ruleEdge EOF )
            // InternalExecTraces.g:144:2: iv_ruleEdge= ruleEdge EOF
            {
             newCompositeNode(grammarAccess.getEdgeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEdge=ruleEdge();

            state._fsp--;

             current =iv_ruleEdge; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEdge"


    // $ANTLR start "ruleEdge"
    // InternalExecTraces.g:150:1: ruleEdge returns [EObject current=null] : (otherlv_0= 'From' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'To' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'Trigger' ( (lv_trigger_5_0= RULE_STRING ) ) otherlv_6= 'Actions' ( (lv_actions_7_0= RULE_STRING ) ) otherlv_8= 'Status' ( (lv_status_9_0= ruleTransStatus ) ) otherlv_10= 'guard' ( (lv_guard_11_0= RULE_STRING ) ) ) ;
    public final EObject ruleEdge() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_trigger_5_0=null;
        Token otherlv_6=null;
        Token lv_actions_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_guard_11_0=null;
        Enumerator lv_status_9_0 = null;



        	enterRule();

        try {
            // InternalExecTraces.g:156:2: ( (otherlv_0= 'From' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'To' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'Trigger' ( (lv_trigger_5_0= RULE_STRING ) ) otherlv_6= 'Actions' ( (lv_actions_7_0= RULE_STRING ) ) otherlv_8= 'Status' ( (lv_status_9_0= ruleTransStatus ) ) otherlv_10= 'guard' ( (lv_guard_11_0= RULE_STRING ) ) ) )
            // InternalExecTraces.g:157:2: (otherlv_0= 'From' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'To' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'Trigger' ( (lv_trigger_5_0= RULE_STRING ) ) otherlv_6= 'Actions' ( (lv_actions_7_0= RULE_STRING ) ) otherlv_8= 'Status' ( (lv_status_9_0= ruleTransStatus ) ) otherlv_10= 'guard' ( (lv_guard_11_0= RULE_STRING ) ) )
            {
            // InternalExecTraces.g:157:2: (otherlv_0= 'From' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'To' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'Trigger' ( (lv_trigger_5_0= RULE_STRING ) ) otherlv_6= 'Actions' ( (lv_actions_7_0= RULE_STRING ) ) otherlv_8= 'Status' ( (lv_status_9_0= ruleTransStatus ) ) otherlv_10= 'guard' ( (lv_guard_11_0= RULE_STRING ) ) )
            // InternalExecTraces.g:158:3: otherlv_0= 'From' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'To' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'Trigger' ( (lv_trigger_5_0= RULE_STRING ) ) otherlv_6= 'Actions' ( (lv_actions_7_0= RULE_STRING ) ) otherlv_8= 'Status' ( (lv_status_9_0= ruleTransStatus ) ) otherlv_10= 'guard' ( (lv_guard_11_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getEdgeAccess().getFromKeyword_0());
            		
            // InternalExecTraces.g:162:3: ( (otherlv_1= RULE_ID ) )
            // InternalExecTraces.g:163:4: (otherlv_1= RULE_ID )
            {
            // InternalExecTraces.g:163:4: (otherlv_1= RULE_ID )
            // InternalExecTraces.g:164:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_1, grammarAccess.getEdgeAccess().getSourceNodeCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getEdgeAccess().getToKeyword_2());
            		
            // InternalExecTraces.g:179:3: ( (otherlv_3= RULE_ID ) )
            // InternalExecTraces.g:180:4: (otherlv_3= RULE_ID )
            {
            // InternalExecTraces.g:180:4: (otherlv_3= RULE_ID )
            // InternalExecTraces.g:181:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_3, grammarAccess.getEdgeAccess().getDestinationNodeCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getEdgeAccess().getTriggerKeyword_4());
            		
            // InternalExecTraces.g:196:3: ( (lv_trigger_5_0= RULE_STRING ) )
            // InternalExecTraces.g:197:4: (lv_trigger_5_0= RULE_STRING )
            {
            // InternalExecTraces.g:197:4: (lv_trigger_5_0= RULE_STRING )
            // InternalExecTraces.g:198:5: lv_trigger_5_0= RULE_STRING
            {
            lv_trigger_5_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_trigger_5_0, grammarAccess.getEdgeAccess().getTriggerSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"trigger",
            						lv_trigger_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getEdgeAccess().getActionsKeyword_6());
            		
            // InternalExecTraces.g:218:3: ( (lv_actions_7_0= RULE_STRING ) )
            // InternalExecTraces.g:219:4: (lv_actions_7_0= RULE_STRING )
            {
            // InternalExecTraces.g:219:4: (lv_actions_7_0= RULE_STRING )
            // InternalExecTraces.g:220:5: lv_actions_7_0= RULE_STRING
            {
            lv_actions_7_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_actions_7_0, grammarAccess.getEdgeAccess().getActionsSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"actions",
            						lv_actions_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_8=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_8, grammarAccess.getEdgeAccess().getStatusKeyword_8());
            		
            // InternalExecTraces.g:240:3: ( (lv_status_9_0= ruleTransStatus ) )
            // InternalExecTraces.g:241:4: (lv_status_9_0= ruleTransStatus )
            {
            // InternalExecTraces.g:241:4: (lv_status_9_0= ruleTransStatus )
            // InternalExecTraces.g:242:5: lv_status_9_0= ruleTransStatus
            {

            					newCompositeNode(grammarAccess.getEdgeAccess().getStatusTransStatusEnumRuleCall_9_0());
            				
            pushFollow(FOLLOW_12);
            lv_status_9_0=ruleTransStatus();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEdgeRule());
            					}
            					set(
            						current,
            						"status",
            						lv_status_9_0,
            						"umlrtsyntesizer.ExecTraces.TransStatus");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_10, grammarAccess.getEdgeAccess().getGuardKeyword_10());
            		
            // InternalExecTraces.g:263:3: ( (lv_guard_11_0= RULE_STRING ) )
            // InternalExecTraces.g:264:4: (lv_guard_11_0= RULE_STRING )
            {
            // InternalExecTraces.g:264:4: (lv_guard_11_0= RULE_STRING )
            // InternalExecTraces.g:265:5: lv_guard_11_0= RULE_STRING
            {
            lv_guard_11_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_guard_11_0, grammarAccess.getEdgeAccess().getGuardSTRINGTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEdgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"guard",
            						lv_guard_11_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEdge"


    // $ANTLR start "entryRuleNode"
    // InternalExecTraces.g:285:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalExecTraces.g:285:45: (iv_ruleNode= ruleNode EOF )
            // InternalExecTraces.g:286:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalExecTraces.g:292:1: ruleNode returns [EObject current=null] : (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'id' ( (lv_id_3_0= RULE_INT ) ) otherlv_4= 'level' ( (lv_level_5_0= RULE_INT ) ) otherlv_6= 'VarData' otherlv_7= '{' ( (lv_VarData_8_0= ruleVariable ) )* otherlv_9= '}' otherlv_10= 'status' ( (lv_status_11_0= ruleStateStatus ) ) otherlv_12= 'constraints' ( (lv_constraints_13_0= RULE_STRING ) ) otherlv_14= 'outgoingEdges' ( (otherlv_15= RULE_ID ) )* otherlv_16= 'incomingEdges' ( (otherlv_17= RULE_ID ) )* ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;
        Token otherlv_4=null;
        Token lv_level_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_constraints_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_VarData_8_0 = null;

        Enumerator lv_status_11_0 = null;



        	enterRule();

        try {
            // InternalExecTraces.g:298:2: ( (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'id' ( (lv_id_3_0= RULE_INT ) ) otherlv_4= 'level' ( (lv_level_5_0= RULE_INT ) ) otherlv_6= 'VarData' otherlv_7= '{' ( (lv_VarData_8_0= ruleVariable ) )* otherlv_9= '}' otherlv_10= 'status' ( (lv_status_11_0= ruleStateStatus ) ) otherlv_12= 'constraints' ( (lv_constraints_13_0= RULE_STRING ) ) otherlv_14= 'outgoingEdges' ( (otherlv_15= RULE_ID ) )* otherlv_16= 'incomingEdges' ( (otherlv_17= RULE_ID ) )* ) )
            // InternalExecTraces.g:299:2: (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'id' ( (lv_id_3_0= RULE_INT ) ) otherlv_4= 'level' ( (lv_level_5_0= RULE_INT ) ) otherlv_6= 'VarData' otherlv_7= '{' ( (lv_VarData_8_0= ruleVariable ) )* otherlv_9= '}' otherlv_10= 'status' ( (lv_status_11_0= ruleStateStatus ) ) otherlv_12= 'constraints' ( (lv_constraints_13_0= RULE_STRING ) ) otherlv_14= 'outgoingEdges' ( (otherlv_15= RULE_ID ) )* otherlv_16= 'incomingEdges' ( (otherlv_17= RULE_ID ) )* )
            {
            // InternalExecTraces.g:299:2: (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'id' ( (lv_id_3_0= RULE_INT ) ) otherlv_4= 'level' ( (lv_level_5_0= RULE_INT ) ) otherlv_6= 'VarData' otherlv_7= '{' ( (lv_VarData_8_0= ruleVariable ) )* otherlv_9= '}' otherlv_10= 'status' ( (lv_status_11_0= ruleStateStatus ) ) otherlv_12= 'constraints' ( (lv_constraints_13_0= RULE_STRING ) ) otherlv_14= 'outgoingEdges' ( (otherlv_15= RULE_ID ) )* otherlv_16= 'incomingEdges' ( (otherlv_17= RULE_ID ) )* )
            // InternalExecTraces.g:300:3: otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'id' ( (lv_id_3_0= RULE_INT ) ) otherlv_4= 'level' ( (lv_level_5_0= RULE_INT ) ) otherlv_6= 'VarData' otherlv_7= '{' ( (lv_VarData_8_0= ruleVariable ) )* otherlv_9= '}' otherlv_10= 'status' ( (lv_status_11_0= ruleStateStatus ) ) otherlv_12= 'constraints' ( (lv_constraints_13_0= RULE_STRING ) ) otherlv_14= 'outgoingEdges' ( (otherlv_15= RULE_ID ) )* otherlv_16= 'incomingEdges' ( (otherlv_17= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNameKeyword_0());
            		
            // InternalExecTraces.g:304:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExecTraces.g:305:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExecTraces.g:305:4: (lv_name_1_0= RULE_ID )
            // InternalExecTraces.g:306:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getIdKeyword_2());
            		
            // InternalExecTraces.g:326:3: ( (lv_id_3_0= RULE_INT ) )
            // InternalExecTraces.g:327:4: (lv_id_3_0= RULE_INT )
            {
            // InternalExecTraces.g:327:4: (lv_id_3_0= RULE_INT )
            // InternalExecTraces.g:328:5: lv_id_3_0= RULE_INT
            {
            lv_id_3_0=(Token)match(input,RULE_INT,FOLLOW_15); 

            					newLeafNode(lv_id_3_0, grammarAccess.getNodeAccess().getIdINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getNodeAccess().getLevelKeyword_4());
            		
            // InternalExecTraces.g:348:3: ( (lv_level_5_0= RULE_INT ) )
            // InternalExecTraces.g:349:4: (lv_level_5_0= RULE_INT )
            {
            // InternalExecTraces.g:349:4: (lv_level_5_0= RULE_INT )
            // InternalExecTraces.g:350:5: lv_level_5_0= RULE_INT
            {
            lv_level_5_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            					newLeafNode(lv_level_5_0, grammarAccess.getNodeAccess().getLevelINTTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"level",
            						lv_level_5_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_17); 

            			newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getVarDataKeyword_6());
            		
            otherlv_7=(Token)match(input,22,FOLLOW_18); 

            			newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalExecTraces.g:374:3: ( (lv_VarData_8_0= ruleVariable ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExecTraces.g:375:4: (lv_VarData_8_0= ruleVariable )
            	    {
            	    // InternalExecTraces.g:375:4: (lv_VarData_8_0= ruleVariable )
            	    // InternalExecTraces.g:376:5: lv_VarData_8_0= ruleVariable
            	    {

            	    					newCompositeNode(grammarAccess.getNodeAccess().getVarDataVariableParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_VarData_8_0=ruleVariable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNodeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"VarData",
            	    						lv_VarData_8_0,
            	    						"umlrtsyntesizer.ExecTraces.Variable");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_9=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_9());
            		
            otherlv_10=(Token)match(input,24,FOLLOW_20); 

            			newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getStatusKeyword_10());
            		
            // InternalExecTraces.g:401:3: ( (lv_status_11_0= ruleStateStatus ) )
            // InternalExecTraces.g:402:4: (lv_status_11_0= ruleStateStatus )
            {
            // InternalExecTraces.g:402:4: (lv_status_11_0= ruleStateStatus )
            // InternalExecTraces.g:403:5: lv_status_11_0= ruleStateStatus
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getStatusStateStatusEnumRuleCall_11_0());
            				
            pushFollow(FOLLOW_21);
            lv_status_11_0=ruleStateStatus();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNodeRule());
            					}
            					set(
            						current,
            						"status",
            						lv_status_11_0,
            						"umlrtsyntesizer.ExecTraces.StateStatus");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_12, grammarAccess.getNodeAccess().getConstraintsKeyword_12());
            		
            // InternalExecTraces.g:424:3: ( (lv_constraints_13_0= RULE_STRING ) )
            // InternalExecTraces.g:425:4: (lv_constraints_13_0= RULE_STRING )
            {
            // InternalExecTraces.g:425:4: (lv_constraints_13_0= RULE_STRING )
            // InternalExecTraces.g:426:5: lv_constraints_13_0= RULE_STRING
            {
            lv_constraints_13_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_constraints_13_0, grammarAccess.getNodeAccess().getConstraintsSTRINGTerminalRuleCall_13_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"constraints",
            						lv_constraints_13_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_14=(Token)match(input,26,FOLLOW_23); 

            			newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getOutgoingEdgesKeyword_14());
            		
            // InternalExecTraces.g:446:3: ( (otherlv_15= RULE_ID ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalExecTraces.g:447:4: (otherlv_15= RULE_ID )
            	    {
            	    // InternalExecTraces.g:447:4: (otherlv_15= RULE_ID )
            	    // InternalExecTraces.g:448:5: otherlv_15= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getNodeRule());
            	    					}
            	    				
            	    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_23); 

            	    					newLeafNode(otherlv_15, grammarAccess.getNodeAccess().getOutgoingEdgesEdgeCrossReference_15_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_16=(Token)match(input,27,FOLLOW_24); 

            			newLeafNode(otherlv_16, grammarAccess.getNodeAccess().getIncomingEdgesKeyword_16());
            		
            // InternalExecTraces.g:463:3: ( (otherlv_17= RULE_ID ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalExecTraces.g:464:4: (otherlv_17= RULE_ID )
            	    {
            	    // InternalExecTraces.g:464:4: (otherlv_17= RULE_ID )
            	    // InternalExecTraces.g:465:5: otherlv_17= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getNodeRule());
            	    					}
            	    				
            	    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_24); 

            	    					newLeafNode(otherlv_17, grammarAccess.getNodeAccess().getIncomingEdgesEdgeCrossReference_17_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleVariable"
    // InternalExecTraces.g:480:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalExecTraces.g:480:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalExecTraces.g:481:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalExecTraces.g:487:1: ruleVariable returns [EObject current=null] : (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteral ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalExecTraces.g:493:2: ( (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteral ) ) ) )
            // InternalExecTraces.g:494:2: (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteral ) ) )
            {
            // InternalExecTraces.g:494:2: (otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteral ) ) )
            // InternalExecTraces.g:495:3: otherlv_0= 'name' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteral ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getNameKeyword_0());
            		
            // InternalExecTraces.g:499:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExecTraces.g:500:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExecTraces.g:500:4: (lv_name_1_0= RULE_ID )
            // InternalExecTraces.g:501:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getEqualsSignKeyword_2());
            		
            // InternalExecTraces.g:521:3: ( (lv_value_3_0= ruleLiteral ) )
            // InternalExecTraces.g:522:4: (lv_value_3_0= ruleLiteral )
            {
            // InternalExecTraces.g:522:4: (lv_value_3_0= ruleLiteral )
            // InternalExecTraces.g:523:5: lv_value_3_0= ruleLiteral
            {

            					newCompositeNode(grammarAccess.getVariableAccess().getValueLiteralParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"umlrtsyntesizer.ExecTraces.Literal");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleRealLiteral"
    // InternalExecTraces.g:544:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalExecTraces.g:544:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalExecTraces.g:545:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExecTraces.g:551:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_intPart_0_0=null;
        Token otherlv_1=null;
        Token lv_decimalPart_2_0=null;


        	enterRule();

        try {
            // InternalExecTraces.g:557:2: ( ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) ) )
            // InternalExecTraces.g:558:2: ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) )
            {
            // InternalExecTraces.g:558:2: ( ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) ) )
            // InternalExecTraces.g:559:3: ( (lv_intPart_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_decimalPart_2_0= RULE_INT ) )
            {
            // InternalExecTraces.g:559:3: ( (lv_intPart_0_0= RULE_INT ) )
            // InternalExecTraces.g:560:4: (lv_intPart_0_0= RULE_INT )
            {
            // InternalExecTraces.g:560:4: (lv_intPart_0_0= RULE_INT )
            // InternalExecTraces.g:561:5: lv_intPart_0_0= RULE_INT
            {
            lv_intPart_0_0=(Token)match(input,RULE_INT,FOLLOW_27); 

            					newLeafNode(lv_intPart_0_0, grammarAccess.getRealLiteralAccess().getIntPartINTTerminalRuleCall_0_0());
            				

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

            otherlv_1=(Token)match(input,29,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getRealLiteralAccess().getFullStopKeyword_1());
            		
            // InternalExecTraces.g:581:3: ( (lv_decimalPart_2_0= RULE_INT ) )
            // InternalExecTraces.g:582:4: (lv_decimalPart_2_0= RULE_INT )
            {
            // InternalExecTraces.g:582:4: (lv_decimalPart_2_0= RULE_INT )
            // InternalExecTraces.g:583:5: lv_decimalPart_2_0= RULE_INT
            {
            lv_decimalPart_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_decimalPart_2_0, grammarAccess.getRealLiteralAccess().getDecimalPartINTTerminalRuleCall_2_0());
            				

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


            	leaveRule();

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


    // $ANTLR start "entryRuleLiteral"
    // InternalExecTraces.g:603:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalExecTraces.g:603:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalExecTraces.g:604:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExecTraces.g:610:1: ruleLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_BoolLiteral_1 = null;

        EObject this_RealLiteral_2 = null;



        	enterRule();

        try {
            // InternalExecTraces.g:616:2: ( (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral ) )
            // InternalExecTraces.g:617:2: (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral )
            {
            // InternalExecTraces.g:617:2: (this_IntLiteral_0= ruleIntLiteral | this_BoolLiteral_1= ruleBoolLiteral | this_RealLiteral_2= ruleRealLiteral )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==29) ) {
                    alt5=3;
                }
                else if ( (LA5_1==EOF||LA5_1==18||LA5_1==23) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA5_0==RULE_BOOLEAN) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalExecTraces.g:618:3: this_IntLiteral_0= ruleIntLiteral
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;


                    			current = this_IntLiteral_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalExecTraces.g:627:3: this_BoolLiteral_1= ruleBoolLiteral
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolLiteral_1=ruleBoolLiteral();

                    state._fsp--;


                    			current = this_BoolLiteral_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalExecTraces.g:636:3: this_RealLiteral_2= ruleRealLiteral
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_RealLiteral_2=ruleRealLiteral();

                    state._fsp--;


                    			current = this_RealLiteral_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalExecTraces.g:648:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalExecTraces.g:648:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalExecTraces.g:649:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExecTraces.g:655:1: ruleIntLiteral returns [EObject current=null] : ( (lv_int_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_int_0_0=null;


        	enterRule();

        try {
            // InternalExecTraces.g:661:2: ( ( (lv_int_0_0= RULE_INT ) ) )
            // InternalExecTraces.g:662:2: ( (lv_int_0_0= RULE_INT ) )
            {
            // InternalExecTraces.g:662:2: ( (lv_int_0_0= RULE_INT ) )
            // InternalExecTraces.g:663:3: (lv_int_0_0= RULE_INT )
            {
            // InternalExecTraces.g:663:3: (lv_int_0_0= RULE_INT )
            // InternalExecTraces.g:664:4: lv_int_0_0= RULE_INT
            {
            lv_int_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_int_0_0, grammarAccess.getIntLiteralAccess().getIntINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"int",
            					lv_int_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

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
    // InternalExecTraces.g:683:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // InternalExecTraces.g:683:52: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // InternalExecTraces.g:684:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
             newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;

             current =iv_ruleBoolLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalExecTraces.g:690:1: ruleBoolLiteral returns [EObject current=null] : ( (lv_bool_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_bool_0_0=null;


        	enterRule();

        try {
            // InternalExecTraces.g:696:2: ( ( (lv_bool_0_0= RULE_BOOLEAN ) ) )
            // InternalExecTraces.g:697:2: ( (lv_bool_0_0= RULE_BOOLEAN ) )
            {
            // InternalExecTraces.g:697:2: ( (lv_bool_0_0= RULE_BOOLEAN ) )
            // InternalExecTraces.g:698:3: (lv_bool_0_0= RULE_BOOLEAN )
            {
            // InternalExecTraces.g:698:3: (lv_bool_0_0= RULE_BOOLEAN )
            // InternalExecTraces.g:699:4: lv_bool_0_0= RULE_BOOLEAN
            {
            lv_bool_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            				newLeafNode(lv_bool_0_0, grammarAccess.getBoolLiteralAccess().getBoolBOOLEANTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBoolLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"bool",
            					lv_bool_0_0,
            					"umlrtsyntesizer.ExecTraces.BOOLEAN");
            			

            }


            }


            }


            	leaveRule();

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


    // $ANTLR start "ruleStateStatus"
    // InternalExecTraces.g:718:1: ruleStateStatus returns [Enumerator current=null] : ( (enumLiteral_0= 'new' ) | (enumLiteral_1= 'unSafeTrans' ) | (enumLiteral_2= 'repeated' ) ) ;
    public final Enumerator ruleStateStatus() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalExecTraces.g:724:2: ( ( (enumLiteral_0= 'new' ) | (enumLiteral_1= 'unSafeTrans' ) | (enumLiteral_2= 'repeated' ) ) )
            // InternalExecTraces.g:725:2: ( (enumLiteral_0= 'new' ) | (enumLiteral_1= 'unSafeTrans' ) | (enumLiteral_2= 'repeated' ) )
            {
            // InternalExecTraces.g:725:2: ( (enumLiteral_0= 'new' ) | (enumLiteral_1= 'unSafeTrans' ) | (enumLiteral_2= 'repeated' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt6=1;
                }
                break;
            case 31:
                {
                alt6=2;
                }
                break;
            case 32:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalExecTraces.g:726:3: (enumLiteral_0= 'new' )
                    {
                    // InternalExecTraces.g:726:3: (enumLiteral_0= 'new' )
                    // InternalExecTraces.g:727:4: enumLiteral_0= 'new'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getStateStatusAccess().getNewEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStateStatusAccess().getNewEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalExecTraces.g:734:3: (enumLiteral_1= 'unSafeTrans' )
                    {
                    // InternalExecTraces.g:734:3: (enumLiteral_1= 'unSafeTrans' )
                    // InternalExecTraces.g:735:4: enumLiteral_1= 'unSafeTrans'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getStateStatusAccess().getUnSafeStateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStateStatusAccess().getUnSafeStateEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalExecTraces.g:742:3: (enumLiteral_2= 'repeated' )
                    {
                    // InternalExecTraces.g:742:3: (enumLiteral_2= 'repeated' )
                    // InternalExecTraces.g:743:4: enumLiteral_2= 'repeated'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getStateStatusAccess().getRepeatedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStateStatusAccess().getRepeatedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateStatus"


    // $ANTLR start "ruleTransStatus"
    // InternalExecTraces.g:753:1: ruleTransStatus returns [Enumerator current=null] : ( (enumLiteral_0= 'Normal' ) | (enumLiteral_1= 'Error' ) | (enumLiteral_2= 'unSafeTrans' ) | (enumLiteral_3= 'Redundant' ) ) ;
    public final Enumerator ruleTransStatus() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalExecTraces.g:759:2: ( ( (enumLiteral_0= 'Normal' ) | (enumLiteral_1= 'Error' ) | (enumLiteral_2= 'unSafeTrans' ) | (enumLiteral_3= 'Redundant' ) ) )
            // InternalExecTraces.g:760:2: ( (enumLiteral_0= 'Normal' ) | (enumLiteral_1= 'Error' ) | (enumLiteral_2= 'unSafeTrans' ) | (enumLiteral_3= 'Redundant' ) )
            {
            // InternalExecTraces.g:760:2: ( (enumLiteral_0= 'Normal' ) | (enumLiteral_1= 'Error' ) | (enumLiteral_2= 'unSafeTrans' ) | (enumLiteral_3= 'Redundant' ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt7=1;
                }
                break;
            case 34:
                {
                alt7=2;
                }
                break;
            case 31:
                {
                alt7=3;
                }
                break;
            case 35:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalExecTraces.g:761:3: (enumLiteral_0= 'Normal' )
                    {
                    // InternalExecTraces.g:761:3: (enumLiteral_0= 'Normal' )
                    // InternalExecTraces.g:762:4: enumLiteral_0= 'Normal'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getTransStatusAccess().getNormalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTransStatusAccess().getNormalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalExecTraces.g:769:3: (enumLiteral_1= 'Error' )
                    {
                    // InternalExecTraces.g:769:3: (enumLiteral_1= 'Error' )
                    // InternalExecTraces.g:770:4: enumLiteral_1= 'Error'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getTransStatusAccess().getErrorEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTransStatusAccess().getErrorEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalExecTraces.g:777:3: (enumLiteral_2= 'unSafeTrans' )
                    {
                    // InternalExecTraces.g:777:3: (enumLiteral_2= 'unSafeTrans' )
                    // InternalExecTraces.g:778:4: enumLiteral_2= 'unSafeTrans'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getTransStatusAccess().getUnsafeTransEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTransStatusAccess().getUnsafeTransEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalExecTraces.g:785:3: (enumLiteral_3= 'Redundant' )
                    {
                    // InternalExecTraces.g:785:3: (enumLiteral_3= 'Redundant' )
                    // InternalExecTraces.g:786:4: enumLiteral_3= 'Redundant'
                    {
                    enumLiteral_3=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getTransStatusAccess().getRedundantTransEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getTransStatusAccess().getRedundantTransEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransStatus"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000041002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000E80000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});

}