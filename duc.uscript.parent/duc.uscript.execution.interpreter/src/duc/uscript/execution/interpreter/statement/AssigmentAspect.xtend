package duc.uscript.execution.interpreter.statement

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Assignment
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*
import static extension duc.uscript.execution.interpreter.expression.ExpressionAspect.*
import static extension duc.uscript.execution.interpreter.modelstate.ContextAspect.*

import duc.uscript.uScript.VariableDeclaration
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.SymbolRef
import duc.uscript.utils.SymbolSet

@Aspect(className=Assignment)
class AssigmentAspect extends AStatementAspect {
	
	@OverrideAspectMethod
	def void evaluateStatement(State state) {
		val context = state.findCurrentContext
		val assignee = _self.assignee
		val right = _self.value.evaluateExpression(state)
		
		val SymbolSet dependences = _self.value.findDependentVariables(state)
					
		switch (assignee) {
			SymbolRef: {
				val existingBinding = context.findBinding(assignee.symbol)
				existingBinding.value = right
				existingBinding.symbolSet.clear()
				existingBinding.symbolSet = dependences
			}
			VariableDeclaration: {
				val binding = ExecutionFactory::eINSTANCE.createSymbolBindings => [
					symbol = assignee
					value = right
					symbolSet = dependences
				]
				context.bindings.add(binding)
			}
//			FieldAccess: {
//				val f = assignee.field as Field
//				val realReceiver = (assignee.receiver.evaluateExpression(state) as ObjectRefValue).instance
//				val existingBinding = realReceiver.fieldbindings.findFirst[it.field === f]
//				if (existingBinding !== null) {
//					existingBinding.value = right
//				} else {
//					val binding = MinijavadynamicdataFactory::eINSTANCE.createFieldBinding => [
//						field = f
//						value = right
//					]
//					realReceiver.fieldbindings.add(binding)
//				}
//			}
//			ArrayAccess: {
//				val array = (assignee.object.evaluateExpression(state) as ArrayRefValue).instance
//				val index = (assignee.index.evaluateExpression(state) as IntegerValue).value
//				array.value.set(index,right) 
//			}
			default: throw new Exception("Cannot assign a value to "+assignee)
		}
	}
}
