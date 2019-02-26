package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectProperties;
import duc.uscript.uScript.Assignment;
import java.util.Map;

@SuppressWarnings("all")
public class AssigmentAspectAssignmentAspectContext {
  public static final AssigmentAspectAssignmentAspectContext INSTANCE = new AssigmentAspectAssignmentAspectContext();
  
  public static AssigmentAspectAssignmentAspectProperties getSelf(final Assignment _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Assignment, AssigmentAspectAssignmentAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Assignment, duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectProperties>();
  
  public Map<Assignment, AssigmentAspectAssignmentAspectProperties> getMap() {
    return map;
  }
}
