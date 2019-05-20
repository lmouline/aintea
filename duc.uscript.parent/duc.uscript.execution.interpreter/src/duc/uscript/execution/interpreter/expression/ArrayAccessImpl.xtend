package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.ArrayAccess
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.utils.SymbolSet
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.ArrayRefValue
import duc.uscript.execution.IntegerValue

import static extension duc.uscript.execution.interpreter.modelstate.ValueAspect.copy
//import duc.uscript.uScript.BernoulliRef
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils
import duc.uscript.execution.DoubleValue

@Aspect(className=ArrayAccess)
class ArrayAccessImpl extends ExpressionAspect {
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet
	}
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val arrayRef = _self.object.evaluateExpression(state)
		val index = _self.index.evaluateExpression(state)
		
		return switch(arrayRef) {
			ArrayRefValue: realAccess(_self, arrayRef, index, state)
			ObjectRefValue: confidenceOperator(_self, arrayRef, index, state)
		}
	}
	
	private static def Value realAccess(ArrayRefValue arrayRef, Value index, State state) {
		val int_idx = (index as IntegerValue).value
		return arrayRef.instance.value.get(int_idx).copy
	}
	
	private static def Value confidenceOperator(ObjectRefValue bernRef, Value givenConf, State state) {
		val double conf = BernoulliBoolUtils.getProbability(bernRef).value
				
		val threshold = if (givenConf instanceof IntegerValue) {
			givenConf.value
		} else if(givenConf instanceof DoubleValue) {
			givenConf.value
		}

		//Dirty way to run the exist operator
		if(conf < threshold && (1-conf) < threshold) {
			throw new RuntimeException("No value exists with such a confidence")
		}
							
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			if(conf > 1- conf) {
				value = true
			} else if(conf < 1- conf) {
				value = false
			} else {
				throw new RuntimeException("confidence value equals 0.5: no choice possible.")
			}
		]
	}
	
	
		
}