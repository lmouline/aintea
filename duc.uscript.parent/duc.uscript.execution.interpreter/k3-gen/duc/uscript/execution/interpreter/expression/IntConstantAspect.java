package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.IntConstantAspectIntConstantAspectProperties;
import duc.uscript.uScript.IntConstant;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = IntConstant.class)
@SuppressWarnings("all")
public class IntConstantAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final IntConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.IntConstantAspectIntConstantAspectProperties _self_ = duc.uscript.execution.interpreter.expression.IntConstantAspectIntConstantAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.IntConstant){
    	result = duc.uscript.execution.interpreter.expression.IntConstantAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.IntConstant)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value super_evaluateExpression(final IntConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final IntConstantAspectIntConstantAspectProperties _self_, final IntConstant _self, final State state) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
}
