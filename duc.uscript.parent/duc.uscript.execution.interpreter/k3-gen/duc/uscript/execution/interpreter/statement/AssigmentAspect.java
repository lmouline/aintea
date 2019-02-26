package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.Context;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.State;
import duc.uscript.execution.SymbolBindings;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.statement.AStatementAspect;
import duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectProperties;
import duc.uscript.uScript.Assignee;
import duc.uscript.uScript.Assignment;
import duc.uscript.uScript.Symbol;
import duc.uscript.uScript.VariableDeclaration;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Assignment.class)
@SuppressWarnings("all")
public class AssigmentAspect extends AStatementAspect {
  @OverrideAspectMethod
  public static void evaluateStatement(final Assignment _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.Assignment){
    	duc.uscript.execution.interpreter.statement.AssigmentAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.Assignment)_self,state);
    };
  }
  
  private static void super_evaluateStatement(final Assignment _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectContext.getSelf(_self);
     duc.uscript.execution.interpreter.statement.AStatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final AssigmentAspectAssignmentAspectProperties _self_, final Assignment _self, final State state) {
    try {
      final Context context = StateAspect.findCurrentContext(state);
      final Assignee assignee = _self.getAssignee();
      final Value right = ExpressionAspect.evaluateExpression(_self.getValue(), state);
      boolean _matched = false;
      if (assignee instanceof VariableDeclaration) {
        _matched=true;
        SymbolBindings _createSymbolBindings = ExecutionFactory.eINSTANCE.createSymbolBindings();
        final Procedure1<SymbolBindings> _function = (SymbolBindings it) -> {
          it.setSymbol(((Symbol)assignee));
          it.setValue(right);
        };
        final SymbolBindings binding = ObjectExtensions.<SymbolBindings>operator_doubleArrow(_createSymbolBindings, _function);
        context.getBindings().add(binding);
      }
      if (!_matched) {
        throw new Exception(("Cannot assign a value to " + assignee));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
