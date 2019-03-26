package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.NullValue
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.ExecutionFactory

@Aspect(className=NullValue)
class NullValueAspect extends ValueAspect{
	
	@OverrideAspectMethod
	def String convertToString() {
		return "null"
	}
	
	def Value copy() {
		return ExecutionFactory::eINSTANCE.createNullValue
	}
}