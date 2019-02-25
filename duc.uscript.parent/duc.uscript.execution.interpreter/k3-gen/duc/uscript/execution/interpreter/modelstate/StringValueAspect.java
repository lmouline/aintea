package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.StringValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.StringValueAspectStringValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = StringValue.class)
@SuppressWarnings("all")
public class StringValueAspect extends AValueAspect {
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
  
  private static String super_convertToString(final StringValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final StringValueAspectStringValueAspectProperties _self_, final StringValue _self) {
    return _self.getValue();
  }
}
