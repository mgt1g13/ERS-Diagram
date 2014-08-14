package ac.soton.eventb.atomicitydecomposition.diagram.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;

public class Utils {

	private Utils() {
		//DO NOT INSTANTIATE
	}

	/**
	 * Returns string representation of a sequence of strings, separated by separator.
	 * @param inStr
	 * @param separator
	 * @return
	 */
	public static String toString(List<String> inStr, String separator){
		String ret = "";
		for(int i = 0 ; i < inStr.size() ; i++){
			ret += inStr.get(i);
			if (i != inStr.size() -1 ) ret += separator;
		}
		return ret;
	}
	
	/**
	 * Get a list of names of the parameters in the 
	 * 
	 * @param object
	 * @return
	 */
	private static List<String> parentParameters(EObject object){
		List<String> ret = new ArrayList<String>();
		if(object == null)
			return ret;
		
		if(object instanceof Leaf){
			ret.addAll(parentParameters(object.eContainer()));
			return ret;
			
		}
		if(object instanceof FlowDiagram){
			for(TypedParameterExpression tp : ((FlowDiagram) object).getParameters()){
				ret.add(tp.getName());
			}
			return ret;
		}
		else if(object instanceof All){
			ret.addAll(parentParameters(object.eContainer()));
			if(((All) object).getNewParameter() != null)
				ret.add(((All) object).getNewParameter().getName());
			return ret;
		}
		else if(object instanceof Some){
			ret.addAll(parentParameters(object.eContainer()));
			if(((Some) object).getNewParameter() != null)
				ret.add(((Some) object).getNewParameter().getName());
			return ret;
		}
		else if(object instanceof One){
			ret.addAll(parentParameters(object.eContainer()));
			if(((One) object).getNewParameter() != null)
				ret.add(((One) object).getNewParameter().getName());
			return ret;
		}
		else if(object instanceof Par){
			ret.addAll(parentParameters(object.eContainer()));
			if(((Par) object).getNewParameter() != null)
				ret.add(((Par) object).getNewParameter().getName());
			return ret;
		}
		
		else{ 
			ret.addAll(parentParameters(object.eContainer()));
			return ret;
		}
	}
	
	public static String parenthesize(String s){
		return "(" + s + ")";
	}
	
	/**
	 * Generate parameters String
	 * 
	 * @return
	 */
	public static String mountParametersString(Child ch){
		List<String> parameters = new ArrayList<String>();
	
	
		if(ch instanceof Leaf){
			parameters.addAll(Utils.parentParameters(ch.eContainer()));
			for(FlowDiagram flow : ((Leaf) ch).getDecompose()){
				for(TypedParameterExpression tp : flow.getParameters()){
					if(parameters.contains(tp.getName())) continue; //In case the parameter was carried forward
					if(tp.getInputExpression().isEmpty())
						parameters.add(tp.getName() + ": " + tp.getType());
					else
						parameters.add(tp.getName() + ": " + tp.getInputExpression());
				}
			}
		}
		else if (ch instanceof All){
			All all = (All) ch;
			if(all.getNewParameter().getInputExpression().isEmpty())
				parameters.add(all.getNewParameter().getName() + ": " + all.getNewParameter().getType());
			else
				parameters.add(all.getNewParameter().getName() + ": " + all.getNewParameter().getInputExpression());
		}
		else if (ch instanceof Some){
			Some some = (Some) ch;
			if(some.getNewParameter().getInputExpression().isEmpty())
				parameters.add(some.getNewParameter().getName() + ": " + some.getNewParameter().getType());
			else
				parameters.add(some.getNewParameter().getName() + ": " + some.getNewParameter().getInputExpression());
		}
		else if (ch instanceof One){
			One one = (One) ch;
			if(one.getNewParameter().getInputExpression().isEmpty())
				parameters.add(one.getNewParameter().getName() + ": " + one.getNewParameter().getType());
			else
				parameters.add(one.getNewParameter().getName() + ": " + one.getNewParameter().getInputExpression());
		}
		else if (ch instanceof Par){
			Par par = (Par) ch;
			if(par.getNewParameter().getInputExpression().isEmpty())
				parameters.add(par.getNewParameter().getName() + ": " + par.getNewParameter().getType());
			else
				parameters.add(par.getNewParameter().getName() + ": " + par.getNewParameter().getInputExpression());
		}
		
		
		String ret = Utils.toString(parameters, ", ");
		if(!ret.equals(""))
			ret = Utils.parenthesize(ret);
		return ret;
	}
	

}
