package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.NegAspectImplNegAspectProperties;
import duc.uscript.uScript.Neg;
import java.util.Map;

@SuppressWarnings("all")
public class NegAspectImplNegAspectContext {
  public static final NegAspectImplNegAspectContext INSTANCE = new NegAspectImplNegAspectContext();
  
  public static NegAspectImplNegAspectProperties getSelf(final Neg _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.NegAspectImplNegAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Neg, NegAspectImplNegAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Neg, duc.uscript.execution.interpreter.expression.NegAspectImplNegAspectProperties>();
  
  public Map<Neg, NegAspectImplNegAspectProperties> getMap() {
    return map;
  }
}
