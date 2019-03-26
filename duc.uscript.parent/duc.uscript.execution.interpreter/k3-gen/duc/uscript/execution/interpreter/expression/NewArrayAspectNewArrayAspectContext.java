package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectProperties;
import duc.uscript.uScript.NewArray;
import java.util.Map;

@SuppressWarnings("all")
public class NewArrayAspectNewArrayAspectContext {
  public static final NewArrayAspectNewArrayAspectContext INSTANCE = new NewArrayAspectNewArrayAspectContext();
  
  public static NewArrayAspectNewArrayAspectProperties getSelf(final NewArray _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NewArray, NewArrayAspectNewArrayAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.NewArray, duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectProperties>();
  
  public Map<NewArray, NewArrayAspectNewArrayAspectProperties> getMap() {
    return map;
  }
}
