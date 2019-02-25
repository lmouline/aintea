package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.State;
import duc.uscript.execution.StringValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.StringConstantAspectStringConstantAspectProperties;
import duc.uscript.uScript.StringConstant;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = StringConstant.class)
@SuppressWarnings("all")
public class StringConstantAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final StringConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.StringConstantAspectStringConstantAspectProperties _self_ = duc.uscript.execution.interpreter.expression.StringConstantAspectStringConstantAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.StringConstant){
    	result = duc.uscript.execution.interpreter.expression.StringConstantAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.StringConstant)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value super_evaluateExpression(final StringConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final StringConstantAspectStringConstantAspectProperties _self_, final StringConstant _self, final State state) {
    StringValue _createStringValue = ExecutionFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      it.setValue(_self.getValue());
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
}
