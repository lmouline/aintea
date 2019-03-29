package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectProperties;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.uScript.ArrayLength;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ArrayLength.class)
@SuppressWarnings("all")
public class ArrayLengthAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final ArrayLength _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.ArrayLength){
    	result = duc.uscript.execution.interpreter.expression.ArrayLengthAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.ArrayLength)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final ArrayLength _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ArrayLengthAspectArrayLengthAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.ArrayLength){
    	result = duc.uscript.execution.interpreter.expression.ArrayLengthAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.ArrayLength)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final ArrayLength _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ArrayLengthAspectArrayLengthAspectProperties _self_, final ArrayLength _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getArray(), state);
    final ArrayRefValue arrayRef = ((ArrayRefValue) _evaluateExpression);
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      it.setValue(arrayRef.getInstance().getSize());
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  private static SymbolSet super_findDependentVariables(final ArrayLength _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final ArrayLengthAspectArrayLengthAspectProperties _self_, final ArrayLength _self, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("findDependentVariables should be overriden for type ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
}
