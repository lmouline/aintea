package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.Expression

import static extension duc.uminijava.semantics.expressions.ExpressionAspect.*

@Aspect(className=Expression)
class ExpressionStatementAspect extends StatementAspect {
	@OverrideAspectMethod
	@Step
	def void evaluateStatement(State state) {
		_self.evaluateExpression(state)
	}
}