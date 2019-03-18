package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Call;
import duc.uscript.execution.Context;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.Frame;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.State;
import duc.uscript.execution.interpreter.modelstate.FrameAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = State.class)
@SuppressWarnings("all")
public class StateAspect {
  public static Context findCurrentContext(final State _self) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Context findCurrentContext()
    if (_self instanceof duc.uscript.execution.State){
    	result = duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_findCurrentContext(_self_, (duc.uscript.execution.State)_self);
    };
    return (duc.uscript.execution.Context)result;
  }
  
  public static Frame findCurrentFrame(final State _self) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Frame findCurrentFrame()
    if (_self instanceof duc.uscript.execution.State){
    	result = duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_findCurrentFrame(_self_, (duc.uscript.execution.State)_self);
    };
    return (duc.uscript.execution.Frame)result;
  }
  
  public static void pushNewContext(final State _self) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void pushNewContext()
    if (_self instanceof duc.uscript.execution.State){
    	duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_pushNewContext(_self_, (duc.uscript.execution.State)_self);
    };
  }
  
  public static void popCurrentContext(final State _self) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void popCurrentContext()
    if (_self instanceof duc.uscript.execution.State){
    	duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_popCurrentContext(_self_, (duc.uscript.execution.State)_self);
    };
  }
  
  public static void print(final State _self, final String string) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void print(String)
    if (_self instanceof duc.uscript.execution.State){
    	duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_print(_self_, (duc.uscript.execution.State)_self,string);
    };
  }
  
  public static void pushNewFrame(final State _self, final ObjectInstance receiver, final Call c, final Context ctx) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void pushNewFrame(ObjectInstance,Call,Context)
    if (_self instanceof duc.uscript.execution.State){
    	duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_pushNewFrame(_self_, (duc.uscript.execution.State)_self,receiver,c,ctx);
    };
  }
  
  public static void popCurrentFrame(final State _self) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void popCurrentFrame()
    if (_self instanceof duc.uscript.execution.State){
    	duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_popCurrentFrame(_self_, (duc.uscript.execution.State)_self);
    };
  }
  
  private static Context context(final State _self) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Context context()
    if (_self instanceof duc.uscript.execution.State){
    	result = duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_context(_self_, (duc.uscript.execution.State)_self);
    };
    return (duc.uscript.execution.Context)result;
  }
  
  private static void context(final State _self, final Context context) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void context(Context)
    if (_self instanceof duc.uscript.execution.State){
    	duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_context(_self_, (duc.uscript.execution.State)_self,context);
    };
  }
  
  private static Frame frame(final State _self) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Frame frame()
    if (_self instanceof duc.uscript.execution.State){
    	result = duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_frame(_self_, (duc.uscript.execution.State)_self);
    };
    return (duc.uscript.execution.Frame)result;
  }
  
  private static void frame(final State _self, final Frame frame) {
    final duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StateAspectStateAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void frame(Frame)
    if (_self instanceof duc.uscript.execution.State){
    	duc.uscript.execution.interpreter.modelstate.StateAspect._privk3_frame(_self_, (duc.uscript.execution.State)_self,frame);
    };
  }
  
  protected static Context _privk3_findCurrentContext(final StateAspectStateAspectProperties _self_, final State _self) {
    Context _context = StateAspect.context(_self);
    boolean _tripleEquals = (_context == null);
    if (_tripleEquals) {
      StateAspect.context(_self, FrameAspect.findCurrentContext(StateAspect.frame(_self)));
    }
    return StateAspect.context(_self);
  }
  
  protected static Frame _privk3_findCurrentFrame(final StateAspectStateAspectProperties _self_, final State _self) {
    Frame _frame = StateAspect.frame(_self);
    boolean _tripleEquals = (_frame == null);
    if (_tripleEquals) {
      StateAspect.frame(_self, FrameAspect.findCurrentFrame(_self.getRootFrame()));
    }
    return StateAspect.frame(_self);
  }
  
  protected static void _privk3_pushNewContext(final StateAspectStateAspectProperties _self_, final State _self) {
    final Context newContext = ExecutionFactory.eINSTANCE.createContext();
    Context _findCurrentContext = StateAspect.findCurrentContext(_self);
    boolean _tripleNotEquals = (_findCurrentContext != null);
    if (_tripleNotEquals) {
      Context _findCurrentContext_1 = StateAspect.findCurrentContext(_self);
      _findCurrentContext_1.setChild(newContext);
    } else {
      Frame _findCurrentFrame = StateAspect.findCurrentFrame(_self);
      _findCurrentFrame.setRootContext(newContext);
    }
    StateAspect.context(_self, newContext);
  }
  
  protected static void _privk3_popCurrentContext(final StateAspectStateAspectProperties _self_, final State _self) {
    final Context newCurrent = StateAspect.findCurrentContext(_self).getParent();
    Context _findCurrentContext = StateAspect.findCurrentContext(_self);
    _findCurrentContext.setParent(null);
    StateAspect.context(_self, newCurrent);
  }
  
  protected static void _privk3_print(final StateAspectStateAspectProperties _self_, final State _self, final String string) {
    _self.getOutputStream().getStream().add(string);
  }
  
  protected static void _privk3_pushNewFrame(final StateAspectStateAspectProperties _self_, final State _self, final ObjectInstance receiver, final Call c, final Context ctx) {
    Frame _createFrame = ExecutionFactory.eINSTANCE.createFrame();
    final Procedure1<Frame> _function = (Frame it) -> {
      it.setInstance(receiver);
      it.setCall(c);
      it.setRootContext(ctx);
    };
    final Frame newFrame = ObjectExtensions.<Frame>operator_doubleArrow(_createFrame, _function);
    Frame _findCurrentFrame = StateAspect.findCurrentFrame(_self);
    _findCurrentFrame.setChild(newFrame);
    StateAspect.frame(_self, newFrame);
    StateAspect.context(_self, null);
  }
  
  protected static void _privk3_popCurrentFrame(final StateAspectStateAspectProperties _self_, final State _self) {
    final Frame newCurrent = StateAspect.findCurrentFrame(_self).getParent();
    Frame _findCurrentFrame = StateAspect.findCurrentFrame(_self);
    _findCurrentFrame.setParent(null);
    StateAspect.context(_self, null);
    StateAspect.frame(_self, newCurrent);
  }
  
  protected static Context _privk3_context(final StateAspectStateAspectProperties _self_, final State _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getContext") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (duc.uscript.execution.Context) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.context;
  }
  
  protected static void _privk3_context(final StateAspectStateAspectProperties _self_, final State _self, final Context context) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setContext")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, context);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.context = context;
    }
  }
  
  protected static Frame _privk3_frame(final StateAspectStateAspectProperties _self_, final State _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getFrame") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (duc.uscript.execution.Frame) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.frame;
  }
  
  protected static void _privk3_frame(final StateAspectStateAspectProperties _self_, final State _self, final Frame frame) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setFrame")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, frame);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.frame = frame;
    }
  }
}
