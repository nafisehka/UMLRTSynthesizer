package UMLRTSynthesizer.constraintccript;

public class ComponentConstraintScript {
	private String initConstraint="" ;     // capture init constraint
	private String currentConstraintsBlock="";   // 
	private String nextConstraintBlock="";
	private String inputConstraintBlock="";
	private String varDefineBlock="";
	private String globalConstraintBlock="";  // one input at each time (xor), if no pre hold then all variable will be same
	private String globalConstraintBlockWithoutInvariant="";
	private String messageConstraintsBlock="";
	private String messageConstraintsBlockForCleints="";
	private String globalConstraintBlockForClients=""; 
	public String getInitConstraint() {
		return initConstraint;
	}
	public void setInitConstraint(String initConstraint) {
		this.initConstraint = initConstraint;
	}
	public String getCurrentConstraintsBlock() {
		return currentConstraintsBlock;
	}
	public void setCurrentConstraintsBlock(String currentConstraintsBlock) {
		this.currentConstraintsBlock = currentConstraintsBlock;
	}
	public String getNextConstraintBlock() {
		return nextConstraintBlock;
	}
	public void setNextConstraintBlock(String nextConstraintBlock) {
		this.nextConstraintBlock = nextConstraintBlock;
	}
	public String getInputConstraintBlock() {
		return inputConstraintBlock;
	}
	public void setInputConstraintBlock(String inputConstraintBlock) {
		this.inputConstraintBlock = inputConstraintBlock;
	}
	public String getVarDefineBlock() {
		return varDefineBlock;
	}
	public void setVarDefineBlock(String varDefineBlock) {
		this.varDefineBlock = varDefineBlock;
	}
	public String getGlobalConstraintBlock() {
		return globalConstraintBlock;
	}
	public void setGlobalConstraintBlock(String globalConstraintBlock) {
		this.globalConstraintBlock = globalConstraintBlock;
	}
	public String getMessageConstraintsBlock() {
		return messageConstraintsBlock;
	}
	public void setMessageConstraintsBlock(String messageConstraintsBlock) {
		this.messageConstraintsBlock = messageConstraintsBlock;
	}
	public String getMessageConstraintsBlockForCleints() {
		return messageConstraintsBlockForCleints;
	}
	public void setMessageConstraintsBlockForCleints(String messageConstraintsBlockForCleints) {
		this.messageConstraintsBlockForCleints = messageConstraintsBlockForCleints;
	}

	public String getGlobalConstraintBlockForClients() {
		return globalConstraintBlockForClients;
	}
	public void setGlobalConstraintBlockForClients(String globalConstraintBlockForClients) {
		this.globalConstraintBlockForClients = globalConstraintBlockForClients;
	}
	public void setGlobalConstraintBlockWithoutInvariant(String z3Script) {
		this.globalConstraintBlockWithoutInvariant=z3Script;
		
	}
	public String getGlobalConstraintBlockWithoutInvariant() {
		return this.globalConstraintBlockWithoutInvariant;
		
	}
}
