package duc.uscript.execution.interpreter.expression;

import duc.uscript.execution.ByteValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.FloatValue;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.LongValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.NegAspectImplNegAspectProperties;
import duc.uscript.uScript.Neg;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;

@Aspect(className = Neg.class)
@SuppressWarnings("all")
public class NegAspectImpl extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Neg _self, final State state) {
    final duc.uscript.execution.interpreter.expression.NegAspectImplNegAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NegAspectImplNegAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Neg){
    	result = duc.uscript.execution.interpreter.expression.NegAspectImpl._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Neg)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value super_evaluateExpression(final Neg _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NegAspectImplNegAspectProperties _self_, final Neg _self, final State state) {
    final Value res = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    boolean _matched = false;
    if (res instanceof LongValue) {
      _matched=true;
      long _value = ((LongValue)res).getValue();
      long _minus = (-_value);
      ((LongValue)res).setValue(_minus);
    }
    if (!_matched) {
      if (res instanceof IntegerValue) {
        _matched=true;
        int _value = ((IntegerValue)res).getValue();
        int _minus = (-_value);
        ((IntegerValue)res).setValue(_minus);
      }
    }
    if (!_matched) {
      if (res instanceof ByteValue) {
        _matched=true;
        byte _value = ((ByteValue)res).getValue();
        int _minus = (-_value);
        ((ByteValue)res).setValue(((byte) _minus));
      }
    }
    if (!_matched) {
      if (res instanceof DoubleValue) {
        _matched=true;
        double _value = ((DoubleValue)res).getValue();
        double _minus = (-_value);
        ((DoubleValue)res).setValue(_minus);
      }
    }
    if (!_matched) {
      if (res instanceof FloatValue) {
        _matched=true;
        float _value = ((FloatValue)res).getValue();
        float _minus = (-_value);
        ((FloatValue)res).setValue(_minus);
      }
    }
    if (!_matched) {
      throw new RuntimeException(("Not implemented for " + res));
    }
    return res;
  }
}
