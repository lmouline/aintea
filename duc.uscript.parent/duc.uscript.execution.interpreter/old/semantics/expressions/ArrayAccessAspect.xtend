package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ArrayRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.ArrayAccess
import uMiniJavaDynamicData.UBooleanValue

import static extension duc.uminijava.semantics.utils.ValueAspect.copy

@Aspect(className=ArrayAccess)
class ArrayAccessAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val arrayRef = _self.object.evaluateExpression(state)
		
		if(arrayRef instanceof ArrayRefValue) {
			val index = (_self.index.evaluateExpression(state) as IntegerValue).value
			return arrayRef.instance.value.get(index).copy
		} else if(arrayRef instanceof UBooleanValue){ //UBooleanValue
			val conf = (_self.index.evaluateExpression(state) as DoubleValue).value
					
			return MinijavadynamicdataFactory.eINSTANCE.createBooleanValue => [
				if(arrayRef.value) {
					value = arrayRef.confidence >= conf
				} else {
					value = (1-arrayRef.confidence) >= conf
				}
			]
		} else {
			throw new RuntimeException("Not yet implemented for " + arrayRef.class.name)
		}

	}

}