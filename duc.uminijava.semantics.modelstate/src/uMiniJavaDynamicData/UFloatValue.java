/**
 */
package uMiniJavaDynamicData;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.FloatValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UFloat Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uMiniJavaDynamicData.UFloatValue#getVariance <em>Variance</em>}</li>
 * </ul>
 *
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getUFloatValue()
 * @model
 * @generated
 */
public interface UFloatValue extends FloatValue {
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
	 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getUFloatValue_Variance()
	 * @model
	 * @generated
	 */
	double getVariance();

	/**
	 * Sets the value of the '{@link uMiniJavaDynamicData.UFloatValue#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(double value);

} // UFloatValue
