package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties;
import duc.uscript.uScript.SymbolRef;
import java.util.Map;

@SuppressWarnings("all")
public class SymbolRefAspectSymbolRefAspectContext {
  public static final SymbolRefAspectSymbolRefAspectContext INSTANCE = new SymbolRefAspectSymbolRefAspectContext();
  
  public static SymbolRefAspectSymbolRefAspectProperties getSelf(final SymbolRef _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SymbolRef, SymbolRefAspectSymbolRefAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.SymbolRef, duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties>();
  
  public Map<SymbolRef, SymbolRefAspectSymbolRefAspectProperties> getMap() {
    return map;
  }
}
