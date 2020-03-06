package UMLRTSynthesizer.statespaceexploration;

import UMLRTSynthesizer.constraintccript.Constraints;
import umlrtsyntesizer.constLang.Addition;
import umlrtsyntesizer.constLang.AndExpression;
import umlrtsyntesizer.constLang.Assign;
import umlrtsyntesizer.constLang.BoolLiteral;
import umlrtsyntesizer.constLang.Divide;
import umlrtsyntesizer.constLang.Expression;
import umlrtsyntesizer.constLang.Identifier;
import umlrtsyntesizer.constLang.IntLiteral;
import umlrtsyntesizer.constLang.Literal;
import umlrtsyntesizer.constLang.Minus;
import umlrtsyntesizer.constLang.Modulo;
import umlrtsyntesizer.constLang.Multiplication;
import umlrtsyntesizer.constLang.NotBooleanExpression;
import umlrtsyntesizer.constLang.OrExpression;
import umlrtsyntesizer.constLang.RealLiteral;
import umlrtsyntesizer.constLang.UnaryExpression;

public class ExpressionInterpreter {
	public static Object  execute(Expression exp, Heap heap){
		if (exp instanceof Identifier)
			return execute((Identifier) exp, heap);
		else if (exp instanceof Assign)
			return execute((Assign) exp, heap);
		else if (exp instanceof Literal)
			return execute((Literal)exp);
		else if (exp instanceof AndExpression)
			return execute((AndExpression)exp);
		else if (exp instanceof OrExpression)
			return execute((OrExpression)exp);
		else if (exp instanceof Addition)
			return execute((Addition)exp);
		else if (exp instanceof Minus)
			return execute((Minus)exp);
		else if (exp instanceof Divide)
			return execute((Divide)exp);
		else if (exp instanceof Modulo)
			return execute((Modulo)exp);
		else if (exp instanceof Multiplication)
			return execute((Modulo)exp);
		else if (exp instanceof NotBooleanExpression)
			return execute((NotBooleanExpression)exp);
		else if (exp instanceof UnaryExpression)
			return execute((UnaryExpression)exp);
		else 
			return null;
			//System.out.println("Only assignment can be main expression in intialization");
		
	}
	public static Object execute(Expression exp){
		if (exp instanceof Identifier)
			return execute((Identifier) exp);
		else if (exp instanceof Assign)
			return execute((Assign) exp);
	//	else if (exp instanceof LTLUnaryUntil)
	//		return execute((LTLUnaryUntil) exp);	
		else if (exp instanceof Literal)
			return execute((Literal)exp);
		else if (exp instanceof AndExpression)
			return execute((AndExpression)exp);
		else if (exp instanceof OrExpression)
			return execute((OrExpression)exp);
		else if (exp instanceof Addition)
			return execute((Addition)exp);
		else if (exp instanceof Minus)
			return execute((Minus)exp);
		else if (exp instanceof Divide)
			return execute((Divide)exp);
		else if (exp instanceof Modulo)
			return execute((Modulo)exp);
		else if (exp instanceof Multiplication)
			return execute((Modulo)exp);
		else if (exp instanceof NotBooleanExpression)
			return execute((NotBooleanExpression)exp);
		else if (exp instanceof UnaryExpression)
			return execute((UnaryExpression)exp);
		else 
			return null;
			//System.out.println("Only assignment can be main expression in intialization");
		
	}
	/// addition execution
	public static Object execute(Addition addExp){
		Expression right=addExp.getRight();
		Expression left=addExp.getLeft();
		Object rightResult=execute(right);
		Object leftResult=execute(left);
		if (rightResult instanceof Integer && leftResult instanceof Integer)
			return ((Integer)rightResult)+ ((Integer)leftResult);
		else if (rightResult instanceof String && leftResult instanceof String)
			return ((String)rightResult)+ ((String)leftResult);
		else 
			return null;	
	}
	/// minus execution
	public static Object execute(Minus addExp){
		Expression right=addExp.getRight();
		Expression left=addExp.getLeft();
		Object rightResult=execute(right);
		Object leftResult=execute(left);
		if (rightResult instanceof Integer && leftResult instanceof Integer)
			return ((Integer)leftResult)-((Integer)rightResult);
		else 
			return null;	
	}
	
	////  divide
	public static Object execute(Divide divExp){
		return null;	
	}
	////
	public static Object execute( Multiplication mulExp){
		return null;	
	}
	///
	public static Object execute( Modulo modExp){
		return null;	
	}
	////
	public static Object execute(UnaryExpression unExp){
		return null;	
	}
	
	//@Overloading
	public static Object execute(Assign assignExp, Heap heap){
		Expression left=assignExp.getLeft();
		Expression right=assignExp.getRight();
		/////
		if (heap.isVarExist(Constraints.currentText+((Identifier)left).getRef().getName())){
			Object rightResult=execute((Expression) right);
			heap.setValue(Constraints.currentText+((Identifier)left).getRef().getName(), rightResult);
			return rightResult;
		}

		return null;	
	}
		
	public static Object execute(OrExpression orExp){
		return false;	
	}
	
	public static Object execute(AndExpression andExp){
		return false;	
	}
	//@Overloading
	public static Object execute(Identifier iden, Heap heap){
		if (heap.isVarExist(Constraints.currentText+iden.getRef().getName()))
			return heap.getValue(Constraints.currentText+iden.getRef().getName());
		else
			return null;
	}
	public static Object execute(Literal literal){
		if (literal instanceof IntLiteral)
			return ((IntLiteral) literal).getIntLiteral();
		else if (literal instanceof RealLiteral)
			return ((RealLiteral)literal).getIntPart();
		else if (literal instanceof BoolLiteral)
			return Boolean.valueOf(((BoolLiteral)literal).getBoolLiteral());
		else 
			return null;
	}
	
	public static Object execute(NotBooleanExpression notBooleanExp){
		
		return false;	
	}

}
