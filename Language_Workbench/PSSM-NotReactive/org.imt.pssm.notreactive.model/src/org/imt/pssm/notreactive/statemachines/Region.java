/**
 */
package org.imt.pssm.notreactive.statemachines;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.Region#getVertice <em>Vertice</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.Region#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.Region#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.Region#getState <em>State</em>}</li>
 *   <li>{@link org.imt.pssm.notreactive.statemachines.Region#getCurrentVertex <em>Current Vertex</em>}</li>
 * </ul>
 *
 * @see org.imt.pssm.notreactive.statemachines.StatemachinesPackage#getRegion()
 * @model
 * @generated
 */
public interface Region extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Vertice</b></em>' containment reference list.
	 * The list contents are of type {@link org.imt.pssm.notreactive.statemachines.Vertex}.
	 * It is bidirectional and its opposite is '{@link org.imt.pssm.notreactive.statemachines.Vertex#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertice</em>' containment reference list.
	 * @see org.imt.pssm.notreactive.statemachines.StatemachinesPackage#getRegion_Vertice()
	 * @see org.imt.pssm.notreactive.statemachines.Vertex#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<Vertex> getVertice();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.imt.pssm.notreactive.statemachines.Transition}.
	 * It is bidirectional and its opposite is '{@link org.imt.pssm.notreactive.statemachines.Transition#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.imt.pssm.notreactive.statemachines.StatemachinesPackage#getRegion_Transitions()
	 * @see org.imt.pssm.notreactive.statemachines.Transition#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.imt.pssm.notreactive.statemachines.StateMachine#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' container reference.
	 * @see #setStateMachine(StateMachine)
	 * @see org.imt.pssm.notreactive.statemachines.StatemachinesPackage#getRegion_StateMachine()
	 * @see org.imt.pssm.notreactive.statemachines.StateMachine#getRegions
	 * @model opposite="regions" transient="false"
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link org.imt.pssm.notreactive.statemachines.Region#getStateMachine <em>State Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' container reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.imt.pssm.notreactive.statemachines.State#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' container reference.
	 * @see #setState(State)
	 * @see org.imt.pssm.notreactive.statemachines.StatemachinesPackage#getRegion_State()
	 * @see org.imt.pssm.notreactive.statemachines.State#getRegions
	 * @model opposite="regions" transient="false"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.imt.pssm.notreactive.statemachines.Region#getState <em>State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' container reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Current Vertex</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Vertex</em>' reference.
	 * @see #setCurrentVertex(Vertex)
	 * @see org.imt.pssm.notreactive.statemachines.StatemachinesPackage#getRegion_CurrentVertex()
	 * @model annotation="dynamic"
	 * @generated
	 */
	Vertex getCurrentVertex();

	/**
	 * Sets the value of the '{@link org.imt.pssm.notreactive.statemachines.Region#getCurrentVertex <em>Current Vertex</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Vertex</em>' reference.
	 * @see #getCurrentVertex()
	 * @generated
	 */
	void setCurrentVertex(Vertex value);

} // Region
