package ac.soton.eventb.atomicitydecomposition.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;
import ac.soton.eventb.atomicitydecomposition.diagram.part.Messages;

/**
 * @generated
 */
public class AtomicitydecompositionModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof FlowDiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(11);
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.And_2002);
			types.add(AtomicitydecompositionElementTypes.Loop_2003);
			types.add(AtomicitydecompositionElementTypes.All_2004);
			types.add(AtomicitydecompositionElementTypes.Some_2005);
			types.add(AtomicitydecompositionElementTypes.Or_2006);
			types.add(AtomicitydecompositionElementTypes.Xor_2007);
			types.add(AtomicitydecompositionElementTypes.One_2008);
			types.add(AtomicitydecompositionElementTypes.Par_2009);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_2011);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof LeafEditPart) {
			return ((LeafEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AndEditPart) {
			return ((AndEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoopEditPart) {
			return ((LoopEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AllEditPart) {
			return ((AllEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SomeEditPart) {
			return ((SomeEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof OrEditPart) {
			return ((OrEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof XorEditPart) {
			return ((XorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof OneEditPart) {
			return ((OneEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ParEditPart) {
			return ((ParEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Leaf2EditPart) {
			return ((Leaf2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FlowDiagram2EditPart) {
			return ((FlowDiagram2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof LeafEditPart) {
			return ((LeafEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AndEditPart) {
			return ((AndEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LoopEditPart) {
			return ((LoopEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AllEditPart) {
			return ((AllEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SomeEditPart) {
			return ((SomeEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof OrEditPart) {
			return ((OrEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof XorEditPart) {
			return ((XorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof OneEditPart) {
			return ((OneEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ParEditPart) {
			return ((ParEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			return ((Leaf2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FlowDiagram2EditPart) {
			return ((FlowDiagram2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof LeafEditPart) {
			return ((LeafEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AndEditPart) {
			return ((AndEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoopEditPart) {
			return ((LoopEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AllEditPart) {
			return ((AllEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SomeEditPart) {
			return ((SomeEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof OrEditPart) {
			return ((OrEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof XorEditPart) {
			return ((XorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof OneEditPart) {
			return ((OneEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ParEditPart) {
			return ((ParEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Leaf2EditPart) {
			return ((Leaf2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FlowDiagram2EditPart) {
			return ((FlowDiagram2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof LeafEditPart) {
			return ((LeafEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AndEditPart) {
			return ((AndEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LoopEditPart) {
			return ((LoopEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AllEditPart) {
			return ((AllEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SomeEditPart) {
			return ((SomeEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof OrEditPart) {
			return ((OrEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof XorEditPart) {
			return ((XorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof OneEditPart) {
			return ((OneEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ParEditPart) {
			return ((ParEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			return ((Leaf2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FlowDiagram2EditPart) {
			return ((FlowDiagram2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof LeafEditPart) {
			return ((LeafEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AndEditPart) {
			return ((AndEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoopEditPart) {
			return ((LoopEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AllEditPart) {
			return ((AllEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SomeEditPart) {
			return ((SomeEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof OrEditPart) {
			return ((OrEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof XorEditPart) {
			return ((XorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof OneEditPart) {
			return ((OneEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ParEditPart) {
			return ((ParEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Leaf2EditPart) {
			return ((Leaf2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FlowDiagram2EditPart) {
			return ((FlowDiagram2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				AtomicitydecompositionDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.AtomicitydecompositionModelingAssistantProviderMessage);
		dialog.setTitle(Messages.AtomicitydecompositionModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
