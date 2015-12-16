package ac.soton.eventb.atomicitydecomposition.diagram.sheet.custom;


	import org.eclipse.emf.ecore.EStructuralFeature;
	
import org.eclipse.jface.viewers.IFilter;

	import ac.soton.eventb.emf.diagrams.sheet.AbstractBooleanEnumerationPropertySection;
	import org.eclipse.jface.viewers.IFilter;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;
	/**
	 * Refines property section for State.
	 * 
	 *
	 */
	public class FlowDiagramSWPropertySection  extends AbstractBooleanEnumerationPropertySection {

		@Override
		protected EStructuralFeature getFeature() {
			return AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__SW;
		}

		@Override
		protected String[] getEnumerationFeatureValues() {
			
			String[] values = new String[2];
			
			values[0] = "true";
			values[1]="false";
			return values;
		}

		@Override
		protected String getFeatureAsText() {
			if(((FlowDiagram) eObject).isSw())
				return "true";
			else
				return "false";
		}

		@Override
		protected String getLabelText() {
			return "SW:";
		}

		/**
		 * Filter for properties of flowdiagram element.
		 */
		public static final class FlowDiagramFilter implements IFilter {
			@Override
			public boolean select(Object toTest) {
				return DiagramUtils.unwrap(toTest) instanceof FlowDiagram;
			}
		}
		
		
	}
	
