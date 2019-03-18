package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.SymbolRef
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*
import static extension duc.uscript.execution.interpreter.modelstate.ContextAspect.*
import static extension duc.uscript.execution.interpreter.modelstate.ValueAspect.*
import duc.uscript.utils.SymbolSet

@Aspect(className=SymbolRef)
class SymbolRefAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		state.findCurrentContext.findBinding(_self.symbol).value.copy 
	}
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		val context = state.findCurrentContext
		val existingBinding = context.findBinding(_self.symbol)
		val result = new SymbolSet
		result.add(_self.symbol)
		result.addAll(existingBinding.symbolSet)
		return result
	}
}