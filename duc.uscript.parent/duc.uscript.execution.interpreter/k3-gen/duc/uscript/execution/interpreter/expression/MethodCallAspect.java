package duc.uscript.execution.interpreter.expression;

import com.google.common.base.Objects;
import duc.uscript.execution.Context;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.MethodCall4;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.SymbolBindings;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.MethodAspect;
import duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectProperties;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.uScript.Expression;
import duc.uscript.uScript.Method;
import duc.uscript.uScript.MethodCall;
import duc.uscript.uScript.Parameter;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = MethodCall.class)
@SuppressWarnings("all")
public class MethodCallAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final MethodCall _self, final State state) {
    final duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectProperties _self_ = duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.MethodCall){
    	result = duc.uscript.execution.interpreter.expression.MethodCallAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.MethodCall)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final MethodCall _self, final State state) {
    final duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectProperties _self_ = duc.uscript.execution.interpreter.expression.MethodCallAspectMethodCallAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.MethodCall){
    	result = duc.uscript.execution.interpreter.expression.MethodCallAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.MethodCall)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final MethodCall _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final MethodCallAspectMethodCallAspectProperties _self_, final MethodCall _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getReceiver(), state);
    final ObjectInstance receiver = ((ObjectRefValue) _evaluateExpression).getInstance();
    final Method method = _self.getMethod();
    final Context ctx = ExecutionFactory.eINSTANCE.createContext();
    EList<Expression> _args = _self.getArgs();
    for (final Expression arg : _args) {
      {
        final Parameter param = method.getParams().get(_self.getArgs().indexOf(arg));
        SymbolBindings _createSymbolBindings = ExecutionFactory.eINSTANCE.createSymbolBindings();
        final Procedure1<SymbolBindings> _function = (SymbolBindings it) -> {
          it.setSymbol(param);
          it.setValue(ExpressionAspect.evaluateExpression(arg, state));
        };
        final SymbolBindings binding = ObjectExtensions.<SymbolBindings>operator_doubleArrow(_createSymbolBindings, _function);
        ctx.getBindings().add(binding);
      }
    }
    EList<FieldBinding> _fieldbindings = receiver.getFieldbindings();
    for (final FieldBinding fieldBdg : _fieldbindings) {
      {
        SymbolBindings _createSymbolBindings = ExecutionFactory.eINSTANCE.createSymbolBindings();
        final Procedure1<SymbolBindings> _function = (SymbolBindings it) -> {
          it.setSymbol(fieldBdg.getField());
          it.setValue(fieldBdg.getValue());
        };
        final SymbolBindings smbBdg = ObjectExtensions.<SymbolBindings>operator_doubleArrow(_createSymbolBindings, _function);
        ctx.getBindings().add(smbBdg);
      }
    }
    MethodCall4 _createMethodCall4 = ExecutionFactory.eINSTANCE.createMethodCall4();
    final Procedure1<MethodCall4> _function = (MethodCall4 it) -> {
      it.setMethodCall(_self);
    };
    final MethodCall4 call = ObjectExtensions.<MethodCall4>operator_doubleArrow(_createMethodCall4, _function);
    StateAspect.pushNewFrame(state, receiver, call, ctx);
    MethodAspect.call(method, state);
    final Value returnValue = StateAspect.findCurrentFrame(state).getValue();
    final Function1<SymbolBindings, String> _function_1 = (SymbolBindings it) -> {
      return it.getSymbol().getName();
    };
    final List<String> names = ListExtensions.<SymbolBindings, String>map(ctx.getBindings(), _function_1);
    final Function1<SymbolBindings, Boolean> _function_2 = (SymbolBindings it) -> {
      return Boolean.valueOf(names.contains(it.getSymbol().getName()));
    };
    final Consumer<SymbolBindings> _function_3 = (SymbolBindings it) -> {
      final Value value = it.getValue();
      final String name = it.getSymbol().getName();
      final Function1<FieldBinding, Boolean> _function_4 = (FieldBinding it_1) -> {
        String _name = it_1.getField().getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      };
      FieldBinding _findFirst = IterableExtensions.<FieldBinding>findFirst(receiver.getFieldbindings(), _function_4);
      _findFirst.setValue(value);
    };
    IterableExtensions.<SymbolBindings>filter(ctx.getBindings(), _function_2).forEach(_function_3);
    StateAspect.popCurrentFrame(state);
    return returnValue;
  }
  
  private static SymbolSet super_findDependentVariables(final MethodCall _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final MethodCallAspectMethodCallAspectProperties _self_, final MethodCall _self, final State state) {
    final SymbolSet result = new SymbolSet();
    EList<Expression> _args = _self.getArgs();
    for (final Expression arg : _args) {
      result.addAll(ExpressionAspect.findDependentVariables(arg, state));
    }
    return result;
  }
}
