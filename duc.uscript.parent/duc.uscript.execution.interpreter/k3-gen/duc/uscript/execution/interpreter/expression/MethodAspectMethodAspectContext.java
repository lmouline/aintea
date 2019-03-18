package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.MethodAspectMethodAspectProperties;
import duc.uscript.uScript.Method;
import java.util.Map;

@SuppressWarnings("all")
public class MethodAspectMethodAspectContext {
  public static final MethodAspectMethodAspectContext INSTANCE = new MethodAspectMethodAspectContext();
  
  public static MethodAspectMethodAspectProperties getSelf(final Method _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.MethodAspectMethodAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Method, MethodAspectMethodAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Method, duc.uscript.execution.interpreter.expression.MethodAspectMethodAspectProperties>();
  
  public Map<Method, MethodAspectMethodAspectProperties> getMap() {
    return map;
  }
}
