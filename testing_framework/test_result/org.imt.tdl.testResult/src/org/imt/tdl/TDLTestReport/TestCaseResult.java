/**
 */
package org.imt.tdl.TDLTestReport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.etsi.mts.tdl.TestDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Case Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestCaseResult#getTestCase <em>Test Case</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestCaseResult#getTestMessageResults <em>Test Message Results</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestCaseResult#getValue <em>Value</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestCaseResult#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestCaseResult()
 * @model
 * @generated
 */
public interface TestCaseResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Case</em>' reference.
	 * @see #setTestCase(TestDescription)
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestCaseResult_TestCase()
	 * @model required="true"
	 * @generated
	 */
	TestDescription getTestCase();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestCaseResult#getTestCase <em>Test Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Case</em>' reference.
	 * @see #getTestCase()
	 * @generated
	 */
	void setTestCase(TestDescription value);

	/**
	 * Returns the value of the '<em><b>Test Message Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.imt.tdl.TDLTestReport.TestMessageResult}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Message Results</em>' containment reference list.
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestCaseResult_TestMessageResults()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TestMessageResult> getTestMessageResults();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.imt.tdl.TDLTestReport.Verdicts}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.imt.tdl.TDLTestReport.Verdicts
	 * @see #setValue(Verdicts)
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestCaseResult_Value()
	 * @model required="true"
	 * @generated
	 */
	Verdicts getValue();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestCaseResult#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see org.imt.tdl.TDLTestReport.Verdicts
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Verdicts value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestCaseResult_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestCaseResult#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // TestCaseResult
