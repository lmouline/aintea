package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Neg
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.LongValue
import duc.uscript.execution.IntegerValue
import duc.uscript.execution.ByteValue
import duc.uscript.execution.DoubleValue
import javax.sound.sampled.FloatControl.Type
import duc.uscript.execution.FloatValue

@Aspect(className=Neg)
class NegAspectImpl extends ExpressionAspect{
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val res = _self.expression.evaluateExpression(state);
		
		switch(res) {
			LongValue: res.value = -res.value
			IntegerValue: res.value = -res.value
			ByteValue: res.value = (-res.value) as byte
			DoubleValue: res.value = -res.value
			FloatValue: res.value = -res.value
			default: throw new RuntimeException("Not implemented for " + res)
		}
		
		return res
	}
}