package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.FloatValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.FloatValueAspectFloatValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = FloatValue.class)
@SuppressWarnings("all")
public class FloatValueAspect extends AValueAspect {
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
  
  private static String super_convertToString(final FloatValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final FloatValueAspectFloatValueAspectProperties _self_, final FloatValue _self) {
    return Float.valueOf(_self.getValue()).toString();
  }
}
