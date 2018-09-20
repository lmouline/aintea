package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.BooleanTypeRef
import org.tetrabox.minijava.xtext.miniJava.ClassRef
import org.tetrabox.minijava.xtext.miniJava.IntegerTypeRef
import org.tetrabox.minijava.xtext.miniJava.NewArray
import org.tetrabox.minijava.xtext.miniJava.StringTypeRef

import static extension duc.uminijava.semantics.utils.ValueAspect.copy

@Aspect(className=NewArray)
class NewArrayAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		// Creating array with size
		val result = MinijavadynamicdataFactory::eINSTANCE.createArrayInstance
		result.size = (_self.size.evaluateExpression(state) as IntegerValue).value
		state.arraysHeap.add(result)

		// Filling array with default values
		val defaultValue = switch (_self.type) {
			IntegerTypeRef: MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = 0]
			BooleanTypeRef: MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [value = false]
			StringTypeRef: MinijavadynamicdataFactory::eINSTANCE.createNullValue
			ClassRef: MinijavadynamicdataFactory::eINSTANCE.createNullValue
		}
		for (i : 1 .. result.size) {
			result.value.add(defaultValue.copy)
		}

		// Return constructed array
		return MinijavadynamicdataFactory::eINSTANCE.createArrayRefValue => [instance = result]
	}
}