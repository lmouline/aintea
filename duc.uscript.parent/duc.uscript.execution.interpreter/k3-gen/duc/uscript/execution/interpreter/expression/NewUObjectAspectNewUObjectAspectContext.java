package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectProperties;
import duc.uscript.uScript.NewUObject;
import java.util.Map;

@SuppressWarnings("all")
public class NewUObjectAspectNewUObjectAspectContext {
  public static final NewUObjectAspectNewUObjectAspectContext INSTANCE = new NewUObjectAspectNewUObjectAspectContext();
  
  public static NewUObjectAspectNewUObjectAspectProperties getSelf(final NewUObject _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NewUObject, NewUObjectAspectNewUObjectAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.NewUObject, duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectProperties>();
  
  public Map<NewUObject, NewUObjectAspectNewUObjectAspectProperties> getMap() {
    return map;
  }
}
