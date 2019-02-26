package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.StringValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = StringValue.class)
@SuppressWarnings("all")
public class StringValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final StringValue _self) {
    final duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.StringValue){
    	result = duc.uscript.execution.interpreter.modelstate.StringValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.StringValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final StringValue _self) {
    final duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.StringValue){
    	result = duc.uscript.execution.interpreter.modelstate.StringValueAspect._privk3_copy(_self_, (duc.uscript.execution.StringValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final StringValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final StringValueAspectStringValueAspectProperties _self_, final StringValue _self) {
    return _self.getValue();
  }
  
  private static Value super_copy(final StringValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final StringValueAspectStringValueAspectProperties _self_, final StringValue _self) {
    StringValue _createStringValue = ExecutionFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
}
