package duc.uscript.execution.interpreter.expression.comparison

import duc.uscript.uScript.Equality
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.IntegerValue
import duc.uscript.execution.ExecutionFactory
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

@Aspect(className=Equality)
class EqualityAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet
	}
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value leftVal = _self.left.evaluateExpression(state)
		val Value rightVal = _self.right.evaluateExpression(state)
		
		return switch(leftVal) {
			IntegerValue: rightDispatch(_self, leftVal, rightVal)
			default: throw new RuntimeException("Equality operator not implemented for " + leftVal.class.name)
		}
	}
	
	private static def BooleanValue rightDispatch(IntegerValue left, Value right) {
		return switch(right) {
			IntegerValue: strictEquality(_self, left, right)
			default: throw new RuntimeException("Equality operator not implemented for " + right.class.name)
		}
	}
	
	
	
	private static def BooleanValue strictEquality(IntegerValue x, IntegerValue y) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = x.value == y.value
		]
	}
	
}