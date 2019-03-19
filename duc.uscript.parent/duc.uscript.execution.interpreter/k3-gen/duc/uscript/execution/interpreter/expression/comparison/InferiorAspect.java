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
import duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties;
import duc.uscript.uScript.DoubleConstant;
import duc.uscript.uScript.Expression;
import duc.uscript.uScript.Inferior;
import duc.uscript.uScript.IntConstant;
import duc.uscript.uScript.LongConstant;
import duc.uscript.utils.LongConstantUtils;
import duc.uscript.utils.Range;
import duc.uscript.utils.RangeFactory;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Inferior.class)
@SuppressWarnings("all")
public class InferiorAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Range findRange(final Inferior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Range findRange(State)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_findRange(_self_, (duc.uscript.uScript.Inferior)_self,state);
    };
    return (duc.uscript.utils.Range)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final Inferior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.Inferior)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final Inferior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Inferior)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Inferior _self, final ByteValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(ByteValue,Value)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Inferior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Inferior _self, final ShortValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(ShortValue,Value)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Inferior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Inferior _self, final IntegerValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(IntegerValue,Value)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Inferior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Inferior _self, final LongValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(LongValue,Value)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Inferior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Inferior _self, final FloatValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(FloatValue,Value)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Inferior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value rightDispatch(final Inferior _self, final DoubleValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value rightDispatch(DoubleValue,Value)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.Inferior)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ByteValue x, final ByteValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,ByteValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ByteValue x, final ShortValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,ShortValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ByteValue x, final IntegerValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ByteValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ByteValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ByteValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ByteValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ShortValue x, final ShortValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,ShortValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ShortValue x, final IntegerValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ShortValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ShortValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final ShortValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(ShortValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final IntegerValue x, final IntegerValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,IntegerValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final IntegerValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final IntegerValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final IntegerValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(IntegerValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final LongValue x, final LongValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(LongValue,LongValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final LongValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(LongValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final LongValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(LongValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final FloatValue x, final FloatValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(FloatValue,FloatValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final FloatValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(FloatValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static BooleanValue superior(final Inferior _self, final DoubleValue x, final DoubleValue y, final boolean inverse) {
    final duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectProperties _self_ = duc.uscript.execution.interpreter.expression.comparison.InferiorAspectInferiorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue superior(DoubleValue,DoubleValue,boolean)
    if (_self instanceof duc.uscript.uScript.Inferior){
    	result = duc.uscript.execution.interpreter.expression.comparison.InferiorAspect._privk3_superior(_self_, (duc.uscript.uScript.Inferior)_self,x,y,inverse);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static Range super_findRange(final Inferior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findRange(_self_, _self,state);
  }
  
  protected static Range _privk3_findRange(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final State state) {
    final Expression left = _self.getLeft();
    boolean _matched = false;
    if (left instanceof DoubleConstant) {
      _matched=true;
      return RangeFactory.createRangeWithLower(((DoubleConstant)left).getValue(), false);
    }
    if (!_matched) {
      if (left instanceof IntConstant) {
        _matched=true;
        return RangeFactory.createRangeWithLower(((IntConstant)left).getValue(), false);
      }
    }
    if (!_matched) {
      if (left instanceof LongConstant) {
        _matched=true;
        return RangeFactory.createRangeWithLower(LongConstantUtils.parseValue(((LongConstant)left)), false);
      }
    }
    final Expression right = _self.getRight();
    boolean _matched_1 = false;
    if (right instanceof DoubleConstant) {
      _matched_1=true;
      return RangeFactory.createRangeWithUpper(((DoubleConstant)right).getValue(), false);
    }
    if (!_matched_1) {
      if (right instanceof IntConstant) {
        _matched_1=true;
        return RangeFactory.createRangeWithUpper(((IntConstant)right).getValue(), false);
      }
    }
    if (!_matched_1) {
      if (right instanceof LongConstant) {
        _matched_1=true;
        return RangeFactory.createRangeWithUpper(LongConstantUtils.parseValue(((LongConstant)right)), false);
      }
    }
    return RangeFactory.createFullRange();
  }
  
  private static SymbolSet super_findDependentVariables(final Inferior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final State state) {
    final SymbolSet result = new SymbolSet();
    result.addAll(ExpressionAspect.findDependentVariables(_self.getLeft(), state));
    result.addAll(ExpressionAspect.findDependentVariables(_self.getRight(), state));
    return result;
  }
  
  private static Value super_evaluateExpression(final Inferior _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof ByteValue) {
      _matched=true;
      _switchResult = InferiorAspect.rightDispatch(_self, ((ByteValue)left), right);
    }
    if (!_matched) {
      if (left instanceof ShortValue) {
        _matched=true;
        _switchResult = InferiorAspect.rightDispatch(_self, ((ShortValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof IntegerValue) {
        _matched=true;
        _switchResult = InferiorAspect.rightDispatch(_self, ((IntegerValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof LongValue) {
        _matched=true;
        _switchResult = InferiorAspect.rightDispatch(_self, ((LongValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof FloatValue) {
        _matched=true;
        _switchResult = InferiorAspect.rightDispatch(_self, ((FloatValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof DoubleValue) {
        _matched=true;
        _switchResult = InferiorAspect.rightDispatch(_self, ((DoubleValue)left), right);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ByteValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = InferiorAspect.superior(_self, left, ((ByteValue)right), false);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((ShortValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((IntegerValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ShortValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = InferiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((ShortValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((IntegerValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final IntegerValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = InferiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((IntegerValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final LongValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = InferiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((IntegerValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((LongValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final FloatValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = InferiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((IntegerValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((LongValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((FloatValue)right), false);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_rightDispatch(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final DoubleValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = InferiorAspect.superior(_self, ((ByteValue)right), left, true);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((ShortValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((IntegerValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((LongValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, ((FloatValue)right), left, true);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = InferiorAspect.superior(_self, left, ((DoubleValue)right), false);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ByteValue x, final ByteValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        byte _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        byte _value_2 = x.getValue();
        byte _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ByteValue x, final ShortValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        short _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        byte _value_2 = x.getValue();
        short _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ByteValue x, final IntegerValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        int _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        byte _value_2 = x.getValue();
        int _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ByteValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        byte _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ByteValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        byte _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ByteValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        byte _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        byte _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ShortValue x, final ShortValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        short _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        short _value_2 = x.getValue();
        short _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ShortValue x, final IntegerValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        int _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        short _value_2 = x.getValue();
        int _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ShortValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        short _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ShortValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        short _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final ShortValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        short _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        short _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final IntegerValue x, final IntegerValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        int _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        int _value_2 = x.getValue();
        int _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final IntegerValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        int _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final IntegerValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        int _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final IntegerValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        int _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        int _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final LongValue x, final LongValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        long _value = y.getValue();
        long _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        long _value_2 = x.getValue();
        long _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final LongValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        long _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        long _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final LongValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        long _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        long _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final FloatValue x, final FloatValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        float _value = y.getValue();
        float _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        float _value_2 = x.getValue();
        float _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final FloatValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        float _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        float _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static BooleanValue _privk3_superior(final InferiorAspectInferiorAspectProperties _self_, final Inferior _self, final DoubleValue x, final DoubleValue y, final boolean inverse) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      if (inverse) {
        double _value = y.getValue();
        double _value_1 = x.getValue();
        boolean _lessThan = (_value < _value_1);
        it.setValue(_lessThan);
      } else {
        double _value_2 = x.getValue();
        double _value_3 = y.getValue();
        boolean _lessThan_1 = (_value_2 < _value_3);
        it.setValue(_lessThan_1);
      }
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
