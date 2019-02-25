package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.LongConstantAspectLongConstantAspectProperties;
import duc.uscript.uScript.LongConstant;
import java.util.Map;

@SuppressWarnings("all")
public class LongConstantAspectLongConstantAspectContext {
  public static final LongConstantAspectLongConstantAspectContext INSTANCE = new LongConstantAspectLongConstantAspectContext();
  
  public static LongConstantAspectLongConstantAspectProperties getSelf(final LongConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.LongConstantAspectLongConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LongConstant, LongConstantAspectLongConstantAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.LongConstant, duc.uscript.execution.interpreter.expression.LongConstantAspectLongConstantAspectProperties>();
  
  public Map<LongConstant, LongConstantAspectLongConstantAspectProperties> getMap() {
    return map;
  }
}
