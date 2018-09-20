package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Call
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Context
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Frame
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance
import org.tetrabox.minijava.dynamic.minijavadynamicdata.OutputStream
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State

import static extension duc.uminijava.semantics.utils.FrameAspect.*

@Aspect(className=State)
class StateAspect {

	var Frame frameCache
	var Context contextCache
	var OutputStream javaOutputStream

	def Frame findCurrentFrame() {
		if (_self.frameCache === null) {
			_self.frameCache = _self.rootFrame.findCurrentFrame
		}
		return _self.frameCache
	}

	def Context findCurrentContext() {
		if (_self.contextCache === null) {
			_self.contextCache = _self.rootFrame.findCurrentContext
		}
		return _self.contextCache
	}

	def void println(String string) {
//		println(string)
		_self.outputStream.stream.add(string) //Usage ???
	}

	def void pushNewContext() {
		val newContext = MinijavadynamicdataFactory::eINSTANCE.createContext
		if (_self.findCurrentContext !== null) {
			_self.findCurrentContext.childContext = newContext
		} else {
			_self.findCurrentFrame.rootContext = newContext
		}
		_self.contextCache = newContext
	}

	def void popCurrentContext() {
		val newCurrent = _self.findCurrentContext.parentContext
		_self.findCurrentContext.parentContext = null
		_self.contextCache = newCurrent
	}

	def void pushNewFrame(ObjectInstance receiver, Call c, Context newContext) {
		val newFrame = MinijavadynamicdataFactory::eINSTANCE.createFrame => [
			instance = receiver
			call = c
			rootContext = newContext
		]
		_self.findCurrentFrame.childFrame = newFrame
		_self.frameCache = newFrame
		_self.contextCache = null

	}

	def void popCurrentFrame() {
		val newCurrent = _self.findCurrentFrame.parentFrame
		_self.findCurrentFrame.parentFrame = null;
		_self.contextCache = null
		_self.frameCache = newCurrent
	}

}