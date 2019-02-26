package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = IntegerValue.class)
@SuppressWarnings("all")
public class IntegerValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final IntegerValue _self) {
    final duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.IntegerValue){
    	result = duc.uscript.execution.interpreter.modelstate.IntegerValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.IntegerValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final IntegerValue _self) {
    final duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.IntegerValue){
    	result = duc.uscript.execution.interpreter.modelstate.IntegerValueAspect._privk3_copy(_self_, (duc.uscript.execution.IntegerValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final IntegerValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final IntegerValueAspectIntegerValueAspectProperties _self_, final IntegerValue _self) {
    return Integer.valueOf(_self.getValue()).toString();
  }
  
  private static Value super_copy(final IntegerValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final IntegerValueAspectIntegerValueAspectProperties _self_, final IntegerValue _self) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
}
