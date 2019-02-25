package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.LongValue;
import duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class LongValueAspectLongValueAspectContext {
  public static final LongValueAspectLongValueAspectContext INSTANCE = new LongValueAspectLongValueAspectContext();
  
  public static LongValueAspectLongValueAspectProperties getSelf(final LongValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LongValue, LongValueAspectLongValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.LongValue, duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectProperties>();
  
  public Map<LongValue, LongValueAspectLongValueAspectProperties> getMap() {
    return map;
  }
}
