package duc.uscript.execution.interpreter.statement

import duc.uscript.uScript.ForStatement
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.State
import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*
import static extension duc.uscript.execution.interpreter.expression.ExpressionAspect.*
import duc.uscript.execution.BooleanValue

@Aspect(className=ForStatement)
class ForStatementAspect extends AStatementAspect {
	
	@OverrideAspectMethod
	def void evaluateStatement(State state) {
		state.pushNewContext
				
		for (_self.declaration.evaluateStatement(state); (_self.condition.evaluateExpression(state) as BooleanValue).
			value; _self.progression.evaluateStatement(state)) {
			_self.block.evaluateStatement(state)
		}
		state.popCurrentContext
	}
}