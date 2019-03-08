package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ObjectRefValueAspectObjectRefValueAspectContext {
  public static final ObjectRefValueAspectObjectRefValueAspectContext INSTANCE = new ObjectRefValueAspectObjectRefValueAspectContext();
  
  public static ObjectRefValueAspectObjectRefValueAspectProperties getSelf(final ObjectRefValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ObjectRefValue, ObjectRefValueAspectObjectRefValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.ObjectRefValue, duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectProperties>();
  
  public Map<ObjectRefValue, ObjectRefValueAspectObjectRefValueAspectProperties> getMap() {
    return map;
  }
}
