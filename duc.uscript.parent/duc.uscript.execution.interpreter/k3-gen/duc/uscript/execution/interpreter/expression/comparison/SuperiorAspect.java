package duc.uscript.execution.interpreter.expression.comparison;

import duc.uscript.execution.BooleanValue;
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
import duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties;
import duc.uscript.execution.interpreter.utils.SymbolSet;
import duc.uscript.uScript.Superior;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Superior.class)
@SuppressWarnings("all")
public class SuperiorAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final Superior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.Superior)_self,state);
    };
    return (duc.uscript.execution.interpreter.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final Superior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Superior)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Superior _self, final ByteValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(ByteValue,Value)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Superior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Superior _self, final ShortValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(ShortValue,Value)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Superior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Superior _self, final IntegerValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(IntegerValue,Value)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Superior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Superior _self, final LongValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(LongValue,Value)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Superior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Superior _self, final FloatValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(FloatValue,Value)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Superior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Superior _self, final DoubleValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(DoubleValue,Value)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Superior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ByteValue x, final ByteValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,ByteValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ByteValue x, final ShortValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,ShortValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ByteValue x, final IntegerValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ByteValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ByteValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ByteValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ShortValue x, final ShortValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,ShortValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ShortValue x, final IntegerValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ShortValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ShortValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final ShortValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final IntegerValue x, final IntegerValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final IntegerValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final IntegerValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final IntegerValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final LongValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(LongValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final LongValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(LongValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final LongValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(LongValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final FloatValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(FloatValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final FloatValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(FloatValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Superior _self, final DoubleValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspectSuperiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(DoubleValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Superior){
    	result = duc.uscript.execution.interpreter.expression.comparison.SuperiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Superior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static SymbolSet super_findDependentVariables(final Superior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final State state) {
    final SymbolSet result = new SymbolSet();
    result.addAll(ExpressionAspect.findDependentVariables(_self.getLeft(), state));
    result.addAll(ExpressionAspect.findDependentVariables(_self.getRight(), state));
    return result;
  }
  
  private static Value super_evaluateExpression(final Superior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof ByteValue) {
      _matched=true;
      _switchResult = SuperiorAspect.rightDispatch(_self, ((ByteValue)left), right);
    }
    if (!_matched) {
      if (left instanceof ShortValue) {
        _matched=true;
        _switchResult = SuperiorAspect.rightDispatch(_self, ((ShortValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof IntegerValue) {
        _matched=true;
        _switchResult = SuperiorAspect.rightDispatch(_self, ((IntegerValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof LongValue) {
        _matched=true;
        _switchResult = SuperiorAspect.rightDispatch(_self, ((LongValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof FloatValue) {
        _matched=true;
        _switchResult = SuperiorAspect.rightDispatch(_self, ((FloatValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof DoubleValue) {
        _matched=true;
        _switchResult = SuperiorAspect.rightDispatch(_self, ((DoubleValue)left), right);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ByteValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = SuperiorAspect.superior(_self, left, ((ByteValue)right), false);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((ShortValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((IntegerValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ShortValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = SuperiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((ShortValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((IntegerValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final IntegerValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = SuperiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((IntegerValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final LongValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = SuperiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((IntegerValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final FloatValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = SuperiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((IntegerValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((LongValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final DoubleValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = SuperiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((IntegerValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((LongValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, ((FloatValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = SuperiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ByteValue x, final ByteValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        byte _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        byte _value_2 = x.getValue();
        byte _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ByteValue x, final ShortValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        short _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        byte _value_2 = x.getValue();
        short _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ByteValue x, final IntegerValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        int _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        byte _value_2 = x.getValue();
        int _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ByteValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        byte _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ByteValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        byte _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ByteValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        byte _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ShortValue x, final ShortValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        short _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        short _value_2 = x.getValue();
        short _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ShortValue x, final IntegerValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        int _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        short _value_2 = x.getValue();
        int _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ShortValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        short _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ShortValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        short _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final ShortValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        short _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final IntegerValue x, final IntegerValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        int _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        int _value_2 = x.getValue();
        int _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final IntegerValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        int _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final IntegerValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        int _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final IntegerValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        int _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final LongValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        long _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        long _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final LongValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        long _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        long _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final LongValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        long _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        long _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final FloatValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        float _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        float _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final FloatValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        float _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        float _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final SuperiorAspectSuperiorAspectProperties _self_, final Superior _self, final DoubleValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        double _value_1 = x.getValue();
        boolean _greaterThan = (_value > _value_1);
        it.setValue(_greaterThan);
      } else {
        double _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _greaterThan_1 = (_value_2 > _value_3);
        it.setValue(_greaterThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
