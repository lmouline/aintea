package duc.uscript.execution.interpreter.expression.bool

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.And
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ExecutionFactory

@Aspect(className=And)
class AndAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value left = _self.left.evaluateExpression(state)
		val Value right = _self.right.evaluateExpression(state)
		
		//Left dispatch		
		return switch(left) {
			BooleanValue: rightDispatch(_self, left, right)
		}
	}
	
	//Right dispatch
	private static def BooleanValue rightDispatch(BooleanValue left, Value right) {
		return switch(right) {
			BooleanValue: private_and(_self, left, right)
		}
	}
	
	// All possible combination
	private static def BooleanValue private_and(BooleanValue x, BooleanValue y) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = x.value && y.value
		]
	}
}