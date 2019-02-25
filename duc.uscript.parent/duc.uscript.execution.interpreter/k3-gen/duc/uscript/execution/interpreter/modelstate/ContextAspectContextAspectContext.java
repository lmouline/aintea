package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Context;
import duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ContextAspectContextAspectContext {
  public static final ContextAspectContextAspectContext INSTANCE = new ContextAspectContextAspectContext();
  
  public static ContextAspectContextAspectProperties getSelf(final Context _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Context, ContextAspectContextAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.Context, duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties>();
  
  public Map<Context, ContextAspectContextAspectProperties> getMap() {
    return map;
  }
}
