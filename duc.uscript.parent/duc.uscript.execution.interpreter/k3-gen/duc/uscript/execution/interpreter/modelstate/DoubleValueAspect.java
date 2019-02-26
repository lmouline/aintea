package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = DoubleValue.class)
@SuppressWarnings("all")
public class DoubleValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final DoubleValue _self) {
    final duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.DoubleValue){
    	result = duc.uscript.execution.interpreter.modelstate.DoubleValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.DoubleValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final DoubleValue _self) {
    final duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.DoubleValue){
    	result = duc.uscript.execution.interpreter.modelstate.DoubleValueAspect._privk3_copy(_self_, (duc.uscript.execution.DoubleValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final DoubleValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final DoubleValueAspectDoubleValueAspectProperties _self_, final DoubleValue _self) {
    return Double.valueOf(_self.getValue()).toString();
  }
  
  private static Value super_copy(final DoubleValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final DoubleValueAspectDoubleValueAspectProperties _self_, final DoubleValue _self) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
}
