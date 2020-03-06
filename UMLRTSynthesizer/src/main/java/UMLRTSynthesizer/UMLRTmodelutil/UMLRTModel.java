package UMLRTSynthesizer.UMLRTmodelutil;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage;
import org.eclipse.epsilon.ecl.parse.Ecl_EolParserRules.returnStatement_return;
import org.eclipse.papyrusrt.codegen.cpp.profile.RTCppProperties.RTCppPropertiesPackage;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.Protocol;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.UMLRealTimePackage;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.RTPseudostate;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.RTRegion;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.UMLRTStateMachinesPackage;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.impl.RTStateImpl;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.impl.RTStateMachineImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.ValueSpecificationAction;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.internal.impl.CallEventImpl;
import org.eclipse.uml2.uml.internal.impl.ConstraintImpl;
import org.eclipse.uml2.uml.internal.impl.ValueSpecificationImpl;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.resource.UMLResource;




public   class UMLRTModel {
	
	ResourceSet resSet;
	Resource resource;
	private Model UMLRTmodel;
	


	public void load(String pathtoModel) {
        resSet = new ResourceSetImpl();
        resource = resSet.createResource(URI.createURI(pathtoModel));
        this.registerMetaModels();
        try {
            resource.load(null);
            UMLRTmodel = (Model)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.MODEL);
            //this.rootElement=(ExecTraces) EcoreUtil.getObjectByType(resource.getContents(), ExecTracesPackage.Literals.EXEC_TRACES);
        } catch (IOException e) {
            e.printStackTrace();
        } 	
	}
	
	
	public org.eclipse.uml2.uml.Class getCapsule(String capName) {
		for (Object capsule: EcoreUtil.getObjectsByType(UMLRTmodel.getPackagedElements(), UMLPackage.Literals.CLASS)){
			if (((org.eclipse.uml2.uml.Class)capsule).getName().contentEquals(capName))
				return ((org.eclipse.uml2.uml.Class) capsule);
			
		}
		return null;
	}
	
	public StateMachine createStateMachine(org.eclipse.uml2.uml.Class owner, String name) {
		StateMachine sm = UMLFactory.eINSTANCE.createStateMachine();
		owner.getOwnedBehaviors().add(sm);
		sm.setName(name);
		if (applyStreotype(owner.getModel(),sm, "RTStateMachine") <= 0) {
			System.err.println("Region Stereotype is not aplied");
		}
		Region rg=UMLFactory.eINSTANCE.createRegion();
		sm.getRegions().add(rg);
		if (applyStreotype(owner.getModel(),rg, "RTRegion") <= 0) {
			System.err.println("Region Stereotype is not aplied");
		}
	    return sm;
	}
	public Pseudostate createPseudoState(StateMachine sm, String name, org.eclipse.uml2.uml.PseudostateKind kind) {
		Region rg=sm.getRegions().get(0);
		Pseudostate pState=(Pseudostate) rg.createSubvertex(name,  UMLPackage.Literals.PSEUDOSTATE);
		pState.setKind(kind);
		applyStreotype(sm.getModel(), pState, "RTPseudostate");
		return pState;
	}
	
	public State createState(StateMachine sm, String name) {
		Region rg=sm.getRegions().get(0);
		State bState=(State) rg.createSubvertex(name,  UMLPackage.Literals.STATE);
		applyStreotype(sm.getModel(), bState, "RTState");
		return bState;
	}
	
	public Transition createTransition(StateMachine sm, String name, State source, State target){
		 Region rg=sm.getRegions().get(0);
		 org.eclipse.uml2.uml.Transition trans= rg.createTransition(name);
		 trans.setSource(source);
		 trans.setTarget(target);
		 return trans;
	}
	
	public Transition setAction(Transition trans, String body) {
		OpaqueBehavior opaqueBehavior=UMLFactory.eINSTANCE.createOpaqueBehavior();
		opaqueBehavior.setName("");
		opaqueBehavior.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		opaqueBehavior.setIsActive(true);
		opaqueBehavior.getLanguages().add("C++");
		opaqueBehavior.getBodies().add(body);
		trans.setEffect(opaqueBehavior);
		return trans;
	}
	
	public Transition setGuard(Transition trans, String guard) {

		Constraint constraint=trans.createGuard("test");
		OpaqueExpression expression = (OpaqueExpression) constraint.createSpecification(null, null, UMLPackage.eINSTANCE.getOpaqueExpression());
		expression.getLanguages().add("C++");
		expression.getBodies().add(guard);
		return trans;
	}
	
	public Transition setTrigger(Class umlrtCapsule, Transition trans, String msg) {
		Trigger trigger=UMLFactory.eINSTANCE.createTrigger();
		trigger.setName(msg);
		trigger.getPorts().add(getMessagePort(umlrtCapsule,msg));
		trigger.setEvent(getMessageEvent(umlrtCapsule,msg));
		trans.getTriggers().add(trigger);
		getMessagePort(umlrtCapsule,msg);
		return trans;
	}
	
	public Port getMessagePort(Class umlrtCapsule,String msg) {
		for (Port port: umlrtCapsule.getOwnedPorts()) {
			for (Element element: port.getType().getOwner().allOwnedElements()) {
				if (element instanceof CallEventImpl) {
					CallEventImpl event=(CallEventImpl) element;
					if (event.getOperation().getName().contentEquals(msg))
						return port;
				}
			}
		}
		return null;
	}
	
	public CallEventImpl getMessageEvent(Class umlrtCapsule,String msg) {
		for (Port port: umlrtCapsule.getOwnedPorts()) {
			for (Element element: port.getType().getOwner().allOwnedElements()) {
				if (element instanceof CallEventImpl) {
					CallEventImpl event=(CallEventImpl) element;
					if (event.getOperation().getName().contentEquals(msg))
						return event;
				}
			}
		}
		return null;
	}
	
	
	
	public int applyStreotype(Model model, StateMachine umlModelElement, String stereotypeName) {
		int result = 0;
		for (Profile profile : model.getAllAppliedProfiles()) {
			 EPackage ep = profile.getDefinition();
		}

		for (org.eclipse.uml2.uml.Stereotype stereoType : umlModelElement.getApplicableStereotypes()) {
			if (stereoType.getName().equals(stereotypeName)) {
				RTStateMachineImpl st=(RTStateMachineImpl) umlModelElement.applyStereotype(stereoType);
				st.setBase_StateMachine(umlModelElement);
				result++;
			
			}
		}
		return result;
	}
	
	public int applyStreotype(Model model, State umlModelElement, String stereotypeName) {
		int result = 0;
		for (Profile profile : model.getAllAppliedProfiles()) {
			 EPackage ep = profile.getDefinition();
		}

		for (org.eclipse.uml2.uml.Stereotype stereoType : umlModelElement.getApplicableStereotypes()) {
			if (stereoType.getName().equals(stereotypeName)) {
				RTStateImpl st=(RTStateImpl) umlModelElement.applyStereotype(stereoType);
				st.setBase_State(umlModelElement);
				result++;
			
			}
		}
		return result;
	}
	
	public int applyStreotype(Model model, Pseudostate umlModelElement, String stereotypeName) {
		int result = 0;
		for (Profile profile : model.getAllAppliedProfiles()) {
			 EPackage ep = profile.getDefinition();
		}

		for (org.eclipse.uml2.uml.Stereotype stereoType : umlModelElement.getApplicableStereotypes()) {
			if (stereoType.getName().equals(stereotypeName)) {
				RTPseudostate st=(RTPseudostate) umlModelElement.applyStereotype(stereoType);
				st.setBase_Pseudostate(umlModelElement);
				result++;
			}
		}
		return result;
	}
	
	public int applyStreotype(Model model, Region umlModelElement, String stereotypeName) {
		int result = 0;
		for (Profile profile : model.getAllAppliedProfiles()) {
			 EPackage ep = profile.getDefinition();
			//System.out.println(profile.getLabel());
		}
		// umlModelElement.getApplicableStereotypes();
		for (org.eclipse.uml2.uml.Stereotype stereoType : umlModelElement.getApplicableStereotypes()) {
			//System.out.println(stereoType.getName());
			if (stereoType.getName().equals(stereotypeName)) {
				RTRegion st=(RTRegion) umlModelElement.applyStereotype(stereoType);
				st.setBase_Region(umlModelElement);
				result++;
			
			}
		}
		return result;
	}
	
	 public void saveModel(){
	        try {
	            this.resource.save(null);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 }
	


	
	public void registerMetaModels() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl ());
		EPackage.Registry.INSTANCE.put(Ecore2XMLPackage.eNS_URI,Ecore2XMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		Map<URI,URI>  uriMap= new HashMap<URI, URI>();
		uriMap = org.eclipse.uml2.uml.resources.util.UMLResourcesUtil.initURIConverterURIMap(uriMap);
		// load profile from papyrus-rt jar file, the jar file should be set in classpath 
		String UMLRealTimeSMProfilePath=this.getClass().getClassLoader().getResource("umlProfile/UMLRealTimeSM-addendum.profile.uml").toString();
		uriMap.put(URI.createURI("pathmap://UML_RT_PROFILE/UMLRealTimeSM-addendum.profile.uml"), URI.createURI(UMLRealTimeSMProfilePath)); 
		String RTCppPropertiesProfilePath=this.getClass().getClassLoader().getResource("profiles/RTCppProperties.profile.uml").toString();
		uriMap.put(URI.createURI("pathmap://UMLRT_CPP/RTCppProperties.profile.uml"),URI.createURI(RTCppPropertiesProfilePath));
		String UMLRTProfilePath=this.getClass().getClassLoader().getResource("umlProfile/uml-rt.profile.uml").toString();
		uriMap.put(URI.createURI("pathmap://UML_RT_PROFILE/uml-rt.profile.uml"),URI.createURI(UMLRTProfilePath));
		String UMLRTRTSLIBPath=this.getClass().getClassLoader().getResource("libraries/UMLRT-RTS.uml").toString();
		uriMap.put(URI.createURI("pathmap://UMLRTRTSLIB/UMLRT-RTS.uml"),URI.createURI(UMLRTRTSLIBPath));
		/// register packages for UMLRT packages
		URIMappingRegistryImpl.INSTANCE.putAll(uriMap);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new UMLResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		EPackage.Registry.INSTANCE.put(UMLRealTimePackage.eNS_URI, UMLRealTimePackage.eINSTANCE);
		UMLRealTimePackage.class.getResource("");
		EPackage.Registry.INSTANCE.put(RTCppPropertiesPackage.eNS_URI, RTCppPropertiesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(UMLRTStateMachinesPackage.eNS_URI, UMLRTStateMachinesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(StandardPackage.eNS_URI, StandardPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		//System.out.println("Metamodels and profiles loaded successfully for UMLRT models");
	    //System.out.println("Size of URI convertor: "+URIConverter.URI_MAP.size());
	    /*for (Entry<URI, URI> entry : URIConverter.URI_MAP.entrySet())
	    {
	        System.out.println(entry.getKey() + "/" + entry.getValue());
	    }*/
	}

	public Transition  createTransition(StateMachine sm, String name, Pseudostate source, State target) {
		 Region rg=sm.getRegions().get(0);
		 org.eclipse.uml2.uml.Transition trans= rg.createTransition(name);
		 trans.setSource(source);
		 trans.setTarget(target);
		 trans.setEffect(null);
		 trans.createTrigger(null);
		 return trans;
		
	}

}
