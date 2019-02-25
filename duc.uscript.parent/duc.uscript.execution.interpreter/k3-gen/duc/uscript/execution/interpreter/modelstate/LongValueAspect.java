package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.LongValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.LongValueAspectLongValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = LongValue.class)
@SuppressWarnings("all")
public class LongValueAspect extends AValueAspect {
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
  
  private static String super_convertToString(final LongValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final LongValueAspectLongValueAspectProperties _self_, final LongValue _self) {
    return Long.valueOf(_self.getValue()).toString();
  }
}
