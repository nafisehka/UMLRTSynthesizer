package UMLRTSynthesizer.constraintccript;

import java.util.HashMap;
import java.util.HashSet;

import umlrtsyntesizer.constLang.VarType;
import umlrtsyntesizer.constLang.WhereToApplyEnum;



public class MessageConditions {

	public String z3Pre="";
	String z3Post="";
	String z3NotPre="";
	String ccPre="";
	String ccPost="";
	WhereToApplyEnum whereToApply;
	public int ID=-1;
	public HashMap<String, VarType> preUsedvariable=new HashMap<String,VarType>();;
	public HashMap<String, VarType> postUsedvariable=new HashMap<String,VarType>();
	public HashMap<String, VarType> usedvariable=new HashMap<String,VarType>();
	public HashMap<String, VarType> payloads=new HashMap<String,VarType>();
	public HashSet<String> clients= new HashSet<String>();
	public HashSet<String> servers= new HashSet<String>();
}
