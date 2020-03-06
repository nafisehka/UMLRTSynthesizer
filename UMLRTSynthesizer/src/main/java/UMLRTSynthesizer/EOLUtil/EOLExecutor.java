package UMLRTSynthesizer.EOLUtil;

import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

//import org.eclipse.core.runtime.URIUtil;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class EOLExecutor {
	private List<IModel> models;
	private String scriptPath;
	private String params="";
	private String args="";
	private boolean profiling=false;
	private String sourceModelpath;
	private String CSVScriptOutputs=""; 
	
	public String getCSVScriptOutputs() {
		return CSVScriptOutputs;
	}
	public void setCsvScriptOutputs(String csvScriptOutputs) {
		this.CSVScriptOutputs = csvScriptOutputs;
	}
	EolModule module;
	public EOLExecutor(String sourceModelPath,String scriptPath, List<IModel> models,String args, boolean profiling){
		this.scriptPath=scriptPath;
		this.models=models;
		module = new EolModule();
		this.sourceModelpath=sourceModelPath;
		this.args=args;
		this.profiling=profiling;
	}
	EOLExecutor(String sourceModelPath,String scriptPath, List<IModel> models, String params,String args, boolean profiling ){
		this.scriptPath=scriptPath;
		this.models=models;
		module = new EolModule();
		this.setParams(params);
		this.sourceModelpath=sourceModelPath;
		this.args=args;
		this.profiling=profiling;
	}

	// execute the script against the models provided
	public void execute() {
		 
	    try {
	    	module.parse(getFileURI(this.scriptPath));
	    	if (module.getParseProblems().size() > 0) {
	    		System.err.println("Parse errors occured...");
	    		for (ParseProblem problem : module.getParseProblems()) {
	    			System.err.println(problem.toString());
	    			}
	    		return;
	    	}
	    	for (IModel m: models)
	    		module.getContext().getModelRepository().addModel(m);
	    	/// send parameter
	    	Variable parametres = new Variable();
	    	parametres.setType(EolPrimitiveType.String);
	    	parametres.setName("params");
	    	parametres.setValue(this.params, module.getContext());
	    	module.getContext().getFrameStack().put(parametres);
	    	
	    	Variable scriptArgs = new Variable();
	    	scriptArgs.setType(EolPrimitiveType.String);
	    	scriptArgs.setName("args");
	    	scriptArgs.setValue(this.args, module.getContext());
	    	module.getContext().getFrameStack().put(scriptArgs);
	    	
	    	Variable csvScriptOutputs = new Variable();
	    	csvScriptOutputs.setType(EolPrimitiveType.String);
	    	csvScriptOutputs.setName("csvScriptOutputs");
	    	csvScriptOutputs.setValue(this.CSVScriptOutputs, module.getContext());
	    	module.getContext().getFrameStack().put(csvScriptOutputs);
	    	////
	    	//System.out.println("Executing EOL Scripts " + "'"+ this.scriptPath+"'" + " .....");
	    	//System.out.println("------Beginning of the script result--------");
	    	Timestamp timestamp= new Timestamp(System.currentTimeMillis());
			module.execute();
			
			long duration=System.currentTimeMillis()-timestamp.getTime();
			//System.out.println("------End of the script result--------");
			//System.out.println("Transromation of model: " + this.sourceModelpath + " is done in " + duration +" ms");
			if (profiling) {
				Path p = Paths.get(scriptPath);
				String profileFilePath=p.getParent()+"/profile.csv";
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(profileFilePath, true)));
				writer.println(timestamp+","+p.getFileName()+","+this.sourceModelpath+","+ duration);
				writer.close();
			}
			//if (module.getContext().getErrorStream().checkError())
			//	System.exit(-1);
			this.CSVScriptOutputs=(String) csvScriptOutputs.getValue();
		    //module.getContext().getModelRepository().dispose();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// return uri for a file path
	protected URI getFileURI(String fileName) throws URISyntaxException {
		URI uri=URI.create(fileName);
		if (uri.isAbsolute())
			return uri;
		
		uri = this.getClass().getClassLoader().getResource(fileName).toURI();
		return uri;

	}
	public String getParams() {
		return params;
	}
	public void setParams(String paramsFilePath) {
		this.params = paramsFilePath;
	}	
}
