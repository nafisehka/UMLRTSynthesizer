package UMLRTSynthesizer.statespaceexploration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.ecl.parse.Ecl_EolParserRules.deleteStatement_return;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;

import UMLRTSynthesizer.ExecTracesUtil.ExecTraceModel;
import UMLRTSynthesizer.UMLRTmodelutil.UMLRTModel;
import UMLRTSynthesizer.Z3.Z3Executor;
import UMLRTSynthesizer.constraintccript.Constraints;
import UMLRTSynthesizer.constraintccript.MessageConditions;
import umlrtsyntesizer.execTraces.Edge;
import umlrtsyntesizer.execTraces.ExecTracesFactory;
import umlrtsyntesizer.execTraces.ExecTracesPackage;
import umlrtsyntesizer.execTraces.Node;
import umlrtsyntesizer.execTraces.StateStatus;
import umlrtsyntesizer.execTraces.TransStatus;
import javafx.util.Pair;



public class ComponentStateSpaceExplorer {
	Constraints comConstraints;
	SystemModel system;
	Component component;
	ExecTraceModel execTraceModel;
	List<Node> candiates;
	HashMap<Integer, Node> visited;
	Z3Executor z3Executor;
	Map <String,String> cachedSolutions; // used for dynamic programming
	private int exploredPaths;
	
	public ComponentStateSpaceExplorer(SystemModel systemmodel,Component component,Constraints comConstraints) {
		this.comConstraints=comConstraints;
		this.component=component;
		this.system=systemmodel;
		z3Executor= new Z3Executor();
		execTraceModel= new ExecTraceModel();
		execTraceModel.setMaxLevel(0);
		candiates= new ArrayList<Node>();
		visited= new HashMap<Integer, Node>();
		cachedSolutions= new LinkedHashMap<String, String>();
	}
	
	private void initializeExplration() {
		/// i need to fix fix intailization variable, right now it just read from deafult value, and the init value are ignored
		comConstraints.initComponentVariable(this.component);
		///comConstraints.initStateVars();
		Node node=ExecTraceModel.traceFactory.createNode();
		execTraceModel.getTraceRoot().getNode().add(node);
		node.setLevel(execTraceModel.getMaxLevel());
		execTraceModel.loadNodeVarFromHeap(node, component.currentHeap);
		node.setId(component.currentHeap.generateId().hashCode());
		//convert the heap to node variables list, function is done in execmodel
		candiates.add(node);
		visited.put(node.getId(), node);
	}
	public void explorerStates(int bound) {
		initializeExplration();
		//-- test this function 
		Node unsafeNode=ExecTraceModel.traceFactory.createNode();
		unsafeNode.setName("unsafeState");
		unsafeNode.setStatus(StateStatus.UN_SAFE_STATE);
		execTraceModel.addNode(unsafeNode, StateStatus.UN_SAFE_STATE);
		exploredPaths=0;
		explorerStates(candiates,unsafeNode,bound);
		System.out.println("Number of explored execution paths: "+exploredPaths);
		/*for (Edge trans:execTraceModel.getTraceRoot().getEdge()) {
			if (trans.getStatus()==TransStatus.NORMAL) {
				String actionCode=syntesizeActioneCode(trans);
				trans.setActions(actionCode);
			}
		}*/
	}
	public void syntesizeAction() {
		for (Edge trans:execTraceModel.getTraceRoot().getEdge()) {
			if (trans.getStatus()==TransStatus.NORMAL) {
				String actionCode=syntesizeActioneCode(trans);
				trans.setActions(actionCode);
			} else 
				trans.setActions("Error");
		}
	}
	

	
	public void explorerStates(List<Node> candiates,Node unsafeState,int bound) {
		List<Node> nextCandidates= new ArrayList<Node>();

		for (Node node: candiates ) {
			nextCandidates.addAll(nextStateOf(node,unsafeState,bound));
		}
		if ((nextCandidates.size()>0))
			explorerStates(nextCandidates,unsafeState,bound);
	}

	private List<Node>  nextStateOf(Node node, Node unsafeState,int bound) {
		List<Node> nextCandiates = new ArrayList<Node>();
		// apply bound
		if (node.getLevel()>bound)
			return nextCandiates;
		else 
			System.out.println("Exploration node in level " +node.getLevel());
		////
		visited.put(node.getId(), node);
		execTraceModel.unloadNodeDataToHeap(node,component.currentHeap);
		for (String msg: component.getInputMessages()) {
			//System.out.println("Explration of message"+ msg + " of component "+ component.getName());

			String zScript=component.generateInputScript(msg,false);
			/// add payload part here 
			String payloadContext="";
			Set<String> payloads=component.getMsgPayload(msg);
			if (payloads.isEmpty())
				payloads.add("None");
			
			//.nextCandiates.
			for (String payload: payloads) {
				for (MessageConditions mc: this.comConstraints.getMessageConditions(msg)) {
					payloadContext="";
					//if (mc.payloads.containsKey(payload) && (!mc.z3Pre.isEmpty())) {
					if ((!mc.z3Pre.isEmpty())) {
						payloadContext="(assert  "+mc.z3Pre + " )\n";
						//zScript=zScript+payloadContext;
					}
					exploredPaths++;
					if (z3Executor.isSatisfiable(zScript+payloadContext)) {
						if ((Boolean)z3Executor.getVarValueInModel("rep_inputRejected","Boolean")) {
							//execTraceModel.addChild(node, node, msg, TransStatus.ERROR);
							// Nope}
					    }
						else {
							Heap tempHeap=new Heap();
							z3Executor.loadSATModelVartoMap(component.nextHeap.getVarTable(),tempHeap);
							int appliedMC=(int)z3Executor.getVarValueInModel("rep_MC_ID","Integer") ;
							//
							if (node.getId()==tempHeap.generateId().hashCode()) {
								//execTraceModel.addChild(node,node, msg, TransStatus.NO_EFFECT); // return later
							}
							else if (visited.containsKey(tempHeap.generateId().hashCode())) {
									execTraceModel.addEdge(node, visited.get(tempHeap.generateId().hashCode()),msg,
												TransStatus.NORMAL,Integer.toString(appliedMC));
							} else {
									Node child=ExecTraceModel.traceFactory.createNode();
									execTraceModel.getTraceRoot().getNode().add(child);
									child.setLevel(node.getLevel()+1);
									execTraceModel.loadNodeVarFromHeap(child,tempHeap);
									child.setId(tempHeap.generateId().hashCode());
									execTraceModel.addChild(node, child, msg,TransStatus.NORMAL,Integer.toString(appliedMC));
									//if (!visited.containsKey(child.getId()))
									nextCandiates.add(child);
									visited.put(child.getId(), child);
									//System.out.println("Number of visited state is" + visited.size());
							}
						}
					}
					else { // unsafe step
						zScript=component.generateInputScriptWithoutInvariant(msg);
						if (z3Executor.isSatisfiable(zScript+payloadContext)) {
							int appliedMC=(int)z3Executor.getVarValueInModel("rep_MC_ID","Integer") ;
							execTraceModel.addEdge(node, unsafeState,msg,
								TransStatus.UNSAFE_TRANS,Integer.toString(appliedMC));
							}
						
					}
				}
			}
		}	
		//System.out.println("Exploration of message done");
		return nextCandiates;
	}
	
/// Implementation is based on backtracking
	
	public String syntesizeActioneCode(Edge edge) {
		//System.out.println("Syntesize action of Edge "+edge.getTrigger());
		Node sourceNode=edge.getSource();
		Node targetNode=edge.getDestination();
		Heap sourceHeap = new Heap();
		execTraceModel.unloadNodeDataToHeap(sourceNode, sourceHeap);
		Heap targetHeap = new Heap();
		execTraceModel.unloadNodeDataToHeap(targetNode, targetHeap);
		Set<String> diff1 = sourceHeap.diff(targetHeap);
		Set<String> possibleActions= new HashSet<String>();
		if (component.getAttributes().size()>0)
			for (String attr: component.getAttributes())
				for (String attr1: diff1)
					if (attr1.contentEquals("cur_"+attr.trim()))
						possibleActions.add("attr:"+attr.trim());
			//component.getAttributes().forEach((String attr) -> { possibleActions.add("attr:"+attr.trim());});
		if (component.getOutputMessages().size()>0)
			component.getOutputMessages().forEach((String msg) -> { possibleActions.add("msg:"+msg.trim());});
		Stack<String> solution= new Stack<String>();
		String actionCode="";
		if (btSearch(sourceHeap,targetHeap,solution,possibleActions)) {
			for (String act: solution)
				actionCode=actionCode+act+";"+System.lineSeparator();
			return actionCode;
		} else 
			return "";
	}

	private boolean btSearch(Heap sourceHeap, Heap targetHeap, Stack<String> solution, Set<String> possibleActions) {
		
		
	   if (sourceHeap.diff(targetHeap).size()==0) {
				return true;
		} 
		Set<String> diff1 = sourceHeap.diff(targetHeap);
		for (String act: possibleActions) {
			if (act.startsWith("msg:")) {
				String outmsg=act.replace("msg:", "");
				if ( !(outmsg.isEmpty()) && comConstraints.hasMessageEffects(outmsg,diff1)) {
					Component server=system.getComponentWithInput(outmsg);
					server.currentHeap.load(sourceHeap);	
					String z3OutScript=server.generateInputScript(outmsg,true);
					if (z3Executor.isSatisfiable(z3OutScript)) {
						// load sat model to tempheap
						Heap tempHeap=new Heap();
						z3Executor.loadSATModelVartoMap(server.nextHeap.getVarTable(),tempHeap);
						// check if there is a progress, the source heap and this are different
						Set<String> diff2 = tempHeap.diff(targetHeap);
						Set<String> diff3 = tempHeap.diff(sourceHeap);
							if (diff2.size()<diff1.size()) {
								String port=component.getOutMessagePort(outmsg);
								//String action="send_"+ outmsg+"_to_" + server.getName();
								String action=port+"."+outmsg+"().send()";
								//send_"+ outmsg+"_to_" + server.getName();
								cachedSolutions.put(sourceHeap.getVarTable().toString()+"--"+tempHeap.getVarTable().toString(),
										action);
								solution.push(action);
								if (btSearch(tempHeap,targetHeap,solution,possibleActions))
									return true;
								else 
									solution.pop(); // backtrack and remove the last solution which is not acceptable
							}
						//}
					}	
				}
			} else if (act.startsWith("attr:")) {
				String varName=act.replace("attr:", "cur_");
				Heap tempHeap= new Heap();
				sourceHeap.getVarTable().forEach((String key, Object value) -> {tempHeap.getVarTable().put(key, value);});
				tempHeap.setValue(varName, targetHeap.getValue(varName));
				Set<String> diff2 = tempHeap.diff(targetHeap);
					if (diff2.size()<diff1.size()) {
					//if (tempHeap.getVarTable().hashCode()!=sourceHeap.getVarTable().hashCode()) {
						String action= varName.replace("cur_", "")+ "=" + tempHeap.getValue(varName);
						cachedSolutions.put(sourceHeap.getVarTable().toString()+"--"+tempHeap.getVarTable().toString(),
								action);
						solution.push(action);
						if (btSearch(tempHeap,targetHeap,solution,possibleActions))
							return true;
						else 
							solution.pop();
					}
				//}
			}
		}
		
		return false;
	}
///// utility functions
	public void reportSizeofSyntesizedLTS() {
		long  numberOfNodes=execTraceModel.getTraceRoot().getNode().size();
		long  numberOfEdge=execTraceModel.getTraceRoot().getEdge().size();
		long  numberOfNormalEdge=0;
		long  numberOfErrorEdge=0;
		long  numberOfUnsafe=0;
		for (Edge trans:execTraceModel.getTraceRoot().getEdge()) {
			if (trans.getStatus()==TransStatus.NORMAL) {
				numberOfNormalEdge++;
			} else if (trans.getStatus()==TransStatus.ERROR) {
				numberOfErrorEdge++;
			} else if (trans.getStatus()==TransStatus.UNSAFE_TRANS) {
				numberOfUnsafe++;
			}
		}
		System.out.println("Results: Number of state is : "+ numberOfNodes +    " and  Number edges: " + 
				(numberOfNormalEdge+ numberOfErrorEdge+numberOfUnsafe));
	}
	
	

	
	
	public void saveResult(String path) {
		this.execTraceModel.save(path);
	}
	
	
/////// Merge code 
	@SuppressWarnings("restriction")
	public List<Pair<Node, Node>> getAllAtatePairs() {
		List<Pair<Node, Node>> allPairs=new ArrayList<Pair<Node, Node>>();
		HashSet<String> visitedPair=new HashSet<String>();
		Collection<Node> nodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE);
		for (Node node1: nodes) {
			if (node1.getStatus()!=StateStatus.UN_SAFE_STATE) 
				for (Node node2: nodes)
					if (node2.getStatus()!=StateStatus.UN_SAFE_STATE && node2.getId()!=node1.getId()) 
						if (! visitedPair.contains(Integer.toString(node2.getId())+Integer.toString(node1.getId()))) {
							visitedPair.add(Integer.toString(node1.getId())+Integer.toString(node2.getId()));
							Pair<Node, Node> pair= new Pair<Node, Node>(node1, node2);
							allPairs.add(pair);
						}
		}
		return allPairs;
		
	}
	
	@SuppressWarnings("restriction")
	public void minimizeLTS(int stateCount) {
		List<Pair<Node, Node>>  allPairs=getAllAtatePairs();
		HashSet<Node>  visited=new HashSet<Node>();
		System.out.println("Minimizating of LTS with paiirs count: " + allPairs.size());
		Random rand = new Random(); 
		while (allPairs.size()>0) {
			Set<Node> mergedNodes = new HashSet<Node>();
			visited.clear();
			int itemIndex=0;
			/*if (allPairs.size()>1)
				itemIndex=rand.nextInt(allPairs.size()-1);
				*/
			
			merge(allPairs.get(itemIndex).getKey(),allPairs.get(itemIndex).getValue(),mergedNodes,visited);
			allPairs.remove(itemIndex);
			List<Pair<Node, Node>>  mergedPairs=new  ArrayList<Pair<Node, Node>>();
			for (Node mergedNode:mergedNodes) {
				for (Pair<Node, Node> pair: allPairs)
					if (pair.getKey().equals(mergedNode) || pair.getValue().equals(mergedNode))
						mergedPairs.add(pair);
			}
			allPairs.removeAll(mergedPairs);
			for (Node mergedNode:mergedNodes)
				EcoreUtil.delete(mergedNode);
			int numberOfNodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE).size();
			if (numberOfNodes<=stateCount)
				break;
		}
		Collection<Node> nodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE);
		Collection<Edge> edges=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.EDGE);
		for (Edge edge1: edges) {
			if (edge1.getStatus()==TransStatus.UNSAFE_TRANS || edge1.getStatus()==TransStatus.REDUNDANT_TRANS)
				EcoreUtil.delete(edge1);
			else {}
				//edge1.setGuard(comConstraints.getCCPreOfMC(Integer.valueOf(edge1.getGuard())));
				//edge=null;
		}
		for (Node node1: nodes) {
			if (node1.getStatus()==StateStatus.UN_SAFE_STATE)
				EcoreUtil.delete(node1);
				//node1=null;
		}

		
	}
	

	private Boolean merge(Node state1, Node state2, Set<Node> mergedNodes, Set<Node> visited) {
		// TODO Auto-generated method stub
		
		if (state1.getId()==state2.getId())
			return true;
		if (visited.contains(state1) || visited.contains(state2)) {// loop
			System.out.println("Loop detected" + Integer.toString(state1.getId())+"  " +state2.getId() );
			return false;
		}
		visited.add(state1);
		visited.add(state2);
		for (Edge edge1: state1.getOutgoingEdges())
			if (edge1.getStatus()==TransStatus.UNSAFE_TRANS) {
				for (Edge edge2: state2.getOutgoingEdges())
					if (edge2.getStatus()==TransStatus.NORMAL &&  
					edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
					(edge1.getGuard().contentEquals(edge2.getGuard()))) {
						return false;
					}
			}
			else if (edge1.getStatus()==TransStatus.NORMAL){
				for (Edge edge2: state2.getOutgoingEdges())
					if (edge2.getStatus()==TransStatus.UNSAFE_TRANS &&  
					edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
					(edge1.getGuard().contentEquals(edge2.getGuard()))) {
						return false;
					}
					else if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
							(edge1.getGuard().contentEquals(edge2.getGuard())) && 
							( edge1.getActions()=="" || edge2.getActions()=="")) {
						break;
						
					}	
					else if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
							(edge1.getGuard().contentEquals(edge2.getGuard())) && 
							(! edge1.getActions().contentEquals(edge2.getActions()))) {
						  return false;
						//break;
					} else if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
							(edge1.getGuard().contentEquals(edge2.getGuard())) && 
							(edge1.getActions().contentEquals(edge2.getActions()))) {

							if ((edge1.getDestination()==state2 &&  edge2.getDestination()==state1) ||
									(edge1.getDestination()==state1) && edge1.getDestination()==state2 )
								break;
							else if (!merge(edge1.getDestination(),edge2.getDestination(), mergedNodes,visited))
								return false;
						}
				}
		for (Edge edge2: state2.getOutgoingEdges()) {
			//if ( edge2.getStatus()==TransStatus.NORMAL)
			boolean redundant=false;
			for (Edge edge1: state1.getOutgoingEdges()) {
				if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
						(edge1.getGuard().contentEquals(edge2.getGuard())) ) {
					edge2.getDestination().getIncomingEdges().remove(edge2);
					edge2.setStatus(TransStatus.REDUNDANT_TRANS);
					redundant=true;
					break;
				}
			}
			if (! redundant) {
					edge2.setSource(state1);
					state1.getOutgoingEdges().add(edge2);
			}
			
			
		}
		state2.getOutgoingEdges().clear();
		Collection<Edge> edges=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.EDGE);
		for (Edge edge:edges)
			if (edge.getDestination().getId()==state2.getId()) {
				edge.setDestination(state1);
				state1.getIncomingEdges().add(edge);
			}
		state2.getIncomingEdges().clear();
		mergedNodes.add(state2);
		return true;
	}

	@SuppressWarnings("restriction")
	public void minimizeLTS3(int stateCount) {
		//List<Pair<Node, Node>>  allPairs=getAllAtatePairs();
		//HashMap<Node,List<Node> > 
		HashSet<Node>  visited=new HashSet<Node>();
		HashSet<Node>  iterated=new HashSet<Node>();
		System.out.println("Minimizating of LTS");
		Random rand = new Random(); 
		HashSet<Node> mergedNodes=new HashSet<Node>();
		int numberOfNodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE).size();
		Collection<Node> allNode=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE);
		for (Node state1:allNode) {
			iterated.add(state1);
			for (Node state2:allNode) {
				if (!(iterated.contains(state2) || mergedNodes.contains(state2) || mergedNodes.contains(state1))) {
					visited.clear();
					HashMap<Node,List<Node> > mergedNodeOfState= new HashMap<Node, List<Node>>();
					finamergableStates(state1,state2,mergedNodeOfState,visited);
					//List<Pair<Node, Node>>  mergedPairs=new  ArrayList<Pair<Node, Node>>();
				
					for (Entry<Node, List<Node>> nodesToBeMerged:mergedNodeOfState.entrySet()) {
						for (Node node:nodesToBeMerged.getValue()) {
							Set<Node> allMergedNodesOfState=new HashSet<Node>();
							allMergedNodesOfState.add(node);
							if (mergedNodeOfState.containsKey(node)) {
								allMergedNodesOfState.addAll(mergedNodeOfState.get(node));
							}	
							for (Node nodetoMerge:allMergedNodesOfState) {
								mergeStates(nodesToBeMerged.getKey(),nodetoMerge );
								mergedNodes.add(nodetoMerge);
							}
					
						}
					}

					
					if (mergedNodes.size()+stateCount>=numberOfNodes)
						break;
					//System.out.println("Number of merged nodes sofar: " +mergedNodes.size());
					//System.out.flush();
				}
			}

		}
		for (Node mergedNode:mergedNodes)
			EcoreUtil.delete(mergedNode);
		Collection<Node> nodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE);
		Collection<Edge> edges=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.EDGE);
		for (Node node1: nodes) {
			if (node1.getStatus()==StateStatus.UN_SAFE_STATE)
				EcoreUtil.delete(node1);
				//node1=null;
		}
		for (Edge edge1: edges) {
			if (edge1.getStatus()==TransStatus.UNSAFE_TRANS || edge1.getStatus()==TransStatus.REDUNDANT_TRANS)
				EcoreUtil.delete(edge1);
			//else if (edge1.getDestination().eContainer()==null || edge1.getSource().eContainer()==null)
			//	EcoreUtil.delete(edge1);
			else 
				edge1.setGuard(comConstraints.getCCPreOfMC(Integer.valueOf(edge1.getGuard())));
				//edge=null;
		}


		
	}
	
	@SuppressWarnings("restriction")
	public void minimizeLTS2(int stateCount) {
		List<Pair<Node, Node>>  allPairs=getAllAtatePairs();
		//HashMap<Node,List<Node> > 
		HashSet<Node>  visited=new HashSet<Node>();
		System.out.println("Minimizating of LTS with pairs count: " + allPairs.size());
		Random rand = new Random(); 
		

		while (allPairs.size()>0) {
			Set<Node> mergedNodes = new HashSet<Node>();
			visited.clear();
			int itemIndex=0;
			if (allPairs.size()>1)
				itemIndex=rand.nextInt(allPairs.size()-1);
				
			HashMap<Node,List<Node> > mergedNodeOfState= new HashMap<Node, List<Node>>();

			finamergableStates(allPairs.get(itemIndex).getKey(),allPairs.get(itemIndex).getValue(),mergedNodeOfState,visited);
			allPairs.remove(itemIndex);
			List<Pair<Node, Node>>  mergedPairs=new  ArrayList<Pair<Node, Node>>();
			for (Entry<Node, List<Node>> nodesToBeMerged:mergedNodeOfState.entrySet()) {
				for (Node node:nodesToBeMerged.getValue()) {
					Set<Node> allNodes=new HashSet<Node>();
					allNodes.add(node);
					if (mergedNodeOfState.containsKey(node)) {
						allNodes.addAll(mergedNodeOfState.get(node));
						allNodes.remove(node);
					}
					for (Node nodetoMerge:allNodes) {
						mergeStates(nodesToBeMerged.getKey(),nodetoMerge );
						mergedNodes.add(nodetoMerge);
						Pair<Node,Node> pair=new Pair<Node, Node>(nodesToBeMerged.getKey(),nodetoMerge);
						//mergedPairs.add(pair);
					}
					
				}
			}
			for (Node mergedNode:mergedNodes) {
				for (Pair<Node, Node> pair: allPairs)
					if (pair.getKey().equals(mergedNode) || pair.getValue().equals(mergedNode))
						mergedPairs.add(pair);
			}
			allPairs.removeAll(mergedPairs);
			for (Node mergedNode:mergedNodes)
				EcoreUtil.delete(mergedNode);
			
			int numberOfNodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE).size();
			if (numberOfNodes<=stateCount)
			    	break;
			//System.out.println("Number of nodes sofar: " +numberOfNodes);
			//System.out.flush();

		}
		Collection<Node> nodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE);
		Collection<Edge> edges=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.EDGE);
		for (Node node1: nodes) {
			if (node1.getStatus()==StateStatus.UN_SAFE_STATE)
				EcoreUtil.delete(node1);
				//node1=null;
		}
		for (Edge edge1: edges) {
			if (edge1.getStatus()==TransStatus.UNSAFE_TRANS || edge1.getStatus()==TransStatus.REDUNDANT_TRANS)
				EcoreUtil.delete(edge1);
			//else if (edge1.getDestination().eContainer()==null || edge1.getSource().eContainer()==null)
			//	EcoreUtil.delete(edge1);
			else 
				edge1.setGuard(comConstraints.getCCPreOfMC(Integer.valueOf(edge1.getGuard())));
				//edge=null;
		}


		
	}
	private void mergeStates(Node state1, Node state2) {
		for (Edge edge2: state2.getOutgoingEdges()) {
			//if ( edge2.getStatus()==TransStatus.NORMAL)
			boolean redundant=false;
			for (Edge edge1: state1.getOutgoingEdges()) {
				if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
						(edge1.getGuard().contentEquals(edge2.getGuard())) ) {
					edge2.getDestination().getIncomingEdges().remove(edge2);
					edge2.setStatus(TransStatus.REDUNDANT_TRANS);
					redundant=true;
					break;
				}
			}
			if (! redundant) {
					edge2.setSource(state1);
					state1.getOutgoingEdges().add(edge2);
			}
			
			
		}
		state2.getOutgoingEdges().clear();
		//Collection<Edge> edges=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.EDGE);
		for (Edge edge:state2.getIncomingEdges()) {
			//if (edge.getDestination().getId()==state2.getId()) {
				edge.setDestination(state1);
				state1.getIncomingEdges().add(edge);
			}
		state2.getIncomingEdges().clear();
	}
	private Boolean finamergableStates(Node state1, Node state2,  HashMap<Node,List<Node> > mergedNodeOfState, Set<Node> visited) {
		// TODO Auto-generated method stub
		
		if (state1.getId()==state2.getId())
			return true;
		if (visited.contains(state1) &&  visited.contains(state2)) {// loop
			
			/*if ((mergedNodeOfState.containsKey(state1) && mergedNodeOfState.get(state1).contains(state2) ) ||
					(mergedNodeOfState.containsKey(state2) && mergedNodeOfState.get(state1).contains(state1) )) {
				System.out.println("Loop detected and solved" + Integer.toString(state1.getId())+"  " +state2.getId() );
				return true;
			}*/
			//else
			return true;
		}
		visited.add(state1);
		visited.add(state2);
		for (Edge edge1: state1.getOutgoingEdges())
			if (edge1.getStatus()==TransStatus.UNSAFE_TRANS) {
				for (Edge edge2: state2.getOutgoingEdges())
					if (edge2.getStatus()==TransStatus.NORMAL &&  
					edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
					(edge1.getGuard().contentEquals(edge2.getGuard()))) {
						return false;
					}
			}
			else if (edge1.getStatus()==TransStatus.NORMAL){
				for (Edge edge2: state2.getOutgoingEdges())
					if (edge2.getStatus()==TransStatus.UNSAFE_TRANS &&  
					edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
					(edge1.getGuard().contentEquals(edge2.getGuard()))) {
						return false;
					}
					else if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
							(edge1.getGuard().contentEquals(edge2.getGuard())) && 
							( edge1.getActions()=="" || edge2.getActions()=="")) {
						break;
						
					}	
					else if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
							(edge1.getGuard().contentEquals(edge2.getGuard())) && 
							(! edge1.getActions().contentEquals(edge2.getActions())) &&
							(edge1.getActions().contains("milliSecond"))
							) {
						  return false;
					}
					else if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
							(edge1.getGuard().contentEquals(edge2.getGuard())) && 
							(! edge1.getActions().contentEquals(edge2.getActions()))) {
						  return false;
						  //break;
					} else if (edge2.getTrigger().contentEquals(edge1.getTrigger()) &&
							(edge1.getGuard().contentEquals(edge2.getGuard())) && 
							(edge1.getActions().contentEquals(edge2.getActions()))) {

							if ((edge1.getDestination()==state2 &&  edge2.getDestination()==state1) ||
									(edge1.getDestination()==state1) && edge1.getDestination()==state2 )
								break;
							else if (!finamergableStates(edge1.getDestination(),edge2.getDestination(), mergedNodeOfState,visited))
								return false;
						}
				}


		if (mergedNodeOfState.containsKey(state1)){
			mergedNodeOfState.get(state1).add(state2);
		} else if (mergedNodeOfState.containsKey(state2)) {
			mergedNodeOfState.get(state2).add(state1);
		}else {
			List<Node> tempList=new ArrayList<Node>();
			tempList.add(state2);
			mergedNodeOfState.put(state1,tempList);
		}
		return true;
	}


	public void transfromLTS2UMLRT(UMLRTModel umlrtmodel,Class umlrtCapsule) {
		// transform LTS 2 UMLRT state machine
		Collection<Node> nodes=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.NODE);
		Collection<Edge> edges=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.EDGE);
		HashMap<Node, State> letState2umlState=new HashMap<Node, State>();
		// create an initial state
		StateMachine umlrtsm=umlrtmodel.createStateMachine(umlrtCapsule,umlrtCapsule.getName()+"SM");
		boolean firstTrans=true;
		int id=1;
		for (Node ltsState: nodes) {
			State umlrtState=umlrtmodel.createState(umlrtsm,"S_"+Integer.toString(id++));
			letState2umlState.put(ltsState, umlrtState);
			if (firstTrans) {
				firstTrans=false;
				Pseudostate initialState=umlrtmodel.createPseudoState(umlrtsm, "initial", PseudostateKind.INITIAL_LITERAL);
				umlrtmodel.createTransition(umlrtsm, "init_trans",  initialState,umlrtState);
			}
		}
		for (Edge ltsEdge: edges) {
			Transition umlrtTrans=umlrtmodel.createTransition(umlrtsm, ltsEdge.getTrigger()+ "[" + ltsEdge.getGuard()+"]"+ "\\" + ltsEdge.getActions(),
					letState2umlState.get(ltsEdge.getSource()), letState2umlState.get(ltsEdge.getDestination()));
			umlrtmodel.setAction(umlrtTrans, ltsEdge.getActions());
			if (ltsEdge.getGuard()!="")
				umlrtmodel.setGuard(umlrtTrans, "return " +ltsEdge.getGuard() + ";");
			umlrtmodel.setTrigger(umlrtCapsule,umlrtTrans, ltsEdge.getTrigger());
			
		}
		
	}

	public void fixDigitalWathActions() {
		Collection<Edge> edges=EcoreUtil.getObjectsByType(execTraceModel.getTraceRoot().eContents(), ExecTracesPackage.Literals.EDGE);

		for (Edge edge1: edges) {
			if (edge1.getActions().startsWith("milliSecond=") && ! edge1.getActions().contains("stopwatchCounter") )
				edge1.setActions("milliSecond=milliSecond=+1");
			//else if (edge1.getDestination().eContainer()==null || edge1.getSource().eContainer()==null)
			//	EcoreUtil.delete(edge1);
			else if (edge1.getActions().startsWith("milliSecond=") &&  edge1.getActions().contains("stopwatchCounter") )
				edge1.setActions("milliSecond=milliSecond=+1"+System.lineSeparator()+"stopwatchCounter=stopwatchCounter+1");
				//edge=null;
		}
		
	}
	
	


}
