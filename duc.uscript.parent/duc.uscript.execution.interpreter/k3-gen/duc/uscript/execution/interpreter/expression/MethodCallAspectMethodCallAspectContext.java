package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectProperties;
import duc.uscript.uScript.MethodCall;
import java.util.Map;

@SuppressWarnings("all")
public class MethodCallAspectMethodCallAspectContext {
  public static final MethodCallAspectMethodCallAspectContext INSTANCE = new MethodCallAspectMethodCallAspectContext();
  
  public static MethodCallAspectMethodCallAspectProperties getSelf(final MethodCall _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MethodCall, MethodCallAspectMethodCallAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.MethodCall, duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectProperties>();
  
  public Map<MethodCall, MethodCallAspectMethodCallAspectProperties> getMap() {
    return map;
  }
}
