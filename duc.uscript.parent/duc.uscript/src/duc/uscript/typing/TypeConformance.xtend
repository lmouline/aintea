package duc.uscript.typing

import duc.uscript.uScript.Class

import static duc.uscript.typing.TypeConcordance.*
import static duc.uscript.UScriptModelHelper.*
import static duc.uscript.typing.InternalTypeDcl.*
import java.util.Map
import java.util.Set

class TypeConformance {
	
	public val static Map<String, Set<String>> CONFORMANCE_MAP = #{
		BOOL_TYPE -> #{BOOL_TYPE, BERNOULLI_TYPE},
		BERNOULLI_TYPE -> #{BERNOULLI_TYPE, BOOL_TYPE},
		NUMERIC_TYPE -> #{NUMERIC_TYPE, GAUSSIAN_TYPE, RAYLEIGH_TYPE, BINOMIAL_TYPE, DIRAC_TYPE},
		DIRAC_TYPE -> #{DIRAC_TYPE, NUMERIC_TYPE},
		GAUSSIAN_TYPE -> #{GAUSSIAN_TYPE, BINOMIAL_TYPE}
	};
	
	def static Set<String> conformType(Class c) {
		for(String className: CONFORMANCE_MAP.keySet()) {
			if(is(c, className)) {
				return CONFORMANCE_MAP.get(className)
			}
		}
		
		return #{getFullQualifiedNamed(c)}
	}
	
	def static boolean isConformant(Class left, Class right) {
		val compatibleTypes = conformType(left)
		
		if(compatibleTypes.empty) {
			throw new RuntimeException('''Conformance map not fill for «left.name»''');
		}
		
		var boolean isCompatible = false;
		for(String s: compatibleTypes) {
			isCompatible = isCompatible || is(right, s); 
		}
		
		return isCompatible;
		
	
		
		// Type equality
//		if(left.name == right.name) {
//			return true
//		}
		
		// Hierarchy
//		if(is(right, getFullQualifiedNamed(left))) {
//			return true
//		}
		
//		if(isGaussian(left) && isDirac(right)) {
//			return false
//		}
//		
//		if(isGaussian(right) && isDirac(left)) {
//			return false
//		}
		
		//Simplified
//		if(isNumber(left) && isNumber(right)) {
//			return true
//		}
		
//		if(isBoolean(left) && isBoolean(right)) {
//			return true
//		}
		
//		if(isBoolean(left) && isNumber(right)) {
//			return false;
//		}
		
//		if(isBoolean(right) && isNumber(left)) {
//			return false;
//		}
//		
//		throw new RuntimeException('''Type conformance not defined for «left.name» and «right.name»''')
	}
	
	
	
	
}