package duc.uscript.execution.interpreter.expression.comparison;

import duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties;
import duc.uscript.uScript.Inferior;
import java.util.Map;

@SuppressWarnings("all")
public class InferiorAspectInferiorAspectContext {
  public static final InferiorAspectInferiorAspectContext INSTANCE = new InferiorAspectInferiorAspectContext();
  
  public static InferiorAspectInferiorAspectProperties getSelf(final Inferior _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Inferior, InferiorAspectInferiorAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Inferior, duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties>();
  
  public Map<Inferior, InferiorAspectInferiorAspectProperties> getMap() {
    return map;
  }
}
