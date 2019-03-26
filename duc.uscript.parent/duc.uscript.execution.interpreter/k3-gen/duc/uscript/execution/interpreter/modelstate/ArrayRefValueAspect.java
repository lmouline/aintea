package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ArrayRefValue.class)
@SuppressWarnings("all")
public class ArrayRefValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final ArrayRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.ArrayRefValue){
    	result = duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.ArrayRefValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final ArrayRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspectArrayRefValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.ArrayRefValue){
    	result = duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect._privk3_copy(_self_, (duc.uscript.execution.ArrayRefValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final ArrayRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final ArrayRefValueAspectArrayRefValueAspectProperties _self_, final ArrayRefValue _self) {
    final StringBuilder result = new StringBuilder();
    result.append("[");
    final EList<Value> values = _self.getInstance().getValue();
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(values, Object.class)).length); i++) {
      {
        result.append(ValueAspect.convertToString(values.get(i)));
        int _length = ((Object[])Conversions.unwrapArray(values, Object.class)).length;
        int _minus = (_length - 1);
        boolean _lessThan = (i < _minus);
        if (_lessThan) {
          result.append(", ");
        }
      }
    }
    result.append("]");
    return result.toString();
  }
  
  private static Value super_copy(final ArrayRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final ArrayRefValueAspectArrayRefValueAspectProperties _self_, final ArrayRefValue _self) {
    ArrayRefValue _createArrayRefValue = ExecutionFactory.eINSTANCE.createArrayRefValue();
    final Procedure1<ArrayRefValue> _function = (ArrayRefValue it) -> {
      it.setInstance(_self.getInstance());
    };
    return ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function);
  }
}
