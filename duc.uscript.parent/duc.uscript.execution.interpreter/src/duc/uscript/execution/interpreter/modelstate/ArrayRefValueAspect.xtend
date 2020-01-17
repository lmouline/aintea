package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.ArrayRefValue
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.ExecutionFactory

@Aspect(className=ArrayRefValue)
class ArrayRefValueAspect extends ValueAspect{
	
	@OverrideAspectMethod
	def String convertToString() {
//		val StringBuilder result = new StringBuilder()
//		result.append('[')
//		
//		val EList<Value> values = _self.instance.value
//		
//		for(var i=0; i<values.length; i++) {
//			result.append(values.get(i).convertToString)
//			if(i < values.length - 1) {
//				result.append(", ")
//			}
//		}
//		
//		result.append(']')
//		return result.toString
		return "Array@" + _self.instance.class.simpleName
	}
	
	@OverrideAspectMethod
	def Value copy() {
		return ExecutionFactory::eINSTANCE.createArrayRefValue => [
			instance = _self.instance
		]
	}
	
}