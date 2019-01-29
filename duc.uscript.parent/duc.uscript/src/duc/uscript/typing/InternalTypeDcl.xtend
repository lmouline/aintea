package duc.uscript.typing

import duc.uscript.uScript.UScriptFactory
import org.eclipse.emf.ecore.resource.Resource
import duc.uscript.uScript.Program

class InternalTypeDcl {
	static boolean hasBeenInit = false
	
	def static init(Resource r) {
		if(hasBeenInit) {
			return;
		}
		
		val root = r.contents.get(0)
		if(root !== null) {
			val prog = root as Program
			hasBeenInit = true
			
			prog.elements.addAll(PRIMITIVE_TYPE, STRING_TYPE, CHAR_TYPE, BOOLEAN_TYPE, 
				NUMERIC_TYPE, LONG_TYPE, INT_TYPE, SHORT_TYPE, BYTE_TYPE, DOUBLE_TYPE, FLOAT_TYPE,
				ARRAY_TYPE, STRING_ARRAY_TYPE, CHAR_ARRAY_TYPE, BOOLEAN_ARRAY_TYPE, LONG_ARRAY_TYPE,
				INT_ARRAY_TYPE, SHORT_ARRAY_TYPE, BYTE_ARRAY_TYPE, DOUBLE_ARRAY_TYPE, FLOAT_ARRAY_TYPE,
				NULL_TYPE, UNCERTAIN_TYPE, BERNOULLI_TYPE, BERNOULLI_BOOL_TYPE, UNCERTAIN_NUMERIC_TYPE, 
				GAUSSIAN_TYPE, GAUSSIAN_DOUBLE_TYPE, GAUSSIAN_FLOAT_TYPE, RAYLEIGH_TYPE, RAYLEIGH_DOUBLE_TYPE,
				RAYLEIGH_FLOAT_TYPE, BINOMIAL_TYPE, BINOMIAL_BYTE_TYPE, BINOMIAL_SHORT_TYPE, BINOMIAL_INT_TYPE,
				BINOMIAL_LONG_TYPE, DIRAC_TYPE, DIRAC_BYTE_TYPE, DIRAC_SHORT_TYPE, DIRAC_INT_TYPE,
				DIRAC_LONG_TYPE, DIRAC_DOUBLE_TYPE, DIRAC_FLOAT_TYPE
			)
		}
	}
	
	protected static val FACTORY = UScriptFactory.eINSTANCE
	
	public static val PRIMITIVE_TYPE = FACTORY.createClass => [name = 'primitiveType']
	
	public static val STRING_TYPE = FACTORY.createClass => [
		name = 'stringType'
		superClass = PRIMITIVE_TYPE
	]
	public static val CHAR_TYPE = FACTORY.createClass => [
		name = 'charType'
		superClass = PRIMITIVE_TYPE
	]
	public static val BOOLEAN_TYPE = FACTORY.createClass => [
		name = 'booleanType'
		superClass = PRIMITIVE_TYPE
	]
	
	public static val NUMERIC_TYPE = FACTORY.createClass => [
		name = 'numericType'
		superClass = PRIMITIVE_TYPE
	]
	public static val LONG_TYPE = FACTORY.createClass => [
		name = 'longType'
		superClass = NUMERIC_TYPE
	]
	public static val INT_TYPE = FACTORY.createClass => [
		name = 'intType'
		superClass = LONG_TYPE
	]
	public static val SHORT_TYPE = FACTORY.createClass => [
		name = 'shortType'
		superClass = INT_TYPE
	]
	public static val BYTE_TYPE = FACTORY.createClass => [
		name = 'byteType'
		superClass = SHORT_TYPE
	]
	
	public static val DOUBLE_TYPE = FACTORY.createClass => [
		name = 'doubleType'
		superClass = NUMERIC_TYPE
	]
	public static val FLOAT_TYPE = FACTORY.createClass => [
		name = 'floatType'
		superClass = DOUBLE_TYPE
	]
	
	public static val ARRAY_TYPE = FACTORY.createClass => [name = 'arrayType']
	public static val STRING_ARRAY_TYPE = FACTORY.createClass => [name = 'stringArrayType']
	public static val INT_ARRAY_TYPE = FACTORY.createClass => [name = 'intArrayType']
	public static val BOOLEAN_ARRAY_TYPE = FACTORY.createClass => [name = 'booleanArrayType']
	public static val BYTE_ARRAY_TYPE = FACTORY.createClass => [name = 'byteArrayType']
	public static val LONG_ARRAY_TYPE = FACTORY.createClass => [name = 'longArrayType']
	public static val DOUBLE_ARRAY_TYPE = FACTORY.createClass => [name = 'doubleArrayType']
	public static val SHORT_ARRAY_TYPE = FACTORY.createClass => [name = 'shortArrayType']
	public static val FLOAT_ARRAY_TYPE = FACTORY.createClass => [name = 'floatArrayType']
	public static val CHAR_ARRAY_TYPE = FACTORY.createClass => [name = 'charArrayType']
	
	public static val NULL_TYPE = FACTORY.createClass => [name = 'nullType']
	
	
	
	public static val UNCERTAIN_TYPE = FACTORY.createClass => [
		name = 'uncertainType'
	]

	public static val BERNOULLI_TYPE = FACTORY.createClass => [
		name = 'bernoulliType'
		superClass = UNCERTAIN_TYPE
	]
	
	public static val BERNOULLI_BOOL_TYPE = FACTORY.createClass => [
		name = 'bernoulliBoolType'
		superClass = BERNOULLI_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createBooleanTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createBernoulliRef()
		])
	]
	
	
	public static val UNCERTAIN_NUMERIC_TYPE = FACTORY.createClass => [
		name = 'uncertainNumericType'
		superClass = UNCERTAIN_TYPE
	]
	
	public static val GAUSSIAN_TYPE = FACTORY.createClass => [
		name = 'gaussianType'
		superClass = UNCERTAIN_NUMERIC_TYPE
	]
		
	public static val GAUSSIAN_DOUBLE_TYPE = FACTORY.createClass => [
		name = 'gaussianDoubleType'
		superClass = GAUSSIAN_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createDoubleTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createGaussianRef()
		])
		
	]
	
	public static val GAUSSIAN_FLOAT_TYPE = FACTORY.createClass => [
		name = 'gaussianFloatType'
		superClass = GAUSSIAN_DOUBLE_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createFloatTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createGaussianRef()
		])
	]
	
	public static val RAYLEIGH_TYPE = FACTORY.createClass => [
		name = 'rayleighType'
		superClass = UNCERTAIN_NUMERIC_TYPE
	]
		
	public static val RAYLEIGH_DOUBLE_TYPE = FACTORY.createClass => [
		name = 'rayleighDoubleType'
		superClass = RAYLEIGH_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createDoubleTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createRayleighRef()
		])
	]
	
	public static val RAYLEIGH_FLOAT_TYPE = FACTORY.createClass => [
		name = 'rayleighFloatType'
		superClass = RAYLEIGH_DOUBLE_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createFloatTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createRayleighRef()
		])
	]
	
	public static val BINOMIAL_TYPE = FACTORY.createClass => [
		name = 'binomialType'
		superClass = UNCERTAIN_NUMERIC_TYPE
	]
	
	public static val BINOMIAL_LONG_TYPE = FACTORY.createClass => [
		name = 'binomialLongType'
		superClass = BINOMIAL_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createLongTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createBinomialRef()
		])
	]
	
	public static val BINOMIAL_INT_TYPE = FACTORY.createClass => [
		name = 'binomialIntType'
		superClass = BINOMIAL_LONG_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createIntegerTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createBinomialRef()
		])
	]
	
	public static val BINOMIAL_SHORT_TYPE = FACTORY.createClass => [
		name = 'binomialShortType'
		superClass = BINOMIAL_INT_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createShortTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createBinomialRef()
		])
	]
	
	public static val BINOMIAL_BYTE_TYPE = FACTORY.createClass => [
		name = 'binomialByteType'
		superClass = BINOMIAL_SHORT_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createByteTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createBinomialRef()
		])
	]
	
	public static val DIRAC_TYPE = FACTORY.createClass => [
		name = 'diracType'
		superClass = UNCERTAIN_NUMERIC_TYPE
	]
	
	public static val DIRAC_LONG_TYPE = FACTORY.createClass => [
		name = 'diracLongType'
		superClass = DIRAC_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createLongTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createDiracRef()
		])
	]
	
	public static val DIRAC_INT_TYPE = FACTORY.createClass => [
		name = 'diracIntType'
		superClass = DIRAC_LONG_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createIntegerTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createDiracRef()
		])
	]
	
	public static val DIRAC_SHORT_TYPE = FACTORY.createClass => [
		name = 'diracShortType'
		superClass = DIRAC_INT_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createShortTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createDiracRef()
		])
	]
	
	public static val DIRAC_BYTE_TYPE = FACTORY.createClass => [
		name = 'diracByteType'
		superClass = DIRAC_SHORT_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createByteTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createDiracRef()
		])
	]
	
	public static val DIRAC_DOUBLE_TYPE = FACTORY.createClass => [
		name = 'diracDoubleType'
		superClass = DIRAC_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createDoubleTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createDiracRef()
		])
	]
	
	public static val DIRAC_FLOAT_TYPE = FACTORY.createClass => [
		name = 'diracFloatType'
		superClass = DIRAC_DOUBLE_TYPE
		
		members.add(FACTORY.createField => [
			name= "value"
			typeRef= FACTORY.createFloatTypeRef()
		])
		
		members.add(FACTORY.createField => [
			name= "confidence"
			typeRef= FACTORY.createDiracRef()
		])
	]
	
}