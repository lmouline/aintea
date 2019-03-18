package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.Frame;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.statement.AStatementAspect;
import duc.uscript.execution.interpreter.statement.ReturnAspectReturnAspectProperties;
import duc.uscript.uScript.Return;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = Return.class)
@SuppressWarnings("all")
public class ReturnAspect extends AStatementAspect {
  @OverrideAspectMethod
  public static void evaluateStatement(final Return _self, final State state) {
    final duc.uscript.execution.interpreter.statement.ReturnAspectReturnAspectProperties _self_ = duc.uscript.execution.interpreter.statement.ReturnAspectReturnAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.Return){
    	duc.uscript.execution.interpreter.statement.ReturnAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.Return)_self,state);
    };
  }
  
  private static void super_evaluateStatement(final Return _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectContext.getSelf(_self);
     duc.uscript.execution.interpreter.statement.AStatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final ReturnAspectReturnAspectProperties _self_, final Return _self, final State state) {
    final Value value = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    Frame _findCurrentFrame = StateAspect.findCurrentFrame(state);
    _findCurrentFrame.setValue(value);
  }
}
