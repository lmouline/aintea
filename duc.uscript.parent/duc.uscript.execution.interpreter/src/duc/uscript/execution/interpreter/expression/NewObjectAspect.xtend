package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.NewObject
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.Field
import duc.uscript.uScript.Expression

@Aspect(className=NewObject)
class NewObjectAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val result = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = _self.type
		]
		state.objectsHeap.add(result)
		
		val fields = _self.type
						  .members
						  .filter(Field)
						  .filter[defaultValue !== null]
						  
		for (f: fields) {
			val defaultValue = f.defaultValue.evaluateExpression(state)
			result.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
				it.field = f
				it.value = defaultValue
			])	
		}		
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [
			instance = result
		]
	}
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		val result = new SymbolSet
		
		for(Expression arg: _self.args) {
			result.addAll(findDependentVariables(arg, state))
		}
		
		return result
	}
		
}