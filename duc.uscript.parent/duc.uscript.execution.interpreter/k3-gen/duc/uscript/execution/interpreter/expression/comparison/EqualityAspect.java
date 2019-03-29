package duc.uscript.execution.interpreter.expression.comparison;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties;
import duc.uscript.uScript.Equality;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Equality.class)
@SuppressWarnings("all")
public class EqualityAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final Equality _self, final State state) {
    final duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.Equality){
    	result = duc.uscript.execution.interpreter.expression.comparison.EqualityAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.Equality)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final Equality _self, final State state) {
    final duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Equality){
    	result = duc.uscript.execution.interpreter.expression.comparison.EqualityAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Equality)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue rightDispatch(final Equality _self, final IntegerValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue rightDispatch(IntegerValue,Value)
    if (_self instanceof duc.uscript.uScript.Equality){
    	result = duc.uscript.execution.interpreter.expression.comparison.EqualityAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Equality)_self,left,right);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue strictEquality(final Equality _self, final IntegerValue x, final IntegerValue y) {
    final duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.EqualityAspectEqualityAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue strictEquality(IntegerValue,IntegerValue)
    if (_self instanceof duc.uscript.uScript.Equality){
    	result = duc.uscript.execution.interpreter.expression.comparison.EqualityAspect._privk3_strictEquality(_self_, (duc.uscript.uScript.Equality)_self,x,y);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static SymbolSet super_findDependentVariables(final Equality _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final EqualityAspectEqualityAspectProperties _self_, final Equality _self, final State state) {
    return new SymbolSet();
  }
  
  private static Value super_evaluateExpression(final Equality _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final EqualityAspectEqualityAspectProperties _self_, final Equality _self, final State state) {
    final Value leftVal = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value rightVal = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (leftVal instanceof IntegerValue) {
      _matched=true;
      _switchResult = EqualityAspect.rightDispatch(_self, ((IntegerValue)leftVal), rightVal);
    }
    if (!_matched) {
      String _name = leftVal.getClass().getName();
      String _plus = ("Equality operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_rightDispatch(final EqualityAspectEqualityAspectProperties _self_, final Equality _self, final IntegerValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof IntegerValue) {
      _matched=true;
      _switchResult = EqualityAspect.strictEquality(_self, left, ((IntegerValue)right));
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Equality operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_strictEquality(final EqualityAspectEqualityAspectProperties _self_, final Equality _self, final IntegerValue x, final IntegerValue y) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      int _value = x.getValue();
      int _value_1 = y.getValue();
      boolean _equals = (_value == _value_1);
      it.setValue(_equals);
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
