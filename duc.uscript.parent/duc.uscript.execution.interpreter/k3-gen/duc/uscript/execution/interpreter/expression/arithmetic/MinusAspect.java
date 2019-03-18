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
import duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties;
import duc.uscript.execution.interpreter.utils.SymbolSet;
import duc.uscript.uScript.Minus;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Minus.class)
@SuppressWarnings("all")
public class MinusAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Minus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Minus)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Minus _self, final ByteValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(ByteValue,Value)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Minus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Minus _self, final ShortValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(ShortValue,Value)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Minus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Minus _self, final IntegerValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(IntegerValue,Value)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Minus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Minus _self, final LongValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(LongValue,Value)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Minus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Minus _self, final FloatValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(FloatValue,Value)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Minus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Minus _self, final DoubleValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(DoubleValue,Value)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Minus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static ByteValue p(final Minus _self, final ByteValue x, final ByteValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ByteValue p(ByteValue,ByteValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.ByteValue)result;
  }
  
  private static ShortValue p(final Minus _self, final ByteValue x, final ShortValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ShortValue p(ByteValue,ShortValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.ShortValue)result;
  }
  
  private static IntegerValue p(final Minus _self, final ByteValue x, final IntegerValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(ByteValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Minus _self, final ByteValue x, final LongValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(ByteValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Minus _self, final ByteValue x, final FloatValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(ByteValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Minus _self, final ByteValue x, final DoubleValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(ByteValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static ShortValue p(final Minus _self, final ShortValue x, final ShortValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ShortValue p(ShortValue,ShortValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.ShortValue)result;
  }
  
  private static IntegerValue p(final Minus _self, final ShortValue x, final IntegerValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(ShortValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Minus _self, final ShortValue x, final LongValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(ShortValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Minus _self, final ShortValue x, final FloatValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(ShortValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Minus _self, final ShortValue x, final DoubleValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(ShortValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static IntegerValue p(final Minus _self, final IntegerValue x, final IntegerValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(IntegerValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Minus _self, final IntegerValue x, final LongValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(IntegerValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Minus _self, final IntegerValue x, final FloatValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(IntegerValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Minus _self, final IntegerValue x, final DoubleValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(IntegerValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static LongValue p(final Minus _self, final LongValue x, final LongValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(LongValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Minus _self, final LongValue x, final FloatValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(LongValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Minus _self, final LongValue x, final DoubleValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(LongValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static FloatValue p(final Minus _self, final FloatValue x, final FloatValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(FloatValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Minus _self, final FloatValue x, final DoubleValue y, final boolean normal) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(FloatValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y,normal);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static DoubleValue p(final Minus _self, final DoubleValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(DoubleValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_p(_self_, (duc.uscript.uScript.Minus)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final Minus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspectMinusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.Minus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.MinusAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.Minus)_self,state);
    };
    return (duc.uscript.execution.interpreter.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final Minus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final MinusAspectMinusAspectProperties _self_, final Minus _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof ByteValue) {
      _matched=true;
      _switchResult = MinusAspect.left_plus(_self, ((ByteValue)left), right);
    }
    if (!_matched) {
      if (left instanceof ShortValue) {
        _matched=true;
        _switchResult = MinusAspect.left_plus(_self, ((ShortValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof IntegerValue) {
        _matched=true;
        _switchResult = MinusAspect.left_plus(_self, ((IntegerValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof LongValue) {
        _matched=true;
        _switchResult = MinusAspect.left_plus(_self, ((LongValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof FloatValue) {
        _matched=true;
        _switchResult = MinusAspect.left_plus(_self, ((FloatValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof DoubleValue) {
        _matched=true;
        _switchResult = MinusAspect.left_plus(_self, ((DoubleValue)left), right);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ByteValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MinusAspect.p(_self, left, ((ByteValue)right), true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((ShortValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((IntegerValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((LongValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((FloatValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((DoubleValue)right), true);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ShortValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MinusAspect.p(_self, ((ByteValue)right), left, false);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((ShortValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((IntegerValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((LongValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((FloatValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((DoubleValue)right), true);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MinusAspectMinusAspectProperties _self_, final Minus _self, final IntegerValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MinusAspect.p(_self, ((ByteValue)right), left, false);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((ShortValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((IntegerValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((LongValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((FloatValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((DoubleValue)right), true);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MinusAspectMinusAspectProperties _self_, final Minus _self, final LongValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MinusAspect.p(_self, ((ByteValue)right), left, false);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((ShortValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((IntegerValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((LongValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((FloatValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((DoubleValue)right), true);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MinusAspectMinusAspectProperties _self_, final Minus _self, final FloatValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MinusAspect.p(_self, ((ByteValue)right), left, false);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((ShortValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((IntegerValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((LongValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((FloatValue)right), true);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((DoubleValue)right), true);
      }
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final MinusAspectMinusAspectProperties _self_, final Minus _self, final DoubleValue left, final Value right) {
    DoubleValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = MinusAspect.p(_self, ((ByteValue)right), left, false);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((ShortValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((IntegerValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((LongValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, ((FloatValue)right), left, false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = MinusAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    return _switchResult;
  }
  
  protected static ByteValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ByteValue x, final ByteValue y, final boolean normal) {
    ByteValue _createByteValue = ExecutionFactory.eINSTANCE.createByteValue();
    final Procedure1<ByteValue> _function = (ByteValue it) -> {
      if (normal) {
        byte _value = x.getValue();
        byte _value_1 = y.getValue();
        int _minus = (_value - _value_1);
        it.setValue(((byte) _minus));
      } else {
        byte _value_2 = y.getValue();
        byte _value_3 = x.getValue();
        int _minus_1 = (_value_2 - _value_3);
        it.setValue(((byte) _minus_1));
      }
    };
    return ObjectExtensions.<ByteValue>operator_doubleArrow(_createByteValue, _function);
  }
  
  protected static ShortValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ByteValue x, final ShortValue y, final boolean normal) {
    ShortValue _createShortValue = ExecutionFactory.eINSTANCE.createShortValue();
    final Procedure1<ShortValue> _function = (ShortValue it) -> {
      if (normal) {
        byte _value = x.getValue();
        short _value_1 = y.getValue();
        int _minus = (_value - _value_1);
        it.setValue(((short) _minus));
      } else {
        short _value_2 = y.getValue();
        byte _value_3 = x.getValue();
        int _minus_1 = (_value_2 - _value_3);
        it.setValue(((short) _minus_1));
      }
    };
    return ObjectExtensions.<ShortValue>operator_doubleArrow(_createShortValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ByteValue x, final IntegerValue y, final boolean normal) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      if (normal) {
        byte _value = x.getValue();
        int _value_1 = y.getValue();
        int _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        int _value_2 = y.getValue();
        byte _value_3 = x.getValue();
        int _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ByteValue x, final LongValue y, final boolean normal) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      if (normal) {
        byte _value = x.getValue();
        long _value_1 = y.getValue();
        long _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        long _value_2 = y.getValue();
        byte _value_3 = x.getValue();
        long _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ByteValue x, final FloatValue y, final boolean normal) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      if (normal) {
        byte _value = x.getValue();
        float _value_1 = y.getValue();
        float _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        float _value_2 = y.getValue();
        byte _value_3 = x.getValue();
        float _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ByteValue x, final DoubleValue y, final boolean normal) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      if (normal) {
        byte _value = x.getValue();
        double _value_1 = y.getValue();
        double _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        double _value_2 = y.getValue();
        byte _value_3 = x.getValue();
        double _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static ShortValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ShortValue x, final ShortValue y, final boolean normal) {
    ShortValue _createShortValue = ExecutionFactory.eINSTANCE.createShortValue();
    final Procedure1<ShortValue> _function = (ShortValue it) -> {
      short _value = x.getValue();
      short _value_1 = y.getValue();
      int _minus = (_value - _value_1);
      it.setValue(((short) _minus));
    };
    return ObjectExtensions.<ShortValue>operator_doubleArrow(_createShortValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ShortValue x, final IntegerValue y, final boolean normal) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      if (normal) {
        short _value = x.getValue();
        int _value_1 = y.getValue();
        int _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        int _value_2 = y.getValue();
        short _value_3 = x.getValue();
        int _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ShortValue x, final LongValue y, final boolean normal) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      if (normal) {
        short _value = x.getValue();
        long _value_1 = y.getValue();
        long _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        long _value_2 = y.getValue();
        short _value_3 = x.getValue();
        long _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ShortValue x, final FloatValue y, final boolean normal) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      if (normal) {
        short _value = x.getValue();
        float _value_1 = y.getValue();
        float _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        float _value_2 = y.getValue();
        short _value_3 = x.getValue();
        float _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final ShortValue x, final DoubleValue y, final boolean normal) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      if (normal) {
        short _value = x.getValue();
        double _value_1 = y.getValue();
        double _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        double _value_2 = y.getValue();
        short _value_3 = x.getValue();
        double _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final IntegerValue x, final IntegerValue y, final boolean normal) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      if (normal) {
        int _value = x.getValue();
        int _value_1 = y.getValue();
        int _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        int _value_2 = y.getValue();
        int _value_3 = x.getValue();
        int _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final IntegerValue x, final LongValue y, final boolean normal) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      if (normal) {
        int _value = x.getValue();
        long _value_1 = y.getValue();
        long _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        long _value_2 = y.getValue();
        int _value_3 = x.getValue();
        long _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final IntegerValue x, final FloatValue y, final boolean normal) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      if (normal) {
        int _value = x.getValue();
        float _value_1 = y.getValue();
        float _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        float _value_2 = y.getValue();
        int _value_3 = x.getValue();
        float _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final IntegerValue x, final DoubleValue y, final boolean normal) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      if (normal) {
        int _value = x.getValue();
        double _value_1 = y.getValue();
        double _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        double _value_2 = y.getValue();
        int _value_3 = x.getValue();
        double _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static LongValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final LongValue x, final LongValue y, final boolean normal) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      if (normal) {
        long _value = x.getValue();
        long _value_1 = y.getValue();
        long _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        long _value_2 = y.getValue();
        long _value_3 = x.getValue();
        long _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final LongValue x, final FloatValue y, final boolean normal) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      if (normal) {
        long _value = x.getValue();
        float _value_1 = y.getValue();
        float _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        float _value_2 = y.getValue();
        long _value_3 = x.getValue();
        float _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final LongValue x, final DoubleValue y, final boolean normal) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      if (normal) {
        long _value = x.getValue();
        double _value_1 = y.getValue();
        double _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        double _value_2 = y.getValue();
        long _value_3 = x.getValue();
        double _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static FloatValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final FloatValue x, final FloatValue y, final boolean normal) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      if (normal) {
        float _value = x.getValue();
        float _value_1 = y.getValue();
        float _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        float _value_2 = y.getValue();
        float _value_3 = x.getValue();
        float _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final FloatValue x, final DoubleValue y, final boolean normal) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      if (normal) {
        float _value = x.getValue();
        double _value_1 = y.getValue();
        double _minus = (_value - _value_1);
        it.setValue(_minus);
      } else {
        double _value_2 = y.getValue();
        float _value_3 = x.getValue();
        double _minus_1 = (_value_2 - _value_3);
        it.setValue(_minus_1);
      }
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final MinusAspectMinusAspectProperties _self_, final Minus _self, final DoubleValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      double _value = x.getValue();
      double _value_1 = y.getValue();
      double _minus = (_value - _value_1);
      it.setValue(_minus);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  private static SymbolSet super_findDependentVariables(final Minus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final MinusAspectMinusAspectProperties _self_, final Minus _self, final State state) {
    final SymbolSet result = new SymbolSet();
    result.addAll(ExpressionAspect.findDependentVariables(_self.getLeft(), state));
    result.addAll(ExpressionAspect.findDependentVariables(_self.getRight(), state));
    return result;
  }
}
