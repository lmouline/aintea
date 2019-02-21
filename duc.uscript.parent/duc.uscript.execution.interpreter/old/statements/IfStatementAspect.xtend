package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.IfStatement

import static extension duc.uminijava.semantics.ImplicitConversionUtil.*
import static extension duc.uminijava.semantics.expressions.ExpressionAspect.*
import static extension duc.uminijava.semantics.statements.BlockAspect.*

@Aspect(className=IfStatement)
class IfStatementAspect extends StatementAspect {
	@OverrideAspectMethod
	@Step
	def void evaluateStatement(State state) {
		val condition = _self.expression.evaluateExpression(state).toBool
		if (condition.value) {
			_self.thenBlock.evaluateStatement(state)
		} else if (_self.elseBlock !== null) {
			_self.elseBlock.evaluateStatement(state)
		}
	}
}