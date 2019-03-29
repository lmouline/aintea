package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.ArrayLength
import duc.uscript.execution.State
import duc.uscript.execution.Value
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.ArrayRefValue
import duc.uscript.execution.ExecutionFactory
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

@Aspect(className=ArrayLength)
class ArrayLengthAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val arrayRef = _self.array.evaluateExpression(state) as ArrayRefValue
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
			value = arrayRef.instance.size
		]
	}
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		throw new RuntimeException('''findDependentVariables should be overriden for type «_self.class.name»''')
	}
	
	
}