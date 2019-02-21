package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.WhileStatement

import static extension duc.uminijava.semantics.expressions.ExpressionAspect.*
import static extension duc.uminijava.semantics.statements.BlockAspect.*

@Aspect(className=WhileStatement)
class WhileStatementAspect extends StatementAspect {
	@OverrideAspectMethod
	@Step
	def void evaluateStatement(State state) {
		while ((_self.condition.evaluateExpression(state) as BooleanValue).value) {
			_self.block.evaluateStatement(state)
		}
	}
}