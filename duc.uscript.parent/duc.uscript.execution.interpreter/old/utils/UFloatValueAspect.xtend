package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UFloatValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=UFloatValue)
class UFloatValueAspect extends FloatValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUFloatValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}