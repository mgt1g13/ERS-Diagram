

package ac.soton.eventb.atomicitydecomposition.diagram.layout.provider;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNode;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;

/**
 */
public class SquareLayoutProvider extends org.eclipse.gmf.runtime.diagram.ui.providers.TopDownProvider{

	public static String SQUARE_LAYOUT = "Square"; //$NON-NLS-1$
	public static int i = 1; //$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */  
	public boolean provides(IOperation operation) {
		return true;
////		i ++;
////		// check to make sure all node are contained in a diagram
////		if (operation instanceof ILayoutNodeOperation) {
////			Iterator nodes = ((ILayoutNodeOperation)operation).getLayoutNodes().listIterator();
////			
////			if (nodes.hasNext()) { 
////				Node node = ((ILayoutNode)nodes.next()).getNode();
////				EObject container = node.getElement().eContainer(); 
////				
////				if (container instanceof FlowDiagram && i <= 2)
////					return true;
////				else
////					return false;
////			} 
////		}
////		else {
////			return false;
////		}
////		
////		// Provide for SQUARE_LAYOUT hint.  
////		// Note: To override the default layout which is invoked from the Arrange menu
////		// then the provider can compare against ILayoutNodeProvider.DEFAULT_LAYOUT.
////		IAdaptable layoutHint = ((ILayoutNodeOperation) operation).getLayoutHint();
////		String layoutType = (String) layoutHint.getAdapter(String.class);
////		//return DEFAULT_LAYOUT.equals(layoutType);
////		System.out.println(SQUARE_LAYOUT.equals(layoutType));
////		
////		
////		
////		if(i > 2)
////			return false;
////		return SQUARE_LAYOUT.equals(layoutType);	
	}
	
	public Runnable layoutLayoutNodes(List layoutNodes,
			boolean offsetFromBoundingBox, IAdaptable layoutHint) {
		
		final List lnodes = layoutNodes;
	
				
		return new Runnable() {
		
			private HashMap<EObject, ILayoutNode> object2node;
			private HashMap<EObject, Float> object2offset;
			private EObject topLevelElement;
			private int gridWidth = 0;
			private int gridHeight = 0;
			
			public void run() {
				final int rowsize = (int)Math.round(Math.sqrt(lnodes.size()));
				object2node = new HashMap<EObject, ILayoutNode>();
				object2offset = new HashMap<EObject, Float>();
				ListIterator li = lnodes.listIterator();
				while (li.hasNext()) {
					ILayoutNode lnode = (ILayoutNode)li.next();
					if(lnode.getNode().getElement().eContainer() == null)
						continue;
					object2node.put(lnode.getNode().getElement(), lnode);
					object2offset.put(lnode.getNode().getElement(), (getTreeWidth(lnode.getNode().getElement()) + 1)/2);
					if(lnode.getNode().getElement().eContainer().eContainer() == null || lnode.getNode().getElement().eContainer().eContainer() instanceof Machine)
						topLevelElement = lnode.getNode().getElement().eContainer();
					
					if (lnode.getWidth() > gridWidth)
						gridWidth = lnode.getWidth();
					if (lnode.getHeight() > gridHeight)
						gridHeight = lnode.getHeight();
				}
				// add a small buffer in HiMetric units
				gridWidth += 15;
				gridHeight += 15;
				positionTree(topLevelElement);
				
			}
						
			private void positionTree(EObject obj){
				Float offset = (float)1;
				for(EObject eobj : obj.eContents()){		
					positionSubtree(eobj, offset, (float) 0.5);
					offset += (object2offset.get(eobj) * 2)*gridWidth;
				}
			}
			
			
			private void positionSubtree(EObject obj, Float Xoffset, Float level){
				ILayoutNode ln = object2node.get(obj);
				if(obj instanceof TypedParameterExpression)
					return;
				
				Bounds bounds = (Bounds)ln.getNode().getLayoutConstraint();
				if(obj instanceof FlowDiagram)
					bounds.setX( (int) Math.round(Xoffset + (object2offset.get(obj))*gridWidth) + object2node.get(obj.eContainer()).getWidth()/2 ) ;
				else
					bounds.setX( (int) Math.round(Xoffset + (object2offset.get(obj))*gridWidth));
				bounds.setY( (int) Math.round(level * gridHeight));
				ln.getNode().setLayoutConstraint(bounds);
				
				for(EObject eobj : obj.eContents()){
					if(eobj instanceof TypedParameterExpression)
						continue;
					positionSubtree(eobj, Xoffset, level + 1);
					if(object2offset.get(eobj) - 1 > -0.00001  && object2offset.get(eobj) - 1 < 0.00001 ){
						Xoffset += (object2offset.get(eobj))*gridWidth;
					}
					else
						Xoffset = Xoffset + (object2offset.get(eobj))*gridWidth*2 - gridWidth;
				}
				
				
			}
			
			private Float getTreeWidth(EObject obj){
				if(obj.eContents().size() == 0)
					return (float) 1;
				else{
					Float ret = (float) 0;
					for(EObject child : obj.eContents()){
						if(child instanceof TypedParameterExpression) continue;
						ret += getTreeWidth(child);
					}
					return ret;
				}
					
			}
			
		};
	}
}
