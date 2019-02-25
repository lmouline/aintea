package duc.uscript.execution.interpreter.statement

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.PrintStatement
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.expression.constants.AExpressionAspect.*
import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*
import static extension duc.uscript.execution.interpreter.modelstate.AValueAspect.*

@Aspect(className=PrintStatement)
class PrintStatementAspect extends AStatementAspect{
	
	@OverrideAspectMethod
	def void evaluateStatement(State state) {
		val expression = _self.expression.evaluateExpression(state)
		val string = expression.convertToString
		state.print(string)
	}
	
}