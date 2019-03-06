package duc.uscript.execution.interpreter.expression.constants

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.StringConstant
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.interpreter.expression.ExpressionAspect

@Aspect(className=StringConstant)
class StringConstantAspect extends ExpressionAspect {
		
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return ExecutionFactory::eINSTANCE.createStringValue => [
			value = _self.value
		]
	}
}