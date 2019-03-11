package duc.uscript.execution.interpreter.expression.bool

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.Not
import duc.uscript.execution.ObjectRefValue
import static duc.uscript.execution.interpreter.utils.BernoulliBoolUtils.*

@Aspect(className=Not)
class NotAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value value = _self.expression.evaluateExpression(state)
		
		//Left dispatch		
		return switch(value) {
			BooleanValue: private_not(_self, value)
			ObjectRefValue: private_not(_self, value, state)
			default: throw new RuntimeException("Not yet implemented for " + value.class.name)
		}
	}
		
	// All possible combination
	private static def BooleanValue private_not(BooleanValue x) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = !x.value
		]
	}
	
	private static def ObjectRefValue private_not(ObjectRefValue x, State state) {
		val valX = getValue(x)
		
		val probX = getProbability(x)
								 
		val result = createBernoulliBool(state, 
									     1 - probX.value, 
									     !valX.value, 
									     _self)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
}