package duc.uscript.execution.interpreter.expression.bool;

import duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties;
import duc.uscript.uScript.Or;
import java.util.Map;

@SuppressWarnings("all")
public class OrAspectOrAspectContext {
  public static final OrAspectOrAspectContext INSTANCE = new OrAspectOrAspectContext();
  
  public static OrAspectOrAspectProperties getSelf(final Or _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Or, OrAspectOrAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Or, duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties>();
  
  public Map<Or, OrAspectOrAspectProperties> getMap() {
    return map;
  }
}
