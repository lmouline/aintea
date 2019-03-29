package duc.uscript.execution.interpreter.expression.comparison;

import duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties;
import duc.uscript.uScript.Equality;
import java.util.Map;

@SuppressWarnings("all")
public class EqualityAspectEqualityAspectContext {
  public static final EqualityAspectEqualityAspectContext INSTANCE = new EqualityAspectEqualityAspectContext();
  
  public static EqualityAspectEqualityAspectProperties getSelf(final Equality _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Equality, EqualityAspectEqualityAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Equality, duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties>();
  
  public Map<Equality, EqualityAspectEqualityAspectProperties> getMap() {
    return map;
  }
}
