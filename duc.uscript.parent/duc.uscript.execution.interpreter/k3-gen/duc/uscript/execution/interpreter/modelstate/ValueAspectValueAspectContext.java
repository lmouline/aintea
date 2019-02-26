package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ValueAspectValueAspectContext {
  public static final ValueAspectValueAspectContext INSTANCE = new ValueAspectValueAspectContext();
  
  public static ValueAspectValueAspectProperties getSelf(final Value _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Value, ValueAspectValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.Value, duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties>();
  
  public Map<Value, ValueAspectValueAspectProperties> getMap() {
    return map;
  }
}
