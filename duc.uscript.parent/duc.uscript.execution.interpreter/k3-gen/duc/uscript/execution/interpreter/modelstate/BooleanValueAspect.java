package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.BooleanValueAspectBooleanValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = BooleanValue.class)
@SuppressWarnings("all")
public class BooleanValueAspect extends AValueAspect {
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
  
  private static String super_convertToString(final BooleanValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final BooleanValueAspectBooleanValueAspectProperties _self_, final BooleanValue _self) {
    return Boolean.valueOf(_self.isValue()).toString();
  }
}
