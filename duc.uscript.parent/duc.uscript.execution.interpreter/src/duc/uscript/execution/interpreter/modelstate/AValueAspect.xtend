package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.Value

@Aspect(className=Value)
class AValueAspect {
	
	def String convertToString() {
		throw new RuntimeException("Not implemented")
	}
}