package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.ArrayInstance;
import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectProperties;
import duc.uscript.uScript.NewArray;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = NewArray.class)
@SuppressWarnings("all")
public class NewArrayAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final NewArray _self, final State state) {
    final duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.NewArray){
    	result = duc.uscript.execution.interpreter.expression.NewArrayAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.NewArray)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final NewArray _self, final State state) {
    final duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NewArrayAspectNewArrayAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.NewArray){
    	result = duc.uscript.execution.interpreter.expression.NewArrayAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.NewArray)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final NewArray _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NewArrayAspectNewArrayAspectProperties _self_, final NewArray _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getSize(), state);
    final int arraSize = ((IntegerValue) _evaluateExpression).getValue();
    ArrayInstance _createArrayInstance = ExecutionFactory.eINSTANCE.createArrayInstance();
    final Procedure1<ArrayInstance> _function = (ArrayInstance it) -> {
      it.setSize(arraSize);
    };
    final ArrayInstance result = ObjectExtensions.<ArrayInstance>operator_doubleArrow(_createArrayInstance, _function);
    state.getArraysHeap().add(result);
    IntegerRange _upTo = new IntegerRange(1, arraSize);
    for (final Integer i : _upTo) {
      result.getValue().add(ExecutionFactory.eINSTANCE.createNullValue());
    }
    ArrayRefValue _createArrayRefValue = ExecutionFactory.eINSTANCE.createArrayRefValue();
    final Procedure1<ArrayRefValue> _function_1 = (ArrayRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function_1);
  }
  
  private static SymbolSet super_findDependentVariables(final NewArray _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final NewArrayAspectNewArrayAspectProperties _self_, final NewArray _self, final State state) {
    return new SymbolSet();
  }
}
