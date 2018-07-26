/**
 */
package uMiniJavaDynamicData.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uMiniJavaDynamicData.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMiniJavaDynamicDataFactoryImpl extends EFactoryImpl implements UMiniJavaDynamicDataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMiniJavaDynamicDataFactory init() {
		try {
			UMiniJavaDynamicDataFactory theUMiniJavaDynamicDataFactory = (UMiniJavaDynamicDataFactory)EPackage.Registry.INSTANCE.getEFactory(UMiniJavaDynamicDataPackage.eNS_URI);
			if (theUMiniJavaDynamicDataFactory != null) {
				return theUMiniJavaDynamicDataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UMiniJavaDynamicDataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMiniJavaDynamicDataFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UMiniJavaDynamicDataPackage.UBOOLEAN_VALUE: return createUBooleanValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UBooleanValue createUBooleanValue() {
		UBooleanValueImpl uBooleanValue = new UBooleanValueImpl();
		return uBooleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMiniJavaDynamicDataPackage getUMiniJavaDynamicDataPackage() {
		return (UMiniJavaDynamicDataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UMiniJavaDynamicDataPackage getPackage() {
		return UMiniJavaDynamicDataPackage.eINSTANCE;
	}

} //UMiniJavaDynamicDataFactoryImpl
