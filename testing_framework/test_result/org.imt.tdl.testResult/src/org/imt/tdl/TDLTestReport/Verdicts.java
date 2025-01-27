/**
 */
package org.imt.tdl.TDLTestReport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Verdicts</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.imt.tdl.TDLTestReport.TDLTestReportPackage#getVerdicts()
 * @model
 * @generated
 */
public enum Verdicts implements Enumerator {
	/**
	 * The '<em><b>PASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASS_VALUE
	 * @generated
	 * @ordered
	 */
	PASS(0, "PASS", "PASS"),

	/**
	 * The '<em><b>FAIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAIL_VALUE
	 * @generated
	 * @ordered
	 */
	FAIL(1, "FAIL", "FAIL"),

	/**
	 * The '<em><b>INCONCLUSIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCONCLUSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	INCONCLUSIVE(2, "INCONCLUSIVE", "INCONCLUSIVE");

	/**
	 * The '<em><b>PASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PASS_VALUE = 0;

	/**
	 * The '<em><b>FAIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAIL_VALUE = 1;

	/**
	 * The '<em><b>INCONCLUSIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCONCLUSIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INCONCLUSIVE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Verdicts</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Verdicts[] VALUES_ARRAY =
		new Verdicts[] {
			PASS,
			FAIL,
			INCONCLUSIVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Verdicts</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Verdicts> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Verdicts</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Verdicts get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Verdicts result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Verdicts</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Verdicts getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Verdicts result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Verdicts</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Verdicts get(int value) {
		switch (value) {
			case PASS_VALUE: return PASS;
			case FAIL_VALUE: return FAIL;
			case INCONCLUSIVE_VALUE: return INCONCLUSIVE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Verdicts(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Verdicts
