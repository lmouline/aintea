package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties;
import duc.uscript.uScript.ArrayAccess;
import java.util.Map;

@SuppressWarnings("all")
public class ArrayAccessImplArrayAccessAspectContext {
  public static final ArrayAccessImplArrayAccessAspectContext INSTANCE = new ArrayAccessImplArrayAccessAspectContext();
  
  public static ArrayAccessImplArrayAccessAspectProperties getSelf(final ArrayAccess _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ArrayAccess, ArrayAccessImplArrayAccessAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.ArrayAccess, duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties>();
  
  public Map<ArrayAccess, ArrayAccessImplArrayAccessAspectProperties> getMap() {
    return map;
  }
}
