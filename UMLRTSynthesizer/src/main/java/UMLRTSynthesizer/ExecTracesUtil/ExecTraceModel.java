package UMLRTSynthesizer.ExecTracesUtil;

import java.io.IOException;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage;

import UMLRTSynthesizer.statespaceexploration.Heap;
import umlrtsyntesizer.execTraces.BoolLiteral;
import umlrtsyntesizer.execTraces.Edge;
import umlrtsyntesizer.execTraces.ExecTraces;
import umlrtsyntesizer.execTraces.ExecTracesFactory;
import umlrtsyntesizer.execTraces.ExecTracesPackage;
import umlrtsyntesizer.execTraces.IntLiteral;
import umlrtsyntesizer.execTraces.Literal;
import umlrtsyntesizer.execTraces.Node;
import umlrtsyntesizer.execTraces.StateStatus;
import umlrtsyntesizer.execTraces.TransStatus;
import umlrtsyntesizer.execTraces.Variable;




public class ExecTraceModel {
	private ExecTraces traceRoot;
	public static ExecTracesFactory traceFactory= ExecTracesFactory.eINSTANCE;
	int maxLevel;
	ResourceSet resSet;
	Resource resource;
	
	 
	
	public ExecTraceModel(ExecTraces traceRoot) {
		// TODO Auto-generated constructor stub
		loadMetaModels();
		this.traceRoot=traceRoot;
		
	}
	public ExecTraceModel() {
		// TODO Auto-generated constructor stub
		loadMetaModels();
		this.traceRoot=traceFactory.createExecTraces();
		
	}
	
	public ExecTraceModel(String pathtoModel) {
		// TODO Auto-generated constructor stub
		loadMetaModels();
		this.load(pathtoModel);
		
	}
	
	private void load(String pathtoModel) {
        resSet = new ResourceSetImpl();
        resource = resSet.createResource(URI.createURI(pathtoModel));
        // register the metamodel
        try {
            resource.load(null);
            this.traceRoot=(ExecTraces) EcoreUtil.getObjectByType(resource.getContents(), ExecTracesPackage.Literals.EXEC_TRACES);
        } catch (IOException e) {
            e.printStackTrace();
        } 	
	}
	
	public void save(String pathtoModel) {
		if (resSet==null)
			resSet = new ResourceSetImpl();
		//if (resource==null) 
		{
			resource = resSet.createResource(URI.createURI(pathtoModel));
			resource.getContents().add(traceRoot);
		}
        // register the metamodel
        try {
            resource.save(null);
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
	}
	
	void loadMetaModels() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("trace", new umlrtsyntesizer.execTraces.impl.ExecTracesFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl ());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("trace", new XMIResourceFactoryImpl());
		//m.put(this.getModelExtension(), new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(Ecore2XMLPackage.eNS_URI,Ecore2XMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ExecTracesPackage.eNS_URI, ExecTracesPackage.eINSTANCE);    
		
	}
	
	public ExecTraces getTraceRoot() {
		return traceRoot;
	}

	public void setTraceRoot(ExecTraces traceRoot) {
		this.traceRoot = traceRoot;
	}
	
	public void addChild(Node parent, Node child, String msgname, TransStatus status,String gaurdID ){
		//parent.getChilds().add(child);
		//child.getParent().add(parent);
		this.addEdge(parent,child,msgname,status,gaurdID);
	}
	
	public void addNode(Node node, StateStatus status){
		this.getTraceRoot().getNode().add(node);
		if (node.getLevel()>maxLevel)
			setMaxLevel(node.getLevel());
		node.setStatus(status);
	}
	
	public  void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void addEdge(Node source, Node destination, String msgName,TransStatus status,String guardID){
		Edge edge=traceFactory.createEdge();
		edge.setSource(source);
		edge.setDestination(destination);
		edge.setTrigger(msgName);
		edge.setStatus(status);
		edge.setGuard(guardID);
		source.getOutgoingEdges().add(edge);
		
		destination.getIncomingEdges().add(edge);
		this.getTraceRoot().getEdge().add(edge);
		//((Trace) this.getRootElement()).getEdge().add(edge);
	}

	public Node getRootNode() {
		return getTraceRoot().getNode().get(0);
	}

	public int getMaxLevel() {
		// TODO Auto-generated method stub
		return maxLevel;
	}
	// 
	public void loadNodeVarFromHeap(Node node,Heap heap) {
		for (Entry<String, Object> var : heap.getVarTable().entrySet()) {
			Variable nodeVar= ExecTraceModel.traceFactory.createVariable();
			nodeVar.setName(var.getKey());
			Literal value = null;
			if (var.getValue() instanceof Boolean) {
				value= ExecTraceModel.traceFactory.createBoolLiteral();
				((BoolLiteral) value).setBool(Heap.getStrValue(var.getValue()));
			}
			else if (var.getValue() instanceof Integer){
				value= ExecTraceModel.traceFactory.createIntLiteral();
				((IntLiteral) value).setInt(Integer.parseInt(Heap.getStrValue(var.getValue())));
			} 
			nodeVar.setValue(value);
			node.getVarData().add(nodeVar);
		}
		
	}
	public void unloadNodeDataToHeap(Node node,Heap heap) {
		for (Variable var: node.getVarData()) {
			Object value;
			if (var.getValue() instanceof BoolLiteral) {
				//String s=((BoolLiteral) var.getValue()).getBool();
				value=Boolean.parseBoolean(((BoolLiteral) var.getValue()).getBool());
				//System.out.println("Value of string " + s + " coverted to bool value " + value);
			}
			else
				value=((IntLiteral) var.getValue()).getInt();
			heap.getVarTable().put(var.getName(), value);
			
   }
	
		
	}
	
	//@Overloading 
	public String getVarData(Node node){
		String nameInNode="";
		for (Variable var: node.getVarData()) {
			String value="null";
			if (var.getValue()!=null){
				if (var.getValue() instanceof IntLiteral)
					value=String.valueOf(((IntLiteral) var.getValue()).getInt());
				else  if (var.getValue() instanceof BoolLiteral)
					value=String.valueOf(((BoolLiteral) var.getValue()).getBool());
			}
		    nameInNode+= var.getName() + ": " + value+"  ";
		}
		return nameInNode;
	}
	public String getDiffVarData(Node parent, Node child){
		EList<Variable> childList= child.getVarData();
		EList<Variable> parentList= parent.getVarData();
		String nameInNode="", valueChild="", valueParent="";	 	
		for (int i=0; i<childList.size();i++){ 
			if (childList.get(i).getValue()!=null){
		//for (Variable var: childList){
					if (childList.get(i).getValue() instanceof IntLiteral){
						valueChild=String.valueOf(((IntLiteral) childList.get(i).getValue()).getInt());
						valueParent=String.valueOf(((IntLiteral) parentList.get(i).getValue()).getInt());
					}
					else  if (childList.get(i).getValue() instanceof BoolLiteral){
						valueChild=String.valueOf(((BoolLiteral) childList.get(i).getValue()).getBool());
						valueParent=String.valueOf(((BoolLiteral) parentList.get(i).getValue()).getBool());
					}
					if (! valueChild.equals(valueParent))
						nameInNode+=childList.get(i).getName() + ": " + valueChild+" ";
				}
			
		}		
		return nameInNode;
	}
	

}
