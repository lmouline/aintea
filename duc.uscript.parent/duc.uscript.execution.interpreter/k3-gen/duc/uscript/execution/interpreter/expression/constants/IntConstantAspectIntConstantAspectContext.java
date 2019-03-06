package duc.uscript.execution.interpreter.expression.constants;

import duc.uscript.execution.interpreter.expression.constants.IntConstantAspectIntConstantAspectProperties;
import duc.uscript.uScript.IntConstant;
import java.util.Map;

@SuppressWarnings("all")
public class IntConstantAspectIntConstantAspectContext {
  public static final IntConstantAspectIntConstantAspectContext INSTANCE = new IntConstantAspectIntConstantAspectContext();
  
  public static IntConstantAspectIntConstantAspectProperties getSelf(final IntConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.constants.IntConstantAspectIntConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IntConstant, IntConstantAspectIntConstantAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.IntConstant, duc.uscript.execution.interpreter.expression.constants.IntConstantAspectIntConstantAspectProperties>();
  
  public Map<IntConstant, IntConstantAspectIntConstantAspectProperties> getMap() {
    return map;
  }
}
