package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.LongValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = LongValue.class)
@SuppressWarnings("all")
public class LongValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final LongValue _self) {
    final duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.LongValue){
    	result = duc.uscript.execution.interpreter.modelstate.LongValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.LongValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final LongValue _self) {
    final duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.LongValue){
    	result = duc.uscript.execution.interpreter.modelstate.LongValueAspect._privk3_copy(_self_, (duc.uscript.execution.LongValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final LongValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final LongValueAspectLongValueAspectProperties _self_, final LongValue _self) {
    return Long.valueOf(_self.getValue()).toString();
  }
  
  private static Value super_copy(final LongValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final LongValueAspectLongValueAspectProperties _self_, final LongValue _self) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
}
