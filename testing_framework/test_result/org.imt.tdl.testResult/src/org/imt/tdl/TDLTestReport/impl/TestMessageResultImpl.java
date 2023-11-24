/**
 */
package org.imt.tdl.TDLTestReport.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.etsi.mts.tdl.Message;

import org.imt.tdl.TDLTestReport.TDLTestReportPackage;
import org.imt.tdl.TDLTestReport.TestMessageResult;
import org.imt.tdl.TDLTestReport.Verdicts;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Message Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl#getTdlMessageId <em>Tdl Message Id</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.imt.tdl.TDLTestReport.impl.TestMessageResultImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestMessageResultImpl extends MinimalEObjectImpl.Container implements TestMessageResult {
	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected Message message;

	/**
	 * The default value of the '{@link #getTdlMessageId() <em>Tdl Message Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTdlMessageId()
	 * @generated
	 * @ordered
	 */
	protected static final String TDL_MESSAGE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTdlMessageId() <em>Tdl Message Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTdlMessageId()
	 * @generated
	 * @ordered
	 */
	protected String tdlMessageId = TDL_MESSAGE_ID_EDEFAULT;

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
	protected TestMessageResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TDLTestReportPackage.Literals.TEST_MESSAGE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Message getMessage() {
		if (message != null && message.eIsProxy()) {
			InternalEObject oldMessage = (InternalEObject)message;
			message = (Message)eResolveProxy(oldMessage);
			if (message != oldMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TDLTestReportPackage.TEST_MESSAGE_RESULT__MESSAGE, oldMessage, message));
			}
		}
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(Message newMessage) {
		Message oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_MESSAGE_RESULT__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTdlMessageId() {
		return tdlMessageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTdlMessageId(String newTdlMessageId) {
		String oldTdlMessageId = tdlMessageId;
		tdlMessageId = newTdlMessageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_MESSAGE_RESULT__TDL_MESSAGE_ID, oldTdlMessageId, tdlMessageId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_MESSAGE_RESULT__VALUE, oldValue, value));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TDLTestReportPackage.TEST_MESSAGE_RESULT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__MESSAGE:
				if (resolve) return getMessage();
				return basicGetMessage();
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__TDL_MESSAGE_ID:
				return getTdlMessageId();
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__VALUE:
				return getValue();
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__DESCRIPTION:
				return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__MESSAGE:
				setMessage((Message)newValue);
				return;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__TDL_MESSAGE_ID:
				setTdlMessageId((String)newValue);
				return;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__VALUE:
				setValue((Verdicts)newValue);
				return;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__DESCRIPTION:
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
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__MESSAGE:
				setMessage((Message)null);
				return;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__TDL_MESSAGE_ID:
				setTdlMessageId(TDL_MESSAGE_ID_EDEFAULT);
				return;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__DESCRIPTION:
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
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__MESSAGE:
				return message != null;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__TDL_MESSAGE_ID:
				return TDL_MESSAGE_ID_EDEFAULT == null ? tdlMessageId != null : !TDL_MESSAGE_ID_EDEFAULT.equals(tdlMessageId);
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__VALUE:
				return value != VALUE_EDEFAULT;
			case TDLTestReportPackage.TEST_MESSAGE_RESULT__DESCRIPTION:
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
		result.append(" (tdlMessageId: ");
		result.append(tdlMessageId);
		result.append(", value: ");
		result.append(value);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //TestMessageResultImpl
