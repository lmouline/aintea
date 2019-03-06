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
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.SymbolRefAspect
    		if (_self instanceof duc.uscript.uScript.SymbolRef){
    			result = duc.uscript.execution.interpreter.expression.SymbolRefAspect.evaluateExpression((duc.uscript.uScript.SymbolRef)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.SymbolRefAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspect
    		if (_self instanceof duc.uscript.uScript.Division){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspect.evaluateExpression((duc.uscript.uScript.Division)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect
    		if (_self instanceof duc.uscript.uScript.Minus){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect.evaluateExpression((duc.uscript.uScript.Minus)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect
    		if (_self instanceof duc.uscript.uScript.Multiplication){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect.evaluateExpression((duc.uscript.uScript.Multiplication)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect
    		if (_self instanceof duc.uscript.uScript.Plus){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect.evaluateExpression((duc.uscript.uScript.Plus)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect
    		if (_self instanceof duc.uscript.uScript.BoolConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect.evaluateExpression((duc.uscript.uScript.BoolConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect
    		if (_self instanceof duc.uscript.uScript.DoubleConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect.evaluateExpression((duc.uscript.uScript.DoubleConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.IntConstantAspect
    		if (_self instanceof duc.uscript.uScript.IntConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.IntConstantAspect.evaluateExpression((duc.uscript.uScript.IntConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.IntConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.LongConstantAspect
    		if (_self instanceof duc.uscript.uScript.LongConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.LongConstantAspect.evaluateExpression((duc.uscript.uScript.LongConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.LongConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.StringConstantAspect
    		if (_self instanceof duc.uscript.uScript.StringConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.StringConstantAspect.evaluateExpression((duc.uscript.uScript.StringConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.constants.StringConstantAspect
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
