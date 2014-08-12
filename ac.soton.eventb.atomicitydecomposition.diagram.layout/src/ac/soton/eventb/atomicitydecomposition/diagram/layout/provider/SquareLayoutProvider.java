/******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

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

import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
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
				
				
//				int i = 0;
//				System.out.println(totalLevels);
//				for(ILayoutNode lnode : level2ListNodes.get(totalLevels)){
//					Bounds bounds = (Bounds)lnode.getNode().getLayoutConstraint();
//					bounds.setX(i * gridWidth);
//					bounds.setY(totalLevels * gridHeight);
//					lnode.getNode().setLayoutConstraint(bounds);
//					
//					EObject eContainer = lnode.getNode().getElement();
//					if(eContainer != null && ancestorChildrenBorders.keySet().contains(eContainer)){
//						ArrayList<Integer> lp = ancestorChildrenBorders.get(eContainer);
//						if(lp.get(0) > i * gridWidth)
//							lp.set(0, i * gridWidth);
//						if(lp.get(1) < (i + 1) * gridWidth )
//							lp.set(1, (i + 1) * gridWidth);
//					}
//					else if(eContainer != null){
//						ArrayList<Integer> newList = new ArrayList<Integer>();
//						newList.add(i * gridWidth);
//						newList.add( (i+1) * gridWidth);
//						
//					}
//					i++;
//				}
//				
//				
//				for(Integer it = totalLevels-1 ; it >= 2 ; it--){
//					i = 0;
//		
//					for(ILayoutNode iln : level2ListNodes.get(it)){
//						i++;
//						Bounds bounds = (Bounds)iln.getNode().getLayoutConstraint();
//						ArrayList<Integer> xpos = ancestorChildrenBorders.get(iln.getNode().getElement());
//						//bounds.setX( xpos.get(0) + (xpos.get(1) - xpos.get(0))/2  );
//						bounds.setX( (-1)*( it - i )* gridWidth  );
//						bounds.setY((it  * gridHeight));
//						iln.getNode().setLayoutConstraint(bounds);
//						System.out.println(it);
//						EObject eContainer = iln.getNode().getElement();
//						
//						if(eContainer != null && ancestorChildrenBorders.keySet().contains(eContainer)){
//							ArrayList<Integer> lp = ancestorChildrenBorders.get(eContainer);
//							if(lp.get(0) > i * gridWidth)
//								lp.set(0, i * gridWidth);
//							if(lp.get(1) < (i + 1) * gridWidth )
//								lp.set(1, (i + 1) * gridWidth);
//						}
//						else if(eContainer != null){
//							ArrayList<Integer> newList = new ArrayList<Integer>();
//							newList.add(i * gridWidth);
//							newList.add( (i+1) * gridWidth);
//							
//						}
//						
//					}
//						
//				}
//				
				
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
					bounds.setX( (int) Math.round(Xoffset + (object2offset.get(obj))*gridWidth) + 15);
				else
					bounds.setX( (int) Math.round(Xoffset + (object2offset.get(obj))*gridWidth));
				//bounds.setX( (int) Math.round(Xoffset + (object2offset.get(obj))*gridWidth));
				//System.out.println(object2offset.get(obj));
				bounds.setY( (int) Math.round(level * gridHeight));
				ln.getNode().setLayoutConstraint(bounds);
				if(obj instanceof And){// FlowDiagram && ((Leaf)obj.eContainer()).getName().equals("b")){
					System.out.println();
					System.out.println("GridWidth ->" + gridWidth);
					
				}
				
				
				for(EObject eobj : obj.eContents()){
					if(eobj instanceof TypedParameterExpression)
						continue;
					positionSubtree(eobj, Xoffset, level + 1);
					if(obj instanceof And){//FlowDiagram && ((Leaf)obj.eContainer()).getName().equals("b")){
						System.out.println(Xoffset);
					
					}
					
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
