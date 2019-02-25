package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Context;
import duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;

@Aspect(className = Context.class)
@SuppressWarnings("all")
public class ContextAspect {
  public static Context findCurrentContext(final Context _self) {
    final duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Context findCurrentContext()
    if (_self instanceof duc.uscript.execution.Context){
    	result = duc.uscript.execution.interpreter.modelstate.ContextAspect._privk3_findCurrentContext(_self_, (duc.uscript.execution.Context)_self);
    };
    return (duc.uscript.execution.Context)result;
  }
  
  protected static Context _privk3_findCurrentContext(final ContextAspectContextAspectProperties _self_, final Context _self) {
    Context _child = _self.getChild();
    boolean _tripleNotEquals = (_child != null);
    if (_tripleNotEquals) {
      return ContextAspect.findCurrentContext(_self.getChild());
    } else {
      return _self;
    }
  }
}
