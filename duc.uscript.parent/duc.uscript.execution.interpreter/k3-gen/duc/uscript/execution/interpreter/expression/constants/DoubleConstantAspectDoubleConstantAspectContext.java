package duc.uscript.execution.interpreter.expression.constants;

import duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectProperties;
import duc.uscript.uScript.DoubleConstant;
import java.util.Map;

@SuppressWarnings("all")
public class DoubleConstantAspectDoubleConstantAspectContext {
  public static final DoubleConstantAspectDoubleConstantAspectContext INSTANCE = new DoubleConstantAspectDoubleConstantAspectContext();
  
  public static DoubleConstantAspectDoubleConstantAspectProperties getSelf(final DoubleConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DoubleConstant, DoubleConstantAspectDoubleConstantAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.DoubleConstant, duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectProperties>();
  
  public Map<DoubleConstant, DoubleConstantAspectDoubleConstantAspectProperties> getMap() {
    return map;
  }
}
