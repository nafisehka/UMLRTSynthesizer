package UMLRTSynthesizer.constraintccript;

import java.util.HashMap;
import java.util.HashSet;

import umlrtsyntesizer.constLang.VarType;
import umlrtsyntesizer.constLang.WhereToApplyEnum;



public class Invariant {

	public String z3Cur="";
	public String z3Next="";
	public HashMap<String, VarType> usedvariable=new HashMap<String,VarType>();
}
