package duc.uscript.execution.interpreter.expression.comparison;

import duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties;
import duc.uscript.uScript.Superior;
import java.util.Map;

@SuppressWarnings("all")
public class SuperiorAspectSuperiorAspectContext {
  public static final SuperiorAspectSuperiorAspectContext INSTANCE = new SuperiorAspectSuperiorAspectContext();
  
  public static SuperiorAspectSuperiorAspectProperties getSelf(final Superior _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Superior, SuperiorAspectSuperiorAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Superior, duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties>();
  
  public Map<Superior, SuperiorAspectSuperiorAspectProperties> getMap() {
    return map;
  }
}
