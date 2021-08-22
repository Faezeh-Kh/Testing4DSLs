/**
 */
package org.imt.pssm.notreactive.statemachines.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.imt.pssm.notreactive.statemachines.Behavior;
import org.imt.pssm.notreactive.statemachines.CustomSystem;
import org.imt.pssm.notreactive.statemachines.EventOccurrence;
import org.imt.pssm.notreactive.statemachines.Operation;
import org.imt.pssm.notreactive.statemachines.Signal;
import org.imt.pssm.notreactive.statemachines.StateMachine;
import org.imt.pssm.notreactive.statemachines.StatemachinesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.impl.CustomSystemImpl#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.impl.CustomSystemImpl#getSignals <em>Signals</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.impl.CustomSystemImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.impl.CustomSystemImpl#getEventOccurrences <em>Event Occurrences</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.impl.CustomSystemImpl#getPerformedBehaviors <em>Performed Behaviors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CustomSystemImpl extends MinimalEObjectImpl.Container implements CustomSystem {
	/**
	 * The cached value of the '{@link #getStatemachine() <em>Statemachine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatemachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachine statemachine;

	/**
	 * The cached value of the '{@link #getSignals() <em>Signals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignals()
	 * @generated
	 * @ordered
	 */
	protected EList<Signal> signals;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * The cached value of the '{@link #getEventOccurrences() <em>Event Occurrences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventOccurrences()
	 * @generated
	 * @ordered
	 */
	protected EList<EventOccurrence> eventOccurrences;

	/**
	 * The cached value of the '{@link #getPerformedBehaviors() <em>Performed Behaviors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformedBehaviors()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> performedBehaviors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatemachinesPackage.Literals.CUSTOM_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getStatemachine() {
		return statemachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatemachine(StateMachine newStatemachine, NotificationChain msgs) {
		StateMachine oldStatemachine = statemachine;
		statemachine = newStatemachine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE, oldStatemachine, newStatemachine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatemachine(StateMachine newStatemachine) {
		if (newStatemachine != statemachine) {
			NotificationChain msgs = null;
			if (statemachine != null)
				msgs = ((InternalEObject)statemachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE, null, msgs);
			if (newStatemachine != null)
				msgs = ((InternalEObject)newStatemachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE, null, msgs);
			msgs = basicSetStatemachine(newStatemachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE, newStatemachine, newStatemachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Signal> getSignals() {
		if (signals == null) {
			signals = new EObjectContainmentEList<Signal>(Signal.class, this, StatemachinesPackage.CUSTOM_SYSTEM__SIGNALS);
		}
		return signals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<Operation>(Operation.class, this, StatemachinesPackage.CUSTOM_SYSTEM__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventOccurrence> getEventOccurrences() {
		if (eventOccurrences == null) {
			eventOccurrences = new EObjectContainmentEList<EventOccurrence>(EventOccurrence.class, this, StatemachinesPackage.CUSTOM_SYSTEM__EVENT_OCCURRENCES);
		}
		return eventOccurrences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Behavior> getPerformedBehaviors() {
		if (performedBehaviors == null) {
			performedBehaviors = new EObjectResolvingEList<Behavior>(Behavior.class, this, StatemachinesPackage.CUSTOM_SYSTEM__PERFORMED_BEHAVIORS);
		}
		return performedBehaviors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE:
				return basicSetStatemachine(null, msgs);
			case StatemachinesPackage.CUSTOM_SYSTEM__SIGNALS:
				return ((InternalEList<?>)getSignals()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.CUSTOM_SYSTEM__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case StatemachinesPackage.CUSTOM_SYSTEM__EVENT_OCCURRENCES:
				return ((InternalEList<?>)getEventOccurrences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE:
				return getStatemachine();
			case StatemachinesPackage.CUSTOM_SYSTEM__SIGNALS:
				return getSignals();
			case StatemachinesPackage.CUSTOM_SYSTEM__OPERATIONS:
				return getOperations();
			case StatemachinesPackage.CUSTOM_SYSTEM__EVENT_OCCURRENCES:
				return getEventOccurrences();
			case StatemachinesPackage.CUSTOM_SYSTEM__PERFORMED_BEHAVIORS:
				return getPerformedBehaviors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE:
				setStatemachine((StateMachine)newValue);
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__SIGNALS:
				getSignals().clear();
				getSignals().addAll((Collection<? extends Signal>)newValue);
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__EVENT_OCCURRENCES:
				getEventOccurrences().clear();
				getEventOccurrences().addAll((Collection<? extends EventOccurrence>)newValue);
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__PERFORMED_BEHAVIORS:
				getPerformedBehaviors().clear();
				getPerformedBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE:
				setStatemachine((StateMachine)null);
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__SIGNALS:
				getSignals().clear();
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__OPERATIONS:
				getOperations().clear();
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__EVENT_OCCURRENCES:
				getEventOccurrences().clear();
				return;
			case StatemachinesPackage.CUSTOM_SYSTEM__PERFORMED_BEHAVIORS:
				getPerformedBehaviors().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StatemachinesPackage.CUSTOM_SYSTEM__STATEMACHINE:
				return statemachine != null;
			case StatemachinesPackage.CUSTOM_SYSTEM__SIGNALS:
				return signals != null && !signals.isEmpty();
			case StatemachinesPackage.CUSTOM_SYSTEM__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case StatemachinesPackage.CUSTOM_SYSTEM__EVENT_OCCURRENCES:
				return eventOccurrences != null && !eventOccurrences.isEmpty();
			case StatemachinesPackage.CUSTOM_SYSTEM__PERFORMED_BEHAVIORS:
				return performedBehaviors != null && !performedBehaviors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CustomSystemImpl
