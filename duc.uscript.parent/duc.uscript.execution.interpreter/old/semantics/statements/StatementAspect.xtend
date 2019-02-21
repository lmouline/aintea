package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.Statement

@Aspect(className=Statement)
class StatementAspect {
	@Step
	def void evaluateStatement(State state) {
		throw new RuntimeException('''evaluate should be overriden for type «_self.class.name»''')
	}
}
