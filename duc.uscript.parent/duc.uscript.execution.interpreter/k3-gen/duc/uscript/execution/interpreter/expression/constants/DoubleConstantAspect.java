package duc.uscript.execution.interpreter.expression.constants;

import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectProperties;
import duc.uscript.execution.interpreter.utils.SymbolSet;
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
    final duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectProperties _self_ = duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.DoubleConstant){
    	result = duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.DoubleConstant)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final DoubleConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectProperties _self_ = duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspectDoubleConstantAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.DoubleConstant){
    	result = duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.DoubleConstant)_self,state);
    };
    return (duc.uscript.execution.interpreter.utils.SymbolSet)result;
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
  
  private static SymbolSet super_findDependentVariables(final DoubleConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final DoubleConstantAspectDoubleConstantAspectProperties _self_, final DoubleConstant _self, final State state) {
    return new SymbolSet();
  }
}
