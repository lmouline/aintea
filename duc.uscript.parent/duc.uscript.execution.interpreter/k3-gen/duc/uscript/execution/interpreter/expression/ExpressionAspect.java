package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties;
import duc.uscript.uScript.Expression;
import duc.uscript.utils.Range;
import duc.uscript.utils.RangeFactory;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = Expression.class)
@SuppressWarnings("all")
public class ExpressionAspect {
  public static Value evaluateExpression(final Expression _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.MethodCall2Aspect
    		if (_self instanceof duc.uscript.uScript.MethodCall2){
    			result = duc.uscript.execution.interpreter.expression.MethodCall2Aspect.evaluateExpression((duc.uscript.uScript.MethodCall2)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.MethodCall2Aspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.NewUObjectAspect
    		if (_self instanceof duc.uscript.uScript.NewUObject){
    			result = duc.uscript.execution.interpreter.expression.NewUObjectAspect.evaluateExpression((duc.uscript.uScript.NewUObject)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.NewUObjectAspect
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
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.bool.AndAspect
    		if (_self instanceof duc.uscript.uScript.And){
    			result = duc.uscript.execution.interpreter.expression.bool.AndAspect.evaluateExpression((duc.uscript.uScript.And)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.bool.AndAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.bool.NotAspect
    		if (_self instanceof duc.uscript.uScript.Not){
    			result = duc.uscript.execution.interpreter.expression.bool.NotAspect.evaluateExpression((duc.uscript.uScript.Not)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.bool.NotAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.bool.OrAspect
    		if (_self instanceof duc.uscript.uScript.Or){
    			result = duc.uscript.execution.interpreter.expression.bool.OrAspect.evaluateExpression((duc.uscript.uScript.Or)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.bool.OrAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.comparison.InferiorAspect
    		if (_self instanceof duc.uscript.uScript.Inferior){
    			result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect.evaluateExpression((duc.uscript.uScript.Inferior)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.comparison.InferiorAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect
    		if (_self instanceof duc.uscript.uScript.Superior){
    			result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect.evaluateExpression((duc.uscript.uScript.Superior)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Value evaluateExpression(State) from duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect
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
  
  public static SymbolSet findDependentVariables(final Expression _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.MethodCall2Aspect
    		if (_self instanceof duc.uscript.uScript.MethodCall2){
    			result = duc.uscript.execution.interpreter.expression.MethodCall2Aspect.findDependentVariables((duc.uscript.uScript.MethodCall2)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.MethodCall2Aspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.NewUObjectAspect
    		if (_self instanceof duc.uscript.uScript.NewUObject){
    			result = duc.uscript.execution.interpreter.expression.NewUObjectAspect.findDependentVariables((duc.uscript.uScript.NewUObject)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.NewUObjectAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.SymbolRefAspect
    		if (_self instanceof duc.uscript.uScript.SymbolRef){
    			result = duc.uscript.execution.interpreter.expression.SymbolRefAspect.findDependentVariables((duc.uscript.uScript.SymbolRef)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.SymbolRefAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspect
    		if (_self instanceof duc.uscript.uScript.Division){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspect.findDependentVariables((duc.uscript.uScript.Division)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.DivisionAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect
    		if (_self instanceof duc.uscript.uScript.Minus){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect.findDependentVariables((duc.uscript.uScript.Minus)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect
    		if (_self instanceof duc.uscript.uScript.Multiplication){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect.findDependentVariables((duc.uscript.uScript.Multiplication)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect
    		if (_self instanceof duc.uscript.uScript.Plus){
    			result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect.findDependentVariables((duc.uscript.uScript.Plus)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.bool.AndAspect
    		if (_self instanceof duc.uscript.uScript.And){
    			result = duc.uscript.execution.interpreter.expression.bool.AndAspect.findDependentVariables((duc.uscript.uScript.And)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.bool.AndAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.bool.NotAspect
    		if (_self instanceof duc.uscript.uScript.Not){
    			result = duc.uscript.execution.interpreter.expression.bool.NotAspect.findDependentVariables((duc.uscript.uScript.Not)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.bool.NotAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.bool.OrAspect
    		if (_self instanceof duc.uscript.uScript.Or){
    			result = duc.uscript.execution.interpreter.expression.bool.OrAspect.findDependentVariables((duc.uscript.uScript.Or)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.bool.OrAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.comparison.InferiorAspect
    		if (_self instanceof duc.uscript.uScript.Inferior){
    			result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect.findDependentVariables((duc.uscript.uScript.Inferior)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.comparison.InferiorAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect
    		if (_self instanceof duc.uscript.uScript.Superior){
    			result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect.findDependentVariables((duc.uscript.uScript.Superior)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect
    		if (_self instanceof duc.uscript.uScript.BoolConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect.findDependentVariables((duc.uscript.uScript.BoolConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.BoolConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect
    		if (_self instanceof duc.uscript.uScript.DoubleConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect.findDependentVariables((duc.uscript.uScript.DoubleConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.DoubleConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.IntConstantAspect
    		if (_self instanceof duc.uscript.uScript.IntConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.IntConstantAspect.findDependentVariables((duc.uscript.uScript.IntConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.IntConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.LongConstantAspect
    		if (_self instanceof duc.uscript.uScript.LongConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.LongConstantAspect.findDependentVariables((duc.uscript.uScript.LongConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.LongConstantAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.StringConstantAspect
    		if (_self instanceof duc.uscript.uScript.StringConstant){
    			result = duc.uscript.execution.interpreter.expression.constants.StringConstantAspect.findDependentVariables((duc.uscript.uScript.StringConstant)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#SymbolSet findDependentVariables(State) from duc.uscript.execution.interpreter.expression.constants.StringConstantAspect
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.Expression){
    	result = duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.Expression)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  public static Range findRange(final Expression _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.NewUObjectAspect
    		if (_self instanceof duc.uscript.uScript.NewUObject){
    			result = duc.uscript.execution.interpreter.expression.NewUObjectAspect.findRange((duc.uscript.uScript.NewUObject)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.NewUObjectAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.SymbolRefAspect
    		if (_self instanceof duc.uscript.uScript.SymbolRef){
    			result = duc.uscript.execution.interpreter.expression.SymbolRefAspect.findRange((duc.uscript.uScript.SymbolRef)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.SymbolRefAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.comparison.InferiorAspect
    		if (_self instanceof duc.uscript.uScript.Inferior){
    			result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect.findRange((duc.uscript.uScript.Inferior)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.comparison.InferiorAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect
    		if (_self instanceof duc.uscript.uScript.Superior){
    			result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect.findRange((duc.uscript.uScript.Superior)_self,state);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.expression.ExpressionAspect#Range findRange(State) from duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect
    // #DispatchPointCut_before# Range findRange(State)
    if (_self instanceof duc.uscript.uScript.Expression){
    	result = duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findRange(_self_, (duc.uscript.uScript.Expression)_self,state);
    };
    return (duc.uscript.utils.Range)result;
  }
  
  protected static SymbolSet dependentVariables(final Expression _self) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet dependentVariables()
    if (_self instanceof duc.uscript.uScript.Expression){
    	result = duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_dependentVariables(_self_, (duc.uscript.uScript.Expression)_self);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  protected static void dependentVariables(final Expression _self, final SymbolSet dependentVariables) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void dependentVariables(SymbolSet)
    if (_self instanceof duc.uscript.uScript.Expression){
    	duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_dependentVariables(_self_, (duc.uscript.uScript.Expression)_self,dependentVariables);
    };
  }
  
  protected static Value _privk3_evaluateExpression(final ExpressionAspectExpressionAspectProperties _self_, final Expression _self, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("evaluateExpression should be overriden for type ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final ExpressionAspectExpressionAspectProperties _self_, final Expression _self, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("findDependentVariables should be overriden for type ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
  
  protected static Range _privk3_findRange(final ExpressionAspectExpressionAspectProperties _self_, final Expression _self, final State state) {
    return RangeFactory.createFullRange();
  }
  
  protected static SymbolSet _privk3_dependentVariables(final ExpressionAspectExpressionAspectProperties _self_, final Expression _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getDependentVariables") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (duc.uscript.utils.SymbolSet) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.dependentVariables;
  }
  
  protected static void _privk3_dependentVariables(final ExpressionAspectExpressionAspectProperties _self_, final Expression _self, final SymbolSet dependentVariables) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setDependentVariables")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, dependentVariables);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.dependentVariables = dependentVariables;
    }
  }
}
