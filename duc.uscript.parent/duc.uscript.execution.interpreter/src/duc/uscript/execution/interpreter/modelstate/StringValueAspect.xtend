package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.StringValue
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

@Aspect(className=StringValue)
class StringValueAspect extends AValueAspect {
	
	@OverrideAspectMethod
	def String convertToString() {
		return _self.value
	}
	
}