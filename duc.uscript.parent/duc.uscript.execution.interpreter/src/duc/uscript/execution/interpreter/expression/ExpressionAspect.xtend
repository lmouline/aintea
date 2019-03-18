package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Expression
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.interpreter.utils.SymbolSet

@Aspect(className=Expression)
class ExpressionAspect {
	protected SymbolSet dependentVariables
	
	def Value evaluateExpression(State state) {
		throw new RuntimeException('''evaluateExpression should be overriden for type «_self.class.name»''')
	}
	
	protected def SymbolSet findDependentVariables(State state) {
		throw new RuntimeException('''findDependentVariables should be overriden for type «_self.class.name»''')
	}
		
}