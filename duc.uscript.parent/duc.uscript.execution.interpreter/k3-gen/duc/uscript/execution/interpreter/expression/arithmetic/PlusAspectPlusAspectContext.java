package duc.uscript.execution.interpreter.expression.arithmetic;

import duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties;
import duc.uscript.uScript.Plus;
import java.util.Map;

@SuppressWarnings("all")
public class PlusAspectPlusAspectContext {
  public static final PlusAspectPlusAspectContext INSTANCE = new PlusAspectPlusAspectContext();
  
  public static PlusAspectPlusAspectProperties getSelf(final Plus _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Plus, PlusAspectPlusAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Plus, duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties>();
  
  public Map<Plus, PlusAspectPlusAspectProperties> getMap() {
    return map;
  }
}
