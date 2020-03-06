package UMLRTSynthesizer.EMFUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;



public abstract  class ModelUtility<E> {
	
	static  EFactory modelFactory;
	private String   modelPath;
	private String   modelExtension;
	private EObject  rootElement;
	
	abstract public boolean loadModel();

	/*
	 *  save model 
	 */

	 public void saveModel(){
	        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	        Map<String, Object> m = reg.getExtensionToFactoryMap();
	        m.put(this.getModelExtension(), new XMIResourceFactoryImpl());
	        /////
	        // Obtain a new resource set
	        ResourceSet resSet = new ResourceSetImpl();

	        // create a resource
	        Resource resource = resSet.createResource(URI.createURI(this.getmodelPath()));
	        
	        resource.getContents().add(this.getRootElement());
	        //EcoreUtil.
	        // now save the content.
	        try {
	            resource.save(Collections.EMPTY_MAP);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 }
	
	/**
	 * @setup the model path and model type
	 */
	public void setupModel(EFactory modelFactory,String path,String modelExtension,EObject rootElement){
		this.setmodelPath(path);
		ModelUtility.modelFactory=modelFactory;
		this.setModelExtension(modelExtension);
		this.setRootElement(rootElement);
	}
	/**
	 * @return the path
	 */
	public String getmodelPath() {
		return modelPath;
	}
	/**
	 * @param path the path to set
	 */
	public void setmodelPath(String path) {
		this.modelPath = path;
	}
	/**
	 * @return the modelExtension
	 */
	public String getModelExtension() {
		return modelExtension;
	}
	/**
	 * @param modelExtension the modelExtension to set
	 */
	public void setModelExtension(String modelExtension) {
		this.modelExtension = modelExtension;
	}
	/**
	 * @return the rootEObject
	 */
	public EObject getRootElement() {
		return rootElement;
	}
	/**
	 * @param rootEObject the rootEObject to set
	 */
	public void setRootElement(EObject rootEObject) {
		this.rootElement = rootEObject;
	}

}
