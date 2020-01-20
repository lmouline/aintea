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
import duc.uscript.utils.Range;
import duc.uscript.utils.SimpleRange;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = And.class)
@SuppressWarnings("all")
public class AndAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final And _self, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.And)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
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
  
  private static Value rightDispatch(final And _self, final BooleanValue left, final Value right, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(BooleanValue,Value,State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.And)_self,left,right,state);
    };
    return (duc.uscript.execution.Value)result;
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
  
  private static ObjectRefValue private_and(final And _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_and(ObjectRefValue,ObjectRefValue,State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_private_and(_self_, (duc.uscript.uScript.And)_self,x,y,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue private_and(final And _self, final ObjectRefValue x, final BooleanValue y, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_and(ObjectRefValue,BooleanValue,State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_private_and(_self_, (duc.uscript.uScript.And)_self,x,y,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue indepNonDisjoint(final And _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue indepNonDisjoint(State,DoubleValue,DoubleValue,BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_indepNonDisjoint(_self_, (duc.uscript.uScript.And)_self,state,probX,probY,valX,valY);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue depNonDisjoint(final And _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue depNonDisjoint(State,DoubleValue,DoubleValue,BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_depNonDisjoint(_self_, (duc.uscript.uScript.And)_self,state,probX,probY,valX,valY);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue disjoint(final And _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue disjoint(State,DoubleValue,DoubleValue,BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_disjoint(_self_, (duc.uscript.uScript.And)_self,state,probX,probY,valX,valY);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static SymbolSet super_findDependentVariables(final And _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final AndAspectAndAspectProperties _self_, final And _self, final State state) {
    final SymbolSet result = new SymbolSet();
    result.addAll(ExpressionAspect.findDependentVariables(_self.getLeft(), state));
    result.addAll(ExpressionAspect.findDependentVariables(_self.getRight(), state));
    return result;
  }
  
  private static Value super_evaluateExpression(final And _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final AndAspectAndAspectProperties _self_, final And _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof BooleanValue) {
      _matched=true;
      Value _xifexpression = null;
      boolean _isValue = ((BooleanValue)left).isValue();
      if (_isValue) {
        Value _xblockexpression = null;
        {
          final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
          _xblockexpression = AndAspect.rightDispatch(_self, ((BooleanValue)left), right, state);
        }
        _xifexpression = _xblockexpression;
      } else {
        BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
        final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
          it.setValue(false);
        };
        _xifexpression = ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
      }
      _switchResult = _xifexpression;
    }
    if (!_matched) {
      if (left instanceof ObjectRefValue) {
        _matched=true;
        ObjectRefValue _xblockexpression = null;
        {
          final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
          _xblockexpression = AndAspect.rightDispatch(_self, ((ObjectRefValue)left), right, state);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final AndAspectAndAspectProperties _self_, final And _self, final BooleanValue left, final Value right, final State state) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof BooleanValue) {
      _matched=true;
      BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
      final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
        it.setValue(((BooleanValue)right).isValue());
      };
      _switchResult = ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
    }
    if (!_matched) {
      if (right instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = AndAspect.private_and(_self, ((ObjectRefValue)right), left, state);
      }
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
    if (right instanceof BooleanValue) {
      _matched=true;
      _switchResult = AndAspect.private_and(_self, left, ((BooleanValue)right), state);
    }
    if (!_matched) {
      if (right instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = AndAspect.private_and(_self, left, ((ObjectRefValue)right), state);
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static ObjectRefValue _privk3_private_and(final AndAspectAndAspectProperties _self_, final And _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
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
      return AndAspect.disjoint(_self, state, probX, probY, valX, valY);
    }
    if (areDependent) {
      return AndAspect.depNonDisjoint(_self, state, probX, probY, valX, valY);
    }
    return AndAspect.indepNonDisjoint(_self, state, probX, probY, valX, valY);
  }
  
  protected static ObjectRefValue _privk3_private_and(final AndAspectAndAspectProperties _self_, final And _self, final ObjectRefValue x, final BooleanValue y, final State state) {
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
    return AndAspect.indepNonDisjoint(_self, state, probX, probY, valX, y);
  }
  
  protected static ObjectRefValue _privk3_indepNonDisjoint(final AndAspectAndAspectProperties _self_, final And _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
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
  
  protected static ObjectRefValue _privk3_depNonDisjoint(final AndAspectAndAspectProperties _self_, final And _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    throw new UnsupportedOperationException("And operator cannot be applied on dependent and non-disjoint elements.");
  }
  
  protected static ObjectRefValue _privk3_disjoint(final AndAspectAndAspectProperties _self_, final And _self, final State state, final DoubleValue probX, final DoubleValue probY, final BooleanValue valX, final BooleanValue valY) {
    final ObjectInstance result = BernoulliBoolUtils.createBernoulliBool(state, 
      0, 
      false, _self);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
}
