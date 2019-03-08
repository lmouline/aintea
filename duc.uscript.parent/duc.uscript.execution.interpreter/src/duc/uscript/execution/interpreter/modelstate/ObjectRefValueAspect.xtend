package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.ObjectRefValue
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.FieldBinding

@Aspect(className=ObjectRefValue)
class ObjectRefValueAspect extends ValueAspect {
	
	@OverrideAspectMethod
	def String convertToString() {
		val objInstance = _self.instance
		
		val StringBuilder builder = new StringBuilder
		builder.append(objInstance.type.name)
		builder.append('(')
		
		
		val fields = objInstance.fieldbindings
		for(var i =0; i<fields.size; i++) {
			val FieldBinding fBdg = fields.get(i)
			val fieldName = fBdg.field.name
			val value = fBdg.value.convertToString
			builder.append(fieldName + ":" + value)
			
			if(i<fields.size - 1) {
				builder.append(", ")
			}
		}
				
		builder.append(')')	
		
		return builder.toString
		
	}
	
	@OverrideAspectMethod
	def Value copy() { 
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [
			instance = _self.instance
		]
	}
}