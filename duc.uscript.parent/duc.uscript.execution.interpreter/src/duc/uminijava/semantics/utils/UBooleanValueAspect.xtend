package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UBooleanValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=UBooleanValue)
class UBooleanValueAspect extends BooleanValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUBooleanValue => [
			value = _self.value
			confidence = _self.confidence
		]
	}
}