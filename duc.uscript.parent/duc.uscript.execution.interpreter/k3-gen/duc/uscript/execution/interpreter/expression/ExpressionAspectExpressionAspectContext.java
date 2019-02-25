package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties;
import duc.uscript.uScript.Expression;
import java.util.Map;

@SuppressWarnings("all")
public class ExpressionAspectExpressionAspectContext {
  public static final ExpressionAspectExpressionAspectContext INSTANCE = new ExpressionAspectExpressionAspectContext();
  
  public static ExpressionAspectExpressionAspectProperties getSelf(final Expression _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Expression, ExpressionAspectExpressionAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Expression, duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties>();
  
  public Map<Expression, ExpressionAspectExpressionAspectProperties> getMap() {
    return map;
  }
}
