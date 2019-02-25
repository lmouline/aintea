package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.StringValue;
import duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class StringValueAspectStringValueAspectContext {
  public static final StringValueAspectStringValueAspectContext INSTANCE = new StringValueAspectStringValueAspectContext();
  
  public static StringValueAspectStringValueAspectProperties getSelf(final StringValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StringValue, StringValueAspectStringValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.StringValue, duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectProperties>();
  
  public Map<StringValue, StringValueAspectStringValueAspectProperties> getMap() {
    return map;
  }
}
