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
import duc.uscript.uScript.Class
import duc.uscript.typing.InternalTypeDcl

class UTypeValidator extends AbstractUScriptValidator{
	
	public static val WRONG_UTYPE = "wrongUType"
	public static val WRONG_UTYPE_CONSTRUCTOR = "wrongUTypeConstructor"
	
	@Check
	def checkBernoulliBool(BernoulliRef ber) {
		InternalTypeDcl.init(ber.eResource)
		if(ber.genericType !== null) {
			if(!(ber.genericType instanceof BooleanTypeRef)) {
				error(
					'''Bernoulli distribution can only be applied on boolean. Actual: «ber.genericType.syntax»''',
					ber,
					UScriptPackage.Literals.UTYPE_REF__GENERIC_TYPE,
					WRONG_UTYPE
				)
			}
		}
	}
		
	@Check
	def checkGaussianNbr(GaussianRef gauss) {
		InternalTypeDcl.init(gauss.eResource)
		checkContinuous(gauss, "Gaussian")
	}
	
	@Check
	def checkRayleighNbr(RayleighRef ray) {
		InternalTypeDcl.init(ray.eResource)
		checkContinuous(ray, "Rayleigh")
	}
	
	private def checkContinuous(UTypeRef type, String name) {
		val genType = type.genericType
		
		if(genType !== null) {
			if(!(genType instanceof FloatTypeRef || genType instanceof DoubleTypeRef)) {
				error(
					'''«name» distribution can only be applied on (float, double). Actual: «genType.syntax»''',
					type,
					UScriptPackage.Literals.UTYPE_REF__GENERIC_TYPE,
					WRONG_UTYPE
				)
			}
		}
	}
	
	@Check
	def checkBinomialNbr(BinomialRef bin) {
		InternalTypeDcl.init(bin.eResource)
		val genType = bin.genericType
		
		if(genType !== null) {
			if(!(genType instanceof ShortTypeRef || genType instanceof IntegerTypeRef || genType instanceof LongTypeRef)) {
				error(
					'''Binomial distribution can only be applied on (short, int, long). Actual: «genType.syntax»''',
					bin,
					UScriptPackage.Literals.UTYPE_REF__GENERIC_TYPE,
					WRONG_UTYPE
				)
			}
		}
	}
	
	@Check
	def checkDiracNbr(DiracRef bin) {
		InternalTypeDcl.init(bin.eResource)
		val genType = bin.genericType
		
		if(genType !== null) {
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
	
	@Check
	def checkNewUObj(NewUObject newUT) {
		InternalTypeDcl.init(newUT.eResource)
		checkUTypeCreation(newUT.type, newUT)
	}
	
	private def dispatch checkUTypeCreation(UTypeRef type, NewUObject newUT) {
		throw new RuntimeException('''checkUTypeCreation(UTypeRef) undefined for «type»''')
	}
	
	private def dispatch checkUTypeCreation(BernoulliRef type, NewUObject newUT) {
		val hasError = checkNbParam(newUT, "Bernoulli", 2)
		if(!hasError) {
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
			
			checkNumParam(newUT, 1, "Bernoulli")
		}
				
	}
	
	private def dispatch checkUTypeCreation(GaussianRef type, NewUObject newUT) {
		val hasError = checkNbParam(newUT, "Gaussian", 2)
		if(!hasError) {
			checkNumParam(newUT, 0, "Gaussian")
			checkNumParam(newUT, 1, "Gaussian")
		}
		
	}
	
	private def dispatch checkUTypeCreation(DiracRef type, NewUObject newUT) {
		val hasError = checkNbParam(newUT, "Dirac", 2)
		if(!hasError) {
			checkNumParam(newUT, 0, "Dirac")
			checkNumParam(newUT, 1, "Dirac")
		}
		
	}
	
	private def boolean checkNumParam(NewUObject newUT, int paramIdx, String distName) {
		val Class arg1Type = type(newUT.args.get(paramIdx))
		if(!isNumber(arg1Type)) {
			error(
				'''«intToNiceString(paramIdx)» argument of the «distName» constructor needs to be a numeric expression. Actual: «arg1Type.name»''',
				newUT,
				UScriptPackage.Literals.NEW_UOBJECT__ARGS,
				paramIdx,
				WRONG_UTYPE_CONSTRUCTOR
			)
			return true
		}
		return false
	}
	
	private def boolean checkNbParam(NewUObject newUT, String distName, int nbArgs) {
		if(newUT.args.length != nbArgs) {
			error(
				'''«distName» constructor needs exactly «nbArgs» arguments. Actual: «newUT.args.length»''',
				newUT,
				UScriptPackage.Literals.NEW_UOBJECT__ARGS,
				-1,
				WRONG_UTYPE_CONSTRUCTOR
			)
			return true;
		}
		return false;
	}
	
	private def String intToNiceString(int idx) {
		if(idx == 0) {
			return "First"
		}
		if(idx == 1) {
			return "Second"
		}
		if(idx == 2) {
			return "Third"
		}
	}
		
}