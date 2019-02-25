package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ShortValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.ShortValueAspectShortValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = ShortValue.class)
@SuppressWarnings("all")
public class ShortValueAspect extends AValueAspect {
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
  
  private static String super_convertToString(final ShortValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final ShortValueAspectShortValueAspectProperties _self_, final ShortValue _self) {
    return Short.valueOf(_self.getValue()).toString();
  }
}
