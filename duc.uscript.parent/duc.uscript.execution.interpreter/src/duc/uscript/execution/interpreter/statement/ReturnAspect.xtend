package duc.uscript.execution.interpreter.statement

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Return
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.expression.ExpressionAspect.*
import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*

@Aspect(className=Return)
class ReturnAspect extends AStatementAspect {
	
	@OverrideAspectMethod
	def void evaluateStatement(State state) {
		val value = _self.expression.evaluateExpression(state)
		state.findCurrentFrame.value = value
	}
}