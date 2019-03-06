package duc.uscript.execution.interpreter.expression.bool;

import duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties;
import duc.uscript.uScript.Not;
import java.util.Map;

@SuppressWarnings("all")
public class NotAspectNotAspectContext {
  public static final NotAspectNotAspectContext INSTANCE = new NotAspectNotAspectContext();
  
  public static NotAspectNotAspectProperties getSelf(final Not _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Not, NotAspectNotAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Not, duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties>();
  
  public Map<Not, NotAspectNotAspectProperties> getMap() {
    return map;
  }
}
