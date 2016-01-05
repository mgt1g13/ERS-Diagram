package ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.custom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eventb.emf.core.machine.Machine;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorUtil;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionNewDiagramFileWizard;
import ac.soton.eventb.atomicitydecomposition.diagram.part.Messages;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
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
		
		if(leaf.getAdapter(Leaf.class) == null)
			return;
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
				//for(TypedParameterExpression tp : ((FlowDiagram) temp).getParameters()){
				for(int i = ((FlowDiagram) temp).getParameters().size() -1; i >=0; i-- ){ //changed by Dana
					TypedParameterExpression tp = ((FlowDiagram) temp).getParameters().get(i);
					if(!retNames.contains(tp.getName())){
						TypedParameterExpression newTp = AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression();
						newTp.setName(tp.getName());
						newTp.setInputExpression(tp.getInputExpression());
						newTp.setType(tp.getType());
						ret.add(0, newTp);//changed by Dana at 0 index
						retNames.add(newTp.getName());
					}
					
				}
			}
				//------------------------------------------------
				//test to get copy the replicator parameters
				else if(temp instanceof All){
					TypedParameterExpression tp = ((All) temp).getNewParameter();
						if(!retNames.contains(tp.getName())){
							TypedParameterExpression newTp = AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression();
							newTp.setName(tp.getName());
							newTp.setInputExpression(tp.getInputExpression());
							newTp.setType(tp.getType());
							ret.add(newTp);
							retNames.add(newTp.getName());
						
						}
				}
			
				else if(temp instanceof Some){
					TypedParameterExpression tp = ((Some) temp).getNewParameter();
						if(!retNames.contains(tp.getName())){
							TypedParameterExpression newTp = AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression();
							newTp.setName(tp.getName());
							newTp.setInputExpression(tp.getInputExpression());
							newTp.setType(tp.getType());
							ret.add(newTp);
							retNames.add(newTp.getName());
						
						}
				}
				else if(temp instanceof One){
					TypedParameterExpression tp = ((One) temp).getNewParameter();
						if(!retNames.contains(tp.getName())){
							TypedParameterExpression newTp = AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression();
							newTp.setName(tp.getName());
							newTp.setInputExpression(tp.getInputExpression());
							newTp.setType(tp.getType());
							ret.add(newTp);
							retNames.add(newTp.getName());
						
						}
				}
				else if(temp instanceof Par){
					TypedParameterExpression tp = ((Par) temp).getNewParameter();
						if(!retNames.contains(tp.getName())){
							TypedParameterExpression newTp = AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression();
							newTp.setName(tp.getName());
							newTp.setInputExpression(tp.getInputExpression());
							newTp.setType(tp.getType());
							ret.add(newTp);
							retNames.add(newTp.getName());
						
						}
				}
			//------------------------------------------------
			temp = temp.eContainer();
		}

		return ret;
	}
}
