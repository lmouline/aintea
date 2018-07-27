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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UMiniJavaDynamicDataPackage getUMiniJavaDynamicDataPackage();

} //UMiniJavaDynamicDataFactory
