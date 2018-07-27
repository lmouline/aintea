/**
 */
package uMiniJavaDynamicData.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataPackage;
import org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage;

import uMiniJavaDynamicData.UBooleanValue;
import uMiniJavaDynamicData.UDoubleValue;
import uMiniJavaDynamicData.UIntegerValue;
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory;
import uMiniJavaDynamicData.UMiniJavaDynamicDataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMiniJavaDynamicDataPackageImpl extends EPackageImpl implements UMiniJavaDynamicDataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uBooleanValueEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uIntegerValueEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uDoubleValueEClass = null;
	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see uMiniJavaDynamicData.UMiniJavaDynamicDataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMiniJavaDynamicDataPackageImpl() {
		super(eNS_URI, UMiniJavaDynamicDataFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link UMiniJavaDynamicDataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UMiniJavaDynamicDataPackage init() {
		if (isInited) return (UMiniJavaDynamicDataPackage)EPackage.Registry.INSTANCE.getEPackage(UMiniJavaDynamicDataPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUMiniJavaDynamicDataPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UMiniJavaDynamicDataPackageImpl theUMiniJavaDynamicDataPackage = registeredUMiniJavaDynamicDataPackage instanceof UMiniJavaDynamicDataPackageImpl ? (UMiniJavaDynamicDataPackageImpl)registeredUMiniJavaDynamicDataPackage : new UMiniJavaDynamicDataPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		MiniJavaPackage.eINSTANCE.eClass();
		MinijavadynamicdataPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUMiniJavaDynamicDataPackage.createPackageContents();

		// Initialize created meta-data
		theUMiniJavaDynamicDataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUMiniJavaDynamicDataPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMiniJavaDynamicDataPackage.eNS_URI, theUMiniJavaDynamicDataPackage);
		return theUMiniJavaDynamicDataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUBooleanValue() {
		return uBooleanValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUBooleanValue_Confidence() {
		return (EAttribute)uBooleanValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUIntegerValue() {
		return uIntegerValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUIntegerValue_Variance() {
		return (EAttribute)uIntegerValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUDoubleValue() {
		return uDoubleValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUDoubleValue_Variance() {
		return (EAttribute)uDoubleValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMiniJavaDynamicDataFactory getUMiniJavaDynamicDataFactory() {
		return (UMiniJavaDynamicDataFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		uBooleanValueEClass = createEClass(UBOOLEAN_VALUE);
		createEAttribute(uBooleanValueEClass, UBOOLEAN_VALUE__CONFIDENCE);

		uIntegerValueEClass = createEClass(UINTEGER_VALUE);
		createEAttribute(uIntegerValueEClass, UINTEGER_VALUE__VARIANCE);

		uDoubleValueEClass = createEClass(UDOUBLE_VALUE);
		createEAttribute(uDoubleValueEClass, UDOUBLE_VALUE__VARIANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MinijavadynamicdataPackage theMinijavadynamicdataPackage = (MinijavadynamicdataPackage)EPackage.Registry.INSTANCE.getEPackage(MinijavadynamicdataPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		uBooleanValueEClass.getESuperTypes().add(theMinijavadynamicdataPackage.getBooleanValue());
		uIntegerValueEClass.getESuperTypes().add(theMinijavadynamicdataPackage.getIntegerValue());
		uDoubleValueEClass.getESuperTypes().add(theMinijavadynamicdataPackage.getDoubleValue());

		// Initialize classes, features, and operations; add parameters
		initEClass(uBooleanValueEClass, UBooleanValue.class, "UBooleanValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUBooleanValue_Confidence(), ecorePackage.getEDouble(), "confidence", null, 0, 1, UBooleanValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uIntegerValueEClass, UIntegerValue.class, "UIntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUIntegerValue_Variance(), ecorePackage.getEDouble(), "variance", null, 0, 1, UIntegerValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uDoubleValueEClass, UDoubleValue.class, "UDoubleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUDoubleValue_Variance(), ecorePackage.getEDouble(), "variance", null, 0, 1, UDoubleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UMiniJavaDynamicDataPackageImpl
