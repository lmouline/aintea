package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.Context;
import duc.uscript.execution.State;
import duc.uscript.execution.SymbolBindings;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ContextAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.uScript.SymbolRef;
import duc.uscript.utils.Range;
import duc.uscript.utils.SymbolSet;
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
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final SymbolRef _self, final State state) {
    final duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties _self_ = duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.SymbolRef){
    	result = duc.uscript.execution.interpreter.expression.SymbolRefAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.SymbolRef)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Range findRange(final SymbolRef _self, final State state) {
    final duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectProperties _self_ = duc.uscript.execution.interpreter.expression.SymbolRefAspectSymbolRefAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Range findRange(State)
    if (_self instanceof duc.uscript.uScript.SymbolRef){
    	result = duc.uscript.execution.interpreter.expression.SymbolRefAspect._privk3_findRange(_self_, (duc.uscript.uScript.SymbolRef)_self,state);
    };
    return (duc.uscript.utils.Range)result;
  }
  
  private static Value super_evaluateExpression(final SymbolRef _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final SymbolRefAspectSymbolRefAspectProperties _self_, final SymbolRef _self, final State state) {
    final Context ctx = StateAspect.findCurrentContext(state);
    final SymbolBindings bindings = ContextAspect.findBinding(ctx, _self.getSymbol());
    final Value bindingVal = bindings.getValue();
    return ValueAspect.copy(bindingVal);
  }
  
  private static SymbolSet super_findDependentVariables(final SymbolRef _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final SymbolRefAspectSymbolRefAspectProperties _self_, final SymbolRef _self, final State state) {
    final Context context = StateAspect.findCurrentContext(state);
    final SymbolBindings existingBinding = ContextAspect.findBinding(context, _self.getSymbol());
    final SymbolSet result = new SymbolSet();
    result.add(_self.getSymbol());
    result.addAll(existingBinding.getSymbolSet());
    return result;
  }
  
  private static Range super_findRange(final SymbolRef _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findRange(_self_, _self,state);
  }
  
  protected static Range _privk3_findRange(final SymbolRefAspectSymbolRefAspectProperties _self_, final SymbolRef _self, final State state) {
    final Context context = StateAspect.findCurrentContext(state);
    final SymbolBindings existingBinding = ContextAspect.findBinding(context, _self.getSymbol());
    return existingBinding.getRange();
  }
}
