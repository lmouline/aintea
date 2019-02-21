package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Class
import org.tetrabox.minijava.xtext.miniJava.MethodCall

import static extension duc.uminijava.semantics.expressions.MethodAspect.findOverride
import static extension duc.uminijava.semantics.utils.StateAspect.*
import static extension duc.uminijava.semantics.statements.MethodSortofStatementAspect.call 

@Aspect(className=MethodCall)
class MethodCallExpressionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val realReceiver = (_self.receiver.evaluateExpression(state) as ObjectRefValue).instance
		val realMethod = _self.method.findOverride(realReceiver.type as Class)
		val newContext = MinijavadynamicdataFactory::eINSTANCE.createContext
		for (arg : _self.args) {
			val param = realMethod.params.get(_self.args.indexOf(arg))
			val binding = MinijavadynamicdataFactory::eINSTANCE.createSymbolBinding => [
				symbol = param
				value = arg.evaluateExpression(state)
			]
			newContext.bindings.add(binding)
		}

		val call = MinijavadynamicdataFactory::eINSTANCE.createMethodCall2 => [methodcall = _self]
		state.pushNewFrame(realReceiver, call, newContext)
		realMethod.call(state)
		val returnValue = state.findCurrentFrame.returnValue
		state.popCurrentFrame
		return returnValue

	}
}