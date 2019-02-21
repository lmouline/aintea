package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.ULongValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=ULongValue)
class ULongValueAspect extends LongValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createULongValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}