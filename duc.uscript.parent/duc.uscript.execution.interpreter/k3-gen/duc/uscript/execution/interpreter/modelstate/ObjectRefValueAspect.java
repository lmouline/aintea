package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ObjectRefValue.class)
@SuppressWarnings("all")
public class ObjectRefValueAspect extends ValueAspect {
  @OverrideAspectMethod
  public static String convertToString(final ObjectRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.ObjectRefValue){
    	result = duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.ObjectRefValue)_self);
    };
    return (java.lang.String)result;
  }
  
  @OverrideAspectMethod
  public static Value copy(final ObjectRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspectObjectRefValueAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.ObjectRefValue){
    	result = duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect._privk3_copy(_self_, (duc.uscript.execution.ObjectRefValue)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static String super_convertToString(final ObjectRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, _self);
  }
  
  protected static String _privk3_convertToString(final ObjectRefValueAspectObjectRefValueAspectProperties _self_, final ObjectRefValue _self) {
    final ObjectInstance objInstance = _self.getInstance();
    final StringBuilder builder = new StringBuilder();
    builder.append(objInstance.getType().getName());
    builder.append("(");
    final EList<FieldBinding> fields = objInstance.getFieldbindings();
    for (int i = 0; (i < fields.size()); i++) {
      {
        final FieldBinding fBdg = fields.get(i);
        final String fieldName = fBdg.getField().getName();
        final String value = ValueAspect.convertToString(fBdg.getValue());
        builder.append(((fieldName + ":") + value));
        int _size = fields.size();
        int _minus = (_size - 1);
        boolean _lessThan = (i < _minus);
        if (_lessThan) {
          builder.append(", ");
        }
      }
    }
    builder.append(")");
    return builder.toString();
  }
  
  private static Value super_copy(final ObjectRefValue _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, _self);
  }
  
  protected static Value _privk3_copy(final ObjectRefValueAspectObjectRefValueAspectProperties _self_, final ObjectRefValue _self) {
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(_self.getInstance());
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
}
