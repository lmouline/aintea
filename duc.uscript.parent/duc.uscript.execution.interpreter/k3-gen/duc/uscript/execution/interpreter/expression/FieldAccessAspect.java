package duc.uscript.execution.interpreter.expression;

import com.google.common.base.Objects;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectProperties;
import duc.uscript.uScript.FieldAccess;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Aspect(className = FieldAccess.class)
@SuppressWarnings("all")
public class FieldAccessAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final FieldAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectProperties _self_ = duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.FieldAccess){
    	result = duc.uscript.execution.interpreter.expression.FieldAccessAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.FieldAccess)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final FieldAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectProperties _self_ = duc.uscript.execution.interpreter.expression.FieldAccessAspectFieldAccessAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.FieldAccess){
    	result = duc.uscript.execution.interpreter.expression.FieldAccessAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.FieldAccess)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final FieldAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final FieldAccessAspectFieldAccessAspectProperties _self_, final FieldAccess _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getReceiver(), state);
    ObjectInstance _instance = ((ObjectRefValue) _evaluateExpression).getInstance();
    final ObjectInstance realReceiver = ((ObjectInstance) _instance);
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      String _name_1 = _self.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, _name_1));
    };
    return IterableExtensions.<FieldBinding>findFirst(realReceiver.getFieldbindings(), _function).getValue();
  }
  
  private static SymbolSet super_findDependentVariables(final FieldAccess _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final FieldAccessAspectFieldAccessAspectProperties _self_, final FieldAccess _self, final State state) {
    return new SymbolSet();
  }
}
