package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.tetrabox.minijava.xtext.miniJava.TypeRef

@Aspect(className=TypeRef)
class TypeRefAspect {
	def boolean compare(TypeRef other) { 
		return _self.eClass == other.eClass
	}
}