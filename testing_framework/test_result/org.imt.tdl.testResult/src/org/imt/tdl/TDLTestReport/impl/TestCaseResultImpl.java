/**
 */
package org.imt.tdl.TDLTestReport.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.etsi.mts.tdl.TestDescription;

import org.imt.tdl.TDLTestReport.TDLTestReportPackage;
import org.imt.tdl.TDLTestReport.TestCaseResult;
import org.imt.tdl.TDLTestReport.TestMessageResult;
import org.imt.tdl.TDLTestReport.Verdicts;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl#getTestCase <em>Test Case</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl#getTestMessageResults <em>Test Message Results</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestCaseResultImpl extends MinimalEObjectImpl.Container implements TestCaseResult {
	/**
	 * The cached value of the '{@link #getTestCase() <em>Test Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestCase()
	 * @generated
	 * @ordered
	 */
	protected TestDescription testCase;

	/**
	 * The cached value of the '{@link #getTestMessageResults() <em>Test Message Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestMessageResults()
	 * @generated
	 * @ordered
	 */
	protected EList<TestMessageResult> testMessageResults;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Verdicts VALUE_EDEFAULT = Verdicts.PASS;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Verdicts value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TDLTestReportPackage.Literals.TEST_CASE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestDescription getTestCase() {
		if (testCase != null && testCase.eIsProxy()) {
			InternalEObject oldTestCase = (InternalEObject)testCase;
			testCase = (TestDescription)eResolveProxy(oldTestCase);
			if (testCase != oldTestCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TDLTestReportPackage.TEST_CASE_RESULT__TEST_CASE, oldTestCase, testCase));
			}
		}
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestDescription basicGetTestCase() {
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestCase(TestDescription newTestCase) {
		TestDescription oldTestCase = testCase;
		testCase = newTestCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_CASE_RESULT__TEST_CASE, oldTestCase, testCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestMessageResult> getTestMessageResults() {
		if (testMessageResults == null) {
			testMessageResults = new EObjectContainmentEList<TestMessageResult>(TestMessageResult.class, this, TDLTestReportPackage.TEST_CASE_RESULT__TEST_MESSAGE_RESULTS);
		}
		return testMessageResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Verdicts getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(Verdicts newValue) {
		Verdicts oldValue = value;
		value = newValue == null ? VALUE_EDEFAULT : newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_CASE_RESULT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_CASE_RESULT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_MESSAGE_RESULTS:
				return ((InternalEList<?>)getTestMessageResults()).basicRemove(otherEnd, msgs);
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
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_CASE:
				if (resolve) return getTestCase();
				return basicGetTestCase();
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_MESSAGE_RESULTS:
				return getTestMessageResults();
			case TDLTestReportPackage.TEST_CASE_RESULT__VALUE:
				return getValue();
			case TDLTestReportPackage.TEST_CASE_RESULT__DESCRIPTION:
				return getDescription();
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
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_CASE:
				setTestCase((TestDescription)newValue);
				return;
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_MESSAGE_RESULTS:
				getTestMessageResults().clear();
				getTestMessageResults().addAll((Collection<? extends TestMessageResult>)newValue);
				return;
			case TDLTestReportPackage.TEST_CASE_RESULT__VALUE:
				setValue((Verdicts)newValue);
				return;
			case TDLTestReportPackage.TEST_CASE_RESULT__DESCRIPTION:
				setDescription((String)newValue);
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
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_CASE:
				setTestCase((TestDescription)null);
				return;
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_MESSAGE_RESULTS:
				getTestMessageResults().clear();
				return;
			case TDLTestReportPackage.TEST_CASE_RESULT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case TDLTestReportPackage.TEST_CASE_RESULT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_CASE:
				return testCase != null;
			case TDLTestReportPackage.TEST_CASE_RESULT__TEST_MESSAGE_RESULTS:
				return testMessageResults != null && !testMessageResults.isEmpty();
			case TDLTestReportPackage.TEST_CASE_RESULT__VALUE:
				return value != VALUE_EDEFAULT;
			case TDLTestReportPackage.TEST_CASE_RESULT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //TestCaseResultImpl
