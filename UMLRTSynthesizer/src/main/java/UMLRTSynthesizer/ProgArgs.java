package UMLRTSynthesizer;


import java.util.Arrays;
import java.util.List;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;



public class ProgArgs {
	public static class HelperPathConvertor implements IStringConverter<List<String>> {
		  @Override
		  public List<String> convert(String value) {
		    return Arrays.asList(value.split(","));
		  }
	}
	JCommander jCommander;
	@Parameter(names = { "-umlrtmodel","-m" }, description = "Path of the structural UMLRTModel model",required = true)
	public String modelPath;
	@Parameter(names = { "-script","-s" }, description = "Path of the constraint script",required = true)
	public String scriptPath;
	@Parameter(names = { "-outputDir","-o" }, description = "Directory where the result will be saved",required = true)
	public String outPath;
	@Parameter(names = { "-component","-c" }, description = "Name of the component whose behaviour to be syntesized",required = true)
	public String componentName;
	@Parameter(names = { "-bound","-b" }, description = "bound of the exploration",required = false)
	public int bound=0;
	@Parameter(names = { "-number","-n" }, description = "Number of states in final state machine",required = false)
	public int stateCount=0;
	//@Parameter(names = { "-phase","-p" }, description = "The execution will be done until the specefied phase that can be 1..4",required = false)
	//public Integer phase;

	public void parse(String[] args) {
		if (jCommander==null)
			jCommander=new JCommander(this);
	     jCommander.setProgramName("UMLRTSyntesizer");
	     try {
	        jCommander.parse(args);
	     } catch (ParameterException e) {
			// TODO: handle exception
	        jCommander.usage();
	        System.exit(-1);
	     }
	 }
}
