package duc.uscript.execution.interpreter.utils

import duc.uscript.execution.ObjectInstance
import duc.uscript.execution.ArrayRefValue
import duc.uscript.execution.DoubleValue
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.IntegerValue

class MultPossibilityUtils {
	
	def static double[] extractProbs(ObjectInstance poissBinIntObj) {
		val dist = (poissBinIntObj.fieldbindings
								 .findFirst[it.field.name == "confidence"]
								 .value as ObjectRefValue)
								 .instance
								 
		val initBernProbs = (dist.fieldbindings
								.findFirst[it.field.name == "initBernProbs"]
								.value as ArrayRefValue)
								.instance
								
		val double[] result = newDoubleArrayOfSize(initBernProbs.size)
		for(var i=0; i<result.length; i++) {
			val dblValue = initBernProbs.value.get(i) as DoubleValue
			result.set(i, dblValue.value)
		}		  
		
		
		return result
	}
	
	def static int extractValue(ObjectInstance poissBinIntObj) {
		return (poissBinIntObj.fieldbindings
							 .findFirst[it.field.name == "value"]
							 .value as IntegerValue)
							 .value
	}
	
}