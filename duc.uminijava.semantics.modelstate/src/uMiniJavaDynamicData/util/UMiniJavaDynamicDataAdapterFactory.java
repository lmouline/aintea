/**
 */
package uMiniJavaDynamicData.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ByteValue;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.FloatValue;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.LongValue;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ShortValue;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value;
import uMiniJavaDynamicData.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage
 * @generated
 */
public class UMiniJavaDynamicDataAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMiniJavaDynamicDataPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMiniJavaDynamicDataAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UMiniJavaDynamicDataPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMiniJavaDynamicDataSwitch<Adapter> modelSwitch =
		new UMiniJavaDynamicDataSwitch<Adapter>() {
			@Override
			public Adapter caseUBooleanValue(UBooleanValue object) {
				return createUBooleanValueAdapter();
			}
			@Override
			public Adapter caseUIntegerValue(UIntegerValue object) {
				return createUIntegerValueAdapter();
			}
			@Override
			public Adapter caseUDoubleValue(UDoubleValue object) {
				return createUDoubleValueAdapter();
			}
			@Override
			public Adapter caseULongValue(ULongValue object) {
				return createULongValueAdapter();
			}
			@Override
			public Adapter caseUShortValue(UShortValue object) {
				return createUShortValueAdapter();
			}
			@Override
			public Adapter caseUByteValue(UByteValue object) {
				return createUByteValueAdapter();
			}
			@Override
			public Adapter caseUFloatValue(UFloatValue object) {
				return createUFloatValueAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter caseBooleanValue(BooleanValue object) {
				return createBooleanValueAdapter();
			}
			@Override
			public Adapter caseIntegerValue(IntegerValue object) {
				return createIntegerValueAdapter();
			}
			@Override
			public Adapter caseDoubleValue(DoubleValue object) {
				return createDoubleValueAdapter();
			}
			@Override
			public Adapter caseLongValue(LongValue object) {
				return createLongValueAdapter();
			}
			@Override
			public Adapter caseShortValue(ShortValue object) {
				return createShortValueAdapter();
			}
			@Override
			public Adapter caseByteValue(ByteValue object) {
				return createByteValueAdapter();
			}
			@Override
			public Adapter caseFloatValue(FloatValue object) {
				return createFloatValueAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link uMiniJavaDynamicData.UBooleanValue <em>UBoolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uMiniJavaDynamicData.UBooleanValue
	 * @generated
	 */
	public Adapter createUBooleanValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uMiniJavaDynamicData.UIntegerValue <em>UInteger Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uMiniJavaDynamicData.UIntegerValue
	 * @generated
	 */
	public Adapter createUIntegerValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uMiniJavaDynamicData.UDoubleValue <em>UDouble Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uMiniJavaDynamicData.UDoubleValue
	 * @generated
	 */
	public Adapter createUDoubleValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uMiniJavaDynamicData.ULongValue <em>ULong Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uMiniJavaDynamicData.ULongValue
	 * @generated
	 */
	public Adapter createULongValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uMiniJavaDynamicData.UShortValue <em>UShort Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uMiniJavaDynamicData.UShortValue
	 * @generated
	 */
	public Adapter createUShortValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uMiniJavaDynamicData.UByteValue <em>UByte Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uMiniJavaDynamicData.UByteValue
	 * @generated
	 */
	public Adapter createUByteValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uMiniJavaDynamicData.UFloatValue <em>UFloat Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uMiniJavaDynamicData.UFloatValue
	 * @generated
	 */
	public Adapter createUFloatValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
	 * @generated
	 */
	public Adapter createBooleanValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
	 * @generated
	 */
	public Adapter createIntegerValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue <em>Double Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
	 * @generated
	 */
	public Adapter createDoubleValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.LongValue <em>Long Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.LongValue
	 * @generated
	 */
	public Adapter createLongValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.ShortValue <em>Short Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.ShortValue
	 * @generated
	 */
	public Adapter createShortValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.ByteValue <em>Byte Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.ByteValue
	 * @generated
	 */
	public Adapter createByteValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.FloatValue <em>Float Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.FloatValue
	 * @generated
	 */
	public Adapter createFloatValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UMiniJavaDynamicDataAdapterFactory
