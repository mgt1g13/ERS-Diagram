package ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.custom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;

/**
 * @generated NOT
 */
public class LeafRefineHandler implements
		IObjectActionDelegate {

	private IWorkbenchPart targetPart;

	/**
	 * @generated NOT
	 */
	private Leaf selectedLeaf;

	/**
	 * @generated NOT
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	/**
	 * @generated NOT
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false
				|| selection.isEmpty()) {
			return;
		}
		EditPart leaf = (EditPart) ((IStructuredSelection) selection)
				.getFirstElement();
		
		if(leaf.getAdapter(Leaf.class) == null){
			return;
		}
		selectedLeaf = (Leaf) leaf.getAdapter(Leaf.class);
		
		action.setEnabled(true);
	}

	/**
	 * @generated NOT
	 */
	private Shell getShell() {
		return targetPart.getSite().getShell();
	}

	/**
	 * @generated NOT
	 */
	public void run(IAction action) {
	
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selectedLeaf);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			public void doExecute() {
				FlowDiagram newFlowDiagram = AtomicitydecompositionFactory.eINSTANCE.createFlowDiagram();
				System.out.println(newFlowDiagram.getParameters());			
				newFlowDiagram.getParameters().addAll(getAbstractParametersCopies());
				
				try {
					selectedLeaf.getDecompose().add(newFlowDiagram);
					selectedLeaf.eResource().save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		});
	}
	private List<TypedParameterExpression> getAbstractParametersCopies(){
		List<TypedParameterExpression> ret = new ArrayList<TypedParameterExpression>();
		List<String> retNames = new ArrayList<String>();
		EObject temp = selectedLeaf.eContainer();
		while(temp != null && !(temp instanceof Machine)){
			if(temp instanceof FlowDiagram){
				for(TypedParameterExpression tp : ((FlowDiagram) temp).getParameters()){
					if(!retNames.contains(tp.getName())){
						TypedParameterExpression newTp = AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression();
						newTp.setName(tp.getName());
						newTp.setInputExpression(tp.getInputExpression());
						newTp.setType(tp.getType());
						ret.add(newTp);
						retNames.add(newTp.getName());
					}
				}
			}
			temp = temp.eContainer();
		}

		return ret;
	}
}
