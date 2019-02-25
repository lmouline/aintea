package duc.uscript.execution.interpreter.statement

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Block
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.modelstate.StateAspect.*
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

@Aspect(className=Block)
class BlockAspect extends AStatementAspect {
	
	def void evaluateStatementKeepContext(State state) {
		state.pushNewContext
		val currentFrame = state.findCurrentFrame
		var i = _self.statements.iterator
		
		while( i.hasNext && currentFrame.value === null) {
			i.next.evaluateStatement(state)
		}
	}
	
	@OverrideAspectMethod
	def void evaluateStatement(State state) {
		_self.evaluateStatementKeepContext(state)
		state.popCurrentContext
	}
}