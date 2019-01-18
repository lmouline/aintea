package duc.uscript.validation

import duc.uscript.uScript.TypeRef
import duc.uscript.uScript.ByteTypeRef
import duc.uscript.uScript.IntegerTypeRef
import duc.uscript.uScript.LongTypeRef
import duc.uscript.uScript.FloatTypeRef
import duc.uscript.uScript.DoubleTypeRef
import duc.uscript.uScript.ShortTypeRef
import duc.uscript.uScript.CharTypeRef
import duc.uscript.uScript.BooleanTypeRef
import duc.uscript.uScript.StringTypeRef
import duc.uscript.uScript.VoidTypeRef
import duc.uscript.uScript.GaussianRef
import duc.uscript.uScript.BernoulliRef
import duc.uscript.uScript.RayleighRef
import duc.uscript.uScript.BinomialRef
import duc.uscript.uScript.DiracRef
import duc.uscript.uScript.ClassRef
import duc.uscript.uScript.ArrayTypeRef

class TypeNameHelper {
	static def dispatch getSyntax(TypeRef type) {
		return '''Type «type» not implemented in the validator. Please update it.'''
	}
	
	static def dispatch getSyntax(ArrayTypeRef type) {
		return '''«getSyntax(type.typeRef)»[]'''
	}
	
	static def dispatch getSyntax(ByteTypeRef type) {
		return "byte"
	}
	
	static def dispatch getSyntax(IntegerTypeRef type) {
		return "int"
	}
	
	static def dispatch getSyntax(LongTypeRef type) {
		return "long"
	}
	
	static def dispatch getSyntax(FloatTypeRef type) {
		return "float"
	}
	
	static def dispatch getSyntax(DoubleTypeRef type) {
		return "double"
	}
	
	static def dispatch getSyntax(ShortTypeRef type) {
		return "short"
	}
	
	static def dispatch getSyntax(CharTypeRef type) {
		return "char"
	}
	
	static def dispatch getSyntax(BooleanTypeRef type) {
		return "bool"
	}
	
	static def dispatch getSyntax(StringTypeRef type) {
		return "string"
	}
	
	static def dispatch getSyntax(VoidTypeRef type) {
		return "void"
	}
	
	static def dispatch getSyntax(GaussianRef type) {
		return "Gaussian"
	}
	
	static def dispatch getSyntax(BernoulliRef type) {
		return "Bernoulli"
	}
	
	static def dispatch getSyntax(RayleighRef type) {
		return "Rayleigh"
	}
	
	static def dispatch getSyntax(BinomialRef type) {
		return "Binomial"
	}
	
	static def dispatch getSyntax(DiracRef type) {
		return "DiracDeltaFct"
	}
	
	static def dispatch getSyntax(ClassRef type) {
		return type.referencedClass.name
	}
	
	
}