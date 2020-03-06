package UMLRTSynthesizer.statespaceexploration;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import UMLRTSynthesizer.constraintccript.ComponentConstraintScript;
import UMLRTSynthesizer.constraintccript.Constraints;
import UMLRTSynthesizer.constraintccript.MessageConditions;

import java.util.Set;

public class Component {
	//ExecTraces traces
	// current heap
	// 
	private Set<String> inputMessages;
	private Map<String,Set<String>> messagesPayloads;
	private Set<String> outputMessages;
	private HashMap<String, String> outMessagesPort;
	private String name;
	public Heap currentHeap;
	public Heap nextHeap;
	public Heap msgHeap;
	public Heap payloadHeap;
	public ComponentConstraintScript componentConstraintScript;
	private Set<String> attributes;
	//private HashMap<String,MessageConstraint> inputConstraintScripts;
	
	public Component(String componentName) {
		this.name=componentName;
		this.currentHeap= new Heap();
		this.nextHeap=new Heap();
		this.msgHeap=new Heap();
		this.payloadHeap=new Heap();
		outMessagesPort= new HashMap<String, String>();
		this.setMessagesPayloads(new HashMap<String,Set<String>>());
		componentConstraintScript=new ComponentConstraintScript();
		
		//inputConstraintScripts = new HashMap<String,MessageConstraint>();
	}
	
	public String getOutMessagePort(String message) {
		if (this.outMessagesPort.containsKey(message))
			return this.outMessagesPort.get(message);
		else 
			return "";
	}

	public void addOutMessagesPort(String message, String port) {
		this.outMessagesPort.put(message, port);
	}
	public void setOutputMessagesPort(HashMap<String, String> msg2PortMap) {
		this.outMessagesPort=msg2PortMap;
	}
	private String currentHeapToConstraint() {
		String z3Assertions="";
		for (Entry<String, Object> var : this.currentHeap.getVarTable().entrySet()) {
			if (var.getKey().startsWith(Constraints.currentText) &  !var.getKey().startsWith(Constraints.reportMessageText))
				z3Assertions=z3Assertions+"(assert ( = " + var.getKey() +" "+ 
						Heap.getStrValue(var.getValue()) + " ))"+ System.lineSeparator();
		}
		return z3Assertions;
	}
	
	private String nextHeapToConstraint() {
		String z3Assertions="";
		for (Entry<String, Object> var : this.nextHeap.getVarTable().entrySet()) {
			if (var.getKey().startsWith(Constraints.nextText) &  !var.getKey().startsWith(Constraints.reportMessageText))
				z3Assertions=z3Assertions+"(assert ( = " + var.getKey() +" "+ 
						Heap.getStrValue(var.getValue()) + " ))"+ System.lineSeparator();
		}
		return z3Assertions;
	}
	private String msgHeapToConstraint() {
		String z3Assertions="";
		for (Entry<String, Object> var : this.msgHeap.getVarTable().entrySet()) {
			if (var.getKey().startsWith(Constraints.inputMessageText) &  !var.getKey().startsWith(Constraints.reportMessageText))
				z3Assertions=z3Assertions+"(assert ( = " + var.getKey() +" "+ 
						Heap.getStrValue(var.getValue()) + " ))"+ System.lineSeparator();
		}
		return z3Assertions;
	}
	public String heapToConstraintWithoutMessages() { // fix it later, do not generate the assertion for input messages
		String z3Assertions="";
		for (Entry<String, Object> var : this.msgHeap.getVarTable().entrySet()) {
			if (! var.getKey().startsWith(Constraints.inputMessageText)  & 
					!var.getKey().startsWith(Constraints.reportMessageText))
				z3Assertions=z3Assertions+"(assert ( = " + var.getKey() +" "+ 
						Heap.getStrValue(var.getValue()) + " ))"+ System.lineSeparator();
		}
		return z3Assertions;
	}
	
	public String generateVarDefineBlock() {
		String z3Assertions="";
		for (Entry<String, Object> var : this.currentHeap.getVarTable().entrySet()) {
			z3Assertions=z3Assertions+"(declare-const  " + var.getKey() +" "+ 
					Heap.getValueTypeStr(var.getValue()) + " )"+System.lineSeparator();
		}
		for (Entry<String, Object> var : this.nextHeap.getVarTable().entrySet()) {
			z3Assertions=z3Assertions+"(declare-const  " + var.getKey() +" "+ 
					Heap.getValueTypeStr(var.getValue()) + " )"+System.lineSeparator();
		}
		for (Entry<String, Object> var : this.msgHeap.getVarTable().entrySet()) {
			z3Assertions=z3Assertions+"(declare-const  " + var.getKey() +" "+ 
					Heap.getValueTypeStr(var.getValue()) + " )"+System.lineSeparator();
		}
		for (Entry<String, Object> var : this.payloadHeap.getVarTable().entrySet()) {
			z3Assertions=z3Assertions+"(declare-const  " + var.getKey() +" "+ 
					Heap.getValueTypeStr(var.getValue()) + " )"+System.lineSeparator();
		}
		this.componentConstraintScript.setVarDefineBlock(z3Assertions);
		return z3Assertions;
	}
	public String generateInputScriptWithoutInvariant(String message)  {
		String z3Script="";
		for (String msg : this.inputMessages) {
			this.msgHeap.setValue(Constraints.inputMessageText+msg, false);
		}
		this.msgHeap.setValue(Constraints.inputMessageText+message, true);
		z3Script=this.componentConstraintScript.getVarDefineBlock();
		z3Script=z3Script+this.currentHeapToConstraint()+System.lineSeparator();
		//z3Script=z3Script+this.nextHeapToConstraint()+System.lineSeparator(); --> next heap should be 
		// synthesized based on the current value and input message
		z3Script=z3Script+this.msgHeapToConstraint()+System.lineSeparator();
		z3Script=z3Script+this.componentConstraintScript.getMessageConstraintsBlock()+System.lineSeparator();
		z3Script=z3Script+this.componentConstraintScript.getGlobalConstraintBlockWithoutInvariant()+System.lineSeparator();
		return z3Script; 
	}
	public String generateInputScript(String message, Boolean isClient ) {
		String z3Script="";
		for (String msg : this.inputMessages) {
			this.msgHeap.setValue(Constraints.inputMessageText+msg, false);
		}
		this.msgHeap.setValue(Constraints.inputMessageText+message, true);
		z3Script=this.componentConstraintScript.getVarDefineBlock();
		z3Script=z3Script+this.currentHeapToConstraint()+System.lineSeparator();
		//z3Script=z3Script+this.nextHeapToConstraint()+System.lineSeparator(); --> next heap should be 
		// synthesized based on the current value and input message
		z3Script=z3Script+this.msgHeapToConstraint()+System.lineSeparator();
		if (isClient)
			z3Script=z3Script+this.componentConstraintScript.getMessageConstraintsBlockForCleints()+System.lineSeparator();
		else
			z3Script=z3Script+this.componentConstraintScript.getMessageConstraintsBlock()+System.lineSeparator();
		if (isClient)
			z3Script=z3Script+this.componentConstraintScript.getGlobalConstraintBlockForClients()+System.lineSeparator();
		else
			z3Script=z3Script+this.componentConstraintScript.getGlobalConstraintBlock()+System.lineSeparator();
		return z3Script;
		//-- generate this , then we ar done by this, and can start state space explration
	}

	
	public Set<String> getMsgPayload(String msg){
		return this.messagesPayloads.get(msg);
	}
	
	public Set<MessageConditions> getMessageCondition(String msg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private void constrainttoHeap() {
		
	}
	
	
	void processInput(String zConstraints) {
		
	}

	public Set<String> getInputMessages() {
		return inputMessages;
	}

	public void setInputMessages(Set<String> inputMessages) {
		this.inputMessages = inputMessages;
	}

	public Set<String> getOutputMessages() {
		return outputMessages;
	}

	public void setOutputMessages(Set<String> outputMessages) {
		this.outputMessages = outputMessages;
	}
	
	public void setAttributes(Set<String> outputMessages) {
		this.attributes = outputMessages;
	}
	
	public Set<String> getAttributes() {
		return attributes;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String,Set<String>> getMessagesPayloads() {
		return messagesPayloads;
	}

	public void setMessagesPayloads(Map<String,Set<String>> messagesPayloads) {
		this.messagesPayloads = messagesPayloads;
	}

	public void setMessagePayloads(String msg, Set<String> messagePayload) {
		this.messagesPayloads.put(msg, messagePayload);
		
	}



	/*public HashSet<String> getVariablesWithoutInMessage() {
		HashSet<String> vars=new HashSet<String>();
		for (String var : this.heap.getVarTable().keySet())
			if ((! var.startsWith(Constraints.inputMessageText)) & 
					(! var.startsWith(Constraints.currentText))) {
				vars.add(var);
			}
		return vars;
	}*/
	
	
	
}
