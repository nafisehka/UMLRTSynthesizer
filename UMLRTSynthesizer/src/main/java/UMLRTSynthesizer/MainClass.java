package UMLRTSynthesizer;


import java.io.IOException;



import UMLRTSynthesizer.statespaceexploration.SystemModel;


public class MainClass 
{
	   public static void main(String[] args) throws IOException {
		   ProgArgs progArgs=new ProgArgs();
		   progArgs.parse(args);
		   SystemModel sysModel=new SystemModel(progArgs.modelPath,progArgs.scriptPath,progArgs.outPath);
		   //sysModel.synthesizeBehaviourofAllCompoenents();
		   if (progArgs.bound==0)
			   progArgs.bound=10;
		   if (progArgs.stateCount==0)
			   progArgs.stateCount=30;
		   sysModel.synthesizeBehaviourofCompoenent(progArgs.componentName,progArgs.bound,progArgs.stateCount);

		    
	    }

}
