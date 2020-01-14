package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.MethodCall
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.State
import duc.uscript.uScript.Expression
import duc.uscript.execution.Value
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.ExecutionFactory
import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*
import static extension duc.uscript.execution.interpreter.expression.MethodAspect.*
import static extension duc.uscript.execution.interpreter.modelstate.ValueAspect.copy

@Aspect(className=MethodCall)
class MethodCallAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val receiver = (_self.receiver.evaluateExpression(state) as ObjectRefValue).instance
		val method = _self.method
		val ctx = ExecutionFactory::eINSTANCE.createContext
		
		for(arg: _self.args) {
			val param = method.params.get(_self.args.indexOf(arg))
			val binding = ExecutionFactory::eINSTANCE.createSymbolBindings => [
				symbol = param
				value = arg.evaluateExpression(state)
			]
			ctx.bindings.add(binding)
		}
		 
		for(fieldBdg: receiver.fieldbindings) {
			val smbBdg = ExecutionFactory::eINSTANCE.createSymbolBindings => [
				symbol = fieldBdg.field
				value = fieldBdg.value
			]
			ctx.bindings.add(smbBdg)
		}
		
		val call = ExecutionFactory::eINSTANCE.createMethodCall4 => [
			methodCall = _self
		]
		state.pushNewFrame(receiver, call, ctx)
		method.call(state)
		val returnValue = state.findCurrentFrame.value
		
		val names = ctx.bindings.map[it.symbol.name]
		ctx.bindings
			.filter[names.contains(it.symbol.name)]
			.forEach[
				val value = it.value
				val name = it.symbol.name
				receiver.fieldbindings
						.findFirst[it.field.name == name]
						.value = value
			]
		
		
		
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