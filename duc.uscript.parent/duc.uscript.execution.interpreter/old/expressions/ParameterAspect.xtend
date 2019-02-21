package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.tetrabox.minijava.xtext.miniJava.Parameter

import static extension duc.uminijava.semantics.expressions.TypeRefAspect.compare

@Aspect(className=Parameter)
class ParameterAspect {
	def boolean compare(Parameter other) {
		return _self.name == other.name && _self.typeRef.compare(other.typeRef)
	}
}