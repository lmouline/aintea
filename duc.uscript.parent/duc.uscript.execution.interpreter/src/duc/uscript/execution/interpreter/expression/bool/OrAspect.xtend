package duc.uscript.execution.interpreter.expression.bool

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.Or
import duc.uscript.execution.ObjectRefValue
import static duc.uscript.execution.interpreter.utils.BernoulliBoolUtils.*
import duc.uscript.execution.DoubleValue

@Aspect(className=Or)
class OrAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value left = _self.left.evaluateExpression(state)
		val Value right = _self.right.evaluateExpression(state)
		
		//Left dispatch		
		return switch(left) {
			BooleanValue: rightDispatch(_self, left, right, state)
			ObjectRefValue: rightDispatch(_self, left, right, state)
			default: throw new RuntimeException("Not yet implemented for " + left.class.name)
		}
	}
	
	//Right dispatch
	private static def Value rightDispatch(BooleanValue left, Value right, State state) {
		return switch(right) {
			BooleanValue: private_or(_self, left, right)
			ObjectRefValue: private_or(_self, right, left, state)
			default: throw new RuntimeException("Not yet implemented for " + right.class.name)
		}
	}
	
	//Bernoulli<bool>
	private static def ObjectRefValue rightDispatch(ObjectRefValue left, Value right, State state) {
		return switch(right) {
			BooleanValue: private_or(_self, left, right, state)
			ObjectRefValue: private_or(_self, left, right, state)
			default: throw new RuntimeException("Not yet implemented for " + right.class.name)
		}
	}
	
	// All possible combination
	private static def BooleanValue private_or(BooleanValue x, BooleanValue y) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = x.value || y.value
		]
	}
	
	private static def ObjectRefValue private_or(ObjectRefValue x, ObjectRefValue y, State state) {
		val valX = getValue(x)
		val valY = getValue(y)
		
		val probX = getProbability(x)
		val probY = getProbability(y)
								 
		return indepNonDisjoint(_self, state, probX, probY, valX, valY)
	}
	
	private static def ObjectRefValue private_or(ObjectRefValue x, BooleanValue y, State state) {
		val valX = getValue(x)
		
		val probX = getProbability(x)
		val probY = ExecutionFactory::eINSTANCE.createDoubleValue => [
			value = if(y.value) {
						1
					} else {
						0
					}
		]
								 
		return indepNonDisjoint(_self, state, probX, probY, valX, y)
	}
	
	// All possible way to propagate uncertainty
	private static def ObjectRefValue indepNonDisjoint(State state, DoubleValue probX, DoubleValue probY, 
																BooleanValue valX, BooleanValue valY)
	{
		val result = createBernoulliBool(state, 
									     probX.value + probY.value - (probX.value * probY.value), 
									     valX.value || valY.value, 
									     _self)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
}