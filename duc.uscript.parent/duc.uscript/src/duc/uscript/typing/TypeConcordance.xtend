package duc.uscript.typing

import static duc.uscript.typing.InternalTypeDcl.*
import duc.uscript.uScript.Class

import static extension duc.uscript.UScriptModelHelper.getFullQualifiedNamed

class TypeConcordance {
	def static boolean isPrimitive(Class c) {
		return is(c, PRIMITIVE_TYPE)
	}
	
	def static boolean isNumber(Class c) {
		return is(c, NUMERIC_TYPE) || is(c, UNCERTAIN_NUMERIC_TYPE)
	}
	
	def static boolean isCertainNumber(Class c) {
		return is(c, NUMERIC_TYPE)
	}
	
	def static boolean isUncertain(Class c) {
		return is(c, UNCERTAIN_TYPE)
	}
	
	def static boolean is(Class c, String parentFqnName) {
		if (c.fullQualifiedNamed == parentFqnName) {
			return true
		}
		
		if (c.superClass === null) {
			return false
		}
		
		if(c.superClass.fullQualifiedNamed == parentFqnName) {
			return true
		}
		
		return is(c.superClass, parentFqnName)
	}
	
	def static String getUDistType(Class c) {
		if(is(c, GAUSSIAN_TYPE)) {
			return GAUSSIAN_TYPE
		}
		
		if(is(c, RAYLEIGH_TYPE)) {
			return RAYLEIGH_TYPE
		}
		
		if(is(c, BINOMIAL_TYPE)) {
			return BINOMIAL_TYPE
		}
		
		if(is(c, DIRAC_TYPE)) {
			return DIRAC_TYPE
		}
		
		throw new RuntimeException("Uncertain distribution unknown for " + c.name)
	}
	
	def static String getTypeFromUType(Class c) {
		val fqn = c.fullQualifiedNamed
		if(fqn == GAUSSIAN_DOUBLE_TYPE || fqn == RAYLEIGH_DOUBLE_TYPE || fqn == DIRAC_DOUBLE_TYPE) {
			return DOUBLE_TYPE
		}
		
		if(fqn == GAUSSIAN_FLOAT_TYPE || fqn == RAYLEIGH_FLOAT_TYPE || fqn == DIRAC_FLOAT_TYPE) {
			return FLOAT_TYPE
		}
		
		if(fqn == DIRAC_BYTE_TYPE || fqn == BINOMIAL_BYTE_TYPE) {
			return BYTE_TYPE
		}
		
		if(fqn == DIRAC_INT_TYPE || fqn == BINOMIAL_INT_TYPE) {
			return INT_TYPE
		}
		
		if(fqn == DIRAC_SHORT_TYPE || fqn == BINOMIAL_SHORT_TYPE) {
			return SHORT_TYPE
		}
		
		if(fqn == DIRAC_LONG_TYPE || fqn == BINOMIAL_LONG_TYPE) {
			return LONG_TYPE
		}
		
		if(fqn == BERNOULLI_BOOL_TYPE) {
			return BOOL_TYPE
		}
		
		throw new RuntimeException("Certain type unknown for " + c.name)
	}
}