package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FloatValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = FloatValue.class)
@SuppressWarnings("all")
public class FloatValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final FloatValue _self) {
    final duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.FloatValue){
    	result = duc.uscript.execution.interpreter.modelstate.FloatValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.FloatValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final FloatValue _self) {
    final duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.FloatValue){
    	result = duc.uscript.execution.interpreter.modelstate.FloatValueAspect._privk3_copy(_self_, (duc.uscript.execution.FloatValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final FloatValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final FloatValueAspectFloatValueAspectProperties _self_, final FloatValue _self) {
    return Float.valueOf(_self.getValue()).toString();
  }
  
  private static Value super_copy(final FloatValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final FloatValueAspectFloatValueAspectProperties _self_, final FloatValue _self) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
}
