package ac.soton.eventb.atomicitydecomposition.diagram.sheet.custom;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.EventBEventGroup;
import ac.soton.eventb.emf.diagrams.sheet.ParametersPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamed;

import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;

public class OneParameterExpression  extends ParametersPropertySection{

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof One;
		}
	}
	
	@Override
	protected EReference getFeature() {
		return AtomicitydecompositionPackage.eINSTANCE.getOne_NewParameter();
	}
	
	@Override
	protected EStructuralFeature getFeatureForCol(final int col) {
		switch (col) {
		case 0 : return CorePackage.eINSTANCE.getEventBNamed_Name();
		case 1 : return CoreextensionPackage.eINSTANCE.getType_Type();
		//case 1 : return AtomicitydecompositionPackage.eINSTANCE.getAll_NewParameter();
		case 2 : return AtomicitydecompositionPackage.eINSTANCE.getTypedParameterExpression_InputExpression();
		case 3 : return CorePackage.eINSTANCE.getEventBCommented_Comment();
		default : return null;
		}
		
	}
	
	@Override
	protected boolean isRodinKeyboard(final int col) {
		return col==1 ? true : false;
	}
	
	@Override
	protected boolean isMulti(final int col){
		return col==3 ? true : false;
	}
	
	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 150;	//name field
		case 1 : return 150;	//name field
		case 2 : return 150;	//name field
		case 3 : return 250;	//comment field
		default : return -1;	//unknown
		}
	}
}

