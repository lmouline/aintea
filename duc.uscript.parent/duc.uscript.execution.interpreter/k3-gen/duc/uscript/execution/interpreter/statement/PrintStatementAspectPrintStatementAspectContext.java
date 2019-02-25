package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.interpreter.statement.PrintStatementAspectPrintStatementAspectProperties;
import duc.uscript.uScript.PrintStatement;
import java.util.Map;

@SuppressWarnings("all")
public class PrintStatementAspectPrintStatementAspectContext {
  public static final PrintStatementAspectPrintStatementAspectContext INSTANCE = new PrintStatementAspectPrintStatementAspectContext();
  
  public static PrintStatementAspectPrintStatementAspectProperties getSelf(final PrintStatement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.statement.PrintStatementAspectPrintStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<PrintStatement, PrintStatementAspectPrintStatementAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.PrintStatement, duc.uscript.execution.interpreter.statement.PrintStatementAspectPrintStatementAspectProperties>();
  
  public Map<PrintStatement, PrintStatementAspectPrintStatementAspectProperties> getMap() {
    return map;
  }
}
