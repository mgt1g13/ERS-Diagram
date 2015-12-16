package ac.soton.eventb.atomicitydecomposition.diagram.sheet.custom;



	import org.eclipse.jface.viewers.IFilter;
	import org.eventb.emf.core.EventBNamed;

	import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
	import ac.soton.eventb.emf.diagrams.sheet.NamePropertySection;
	import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

	/**
	 * Name property section for EventBNamed.
	 * 
	 *
	 */
	public class FlowdiagramNamePropertySection extends NamePropertySection {

		/**
		 * Element Filter for this property section.
		 */
		public static final class Filter implements IFilter {
			@Override
			public boolean select(Object toTest) {
				return DiagramUtils.unwrap(toTest) instanceof EventBNamed;
			}
		}
		
		@Override
		public boolean isReadOnly() {
			return false;//return super.isReadOnly()|| (eObject instanceof FlowDiagram && ((FlowDiagram)eObject).getRefine() !=null);
		}
	}

