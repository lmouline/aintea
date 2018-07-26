/**
 */
package uMiniJavaDynamicData;

import duc.uminijava.uMiniJava.UTypeRef;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UObject Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uMiniJavaDynamicData.UObjectInstance#getUType <em>UType</em>}</li>
 * </ul>
 *
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getUObjectInstance()
 * @model
 * @generated
 */
public interface UObjectInstance extends ObjectInstance {
	/**
	 * Returns the value of the '<em><b>UType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UType</em>' reference.
	 * @see #setUType(UTypeRef)
	 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#getUObjectInstance_UType()
	 * @model required="true"
	 * @generated
	 */
	UTypeRef getUType();

	/**
	 * Sets the value of the '{@link uMiniJavaDynamicData.UObjectInstance#getUType <em>UType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UType</em>' reference.
	 * @see #getUType()
	 * @generated
	 */
	void setUType(UTypeRef value);

} // UObjectInstance
