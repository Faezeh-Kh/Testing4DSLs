/**
 */
package org.imt.tdl.TDLTestReport;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage
 * @generated
 */
public interface TDLTestReportFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TDLTestReportFactory eINSTANCE = org.imt.tdl.TDLTestReport.impl.TDLTestReportFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Suite Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Suite Result</em>'.
	 * @generated
	 */
	TestSuiteResult createTestSuiteResult();

	/**
	 * Returns a new object of class '<em>Test Case Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Case Result</em>'.
	 * @generated
	 */
	TestCaseResult createTestCaseResult();

	/**
	 * Returns a new object of class '<em>Test Message Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Message Result</em>'.
	 * @generated
	 */
	TestMessageResult createTestMessageResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TDLTestReportPackage getTDLTestReportPackage();

} //TDLTestReportFactory
