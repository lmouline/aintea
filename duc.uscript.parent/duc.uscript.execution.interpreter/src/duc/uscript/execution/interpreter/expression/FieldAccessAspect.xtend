package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.FieldAccess
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.ObjectInstance

@Aspect(className=FieldAccess)
class FieldAccessAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val realReceiver = (_self.receiver.evaluateExpression(state) as ObjectRefValue).instance as ObjectInstance
		return realReceiver.fieldbindings.findFirst[it.field.name == _self.field.name].value
	}
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet
	}
	
}