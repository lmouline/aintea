package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import java.util.HashMap
import java.util.Map
import org.tetrabox.minijava.xtext.miniJava.Method
import org.tetrabox.minijava.xtext.miniJava.Class

import static extension duc.uminijava.semantics.expressions.TypeRefAspect.compare
import static extension duc.uminijava.semantics.expressions.ParameterAspect.compare

@Aspect(className=Method)
class MethodAspect {

	Map<Class, Method> cache = new HashMap

	def Method findOverride(Class c) {

		if (!_self.cache.containsKey(c)) {
			val result = if (c.members.contains(_self)) {
					_self
				} else {

					val candidate = c.members.filter(Method).findFirst [
						it.name == _self.name && it.params.size == _self.params.size &&
							it.typeRef.compare(_self.typeRef) && it.params.forall [ p1 |
								_self.params.exists [ p2 |
									p1.compare(p2)
								]
							]
					]

					if (candidate !== null) {
						candidate
					} else if (c.superClass !== null) {
						_self.findOverride(c.superClass)
					} else {
						null
					}
				}
			_self.cache.put(c, result)
		}

		return _self.cache.get(c)
	}
}