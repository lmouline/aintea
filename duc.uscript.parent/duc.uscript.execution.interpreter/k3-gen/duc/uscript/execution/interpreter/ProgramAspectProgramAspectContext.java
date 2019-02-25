package duc.uscript.execution.interpreter;

import duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties;
import duc.uscript.uScript.Program;
import java.util.Map;

@SuppressWarnings("all")
public class ProgramAspectProgramAspectContext {
  public static final ProgramAspectProgramAspectContext INSTANCE = new ProgramAspectProgramAspectContext();
  
  public static ProgramAspectProgramAspectProperties getSelf(final Program _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Program, ProgramAspectProgramAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Program, duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties>();
  
  public Map<Program, ProgramAspectProgramAspectProperties> getMap() {
    return map;
  }
}
