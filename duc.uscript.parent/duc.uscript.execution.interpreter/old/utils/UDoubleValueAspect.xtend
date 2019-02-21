package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UDoubleValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=UDoubleValue)
class UDoubleValueAspect extends DoubleValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUDoubleValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}