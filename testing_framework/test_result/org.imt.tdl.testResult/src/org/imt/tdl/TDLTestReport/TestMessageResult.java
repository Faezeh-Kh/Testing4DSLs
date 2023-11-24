/**
 */
package org.imt.tdl.TDLTestReport;

import org.eclipse.emf.ecore.EObject;

import org.etsi.mts.tdl.Message;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Message Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestMessageResult#getMessage <em>Message</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestMessageResult#getTdlMessageId <em>Tdl Message Id</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestMessageResult#getValue <em>Value</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.TestMessageResult#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestMessageResult()
 * @model
 * @generated
 */
public interface TestMessageResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(Message)
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestMessageResult_Message()
	 * @model required="true"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

	/**
	 * Returns the value of the '<em><b>Tdl Message Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tdl Message Id</em>' attribute.
	 * @see #setTdlMessageId(String)
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestMessageResult_TdlMessageId()
	 * @model required="true"
	 * @generated
	 */
	String getTdlMessageId();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getTdlMessageId <em>Tdl Message Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tdl Message Id</em>' attribute.
	 * @see #getTdlMessageId()
	 * @generated
	 */
	void setTdlMessageId(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.imt.tdl.TDLTestReport.Verdicts}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.imt.tdl.TDLTestReport.Verdicts
	 * @see #setValue(Verdicts)
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestMessageResult_Value()
	 * @model required="true"
	 * @generated
	 */
	Verdicts getValue();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getValue <em>Value</em>}' attribute.
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
	 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getTestMessageResult_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.imt.tdl.TDLTestReport.TestMessageResult#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // TestMessageResult
