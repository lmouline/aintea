package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils;
import duc.uscript.uScript.ArrayAccess;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ArrayAccess.class)
@SuppressWarnings("all")
public class ArrayAccessImpl extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final ArrayAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.ArrayAccess){
    	result = duc.uscript.execution.interpreter.expression.ArrayAccessImpl._privk3_findDependentVariables(_self_, (duc.uscript.uScript.ArrayAccess)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final ArrayAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.ArrayAccess){
    	result = duc.uscript.execution.interpreter.expression.ArrayAccessImpl._privk3_evaluateExpression(_self_, (duc.uscript.uScript.ArrayAccess)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value realAccess(final ArrayAccess _self, final ArrayRefValue arrayRef, final int index, final State state) {
    final duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value realAccess(ArrayRefValue,int,State)
    if (_self instanceof duc.uscript.uScript.ArrayAccess){
    	result = duc.uscript.execution.interpreter.expression.ArrayAccessImpl._privk3_realAccess(_self_, (duc.uscript.uScript.ArrayAccess)_self,arrayRef,index,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value confidenceOperator(final ArrayAccess _self, final ObjectRefValue bernRef, final int givenConf, final State state) {
    final duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ArrayAccessImplArrayAccessAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value confidenceOperator(ObjectRefValue,int,State)
    if (_self instanceof duc.uscript.uScript.ArrayAccess){
    	result = duc.uscript.execution.interpreter.expression.ArrayAccessImpl._privk3_confidenceOperator(_self_, (duc.uscript.uScript.ArrayAccess)_self,bernRef,givenConf,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static SymbolSet super_findDependentVariables(final ArrayAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final ArrayAccessImplArrayAccessAspectProperties _self_, final ArrayAccess _self, final State state) {
    return new SymbolSet();
  }
  
  private static Value super_evaluateExpression(final ArrayAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ArrayAccessImplArrayAccessAspectProperties _self_, final ArrayAccess _self, final State state) {
    final Value arrayRef = ExpressionAspect.evaluateExpression(_self.getObject(), state);
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getIndex(), state);
    final int index = ((IntegerValue) _evaluateExpression).getValue();
    Value _switchResult = null;
    boolean _matched = false;
    if (arrayRef instanceof ArrayRefValue) {
      _matched=true;
      _switchResult = ArrayAccessImpl.realAccess(_self, ((ArrayRefValue)arrayRef), index, state);
    }
    if (!_matched) {
      if (arrayRef instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = ArrayAccessImpl.confidenceOperator(_self, ((ObjectRefValue)arrayRef), index, state);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_realAccess(final ArrayAccessImplArrayAccessAspectProperties _self_, final ArrayAccess _self, final ArrayRefValue arrayRef, final int index, final State state) {
    return ValueAspect.copy(arrayRef.getInstance().getValue().get(index));
  }
  
  protected static Value _privk3_confidenceOperator(final ArrayAccessImplArrayAccessAspectProperties _self_, final ArrayAccess _self, final ObjectRefValue bernRef, final int givenConf, final State state) {
    final double conf = BernoulliBoolUtils.getProbability(bernRef).getValue();
    final boolean uValue = BernoulliBoolUtils.getValue(bernRef).isValue();
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (uValue) {
        it.setValue((conf >= givenConf));
      } else {
        it.setValue((conf < givenConf));
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
