/**
 */
package ac.soton.eventb.atomicitydecomposition.provider;


import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;

import ac.soton.eventb.emf.core.extension.coreextension.provider.EventBNamedCommentedDataElaborationElementItemProvider;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eventb.emf.core.CorePackage;

import org.eventb.emf.core.provider.AbstractExtensionItemProvider;

/**
 * This is the item provider adapter for a {@link ac.soton.eventb.atomicitydecomposition.FlowDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowDiagramItemProvider
	extends EventBNamedCommentedDataElaborationElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowDiagramItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExtensionIdPropertyDescriptor(object);
			addSwPropertyDescriptor(object);
			addCopyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Extension Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtensionIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractExtension_extensionId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractExtension_extensionId_feature", "_UI_AbstractExtension_type"),
				 CorePackage.Literals.ABSTRACT_EXTENSION__EXTENSION_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sw feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSwPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FlowDiagram_sw_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FlowDiagram_sw_feature", "_UI_FlowDiagram_type"),
				 AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__SW,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Copy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCopyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FlowDiagram_copy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FlowDiagram_copy_feature", "_UI_FlowDiagram_type"),
				 AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__COPY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__PARAMETERS);
			childrenFeatures.add(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns FlowDiagram.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowDiagram"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FlowDiagram)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_FlowDiagram_type") :
			getString("_UI_FlowDiagram_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(FlowDiagram.class)) {
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID:
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__SW:
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__COPY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS:
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__REFINE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 AtomicitydecompositionFactory.eINSTANCE.createFlowDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__PARAMETERS,
				 AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createLeaf()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createLoop()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createAll()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createSome()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createOne()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createPar()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createInterrupt()));

		newChildDescriptors.add
			(createChildParameter
				(AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM__REFINE,
				 AtomicitydecompositionFactory.eINSTANCE.createRetry()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AtomicitydecompositionEditPlugin.INSTANCE;
	}

}
