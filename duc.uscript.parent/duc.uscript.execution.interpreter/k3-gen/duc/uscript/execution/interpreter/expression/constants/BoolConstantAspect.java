package duc.uscript.execution.interpreter.expression.constants;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectProperties;
import duc.uscript.uScript.BoolConstant;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = BoolConstant.class)
@SuppressWarnings("all")
public class BoolConstantAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final BoolConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectProperties _self_ = duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.BoolConstant){
    	result = duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.BoolConstant)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final BoolConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectProperties _self_ = duc.uscript.execution.interpreter.expression.constants.BoolConstantAspectBoolConstantAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.BoolConstant){
    	result = duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.BoolConstant)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final BoolConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final BoolConstantAspectBoolConstantAspectProperties _self_, final BoolConstant _self, final State state) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue(_self.getValue().equalsIgnoreCase("true"));
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  private static SymbolSet super_findDependentVariables(final BoolConstant _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final BoolConstantAspectBoolConstantAspectProperties _self_, final BoolConstant _self, final State state) {
    return new SymbolSet();
  }
}
