package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Context;
import duc.uscript.execution.Frame;
import duc.uscript.execution.interpreter.modelstate.ContextAspect;
import duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;

@Aspect(className = Frame.class)
@SuppressWarnings("all")
public class FrameAspect {
  public static Frame findCurrentFrame(final Frame _self) {
    final duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Frame findCurrentFrame()
    if (_self instanceof duc.uscript.execution.Frame){
    	result = duc.uscript.execution.interpreter.modelstate.FrameAspect._privk3_findCurrentFrame(_self_, (duc.uscript.execution.Frame)_self);
    };
    return (duc.uscript.execution.Frame)result;
  }
  
  public static Context findCurrentContext(final Frame _self) {
    final duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.FrameAspectFrameAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Context findCurrentContext()
    if (_self instanceof duc.uscript.execution.Frame){
    	result = duc.uscript.execution.interpreter.modelstate.FrameAspect._privk3_findCurrentContext(_self_, (duc.uscript.execution.Frame)_self);
    };
    return (duc.uscript.execution.Context)result;
  }
  
  protected static Frame _privk3_findCurrentFrame(final FrameAspectFrameAspectProperties _self_, final Frame _self) {
    Frame _child = _self.getChild();
    boolean _tripleNotEquals = (_child != null);
    if (_tripleNotEquals) {
      return FrameAspect.findCurrentFrame(_self.getChild());
    } else {
      return _self;
    }
  }
  
  protected static Context _privk3_findCurrentContext(final FrameAspectFrameAspectProperties _self_, final Frame _self) {
    Frame _child = _self.getChild();
    boolean _tripleNotEquals = (_child != null);
    if (_tripleNotEquals) {
      return FrameAspect.findCurrentContext(_self.getChild());
    } else {
      Context _rootContext = _self.getRootContext();
      boolean _tripleNotEquals_1 = (_rootContext != null);
      if (_tripleNotEquals_1) {
        return ContextAspect.findCurrentContext(_self.getRootContext());
      } else {
        return null;
      }
    }
  }
}
