package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Expression
import duc.uscript.execution.Value
import duc.uscript.execution.State

@Aspect(className=Expression)
class ExpressionAspect {
	def Value evaluateExpression(State state) {
		throw new RuntimeException('''evaluate should be overriden for type «_self.class.name»''')
	}
	
}