package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.xtext.miniJava.ClassRef
import org.tetrabox.minijava.xtext.miniJava.TypeRef

@Aspect(className=ClassRef)
class ClassRefAspect extends TypeRefAspect {
	@OverrideAspectMethod
	def boolean compare(TypeRef other) {
		if (other instanceof ClassRef) {
			return _self.referencedClass == other.referencedClass
		} else {
			return false;
		}
	}
}