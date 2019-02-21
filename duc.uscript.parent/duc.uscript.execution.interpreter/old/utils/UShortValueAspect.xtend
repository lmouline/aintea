package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory
import uMiniJavaDynamicData.UShortValue

@Aspect(className=UShortValue)
class UShortValueAspect extends ShortValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUShortValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}