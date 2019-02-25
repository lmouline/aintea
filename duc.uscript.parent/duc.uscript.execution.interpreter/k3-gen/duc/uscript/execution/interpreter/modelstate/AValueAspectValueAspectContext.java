package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class AValueAspectValueAspectContext {
  public static final AValueAspectValueAspectContext INSTANCE = new AValueAspectValueAspectContext();
  
  public static AValueAspectValueAspectProperties getSelf(final Value _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Value, AValueAspectValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.Value, duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties>();
  
  public Map<Value, AValueAspectValueAspectProperties> getMap() {
    return map;
  }
}
