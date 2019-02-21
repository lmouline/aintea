package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.Block

import static extension duc.uminijava.semantics.utils.StateAspect.*

@Aspect(className=Block)
class BlockAspect extends StatementAspect {

	def void evaluateStatementKeepContext(State state) {
		state.pushNewContext
		val currentFrame = state.findCurrentFrame
		var i = _self.statements.iterator
		while (i.hasNext && currentFrame.returnValue === null) {
			i.next.evaluateStatement(state)
		}
	}

	@OverrideAspectMethod
	def void evaluateStatement(State state) {
		_self.evaluateStatementKeepContext(state)
		state.popCurrentContext
	}
}