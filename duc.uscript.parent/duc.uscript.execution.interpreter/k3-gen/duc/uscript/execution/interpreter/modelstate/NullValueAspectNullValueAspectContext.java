package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.NullValue;
import duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class NullValueAspectNullValueAspectContext {
  public static final NullValueAspectNullValueAspectContext INSTANCE = new NullValueAspectNullValueAspectContext();
  
  public static NullValueAspectNullValueAspectProperties getSelf(final NullValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NullValue, NullValueAspectNullValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.NullValue, duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectProperties>();
  
  public Map<NullValue, NullValueAspectNullValueAspectProperties> getMap() {
    return map;
  }
}
