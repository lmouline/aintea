package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.And
import uMiniJavaDynamicData.UBooleanValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=And)
class AndAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		
		
		if(left instanceof UBooleanValue) {
			if(right instanceof UBooleanValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as UBooleanValue
					val castedRight = right as UBooleanValue
					
					if(castedLeft.value == true && castedRight.value == true) {
						value = true
						confidence = castedLeft.confidence * castedRight.confidence
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = false
						confidence = 1 - (castedLeft.confidence * (1-castedRight.confidence))
					} else if(castedLeft.value == false && castedRight.value ==true) {
						value = false
						confidence = 1- ((1-castedLeft.confidence) *castedRight.confidence)
					} else {
						value = false
						confidence = 1- ((1-castedLeft.confidence) * (1-castedRight.confidence))
					}
				]
			} else {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as UBooleanValue
					val castedRight = right as BooleanValue
					
					if(castedRight.value == false) {
						value=false
						confidence = 1
					} else {
						value = castedLeft.value
						confidence = castedLeft.confidence
					}
				]
			}
		} else {
			if(right instanceof UBooleanValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as BooleanValue
					val castedRight = right as UBooleanValue
					
					if(castedLeft.value == false) {
						value=false
						confidence = 1
					} else {
						value = castedRight.value
						confidence = castedRight.confidence
					}
				]
			} else {
				return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
					value = (left as BooleanValue).value && (right as BooleanValue).value
				]
			}
		}
	}
}