package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.statement.AStatementAspect;
import duc.uscript.execution.interpreter.statement.BlockAspect;
import duc.uscript.execution.interpreter.statement.IfStatementAspectIfStatementAspectProperties;
import duc.uscript.uScript.Block;
import duc.uscript.uScript.IfStatement;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;

@Aspect(className = IfStatement.class)
@SuppressWarnings("all")
public class IfStatementAspect extends AStatementAspect {
  public static void evaluateStatement(final IfStatement _self, final State state) {
    final duc.uscript.execution.interpreter.statement.IfStatementAspectIfStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.IfStatementAspectIfStatementAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.IfStatement){
    	duc.uscript.execution.interpreter.statement.IfStatementAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.IfStatement)_self,state);
    };
  }
  
  protected static void _privk3_evaluateStatement(final IfStatementAspectIfStatementAspectProperties _self_, final IfStatement _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getCondition(), state);
    final BooleanValue condition = ((BooleanValue) _evaluateExpression);
    boolean _isValue = condition.isValue();
    if (_isValue) {
      Block _thenBlock = _self.getThenBlock();
      if (_thenBlock!=null) {
        BlockAspect.evaluateStatement(_thenBlock, state);
      }
    } else {
      Block _elseBlock = _self.getElseBlock();
      if (_elseBlock!=null) {
        BlockAspect.evaluateStatement(_elseBlock, state);
      }
    }
  }
}
