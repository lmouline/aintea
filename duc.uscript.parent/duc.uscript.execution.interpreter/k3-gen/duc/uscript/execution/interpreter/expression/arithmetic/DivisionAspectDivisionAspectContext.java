package duc.uscript.execution.interpreter.expression.arithmetic;

import duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspectDivisionAspectProperties;
import duc.uscript.uScript.Division;
import java.util.Map;

@SuppressWarnings("all")
public class DivisionAspectDivisionAspectContext {
  public static final DivisionAspectDivisionAspectContext INSTANCE = new DivisionAspectDivisionAspectContext();
  
  public static DivisionAspectDivisionAspectProperties getSelf(final Division _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspectDivisionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Division, DivisionAspectDivisionAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Division, duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspectDivisionAspectProperties>();
  
  public Map<Division, DivisionAspectDivisionAspectProperties> getMap() {
    return map;
  }
}
