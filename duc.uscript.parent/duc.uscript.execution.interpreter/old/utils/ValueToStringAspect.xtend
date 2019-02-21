package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value

@Aspect(className=Value)
class ValueToStringAspect {
	def String customToString() {}
}