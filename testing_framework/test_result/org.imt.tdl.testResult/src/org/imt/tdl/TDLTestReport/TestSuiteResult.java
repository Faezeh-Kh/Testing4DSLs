/**
 */
package org.imt.tdl.TDLTestReport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestSuiteResult#getTestSuite <em>Test Suite</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestSuiteResult#getTestCaseResults <em>Test Case Results</em>}</li>
 * </ul>
 *
 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestSuiteResult()
 * @model
 * @generated
 */
public interface TestSuiteResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Suite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Suite</em>' reference.
	 * @see #setTestSuite(org.etsi.mts.tdl.Package)
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestSuiteResult_TestSuite()
	 * @model required="true"
	 * @generated
	 */
	org.etsi.mts.tdl.Package getTestSuite();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestSuiteResult#getTestSuite <em>Test Suite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Suite</em>' reference.
	 * @see #getTestSuite()
	 * @generated
	 */
	void setTestSuite(org.etsi.mts.tdl.Package value);

	/**
	 * Returns the value of the '<em><b>Test Case Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.imt.tdl.TDLTestReport.TestCaseResult}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Case Results</em>' containment reference list.
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestSuiteResult_TestCaseResults()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TestCaseResult> getTestCaseResults();

} // TestSuiteResult
