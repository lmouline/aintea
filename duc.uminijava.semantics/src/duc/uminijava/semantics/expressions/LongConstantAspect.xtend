package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.LongConstant

@Aspect(className=LongConstant)
class LongConstantAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return MinijavadynamicdataFactory::eINSTANCE.createLongValue => [
			val strValue = _self.value.substring(0, _self.value.length - 1)
			value = Long.parseLong(strValue)
		]
	}
}