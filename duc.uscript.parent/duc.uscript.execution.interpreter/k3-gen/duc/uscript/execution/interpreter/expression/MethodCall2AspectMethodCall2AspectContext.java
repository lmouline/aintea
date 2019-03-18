package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectProperties;
import duc.uscript.uScript.MethodCall2;
import java.util.Map;

@SuppressWarnings("all")
public class MethodCall2AspectMethodCall2AspectContext {
  public static final MethodCall2AspectMethodCall2AspectContext INSTANCE = new MethodCall2AspectMethodCall2AspectContext();
  
  public static MethodCall2AspectMethodCall2AspectProperties getSelf(final MethodCall2 _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MethodCall2, MethodCall2AspectMethodCall2AspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.MethodCall2, duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectProperties>();
  
  public Map<MethodCall2, MethodCall2AspectMethodCall2AspectProperties> getMap() {
    return map;
  }
}
