package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Expression
import org.tetrabox.minijava.xtext.miniJava.Field
import org.tetrabox.minijava.xtext.miniJava.Method
import org.tetrabox.minijava.xtext.miniJava.NewObject
import org.tetrabox.minijava.xtext.miniJava.Parameter

import static extension duc.uminijava.semantics.utils.StateAspect.pushNewFrame
import static extension duc.uminijava.semantics.utils.StateAspect.popCurrentFrame

import static extension duc.uminijava.semantics.statements.BlockAspect.evaluateStatement

@Aspect(className=NewObject)
class NewObjectAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {

		// Creating instance with default bindings
		val result = MinijavadynamicdataFactory::eINSTANCE.createObjectInstance => [type = _self.type]
		state.objectsHeap.add(result)
		for (f : result.type.members.filter(Field)) {
			if (f.defaultValue !== null) {
				val v = f.defaultValue.evaluateExpression(state)
				result.fieldbindings.add(MinijavadynamicdataFactory::eINSTANCE.createFieldBinding => [
					field = f;
					value = v
				])
			}
		}

		// Find constructor
		val Method constructor = _self.type.members.filter(Method).findFirst [
			it.name === null && it.params.size === _self.args.size
		]

		// If any, call it
		if (constructor !== null) {

			// Create a context with constructor parameters bindings
			val newContext = MinijavadynamicdataFactory::eINSTANCE.createContext
			for (arg : _self.args) {
				val Parameter param = constructor.params.get(_self.args.indexOf(arg))
				val binding = MinijavadynamicdataFactory::eINSTANCE.createSymbolBinding => [
					symbol = param;
					value = (arg as Expression).evaluateExpression(state)
				]
				newContext.bindings.add(binding)
			}

			// Make the constructor call in new frame
			val call = MinijavadynamicdataFactory::eINSTANCE.createNewCall => [^new = _self]
			state.pushNewFrame(result, call, newContext)
			constructor.body.evaluateStatement(state)
			state.popCurrentFrame

		}

		// Return constructed instance
		return MinijavadynamicdataFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
}