package duc.uscript.validation

import org.eclipse.xtext.validation.Check
import duc.uscript.uScript.BernoulliRef
import duc.uscript.uScript.BooleanTypeRef

import static extension duc.uscript.validation.TypeNameHelper.getSyntax
import duc.uscript.uScript.UScriptPackage
import duc.uscript.uScript.GaussianRef
import duc.uscript.uScript.FloatTypeRef
import duc.uscript.uScript.DoubleTypeRef
import duc.uscript.uScript.UTypeRef
import duc.uscript.uScript.RayleighRef
import duc.uscript.uScript.BinomialRef
import com.ibm.icu.impl.coll.SharedObject.Reference
import duc.uscript.uScript.ShortTypeRef
import duc.uscript.uScript.IntegerTypeRef
import duc.uscript.uScript.LongTypeRef
import duc.uscript.uScript.ByteTypeRef
import duc.uscript.uScript.Field
import org.eclipse.xtext.validation.AbstractDeclarativeValidator

class UTypeValidator extends AbstractUScriptValidator{
	
	public static val WRONG_UTYPE = "wrongUType"
	
	@Check
	def checkBernoulliBool(BernoulliRef ber) {
		if(!(ber.genericType instanceof BooleanTypeRef)) {
			error(
				'''Bernoulli distribution can only be applied on boolean. Actual: «ber.genericType.syntax»''',
				ber,
				UScriptPackage.Literals.UTYPE_REF__GENERIC_TYPE,
				WRONG_UTYPE
			)
		}
	}
		
	@Check
	def checkGaussianNbr(GaussianRef gauss) {
		checkContinuous(gauss, "Gaussian")
	}
	
	@Check
	def checkRayleighNbr(RayleighRef gauss) {
		checkContinuous(gauss, "Rayleigh")
	}
	
	private def checkContinuous(UTypeRef type, String name) {
		val genType = type.genericType
		
		if(!(genType instanceof FloatTypeRef || genType instanceof DoubleTypeRef)) {
			error(
				'''«name» distribution can only be applied on (float, double). Actual: «genType.syntax»''',
				type,
				UScriptPackage.Literals.UTYPE_REF__GENERIC_TYPE,
				WRONG_UTYPE
			)
		}
	}
	
	@Check
	def checkBinomialNbr(BinomialRef bin) {
		val genType = bin.genericType
		
		if(!(genType instanceof ShortTypeRef || genType instanceof IntegerTypeRef || genType instanceof LongTypeRef)) {
			error(
				'''Binomial distribution can only be applied on (short, int, long). Actual: «genType.syntax»''',
				bin,
				UScriptPackage.Literals.UTYPE_REF__GENERIC_TYPE,
				WRONG_UTYPE
			)
		}
	}
	
	@Check
	def checkDiracNbr(BinomialRef bin) {
		val genType = bin.genericType
		
		if(!(genType instanceof ShortTypeRef || genType instanceof IntegerTypeRef || genType instanceof LongTypeRef ||
			genType instanceof FloatTypeRef || genType instanceof DoubleTypeRef || genType instanceof ByteTypeRef)) {
				
			error(
				'''Dirac delta function distribution can only be applied on (short, int, long, float, double, byte). Actual: «genType.syntax»''',
				bin,
				UScriptPackage.Literals.UTYPE_REF__GENERIC_TYPE,
				WRONG_UTYPE
			)
		}
	}
		
}