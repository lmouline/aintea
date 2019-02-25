package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.DoubleConstantAspectDoubleConstantAspectProperties;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.uScript.DoubleConstant;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = DoubleConstant.class)
@SuppressWarnings("all")
public class DoubleConstantAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final DoubleConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.DoubleConstantAspectDoubleConstantAspectProperties _self_ = duc.uscript.execution.interpreter.expression.DoubleConstantAspectDoubleConstantAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.DoubleConstant){
    	result = duc.uscript.execution.interpreter.expression.DoubleConstantAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.DoubleConstant)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value super_evaluateExpression(final DoubleConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final DoubleConstantAspectDoubleConstantAspectProperties _self_, final DoubleConstant _self, final State state) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
}
