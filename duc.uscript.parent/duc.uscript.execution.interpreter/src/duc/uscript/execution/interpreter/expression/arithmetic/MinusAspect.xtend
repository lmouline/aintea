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
import duc.uscript.uScript.Minus

@Aspect(className=Minus)
class MinusAspect extends ExpressionAspect {
	
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
		}
	}
	
	// Right dispatch
	private static def Value left_plus(ByteValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, left, right, true)
			ShortValue: p(_self, left, right, true)
			IntegerValue: p(_self, left, right, true)
			LongValue: p(_self, left, right, true)
			FloatValue: p(_self, left, right, true)
			DoubleValue: p(_self, left, right, true)
		}
	}	
	
	private static def Value left_plus(ShortValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left, false)
			ShortValue: p(_self, left, right, true)
			IntegerValue: p(_self, left, right, true)
			LongValue: p(_self, left, right, true)
			FloatValue: p(_self, left, right, true)
			DoubleValue: p(_self, left, right, true)
		}
	}
	
	private static def Value left_plus(IntegerValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left, false)
			ShortValue: p(_self, right, left, false)
			IntegerValue: p(_self, left, right, true)
			LongValue: p(_self, left, right, true)
			FloatValue: p(_self, left, right, true)
			DoubleValue: p(_self, left, right, true)
		}
	}
	
	private static def Value left_plus(LongValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left, false)
			ShortValue: p(_self, right, left, false)
			IntegerValue: p(_self, right, left, false)
			LongValue: p(_self, left, right, true)
			FloatValue: p(_self, left, right, true)
			DoubleValue: p(_self, left, right, true)
		}
	}
	
	private static def Value left_plus(FloatValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left, false)
			ShortValue: p(_self, right, left, false)
			IntegerValue: p(_self, right, left, false)
			LongValue: p(_self, right, left, false)
			FloatValue: p(_self, left, right, true)
			DoubleValue: p(_self, left, right, true)
		}
	}
	
	private static def Value left_plus(DoubleValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left, false)
			ShortValue: p(_self, right, left, false)
			IntegerValue: p(_self, right, left, false)
			LongValue: p(_self, right, left, false)
			FloatValue: p(_self, right, left, false)
			DoubleValue: p(_self, left, right)
		}
	}
	
	
		
	// All possible combination
	private def ByteValue p(ByteValue x, ByteValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createByteValue => [
				if(normal) {
					value = (x.value - y.value) as byte
				} else {
					value = (y.value - x.value) as byte
				} 
			]
	}
	
	private def ShortValue p(ByteValue x, ShortValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createShortValue => [
				if(normal) {
					value = (x.value - y.value) as short
				} else {
					value = (y.value - x.value) as short
				} 
			]
	}
	
	private def IntegerValue p(ByteValue x, IntegerValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def LongValue p(ByteValue x, LongValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def FloatValue p(ByteValue x, FloatValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def DoubleValue p(ByteValue x, DoubleValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
		
	private def ShortValue p(ShortValue x, ShortValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createShortValue => [
				value = (x.value - y.value) as short
			]
	}
	
	private def IntegerValue p(ShortValue x, IntegerValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def LongValue p(ShortValue x, LongValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def FloatValue p(ShortValue x, FloatValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def DoubleValue p(ShortValue x, DoubleValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def IntegerValue p(IntegerValue x, IntegerValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def LongValue p(IntegerValue x, LongValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def FloatValue p(IntegerValue x, FloatValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def DoubleValue p(IntegerValue x, DoubleValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def LongValue p(LongValue x, LongValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def FloatValue p(LongValue x, FloatValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def DoubleValue p(LongValue x, DoubleValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def FloatValue p(FloatValue x, FloatValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def DoubleValue p(FloatValue x, DoubleValue y, boolean normal) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				if(normal) {
					value = x.value - y.value
				} else {
					value = y.value - x.value
				} 
			]
	}
	
	private def DoubleValue p(DoubleValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value - y.value
			]
	}
	
	
}