package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.Context

@Aspect(className=Context)
class ContextAspect {
	
	def Context findCurrentContext() {
		if(_self.child !== null) {
			return _self.child.findCurrentContext
		} else {
			return _self
		}
	}
	
}