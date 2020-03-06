package UMLRTSynthesizer.ExecTracesUtil;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import UMLRTSynthesizer.EMFUtil.ModelUtility;
import umlrtsyntesizer.execTraces.ExecTracesFactory;
import umlrtsyntesizer.execTraces.ExecTracesPackage;


public class TraceGraphModelUtility extends  ModelUtility<Object>{
	public static ExecTracesFactory traceFactory= ExecTracesFactory.eINSTANCE;
	private static int maxLevel=0;

	@Override
	public boolean loadModel() {
	        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	        ExecTracesPackage testPackage = ExecTracesPackage.eINSTANCE;      
	        Map<String, Object> m = reg.getExtensionToFactoryMap();
	        m.put(this.getModelExtension(), new XMIResourceFactoryImpl());
	        // Obtain a new resource set
	        ResourceSet resSet = new ResourceSetImpl();
	        Resource resource = resSet.createResource(URI.createURI(this.getmodelPath()));
	        // regitster the metamodel
	        EPackage.Registry reg2 = resSet.getPackageRegistry();
	        reg2.put(testPackage.getNsURI(), testPackage);
	        try {
	            resource.load(null);
	            super.setRootElement(resource.getContents().get(0));
	            return true;
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return false;
	        }    
	}
	
 

}
