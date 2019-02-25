package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.FloatValue;
import duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class FloatValueAspectFloatValueAspectContext {
  public static final FloatValueAspectFloatValueAspectContext INSTANCE = new FloatValueAspectFloatValueAspectContext();
  
  public static FloatValueAspectFloatValueAspectProperties getSelf(final FloatValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FloatValue, FloatValueAspectFloatValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.FloatValue, duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectProperties>();
  
  public Map<FloatValue, FloatValueAspectFloatValueAspectProperties> getMap() {
    return map;
  }
}
