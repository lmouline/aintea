package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties;
import duc.uscript.uScript.ComputeNbTrueExpr;
import java.util.Map;

@SuppressWarnings("all")
public class ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext {
  public static final ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext INSTANCE = new ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext();
  
  public static ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties getSelf(final ComputeNbTrueExpr _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ComputeNbTrueExpr, ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.ComputeNbTrueExpr, duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties>();
  
  public Map<ComputeNbTrueExpr, ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties> getMap() {
    return map;
  }
}
