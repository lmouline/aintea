package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.interpreter.statement.ReturnAspectReturnAspectProperties;
import duc.uscript.uScript.Return;
import java.util.Map;

@SuppressWarnings("all")
public class ReturnAspectReturnAspectContext {
  public static final ReturnAspectReturnAspectContext INSTANCE = new ReturnAspectReturnAspectContext();
  
  public static ReturnAspectReturnAspectProperties getSelf(final Return _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.statement.ReturnAspectReturnAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Return, ReturnAspectReturnAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Return, duc.uscript.execution.interpreter.statement.ReturnAspectReturnAspectProperties>();
  
  public Map<Return, ReturnAspectReturnAspectProperties> getMap() {
    return map;
  }
}
