package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value

@Aspect(className=DoubleValue)
class DoubleValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createDoubleValue => [value = _self.value]
	}
}