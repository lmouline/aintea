package duc.uscript.typing

import static duc.uscript.typing.InternalTypeDcl.*
import duc.uscript.uScript.Class

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
	
	def static boolean is(Class c, Class parent) {
		if (c === parent) {
			return true
		}
		
		if (c.superClass === null) {
			return false
		}
		
		if(c.superClass === parent) {
			return true
		}
		
		return is(c.superClass, parent)
	}
	
	def static getUDistType(Class c) {
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
	
	def static getTypeFromUType(Class c) {
		if(c === GAUSSIAN_DOUBLE_TYPE || c === RAYLEIGH_DOUBLE_TYPE || c === DIRAC_DOUBLE_TYPE) {
			return DOUBLE_TYPE
		}
		
		if(c === GAUSSIAN_FLOAT_TYPE || c === RAYLEIGH_FLOAT_TYPE || c === DIRAC_FLOAT_TYPE) {
			return FLOAT_TYPE
		}
		
		if(c === DIRAC_BYTE_TYPE || c === BINOMIAL_BYTE_TYPE) {
			return BYTE_TYPE
		}
		
		if(c === DIRAC_INT_TYPE || c === BINOMIAL_INT_TYPE) {
			return INT_TYPE
		}
		
		if(c === DIRAC_SHORT_TYPE || c === BINOMIAL_SHORT_TYPE) {
			return SHORT_TYPE
		}
		
		if(c === DIRAC_LONG_TYPE || c === BINOMIAL_LONG_TYPE) {
			return LONG_TYPE
		}
		
		if(c === BERNOULLI_BOOL_TYPE) {
			return BOOLEAN_TYPE
		}
		
		throw new RuntimeException("Certain type unknown for " + c.name)
	}
}