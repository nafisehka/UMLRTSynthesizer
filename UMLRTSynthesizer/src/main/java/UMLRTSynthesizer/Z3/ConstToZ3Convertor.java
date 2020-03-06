package UMLRTSynthesizer.Z3;

import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;

import umlrtsyntesizer.constLang.Addition;
import umlrtsyntesizer.constLang.AndExpression;
import umlrtsyntesizer.constLang.Assign;
import umlrtsyntesizer.constLang.Attribute;
import umlrtsyntesizer.constLang.BoolLiteral;
import umlrtsyntesizer.constLang.Divide;
import umlrtsyntesizer.constLang.EQ;
import umlrtsyntesizer.constLang.Expression;
import umlrtsyntesizer.constLang.GE;
import umlrtsyntesizer.constLang.GT;
import umlrtsyntesizer.constLang.Identifier;
import umlrtsyntesizer.constLang.Implie;
import umlrtsyntesizer.constLang.IntLiteral;
import umlrtsyntesizer.constLang.LE;
import umlrtsyntesizer.constLang.LT;
import umlrtsyntesizer.constLang.MessageConstraint;
import umlrtsyntesizer.constLang.Minus;
import umlrtsyntesizer.constLang.Modulo;
import umlrtsyntesizer.constLang.Multiplication;
import umlrtsyntesizer.constLang.NE;
import umlrtsyntesizer.constLang.NotBooleanExpression;
import umlrtsyntesizer.constLang.OrExpression;
import umlrtsyntesizer.constLang.Param;
import umlrtsyntesizer.constLang.VarType;



public class ConstToZ3Convertor {
	private final static Logger LOGGER = Logger.getLogger(ConstToZ3Convertor.class.getName());
	public void getZ3SolverOfComponent() {
		
	}
	
	public void getVar(HashMap<String,VarType> vars, Expression expression, String currenttext, HashMap <String,VarType> params) {
		if (expression instanceof Identifier) {
			String varName=((Identifier) expression).getRef().getName();
			if (! varName.startsWith(currenttext) & ! params.containsKey(varName))
				varName=currenttext+varName;
			vars.put(varName,((Identifier) expression).getRef().getPropertyType());
		}
		else {
			Collection<Identifier> idens=EcoreUtil2.getAllContentsOfType(expression, Identifier.class);
			for (Object iden: idens) {
				String varName=((Identifier) iden).getRef().getName();
				if (! varName.startsWith(currenttext) & ! params.containsKey(varName))
					varName=currenttext+varName;
				vars.put(varName,((Identifier) iden).getRef().getPropertyType());
			}
		}
	}
	
	public void getVar(HashMap<String,VarType> vars, Expression expression, String currenttext) {
		if (expression instanceof Identifier) {
			String varName=((Identifier) expression).getRef().getName();
			if (! varName.startsWith(currenttext) )
				varName=currenttext+varName;
			vars.put(varName,((Identifier) expression).getRef().getPropertyType());
		}
		else {
			Collection<Identifier> idens=EcoreUtil2.getAllContentsOfType(expression, Identifier.class);
			for (Object iden: idens) {
				String varName=((Identifier) iden).getRef().getName();
				if (! varName.startsWith(currenttext) )
					varName=currenttext+varName;
				vars.put(varName,((Identifier) iden).getRef().getPropertyType());
			}
		}
	}
	
	
	public void getParam(HashMap<String,VarType> vars, EList<Attribute> payloads, String currenttext) {
		for (Attribute param: payloads) {
			vars.put(param.getName(),((Attribute) param).getPropertyType());
		}

	}
	
	/*public String convert(Expression expression) {
		if (expression instanceof AndExpression)
			return this.convert((AndExpression) expression);
		else if (expression instanceof OrExpression)
			return this.convert((OrExpression) expression);
		else if (expression instanceof NotBooleanExpression)
			return this.convert((NotBooleanExpression) expression);
		else if (expression instanceof Identifier)
			return this.convert((Identifier) expression);
		else if (expression instanceof Implie)
			return this.convert((Implie) expression);
		else if (expression instanceof LE)
			return this.convert((LE) expression);
		else if (expression instanceof GE)
			return this.convert((GE) expression);
		else if (expression instanceof EQ)
			return this.convert((EQ) expression);
		else if (expression instanceof NE)
			return this.convert((NE) expression);
		else if (expression instanceof Addition)
			return this.convert((Addition) expression);
		else if (expression instanceof Minus)
			return this.convert((Minus) expression);
		else if (expression instanceof Multiplication)
			return this.convert((Multiplication) expression);
		else if (expression instanceof Modulo)
			return this.convert((Modulo) expression);
		else if (expression instanceof Divide)
			return this.convert((Divide) expression);
		else {
			LOGGER.error("Can not convert experssion " + expression.toString() );
			System.exit(255);
			return "";
		}
	}*/
	
	
	public String convert(Expression expression, String post) {
		if (expression instanceof AndExpression)
			return this.convert((AndExpression) expression,post);
		else if (expression instanceof OrExpression)
			return this.convert((OrExpression) expression,post);
		else if (expression instanceof NotBooleanExpression)
			return this.convert((NotBooleanExpression) expression,post);
		else if (expression instanceof Identifier) 
				return this.convert((Identifier) expression,post);
		else if (expression instanceof Implie)
			return this.convert((Implie) expression,post);
		else if (expression instanceof LE)
			return this.convert((LE) expression,post);
		else if (expression instanceof GE)
			return this.convert((GE) expression,post);
		else if (expression instanceof EQ)
			return this.convert((EQ) expression,post);
		else if (expression instanceof NE)
			return this.convert((NE) expression,post);
		else if (expression instanceof Addition)
			return this.convert((Addition) expression,post);
		else if (expression instanceof Minus)
			return this.convert((Minus) expression,post);
		else if (expression instanceof Multiplication)
			return this.convert((Multiplication) expression,post);
		else if (expression instanceof Modulo)
			return this.convert((Modulo) expression,post);
		else if (expression instanceof Divide)
			return this.convert((Divide) expression,post);
		else if (expression instanceof Assign)
			return this.convert((Assign) expression,post);
		else if (expression instanceof BoolLiteral)
			return this.convert((BoolLiteral) expression,post);
		else if (expression instanceof IntLiteral)
			 return this.convert((IntLiteral) expression,post).toString();
		else if (expression instanceof GE)
			return this.convert((Expression) expression,post);
		else if (expression instanceof LT)
			return this.convert((LT) expression,post);
		else if (expression instanceof GT)
			return this.convert((GT) expression,post);
		else {
			LOGGER.error("Can not convert experssion " + expression.toString() );
			System.exit(255);
			return "";
		}

	}
	
	public String convert(Param param) {
		String varType=param.getPropertyType().getName();
		if (varType.contentEquals("Integer")){
			return "(declare-const " +  param.getName() + " Int)";
		} else if (varType.contentEquals("Boolean")){
			return "(declare-const " +  param.getName() + " Bool)";
		}
		else if (varType.contentEquals("Real")){
			return "(declare-const " +  param.getName() + " Real)";
		}
		else {
			LOGGER.error("Attribute '" + param.getName() +
					"' with type '" + varType + "' cannot be converted to a z3 attribue" );
			return " ";
		}
	}
	
	public String convert(Attribute constAttribute) {
		String varType=constAttribute.getPropertyType().getName();
		if (varType.contentEquals("Integer")){
			return "(declare-const " +  constAttribute.getName() + " Int)";
		} else if (varType.contentEquals("Boolean")){
			return "(declare-const " +  constAttribute.getName() + " Bool)";
		}
		else if (varType.contentEquals("Real")){
			return "(declare-const " +  constAttribute.getName() + " Real)";
		}
		else {
			LOGGER.error("Attribute '" + constAttribute.getName() +
					"' with type '" + varType + "' cannot be converted to a z3 attribue" );
			return " ";
		}
	}
	
	public String convert(Identifier iden, String post) {
		if ((iden.eContainer() instanceof MessageConstraint) )  // do not convert payloads 
			for ( Attribute param: ((MessageConstraint) iden.eContainer()).getParams())
				if (param.getName().contentEquals(iden.getRef().getName()))
					return iden.getRef().getName();
		if (iden.eContainer().eContainer() instanceof MessageConstraint)  // do not convert payloads 
			for ( Attribute param: ((MessageConstraint) iden.eContainer().eContainer()).getParams())
				if (param.getName().contentEquals(iden.getRef().getName()))
					return iden.getRef().getName();
		if (iden.getRef().eContainer() instanceof MessageConstraint)  // do not convert payloads 
			for ( Attribute param: ((MessageConstraint) iden.getRef().eContainer()).getParams())
				if (param.getName().contentEquals(iden.getRef().getName()))
					return iden.getRef().getName();
		if (! (iden.getRef().getName().startsWith("cur_")))
			return post+iden.getRef().getName();
		else 
			return iden.getRef().getName();
	}

	
	
	public String convert(Assign assignExpr, String post) {
		return "(= " + convert(assignExpr.getLeft(),post) + " " +  convert(assignExpr.getRight(),post) + ")";
	}
	public String convert(AndExpression andExpr, String post) {
		return "(and " + convert(andExpr.getLeft(),post) + " " +  convert(andExpr.getRight(),post) + ")";
	}
	public String convert(OrExpression orExpr, String post) {
		return "(or " + convert(orExpr.getLeft(),post) + " " +  convert(orExpr.getRight(),post) + ")";
	}
	public String convert(Implie implyExpr, String post) {
		return "(=> " + convert(implyExpr.getLeft(),post) + " " +  convert(implyExpr.getRight(),post) + ")";
	}
	public String convert(NotBooleanExpression notBoolExpr, String post) {
		return "(not " + convert(notBoolExpr.getExp(),post) + ")";
	}
	public String convert(LE lessEqualExpr, String post) {
		return "(<= " + convert(lessEqualExpr.getLeft(),post) + " " +  convert(lessEqualExpr.getRest(),post) + ")";
	}
	public String convert(GE greaterEqualExpr, String post) {
		return "(>= " + convert(greaterEqualExpr.getLeft(),post) + " " +  convert(greaterEqualExpr.getRest(),post) + ")";
	}
	public String convert(GT greaterExpr, String post) {
		return "(> " + convert(greaterExpr.getLeft(),post) + " " +  convert(greaterExpr.getRest(),post) + ")";
	}
	public String convert(LT lesserExpr, String post) {
		return "(< " + convert(lesserExpr.getLeft(),post) + " " +  convert(lesserExpr.getRest(),post) + ")";
	}
	public String convert(EQ equalExpr, String post) {
		return "(= " + convert(equalExpr.getLeft(),post) + " " +  convert(equalExpr.getRest(),post) + ")";
	}
	public String convert(NE notEqualExpr, String post) {
		return "(not (= " + convert(notEqualExpr.getLeft(),post) + " " +  convert(notEqualExpr.getRest(),post) + "))";
		
	}
	public String convert(Addition addExpr, String post) {
		return "(+ " + convert(addExpr.getLeft(),post) + " " +  convert(addExpr.getRight(),post) + ")";
	}
	public String convert(Minus minusExpr, String post) {
		return "(- " + convert(minusExpr.getLeft(),post) + " " +  convert(minusExpr.getRight(),post) + ")";
		
	}
	public String convert(Divide divideExpr, String post) {
		return "(/ " + convert(divideExpr.getLeft(),post) + " " +  convert(divideExpr.getRight(),post) + ")";
		
	}
	public String convert(Multiplication mulExpr, String post) {
		return "(* " + convert(mulExpr.getLeft(),post) + " " +  convert(mulExpr.getRight(),post) + ")";
	}
	public String convert(Modulo modExpr, String post) {
		return "(mod " + convert(modExpr.getLeft(),post) + " " +  convert(modExpr.getRight(),post) + ")";
	}
	public Integer convert(IntLiteral intLiteral, String post) {
		return intLiteral.getIntLiteral();
	}
	public String convert(BoolLiteral boolLiteral, String post) {
		return boolLiteral.getBoolLiteral();
	}

	
}
