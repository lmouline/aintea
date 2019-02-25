package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class DoubleValueAspectDoubleValueAspectContext {
  public static final DoubleValueAspectDoubleValueAspectContext INSTANCE = new DoubleValueAspectDoubleValueAspectContext();
  
  public static DoubleValueAspectDoubleValueAspectProperties getSelf(final DoubleValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DoubleValue, DoubleValueAspectDoubleValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.DoubleValue, duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectProperties>();
  
  public Map<DoubleValue, DoubleValueAspectDoubleValueAspectProperties> getMap() {
    return map;
  }
}
