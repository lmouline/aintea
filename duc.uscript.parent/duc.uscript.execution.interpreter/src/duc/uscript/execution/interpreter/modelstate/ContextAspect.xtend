package duc.uscript.execution.interpreter.modelstate

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.Context
import duc.uscript.uScript.Symbol
import duc.uscript.execution.SymbolBindings
import java.util.HashMap
import java.util.Map

@Aspect(className=Context)
class ContextAspect {
	val Map<Symbol, SymbolBindings> cache = new HashMap
	
	def Context findCurrentContext() {
		if(_self.child !== null) {
			return _self.child.findCurrentContext
		} else {
			return _self
		}
	}
	
	def SymbolBindings findBinding(Symbol symbol) {
		if (!_self.cache.containsKey(symbol)) {
			val binding = _self.bindings.findFirst[it.symbol === symbol]
			if (binding !== null) {
				_self.cache.put(symbol, binding)
			} else if (_self.parent !== null) {
				val binding2 = _self.parent.findBinding(symbol)
				_self.cache.put(symbol, binding2)
			} else {
				throw new Exception("No binding for symbol " + symbol)
			}
		}
		return _self.cache.get(symbol)
	}
	
}