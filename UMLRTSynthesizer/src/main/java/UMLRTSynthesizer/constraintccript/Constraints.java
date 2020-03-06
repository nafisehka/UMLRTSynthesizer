package UMLRTSynthesizer.constraintccript;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import UMLRTSynthesizer.Z3.ConstToZ3Convertor;
import UMLRTSynthesizer.statespaceexploration.Component;
import UMLRTSynthesizer.statespaceexploration.ExpressionInterpreter;
import UMLRTSynthesizer.statespaceexploration.Heap;
import umlrtsyntesizer.ConstLangStandaloneSetup;
import umlrtsyntesizer.constLang.Attribute;
import umlrtsyntesizer.constLang.ConstLangPackage;
import umlrtsyntesizer.constLang.Context;
import umlrtsyntesizer.constLang.Expression;
import umlrtsyntesizer.constLang.MessageConstraint;
import umlrtsyntesizer.constLang.SystemInvariant;
import umlrtsyntesizer.constLang.VarType;
import umlrtsyntesizer.constLang.WhereToApplyEnum;



public class Constraints {
	static final public String currentText="cur_";
	static final public String nextText="next_";
	static final public String inputMessageText="in_";
	static final public String reportMessageText="rep_";
	static public int    MC_ID_Counter=1;
	private final static Logger LOGGER = Logger.getLogger(Constraints.class);
	private Map<String,Set<MessageConditions>> messages;
	private Map<String,Invariant> invariants;
	private String constraintsPath;
	private ConstToZ3Convertor constToZ3Convertor;
	private umlrtsyntesizer.constLang.Context constraintsContext;
	private Heap stateVars;
	
	public Constraints (String constraintsPath) {
		this.constraintsPath=constraintsPath;
		this.constToZ3Convertor=new ConstToZ3Convertor();
		this.messages=new HashMap<String,Set<MessageConditions>>();
		this.invariants=new HashMap<String,Invariant>();
		this.stateVars= new  Heap();
	}
	public void initStateVars() {
		for (Attribute attr: constraintsContext.getAttributes()) {
			stateVars.insert(this.currentText+attr.getName(),ConstraintScriptUtil.createVar(attr.getPropertyType()));
		}
		for (Expression exp: constraintsContext.getInit().getExpressions()) {
			ExpressionInterpreter.execute(exp,stateVars);
		}
	}
	
	public void load()  {
        Injector injector = new ConstLangStandaloneSetup().createInjectorAndDoEMFRegistration();
        ResourceSet rs = injector.getInstance(ResourceSet.class);
        ClassLoader classLoader = this.getClass().getClassLoader();
        Resource resource = rs.getResource(URI.createURI(this.constraintsPath), true);
        //Resource resource = rs.getResource(URI.createURI(classLoader.getResource(this.constraintsPath).toString()), true);
        try {
			resource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //IScopeProvider scopeprovidor= injector.getInstance(IScopeProvider.class);
        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        //scopeprovidor.
        List<Issue> issues = validator.validate(resource,CheckMode.ALL, CancelIndicator.NullImpl);
        for (Issue issue: issues) {
            switch (issue.getSeverity()) {
                case ERROR:
                    LOGGER.error(issue.getMessage() + "in line number " + issue.getLineNumber() );
                    //LOGGER.error(issue.getLineNumber());
                    //System.exit(-1);
                case WARNING:
                	LOGGER.warn(issue.getMessage());
                	break;
                case IGNORE:
                	break;
                case INFO:
                	LOGGER.info(issue.getMessage());
                	break;
                default:
                	break;
            }
        }

        constraintsContext=(Context) EcoreUtil2.getObjectByType(resource.getContents(), ConstLangPackage.Literals.CONTEXT);
	}
	public String getCCPreOfMC(int mcID) {
		for (Entry<String,Set<MessageConditions>> mcs: this.messages.entrySet()) {
			for (MessageConditions mc: mcs.getValue())
					if (mc.ID==mcID)
						return mc.ccPre;
			}
		// it is exception and means that mc id is not set correctly
		return null;
	}
	public Set<MessageConditions> getMessageConditions(String msg){
		for (Entry<String,Set<MessageConditions>> mcs: this.messages.entrySet()) {
			if (mcs.getKey().contentEquals(msg)) {
					return mcs.getValue();
			}
		}
		Set<MessageConditions> temp=new HashSet<MessageConditions>(); 
		return temp;
	}
	public void processConstriants() {
		for (MessageConstraint msg: constraintsContext.getMessageConstraints()) {
			//--- add current and next variables -- 
			MessageConditions msgConst= new MessageConditions();
			
			msgConst.ID=++MC_ID_Counter;
			if (msg.getPostConstraints()!=null)
				msgConst.ccPost=NodeModelUtils.findActualNodeFor(msg.getPostConstraints()).getText();
			if (msg.getPreConstraints()!=null)
				msgConst.ccPre=NodeModelUtils.findActualNodeFor(msg.getPreConstraints()).getText();
			msgConst.whereToApply=msg.getWhereToApply();
			constToZ3Convertor.getParam(msgConst.payloads,msg.getParams(),currentText);
			if (msg.getPreConstraints()!=null) {
				msgConst.z3Pre=constToZ3Convertor.convert(msg.getPreConstraints(),currentText);
				constToZ3Convertor.getVar(msgConst.preUsedvariable, msg.getPreConstraints(),currentText,msgConst.payloads);
				LOGGER.info("Pre constraint of message " + msg.getName() + " is " +msgConst.z3Pre);
				LOGGER.info("Used variables in Pre constraint of message " + msg.getName() + " is " +msgConst.preUsedvariable);
			}
			msgConst.z3Post=constToZ3Convertor.convert(msg.getPostConstraints(),nextText);
			LOGGER.info("Post constraint of message " + msg.getName() + " is " +msgConst.z3Post);
			constToZ3Convertor.getVar(msgConst.postUsedvariable, msg.getPostConstraints(),nextText,msgConst.payloads);
			LOGGER.info("Used variables in Post constraint of message " + msg.getName() + " is " +msgConst.postUsedvariable);
			msgConst.usedvariable.putAll(msgConst.preUsedvariable);
			msgConst.usedvariable.putAll(msgConst.postUsedvariable);
			LOGGER.info("Used variables in  message " + msg.getName() + " is " +msgConst.usedvariable);
			if (messages.containsKey(msg.getName()))
				messages.get(msg.getName()).add(msgConst);
			else {
				HashSet<MessageConditions> conds=new HashSet<MessageConditions>();
				conds.add(msgConst);
				messages.put(msg.getName(),conds);
			}
			
		}

		for (SystemInvariant sysInv: constraintsContext.getSystemInvariants()) {
			Invariant z3Inv=new Invariant();
			z3Inv.z3Cur=constToZ3Convertor.convert(sysInv.getInvariantExp(),currentText);
			z3Inv.z3Next=constToZ3Convertor.convert(sysInv.getInvariantExp(),nextText);
			constToZ3Convertor.getVar(z3Inv.usedvariable, sysInv.getInvariantExp(),"");
			invariants.put(sysInv.getName(), z3Inv);
		}
		
		initStateVars();
		
		
	}
	////
	public void annotaeConstriantsWithComponents(Component component) {
		for (Entry<String, Set<MessageConditions>> mcs : messages.entrySet()) {
			for (MessageConditions mc: mcs.getValue()) {
				for (String inputMsg: component.getInputMessages()) 
					if (mcs.getKey().contentEquals(inputMsg))
						mc.servers.add(component.getName());
				for (String outMsg: component.getOutputMessages()) 
					if (mcs.getKey().contentEquals(outMsg))
						mc.clients.add(component.getName());
				LOGGER.info("Client of  message after annotaion of component " 
						+component.getName() +": "+ mcs.getKey() + " is " +mc.clients);
				LOGGER.info("Server of  message of component after annotaion of component" 
						+component.getName() +": " + mcs.getKey() + " is " +mc.servers);
			}	
		}
	}
	////
	public Set<String> getComponentInternalVariables(Component component) {
		/// create a heap of component based on all used variables in constraints 
		Set<String> internalVars= new HashSet<String>();
		for (Entry<String, Set<MessageConditions>> mcs : messages.entrySet()) 
			for (MessageConditions mc: mcs.getValue()) {
				if (mc.servers.contains(component.getName())) {
					for (Entry<String, VarType> var : mc.postUsedvariable.entrySet()) {
						String varName=var.getKey().substring(currentText.length()+1,var.getKey().length());
						internalVars.add(currentText+varName);
						internalVars.add(nextText+varName);
					}
					///add a boolean variable for each input and out-put messages  
				
				internalVars.add(inputMessageText+mcs.getKey());
				}
				else if (mc.clients.contains(component.getName()) && 
						(mc.whereToApply!=WhereToApplyEnum.CLIENT) ) 
					for (Entry<String, VarType> var : mc.preUsedvariable.entrySet()) {
						String varName=var.getKey().substring(nextText.length()+1,var.getKey().length());
						internalVars.add(currentText+varName);
						internalVars.add(nextText+varName);
					}	
		
		}
		internalVars.add(reportMessageText+"inputRejected");
		internalVars.add(reportMessageText+"MC_ID");
		LOGGER.info("Internal variables of componet"+ component.getName()+ " is: "+ internalVars.toString());
		return internalVars;
	}
	//////
	public void initComponentVariable(Component component) {
		/// create a heap of component based on all used variables in constraints 
		/// create message variables
		for (Entry<String, Set<MessageConditions>> mcs : messages.entrySet())
			for (MessageConditions mc: mcs.getValue()) {
				if (mc.servers.contains(component.getName())) {
					component.msgHeap.insert(inputMessageText+mcs.getKey(),false);
				}
				/// create payload variable for messages' payload
				for (Entry <String,VarType> payload: mc.payloads.entrySet()) {
					component.payloadHeap.insert(payload.getKey(),ConstraintScriptUtil.createVar(payload.getValue()));
					//component.nextHeap.insert(payload.getKey(),ConstraintScriptUtil.createVar(payload.getValue()));
				}
			}
		/// create current and next variable per each variable
		for (Attribute attr:this.constraintsContext.getAttributes()) {
			if (! attr.getName().startsWith(currentText)) {
				component.currentHeap.insert(currentText+attr.getName(),ConstraintScriptUtil.createVar(attr.getPropertyType()));
				component.nextHeap.insert(nextText+attr.getName(),ConstraintScriptUtil.createVar(attr.getPropertyType()));
			}
		}
	
		
		
		/// create semantic variable
		component.nextHeap.insert(reportMessageText+"inputRejected", false);
		component.nextHeap.insert(reportMessageText+"MC_ID", 0);
		LOGGER.info("Current Heap of component"+ component.getName()+ " is initilized to: "+ component.currentHeap.getVarTable());
		LOGGER.info("Next Heap of component"+ component.getName()+ " is initilized to: "+ component.nextHeap.getVarTable());
		LOGGER.info("Msg Heap of component"+ component.getName()+ " is initilized to: "+ component.msgHeap.getVarTable());
		LOGGER.info("Payload Heap of component"+ component.getName()+ " is initilized to: "+ component.payloadHeap.getVarTable());
	}
	//////
	public void z3InputScriptOfComponet() {
		
	}
	public void z3OutPutScriptOfComponet() {
		
	}
	
	public void sliceForVarible(String varName) {
		
	}
	public void prepareComponentMessagedContraintScriptForClient(Component com) {  // this should be called after the input of component is generated
		String z3Script="";
		for (Entry<String, Set<MessageConditions>> mcs : messages.entrySet()) {
			for (MessageConditions mc: mcs.getValue())
				if (com.getInputMessages().contains(mcs.getKey())) {
					z3Script=z3Script+ "(assert ( => (and "+ inputMessageText+mcs.getKey() + " " ;
					if (! mc.z3Pre.contentEquals("")) {
						z3Script=z3Script+ mc.z3Pre + " ) ";
					}
				else {
					z3Script=z3Script+ " true ) ";
				}
				// when pre is true the post should hold and none of the us-used variable should change
				// we also record the ID
				z3Script=z3Script+ "( and " +mc.z3Post + " " ; 
				// find unused varibale 
				Set<String> unUsedVars=new HashSet<String>(com.currentHeap.getVarTable().keySet());
				unUsedVars.addAll(com.nextHeap.getVarTable().keySet());
				unUsedVars.removeAll(mc.postUsedvariable.keySet());
				z3Script=z3Script+ConstraintScriptUtil.generateExpressionOfVars(unUsedVars);
				// capture the ID
				z3Script=z3Script+ "( = " + reportMessageText+ "MC_ID " + Integer.toString(mc.ID) + " )";
				z3Script=z3Script+ " ) ";
                
				z3Script=z3Script+ " ))" + System.lineSeparator();
			}

		}
		com.componentConstraintScript.setMessageConstraintsBlockForCleints(z3Script);

	}
	public void prepareComponentMessagedContraintScript(Component com) {  // this should be called after the input of component is generated
		String z3Script="";
		for (Entry<String, Set<MessageConditions>> mcs : messages.entrySet()) {
			for (MessageConditions mc: mcs.getValue()) {
				if (com.getInputMessages().contains(mcs.getKey())) {
					z3Script=z3Script+ "(assert ( => (and "+ inputMessageText+mcs.getKey() + " " ;
					if (mc.whereToApply!=WhereToApplyEnum.CLIENT &  ! mc.z3Pre.contentEquals("")) {
						z3Script=z3Script+ mc.z3Pre + " ) ";
					}
					else {
						z3Script=z3Script+ " true ) ";
					}
					// when pre is true the post should hold and none of the us-used variable should change
					z3Script=z3Script+ "( and " +mc.z3Post + " " ; 
					// find unused varibale 
					Set<String> unUsedVars=new HashSet<String>(com.currentHeap.getVarTable().keySet());
					unUsedVars.addAll(com.nextHeap.getVarTable().keySet());
					unUsedVars.removeAll(mc.postUsedvariable.keySet());
					z3Script=z3Script+ConstraintScriptUtil.generateExpressionOfVars(unUsedVars);
					z3Script=z3Script+ "( = " + reportMessageText+ "MC_ID " + Integer.toString(mc.ID) + " )";
					z3Script=z3Script+ " ) ";
					z3Script=z3Script+ " ))" + System.lineSeparator();
				}

			}
		}
		com.componentConstraintScript.setMessageConstraintsBlock(z3Script);
	}
	
	public void prepareComponentGlobalContraintScriptForClient(Component com) {
		String z3Script="(assert ( xor ";
		String notInScript="";
		for (Entry<String, Set<MessageConditions>> mcs : messages.entrySet()) {
			for (MessageConditions mc: mcs.getValue()) {
				if (com.getInputMessages().contains(mcs.getKey())) {
					notInScript=notInScript+"(not "+"(and "+ inputMessageText+mcs.getKey() + " " ;
					z3Script=z3Script+ "(and "+ inputMessageText+mcs.getKey() + " " ;
					if (! mc.z3Pre.contentEquals("")) {
						z3Script=z3Script+ mc.z3Pre + " ) ";
						notInScript=notInScript+mc.z3Pre + " )) ";
					}
					else {
						z3Script=z3Script+ " true ) ";
						notInScript=notInScript+" true )) ";
					}

				}
			}
		}
		Set<String> unchangedVars=new HashSet<String>(com.currentHeap.getVarTable().keySet());
		unchangedVars.addAll(com.nextHeap.getVarTable().keySet());
		z3Script=z3Script+" (and ";
		z3Script=z3Script+notInScript;
		z3Script=z3Script+ConstraintScriptUtil.generateExpressionOfVars(unchangedVars);
		z3Script=z3Script+ "( = " + reportMessageText+ "MC_ID 0"  + " )";
		z3Script=z3Script+") ) )" + System.lineSeparator();
		z3Script=z3Script+ "(assert (= " + reportMessageText+ "inputRejected (and "+ notInScript ;
		z3Script=z3Script+ "( = " + reportMessageText+ "MC_ID 0"  + " )";
		z3Script=z3Script+ " )))";
		// add invariants to the global constraint
		for (Entry<String, Invariant> inv : invariants.entrySet()) {
			String invAssert="(assert (and "+ inv.getValue().z3Cur + " " + inv.getValue().z3Next + " ) )" ;
			z3Script=z3Script+System.lineSeparator()+ invAssert;
		}
		
		com.componentConstraintScript.setGlobalConstraintBlockForClients(z3Script);
		
		
	}
	
	
	
	public void prepareComponentGlobalContraintScript(Component com) {
		String z3Script="(assert ( xor ";
		String notInScript="";
		for (Entry<String, Set<MessageConditions>> mcs : messages.entrySet()) {
			for (MessageConditions mc: mcs.getValue()) {
				if (com.getInputMessages().contains(mcs.getKey())) {
					notInScript=notInScript+"(not "+"(and "+ inputMessageText+mcs.getKey() + " " ;
					z3Script=z3Script+ "(and "+ inputMessageText+mcs.getKey() + " " ;
					if (mc.whereToApply!=WhereToApplyEnum.CLIENT &  ! mc.z3Pre.contentEquals("")) {
						z3Script=z3Script+ mc.z3Pre + " ) ";
						notInScript=notInScript+mc.z3Pre + " )) ";
					}
					else {
						z3Script=z3Script+ " true ) ";
						notInScript=notInScript+" true )) ";
					}

				}
			}
		}
		//Set<String> unchangedVars=com.getVariablesWithoutInMessage();
		Set<String> unchangedVars=new HashSet<String>(com.currentHeap.getVarTable().keySet());
		unchangedVars.addAll(com.nextHeap.getVarTable().keySet());
		z3Script=z3Script+" (and ";
		z3Script=z3Script+notInScript;
		z3Script=z3Script+ConstraintScriptUtil.generateExpressionOfVars(unchangedVars);
		z3Script=z3Script+ "( = " + reportMessageText+ "MC_ID 0"  + " )";
		z3Script=z3Script+") ) )" + System.lineSeparator();
		z3Script=z3Script+ "(assert (= " + reportMessageText+ "inputRejected (and "+ notInScript ;
		z3Script=z3Script+ "( = " + reportMessageText+ "MC_ID 0"  + " )";
		z3Script=z3Script+ " )))";
		com.componentConstraintScript.setGlobalConstraintBlockWithoutInvariant(z3Script);
		// add invariants to the global constraint
		for (Entry<String, Invariant> inv : invariants.entrySet()) {
			String invAssert="(assert (and "+ inv.getValue().z3Cur + " " + inv.getValue().z3Next + " ) )" ;
			z3Script=z3Script+System.lineSeparator()+ invAssert;
		}
		
		com.componentConstraintScript.setGlobalConstraintBlock(z3Script);
		
		
	}
	
	public void loadComponentHeap(Component com) {
		for (Entry<String,Object> var: stateVars.getVarTable().entrySet())
			com.currentHeap.setValue(var.getKey(), var.getValue());
		
	}
	public void unLoadComponentHeap(Component com) {
		for (Entry<String,Object> var: com.currentHeap.getVarTable().entrySet())
			stateVars.setValue(var.getKey(), var.getValue());
	}
	public boolean hasMessageEffects(String msg,Set<String> diff) {
		for (Entry<String,Set<MessageConditions>> mcs : messages.entrySet())
			if (mcs.getKey().contentEquals(msg))
				for (MessageConditions mc: mcs.getValue())
					for (String varName: mc.postUsedvariable.keySet()) {
						if (diff.contains(varName.replace("next_", "cur_")))
							return true;
				}
		return false;
	}
	
	
}
