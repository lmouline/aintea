/**
 */
package uMiniJavaDynamicData;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage
 * @generated
 */
public interface UMiniJavaDynamicDataFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UMiniJavaDynamicDataFactory eINSTANCE = uMiniJavaDynamicData.impl.UMiniJavaDynamicDataFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>UBoolean Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UBoolean Value</em>'.
	 * @generated
	 */
	UBooleanValue createUBooleanValue();

	/**
	 * Returns a new object of class '<em>UInteger Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UInteger Value</em>'.
	 * @generated
	 */
	UIntegerValue createUIntegerValue();

	/**
	 * Returns a new object of class '<em>UDouble Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UDouble Value</em>'.
	 * @generated
	 */
	UDoubleValue createUDoubleValue();

	/**
	 * Returns a new object of class '<em>ULong Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ULong Value</em>'.
	 * @generated
	 */
	ULongValue createULongValue();

	/**
	 * Returns a new object of class '<em>UShort Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UShort Value</em>'.
	 * @generated
	 */
	UShortValue createUShortValue();

	/**
	 * Returns a new object of class '<em>UByte Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UByte Value</em>'.
	 * @generated
	 */
	UByteValue createUByteValue();

	/**
	 * Returns a new object of class '<em>UFloat Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UFloat Value</em>'.
	 * @generated
	 */
	UFloatValue createUFloatValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UMiniJavaDynamicDataPackage getUMiniJavaDynamicDataPackage();

} //UMiniJavaDynamicDataFactory
