/**
 */
package uMiniJavaDynamicData;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.ByteValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EByte Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uMiniJavaDynamicData.EByteValue#getVariance <em>Variance</em>}</li>
 * </ul>
 *
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getEByteValue()
 * @model
 * @generated
 */
public interface EByteValue extends ByteValue {
	/**
	 * Returns the value of the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variance</em>' attribute.
	 * @see #setVariance(double)
	 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getEByteValue_Variance()
	 * @model
	 * @generated
	 */
	double getVariance();

	/**
	 * Sets the value of the '{@link uMiniJavaDynamicData.EByteValue#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(double value);

} // EByteValue
