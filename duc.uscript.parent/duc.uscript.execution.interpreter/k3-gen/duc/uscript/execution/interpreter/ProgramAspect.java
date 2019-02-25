package duc.uscript.execution.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import duc.uscript.execution.Context;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.Frame;
import duc.uscript.execution.State;
import duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties;
import duc.uscript.execution.interpreter.statement.BlockAspect;
import duc.uscript.execution.interpreter.utils.OutputStreamListener;
import duc.uscript.uScript.Method;
import duc.uscript.uScript.Program;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.io.OutputStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Program.class)
@SuppressWarnings("all")
public class ProgramAspect {
  public static void main(final Program _self) {
    final duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties _self_ = duc.uscript.execution.interpreter.ProgramAspectProgramAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void main()
    if (_self instanceof duc.uscript.uScript.Program){
    	duc.uscript.execution.interpreter.ProgramAspect._privk3_main(_self_, (duc.uscript.uScript.Program)_self);
    };
  }
  
  private static Method getMainMethod(final Program _self) {
    final duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties _self_ = duc.uscript.execution.interpreter.ProgramAspectProgramAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Method getMainMethod()
    if (_self instanceof duc.uscript.uScript.Program){
    	result = duc.uscript.execution.interpreter.ProgramAspect._privk3_getMainMethod(_self_, (duc.uscript.uScript.Program)_self);
    };
    return (duc.uscript.uScript.Method)result;
  }
  
  public static void initialize(final Program _self, final OutputStream out) {
    final duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties _self_ = duc.uscript.execution.interpreter.ProgramAspectProgramAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void initialize(OutputStream)
    if (_self instanceof duc.uscript.uScript.Program){
    	duc.uscript.execution.interpreter.ProgramAspect._privk3_initialize(_self_, (duc.uscript.uScript.Program)_self,out);
    };
  }
  
  public static State execute(final Program _self) {
    final duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties _self_ = duc.uscript.execution.interpreter.ProgramAspectProgramAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# State execute()
    if (_self instanceof duc.uscript.uScript.Program){
    	result = duc.uscript.execution.interpreter.ProgramAspect._privk3_execute(_self_, (duc.uscript.uScript.Program)_self);
    };
    return (duc.uscript.execution.State)result;
  }
  
  public static State state(final Program _self) {
    final duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties _self_ = duc.uscript.execution.interpreter.ProgramAspectProgramAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# State state()
    if (_self instanceof duc.uscript.uScript.Program){
    	result = duc.uscript.execution.interpreter.ProgramAspect._privk3_state(_self_, (duc.uscript.uScript.Program)_self);
    };
    return (duc.uscript.execution.State)result;
  }
  
  public static void state(final Program _self, final State state) {
    final duc.uscript.execution.interpreter.ProgramAspectProgramAspectProperties _self_ = duc.uscript.execution.interpreter.ProgramAspectProgramAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void state(State)
    if (_self instanceof duc.uscript.uScript.Program){
    	duc.uscript.execution.interpreter.ProgramAspect._privk3_state(_self_, (duc.uscript.uScript.Program)_self,state);
    };
  }
  
  protected static void _privk3_main(final ProgramAspectProgramAspectProperties _self_, final Program _self) {
    ProgramAspect.execute(_self);
  }
  
  protected static Method _privk3_getMainMethod(final ProgramAspectProgramAspectProperties _self_, final Program _self) {
    final Function1<Method, Boolean> _function = (Method it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, "main"));
    };
    return IterableExtensions.<Method>findFirst(Iterables.<Method>filter(_self.getElements(), Method.class), _function);
  }
  
  protected static void _privk3_initialize(final ProgramAspectProgramAspectProperties _self_, final Program _self, final OutputStream out) {
    final Method main = ProgramAspect.getMainMethod(_self);
    if ((main == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No main method found");
      throw new RuntimeException(_builder.toString());
    }
    final Context rootCtx = ExecutionFactory.eINSTANCE.createContext();
    State _createState = ExecutionFactory.eINSTANCE.createState();
    final Procedure1<State> _function = (State it) -> {
      it.setOutputStream(ExecutionFactory.eINSTANCE.createOutputStream());
      Frame _createFrame = ExecutionFactory.eINSTANCE.createFrame();
      final Procedure1<Frame> _function_1 = (Frame it_1) -> {
        it_1.setRootContext(rootCtx);
      };
      Frame _doubleArrow = ObjectExtensions.<Frame>operator_doubleArrow(_createFrame, _function_1);
      it.setRootFrame(_doubleArrow);
      EList<Adapter> _eAdapters = it.getOutputStream().eAdapters();
      OutputStreamListener _outputStreamListener = new OutputStreamListener(out);
      _eAdapters.add(_outputStreamListener);
    };
    final State state = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
    ProgramAspect.state(_self, state);
  }
  
  protected static State _privk3_execute(final ProgramAspectProgramAspectProperties _self_, final Program _self) {
    final Method main = ProgramAspect.getMainMethod(_self);
    BlockAspect.evaluateStatement(main.getBody(), ProgramAspect.state(_self));
    return ProgramAspect.state(_self);
  }
  
  protected static State _privk3_state(final ProgramAspectProgramAspectProperties _self_, final Program _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getState") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (duc.uscript.execution.State) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.state;
  }
  
  protected static void _privk3_state(final ProgramAspectProgramAspectProperties _self_, final Program _self, final State state) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setState")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, state);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.state = state;
    }
  }
}
