package duc.uscript.validation

import org.eclipse.xtext.validation.Check
import duc.uscript.uScript.BernoulliRef
import duc.uscript.uScript.BooleanTypeRef

import static extension duc.uscript.typing.TypeNameHelper.getSyntax
import static duc.uscript.typing.TypeResolver.*
import static duc.uscript.typing.InternalTypeDcl.*
import static duc.uscript.typing.TypeConcordance.*
import duc.uscript.uScript.UScriptPackage
import duc.uscript.uScript.GaussianRef
import duc.uscript.uScript.FloatTypeRef
import duc.uscript.uScript.DoubleTypeRef
import duc.uscript.uScript.UTypeRef
import duc.uscript.uScript.RayleighRef
import duc.uscript.uScript.BinomialRef
import duc.uscript.uScript.ShortTypeRef
import duc.uscript.uScript.IntegerTypeRef
import duc.uscript.uScript.LongTypeRef
import duc.uscript.uScript.ByteTypeRef
import duc.uscript.uScript.DiracRef
import duc.uscript.uScript.NewUObject

class UTypeValidator extends AbstractUScriptValidator{
	
	public static val WRONG_UTYPE = "wrongUType"
	public static val WRONG_UTYPE_CONSTRUCTOR = "wrongUTypeConstructor"
	
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
	def checkDiracNbr(DiracRef bin) {
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
	
	@Check
	def checkNewUObj(NewUObject newUT) {
		checkUTypeCreation(newUT.type, newUT)
	}
	
	private def dispatch checkUTypeCreation(UTypeRef type, NewUObject newUT) {
		throw new RuntimeException('''checkUTypeCreation(UTypeRef) undefined for «type»''')
	}
	
	private def dispatch checkUTypeCreation(BernoulliRef type, NewUObject newUT) {
		if(newUT.args.length != 2) {
			error(
				'''Bernoulli constructor needs exactly 2 argument: boolean falue and confidence. Actual: «newUT.args.length»''',
				newUT,
				UScriptPackage.Literals.NEW_UOBJECT__ARGS,
				-1,
				WRONG_UTYPE_CONSTRUCTOR
			)
		} else {
			val arg1Type = type(newUT.args.get(0))
			if(arg1Type !== BOOLEAN_TYPE) {
				error(
					'''First argument of the Bernoulli constructor needs to be a boolean expression. Actual: «arg1Type.name»''',
					newUT,
					UScriptPackage.Literals.NEW_UOBJECT__ARGS,
					0,
					WRONG_UTYPE_CONSTRUCTOR
				)
			}
			
			val arg2Type = type(newUT.args.get(1))
			if(!isNumber(arg2Type)) {
				error(
					'''Second argument of the Bernoulli constructor needs to be a numeric expression. Actual: «arg2Type.name»''',
					newUT,
					UScriptPackage.Literals.NEW_UOBJECT__ARGS,
					1,
					WRONG_UTYPE_CONSTRUCTOR
				)
			}
		}
		
	}
		
}