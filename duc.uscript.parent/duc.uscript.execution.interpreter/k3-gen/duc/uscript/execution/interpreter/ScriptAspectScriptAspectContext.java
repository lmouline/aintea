package duc.uscript.execution.interpreter;

import duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties;
import duc.uscript.uScript.Script;
import java.util.Map;

@SuppressWarnings("all")
public class ScriptAspectScriptAspectContext {
  public static final ScriptAspectScriptAspectContext INSTANCE = new ScriptAspectScriptAspectContext();
  
  public static ScriptAspectScriptAspectProperties getSelf(final Script _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Script, ScriptAspectScriptAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Script, duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties>();
  
  public Map<Script, ScriptAspectScriptAspectProperties> getMap() {
    return map;
  }
}
