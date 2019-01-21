package duc.uscript.typing

import duc.uscript.uScript.UScriptFactory

class InternalTypeDcl {
	protected static val FACTORY = UScriptFactory.eINSTANCE
	
	public static val STRING_TYPE = FACTORY.createClass => [name = 'stringType']
	public static val CHAR_TYPE = FACTORY.createClass => [name = 'charType']
	public static val BOOLEAN_TYPE = FACTORY.createClass => [name = 'booleanType']
	
	public static val NUMERIC_TYPE = FACTORY.createClass => [name = 'numericType']
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
		
	]
	public static val GAUSSIAN_FLOAT_TYPE = FACTORY.createClass => [
		name = 'gaussianFloatType'
		superClass = GAUSSIAN_DOUBLE_TYPE
	]
	
	public static val RAYLEIGH_TYPE = FACTORY.createClass => [
		name = 'rayleighType'
		superClass = UNCERTAIN_NUMERIC_TYPE
	]
		
	public static val RAYLEIGH_DOUBLE_TYPE = FACTORY.createClass => [
		name = 'rayleighDoubleType'
		superClass = RAYLEIGH_TYPE
	]
	public static val RAYLEIGH_FLOAT_TYPE = FACTORY.createClass => [
		name = 'rayleighFloatType'
		superClass = RAYLEIGH_DOUBLE_TYPE
	]
	
	public static val BINOMIAL_TYPE = FACTORY.createClass => [
		name = 'binomialType'
		superClass = UNCERTAIN_NUMERIC_TYPE
	]
	
	public static val BINOMIAL_LONG_TYPE = FACTORY.createClass => [
		name = 'binomialLongType'
		superClass = BINOMIAL_TYPE
	]
	public static val BINOMIAL_INT_TYPE = FACTORY.createClass => [
		name = 'binomialIntType'
		superClass = BINOMIAL_LONG_TYPE
	]
	public static val BINOMIAL_SHORT_TYPE = FACTORY.createClass => [
		name = 'binomialShortType'
		superClass = BINOMIAL_INT_TYPE
	]
	public static val BINOMIAL_BYTE_TYPE = FACTORY.createClass => [
		name = 'binomialByteType'
		superClass = BINOMIAL_SHORT_TYPE
	]
	
	public static val DIRAC_TYPE = FACTORY.createClass => [
		name = 'diracType'
		superClass = UNCERTAIN_NUMERIC_TYPE
	]
	
	public static val DIRAC_LONG_TYPE = FACTORY.createClass => [
		name = 'diracLongType'
		superClass = DIRAC_TYPE
	]
	public static val DIRAC_INT_TYPE = FACTORY.createClass => [
		name = 'diracIntType'
		superClass = DIRAC_LONG_TYPE
	]
	public static val DIRAC_SHORT_TYPE = FACTORY.createClass => [
		name = 'diracShortType'
		superClass = DIRAC_INT_TYPE
	]
	public static val DIRAC_BYTE_TYPE = FACTORY.createClass => [
		name = 'diracByteType'
		superClass = DIRAC_SHORT_TYPE
	]
	
	public static val DIRAC_DOUBLE_TYPE = FACTORY.createClass => [
		name = 'diracDoubleType'
		superClass = DIRAC_TYPE
	]
	public static val DIRAC_FLOAT_TYPE = FACTORY.createClass => [
		name = 'diracFloatType'
		superClass = DIRAC_DOUBLE_TYPE
	]
	
	public static val UNRECOGNIZED_TYPE = FACTORY.createClass => [name = 'unrecognizedType']
}