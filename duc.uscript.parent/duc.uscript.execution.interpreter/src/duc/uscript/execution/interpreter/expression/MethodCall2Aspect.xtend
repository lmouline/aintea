package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.Value
import duc.uscript.execution.State
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.MethodCall2

import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*
import static extension duc.uscript.execution.interpreter.expression.MethodAspect.*
import duc.uscript.utils.SymbolSet
import duc.uscript.uScript.Expression

@Aspect(className=MethodCall2)
class MethodCall2Aspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val newCtx = ExecutionFactory::eINSTANCE.createContext
		for(arg: _self.args) {
			val param = _self.method.params.get(_self.args.indexOf(arg))
			val binding = ExecutionFactory::eINSTANCE.createSymbolBindings => [
				symbol = param
				value = arg.evaluateExpression(state)
			]
			newCtx.bindings.add(binding)
		}
		
		val call = ExecutionFactory::eINSTANCE.createMethodCall3 => [
			methodcall = _self
		]
		state.pushNewFrame(null, call, newCtx)
		_self.method.call(state)
		val returnValue = state.findCurrentFrame.value
		state.popCurrentFrame
		
		
		return returnValue
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