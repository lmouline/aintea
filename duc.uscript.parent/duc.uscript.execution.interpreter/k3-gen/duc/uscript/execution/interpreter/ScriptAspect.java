package duc.uscript.execution.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import duc.uscript.execution.Context;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.Frame;
import duc.uscript.execution.State;
import duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties;
import duc.uscript.execution.interpreter.statement.BlockAspect;
import duc.uscript.execution.interpreter.utils.OutputStreamListener;
import duc.uscript.uScript.Method;
import duc.uscript.uScript.Script;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.io.OutputStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Script.class)
@SuppressWarnings("all")
public class ScriptAspect {
  public static void main(final Script _self) {
    final duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties _self_ = duc.uscript.execution.interpreter.ScriptAspectScriptAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void main()
    if (_self instanceof duc.uscript.uScript.Script){
    	duc.uscript.execution.interpreter.ScriptAspect._privk3_main(_self_, (duc.uscript.uScript.Script)_self);
    };
  }
  
  private static Method getMainMethod(final Script _self) {
    final duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties _self_ = duc.uscript.execution.interpreter.ScriptAspectScriptAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Method getMainMethod()
    if (_self instanceof duc.uscript.uScript.Script){
    	result = duc.uscript.execution.interpreter.ScriptAspect._privk3_getMainMethod(_self_, (duc.uscript.uScript.Script)_self);
    };
    return (duc.uscript.uScript.Method)result;
  }
  
  public static void initialize(final Script _self, final OutputStream out) {
    final duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties _self_ = duc.uscript.execution.interpreter.ScriptAspectScriptAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void initialize(OutputStream)
    if (_self instanceof duc.uscript.uScript.Script){
    	duc.uscript.execution.interpreter.ScriptAspect._privk3_initialize(_self_, (duc.uscript.uScript.Script)_self,out);
    };
  }
  
  public static State execute(final Script _self) {
    final duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties _self_ = duc.uscript.execution.interpreter.ScriptAspectScriptAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# State execute()
    if (_self instanceof duc.uscript.uScript.Script){
    	result = duc.uscript.execution.interpreter.ScriptAspect._privk3_execute(_self_, (duc.uscript.uScript.Script)_self);
    };
    return (duc.uscript.execution.State)result;
  }
  
  public static State state(final Script _self) {
    final duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties _self_ = duc.uscript.execution.interpreter.ScriptAspectScriptAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# State state()
    if (_self instanceof duc.uscript.uScript.Script){
    	result = duc.uscript.execution.interpreter.ScriptAspect._privk3_state(_self_, (duc.uscript.uScript.Script)_self);
    };
    return (duc.uscript.execution.State)result;
  }
  
  public static void state(final Script _self, final State state) {
    final duc.uscript.execution.interpreter.ScriptAspectScriptAspectProperties _self_ = duc.uscript.execution.interpreter.ScriptAspectScriptAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void state(State)
    if (_self instanceof duc.uscript.uScript.Script){
    	duc.uscript.execution.interpreter.ScriptAspect._privk3_state(_self_, (duc.uscript.uScript.Script)_self,state);
    };
  }
  
  protected static void _privk3_main(final ScriptAspectScriptAspectProperties _self_, final Script _self) {
    ScriptAspect.execute(_self);
  }
  
  protected static Method _privk3_getMainMethod(final ScriptAspectScriptAspectProperties _self_, final Script _self) {
    final Function1<Method, Boolean> _function = (Method it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, "main"));
    };
    return IterableExtensions.<Method>findFirst(Iterables.<Method>filter(_self.getElements(), Method.class), _function);
  }
  
  protected static void _privk3_initialize(final ScriptAspectScriptAspectProperties _self_, final Script _self, final OutputStream out) {
    final Method main = ScriptAspect.getMainMethod(_self);
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
    ScriptAspect.state(_self, state);
  }
  
  protected static State _privk3_execute(final ScriptAspectScriptAspectProperties _self_, final Script _self) {
    final Method main = ScriptAspect.getMainMethod(_self);
    BlockAspect.evaluateStatement(main.getBody(), ScriptAspect.state(_self));
    return ScriptAspect.state(_self);
  }
  
  protected static State _privk3_state(final ScriptAspectScriptAspectProperties _self_, final Script _self) {
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
  
  protected static void _privk3_state(final ScriptAspectScriptAspectProperties _self_, final Script _self, final State state) {
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
