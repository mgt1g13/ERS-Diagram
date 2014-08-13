package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.Leaf2CanonicalEditPolicy;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.Leaf2ItemSemanticEditPolicy;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class Leaf2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2010;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public Leaf2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Leaf2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new Leaf2CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new LeafFigure();
	}

	/**
	 * @generated
	 */
	public LeafFigure getPrimaryShape() {
		return (LeafFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LeafName2EditPart) {
			((LeafName2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLeafLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LeafName2EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(AtomicitydecompositionVisualIDRegistry
				.getType(LeafName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(AtomicitydecompositionElementTypes.MultiFlowDecompose_4013);
		types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof FlowDiagram2EditPart) {
			types.add(AtomicitydecompositionElementTypes.MultiFlowDecompose_4013);
		}
		if (targetEditPart instanceof LeafEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof AndEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof LoopEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof AllEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof SomeEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof OrEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof XorEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof OneEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof ParEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		if (targetEditPart instanceof ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == AtomicitydecompositionElementTypes.MultiFlowDecompose_4013) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_2011);
		} else if (relationshipType == AtomicitydecompositionElementTypes.FlowDiagram_4015) {
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
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(11);
		types.add(AtomicitydecompositionElementTypes.AndAndLink_4002);
		types.add(AtomicitydecompositionElementTypes.LoopLoopLink_4003);
		types.add(AtomicitydecompositionElementTypes.AllAllLink_4004);
		types.add(AtomicitydecompositionElementTypes.SomeSomeLink_4006);
		types.add(AtomicitydecompositionElementTypes.OrOrLink_4008);
		types.add(AtomicitydecompositionElementTypes.XorXorLink_4009);
		types.add(AtomicitydecompositionElementTypes.OneOneLink_4010);
		types.add(AtomicitydecompositionElementTypes.ParParLink_4012);
		types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		types.add(AtomicitydecompositionElementTypes.Xor_4016);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == AtomicitydecompositionElementTypes.AndAndLink_4002) {
			types.add(AtomicitydecompositionElementTypes.And_2002);
		} else if (relationshipType == AtomicitydecompositionElementTypes.LoopLoopLink_4003) {
			types.add(AtomicitydecompositionElementTypes.Loop_2003);
		} else if (relationshipType == AtomicitydecompositionElementTypes.AllAllLink_4004) {
			types.add(AtomicitydecompositionElementTypes.All_2004);
		} else if (relationshipType == AtomicitydecompositionElementTypes.SomeSomeLink_4006) {
			types.add(AtomicitydecompositionElementTypes.Some_2005);
		} else if (relationshipType == AtomicitydecompositionElementTypes.OrOrLink_4008) {
			types.add(AtomicitydecompositionElementTypes.Or_2006);
		} else if (relationshipType == AtomicitydecompositionElementTypes.XorXorLink_4009) {
			types.add(AtomicitydecompositionElementTypes.Xor_2007);
		} else if (relationshipType == AtomicitydecompositionElementTypes.OneOneLink_4010) {
			types.add(AtomicitydecompositionElementTypes.One_2008);
		} else if (relationshipType == AtomicitydecompositionElementTypes.ParParLink_4012) {
			types.add(AtomicitydecompositionElementTypes.Par_2009);
		} else if (relationshipType == AtomicitydecompositionElementTypes.FlowDiagramRefine_4014) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_2011);
		} else if (relationshipType == AtomicitydecompositionElementTypes.FlowDiagram_4015) {
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
		} else if (relationshipType == AtomicitydecompositionElementTypes.Xor_4016) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_2011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class LeafFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeafLabelFigure;

		/**
		 * @generated
		 */
		public LeafFigure() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setBackgroundColor(THIS_BACK);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLeafLabelFigure = new WrappingLabel();

			fFigureLeafLabelFigure.setText("Leaf");

			this.add(fFigureLeafLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeafLabelFigure() {
			return fFigureLeafLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 0, 189, 15);

}
