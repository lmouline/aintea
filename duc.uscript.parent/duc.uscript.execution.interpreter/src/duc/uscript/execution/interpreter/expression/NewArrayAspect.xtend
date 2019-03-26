package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.NewArray
import duc.uscript.execution.Value
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.State
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.IntegerValue

@Aspect(className=NewArray)
class NewArrayAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val arraSize = (_self.size.evaluateExpression(state) as IntegerValue).value
		val result = ExecutionFactory::eINSTANCE.createArrayInstance => [
			size = arraSize
		]
		state.arraysHeap.add(result)
		
		for(i: 1..arraSize) {
			result.value.add(ExecutionFactory::eINSTANCE.createNullValue)
		}
				
		return ExecutionFactory::eINSTANCE.createArrayRefValue => [
			instance = result
		]
	}
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet		
	}
}