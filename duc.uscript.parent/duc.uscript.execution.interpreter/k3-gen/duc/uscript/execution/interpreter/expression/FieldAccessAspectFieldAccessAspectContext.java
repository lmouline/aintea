package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectProperties;
import duc.uscript.uScript.FieldAccess;
import java.util.Map;

@SuppressWarnings("all")
public class FieldAccessAspectFieldAccessAspectContext {
  public static final FieldAccessAspectFieldAccessAspectContext INSTANCE = new FieldAccessAspectFieldAccessAspectContext();
  
  public static FieldAccessAspectFieldAccessAspectProperties getSelf(final FieldAccess _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FieldAccess, FieldAccessAspectFieldAccessAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.FieldAccess, duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectProperties>();
  
  public Map<FieldAccess, FieldAccessAspectFieldAccessAspectProperties> getMap() {
    return map;
  }
}
