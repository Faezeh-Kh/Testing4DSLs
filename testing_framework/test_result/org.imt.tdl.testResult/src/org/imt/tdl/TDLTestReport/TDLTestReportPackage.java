/**
 */
package org.imt.tdl.TDLTestReport;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.imt.tdl.TDLTestReport.TDLTestReportFactory
 * @model kind="package"
 * @generated
 */
public interface TDLTestReportPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TDLTestReport";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://org.imt.tdl.testResult/TDLTestReport";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TDLTestReport";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TDLTestReportPackage eINSTANCE = org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.imt.tdl.TDLTestReport.impl.TestSuiteResultImpl <em>Test Suite Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.imt.tdl.TDLTestReport.impl.TestSuiteResultImpl
	 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getTestSuiteResult()
	 * @generated
	 */
	int TEST_SUITE_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Test Suite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__TEST_SUITE = 0;

	/**
	 * The feature id for the '<em><b>Test Case Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__TEST_CASE_RESULTS = 1;

	/**
	 * The number of structural features of the '<em>Test Suite Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Test Suite Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl <em>Test Case Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl
	 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getTestCaseResult()
	 * @generated
	 */
	int TEST_CASE_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Test Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__TEST_CASE = 0;

	/**
	 * The feature id for the '<em><b>Test Message Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__TEST_MESSAGE_RESULTS = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Test Case Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Test Case Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl <em>Test Message Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl
	 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getTestMessageResult()
	 * @generated
	 */
	int TEST_MESSAGE_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_MESSAGE_RESULT__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Tdl Message Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_MESSAGE_RESULT__TDL_MESSAGE_ID = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_MESSAGE_RESULT__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_MESSAGE_RESULT__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Test Message Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_MESSAGE_RESULT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Test Message Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_MESSAGE_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.imt.tdl.TDLTestReport.Verdicts <em>Verdicts</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.imt.tdl.TDLTestReport.Verdicts
	 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getVerdicts()
	 * @generated
	 */
	int VERDICTS = 3;


	/**
	 * Returns the meta object for class '{@link org.imt.tdl.TDLTestReport.TestSuiteResult <em>Test Suite Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Suite Result</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestSuiteResult
	 * @generated
	 */
	EClass getTestSuiteResult();

	/**
	 * Returns the meta object for the reference '{@link org.imt.tdl.TDLTestReport.TestSuiteResult#getTestSuite <em>Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Test Suite</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestSuiteResult#getTestSuite()
	 * @see #getTestSuiteResult()
	 * @generated
	 */
	EReference getTestSuiteResult_TestSuite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.imt.tdl.TDLTestReport.TestSuiteResult#getTestCaseResults <em>Test Case Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Case Results</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestSuiteResult#getTestCaseResults()
	 * @see #getTestSuiteResult()
	 * @generated
	 */
	EReference getTestSuiteResult_TestCaseResults();

	/**
	 * Returns the meta object for class '{@link org.imt.tdl.TDLTestReport.TestCaseResult <em>Test Case Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case Result</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestCaseResult
	 * @generated
	 */
	EClass getTestCaseResult();

	/**
	 * Returns the meta object for the reference '{@link org.imt.tdl.TDLTestReport.TestCaseResult#getTestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Test Case</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestCaseResult#getTestCase()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EReference getTestCaseResult_TestCase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.imt.tdl.TDLTestReport.TestCaseResult#getTestMessageResults <em>Test Message Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Message Results</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestCaseResult#getTestMessageResults()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EReference getTestCaseResult_TestMessageResults();

	/**
	 * Returns the meta object for the attribute '{@link org.imt.tdl.TDLTestReport.TestCaseResult#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestCaseResult#getValue()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EAttribute getTestCaseResult_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.imt.tdl.TDLTestReport.TestCaseResult#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestCaseResult#getDescription()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EAttribute getTestCaseResult_Description();

	/**
	 * Returns the meta object for class '{@link org.imt.tdl.TDLTestReport.TestMessageResult <em>Test Message Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Message Result</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestMessageResult
	 * @generated
	 */
	EClass getTestMessageResult();

	/**
	 * Returns the meta object for the reference '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestMessageResult#getMessage()
	 * @see #getTestMessageResult()
	 * @generated
	 */
	EReference getTestMessageResult_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getTdlMessageId <em>Tdl Message Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tdl Message Id</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestMessageResult#getTdlMessageId()
	 * @see #getTestMessageResult()
	 * @generated
	 */
	EAttribute getTestMessageResult_TdlMessageId();

	/**
	 * Returns the meta object for the attribute '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestMessageResult#getValue()
	 * @see #getTestMessageResult()
	 * @generated
	 */
	EAttribute getTestMessageResult_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.imt.tdl.TDLTestReport.TestMessageResult#getDescription()
	 * @see #getTestMessageResult()
	 * @generated
	 */
	EAttribute getTestMessageResult_Description();

	/**
	 * Returns the meta object for enum '{@link org.imt.tdl.TDLTestReport.Verdicts <em>Verdicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Verdicts</em>'.
	 * @see org.imt.tdl.TDLTestReport.Verdicts
	 * @generated
	 */
	EEnum getVerdicts();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TDLTestReportFactory getTDLTestReportFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.imt.tdl.TDLTestReport.impl.TestSuiteResultImpl <em>Test Suite Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.imt.tdl.TDLTestReport.impl.TestSuiteResultImpl
		 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getTestSuiteResult()
		 * @generated
		 */
		EClass TEST_SUITE_RESULT = eINSTANCE.getTestSuiteResult();

		/**
		 * The meta object literal for the '<em><b>Test Suite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE_RESULT__TEST_SUITE = eINSTANCE.getTestSuiteResult_TestSuite();

		/**
		 * The meta object literal for the '<em><b>Test Case Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE_RESULT__TEST_CASE_RESULTS = eINSTANCE.getTestSuiteResult_TestCaseResults();

		/**
		 * The meta object literal for the '{@link org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl <em>Test Case Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.imt.tdl.TDLTestReport.impl.TestCaseResultImpl
		 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getTestCaseResult()
		 * @generated
		 */
		EClass TEST_CASE_RESULT = eINSTANCE.getTestCaseResult();

		/**
		 * The meta object literal for the '<em><b>Test Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_RESULT__TEST_CASE = eINSTANCE.getTestCaseResult_TestCase();

		/**
		 * The meta object literal for the '<em><b>Test Message Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_RESULT__TEST_MESSAGE_RESULTS = eINSTANCE.getTestCaseResult_TestMessageResults();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE_RESULT__VALUE = eINSTANCE.getTestCaseResult_Value();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE_RESULT__DESCRIPTION = eINSTANCE.getTestCaseResult_Description();

		/**
		 * The meta object literal for the '{@link org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl <em>Test Message Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl
		 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getTestMessageResult()
		 * @generated
		 */
		EClass TEST_MESSAGE_RESULT = eINSTANCE.getTestMessageResult();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_MESSAGE_RESULT__MESSAGE = eINSTANCE.getTestMessageResult_Message();

		/**
		 * The meta object literal for the '<em><b>Tdl Message Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_MESSAGE_RESULT__TDL_MESSAGE_ID = eINSTANCE.getTestMessageResult_TdlMessageId();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_MESSAGE_RESULT__VALUE = eINSTANCE.getTestMessageResult_Value();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_MESSAGE_RESULT__DESCRIPTION = eINSTANCE.getTestMessageResult_Description();

		/**
		 * The meta object literal for the '{@link org.imt.tdl.TDLTestReport.Verdicts <em>Verdicts</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.imt.tdl.TDLTestReport.Verdicts
		 * @see org.imt.tdl.TDLTestReport.impl.TDLTestReportPackageImpl#getVerdicts()
		 * @generated
		 */
		EEnum VERDICTS = eINSTANCE.getVerdicts();

	}

} //TDLTestReportPackage
