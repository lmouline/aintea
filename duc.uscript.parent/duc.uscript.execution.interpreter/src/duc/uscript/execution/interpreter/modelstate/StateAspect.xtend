package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.State
import duc.uscript.execution.Context
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.Frame

import static extension duc.uscript.execution.interpreter.modelstate.FrameAspect.*
import duc.uscript.execution.ObjectInstance
import duc.uscript.execution.Call

@Aspect(className=State)
class StateAspect {
	var Context context
	var Frame frame
	
	def Context findCurrentContext() {
		if(_self.context === null) {
			_self.context = _self.frame.findCurrentContext
		}
		
		return _self.context
	}
	
	def Frame findCurrentFrame() {
		if(_self.frame === null) {
			_self.frame = _self.rootFrame.findCurrentFrame
		}
		return _self.frame
	}
	
	def void pushNewContext() {
		val newContext = ExecutionFactory::eINSTANCE.createContext
		if (_self.findCurrentContext !== null) {
			_self.findCurrentContext.child = newContext
		} else {
			_self.findCurrentFrame.rootContext = newContext
		}
		
		_self.context = newContext
	}
	
	def void popCurrentContext() {
		val newCurrent = _self.findCurrentContext.parent
		_self.findCurrentContext.parent = null
		_self.context = newCurrent
	}
	
	def void print(String string) {
		_self.outputStream.stream.add(string)
	}
	
	def void pushNewFrame(ObjectInstance receiver, Call c, Context ctx) {
		val newFrame = ExecutionFactory::eINSTANCE.createFrame => [
			instance = receiver
			call = c
			rootContext = ctx
		]
		
		_self.findCurrentFrame.child = newFrame
		_self.frame = newFrame
		_self.context = null
	}
	
	def void popCurrentFrame() {
		val newCurrent = _self.findCurrentFrame.parent
		_self.findCurrentFrame.parent = null;
		_self.context = null
		_self.frame = newCurrent
	}
}