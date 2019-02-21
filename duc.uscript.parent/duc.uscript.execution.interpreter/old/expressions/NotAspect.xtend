package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Not
import uMiniJavaDynamicData.UBooleanValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=Not)
class NotAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val exprVal = _self.expression.evaluateExpression(state)
		if(exprVal instanceof UBooleanValue) {
			return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
				value = !exprVal.value
				confidence = exprVal.confidence
			]
		} else {
			return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
				value = !(exprVal as BooleanValue).value
			]
		}
	}
}