package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import uMiniJavaDynamicData.ULongValue

@Aspect(className=ULongValue)
class ULongValueToStringAspect extends LongValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		return '''(«_self.value.toString», «_self.variance.toString»)'''
	}
}