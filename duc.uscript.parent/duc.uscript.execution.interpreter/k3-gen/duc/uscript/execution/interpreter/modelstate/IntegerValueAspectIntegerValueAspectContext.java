package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class IntegerValueAspectIntegerValueAspectContext {
  public static final IntegerValueAspectIntegerValueAspectContext INSTANCE = new IntegerValueAspectIntegerValueAspectContext();
  
  public static IntegerValueAspectIntegerValueAspectProperties getSelf(final IntegerValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IntegerValue, IntegerValueAspectIntegerValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.IntegerValue, duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectProperties>();
  
  public Map<IntegerValue, IntegerValueAspectIntegerValueAspectProperties> getMap() {
    return map;
  }
}
