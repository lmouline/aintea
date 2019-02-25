package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ByteValue;
import duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class ByteValueAspectByteValueAspectContext {
  public static final ByteValueAspectByteValueAspectContext INSTANCE = new ByteValueAspectByteValueAspectContext();
  
  public static ByteValueAspectByteValueAspectProperties getSelf(final ByteValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ByteValue, ByteValueAspectByteValueAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.ByteValue, duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectProperties>();
  
  public Map<ByteValue, ByteValueAspectByteValueAspectProperties> getMap() {
    return map;
  }
}
