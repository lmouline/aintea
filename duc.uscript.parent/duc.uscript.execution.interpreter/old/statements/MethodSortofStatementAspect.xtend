package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.Method

import static extension duc.uminijava.semantics.statements.BlockAspect.*

@Aspect(className=Method)
class MethodSortofStatementAspect {
	@Step
	def void call(State state) {
		_self.body.evaluateStatement(state)
	}
}