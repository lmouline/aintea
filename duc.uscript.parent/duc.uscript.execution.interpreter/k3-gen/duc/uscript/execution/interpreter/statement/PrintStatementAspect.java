package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.statement.AStatementAspect;
import duc.uscript.execution.interpreter.statement.PrintStatementAspectPrintStatementAspectProperties;
import duc.uscript.uScript.PrintStatement;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = PrintStatement.class)
@SuppressWarnings("all")
public class PrintStatementAspect extends AStatementAspect {
  @OverrideAspectMethod
  public static void evaluateStatement(final PrintStatement _self, final State state) {
    final duc.uscript.execution.interpreter.statement.PrintStatementAspectPrintStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.PrintStatementAspectPrintStatementAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.PrintStatement){
    	duc.uscript.execution.interpreter.statement.PrintStatementAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.PrintStatement)_self,state);
    };
  }
  
  private static void super_evaluateStatement(final PrintStatement _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectContext.getSelf(_self);
     duc.uscript.execution.interpreter.statement.AStatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final PrintStatementAspectPrintStatementAspectProperties _self_, final PrintStatement _self, final State state) {
    final Value expression = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    final String string = ValueAspect.convertToString(expression);
    StateAspect.print(state, string);
  }
}
