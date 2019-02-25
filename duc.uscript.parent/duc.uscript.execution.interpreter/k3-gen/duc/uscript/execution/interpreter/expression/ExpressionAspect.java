package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties;
import duc.uscript.uScript.Expression;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = Expression.class)
@SuppressWarnings("all")
public class ExpressionAspect {
  public static Value evaluateExpression(final Expression _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.BoolConstantAspect
    		if (_self instanceof duc.uscript.uScript.BoolConstant){
    			result = duc.uscript.execution.interpreter.expression.BoolConstantAspect.evaluateExpression((duc.uscript.uScript.BoolConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.BoolConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.DoubleConstantAspect
    		if (_self instanceof duc.uscript.uScript.DoubleConstant){
    			result = duc.uscript.execution.interpreter.expression.DoubleConstantAspect.evaluateExpression((duc.uscript.uScript.DoubleConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.DoubleConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.IntConstantAspect
    		if (_self instanceof duc.uscript.uScript.IntConstant){
    			result = duc.uscript.execution.interpreter.expression.IntConstantAspect.evaluateExpression((duc.uscript.uScript.IntConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.IntConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.LongConstantAspect
    		if (_self instanceof duc.uscript.uScript.LongConstant){
    			result = duc.uscript.execution.interpreter.expression.LongConstantAspect.evaluateExpression((duc.uscript.uScript.LongConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.LongConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.StringConstantAspect
    		if (_self instanceof duc.uscript.uScript.StringConstant){
    			result = duc.uscript.execution.interpreter.expression.StringConstantAspect.evaluateExpression((duc.uscript.uScript.StringConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.StringConstantAspect
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Expression){
    	result = duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Expression)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  protected static Value _privk3_evaluateExpression(final ExpressionAspectExpressionAspectProperties _self_, final Expression _self, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("evaluate should be overriden for type ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
}
