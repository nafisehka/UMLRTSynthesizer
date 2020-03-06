package UMLRTSynthesizer.EOLUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.MutablePair;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.papyrusrt.codegen.cpp.profile.RTCppProperties.RTCppPropertiesPackage;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.UMLRealTimePackage;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.UMLRTStateMachinesPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public class EpsilonUMLRTModelLoader extends EpsilonEMFModelLoader {
	public EpsilonUMLRTModelLoader(List<MutablePair<String,String>> modelsPathWithAlias) {
		super( modelsPathWithAlias);
	}
	public EpsilonUMLRTModelLoader(String modelPath, String modelAlias) {
		super(modelPath, modelAlias);
		//registerMetaModels();
		//setDefaultmetaModelsNamespacenamespaceURI();
	}
	@Override
	protected void setDefaultmetaModelsNamespacenamespaceURI() {
		// TODO Auto-generated method stub
		super.setDefaultmetaModelsNamespacenamespaceURI();
		this.metaModelsNamespacenamespaceURI = "http://www.eclipse.org/uml2/5.0.0/UML," +
				"http://www.eclipse.org/uml2/5.0.0/Types," +
				"http://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard," +
				"http://www.eclipse.org/papyrus/umlrt/cppproperties," +
				"http://www.eclipse.org/papyrus/umlrt," +
				"http://www.eclipse.org/emf/2002/Ecore," +
				"http://www.eclipse.org/papyrus/umlrt/statemachine," ;//+
	}
	/// register required metamodels and profile for UMLRT models
	@Override
	public void registerMetaModels() {
		super.registerMetaModels();
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
		System.out.println("Metamodels and profiles loaded successfully for UMLRT models");
	    //System.out.println("Size of URI convertor: "+URIConverter.URI_MAP.size());
	    /*for (Entry<URI, URI> entry : URIConverter.URI_MAP.entrySet())
	    {
	        System.out.println(entry.getKey() + "/" + entry.getValue());
	    }*/
	}



}
