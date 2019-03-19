package duc.uscript.execution.interpreter.expression.bool

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.And
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.ObjectRefValue
import static duc.uscript.execution.interpreter.utils.BernoulliBoolUtils.*
import duc.uscript.execution.DoubleValue
import duc.uscript.utils.SymbolSet
import duc.uscript.utils.Range
import duc.uscript.utils.SimpleRange

@Aspect(className=And)
class AndAspect extends ExpressionAspect{
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		val result = new SymbolSet
		result.addAll(_self.left.findDependentVariables(state))
		result.addAll(_self.right.findDependentVariables(state))
		return result
	}
	
	
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
			BooleanValue: private_and(_self, left, right)
			ObjectRefValue: private_and(_self, right, left, state)
			default: throw new RuntimeException("Not yet implemented for " + right.class.name)
		}
	}
	
	private static def ObjectRefValue rightDispatch(ObjectRefValue left, Value right, State state) {
		return switch(right) {
			BooleanValue: private_and(_self, left, right, state)
			ObjectRefValue: private_and(_self, left, right, state)
			default: throw new RuntimeException("Not yet implemented for " + right.class.name)
		}
	}
	
	// All possible combination
	private static def BooleanValue private_and(BooleanValue x, BooleanValue y) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = x.value && y.value
		]
	}
	
	private static def ObjectRefValue private_and(ObjectRefValue x, ObjectRefValue y, State state) {
		val valX = getValue(x)
		val valY = getValue(y)
		
		val probX = getProbability(x)
		val probY = getProbability(y)
		
		val SymbolSet depValLeft = _self.left.findDependentVariables(state)
		val SymbolSet depValRight = _self.right.findDependentVariables(state)
		
		val SimpleRange leftRange = _self.left.findRange(state) as SimpleRange
		val SimpleRange rightRange = _self.right.findRange(state) as SimpleRange
		
		val areDependent = depValLeft.containsOne(depValRight)
		val areDisjoint = leftRange.intersectionIsNull(rightRange)
		
		if(areDisjoint) {
			return disjoint(_self, state, probX, probY, valX, valY)
		}
		
		if(areDependent) {
			return depNonDisjoint(_self, state, probX, probY, valX, valY)
		}
		
		return indepNonDisjoint(_self, state, probX, probY, valX, valY)
		
	}
	
	private static def ObjectRefValue private_and(ObjectRefValue x, BooleanValue y, State state) {
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
									     probX.value * probY.value, 
									     valX.value && valY.value, 
									     _self)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
	
	private static def ObjectRefValue depNonDisjoint(State state, DoubleValue probX, DoubleValue probY, 
																BooleanValue valX, BooleanValue valY) {
		throw new UnsupportedOperationException("And operator cannot be applied on dependent and non-disjoint elements.")									
	
	
	}
	
	private static def ObjectRefValue disjoint(State state, DoubleValue probX, DoubleValue probY, 
																BooleanValue valX, BooleanValue valY)
	{
		val result = createBernoulliBool(state, 
									     0, 
									     false, 
									     _self)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
	
																
	
	
}