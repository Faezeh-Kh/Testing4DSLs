/**
 */
package org.imt.tdl.TDLTestReport.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.etsi.mts.tdl.tdlPackage;

import org.imt.tdl.TDLTestReport.TDLTestReportFactory;
import org.imt.tdl.TDLTestReport.TDLTestReportPackage;
import org.imt.tdl.TDLTestReport.TestCaseResult;
import org.imt.tdl.TDLTestReport.TestMessageResult;
import org.imt.tdl.TDLTestReport.TestSuiteResult;
import org.imt.tdl.TDLTestReport.Verdicts;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TDLTestReportPackageImpl extends EPackageImpl implements TDLTestReportPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testSuiteResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testCaseResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testMessageResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum verdictsEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TDLTestReportPackageImpl() {
		super(eNS_URI, TDLTestReportFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TDLTestReportPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TDLTestReportPackage init() {
		if (isInited) return (TDLTestReportPackage)EPackage.Registry.INSTANCE.getEPackage(TDLTestReportPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTDLTestReportPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TDLTestReportPackageImpl theTDLTestReportPackage = registeredTDLTestReportPackage instanceof TDLTestReportPackageImpl ? (TDLTestReportPackageImpl)registeredTDLTestReportPackage : new TDLTestReportPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		tdlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTDLTestReportPackage.createPackageContents();

		// Initialize created meta-data
		theTDLTestReportPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTDLTestReportPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TDLTestReportPackage.eNS_URI, theTDLTestReportPackage);
		return theTDLTestReportPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestSuiteResult() {
		return testSuiteResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestSuiteResult_TestSuite() {
		return (EReference)testSuiteResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestSuiteResult_TestCaseResults() {
		return (EReference)testSuiteResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestCaseResult() {
		return testCaseResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCaseResult_TestCase() {
		return (EReference)testCaseResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCaseResult_TestMessageResults() {
		return (EReference)testCaseResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCaseResult_Value() {
		return (EAttribute)testCaseResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCaseResult_Description() {
		return (EAttribute)testCaseResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestMessageResult() {
		return testMessageResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestMessageResult_Message() {
		return (EReference)testMessageResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestMessageResult_TdlMessageId() {
		return (EAttribute)testMessageResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestMessageResult_Value() {
		return (EAttribute)testMessageResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestMessageResult_Description() {
		return (EAttribute)testMessageResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVerdicts() {
		return verdictsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TDLTestReportFactory getTDLTestReportFactory() {
		return (TDLTestReportFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		testSuiteResultEClass = createEClass(TEST_SUITE_RESULT);
		createEReference(testSuiteResultEClass, TEST_SUITE_RESULT__TEST_SUITE);
		createEReference(testSuiteResultEClass, TEST_SUITE_RESULT__TEST_CASE_RESULTS);

		testCaseResultEClass = createEClass(TEST_CASE_RESULT);
		createEReference(testCaseResultEClass, TEST_CASE_RESULT__TEST_CASE);
		createEReference(testCaseResultEClass, TEST_CASE_RESULT__TEST_MESSAGE_RESULTS);
		createEAttribute(testCaseResultEClass, TEST_CASE_RESULT__VALUE);
		createEAttribute(testCaseResultEClass, TEST_CASE_RESULT__DESCRIPTION);

		testMessageResultEClass = createEClass(TEST_MESSAGE_RESULT);
		createEReference(testMessageResultEClass, TEST_MESSAGE_RESULT__MESSAGE);
		createEAttribute(testMessageResultEClass, TEST_MESSAGE_RESULT__TDL_MESSAGE_ID);
		createEAttribute(testMessageResultEClass, TEST_MESSAGE_RESULT__VALUE);
		createEAttribute(testMessageResultEClass, TEST_MESSAGE_RESULT__DESCRIPTION);

		// Create enums
		verdictsEEnum = createEEnum(VERDICTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		tdlPackage thetdlPackage = (tdlPackage)EPackage.Registry.INSTANCE.getEPackage(tdlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(testSuiteResultEClass, TestSuiteResult.class, "TestSuiteResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestSuiteResult_TestSuite(), thetdlPackage.getPackage(), null, "testSuite", null, 1, 1, TestSuiteResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSuiteResult_TestCaseResults(), this.getTestCaseResult(), null, "testCaseResults", null, 1, -1, TestSuiteResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testCaseResultEClass, TestCaseResult.class, "TestCaseResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestCaseResult_TestCase(), thetdlPackage.getTestDescription(), null, "testCase", null, 1, 1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCaseResult_TestMessageResults(), this.getTestMessageResult(), null, "testMessageResults", null, 1, -1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCaseResult_Value(), this.getVerdicts(), "value", null, 1, 1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCaseResult_Description(), ecorePackage.getEString(), "description", null, 0, 1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testMessageResultEClass, TestMessageResult.class, "TestMessageResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestMessageResult_Message(), thetdlPackage.getMessage(), null, "message", null, 1, 1, TestMessageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestMessageResult_TdlMessageId(), ecorePackage.getEString(), "tdlMessageId", null, 1, 1, TestMessageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestMessageResult_Value(), this.getVerdicts(), "value", null, 1, 1, TestMessageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestMessageResult_Description(), ecorePackage.getEString(), "description", null, 0, 1, TestMessageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(verdictsEEnum, Verdicts.class, "Verdicts");
		addEEnumLiteral(verdictsEEnum, Verdicts.PASS);
		addEEnumLiteral(verdictsEEnum, Verdicts.FAIL);
		addEEnumLiteral(verdictsEEnum, Verdicts.INCONCLUSIVE);

		// Create resource
		createResource(eNS_URI);
	}

} //TDLTestReportPackageImpl
