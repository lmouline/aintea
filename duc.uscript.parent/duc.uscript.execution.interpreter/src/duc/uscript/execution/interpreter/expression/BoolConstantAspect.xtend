package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.uScript.BoolConstant
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.ExecutionFactory

@Aspect(className=BoolConstant)
class BoolConstantAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = _self.value.equalsIgnoreCase("true")
		]
	}
}
