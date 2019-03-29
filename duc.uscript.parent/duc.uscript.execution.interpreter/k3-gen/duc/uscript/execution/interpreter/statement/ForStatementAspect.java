package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.statement.AStatementAspect;
import duc.uscript.execution.interpreter.statement.ForStatementAspectForStatementAspectProperties;
import duc.uscript.uScript.ForStatement;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = ForStatement.class)
@SuppressWarnings("all")
public class ForStatementAspect extends AStatementAspect {
  @OverrideAspectMethod
  public static void evaluateStatement(final ForStatement _self, final State state) {
    final duc.uscript.execution.interpreter.statement.ForStatementAspectForStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.ForStatementAspectForStatementAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.ForStatement){
    	duc.uscript.execution.interpreter.statement.ForStatementAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.ForStatement)_self,state);
    };
  }
  
  private static void super_evaluateStatement(final ForStatement _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectContext.getSelf(_self);
     duc.uscript.execution.interpreter.statement.AStatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final ForStatementAspectForStatementAspectProperties _self_, final ForStatement _self, final State state) {
    StateAspect.pushNewContext(state);
    {
      AStatementAspect.evaluateStatement(_self.getDeclaration(), state);
      Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getCondition(), state);
      boolean _isValue = ((BooleanValue) _evaluateExpression).isValue();
      boolean _while = _isValue;
      while (_while) {
        AStatementAspect.evaluateStatement(_self.getBlock(), state);
        AStatementAspect.evaluateStatement(_self.getProgression(), state);
        Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(_self.getCondition(), state);
        boolean _isValue_1 = ((BooleanValue) _evaluateExpression_1).isValue();
        _while = _isValue_1;
      }
    }
    StateAspect.popCurrentContext(state);
  }
}
