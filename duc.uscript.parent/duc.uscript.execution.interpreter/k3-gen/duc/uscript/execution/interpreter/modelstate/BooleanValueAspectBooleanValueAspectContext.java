package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class BooleanValueAspectBooleanValueAspectContext {
  public static final BooleanValueAspectBooleanValueAspectContext INSTANCE = new BooleanValueAspectBooleanValueAspectContext();
  
  public static BooleanValueAspectBooleanValueAspectProperties getSelf(final BooleanValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<BooleanValue, BooleanValueAspectBooleanValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.BooleanValue, duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectProperties>();
  
  public Map<BooleanValue, BooleanValueAspectBooleanValueAspectProperties> getMap() {
    return map;
  }
}
