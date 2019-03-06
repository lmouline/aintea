package duc.uscript.execution.interpreter.expression.bool;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties;
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
  
  private static BooleanValue private_or(final Not _self, final BooleanValue x) {
    final duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue private_or(BooleanValue)
    if (_self instanceof duc.uscript.uScript.Not){
    	result = duc.uscript.execution.interpreter.expression.bool.NotAspect._privk3_private_or(_self_, (duc.uscript.uScript.Not)_self,x);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static Value super_evaluateExpression(final Not _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NotAspectNotAspectProperties _self_, final Not _self, final State state) {
    final Value value = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (value instanceof BooleanValue) {
      _matched=true;
      _switchResult = NotAspect.private_or(_self, ((BooleanValue)value));
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_private_or(final NotAspectNotAspectProperties _self_, final Not _self, final BooleanValue x) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      boolean _isValue = x.isValue();
      boolean _not = (!_isValue);
      it.setValue(_not);
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
