package UMLRTSynthesizer.statespaceexploration;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import umlrtsyntesizer.execTraces.BoolLiteral;
import umlrtsyntesizer.execTraces.IntLiteral;
import umlrtsyntesizer.execTraces.Node;
import umlrtsyntesizer.execTraces.Variable;






public class Heap {
	public Heap() {
		this.varTable = new LinkedHashMap<String,Object>() ;
	}

	//private HashMap<String, Object> varTable;
	private LinkedHashMap<String, Object> varTable;
	
	/// insert new variable to heap
	public  LinkedHashMap<String, Object> getVarTable(){
		return varTable;
	}
	
	public void insert(String Name, Object value){
		varTable.put(Name,value);
	}
	/// get variable data
	public Object getValue(String Name){
		if (this.isVarExist(Name))
			return  varTable.get(Name);
		else
			return null;
	}
	
	public boolean isVarExist(String Name){
		return  varTable.containsKey(Name);
	}
	/// set new value to specified key, on success return true, otherwise return false;
	public boolean setValue(String Name, Object value){
		if (this.isVarExist(Name)){
			varTable.put(Name, value);
			return true;
		}
		else
			return false;
	}

	/// get heap hash
	//public int getHash(){
	//	return this.varTable.hashCode();
	//}
	static public String getStrValue(Object obj) {
		if (obj instanceof Boolean)
			return ((Boolean) obj).toString();
		else if (obj instanceof Integer)
			return ((Integer) obj).toString();
		else if (obj instanceof Double)
			return ((Double) obj).toString();
		else 
			return "";
	}
	
	public static String getValueTypeStr(Object value) {
		if (value instanceof Boolean)
			return "Bool";
		else if (value instanceof Integer)
			return "Int";
		else if (value instanceof Double)
			return "Real";
		else 
			return "";
	}

	public void load(Heap sourceHeap) {
		for (Map.Entry<String, Object> var : varTable.entrySet() ) {
			var.setValue(sourceHeap.getValue(var.getKey()));
		}
		
	}

	public Set<String> diff(Heap targetHeap) {
		Set<String> diff=new HashSet<>();
		for (Map.Entry<String, Object> var : targetHeap.getVarTable().entrySet() ) {
			if (!(this.getValue(var.getKey())==var.getValue())) {
				diff.add(var.getKey());
			}	
		}
		return diff;
	}

	public Boolean compareDeep(Node node) {
		if (node.getVarData().size()!=this.getVarTable().size())
			return false;
		for (Variable var : node.getVarData()) {
			if (var.getValue() instanceof BoolLiteral) {
					Boolean varValue=Boolean.parseBoolean((((BoolLiteral) var.getValue()).getBool()));
					if (this.getValue(var.getName())!=varValue)
						return false;	
			}
			else if (var.getValue() instanceof IntLiteral) {
				int varValue=(((IntLiteral) var.getValue()).getInt());
				if ((int)this.getValue(var.getName())!=varValue)
					return false;
			}
		}
		return true;
		
	}

	public String generateId() {
		// TODO Auto-generated method stub
		String result="";
		for (Map.Entry<String, Object> var : this.getVarTable().entrySet() ) {
			result=result+this.getStrValue(var.getValue());
		}
		return result;
	}

 
	
	/* @Override
	 public int hashCode() {
		 int result = 17;
		 for (Map.Entry<String, Object> var : this.getVarTable().entrySet() ) {
		        result = 17;
		        result = 31 * result + var.getKey().hashCode();
		        if (var.getValue() instanceof Integer)
		        	result = 31 * result + (Integer) var.getValue() ^ ((Integer)var.getValue()  >>> 32);
		        else if (var.getValue() instanceof Boolean)
		        	result = 31 * result + ((Boolean) var.getValue() ? 1 : 0);
		        //long creditsLong = Double.doubleToLongBits(credits);
		        //result = 31 * result + (int) (creditsLong ^ (creditsLong >>> 32));
		        //result = 31 * result + Arrays.hashCode(interests);
		        
		 }
		 return result;
	 }*/

}
