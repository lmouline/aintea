package duc.uscript.execution.interpreter.expression.bool;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties;
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils;
import duc.uscript.uScript.Not;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Not.class)
@SuppressWarnings("all")
public class NotAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Not _self, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Not){
    	result = duc.uscript.execution.interpreter.expression.bool.NotAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Not)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue private_not(final Not _self, final BooleanValue x) {
    final duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue private_not(BooleanValue)
    if (_self instanceof duc.uscript.uScript.Not){
    	result = duc.uscript.execution.interpreter.expression.bool.NotAspect._privk3_private_not(_self_, (duc.uscript.uScript.Not)_self,x);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static ObjectRefValue private_not(final Not _self, final ObjectRefValue x, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_not(ObjectRefValue,State)
    if (_self instanceof duc.uscript.uScript.Not){
    	result = duc.uscript.execution.interpreter.expression.bool.NotAspect._privk3_private_not(_self_, (duc.uscript.uScript.Not)_self,x,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static Value super_evaluateExpression(final Not _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NotAspectNotAspectProperties _self_, final Not _self, final State state) {
    final Value value = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (value instanceof BooleanValue) {
      _matched=true;
      _switchResult = NotAspect.private_not(_self, ((BooleanValue)value));
    }
    if (!_matched) {
      if (value instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = NotAspect.private_not(_self, ((ObjectRefValue)value), state);
      }
    }
    if (!_matched) {
      String _name = value.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_private_not(final NotAspectNotAspectProperties _self_, final Not _self, final BooleanValue x) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      boolean _isValue = x.isValue();
      boolean _not = (!_isValue);
      it.setValue(_not);
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static ObjectRefValue _privk3_private_not(final NotAspectNotAspectProperties _self_, final Not _self, final ObjectRefValue x, final State state) {
    final BooleanValue valX = BernoulliBoolUtils.getValue(x);
    final DoubleValue probX = BernoulliBoolUtils.getProbability(x);
    double _value = probX.getValue();
    double _minus = (1 - _value);
    boolean _isValue = valX.isValue();
    boolean _not = (!_isValue);
    final ObjectInstance result = BernoulliBoolUtils.createBernoulliBool(state, _minus, _not, _self);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
}
