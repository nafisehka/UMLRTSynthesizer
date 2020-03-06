package UMLRTSynthesizer.Z3;

import java.util.LinkedHashMap;
import java.util.Map;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;

import UMLRTSynthesizer.constraintccript.Constraints;
import UMLRTSynthesizer.statespaceexploration.Heap;

public class Z3Executor {
	Context z3Context;
	Model SATModel;
	Solver z3Solver;
	
	public Z3Executor() {
		z3Context= new Context();
		z3Solver=z3Context.mkSolver();
	}
	public Boolean isSatisfiable(String script) {
		z3Solver.reset();
		z3Solver.fromString(script);
		if (z3Solver.check()==Status.UNSATISFIABLE || z3Solver.check()==Status.UNKNOWN)
			return false;
		else {
			SATModel=z3Solver.getModel();
			return true;
		}
	}
	public Object getVarValueInModel(String varName,String varType) {
		if (SATModel != null) {
			if (varType.contentEquals("Boolean")) {
				Expr z3Expr= z3Context.mkBoolConst(varName);
				BoolExpr result=(BoolExpr) SATModel.eval(z3Expr, true);
				return Boolean.parseBoolean(result.toString());
			} else if (varType.contentEquals("Integer")) {
				Expr z3Expr= z3Context.mkIntConst(varName);
				IntExpr result=(IntExpr) SATModel.eval(z3Expr, true); 
				return Integer.parseInt(result.toString()); // this line is not tested, be careful we may need to change that
			}
		}
		return null;
	}
	
	// create a method to load heap from models
	public void loadSATModelVartoMap(LinkedHashMap<String, Object> varTable,Heap tempHeap) {
		for (Map.Entry<String, Object> var: varTable.entrySet()) {
			Object value;
			if (var.getValue() instanceof Boolean)
				value=this.getVarValueInModel(var.getKey(),"Boolean");
			else if (var.getValue() instanceof Integer)
				value=this.getVarValueInModel(var.getKey(),"Integer");
			else 
				value=this.getVarValueInModel(var.getKey(),"");
			if (!var.getKey().contains(Constraints.reportMessageText))
				tempHeap.insert(var.getKey().replace("next", "cur"), value);
			}
		
	}

}
