package duc.uminijava.semantics.utils

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import java.util.HashMap
import java.util.Map
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Context
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.SymbolBinding
import org.tetrabox.minijava.xtext.miniJava.Symbol

@Aspect(className=Context)
class ContextAspect {

	val Map<Symbol, SymbolBinding> cache = new HashMap

	def Context createChildContext() {
		return MinijavadynamicdataFactory::eINSTANCE.createContext => [
			parentContext = _self
		]
	}

	def SymbolBinding findBinding(Symbol symbol) {
		if (!_self.cache.containsKey(symbol)) {
			val binding = _self.bindings.findFirst[it.symbol === symbol]
			if (binding !== null) {
				_self.cache.put(symbol, binding)
			} else if (_self.parentContext !== null) {
				val binding2 = _self.parentContext.findBinding(symbol)
				_self.cache.put(symbol, binding2)
			} else {
				throw new Exception("No binding for symbol " + symbol)
			}
		}
		return _self.cache.get(symbol)
	}

	def Context findCurrentContext() {
		if (_self.childContext !== null) {
			return _self.childContext.findCurrentContext
		} else {
			return _self
		}
	}

}