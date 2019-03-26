package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectProperties;
import duc.uscript.uScript.NewObject;
import java.util.Map;

@SuppressWarnings("all")
public class NewObjectAspectNewObjectAspectContext {
  public static final NewObjectAspectNewObjectAspectContext INSTANCE = new NewObjectAspectNewObjectAspectContext();
  
  public static NewObjectAspectNewObjectAspectProperties getSelf(final NewObject _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NewObject, NewObjectAspectNewObjectAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.NewObject, duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectProperties>();
  
  public Map<NewObject, NewObjectAspectNewObjectAspectProperties> getMap() {
    return map;
  }
}
