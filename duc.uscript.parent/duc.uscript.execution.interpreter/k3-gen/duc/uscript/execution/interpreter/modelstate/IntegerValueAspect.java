package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.IntegerValueAspectIntegerValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = IntegerValue.class)
@SuppressWarnings("all")
public class IntegerValueAspect extends AValueAspect {
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
  
  private static String super_convertToString(final IntegerValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final IntegerValueAspectIntegerValueAspectProperties _self_, final IntegerValue _self) {
    return Integer.valueOf(_self.getValue()).toString();
  }
}
