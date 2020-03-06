package UMLRTSynthesizer.statespaceexploration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import UMLRTSynthesizer.UMLRTmodelutil.UMLRTModel;
import UMLRTSynthesizer.UMLRTmodelutil.UMLRTModelQuery;
import UMLRTSynthesizer.constraintccript.Constraints;


public class SystemModel {
	private Constraints constraints;
	private List<Component> components;
	private String UMLRTModelPath;
	private String outputPath;
	UMLRTModelQuery umlrtQuery;
	public SystemModel(String UMLRTModelPath, String messageContraintsPath, String outputPath) {
		components= new ArrayList<Component>();
		constraints= new Constraints(messageContraintsPath);
		constraints.load();
		constraints.processConstriants();
	    this.UMLRTModelPath=UMLRTModelPath;
	    umlrtQuery= new UMLRTModelQuery(this.UMLRTModelPath);
	   	umlrtQuery.loadModel();
	   	initializeComponenets(umlrtQuery.gettAllCapsule());   
	   	this.outputPath=outputPath;
	}
	//////
	public Component getComponentWithInput(String message) {
		for (Component com: this.components) {
			if (com.getInputMessages().contains(message)) {
				return com;
			}
		}
		return null;
	}
	//////
	private void initializeComponenets(Set<String> components) {
		for (String componentName: components) {
			Component com=new Component(componentName);
			com.setInputMessages(umlrtQuery.getCapsuleInput(componentName));
			com.setOutputMessages(umlrtQuery.getCapsuleOutput(componentName));
			com.setOutputMessagesPort(umlrtQuery.getCapsuleOutputMsgsPort(componentName));
			for (String msg: com.getInputMessages()) {
				com.setMessagePayloads(msg,umlrtQuery.getMessagePayload(msg));
			}
			com.setAttributes(umlrtQuery.getCapsuleAttributes(componentName));
			if ((com.getInputMessages().size()>0) || (com.getOutputMessages().size()>0)) {
				this.components.add(com);
				constraints.annotaeConstriantsWithComponents(com);
			}
			long startTimeofEncoding = System.currentTimeMillis();
			constraints.initComponentVariable(com);
			constraints.prepareComponentMessagedContraintScript(com);
			constraints.prepareComponentMessagedContraintScriptForClient(com);
			com.generateVarDefineBlock();
			constraints.prepareComponentGlobalContraintScript(com);
			constraints.prepareComponentGlobalContraintScriptForClient(com);
			long endTimeofEncoding = System.currentTimeMillis();
			long timeElapsed = endTimeofEncoding - startTimeofEncoding;
			System.out.println("Computation time of SMT formula of componets  "+ com.getName() +" is done in "+ timeElapsed + " milliseconds");
			//for (String msg: com.getInputMessages()) {
			//	System.out.println(com.generateInputScript(msg,false));
			//}
			
			//-- geerate global constraint of the component
		}
	}
	////////
	public void synthesizeBehaviourofCompoenent(Component com,int bound,int stateCount) {
		ComponentStateSpaceExplorer comExplorer=new ComponentStateSpaceExplorer(this,com,this.constraints);
		System.out.println("-----  State Spape Exploration (SSE) of component : " + com.getName() + " with a bound set to ------" + Integer.toString(bound));
		long startTimeofSSE = System.currentTimeMillis();
		comExplorer.explorerStates(bound);
		long endTimeofSSE = System.currentTimeMillis();
		System.out.println("SSE of " + com.getName()+ " is done in  " +(endTimeofSSE-startTimeofSSE) + " milliseconds");
		comExplorer.reportSizeofSyntesizedLTS();
		System.out.println("----- Sytesising actions of LTS for  : " + com.getName());
		
		long startTimeofSyntesize = System.currentTimeMillis();
		comExplorer.syntesizeAction();
		long endTimeofSyntesize = System.currentTimeMillis();
		System.out.println("Sytesising actions of LTS for  : " + com.getName() + "is done in "+ (endTimeofSyntesize-startTimeofSyntesize) + " milliseconds ");
		comExplorer.fixDigitalWathActions();
		comExplorer.saveResult(outputPath+"/full_"+com.getName()+".trace");
		System.out.println("---------LTS  mimization---------");
		long startTimeofMerge = System.currentTimeMillis();
		comExplorer.minimizeLTS3(stateCount);		
		comExplorer.reportSizeofSyntesizedLTS();
		long endTimeofMerge = System.currentTimeMillis();
		
		System.out.println("LTS minimization of : " + com.getName() +" is done in  "+(endTimeofMerge-startTimeofMerge) + " milliseconds");
		//-- test save model here
		comExplorer.saveResult(outputPath+"/minimized_"+com.getName()+".trace");
		comExplorer.reportSizeofSyntesizedLTS();
		System.out.println("---------Transformation into UML-RT models ---------");
		
		///// transform to UMLRT model, convert guards from MC_ID to expression
		/*UMLRTModel umlrtmodel= new UMLRTModel();
		umlrtmodel.load(UMLRTModelPath);
		long startTimeofTransf = System.currentTimeMillis();
		org.eclipse.uml2.uml.Class umlrtCapsule=umlrtmodel.getCapsule(com.getName());
		comExplorer.transfromLTS2UMLRT(umlrtmodel,umlrtCapsule);
		long endTimeofTransf = System.currentTimeMillis();
		System.out.println("Transfomration of LTS into UMLRT State Machine for  : " + com.getName() +" is done in  "+(endTimeofTransf-startTimeofTransf) + " milliseconds");
		umlrtmodel.saveModel();*/
		
		
	}
	public void synthesizeBehaviourofAllCompoenents() {
		for (Component com: this.components) {
			synthesizeBehaviourofCompoenent(com,15,30);
			
		}
		
	}
	
	public void synthesizeBehaviourofCompoenent(String componentName, int bound,int stateCount) {
		for (Component com: this.components) {
			if (com.getName().contentEquals(componentName))
				synthesizeBehaviourofCompoenent(com,bound,stateCount);
			
		}
	}
	public void saveResultintoUMLRT() { /// save the result of syntesize into UMLRTModels
		
	}
	
}
