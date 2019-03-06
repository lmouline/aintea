package duc.uscript.execution.interpreter.expression.bool

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.Not

@Aspect(className=Not)
class NotAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value value = _self.expression.evaluateExpression(state)
		
		//Left dispatch		
		return switch(value) {
			BooleanValue: private_or(_self, value)
		}
	}
		
	// All possible combination
	private static def BooleanValue private_or(BooleanValue x) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = !x.value
		]
	}
}