package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Method
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.statement.BlockAspect.*

@Aspect(className=Method)
class MethodAspect {
//	Map<String, Method> cache = new HashMap
//	
//	def Method getCurrentOrOverride() {
//		if(!_self.cache.containsKey())
//	}

	def void call(State state) {
		_self.body.evaluateStatement(state)
	}


	
}