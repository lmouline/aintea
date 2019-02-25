package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ByteValue;
import duc.uscript.execution.interpreter.modelstate.AValueAspect;
import duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = ByteValue.class)
@SuppressWarnings("all")
public class ByteValueAspect extends AValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final ByteValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.ByteValue){
    	result = duc.uscript.execution.interpreter.modelstate.ByteValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.ByteValue)_self);
    };
    return (java.lang.String)result;
  }
  
  private static String super_convertToString(final ByteValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.AValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final ByteValueAspectByteValueAspectProperties _self_, final ByteValue _self) {
    return Byte.valueOf(_self.getValue()).toString();
  }
}
