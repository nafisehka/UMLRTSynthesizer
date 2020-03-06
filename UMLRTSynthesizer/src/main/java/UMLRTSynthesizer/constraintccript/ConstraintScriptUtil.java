package UMLRTSynthesizer.constraintccript;

import java.util.Set;

import org.eclipse.emf.common.util.EList;

import umlrtsyntesizer.constLang.Attribute;
import umlrtsyntesizer.constLang.Init;
import umlrtsyntesizer.constLang.MessageConstraint;
import umlrtsyntesizer.constLang.VarType;



public class ConstraintScriptUtil {
	public void parse(String scriptPath) {
	
	}
	
	public void validate() {
		
	}
	
	
	static public Object createVar(VarType var) {
		switch (var) {
			case BOOLEAN:
				Boolean b=false;
				return b;
			case INTEGER:
				Integer i=0;
				return i;
			case REAL:
				Double d=0.0;
				return d;
			default:
				return null;
		}
	}

	public MessageConstraint getConstraintForMessage(String Message) {
		//To do 
		return null;	
	}
	
	public Init getInitCode( ) {
		//To do 
		return null;	
	}
	
	public EList<Attribute> getAttributes( ) {
		//To do 
		return null;	
	}
	
	public EList<Attribute> getAttributeOfConstraint(Attribute attr) {
		//To do 
		return null;
	}


	
	public static String generateExpressionOfVars(Set<String> inp) {
		if (inp.size()==0) 
			return " true ";
		else if (inp.size()==1) {
			String var=(String)inp.toArray()[0];
			if (var.startsWith(Constraints.nextText))
				return "( = "+ var + " "+ Constraints.currentText+var.substring(Constraints.nextText.length(),var.length()) + ") true  "; 
			else 
				return " true ";
		} else {
			String result="";
			for (String var: inp) {
				if (var.startsWith(Constraints.nextText))
					result=result+"( = "+ var + " "+ Constraints.currentText+var.substring(Constraints.nextText.length(),var.length()) + ") "; 
			}
			return result;
		}
		
	}
	
}
