/**
 */
package uMiniJavaDynamicData;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.LongValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ULong Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uMiniJavaDynamicData.ULongValue#getVariance <em>Variance</em>}</li>
 * </ul>
 *
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getULongValue()
 * @model
 * @generated
 */
public interface ULongValue extends LongValue {
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
	 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getULongValue_Variance()
	 * @model
	 * @generated
	 */
	double getVariance();

	/**
	 * Sets the value of the '{@link uMiniJavaDynamicData.ULongValue#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(double value);

} // ULongValue
