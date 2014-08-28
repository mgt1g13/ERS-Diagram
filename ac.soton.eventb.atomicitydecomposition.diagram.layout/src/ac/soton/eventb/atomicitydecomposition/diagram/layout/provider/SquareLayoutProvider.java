

package ac.soton.eventb.atomicitydecomposition.diagram.layout.provider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.providers.TopDownProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNode;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;

/**
 */
public class SquareLayoutProvider extends TopDownProvider{

	public static String SQUARE_LAYOUT = "Square"; //$NON-NLS-1$
	public static int i = 1; //$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */  
	public boolean provides(IOperation operation) {
		//return true;
		i ++;
		// check to make sure all node are contained in a diagram
		if (operation instanceof ILayoutNodeOperation) {
			Iterator nodes = ((ILayoutNodeOperation)operation).getLayoutNodes().listIterator();
			
			if (nodes.hasNext()) { 
				Node node = ((ILayoutNode)nodes.next()).getNode();
				EObject container = node.getElement().eContainer(); 
				
				if (container instanceof FlowDiagram) //&& i <= 2)
					return true;
				else
					return false;
			} 
		}
		else {
			return false;
		}
		
		// Provide for SQUARE_LAYOUT hint.  
		// Note: To override the default layout which is invoked from the Arrange menu
		// then the provider can compare against ILayoutNodeProvider.DEFAULT_LAYOUT.
		IAdaptable layoutHint = ((ILayoutNodeOperation) operation).getLayoutHint();
		String layoutType = (String) layoutHint.getAdapter(String.class);
		//return DEFAULT_LAYOUT.equals(layoutType);
		System.out.println(SQUARE_LAYOUT.equals(layoutType));
		
		
		
		if(i > 2)
			return false;
		return SQUARE_LAYOUT.equals(layoutType);	
	}
	
	public Runnable layoutLayoutNodes(List layoutNodes,
			boolean offsetFromBoundingBox, IAdaptable layoutHint) {
		
		final List lnodes = layoutNodes;
	
				
		return new Runnable() {
		
			private HashMap<EObject, ILayoutNode> object2node;
			//private HashMap<EObject, Float> object2offset;
			private EObject topLevelElement;
			private int spaceX = 5;
			private int spaceY = 45;
			
			public void run() {
				object2node = new HashMap<EObject, ILayoutNode>();
				//object2offset = new HashMap<EObject, Float>();
				int topLevel = -1;
				ListIterator li = lnodes.listIterator();
				while (li.hasNext()) {
					ILayoutNode lnode = (ILayoutNode)li.next();
					if(lnode.getNode().getElement().eContainer() == null)
						continue;
					object2node.put(lnode.getNode().getElement(), lnode);
					
					int level = findLevel(lnode.getNode().getElement());
					if(level < topLevel || topLevel == -1){
						topLevel = level;
						topLevelElement = lnode.getNode().getElement().eContainer();
					}					
				}
				positionTree(topLevelElement);
				
			}
			
			private int findLevel(EObject eobj){
				if(eobj.eContainer().eContainer() == null || eobj.eContainer().eContainer() instanceof Machine)
					return 1;
				else
					return findLevel(eobj.eContainer()) + 1;
			}
						
			private void positionTree(EObject obj){
				Float offset = (float)30;
				for(EObject eobj : obj.eContents()){
					if(object2node.get(eobj) == null)
						continue;
					offset = positionSubtree(eobj, offset, (float) 0.5);
					
				}
			}
			
			
			private Float positionSubtree(EObject obj, Float Xoffset, Float level){
				ILayoutNode ln = object2node.get(obj);
				
				Float initialXOffset = Xoffset;
				
				if(obj instanceof Leaf && obj.eContainer() instanceof FlowDiagram &&
						!(obj.eContainer().equals(topLevelElement)))
					level += 1;
				
				for(EObject eobj : obj.eContents()){
					if(eobj instanceof TypedParameterExpression)
						continue;
					Xoffset = positionSubtree(eobj, Xoffset, level + 1);
				}
				
				Bounds bounds = (Bounds)ln.getNode().getLayoutConstraint();
				if(obj.eContents().size() == 0 || (obj.eContents().size() == 1 && obj.eContents().size() == 0))
					bounds.setX( (int) Math.round(initialXOffset)) ;
				else
					bounds.setX(  (int) (Math.round(initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(obj).getWidth()/2)) > initialXOffset ? (int) Math.round(initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(obj).getWidth()/2)) : initialXOffset) ) ;


				bounds.setY( (int) Math.round(level * spaceY));
				ln.getNode().setLayoutConstraint(bounds);

				if(obj.eContents().size() == 0  || Math.round(initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(obj).getWidth()/2)) < initialXOffset )
					return initialXOffset + object2node.get(obj).getWidth() + spaceX;
				
				Float abstractEnd = initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(obj).getWidth()/2) 
						+ object2node.get(obj).getWidth() + spaceX;
				Float subtreeEnd = Xoffset;
				
				return abstractEnd > subtreeEnd ? abstractEnd : subtreeEnd;
				
			}
					
		};
	}
}

	