package duc.uscript.execution.interpreter.expression.arithmetic;

import duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties;
import duc.uscript.uScript.Multiplication;
import java.util.Map;

@SuppressWarnings("all")
public class MultiplicationAspectMultiplicationAspectContext {
  public static final MultiplicationAspectMultiplicationAspectContext INSTANCE = new MultiplicationAspectMultiplicationAspectContext();
  
  public static MultiplicationAspectMultiplicationAspectProperties getSelf(final Multiplication _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Multiplication, MultiplicationAspectMultiplicationAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Multiplication, duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties>();
  
  public Map<Multiplication, MultiplicationAspectMultiplicationAspectProperties> getMap() {
    return map;
  }
}
