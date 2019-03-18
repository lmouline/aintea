package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.Context;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.MethodCall3;
import duc.uscript.execution.State;
import duc.uscript.execution.SymbolBindings;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.MethodAspect;
import duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectProperties;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.utils.SymbolSet;
import duc.uscript.uScript.Expression;
import duc.uscript.uScript.MethodCall2;
import duc.uscript.uScript.Parameter;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = MethodCall2.class)
@SuppressWarnings("all")
public class MethodCall2Aspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final MethodCall2 _self, final State state) {
    final duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectProperties _self_ = duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.MethodCall2){
    	result = duc.uscript.execution.interpreter.expression.MethodCall2Aspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.MethodCall2)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final MethodCall2 _self, final State state) {
    final duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectProperties _self_ = duc.uscript.execution.interpreter.expression.MethodCall2AspectMethodCall2AspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.MethodCall2){
    	result = duc.uscript.execution.interpreter.expression.MethodCall2Aspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.MethodCall2)_self,state);
    };
    return (duc.uscript.execution.interpreter.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final MethodCall2 _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final MethodCall2AspectMethodCall2AspectProperties _self_, final MethodCall2 _self, final State state) {
    final Context newCtx = ExecutionFactory.eINSTANCE.createContext();
    EList<Expression> _args = _self.getArgs();
    for (final Expression arg : _args) {
      {
        final Parameter param = _self.getMethod().getParams().get(_self.getArgs().indexOf(arg));
        SymbolBindings _createSymbolBindings = ExecutionFactory.eINSTANCE.createSymbolBindings();
        final Procedure1<SymbolBindings> _function = (SymbolBindings it) -> {
          it.setSymbol(param);
          it.setValue(ExpressionAspect.evaluateExpression(arg, state));
        };
        final SymbolBindings binding = ObjectExtensions.<SymbolBindings>operator_doubleArrow(_createSymbolBindings, _function);
        newCtx.getBindings().add(binding);
      }
    }
    MethodCall3 _createMethodCall3 = ExecutionFactory.eINSTANCE.createMethodCall3();
    final Procedure1<MethodCall3> _function = (MethodCall3 it) -> {
      it.setMethodcall(_self);
    };
    final MethodCall3 call = ObjectExtensions.<MethodCall3>operator_doubleArrow(_createMethodCall3, _function);
    StateAspect.pushNewFrame(state, null, call, newCtx);
    MethodAspect.call(_self.getMethod(), state);
    final Value returnValue = StateAspect.findCurrentFrame(state).getValue();
    StateAspect.popCurrentFrame(state);
    return returnValue;
  }
  
  private static SymbolSet super_findDependentVariables(final MethodCall2 _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final MethodCall2AspectMethodCall2AspectProperties _self_, final MethodCall2 _self, final State state) {
    final SymbolSet result = new SymbolSet();
    EList<Expression> _args = _self.getArgs();
    for (final Expression arg : _args) {
      result.addAll(ExpressionAspect.findDependentVariables(arg, state));
    }
    return result;
  }
}
