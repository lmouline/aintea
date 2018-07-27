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
	 * The meta object id for the '{@link uMiniJavaDynamicData.impl.UIntegerValueImpl <em>UInteger Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uMiniJavaDynamicData.impl.UIntegerValueImpl
	 * @see uMiniJavaDynamicData.impl.UMiniJavaDynamicDataPackageImpl#getUIntegerValue()
	 * @generated
	 */
	int UINTEGER_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINTEGER_VALUE__VALUE = MinijavadynamicdataPackage.INTEGER_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINTEGER_VALUE__VARIANCE = MinijavadynamicdataPackage.INTEGER_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UInteger Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINTEGER_VALUE_FEATURE_COUNT = MinijavadynamicdataPackage.INTEGER_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>UInteger Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINTEGER_VALUE_OPERATION_COUNT = MinijavadynamicdataPackage.INTEGER_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uMiniJavaDynamicData.impl.UDoubleValueImpl <em>UDouble Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uMiniJavaDynamicData.impl.UDoubleValueImpl
	 * @see uMiniJavaDynamicData.impl.UMiniJavaDynamicDataPackageImpl#getUDoubleValue()
	 * @generated
	 */
	int UDOUBLE_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UDOUBLE_VALUE__VALUE = MinijavadynamicdataPackage.DOUBLE_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UDOUBLE_VALUE__VARIANCE = MinijavadynamicdataPackage.DOUBLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UDouble Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UDOUBLE_VALUE_FEATURE_COUNT = MinijavadynamicdataPackage.DOUBLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>UDouble Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UDOUBLE_VALUE_OPERATION_COUNT = MinijavadynamicdataPackage.DOUBLE_VALUE_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link uMiniJavaDynamicData.UIntegerValue <em>UInteger Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UInteger Value</em>'.
	 * @see uMiniJavaDynamicData.UIntegerValue
	 * @generated
	 */
	EClass getUIntegerValue();

	/**
	 * Returns the meta object for the attribute '{@link uMiniJavaDynamicData.UIntegerValue#getVariance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variance</em>'.
	 * @see uMiniJavaDynamicData.UIntegerValue#getVariance()
	 * @see #getUIntegerValue()
	 * @generated
	 */
	EAttribute getUIntegerValue_Variance();

	/**
	 * Returns the meta object for class '{@link uMiniJavaDynamicData.UDoubleValue <em>UDouble Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UDouble Value</em>'.
	 * @see uMiniJavaDynamicData.UDoubleValue
	 * @generated
	 */
	EClass getUDoubleValue();

	/**
	 * Returns the meta object for the attribute '{@link uMiniJavaDynamicData.UDoubleValue#getVariance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variance</em>'.
	 * @see uMiniJavaDynamicData.UDoubleValue#getVariance()
	 * @see #getUDoubleValue()
	 * @generated
	 */
	EAttribute getUDoubleValue_Variance();

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
		/**
		 * The meta object literal for the '{@link uMiniJavaDynamicData.impl.UIntegerValueImpl <em>UInteger Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uMiniJavaDynamicData.impl.UIntegerValueImpl
		 * @see uMiniJavaDynamicData.impl.UMiniJavaDynamicDataPackageImpl#getUIntegerValue()
		 * @generated
		 */
		EClass UINTEGER_VALUE = eINSTANCE.getUIntegerValue();
		/**
		 * The meta object literal for the '<em><b>Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UINTEGER_VALUE__VARIANCE = eINSTANCE.getUIntegerValue_Variance();
		/**
		 * The meta object literal for the '{@link uMiniJavaDynamicData.impl.UDoubleValueImpl <em>UDouble Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uMiniJavaDynamicData.impl.UDoubleValueImpl
		 * @see uMiniJavaDynamicData.impl.UMiniJavaDynamicDataPackageImpl#getUDoubleValue()
		 * @generated
		 */
		EClass UDOUBLE_VALUE = eINSTANCE.getUDoubleValue();
		/**
		 * The meta object literal for the '<em><b>Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UDOUBLE_VALUE__VARIANCE = eINSTANCE.getUDoubleValue_Variance();

	}

} //UMiniJavaDynamicDataPackage
