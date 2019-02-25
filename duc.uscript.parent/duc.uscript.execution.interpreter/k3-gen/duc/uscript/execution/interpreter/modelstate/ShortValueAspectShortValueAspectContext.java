package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ShortValue;
import duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ShortValueAspectShortValueAspectContext {
  public static final ShortValueAspectShortValueAspectContext INSTANCE = new ShortValueAspectShortValueAspectContext();
  
  public static ShortValueAspectShortValueAspectProperties getSelf(final ShortValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ShortValue, ShortValueAspectShortValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.ShortValue, duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectProperties>();
  
  public Map<ShortValue, ShortValueAspectShortValueAspectProperties> getMap() {
    return map;
  }
}
