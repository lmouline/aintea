package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.Frame;
import duc.uscript.execution.State;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.statement.AStatementAspect;
import duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectProperties;
import duc.uscript.uScript.Block;
import duc.uscript.uScript.Statement;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import java.util.Iterator;

@Aspect(className = Block.class)
@SuppressWarnings("all")
public class BlockAspect extends AStatementAspect {
  public static void evaluateStatementKeepContext(final Block _self, final State state) {
    final duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectProperties _self_ = duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatementKeepContext(State)
    if (_self instanceof duc.uscript.uScript.Block){
    	duc.uscript.execution.interpreter.statement.BlockAspect._privk3_evaluateStatementKeepContext(_self_, (duc.uscript.uScript.Block)_self,state);
    };
  }
  
  @OverrideAspectMethod
  public static void evaluateStatement(final Block _self, final State state) {
    final duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectProperties _self_ = duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.Block){
    	duc.uscript.execution.interpreter.statement.BlockAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.Block)_self,state);
    };
  }
  
  protected static void _privk3_evaluateStatementKeepContext(final BlockAspectBlockAspectProperties _self_, final Block _self, final State state) {
    StateAspect.pushNewContext(state);
    final Frame currentFrame = StateAspect.findCurrentFrame(state);
    Iterator<Statement> i = _self.getStatements().iterator();
    while ((i.hasNext() && (currentFrame.getValue() == null))) {
      AStatementAspect.evaluateStatement(i.next(), state);
    }
  }
  
  private static void super_evaluateStatement(final Block _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectContext.getSelf(_self);
     duc.uscript.execution.interpreter.statement.AStatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final BlockAspectBlockAspectProperties _self_, final Block _self, final State state) {
    BlockAspect.evaluateStatementKeepContext(_self, state);
    StateAspect.popCurrentContext(state);
  }
}
