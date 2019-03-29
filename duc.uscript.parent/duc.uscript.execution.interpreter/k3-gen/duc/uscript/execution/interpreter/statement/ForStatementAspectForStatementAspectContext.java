package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.interpreter.statement.ForStatementAspectForStatementAspectProperties;
import duc.uscript.uScript.ForStatement;
import java.util.Map;

@SuppressWarnings("all")
public class ForStatementAspectForStatementAspectContext {
  public static final ForStatementAspectForStatementAspectContext INSTANCE = new ForStatementAspectForStatementAspectContext();
  
  public static ForStatementAspectForStatementAspectProperties getSelf(final ForStatement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.statement.ForStatementAspectForStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ForStatement, ForStatementAspectForStatementAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.ForStatement, duc.uscript.execution.interpreter.statement.ForStatementAspectForStatementAspectProperties>();
  
  public Map<ForStatement, ForStatementAspectForStatementAspectProperties> getMap() {
    return map;
  }
}
