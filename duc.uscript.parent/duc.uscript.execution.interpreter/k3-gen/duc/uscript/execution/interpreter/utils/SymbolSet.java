package duc.uscript.execution.interpreter.utils;

import duc.uscript.uScript.Symbol;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
public class SymbolSet implements Set<Symbol> {
  private Map<String, Symbol> map;
  
  public SymbolSet() {
    HashMap<String, Symbol> _hashMap = new HashMap<String, Symbol>();
    this.map = _hashMap;
  }
  
  @Override
  public boolean add(final Symbol symbol) {
    Symbol _put = this.map.put(symbol.getName(), symbol);
    return (_put == null);
  }
  
  @Override
  public boolean addAll(final Collection<? extends Symbol> collection) {
    if ((collection == null)) {
      throw new NullPointerException();
    }
    boolean isModified = false;
    for (final Symbol s : collection) {
      isModified = (isModified || this.add(s));
    }
    return true;
  }
  
  @Override
  public void clear() {
    this.map.clear();
  }
  
  @Override
  public boolean contains(final Object o) {
    if ((o == null)) {
      throw new NullPointerException();
    }
    if ((!(o instanceof Symbol))) {
      return false;
    }
    return this.map.containsKey(((Symbol) o).getName());
  }
  
  @Override
  public boolean containsAll(final Collection<?> c) {
    for (final Object o : c) {
      boolean _contains = this.contains(o);
      boolean _not = (!_contains);
      if (_not) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * Return true if the current contains at least one element
   * of the other
   */
  public boolean containsOne(final SymbolSet other) {
    for (final Symbol o : other) {
      boolean _contains = this.contains(o);
      if (_contains) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public boolean isEmpty() {
    return this.map.isEmpty();
  }
  
  @Override
  public Iterator<Symbol> iterator() {
    return this.map.values().iterator();
  }
  
  @Override
  public boolean remove(final Object o) {
    if ((o == null)) {
      throw new NullPointerException();
    }
    if ((!(o instanceof Symbol))) {
      return false;
    }
    Symbol _remove = this.map.remove(((Symbol) o).getName());
    return (_remove != null);
  }
  
  @Override
  public boolean removeAll(final Collection<?> c) {
    boolean modified = false;
    for (final Object o : c) {
      modified = (modified || this.remove(o));
    }
    return modified;
  }
  
  @Override
  public boolean retainAll(final Collection<?> c) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public int size() {
    return this.map.size();
  }
  
  @Override
  public Object[] toArray() {
    return this.map.values().toArray();
  }
  
  @Override
  public <T extends Object> T[] toArray(final T[] a) {
    return this.map.values().<T>toArray(a);
  }
}
