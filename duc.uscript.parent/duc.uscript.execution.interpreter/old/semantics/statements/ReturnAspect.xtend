package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.Return

import static extension duc.uminijava.semantics.expressions.ExpressionAspect.*
import static extension duc.uminijava.semantics.utils.StateAspect.*

@Aspect(className=Return)
class ReturnAspect extends StatementAspect {
	@OverrideAspectMethod
	@Step
	def void evaluateStatement(State state) {
		val value = _self.expression.evaluateExpression(state);
		state.findCurrentFrame.returnValue = value
	}
}