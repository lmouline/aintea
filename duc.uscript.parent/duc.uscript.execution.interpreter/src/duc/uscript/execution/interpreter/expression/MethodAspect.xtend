package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Method
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.statement.BlockAspect.*

@Aspect(className=Method)
class MethodAspect {
	def void call(State state) {
		_self.body.evaluateStatement(state)
	}
}