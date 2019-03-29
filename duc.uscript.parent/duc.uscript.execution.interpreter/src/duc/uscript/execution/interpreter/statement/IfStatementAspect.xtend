package duc.uscript.execution.interpreter.statement

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.IfStatement
import duc.uscript.execution.State
import static extension duc.uscript.execution.interpreter.expression.ExpressionAspect.*
import duc.uscript.execution.BooleanValue
import static extension duc.uscript.execution.interpreter.statement.BlockAspect.*

@Aspect(className=IfStatement)
class IfStatementAspect extends AStatementAspect {
	
	def void evaluateStatement(State state) {
		val condition = _self.condition.evaluateExpression(state) as BooleanValue
		
		if(condition.value) {
			_self.thenBlock?.evaluateStatement(state)
		} else {
			_self.elseBlock?.evaluateStatement(state)
		}
	}
	
}