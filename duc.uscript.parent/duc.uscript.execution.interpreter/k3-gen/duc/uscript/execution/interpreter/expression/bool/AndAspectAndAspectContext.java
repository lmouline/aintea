package duc.uscript.execution.interpreter.expression.bool;

import duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties;
import duc.uscript.uScript.And;
import java.util.Map;

@SuppressWarnings("all")
public class AndAspectAndAspectContext {
  public static final AndAspectAndAspectContext INSTANCE = new AndAspectAndAspectContext();
  
  public static AndAspectAndAspectProperties getSelf(final And _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<And, AndAspectAndAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.And, duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties>();
  
  public Map<And, AndAspectAndAspectProperties> getMap() {
    return map;
  }
}
