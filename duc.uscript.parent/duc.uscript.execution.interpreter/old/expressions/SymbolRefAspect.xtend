package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.SymbolRef

import static extension duc.uminijava.semantics.utils.StateAspect.findCurrentContext
import static extension duc.uminijava.semantics.utils.ContextAspect.findBinding
import static extension duc.uminijava.semantics.utils.ValueAspect.copy

@Aspect(className=SymbolRef)
class SymbolRefAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		state.findCurrentContext.findBinding(_self.symbol).value.copy 
	}
}