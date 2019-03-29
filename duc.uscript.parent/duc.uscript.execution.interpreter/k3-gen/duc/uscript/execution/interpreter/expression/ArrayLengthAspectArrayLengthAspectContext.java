package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectProperties;
import duc.uscript.uScript.ArrayLength;
import java.util.Map;

@SuppressWarnings("all")
public class ArrayLengthAspectArrayLengthAspectContext {
  public static final ArrayLengthAspectArrayLengthAspectContext INSTANCE = new ArrayLengthAspectArrayLengthAspectContext();
  
  public static ArrayLengthAspectArrayLengthAspectProperties getSelf(final ArrayLength _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ArrayLength, ArrayLengthAspectArrayLengthAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.ArrayLength, duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectProperties>();
  
  public Map<ArrayLength, ArrayLengthAspectArrayLengthAspectProperties> getMap() {
    return map;
  }
}
