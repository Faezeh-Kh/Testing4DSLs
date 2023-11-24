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

import org.imt.tdl.TDLTestReport.TDLTestReportPackage;
import org.imt.tdl.TDLTestReport.TestCaseResult;
import org.imt.tdl.TDLTestReport.TestSuiteResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Suite Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestSuiteResultImpl#getTestSuite <em>Test Suite</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestSuiteResultImpl#getTestCaseResults <em>Test Case Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSuiteResultImpl extends MinimalEObjectImpl.Container implements TestSuiteResult {
	/**
	 * The cached value of the '{@link #getTestSuite() <em>Test Suite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestSuite()
	 * @generated
	 * @ordered
	 */
	protected org.etsi.mts.tdl.Package testSuite;

	/**
	 * The cached value of the '{@link #getTestCaseResults() <em>Test Case Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestCaseResults()
	 * @generated
	 * @ordered
	 */
	protected EList<TestCaseResult> testCaseResults;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSuiteResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TDLTestReportPackage.Literals.TEST_SUITE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.etsi.mts.tdl.Package getTestSuite() {
		if (testSuite != null && testSuite.eIsProxy()) {
			InternalEObject oldTestSuite = (InternalEObject)testSuite;
			testSuite = (org.etsi.mts.tdl.Package)eResolveProxy(oldTestSuite);
			if (testSuite != oldTestSuite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TDLTestReportPackage.TEST_SUITE_RESULT__TEST_SUITE, oldTestSuite, testSuite));
			}
		}
		return testSuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.etsi.mts.tdl.Package basicGetTestSuite() {
		return testSuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestSuite(org.etsi.mts.tdl.Package newTestSuite) {
		org.etsi.mts.tdl.Package oldTestSuite = testSuite;
		testSuite = newTestSuite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_SUITE_RESULT__TEST_SUITE, oldTestSuite, testSuite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestCaseResult> getTestCaseResults() {
		if (testCaseResults == null) {
			testCaseResults = new EObjectContainmentEList<TestCaseResult>(TestCaseResult.class, this, TDLTestReportPackage.TEST_SUITE_RESULT__TEST_CASE_RESULTS);
		}
		return testCaseResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_CASE_RESULTS:
				return ((InternalEList<?>)getTestCaseResults()).basicRemove(otherEnd, msgs);
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
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_SUITE:
				if (resolve) return getTestSuite();
				return basicGetTestSuite();
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_CASE_RESULTS:
				return getTestCaseResults();
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
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_SUITE:
				setTestSuite((org.etsi.mts.tdl.Package)newValue);
				return;
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_CASE_RESULTS:
				getTestCaseResults().clear();
				getTestCaseResults().addAll((Collection<? extends TestCaseResult>)newValue);
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
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_SUITE:
				setTestSuite((org.etsi.mts.tdl.Package)null);
				return;
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_CASE_RESULTS:
				getTestCaseResults().clear();
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
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_SUITE:
				return testSuite != null;
			case TDLTestReportPackage.TEST_SUITE_RESULT__TEST_CASE_RESULTS:
				return testCaseResults != null && !testCaseResults.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestSuiteResultImpl
