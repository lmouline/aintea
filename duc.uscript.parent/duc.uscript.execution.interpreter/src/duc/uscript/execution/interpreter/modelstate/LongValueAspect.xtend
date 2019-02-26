package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.LongValue
import duc.uscript.execution.Value
import duc.uscript.execution.ExecutionFactory

@Aspect(className=LongValue)
class LongValueAspect extends ValueAspect {
	
	@OverrideAspectMethod
	def String convertToString() {
		return _self.value.toString
	}
	
	@OverrideAspectMethod
	def Value copy() { 
		return ExecutionFactory::eINSTANCE.createLongValue =>[
			value = _self.value
		]
	}
}
