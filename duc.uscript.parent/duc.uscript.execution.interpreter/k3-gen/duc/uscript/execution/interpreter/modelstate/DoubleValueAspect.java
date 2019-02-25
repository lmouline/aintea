package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.DoubleValueAspectDoubleValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = DoubleValue.class)
@SuppressWarnings("all")
public class DoubleValueAspect extends AValueAspect {
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
  
  private static String super_convertToString(final DoubleValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final DoubleValueAspectDoubleValueAspectProperties _self_, final DoubleValue _self) {
    return Double.valueOf(_self.getValue()).toString();
  }
}
