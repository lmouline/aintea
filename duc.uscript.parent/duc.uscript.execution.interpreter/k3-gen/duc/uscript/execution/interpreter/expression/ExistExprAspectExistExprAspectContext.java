package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectProperties;
import duc.uscript.uScript.ExistExpr;
import java.util.Map;

@SuppressWarnings("all")
public class ExistExprAspectExistExprAspectContext {
  public static final ExistExprAspectExistExprAspectContext INSTANCE = new ExistExprAspectExistExprAspectContext();
  
  public static ExistExprAspectExistExprAspectProperties getSelf(final ExistExpr _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ExistExpr, ExistExprAspectExistExprAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.ExistExpr, duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectProperties>();
  
  public Map<ExistExpr, ExistExprAspectExistExprAspectProperties> getMap() {
    return map;
  }
}
