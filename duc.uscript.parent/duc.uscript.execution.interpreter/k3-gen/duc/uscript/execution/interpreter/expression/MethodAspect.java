package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.State;
import duc.uscript.execution.interpreter.expression.MethodAspectMethodAspectProperties;
import duc.uscript.execution.interpreter.statement.BlockAspect;
import duc.uscript.uScript.Method;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;

@Aspect(className = Method.class)
@SuppressWarnings("all")
public class MethodAspect {
  public static void call(final Method _self, final State state) {
    final duc.uscript.execution.interpreter.expression.MethodAspectMethodAspectProperties _self_ = duc.uscript.execution.interpreter.expression.MethodAspectMethodAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void call(State)
    if (_self instanceof duc.uscript.uScript.Method){
    	duc.uscript.execution.interpreter.expression.MethodAspect._privk3_call(_self_, (duc.uscript.uScript.Method)_self,state);
    };
  }
  
  protected static void _privk3_call(final MethodAspectMethodAspectProperties _self_, final Method _self, final State state) {
    BlockAspect.evaluateStatement(_self.getBody(), state);
  }
}
