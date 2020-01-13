package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.State
import duc.uscript.execution.Value
import duc.uscript.uScript.ComputeNbTrueExpr
import duc.aintea.lib.poissonbinomial.Computer

@Aspect(className=ComputeNbTrueExpr)
class ComputeNbrTrueExprAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet
	}
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val c = new Computer();
		c.big_compute();
		return null;
	}
}