package duc.uscript.execution.interpreter.expression.arithmetic;

import duc.uscript.execution.ByteValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FloatValue;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.LongValue;
import duc.uscript.execution.ShortValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties;
import duc.uscript.uScript.Multiplication;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Multiplication.class)
@SuppressWarnings("all")
public class MultiplicationAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Multiplication _self, final State state) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Multiplication)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Multiplication _self, final ByteValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(ByteValue,Value)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Multiplication)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Multiplication _self, final ShortValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(ShortValue,Value)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Multiplication)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Multiplication _self, final IntegerValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(IntegerValue,Value)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Multiplication)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Multiplication _self, final LongValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(LongValue,Value)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Multiplication)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Multiplication _self, final FloatValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(FloatValue,Value)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Multiplication)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Multiplication _self, final DoubleValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(DoubleValue,Value)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Multiplication)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static ByteValue p(final Multiplication _self, final ByteValue x, final ByteValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ByteValue p(ByteValue,ByteValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.ByteValue)result;
  }
  
  private static ShortValue p(final Multiplication _self, final ByteValue x, final ShortValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ShortValue p(ByteValue,ShortValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.ShortValue)result;
  }
  
  private static IntegerValue p(final Multiplication _self, final ByteValue x, final IntegerValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(ByteValue,IntegerValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Multiplication _self, final ByteValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(ByteValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Multiplication _self, final ByteValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(ByteValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Multiplication _self, final ByteValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(ByteValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static ShortValue p(final Multiplication _self, final ShortValue x, final ShortValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ShortValue p(ShortValue,ShortValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.ShortValue)result;
  }
  
  private static IntegerValue p(final Multiplication _self, final ShortValue x, final IntegerValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(ShortValue,IntegerValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Multiplication _self, final ShortValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(ShortValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Multiplication _self, final ShortValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(ShortValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Multiplication _self, final ShortValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(ShortValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static IntegerValue p(final Multiplication _self, final IntegerValue x, final IntegerValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(IntegerValue,IntegerValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Multiplication _self, final IntegerValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(IntegerValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Multiplication _self, final IntegerValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(IntegerValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Multiplication _self, final IntegerValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(IntegerValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static LongValue p(final Multiplication _self, final LongValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(LongValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Multiplication _self, final LongValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(LongValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Multiplication _self, final LongValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(LongValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static FloatValue p(final Multiplication _self, final FloatValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(FloatValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Multiplication _self, final FloatValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(FloatValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static DoubleValue p(final Multiplication _self, final DoubleValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspectMultiplicationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(DoubleValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Multiplication){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MultiplicationAspect._privk3_p(_self_, (duc.uscript.uScript.Multiplication)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static Value super_evaluateExpression(final Multiplication _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof ByteValue) {
      _matched=true;
      _switchResult = MultiplicationAspect.left_plus(_self, ((ByteValue)left), right);
    }
    if (!_matched) {
      if (left instanceof ShortValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.left_plus(_self, ((ShortValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof IntegerValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.left_plus(_self, ((IntegerValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof LongValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.left_plus(_self, ((LongValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof FloatValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.left_plus(_self, ((FloatValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof DoubleValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.left_plus(_self, ((DoubleValue)left), right);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ByteValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MultiplicationAspect.p(_self, left, ((ByteValue)right));
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((ShortValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((IntegerValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ShortValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MultiplicationAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((ShortValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((IntegerValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final IntegerValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MultiplicationAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((IntegerValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final LongValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MultiplicationAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((IntegerValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final FloatValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MultiplicationAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((IntegerValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((LongValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final DoubleValue left, final Value right) {
    DoubleValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MultiplicationAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((IntegerValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((LongValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, ((FloatValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MultiplicationAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    return _switchResult;
  }
  
  protected static ByteValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ByteValue x, final ByteValue y) {
    ByteValue _createByteValue = ExecutionFactory.eINSTANCE.createByteValue();
    final Procedure1<ByteValue> _function = (ByteValue it) -> {
      byte _value = x.getValue();
      byte _value_1 = y.getValue();
      int _multiply = (_value * _value_1);
      it.setValue(((byte) _multiply));
    };
    return ObjectExtensions.<ByteValue>operator_doubleArrow(_createByteValue, _function);
  }
  
  protected static ShortValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ByteValue x, final ShortValue y) {
    ShortValue _createShortValue = ExecutionFactory.eINSTANCE.createShortValue();
    final Procedure1<ShortValue> _function = (ShortValue it) -> {
      byte _value = x.getValue();
      short _value_1 = y.getValue();
      int _multiply = (_value * _value_1);
      it.setValue(((short) _multiply));
    };
    return ObjectExtensions.<ShortValue>operator_doubleArrow(_createShortValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ByteValue x, final IntegerValue y) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      byte _value = x.getValue();
      int _value_1 = y.getValue();
      int _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ByteValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      byte _value = x.getValue();
      long _value_1 = y.getValue();
      long _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ByteValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      byte _value = x.getValue();
      float _value_1 = y.getValue();
      float _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ByteValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      byte _value = x.getValue();
      double _value_1 = y.getValue();
      double _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static ShortValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ShortValue x, final ShortValue y) {
    ShortValue _createShortValue = ExecutionFactory.eINSTANCE.createShortValue();
    final Procedure1<ShortValue> _function = (ShortValue it) -> {
      short _value = x.getValue();
      short _value_1 = y.getValue();
      int _multiply = (_value * _value_1);
      it.setValue(((short) _multiply));
    };
    return ObjectExtensions.<ShortValue>operator_doubleArrow(_createShortValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ShortValue x, final IntegerValue y) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      short _value = x.getValue();
      int _value_1 = y.getValue();
      int _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ShortValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      short _value = x.getValue();
      long _value_1 = y.getValue();
      long _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ShortValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      short _value = x.getValue();
      float _value_1 = y.getValue();
      float _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final ShortValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      short _value = x.getValue();
      double _value_1 = y.getValue();
      double _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final IntegerValue x, final IntegerValue y) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      int _value = x.getValue();
      int _value_1 = y.getValue();
      int _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final IntegerValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      int _value = x.getValue();
      long _value_1 = y.getValue();
      long _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final IntegerValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      int _value = x.getValue();
      float _value_1 = y.getValue();
      float _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final IntegerValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      int _value = x.getValue();
      double _value_1 = y.getValue();
      double _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static LongValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final LongValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      long _value = x.getValue();
      long _value_1 = y.getValue();
      long _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final LongValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      long _value = x.getValue();
      float _value_1 = y.getValue();
      float _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final LongValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      long _value = x.getValue();
      double _value_1 = y.getValue();
      double _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final FloatValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      float _value = x.getValue();
      float _value_1 = y.getValue();
      float _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final FloatValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      float _value = x.getValue();
      double _value_1 = y.getValue();
      double _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MultiplicationAspectMultiplicationAspectProperties _self_, final Multiplication _self, final DoubleValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      double _value = x.getValue();
      double _value_1 = y.getValue();
      double _multiply = (_value * _value_1);
      it.setValue(_multiply);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
}
