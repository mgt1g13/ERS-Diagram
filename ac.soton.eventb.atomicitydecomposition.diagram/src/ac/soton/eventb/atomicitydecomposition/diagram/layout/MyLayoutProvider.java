package ac.soton.eventb.atomicitydecomposition.diagram.layout;

import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.AbstractLayoutNodeProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNode;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;

public class MyLayoutProvider extends AbstractLayoutNodeProvider {

    public static final String LAYOUT_TYPE = "myLayoutType";
    
    public boolean provides(IOperation operation) {
        View cview = getContainer(operation);
        if (cview == null)
            return false;

        IAdaptable layoutHint = ((ILayoutNodeOperation) operation).getLayoutHint();
        String layoutType = (String) layoutHint.getAdapter(String.class);
        return LAYOUT_TYPE.equals(layoutType);
    }
    
    /**
     * Layout nodes in a pyramid shape
     *    o
     *   o o
     *  o o o
     * Last row may not be completely filled, depending on number
     * of nodes to arrange.
     */
    public Runnable layoutLayoutNodes(final List layoutNodes,
            final boolean offsetFromBoundingBox, final IAdaptable layoutHint) {

        return new Runnable() {
            public void run() {
                // calculate the grid size
                int gridWidth = 0;
                int gridHeight = 0;
                ListIterator li = layoutNodes.listIterator();
                while (li.hasNext()) {
                    ILayoutNode lnode = (ILayoutNode)li.next();
                    if (lnode.getWidth() > gridWidth)
                        gridWidth = lnode.getWidth();
                    if (lnode.getHeight() > gridHeight)
                        gridHeight = lnode.getHeight();
                }
                
                // add a small buffer in HiMetric units
                gridWidth += 100;
                gridHeight += 100;
                
                // determine number of rows
                int rowsize = (int)Math.floor(Math.sqrt(layoutNodes.size() * 2));
                
                int boxXOffset = 1000;
                int boxYOffset = 2000;
                
                // set node bounds
                li = layoutNodes.listIterator();
                for (int i = 1; i <= rowsize; ++i) {
                    int xoffset = (rowsize - i) * gridWidth + boxYOffset;
                    int yoffset = (i - 1) * gridHeight + boxXOffset;
                    for (int j = 1; j <= i && li.hasNext(); ++j, xoffset += (gridWidth * 2)) {
                        ILayoutNode lnode = (ILayoutNode)li.next();
                        Bounds bounds = (Bounds)lnode.getNode().getLayoutConstraint();
                        bounds.setX(xoffset);
                        bounds.setY(yoffset);
                        lnode.getNode().setLayoutConstraint(bounds);
                    }
                }
            }
        };
    }
}