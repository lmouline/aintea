package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties;
import duc.uscript.uScript.Statement;
import java.util.Map;

@SuppressWarnings("all")
public class AStatementAspectStatementAspectContext {
  public static final AStatementAspectStatementAspectContext INSTANCE = new AStatementAspectStatementAspectContext();
  
  public static AStatementAspectStatementAspectProperties getSelf(final Statement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Statement, AStatementAspectStatementAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Statement, duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties>();
  
  public Map<Statement, AStatementAspectStatementAspectProperties> getMap() {
    return map;
  }
}
