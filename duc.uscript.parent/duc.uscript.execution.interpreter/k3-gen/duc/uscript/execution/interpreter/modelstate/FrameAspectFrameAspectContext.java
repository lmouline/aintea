package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Frame;
import duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class FrameAspectFrameAspectContext {
  public static final FrameAspectFrameAspectContext INSTANCE = new FrameAspectFrameAspectContext();
  
  public static FrameAspectFrameAspectProperties getSelf(final Frame _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Frame, FrameAspectFrameAspectProperties> map = new java.util.WeakHashMap<duc.uscript.execution.Frame, duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectProperties>();
  
  public Map<Frame, FrameAspectFrameAspectProperties> getMap() {
    return map;
  }
}
