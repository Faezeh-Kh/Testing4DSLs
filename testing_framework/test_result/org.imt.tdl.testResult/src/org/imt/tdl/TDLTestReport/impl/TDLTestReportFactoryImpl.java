/**
 */
package org.imt.tdl.TDLTestReport.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.imt.tdl.TDLTestReport.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TDLTestReportFactoryImpl extends EFactoryImpl implements TDLTestReportFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TDLTestReportFactory init() {
		try {
			TDLTestReportFactory theTDLTestReportFactory = (TDLTestReportFactory)EPackage.Registry.INSTANCE.getEFactory(TDLTestReportPackage.eNS_URI);
			if (theTDLTestReportFactory != null) {
				return theTDLTestReportFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TDLTestReportFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDLTestReportFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TDLTestReportPackage.TEST_SUITE_RESULT: return createTestSuiteResult();
			case TDLTestReportPackage.TEST_CASE_RESULT: return createTestCaseResult();
			case TDLTestReportPackage.TEST_MESSAGE_RESULT: return createTestMessageResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TDLTestReportPackage.VERDICTS:
				return createVerdictsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TDLTestReportPackage.VERDICTS:
				return convertVerdictsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestSuiteResult createTestSuiteResult() {
		TestSuiteResultImpl testSuiteResult = new TestSuiteResultImpl();
		return testSuiteResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestCaseResult createTestCaseResult() {
		TestCaseResultImpl testCaseResult = new TestCaseResultImpl();
		return testCaseResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestMessageResult createTestMessageResult() {
		TestMessageResultImpl testMessageResult = new TestMessageResultImpl();
		return testMessageResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verdicts createVerdictsFromString(EDataType eDataType, String initialValue) {
		Verdicts result = Verdicts.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVerdictsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TDLTestReportPackage getTDLTestReportPackage() {
		return (TDLTestReportPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TDLTestReportPackage getPackage() {
		return TDLTestReportPackage.eINSTANCE;
	}

} //TDLTestReportFactoryImpl
