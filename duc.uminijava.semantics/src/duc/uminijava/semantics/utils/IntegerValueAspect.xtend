package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value

@Aspect(className=IntegerValue)
class IntegerValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = _self.value]
	}
}