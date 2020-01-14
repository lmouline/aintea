package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.ThisAspectThisAspectProperties;
import duc.uscript.uScript.This;
import java.util.Map;

@SuppressWarnings("all")
public class ThisAspectThisAspectContext {
  public static final ThisAspectThisAspectContext INSTANCE = new ThisAspectThisAspectContext();
  
  public static ThisAspectThisAspectProperties getSelf(final This _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.ThisAspectThisAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<This, ThisAspectThisAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.This, duc.uscript.execution.interpreter.expression.ThisAspectThisAspectProperties>();
  
  public Map<This, ThisAspectThisAspectProperties> getMap() {
    return map;
  }
}
