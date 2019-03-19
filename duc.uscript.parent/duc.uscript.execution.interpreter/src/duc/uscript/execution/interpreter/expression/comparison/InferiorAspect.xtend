package duc.uscript.execution.interpreter.expression.comparison

import duc.uscript.execution.ByteValue
import duc.uscript.execution.DoubleValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.FloatValue
import duc.uscript.execution.IntegerValue
import duc.uscript.execution.LongValue
import duc.uscript.execution.ShortValue
import duc.uscript.execution.State
import duc.uscript.execution.Value
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import duc.uscript.utils.SymbolSet
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.BooleanValue
import duc.uscript.utils.Range
import duc.uscript.uScript.DoubleConstant
import duc.uscript.uScript.IntConstant
import duc.uscript.utils.RangeFactory
import duc.uscript.uScript.LongConstant
import static extension duc.uscript.utils.LongConstantUtils.*
import duc.uscript.uScript.Inferior

@Aspect(className=Inferior)
class InferiorAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Range findRange(State state) {
		
		val left = _self.left
		switch(left) {
			DoubleConstant: return RangeFactory.createRangeWithLower(left.value, false)
			IntConstant: return RangeFactory.createRangeWithLower(left.value, false)
			LongConstant: return RangeFactory.createRangeWithLower(left.parseValue, false)
		}
		
		val right = _self.right
		switch(right) {
			DoubleConstant: return RangeFactory.createRangeWithUpper(right.value, false)
			IntConstant: return RangeFactory.createRangeWithUpper(right.value, false)
			LongConstant: return RangeFactory.createRangeWithUpper(right.parseValue, false)
		}
			
		return RangeFactory.createFullRange()
	}
	
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
		
		return switch (left) {
			ByteValue: rightDispatch(_self, left, right)
			ShortValue: rightDispatch(_self, left, right)
			IntegerValue: rightDispatch(_self, left, right)
			LongValue: rightDispatch(_self, left, right)
			FloatValue: rightDispatch(_self, left, right)
			DoubleValue: rightDispatch(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	//Right dispatch
	private static def Value rightDispatch(ByteValue left, Value right) {
		switch(right) {
			ByteValue: superior(_self, left, right, false)
			ShortValue: superior(_self, left, right, false)
			IntegerValue: superior(_self, left, right, false)
			LongValue: superior(_self, left, right, false)
			FloatValue: superior(_self, left, right, false)
			DoubleValue: superior(_self, left, right, false)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	private static def Value rightDispatch(ShortValue left, Value right) {
		switch(right) {
			ByteValue: superior(_self, right, left, true)
			ShortValue: superior(_self, left, right, false)
			IntegerValue: superior(_self, left, right, false)
			LongValue: superior(_self, left, right, false)
			FloatValue: superior(_self, left, right, false)
			DoubleValue: superior(_self, left, right, false)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	private static def Value rightDispatch(IntegerValue left, Value right) {
		switch(right) {
			ByteValue: superior(_self, right, left, true)
			ShortValue: superior(_self, right, left, true)
			IntegerValue: superior(_self, left, right, false)
			LongValue: superior(_self, left, right, false)
			FloatValue: superior(_self, left, right, false)
			DoubleValue: superior(_self, left, right, false)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	private static def Value rightDispatch(LongValue left, Value right) {
		switch(right) {
			ByteValue: superior(_self, right, left, true)
			ShortValue: superior(_self, right, left, true)
			IntegerValue: superior(_self, right, left, true)
			LongValue: superior(_self, left, right, false)
			FloatValue: superior(_self, left, right, false)
			DoubleValue: superior(_self, left, right, false)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	private static def Value rightDispatch(FloatValue left, Value right) {
		switch(right) {
			ByteValue: superior(_self, right, left, true)
			ShortValue: superior(_self, right, left, true)
			IntegerValue: superior(_self, right, left, true)
			LongValue: superior(_self, right, left, true)
			FloatValue: superior(_self, left, right, false)
			DoubleValue: superior(_self, left, right, false)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	private static def Value rightDispatch(DoubleValue left, Value right) {
		switch(right) {
			ByteValue: superior(_self, right, left, true)
			ShortValue: superior(_self, right, left, true)
			IntegerValue: superior(_self, right, left, true)
			LongValue: superior(_self, right, left, true)
			FloatValue: superior(_self, right, left, true)
			DoubleValue: superior(_self, left, right, false)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	//All possible combination
	private def BooleanValue superior(ByteValue x, ByteValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ByteValue x, ShortValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ByteValue x, IntegerValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ByteValue x, LongValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ByteValue x, FloatValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ByteValue x, DoubleValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
		
	private def BooleanValue superior(ShortValue x, ShortValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ShortValue x, IntegerValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ShortValue x, LongValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ShortValue x, FloatValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(ShortValue x, DoubleValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(IntegerValue x, IntegerValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(IntegerValue x, LongValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(IntegerValue x, FloatValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(IntegerValue x, DoubleValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(LongValue x, LongValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(LongValue x, FloatValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(LongValue x, DoubleValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(FloatValue x, FloatValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(FloatValue x, DoubleValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
	private def BooleanValue superior(DoubleValue x, DoubleValue y, boolean inverse) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
				if(inverse) {
					value = y.value < x.value
				} else {
					value = x.value < y.value
				}
			]
	}
	
}