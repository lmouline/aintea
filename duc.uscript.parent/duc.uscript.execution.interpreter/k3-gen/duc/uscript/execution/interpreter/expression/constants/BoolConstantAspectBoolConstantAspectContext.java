package duc.uscript.execution.interpreter.expression.constants;

import duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectProperties;
import duc.uscript.uScript.BoolConstant;
import java.util.Map;

@SuppressWarnings("all")
public class BoolConstantAspectBoolConstantAspectContext {
  public static final BoolConstantAspectBoolConstantAspectContext INSTANCE = new BoolConstantAspectBoolConstantAspectContext();
  
  public static BoolConstantAspectBoolConstantAspectProperties getSelf(final BoolConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<BoolConstant, BoolConstantAspectBoolConstantAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.BoolConstant, duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectProperties>();
  
  public Map<BoolConstant, BoolConstantAspectBoolConstantAspectProperties> getMap() {
    return map;
  }
}
