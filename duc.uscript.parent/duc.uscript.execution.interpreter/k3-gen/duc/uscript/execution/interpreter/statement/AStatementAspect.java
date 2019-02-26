package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.State;
import duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties;
import duc.uscript.uScript.Statement;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = Statement.class)
@SuppressWarnings("all")
public class AStatementAspect {
  public static void evaluateStatement(final Statement _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectContext.getSelf(_self);
    	// BeginInjectInto duc.uscript.execution.interpreter.statement.AStatementAspect#void evaluateStatement(State) from duc.uscript.execution.interpreter.statement.AssigmentAspect
    		if (_self instanceof duc.uscript.uScript.Assignment){
    			duc.uscript.execution.interpreter.statement.AssigmentAspect.evaluateStatement((duc.uscript.uScript.Assignment)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.statement.AStatementAspect#void evaluateStatement(State) from duc.uscript.execution.interpreter.statement.AssigmentAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.statement.AStatementAspect#void evaluateStatement(State) from duc.uscript.execution.interpreter.statement.BlockAspect
    		if (_self instanceof duc.uscript.uScript.Block){
    			duc.uscript.execution.interpreter.statement.BlockAspect.evaluateStatement((duc.uscript.uScript.Block)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.statement.AStatementAspect#void evaluateStatement(State) from duc.uscript.execution.interpreter.statement.BlockAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.statement.AStatementAspect#void evaluateStatement(State) from duc.uscript.execution.interpreter.statement.PrintStatementAspect
    		if (_self instanceof duc.uscript.uScript.PrintStatement){
    			duc.uscript.execution.interpreter.statement.PrintStatementAspect.evaluateStatement((duc.uscript.uScript.PrintStatement)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.statement.AStatementAspect#void evaluateStatement(State) from duc.uscript.execution.interpreter.statement.PrintStatementAspect
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.Statement){
    	duc.uscript.execution.interpreter.statement.AStatementAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.Statement)_self,state);
    };
  }
  
  protected static void _privk3_evaluateStatement(final AStatementAspectStatementAspectProperties _self_, final Statement _self, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Evaluation is not defined for ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
}
