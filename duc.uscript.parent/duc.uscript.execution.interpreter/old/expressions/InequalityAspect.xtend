package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Inequality

import static extension duc.uminijava.semantics.EqualityUtils.notEquals

@Aspect(className=Inequality)
class InequalityAspect extends ExpressionAspect {

	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		val boolean result = left.notEquals(right)
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = result
		]
	}
}