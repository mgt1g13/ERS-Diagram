package ac.soton.eventb.atomicitydecomposition.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class AtomicitydecompositionPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createAll1CreationTool());
		paletteContainer.add(createAnd2CreationTool());
		paletteContainer.add(createLeaf3CreationTool());
		paletteContainer.add(createLoop4CreationTool());
		paletteContainer.add(createOne5CreationTool());
		paletteContainer.add(createOr6CreationTool());
		paletteContainer.add(createPar7CreationTool());
		paletteContainer.add(createSome8CreationTool());
		paletteContainer.add(createXor9CreationTool());
		paletteContainer.add(createFlowDiagram10CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createAllLink1CreationTool());
		paletteContainer.add(createAndLink2CreationTool());
		paletteContainer.add(createLoopLink3CreationTool());
		paletteContainer.add(createNewParameter4CreationTool());
		paletteContainer.add(createNewParameter5CreationTool());
		paletteContainer.add(createNewParameter6CreationTool());
		paletteContainer.add(createOneLink7CreationTool());
		paletteContainer.add(createOrLink8CreationTool());
		paletteContainer.add(createParLink9CreationTool());
		paletteContainer.add(createRefine10CreationTool());
		paletteContainer.add(createSomeLink11CreationTool());
		paletteContainer.add(createXorLink12CreationTool());
		paletteContainer.add(createDecomposeLink13CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAll1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.All1CreationTool_title,
				Messages.All1CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.All_2004));
		entry.setId("createAll1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.All_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnd2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.And2CreationTool_title,
				Messages.And2CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.And_2002));
		entry.setId("createAnd2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.And_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLeaf3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Leaf3CreationTool_title,
				Messages.Leaf3CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Leaf_2001));
		entry.setId("createLeaf3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Leaf_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoop4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Loop4CreationTool_title,
				Messages.Loop4CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Loop_2003));
		entry.setId("createLoop4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Loop_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOne5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.One5CreationTool_title,
				Messages.One5CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.One_2008));
		entry.setId("createOne5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.One_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOr6CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Or6CreationTool_title,
				Messages.Or6CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Or_2006));
		entry.setId("createOr6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Or_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPar7CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Par7CreationTool_title,
				Messages.Par7CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Par_2009));
		entry.setId("createPar7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Par_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSome8CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Some8CreationTool_title,
				Messages.Some8CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Some_2005));
		entry.setId("createSome8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Some_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createXor9CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Xor9CreationTool_title,
				Messages.Xor9CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Xor_2007));
		entry.setId("createXor9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Xor_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFlowDiagram10CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FlowDiagram10CreationTool_title,
				Messages.FlowDiagram10CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.FlowDiagram_2011));
		entry.setId("createFlowDiagram10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.FlowDiagram_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAllLink1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AllLink1CreationTool_title,
				Messages.AllLink1CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.AllAllLink_4004));
		entry.setId("createAllLink1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.AllAllLink_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAndLink2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AndLink2CreationTool_title,
				Messages.AndLink2CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.AndAndLink_4002));
		entry.setId("createAndLink2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.AndAndLink_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoopLink3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.LoopLink3CreationTool_title,
				Messages.LoopLink3CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.LoopLoopLink_4003));
		entry.setId("createLoopLink3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.LoopLoopLink_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewParameter4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NewParameter4CreationTool_title,
				Messages.NewParameter4CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.AllNewParameter_4005));
		entry.setId("createNewParameter4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.AllNewParameter_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewParameter5CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NewParameter5CreationTool_title,
				Messages.NewParameter5CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.SomeNewParameter_4007));
		entry.setId("createNewParameter5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.SomeNewParameter_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewParameter6CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NewParameter6CreationTool_title,
				Messages.NewParameter6CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.OneNewParameter_4011));
		entry.setId("createNewParameter6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.OneNewParameter_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOneLink7CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OneLink7CreationTool_title,
				Messages.OneLink7CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.OneOneLink_4010));
		entry.setId("createOneLink7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.OneOneLink_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOrLink8CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OrLink8CreationTool_title,
				Messages.OrLink8CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.OrOrLink_4008));
		entry.setId("createOrLink8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.OrOrLink_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParLink9CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ParLink9CreationTool_title,
				Messages.ParLink9CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.ParParLink_4012));
		entry.setId("createParLink9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.ParParLink_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRefine10CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Refine10CreationTool_title,
				Messages.Refine10CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014));
		entry.setId("createRefine10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSomeLink11CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.SomeLink11CreationTool_title,
				Messages.SomeLink11CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.SomeSomeLink_4006));
		entry.setId("createSomeLink11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.SomeSomeLink_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createXorLink12CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.XorLink12CreationTool_title,
				Messages.XorLink12CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.XorXorLink_4009));
		entry.setId("createXorLink12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.XorXorLink_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDecomposeLink13CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.DecomposeLink13CreationTool_title,
				Messages.DecomposeLink13CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.MultiFlowDecompose_4013));
		entry.setId("createDecomposeLink13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.MultiFlowDecompose_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
