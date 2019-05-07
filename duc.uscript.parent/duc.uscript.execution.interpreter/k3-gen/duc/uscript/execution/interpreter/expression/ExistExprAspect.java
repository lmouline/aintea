package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectProperties;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils;
import duc.uscript.uScript.ExistExpr;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ExistExpr.class)
@SuppressWarnings("all")
public class ExistExprAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final ExistExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.ExistExpr){
    	result = duc.uscript.execution.interpreter.expression.ExistExprAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.ExistExpr)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final ExistExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.ExistExpr){
    	result = duc.uscript.execution.interpreter.expression.ExistExprAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.ExistExpr)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue exist(final ExistExpr _self, final ObjectRefValue bernRef, final double conf) {
    final duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExistExprAspectExistExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue exist(ObjectRefValue,double)
    if (_self instanceof duc.uscript.uScript.ExistExpr){
    	result = duc.uscript.execution.interpreter.expression.ExistExprAspect._privk3_exist(_self_, (duc.uscript.uScript.ExistExpr)_self,bernRef,conf);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static SymbolSet super_findDependentVariables(final ExistExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final ExistExprAspectExistExprAspectProperties _self_, final ExistExpr _self, final State state) {
    return new SymbolSet();
  }
  
  private static Value super_evaluateExpression(final ExistExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ExistExprAspectExistExprAspectProperties _self_, final ExistExpr _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getExpr(), state);
    final ObjectRefValue uData = ((ObjectRefValue) _evaluateExpression);
    Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(_self.getConfidence(), state);
    final DoubleValue confidence = ((DoubleValue) _evaluateExpression_1);
    return ExistExprAspect.exist(_self, uData, confidence.getValue());
  }
  
  protected static BooleanValue _privk3_exist(final ExistExprAspectExistExprAspectProperties _self_, final ExistExpr _self, final ObjectRefValue bernRef, final double conf) {
    final double prob = BernoulliBoolUtils.getProbability(bernRef).getValue();
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue((prob >= conf));
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
