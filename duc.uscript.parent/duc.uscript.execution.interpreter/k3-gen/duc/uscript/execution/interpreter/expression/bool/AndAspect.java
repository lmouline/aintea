package duc.uscript.execution.interpreter.expression.bool;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties;
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils;
import duc.uscript.uScript.And;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = And.class)
@SuppressWarnings("all")
public class AndAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final And _self, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.And)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue rightDispatch(final And _self, final BooleanValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue rightDispatch(BooleanValue,Value)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.And)_self,left,right);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static ObjectRefValue rightDispatch(final And _self, final ObjectRefValue left, final Value right, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue rightDispatch(ObjectRefValue,Value,State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.And)_self,left,right,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static BooleanValue private_and(final And _self, final BooleanValue x, final BooleanValue y) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue private_and(BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_private_and(_self_, (duc.uscript.uScript.And)_self,x,y);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static ObjectRefValue private_and(final And _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_and(ObjectRefValue,ObjectRefValue,State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_private_and(_self_, (duc.uscript.uScript.And)_self,x,y,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static Value super_evaluateExpression(final And _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final AndAspectAndAspectProperties _self_, final And _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof BooleanValue) {
      _matched=true;
      _switchResult = AndAspect.rightDispatch(_self, ((BooleanValue)left), right);
    }
    if (!_matched) {
      if (left instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = AndAspect.rightDispatch(_self, ((ObjectRefValue)left), right, state);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_rightDispatch(final AndAspectAndAspectProperties _self_, final And _self, final BooleanValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof BooleanValue) {
      _matched=true;
      _switchResult = AndAspect.private_and(_self, left, ((BooleanValue)right));
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static ObjectRefValue _privk3_rightDispatch(final AndAspectAndAspectProperties _self_, final And _self, final ObjectRefValue left, final Value right, final State state) {
    ObjectRefValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ObjectRefValue) {
      _matched=true;
      _switchResult = AndAspect.private_and(_self, left, ((ObjectRefValue)right), state);
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_private_and(final AndAspectAndAspectProperties _self_, final And _self, final BooleanValue x, final BooleanValue y) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue((x.isValue() && y.isValue()));
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static ObjectRefValue _privk3_private_and(final AndAspectAndAspectProperties _self_, final And _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
    final BooleanValue valX = BernoulliBoolUtils.getValue(x);
    final BooleanValue valY = BernoulliBoolUtils.getValue(y);
    final DoubleValue probX = BernoulliBoolUtils.getProbability(x);
    final DoubleValue probY = BernoulliBoolUtils.getProbability(y);
    double _value = probX.getValue();
    double _value_1 = probY.getValue();
    double _multiply = (_value * _value_1);
    final ObjectInstance result = BernoulliBoolUtils.createBernoulliBool(state, _multiply, 
      (valX.isValue() && valY.isValue()), _self);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
}
