package duc.uscript.execution.interpreter.utils

import duc.uscript.uScript.Symbol
import java.util.Set
import java.util.Collection
import java.util.Map
import java.util.HashMap

class SymbolSet implements Set<Symbol> {
	Map<String, Symbol> map
	
	new() {
		map = new HashMap
	}
	
	override boolean add(Symbol symbol) {
		return map.put(symbol.name, symbol) === null
	}
	
	override boolean addAll(Collection<? extends Symbol> collection) {
		if(collection === null) {
			throw new NullPointerException
		}
		
		var isModified = false
		for(Symbol s: collection) {
			isModified = isModified || add(s)
		}
		
		return true
	}
	
	override clear() {
		map.clear()
	}
	
	override contains(Object o) {
		if(o === null) {
			throw new NullPointerException
		}
		
		if(!(o instanceof Symbol)) {
			return false
		}
		
		return map.containsKey((o as Symbol).name)
	}
	
	override containsAll(Collection<?> c) {
		for(Object o: c) {
			if(!contains(o)) {
				return false
			}
		}
		
		return true
	}
	
	/** 
	 * Return true if the current contains at least one element
	 * of the other
	 */
	def boolean containsOne(SymbolSet other) {
		for (Symbol o : other) {
			if (contains(o)) {
				return true
			}
		}

		return false

	}
	
	override isEmpty() {
		return map.isEmpty
	}
	
	override iterator() {
		return map.values.iterator
	}
	
	override remove(Object o) {
		if(o === null) {
			throw new NullPointerException
		}
		
		if(!(o instanceof Symbol)) {
			return false
		}
		
		return map.remove((o as Symbol).name) !== null
	}
	
	override removeAll(Collection<?> c) {
		var modified = false
		for(Object o: c) {
			modified = modified || remove(o)
		}
		
		return modified
	}
	
	override retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override size() {
		return map.size
	}
	
	override toArray() {
		return map.values.toArray
	}
	
	override <T> toArray(T[] a) {
		return map.values.toArray(a)
	}
	
	
	
}