package duc.uscript.execution.interpreter.expression.constants;

import duc.uscript.execution.interpreter.expression.constants.StringConstantAspectStringConstantAspectProperties;
import duc.uscript.uScript.StringConstant;
import java.util.Map;

@SuppressWarnings("all")
public class StringConstantAspectStringConstantAspectContext {
  public static final StringConstantAspectStringConstantAspectContext INSTANCE = new StringConstantAspectStringConstantAspectContext();
  
  public static StringConstantAspectStringConstantAspectProperties getSelf(final StringConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.constants.StringConstantAspectStringConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StringConstant, StringConstantAspectStringConstantAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.StringConstant, duc.uscript.execution.interpreter.expression.constants.StringConstantAspectStringConstantAspectProperties>();
  
  public Map<StringConstant, StringConstantAspectStringConstantAspectProperties> getMap() {
    return map;
  }
}
