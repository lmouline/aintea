package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.This

import static extension duc.uminijava.semantics.utils.StateAspect.findCurrentFrame

@Aspect(className=This)
class ThisAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val currentInstance = state.findCurrentFrame.instance
		if (currentInstance === null) {
			throw new RuntimeException('''"this" is not valid in the current context''')
		} else {
			return MinijavadynamicdataFactory::eINSTANCE.createObjectRefValue => [instance = currentInstance]
		}
	}
}