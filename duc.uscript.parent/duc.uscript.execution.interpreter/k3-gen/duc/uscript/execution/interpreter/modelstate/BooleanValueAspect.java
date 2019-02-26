package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = BooleanValue.class)
@SuppressWarnings("all")
public class BooleanValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final BooleanValue _self) {
    final duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.BooleanValue){
    	result = duc.uscript.execution.interpreter.modelstate.BooleanValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.BooleanValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final BooleanValue _self) {
    final duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.BooleanValue){
    	result = duc.uscript.execution.interpreter.modelstate.BooleanValueAspect._privk3_copy(_self_, (duc.uscript.execution.BooleanValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final BooleanValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final BooleanValueAspectBooleanValueAspectProperties _self_, final BooleanValue _self) {
    return Boolean.valueOf(_self.isValue()).toString();
  }
  
  private static Value super_copy(final BooleanValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final BooleanValueAspectBooleanValueAspectProperties _self_, final BooleanValue _self) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue(_self.isValue());
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
