package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.interpreter.statement.IfStatementAspectIfStatementAspectProperties;
import duc.uscript.uScript.IfStatement;
import java.util.Map;

@SuppressWarnings("all")
public class IfStatementAspectIfStatementAspectContext {
  public static final IfStatementAspectIfStatementAspectContext INSTANCE = new IfStatementAspectIfStatementAspectContext();
  
  public static IfStatementAspectIfStatementAspectProperties getSelf(final IfStatement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.statement.IfStatementAspectIfStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IfStatement, IfStatementAspectIfStatementAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.IfStatement, duc.uscript.execution.interpreter.statement.IfStatementAspectIfStatementAspectProperties>();
  
  public Map<IfStatement, IfStatementAspectIfStatementAspectProperties> getMap() {
    return map;
  }
}
