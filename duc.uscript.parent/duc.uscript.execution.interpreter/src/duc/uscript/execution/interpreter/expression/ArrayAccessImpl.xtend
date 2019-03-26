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
import duc.uscript.uScript.BernoulliRef
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils

@Aspect(className=ArrayAccess)
class ArrayAccessImpl extends ExpressionAspect {
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet
	}
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val arrayRef = _self.object.evaluateExpression(state)
		val index = (_self.index.evaluateExpression(state) as IntegerValue).value
		
		return switch(arrayRef) {
			ArrayRefValue: realAccess(_self, arrayRef, index, state)
			ObjectRefValue: confidenceOperator(_self, arrayRef, index, state)
		}
	}
	
	private static def Value realAccess(ArrayRefValue arrayRef, int index, State state) {
		return arrayRef.instance.value.get(index).copy
	}
	
	private static def Value confidenceOperator(ObjectRefValue bernRef, int givenConf, State state) {
		val double conf = BernoulliBoolUtils.getProbability(bernRef).value
		val boolean uValue = BernoulliBoolUtils.getValue(bernRef).value
							
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			if(uValue) {
				value = conf >= givenConf
			} else {
				value = conf < givenConf
			}
		]
	}
	
	
		
}