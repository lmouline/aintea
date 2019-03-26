package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ArrayRefValueAspectArrayRefValueAspectContext {
  public static final ArrayRefValueAspectArrayRefValueAspectContext INSTANCE = new ArrayRefValueAspectArrayRefValueAspectContext();
  
  public static ArrayRefValueAspectArrayRefValueAspectProperties getSelf(final ArrayRefValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ArrayRefValue, ArrayRefValueAspectArrayRefValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.ArrayRefValue, duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectProperties>();
  
  public Map<ArrayRefValue, ArrayRefValueAspectArrayRefValueAspectProperties> getMap() {
    return map;
  }
}
