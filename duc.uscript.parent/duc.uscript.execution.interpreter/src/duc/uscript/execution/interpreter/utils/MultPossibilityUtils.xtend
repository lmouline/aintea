package duc.uscript.execution.interpreter.utils

import duc.uscript.execution.ObjectInstance
import duc.uscript.execution.ArrayRefValue
import duc.uscript.execution.DoubleValue

class MultPossibilityUtils {
	
	def static double[] extractProbs(ObjectInstance multPossObj) {
		val rootProbsInst = (multPossObj.fieldbindings
									  .findFirst[it.field.name == "rootProbs"]
									  .value as ArrayRefValue)
									  .instance
		val double[] result = newDoubleArrayOfSize(rootProbsInst.size)
		for(var i=0; i<result.length; i++) {
			val dblValue = rootProbsInst.value.get(i) as DoubleValue
			result.set(i, dblValue.value)
		}		  
		
		
		return result
	}
	
}