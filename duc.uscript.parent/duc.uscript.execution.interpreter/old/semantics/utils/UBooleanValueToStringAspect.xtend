package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import uMiniJavaDynamicData.UBooleanValue

@Aspect(className=UBooleanValue)
class UBooleanValueToStringAspect extends BooleanValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		return '''(«_self.value.toString», «_self.confidence.toString»)'''
	}
}