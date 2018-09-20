package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import uMiniJavaDynamicData.UShortValue

@Aspect(className=UShortValue)
class UShortValueToStringAspect extends ShortValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		return '''(«_self.value.toString», «_self.variance.toString»)'''
	}
}