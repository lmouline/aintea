package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UIntegerValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=UIntegerValue)
class UIntegerValueAspect extends IntegerValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUIntegerValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}