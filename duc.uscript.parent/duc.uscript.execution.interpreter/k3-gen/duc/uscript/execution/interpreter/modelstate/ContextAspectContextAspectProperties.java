package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.SymbolBindings;
import duc.uscript.uScript.Symbol;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class ContextAspectContextAspectProperties {
  public final Map<Symbol, SymbolBindings> cache = new HashMap<Symbol, SymbolBindings>();
}
