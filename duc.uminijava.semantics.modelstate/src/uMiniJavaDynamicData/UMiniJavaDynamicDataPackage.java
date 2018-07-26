/**
 */
package uMiniJavaDynamicData;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataFactory
 * @model kind="package"
 * @generated
 */
public interface UMiniJavaDynamicDataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uMiniJavaDynamicData";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uminijava.duc/UMiniJavaDynamicData";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uMiniJavaDynamicData";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UMiniJavaDynamicDataPackage eINSTANCE = uMiniJavaDynamicData.impl.UMiniJavaDynamicDataPackageImpl.init();

	/**
	 * The meta object id for the '{@link uMiniJavaDynamicData.impl.UBooleanValueImpl <em>UBoolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uMiniJavaDynamicData.impl.UBooleanValueImpl
	 * @see uMiniJavaDynamicData.impl.UMiniJavaDynamicDataPackageImpl#getUBooleanValue()
	 * @generated
	 */
	int UBOOLEAN_VALUE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBOOLEAN_VALUE__VALUE = MinijavadynamicdataPackage.BOOLEAN_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBOOLEAN_VALUE__CONFIDENCE = MinijavadynamicdataPackage.BOOLEAN_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UBoolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBOOLEAN_VALUE_FEATURE_COUNT = MinijavadynamicdataPackage.BOOLEAN_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>UBoolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UBOOLEAN_VALUE_OPERATION_COUNT = MinijavadynamicdataPackage.BOOLEAN_VALUE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link uMiniJavaDynamicData.UBooleanValue <em>UBoolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UBoolean Value</em>'.
	 * @see uMiniJavaDynamicData.UBooleanValue
	 * @generated
	 */
	EClass getUBooleanValue();

	/**
	 * Returns the meta object for the attribute '{@link uMiniJavaDynamicData.UBooleanValue#getConfidence <em>Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidence</em>'.
	 * @see uMiniJavaDynamicData.UBooleanValue#getConfidence()
	 * @see #getUBooleanValue()
	 * @generated
	 */
	EAttribute getUBooleanValue_Confidence();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UMiniJavaDynamicDataFactory getUMiniJavaDynamicDataFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link uMiniJavaDynamicData.impl.UBooleanValueImpl <em>UBoolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uMiniJavaDynamicData.impl.UBooleanValueImpl
		 * @see uMiniJavaDynamicData.impl.UMiniJavaDynamicDataPackageImpl#getUBooleanValue()
		 * @generated
		 */
		EClass UBOOLEAN_VALUE = eINSTANCE.getUBooleanValue();
		/**
		 * The meta object literal for the '<em><b>Confidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UBOOLEAN_VALUE__CONFIDENCE = eINSTANCE.getUBooleanValue_Confidence();

	}

} //UMiniJavaDynamicDataPackage
