package duc.uscript.execution.interpreter.expression.arithmetic;

import duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties;
import duc.uscript.uScript.Minus;
import java.util.Map;

@SuppressWarnings("all")
public class MinusAspectMinusAspectContext {
  public static final MinusAspectMinusAspectContext INSTANCE = new MinusAspectMinusAspectContext();
  
  public static MinusAspectMinusAspectProperties getSelf(final Minus _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Minus, MinusAspectMinusAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Minus, duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties>();
  
  public Map<Minus, MinusAspectMinusAspectProperties> getMap() {
    return map;
  }
}
