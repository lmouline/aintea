package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.NullValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = NullValue.class)
@SuppressWarnings("all")
public class NullValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final NullValue _self) {
    final duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.NullValue){
    	result = duc.uscript.execution.interpreter.modelstate.NullValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.NullValue)_self);
    };
    return (java.lang.String)result;
  }
  
  public static Value copy(final NullValue _self) {
    final duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.NullValueAspectNullValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.NullValue){
    	result = duc.uscript.execution.interpreter.modelstate.NullValueAspect._privk3_copy(_self_, (duc.uscript.execution.NullValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final NullValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final NullValueAspectNullValueAspectProperties _self_, final NullValue _self) {
    return "null";
  }
  
  protected static Value _privk3_copy(final NullValueAspectNullValueAspectProperties _self_, final NullValue _self) {
    return ExecutionFactory.eINSTANCE.createNullValue();
  }
}
