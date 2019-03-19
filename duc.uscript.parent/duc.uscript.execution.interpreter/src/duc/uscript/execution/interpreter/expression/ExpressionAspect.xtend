package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Expression
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.utils.SymbolSet
import duc.uscript.utils.Range
import duc.uscript.utils.RangeFactory

@Aspect(className=Expression)
class ExpressionAspect {
	protected SymbolSet dependentVariables
	
	def Value evaluateExpression(State state) {
		throw new RuntimeException('''evaluateExpression should be overriden for type «_self.class.name»''')
	}
	
	def SymbolSet findDependentVariables(State state) {
		throw new RuntimeException('''findDependentVariables should be overriden for type «_self.class.name»''')
	}
	
	def Range findRange(State state) {
		return RangeFactory.createFullRange()
	}
		
}