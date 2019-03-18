package duc.uscript.execution.interpreter.expression.arithmetic

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import duc.uscript.execution.Value
import duc.uscript.execution.State
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.ByteValue
import duc.uscript.execution.ShortValue
import duc.uscript.execution.IntegerValue
import duc.uscript.execution.LongValue
import duc.uscript.execution.FloatValue
import duc.uscript.execution.DoubleValue
import duc.uscript.uScript.Multiplication
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.interpreter.utils.GaussianDoubleUtils
import duc.uscript.execution.interpreter.utils.SymbolSet

@Aspect(className=Multiplication)
class MultiplicationAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value left = _self.left.evaluateExpression(state)
		val Value right = _self.right.evaluateExpression(state)
				
		// Left dispatch
		return switch (left) {
			ByteValue: left_plus(_self, left, right)
			ShortValue: left_plus(_self, left, right)
			IntegerValue: left_plus(_self, left, right)
			LongValue: left_plus(_self, left, right)
			FloatValue: left_plus(_self, left, right)
			DoubleValue: left_plus(_self, left, right)
			ObjectRefValue: left_plus(_self, state, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	// Right dispatch
	private static def Value left_plus(ByteValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, left, right)
			ShortValue: p(_self, left, right)
			IntegerValue: p(_self, left, right)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}	
	
	private static def Value left_plus(ShortValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, left, right)
			IntegerValue: p(_self, left, right)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(IntegerValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, left, right)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(LongValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, right, left)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(FloatValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, right, left)
			LongValue: p(_self, right, left)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(DoubleValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, right, left)
			LongValue: p(_self, right, left)
			FloatValue: p(_self, right, left)
			DoubleValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(State state, ObjectRefValue left, Value right) {
		return switch(right) {
			IntegerValue: p(_self, state, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
			
	// All possible combination
	private def ByteValue p(ByteValue x, ByteValue y) {
		return ExecutionFactory::eINSTANCE.createByteValue => [
				value = (x.value * y.value) as byte
			]
	}
	
	private def ShortValue p(ByteValue x, ShortValue y) {
		return ExecutionFactory::eINSTANCE.createShortValue => [
				value = (x.value * y.value) as short
			]
	}
	
	private def IntegerValue p(ByteValue x, IntegerValue y) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				value = x.value * y.value
			]
	}
	
	private def LongValue p(ByteValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value * y.value
			]
	}
	
	private def FloatValue p(ByteValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value * y.value
			]
	}
	
	private def DoubleValue p(ByteValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value * y.value
			]
	}
		
	private def ShortValue p(ShortValue x, ShortValue y) {
		return ExecutionFactory::eINSTANCE.createShortValue => [
				value = (x.value * y.value) as short
			]
	}
	
	private def IntegerValue p(ShortValue x, IntegerValue y) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				value = x.value * y.value
			]
	}
	
	private def LongValue p(ShortValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value * y.value
			]
	}
	
	private def FloatValue p(ShortValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value * y.value
			]
	}
	
	private def DoubleValue p(ShortValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value * y.value
			]
	}
	
	private def IntegerValue p(IntegerValue x, IntegerValue y) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				value = x.value * y.value
			]
	}
	
	private def LongValue p(IntegerValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value * y.value
			]
	}
	
	private def FloatValue p(IntegerValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value * y.value
			]
	}
	
	private def DoubleValue p(IntegerValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value * y.value
			]
	}
	
	private def LongValue p(LongValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value * y.value
			]
	}
	
	private def FloatValue p(LongValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value * y.value
			]
	}
	
	private def DoubleValue p(LongValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value * y.value
			]
	}
	
	private def FloatValue p(FloatValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value * y.value
			]
	}
	
	private def DoubleValue p(FloatValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value * y.value
			]
	}
	
	private def DoubleValue p(DoubleValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value * y.value
			]
	}
	
	private def ObjectRefValue p(State state, ObjectRefValue x, IntegerValue y) {
		val valX = GaussianDoubleUtils.getValue(x)
		val meanX = GaussianDoubleUtils.getMean(x)
		val varX = GaussianDoubleUtils.getVariance(x)
		
		val result = GaussianDoubleUtils.createGaussianDouble(state,
															  meanX.value * y.value,
															  varX.value * y.value * y.value,
															  valX.value * y.value,
															  _self
		)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
		
		
		
	}
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		val result = new SymbolSet
		result.addAll(_self.left.findDependentVariables(state))
		result.addAll(_self.right.findDependentVariables(state))
		return result
	}
	
	
}