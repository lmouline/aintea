package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.ExistExpr
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.DoubleValue
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils
import duc.uscript.execution.ExecutionFactory

@Aspect(className=ExistExpr)
class ExistExprAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet
	}
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val ObjectRefValue uData = _self.expr.evaluateExpression(state) as ObjectRefValue
		val DoubleValue confidence = _self.confidence.evaluateExpression(state) as DoubleValue
		
		return exist(_self, uData, confidence.value)
		
	}
	
	private static def BooleanValue exist(ObjectRefValue bernRef, double conf) {
		val double prob = BernoulliBoolUtils.getProbability(bernRef).value
		
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = prob >= conf && (1-prob) >= conf
		]
	}
	
	
	
}