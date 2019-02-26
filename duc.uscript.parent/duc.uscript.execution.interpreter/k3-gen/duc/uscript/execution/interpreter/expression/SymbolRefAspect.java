package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.modelstate.ContextAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.uScript.SymbolRef;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = SymbolRef.class)
@SuppressWarnings("all")
public class SymbolRefAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final SymbolRef _self, final State state) {
    final duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties _self_ = duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.SymbolRef){
    	result = duc.uscript.execution.interpreter.expression.SymbolRefAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.SymbolRef)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value super_evaluateExpression(final SymbolRef _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final SymbolRefAspectSymbolRefAspectProperties _self_, final SymbolRef _self, final State state) {
    return ValueAspect.copy(ContextAspect.findBinding(StateAspect.findCurrentContext(state), _self.getSymbol()).getValue());
  }
}
