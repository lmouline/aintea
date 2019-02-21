package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Context
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Frame

import static extension duc.uminijava.semantics.utils.ContextAspect.*

@Aspect(className=Frame)
class FrameAspect {

	def Frame findCurrentFrame() {
		if (_self.childFrame !== null) {
			return _self.childFrame.findCurrentFrame
		} else {
			return _self
		}
	}

	def Context findCurrentContext() {
		if (_self.childFrame !== null) {
			return _self.childFrame.findCurrentContext
		} else if (_self.rootContext !== null) {
			return _self.rootContext.findCurrentContext
		} else {
			return null
		}
	}

}