package UMLRTSynthesizer.UMLRTmodelutil;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.uml2.uml.Model;

import UMLRTSynthesizer.EOLUtil.EOLExecutor;
import UMLRTSynthesizer.EOLUtil.EpsilonUMLRTModelLoader;



public class UMLRTModelQuery {

	private final String UMLRTModelAlias="UMLRTModel";
	private String UMLRTModelPath="";
	private String epsilonScriptpath;
	private EpsilonUMLRTModelLoader epsilonUMLRTModelLoader;


	public UMLRTModelQuery(String UMLRTModelPath) {
		this.UMLRTModelPath=UMLRTModelPath;
		this.epsilonScriptpath="epsilonScripts/mainScript.eol";
		System.out.println("Epsilon Script Path: "+epsilonScriptpath);
		// load the model

	}
	public void loadModel() {
			epsilonUMLRTModelLoader= new EpsilonUMLRTModelLoader(this.getUMLRTModelPath(),
					this.UMLRTModelAlias);
			
			try {
				epsilonUMLRTModelLoader.loadModels();
			} catch (EolModelLoadingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public Set<String> gettAllCapsule() {
		EOLExecutor eolExecutor=new EOLExecutor(this.getUMLRTModelPath(),this.getEpsilonScriptpath(),
				epsilonUMLRTModelLoader.getModels(),"capsules",false);
		eolExecutor.execute();
		String result= eolExecutor.getCSVScriptOutputs();
		return this.convertQueryResultToSet(result);
		
	}
	public Set<String> getCapsuleInput(String capsuleName) {
		EOLExecutor eolExecutor=new EOLExecutor(this.getUMLRTModelPath(),this.getEpsilonScriptpath(),
				epsilonUMLRTModelLoader.getModels(),"input:"+capsuleName,false);
		eolExecutor.execute();
		String result= eolExecutor.getCSVScriptOutputs();
		return this.convertQueryResultToSet(result);
	}
	public Set<String> getCapsuleOutput(String capsuleName) {
		EOLExecutor eolExecutor=new EOLExecutor(this.getUMLRTModelPath(),this.getEpsilonScriptpath(),
				epsilonUMLRTModelLoader.getModels(),"output:"+capsuleName,false);
		eolExecutor.execute();
		String result= eolExecutor.getCSVScriptOutputs();
		convertQueryResultToSet(result);
		Set<String> tempSet=this.convertQueryResultToSet(result);
 		Set<String> tempSet2=new HashSet<String>();
		for (String tempStr: tempSet)
			if (tempStr.contains("__"))
				tempSet2.add(tempStr.split("__")[1]);
			else 
				tempSet2.add(tempStr);
		return tempSet2;
	}
	public Set<String> getCapsuleAttributes(String capsuleName) {
		EOLExecutor eolExecutor=new EOLExecutor(this.getUMLRTModelPath(),this.getEpsilonScriptpath(),
				epsilonUMLRTModelLoader.getModels(),"vars:"+capsuleName,false);
		eolExecutor.execute();
		String result= eolExecutor.getCSVScriptOutputs();
		return this.convertQueryResultToSet(result);
	}
	
	private Set<String> convertQueryResultToSet(String inputStr) {
		List<String> items = Arrays.asList(inputStr.split("\\s*,\\s*"));
		Set<String> set = new HashSet<String>(items);
		return set;
	}
	private List<String> convertQueryResultToList(String inputStr) {
		List<String> items = Arrays.asList(inputStr.split("\\s*,\\s*"));
		return items;
	}
	public String getUMLRTModelPath() {
		return UMLRTModelPath;
	}
	public void setUMLRTModelPath(String uMLRTModelPath) {
		UMLRTModelPath = uMLRTModelPath;
	}
	public String getEpsilonScriptpath() {
		return epsilonScriptpath;
	}
	public void setEpsilonScriptpath(String epsilonScriptpath) {
		this.epsilonScriptpath=UMLRTModelQuery.class.getClassLoader().
				getResource("test/mainScript.eol").toString();
	}
	public Set<String> getMessagePayload(String msg) {
		EOLExecutor eolExecutor=new EOLExecutor(this.getUMLRTModelPath(),this.getEpsilonScriptpath(),
				epsilonUMLRTModelLoader.getModels(),"payloads:"+msg,false);
		eolExecutor.execute();
		String result= eolExecutor.getCSVScriptOutputs();
		return this.convertQueryResultToSet(result);
	}
	public HashMap<String, String> getCapsuleOutputMsgsPort(String componentName) {
		// TODO Auto-generated method stub
		EOLExecutor eolExecutor=new EOLExecutor(this.getUMLRTModelPath(),this.getEpsilonScriptpath(),
				epsilonUMLRTModelLoader.getModels(),"output:"+componentName,false);
		eolExecutor.execute();
		HashMap<String, String> tempMap=new HashMap<String, String>();
		String result= eolExecutor.getCSVScriptOutputs();
		for (String msg2Port: this.convertQueryResultToSet(result)) {
			if (msg2Port.contains("__")) {
				String  temp[]=msg2Port.split("__");
				tempMap.put(temp[1], temp[0]);
			}
				
		}
		return tempMap;
	}
	
}
