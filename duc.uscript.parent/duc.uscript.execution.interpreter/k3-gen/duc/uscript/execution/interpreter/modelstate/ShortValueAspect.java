package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.ShortValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ShortValue.class)
@SuppressWarnings("all")
public class ShortValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final ShortValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.ShortValue){
    	result = duc.uscript.execution.interpreter.modelstate.ShortValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.ShortValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final ShortValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.ShortValue){
    	result = duc.uscript.execution.interpreter.modelstate.ShortValueAspect._privk3_copy(_self_, (duc.uscript.execution.ShortValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final ShortValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final ShortValueAspectShortValueAspectProperties _self_, final ShortValue _self) {
    return Short.valueOf(_self.getValue()).toString();
  }
  
  private static Value super_copy(final ShortValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final ShortValueAspectShortValueAspectProperties _self_, final ShortValue _self) {
    ShortValue _createShortValue = ExecutionFactory.eINSTANCE.createShortValue();
    final Procedure1<ShortValue> _function = (ShortValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<ShortValue>operator_doubleArrow(_createShortValue, _function);
  }
}
