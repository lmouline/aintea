package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.Value

@Aspect(className=Value)
class ValueAspect {
	
	def String convertToString() {
		throw new RuntimeException('''convertToString is not defined for «_self.class.name»''')
	}
	
	def Value copy() {
		throw new RuntimeException('''copy is not defined for «_self.class.name»''')
	}
	
}