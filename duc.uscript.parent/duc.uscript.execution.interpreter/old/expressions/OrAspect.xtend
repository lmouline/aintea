package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Or
import uMiniJavaDynamicData.UBooleanValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=Or)
class OrAspect extends ExpressionAspect {
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
						confidence = castedLeft.confidence + castedRight.confidence - castedLeft.confidence * castedRight.confidence
					} else if(castedLeft.value == false && castedRight.value == true) {
						value = true 
						confidence = (1-castedLeft.confidence)+ castedRight.confidence - (1-castedLeft.confidence)*castedRight.confidence
						
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = true
						confidence = (1-castedRight.confidence)+ castedLeft.confidence - (1-castedRight.confidence)*castedLeft.confidence
					} else if(castedLeft.value == false && castedRight.value == false) {
						value = false
						val confidenceTrue = 2-castedRight.confidence-castedLeft.confidence - (1-castedRight.confidence)*(1-castedLeft.confidence)
						confidence = 1- confidenceTrue
					}
				]
			} else {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as UBooleanValue
					val castedRight = right as BooleanValue
					
					if(castedLeft.value == true && castedRight.value == true) {
						value = true
						confidence = 1
					} else if(castedLeft.value == false && castedRight.value == true) {
						value = true
						confidence = 0
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = true
						confidence = castedLeft.confidence
					} else if(castedLeft.value == false && castedRight.value == false) {
						value = false
						confidence = castedLeft.confidence
					}
					
				]
			}
			
		} else { //left -> BooleanValue
			if(right instanceof UBooleanValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as BooleanValue
					val castedRight = right as UBooleanValue
					
					if(castedLeft.value == true && castedRight.value == true) {
						value = true
						confidence = 1
					} else if(castedLeft.value == false && castedRight.value == true) {
						value = true
						confidence = castedRight.confidence
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = true
						confidence = 1
					} else if(castedLeft.value == false && castedRight.value == false) {
						value = false
						confidence = 1
					}
					
				]
			} else {//right -> BooleanValue
				return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
					value = (left as BooleanValue).value || (right as BooleanValue).value
				]
			}
		}
		
//		throw new RuntimeException('''Unsupported or operands: «left» || «right».''')
	}
}