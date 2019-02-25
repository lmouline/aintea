package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.BooleanValue

@Aspect(className=BooleanValue)
class BooleanValueAspect extends AValueAspect {
	
	@OverrideAspectMethod
	def String convertToString() {
		return _self.value.toString
	}
}
