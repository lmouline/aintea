package duc.uscript.execution.interpreter.expression;

import duc.aintea.lib.poissonbinomial.Computer;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.uScript.ComputeNbTrueExpr;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = ComputeNbTrueExpr.class)
@SuppressWarnings("all")
public class ComputeNbrTrueExprAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.ComputeNbTrueExpr){
    	result = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.ComputeNbTrueExpr)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.ComputeNbTrueExpr){
    	result = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.ComputeNbTrueExpr)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static SymbolSet super_findDependentVariables(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_, final ComputeNbTrueExpr _self, final State state) {
    return new SymbolSet();
  }
  
  private static Value super_evaluateExpression(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_, final ComputeNbTrueExpr _self, final State state) {
    final Computer c = new Computer();
    c.big_compute();
    return null;
  }
}
