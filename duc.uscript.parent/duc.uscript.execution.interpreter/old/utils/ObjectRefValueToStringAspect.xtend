package duc.uminijava.semantics.utils

import duc.uminijava.uMiniJava.BernoulliRef
import duc.uminijava.uMiniJava.GaussianRef
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue
import uMiniJavaDynamicData.UObjectInstance

import static extension duc.uminijava.semantics.utils.PrimitiveTypeToString.*

@Aspect(className=ObjectRefValue)
class ObjectRefValueToStringAspect extends ValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		switch _self.instance {
			UObjectInstance: {
				val casted = _self.instance as UObjectInstance
				if(casted.UType instanceof GaussianRef) {
					return '''Gaussian<«casted.UType.genericType.primitiveToString»> {value=true, confidence=1}'''
				} else if(casted.UType instanceof BernoulliRef) {
					return '''Bernoulli<«casted.UType.genericType.primitiveToString»> {value=true, confidence=1}'''
				} else {
					return casted.UType.getClass().name
				}
			}
			ObjectInstance: {
				return '''«_self.instance.type.name» {«FOR b : _self.instance.fieldbindings SEPARATOR "\n\t"»«b.field.name»: «b.value.customToString »«ENDFOR»}''';
			}
			default: "nothing :("
		}
	}
}