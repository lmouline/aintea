package duc.uscript.execution.interpreter.expression.bool;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties;
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils;
import duc.uscript.uScript.Or;
import duc.uscript.utils.Range;
import duc.uscript.utils.SimpleRange;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Or.class)
@SuppressWarnings("all")
public class OrAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final Or _self, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.Or)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final Or _self, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Or)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Or _self, final BooleanValue left, final Value right, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(BooleanValue,Value,State)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Or)_self,left,right,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static ObjectRefValue rightDispatch(final Or _self, final ObjectRefValue left, final Value right, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue rightDispatch(ObjectRefValue,Value,State)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Or)_self,left,right,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static BooleanValue private_or(final Or _self, final BooleanValue x, final BooleanValue y) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue private_or(BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_private_or(_self_, (duc.uscript.uScript.Or)_self,x,y);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static ObjectRefValue private_or(final Or _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_or(ObjectRefValue,ObjectRefValue,State)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_private_or(_self_, (duc.uscript.uScript.Or)_self,x,y,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue private_or(final Or _self, final ObjectRefValue x, final BooleanValue y, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_or(ObjectRefValue,BooleanValue,State)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_private_or(_self_, (duc.uscript.uScript.Or)_self,x,y,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue indepNonDisjoint(final Or _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue indepNonDisjoint(State,DoubleValue,DoubleValue,BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_indepNonDisjoint(_self_, (duc.uscript.uScript.Or)_self,state,probX,probY,valX,valY);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue depNonDisjoint(final Or _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue depNonDisjoint(State,DoubleValue,DoubleValue,BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_depNonDisjoint(_self_, (duc.uscript.uScript.Or)_self,state,probX,probY,valX,valY);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue disjoint(final Or _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    final duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.OrAspectOrAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue disjoint(State,DoubleValue,DoubleValue,BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.Or){
    	result = duc.uscript.execution.interpreter.expression.bool.OrAspect._privk3_disjoint(_self_, (duc.uscript.uScript.Or)_self,state,probX,probY,valX,valY);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static SymbolSet super_findDependentVariables(final Or _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final OrAspectOrAspectProperties _self_, final Or _self, final State state) {
    final SymbolSet result = new SymbolSet();
    result.addAll(ExpressionAspect.findDependentVariables(_self.getLeft(), state));
    result.addAll(ExpressionAspect.findDependentVariables(_self.getRight(), state));
    return result;
  }
  
  private static Value super_evaluateExpression(final Or _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final OrAspectOrAspectProperties _self_, final Or _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof BooleanValue) {
      _matched=true;
      _switchResult = OrAspect.rightDispatch(_self, ((BooleanValue)left), right, state);
    }
    if (!_matched) {
      if (left instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = OrAspect.rightDispatch(_self, ((ObjectRefValue)left), right, state);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final OrAspectOrAspectProperties _self_, final Or _self, final BooleanValue left, final Value right, final State state) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof BooleanValue) {
      _matched=true;
      _switchResult = OrAspect.private_or(_self, left, ((BooleanValue)right));
    }
    if (!_matched) {
      if (right instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = OrAspect.private_or(_self, ((ObjectRefValue)right), left, state);
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static ObjectRefValue _privk3_rightDispatch(final OrAspectOrAspectProperties _self_, final Or _self, final ObjectRefValue left, final Value right, final State state) {
    ObjectRefValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof BooleanValue) {
      _matched=true;
      _switchResult = OrAspect.private_or(_self, left, ((BooleanValue)right), state);
    }
    if (!_matched) {
      if (right instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = OrAspect.private_or(_self, left, ((ObjectRefValue)right), state);
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_private_or(final OrAspectOrAspectProperties _self_, final Or _self, final BooleanValue x, final BooleanValue y) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue((x.isValue() || y.isValue()));
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static ObjectRefValue _privk3_private_or(final OrAspectOrAspectProperties _self_, final Or _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
    final BooleanValue valX = BernoulliBoolUtils.getValue(x);
    final BooleanValue valY = BernoulliBoolUtils.getValue(y);
    final DoubleValue probX = BernoulliBoolUtils.getProbability(x);
    final DoubleValue probY = BernoulliBoolUtils.getProbability(y);
    final SymbolSet depValLeft = ExpressionAspect.findDependentVariables(_self.getLeft(), state);
    final SymbolSet depValRight = ExpressionAspect.findDependentVariables(_self.getRight(), state);
    Range _findRange = ExpressionAspect.findRange(_self.getLeft(), state);
    final SimpleRange leftRange = ((SimpleRange) _findRange);
    Range _findRange_1 = ExpressionAspect.findRange(_self.getRight(), state);
    final SimpleRange rightRange = ((SimpleRange) _findRange_1);
    final boolean areDependent = depValLeft.containsOne(depValRight);
    final boolean areDisjoint = leftRange.intersectionIsNull(rightRange);
    if (areDisjoint) {
      return OrAspect.disjoint(_self, state, probX, probY, valX, valY);
    }
    if (areDependent) {
      return OrAspect.depNonDisjoint(_self, state, probX, probY, valX, valY);
    }
    return OrAspect.indepNonDisjoint(_self, state, probX, probY, valX, valY);
  }
  
  protected static ObjectRefValue _privk3_private_or(final OrAspectOrAspectProperties _self_, final Or _self, final ObjectRefValue x, final BooleanValue y, final State state) {
    final BooleanValue valX = BernoulliBoolUtils.getValue(x);
    final DoubleValue probX = BernoulliBoolUtils.getProbability(x);
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      int _xifexpression = (int) 0;
      boolean _isValue = y.isValue();
      if (_isValue) {
        _xifexpression = 1;
      } else {
        _xifexpression = 0;
      }
      it.setValue(_xifexpression);
    };
    final DoubleValue probY = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
    return OrAspect.indepNonDisjoint(_self, state, probX, probY, valX, y);
  }
  
  protected static ObjectRefValue _privk3_indepNonDisjoint(final OrAspectOrAspectProperties _self_, final Or _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    double _value = probX.getValue();
    double _value_1 = probY.getValue();
    double _plus = (_value + _value_1);
    double _value_2 = probX.getValue();
    double _value_3 = probY.getValue();
    double _multiply = (_value_2 * _value_3);
    double _minus = (_plus - _multiply);
    final ObjectInstance result = BernoulliBoolUtils.createBernoulliBool(state, _minus, 
      (valX.isValue() || valY.isValue()), _self);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
  
  protected static ObjectRefValue _privk3_depNonDisjoint(final OrAspectOrAspectProperties _self_, final Or _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    throw new UnsupportedOperationException("Or operator cannot be applied on dependent and non-disjoint elements.");
  }
  
  protected static ObjectRefValue _privk3_disjoint(final OrAspectOrAspectProperties _self_, final Or _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    double _value = probX.getValue();
    double _value_1 = probY.getValue();
    double _plus = (_value + _value_1);
    final ObjectInstance result = BernoulliBoolUtils.createBernoulliBool(state, _plus, 
      (valX.isValue() || valY.isValue()), _self);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
}
