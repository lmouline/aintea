/**
 */
package uMiniJavaDynamicData;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UBoolean Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uMiniJavaDynamicData.UBooleanValue#getConfidence <em>Confidence</em>}</li>
 * </ul>
 *
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getUBooleanValue()
 * @model
 * @generated
 */
public interface UBooleanValue extends BooleanValue {

	/**
	 * Returns the value of the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence</em>' attribute.
	 * @see #setConfidence(double)
	 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getUBooleanValue_Confidence()
	 * @model
	 * @generated
	 */
	double getConfidence();

	/**
	 * Sets the value of the '{@link uMiniJavaDynamicData.UBooleanValue#getConfidence <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence</em>' attribute.
	 * @see #getConfidence()
	 * @generated
	 */
	void setConfidence(double value);
} // UBooleanValue
