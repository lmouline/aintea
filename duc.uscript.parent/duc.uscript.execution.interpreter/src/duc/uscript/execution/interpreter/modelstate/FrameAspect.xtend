package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.Frame
import duc.uscript.execution.Context

import static extension duc.uscript.execution.interpreter.modelstate.ContextAspect.*

@Aspect(className=Frame)
class FrameAspect {
	
	def Frame findCurrentFrame() {
		if(_self.child !== null) {
			return _self.child.findCurrentFrame
		} else {
			return _self
		}
	}
	
	def Context findCurrentContext() {
		if(_self.child !== null) {
			return _self.child.findCurrentContext
		} else if(_self.rootContext !== null) {
			return _self.rootContext.findCurrentContext
		} else {
			return null
		}
	}
	
}