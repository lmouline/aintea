package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ByteValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ByteValue.class)
@SuppressWarnings("all")
public class ByteValueAspect extends ValueAspect {
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
  
  @OverrideAspectMethod
  public static Value copy(final ByteValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ByteValueAspectByteValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.ByteValue){
    	result = duc.uscript.execution.interpreter.modelstate.ByteValueAspect._privk3_copy(_self_, (duc.uscript.execution.ByteValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final ByteValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final ByteValueAspectByteValueAspectProperties _self_, final ByteValue _self) {
    return Byte.valueOf(_self.getValue()).toString();
  }
  
  private static Value super_copy(final ByteValue _self) {
    final duc.uscript.execution.interpreter.modelstate.AValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final ByteValueAspectByteValueAspectProperties _self_, final ByteValue _self) {
    ByteValue _createByteValue = ExecutionFactory.eINSTANCE.createByteValue();
    final Procedure1<ByteValue> _function = (ByteValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<ByteValue>operator_doubleArrow(_createByteValue, _function);
  }
}
