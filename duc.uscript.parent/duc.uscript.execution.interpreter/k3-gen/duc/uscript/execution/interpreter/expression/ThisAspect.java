package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.ThisAspectThisAspectProperties;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.uScript.This;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = This.class)
@SuppressWarnings("all")
public class ThisAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final This _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ThisAspectThisAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ThisAspectThisAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.This){
    	result = duc.uscript.execution.interpreter.expression.ThisAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.This)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value super_evaluateExpression(final This _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ThisAspectThisAspectProperties _self_, final This _self, final State state) {
    final ObjectInstance currentInstance = StateAspect.findCurrentFrame(state).getInstance();
    if ((currentInstance == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"this\" is not valid in the current context");
      throw new RuntimeException(_builder.toString());
    } else {
      ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
      final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
        it.setInstance(currentInstance);
      };
      return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
    }
  }
}
