package duc.uscript.typing

import com.google.inject.Inject
import duc.uscript.scoping.UScriptIndex
import org.eclipse.emf.ecore.EObject
import duc.uscript.uScript.Class

class InternalTypeDcl {
	@Inject extension UScriptIndex
	
	public static final String LIB_PACK = "uscript.lang"
	
	public static final String PRIMITIVE_TYPE = LIB_PACK + ".Primitive"
	public static final String STRING_TYPE = LIB_PACK + ".String"
	public static final String CHAR_TYPE = LIB_PACK + ".Char"
	public static final String BOOL_TYPE = LIB_PACK + ".Boolean"
	public static final String NUMERIC_TYPE = LIB_PACK + ".Numeric"
	public static final String LONG_TYPE = LIB_PACK + ".Long"
	public static final String INT_TYPE = LIB_PACK + ".Int"
	public static final String SHORT_TYPE = LIB_PACK + ".Short"
	public static final String BYTE_TYPE = LIB_PACK + ".Byte"
	public static final String DOUBLE_TYPE = LIB_PACK + ".Double"
	public static final String FLOAT_TYPE = LIB_PACK + ".Float"
	
	public static final String ARRAY_TYPE = LIB_PACK + ".Array"
	public static final String STRING_ARRAY_TYPE = LIB_PACK + ".StringArray"
	public static final String CHAR_ARRAY_TYPE = LIB_PACK + ".CharArray"
	public static final String LONG_ARRAY_TYPE = LIB_PACK + ".LongArray"
	public static final String INT_ARRAY_TYPE = LIB_PACK + ".IntArray"
	public static final String SHORT_ARRAY_TYPE = LIB_PACK + ".ShortArray"
	public static final String BYTE_ARRAY_TYPE = LIB_PACK + ".ByteArray"
	public static final String DOUBLE_ARRAY_TYPE = LIB_PACK + ".DoubleArray"
	public static final String FLOAT_ARRAY_TYPE = LIB_PACK + ".FloatArray"
	public static final String BOOL_ARRAY_TYPE = LIB_PACK + ".BooleanArray"
	
	public static final String NULL_TYPE = LIB_PACK + ".Null"
	
	public static final String BERNOULLI_DIST_TYPE = LIB_PACK + ".BernoulliDist"
	public static final String GAUSSIAN_DIST_TYPE = LIB_PACK + ".GaussianDist"
	public static final String RAYLEIGH_DIST_TYPE = LIB_PACK + ".RayleighDist"
	public static final String BINOMIAL_DIST_TYPE = LIB_PACK + ".BinomialDist"
	public static final String DIRAC_DIST_TYPE = LIB_PACK + ".DiracDeltaFunction"
	
	public static final String UNCERTAIN_TYPE = LIB_PACK + ".UncertainType"
	
	public static final String BERNOULLI_TYPE = LIB_PACK + ".BernoulliType"
	public static final String BERNOULLI_BOOL_TYPE = LIB_PACK + ".BernoulliBool"
	
	public static final String UNCERTAIN_NUMERIC_TYPE = LIB_PACK + ".UncertainNumeric"
	
	public static final String GAUSSIAN_TYPE = LIB_PACK + ".GaussianType"
	public static final String GAUSSIAN_DOUBLE_TYPE = LIB_PACK + ".GaussianDouble"
	public static final String GAUSSIAN_FLOAT_TYPE = LIB_PACK + ".GaussianFloat"
	
	public static final String RAYLEIGH_TYPE = LIB_PACK + ".RayleighType"
	public static final String RAYLEIGH_DOUBLE_TYPE = LIB_PACK + ".RayleighDouble"
	public static final String RAYLEIGH_FLOAT_TYPE = LIB_PACK + ".RayleighFloat"
	
	public static final String BINOMIAL_TYPE = LIB_PACK + ".BinomialType"
	public static final String BINOMIAL_LONG_TYPE = LIB_PACK + ".BinomialLong"
	public static final String BINOMIAL_INT_TYPE = LIB_PACK + ".BinomialInt"
	public static final String BINOMIAL_SHORT_TYPE = LIB_PACK + ".BinomialShort"
	public static final String BINOMIAL_BYTE_TYPE = LIB_PACK + ".BinomialByte"
	
	public static final String DIRAC_TYPE = LIB_PACK + ".DiracType"
	public static final String DIRAC_LONG_TYPE = LIB_PACK + ".DiracLong"
	public static final String DIRAC_INT_TYPE = LIB_PACK + ".DiracInt"
	public static final String DIRAC_SHORT_TYPE = LIB_PACK + ".DiracShort"
	public static final String DIRAC_BYTE_TYPE = LIB_PACK + ".DiracByte"
	public static final String DIRAC_DOUBLE_TYPE = LIB_PACK + ".DiracDouble"
	public static final String DIRAC_FLOAT_TYPE = LIB_PACK + ".DiracFloat"
	
	def Class getStringClass(EObject ctx) {
		return ctx.getClassFromFqn(STRING_TYPE)
	}
	
	def Class getCharClass(EObject ctx) {
		return ctx.getClassFromFqn(CHAR_TYPE)
	}
	
	def Class getBoolClass(EObject ctx) {
		return ctx.getClassFromFqn(BOOL_TYPE)
	}
	
	def Class getLongClass(EObject ctx) {
		return ctx.getClassFromFqn(LONG_TYPE)
	}
	
	def Class getIntClass(EObject ctx) {
		return ctx.getClassFromFqn(INT_TYPE)
	}
	
	def Class getShortClass(EObject ctx) {
		return ctx.getClassFromFqn(SHORT_TYPE)
	}
	
	def Class getByteClass(EObject ctx) {
		return ctx.getClassFromFqn(BYTE_TYPE)
	}
	
	def Class getDoubleClass(EObject ctx) {
		return ctx.getClassFromFqn(DOUBLE_TYPE)
	}
	
	def Class getFloatClass(EObject ctx) {
		return ctx.getClassFromFqn(FLOAT_TYPE)
	}
	
	def Class getNullClass(EObject ctx) {
		return ctx.getClassFromFqn(NULL_TYPE)
	}
	
	def Class getBernoulliDistClass(EObject ctx) {
		return ctx.getClassFromFqn(BERNOULLI_DIST_TYPE)
	}
	
	def Class getBinomialDistClass(EObject ctx) {
		return ctx.getClassFromFqn(BINOMIAL_DIST_TYPE)
	}
	
	def Class getDiracDistClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_DIST_TYPE)
	}
	
	def Class getGaussianDistClass(EObject ctx) {
		return ctx.getClassFromFqn(GAUSSIAN_DIST_TYPE)
	}
	
	def Class getRayleighDistClass(EObject ctx) {
		return ctx.getClassFromFqn(RAYLEIGH_DIST_TYPE)
	}
	
	def Class getBernoulliClass(EObject ctx) {
		return ctx.getClassFromFqn(BERNOULLI_TYPE)
	}
	
	def Class getGaussianClass(EObject ctx) {
		return ctx.getClassFromFqn(GAUSSIAN_TYPE)
	}
	
	def Class getRayleighClass(EObject ctx) {
		return ctx.getClassFromFqn(RAYLEIGH_TYPE)
	}
	
	def Class getDiracClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_TYPE)
	}
	
	def Class getBinomialClass(EObject ctx) {
		return ctx.getClassFromFqn(BINOMIAL_TYPE)
	}
	
	def Class getBernoulliBoolClass(EObject ctx) {
		return ctx.getClassFromFqn(BERNOULLI_BOOL_TYPE)
	}
	
	def Class getGaussianDoubleClass(EObject ctx) {
		return ctx.getClassFromFqn(GAUSSIAN_DOUBLE_TYPE)
	}
	
	def Class getGaussianFloatClass(EObject ctx) {
		return ctx.getClassFromFqn(GAUSSIAN_FLOAT_TYPE)
	}
	
	def Class getRayleighDoubleClass(EObject ctx) {
		return ctx.getClassFromFqn(RAYLEIGH_DOUBLE_TYPE)
	}
	
	def Class getRayleighFloatClass(EObject ctx) {
		return ctx.getClassFromFqn(RAYLEIGH_FLOAT_TYPE)
	}
	
	def Class getDiracLongClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_LONG_TYPE)
	}
	
	def Class getDiracIntClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_INT_TYPE)
	}
	
	def Class getDiracShortClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_SHORT_TYPE)
	}
	
	def Class getDiracByteClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_BYTE_TYPE)
	}
	
	def Class getDiracDoubleClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_DOUBLE_TYPE)
	}
	
	def Class getDiracFloatClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_FLOAT_TYPE)
	}
	
	def Class getUncertainClass(EObject ctx) {
		return ctx.getClassFromFqn(UNCERTAIN_TYPE)
	}
	
	def Class getBinomialLongClass(EObject ctx) {
		return ctx.getClassFromFqn(BINOMIAL_LONG_TYPE)
	}
	
	def Class getBinomialIntClass(EObject ctx) {
		return ctx.getClassFromFqn(BINOMIAL_INT_TYPE)
	}
	
	def Class getBinomialShortClass(EObject ctx) {
		return ctx.getClassFromFqn(BINOMIAL_SHORT_TYPE)
	}
	
	def Class getBinomialByteClass(EObject ctx) {
		return ctx.getClassFromFqn(DIRAC_BYTE_TYPE)
	}
	
	def Class getLongArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(LONG_ARRAY_TYPE)
	}
	
	def Class getIntArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(INT_ARRAY_TYPE)
	}
	
	def Class getShortArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(SHORT_ARRAY_TYPE)
	}
	
	def Class getByteArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(BYTE_ARRAY_TYPE)
	}
	
	def Class getDoubleArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(DOUBLE_ARRAY_TYPE)
	}
	
	def Class getFloatArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(FLOAT_ARRAY_TYPE)
	}
	
	def Class getBoolArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(BOOL_ARRAY_TYPE)
	}
	
	def Class getStringArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(STRING_ARRAY_TYPE)
	}
	
	def Class getCharArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(CHAR_ARRAY_TYPE)
	}
	
	def Class getNumericClass(EObject ctx) {
		return ctx.getClassFromFqn(NUMERIC_TYPE)
	}
			
}