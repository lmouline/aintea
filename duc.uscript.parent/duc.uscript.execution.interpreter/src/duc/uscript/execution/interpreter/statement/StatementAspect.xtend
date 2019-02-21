package duc.uscript.execution.interpreter.statement

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Statement
import duc.uscript.execution.State

@Aspect(className=Statement)
class StatementAspect {
	
	def void evaluateStatement(State state) {
		throw new RuntimeException('''Evaluation is not defined for «_self.class.name»''')
	}
}