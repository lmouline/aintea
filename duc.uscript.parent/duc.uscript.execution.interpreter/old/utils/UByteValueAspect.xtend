package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UByteValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=UByteValue)
class UByteValueAspect extends ByteValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUByteValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}