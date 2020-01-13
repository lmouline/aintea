package duc.uscript.typing

import com.google.inject.Inject
import duc.uscript.scoping.UScriptIndex
import org.eclipse.emf.ecore.EObject
import duc.uscript.uScript.Class
import duc.uscript.uScript.UTypeRef
import duc.uscript.uScript.GaussianRef
import duc.uscript.uScript.RayleighRef
import duc.uscript.uScript.BinomialRef
import duc.uscript.uScript.DiracRef
import duc.uscript.uScript.BernoulliRef

class InternalTypeDcl {
	@Inject extension UScriptIndex
	
	public static final String LIB_PACK = "aintea.lang"
	
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
	public static final String USR_DEF_ARRAY_TYPE = LIB_PACK + ".UsrDefArray"
	
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
	
	public static final String DIRAC_TYPE = LIB_PACK + ".DiracDeltaFunctionType"
	public static final String DIRAC_LONG_TYPE = LIB_PACK + ".DiracDeltaFunctionLong"
	public static final String DIRAC_INT_TYPE = LIB_PACK + ".DiracDeltaFunctionInt"
	public static final String DIRAC_SHORT_TYPE = LIB_PACK + ".DiracDeltaFunctionShort"
	public static final String DIRAC_BYTE_TYPE = LIB_PACK + ".DiracDeltaFunctionByte"
	public static final String DIRAC_DOUBLE_TYPE = LIB_PACK + ".DiracDeltaFunctionDouble"
	public static final String DIRAC_FLOAT_TYPE = LIB_PACK + ".DiracDeltaFunctionFloat"
	
	public static final String MULTPOSS_TYPE = LIB_PACK + ".MultPossibilitiesType"
	public static final String MULTPOSS_BYTE_TYPE = LIB_PACK + ".MultPossibilitiesByte"
	public static final String MULTPOSS_SHORT_TYPE = LIB_PACK + ".MultPossibilitiesShort"
	public static final String MULTPOSS_INT_TYPE = LIB_PACK + ".MultPossibilitiesInt"
	public static final String MULTPOSS_LONG_TYPE = LIB_PACK + ".MultPossibilitiesLong"
	public static final String MULTPOSS_FLOAT_TYPE = LIB_PACK + ".MultPossibilitiesFloat"
	public static final String MULTPOSS_DOUBLE_TYPE = LIB_PACK + ".MultPossibilitiesDouble"

	public static final String POSSIBILITY_TYPE = LIB_PACK + ".Possibility"
	public static final String POSSIBILITY_BYTE_TYPE = LIB_PACK + ".BytePossibility"
	public static final String POSSIBILITY_SHORT_TYPE = LIB_PACK + ".ShortPossibility"
	public static final String POSSIBILITY_INT_TYPE = LIB_PACK + ".IntPossibility"
	public static final String POSSIBILITY_LONG_TYPE = LIB_PACK + ".LongPossibility"
	public static final String POSSIBILITY_FLOAT_TYPE = LIB_PACK + ".FloatPossibility"
	public static final String POSSIBILITY_DOUBLE_TYPE = LIB_PACK + ".DoublePossibility"
	
	
	
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
		return ctx.getClassFromFqn(BINOMIAL_BYTE_TYPE)
	}
	
	// Multiple possibilities
	def Class getMultChoiceClass(EObject ctx) {
		return ctx.getClassFromFqn(MULTPOSS_TYPE)
	}
	
	def Class getMultChoiceByteClass(EObject ctx) {
		return ctx.getClassFromFqn(MULTPOSS_BYTE_TYPE)
	}
	
	def Class getMultChoiceShortClass(EObject ctx) {
		return ctx.getClassFromFqn(MULTPOSS_SHORT_TYPE)
	}
	
	def Class getMultChoiceIntClass(EObject ctx) {
		return ctx.getClassFromFqn(MULTPOSS_INT_TYPE)
	}
	
	def Class getMultChoiceLongClass(EObject ctx) {
		return ctx.getClassFromFqn(MULTPOSS_LONG_TYPE)
	}
	
	def Class getMultChoiceFloatClass(EObject ctx) {
		return ctx.getClassFromFqn(MULTPOSS_FLOAT_TYPE)
	}
	
	def Class getMultChoiceDoubleClass(EObject ctx) {
		return ctx.getClassFromFqn(MULTPOSS_DOUBLE_TYPE)
	}
	
	// Possibilities
	def Class getPossibilityClass(EObject ctx) {
		return ctx.getClassFromFqn(POSSIBILITY_TYPE)
	}
	
	def Class getDoublePossibilityClass(EObject ctx) {
		return ctx.getClassFromFqn(POSSIBILITY_DOUBLE_TYPE)
	}
	
	def Class getIntPossibilityClass(EObject ctx) {
		return ctx.getClassFromFqn(POSSIBILITY_INT_TYPE)
	}
	
	//
	
	def Class getArrayClass(EObject ctx) {
		return ctx.getClassFromFqn(ARRAY_TYPE)
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
	
	// Get distribution type
	def dispatch Class getDistType(UTypeRef uType) {
		throw new RuntimeException('''Not yet implemented for «uType»''')
	}
	
	def dispatch Class getDistType(GaussianRef uType) {
		return uType.gaussianDistClass
	}
	
	def dispatch Class getDistType(RayleighRef uType) {
		return uType.rayleighDistClass
	}
	
	def dispatch Class getDistType(BinomialRef uType) {
		return uType.binomialDistClass
	}
	
	def dispatch Class getDistType(DiracRef uType) {
		return uType.diracDistClass
	}
	
	def dispatch Class getDistType(BernoulliRef uType) {
		return uType.bernoulliDistClass
	}
	
	// Get utype
	def dispatch Class getUType(UTypeRef uType) {
		throw new RuntimeException('''Not yet implemented for «uType»''')
	}
	
	def dispatch Class getUType(GaussianRef uType) {
		return uType.gaussianClass
	}
	
	def dispatch Class getUType(RayleighRef uType) {
		return uType.rayleighClass
	}
	
	def dispatch Class getUType(BinomialRef uType) {
		return uType.binomialClass
	}
	
	def dispatch Class getUType(DiracRef uType) {
		return uType.diracClass
	}
	
	def dispatch Class getUType(BernoulliRef uType) {
		return uType.bernoulliClass
	}
				
}