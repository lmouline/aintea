package duc.uminijava.semantics.expressions

import duc.uminijava.uMiniJava.ExistExpr
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UBooleanValue

@Aspect(className=ExistExpr)
class ExistExprAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val double conf = (_self.confidence.evaluateExpression(state) as DoubleValue).value
		val uAtt = _self.expr.evaluateExpression(state)
		if(uAtt instanceof UBooleanValue) {
			MinijavadynamicdataFactory.eINSTANCE.createBooleanValue => [
				value = conf <= uAtt.confidence || conf <= 1 - uAtt.confidence
			]
		} else {
			throw new RuntimeException('''Not yet implemented for «uAtt.class.name»''')
		}
		
	}
}