package duc.uscript.execution.interpreter.expression.arithmetic;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import duc.aintea.lib.poissonbinomial.Computer;
import duc.uscript.UScriptStandaloneSetupGenerated;
import duc.uscript.execution.ArrayInstance;
import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.ByteValue;
import duc.uscript.execution.CharValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.FloatValue;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.LongValue;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.ShortValue;
import duc.uscript.execution.State;
import duc.uscript.execution.StringValue;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.utils.GaussianDoubleUtils;
import duc.uscript.execution.interpreter.utils.MultPossibilityUtils;
import duc.uscript.typing.InternalTypeDcl;
import duc.uscript.typing.TypeConcordance;
import duc.uscript.uScript.Field;
import duc.uscript.uScript.Plus;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Plus.class)
@SuppressWarnings("all")
public class PlusAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Plus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Plus)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final ByteValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(ByteValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final ShortValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(ShortValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final IntegerValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(IntegerValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final LongValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(LongValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final FloatValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(FloatValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final DoubleValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(DoubleValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final BooleanValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(BooleanValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value left_plus(final Plus _self, final State state, final ObjectRefValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value left_plus(State,ObjectRefValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_left_plus(_self_, (duc.uscript.uScript.Plus)_self,state,left,right);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static StringValue p(final Plus _self, final StringValue x, final Value y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# StringValue p(StringValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.StringValue)result;
  }
  
  private static StringValue p(final Plus _self, final Value x, final StringValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# StringValue p(Value,StringValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.StringValue)result;
  }
  
  private static StringValue p(final Plus _self, final CharValue x, final Value y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# StringValue p(CharValue,Value)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.StringValue)result;
  }
  
  private static StringValue p(final Plus _self, final Value x, final CharValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# StringValue p(Value,CharValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.StringValue)result;
  }
  
  private static StringValue p(final Plus _self, final BooleanValue x, final StringValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# StringValue p(BooleanValue,StringValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.StringValue)result;
  }
  
  private static ByteValue p(final Plus _self, final ByteValue x, final ByteValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ByteValue p(ByteValue,ByteValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.ByteValue)result;
  }
  
  private static ShortValue p(final Plus _self, final ByteValue x, final ShortValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ShortValue p(ByteValue,ShortValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.ShortValue)result;
  }
  
  private static IntegerValue p(final Plus _self, final ByteValue x, final IntegerValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(ByteValue,IntegerValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Plus _self, final ByteValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(ByteValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Plus _self, final ByteValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(ByteValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Plus _self, final ByteValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(ByteValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static ShortValue p(final Plus _self, final ShortValue x, final ShortValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ShortValue p(ShortValue,ShortValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.ShortValue)result;
  }
  
  private static IntegerValue p(final Plus _self, final ShortValue x, final IntegerValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(ShortValue,IntegerValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Plus _self, final ShortValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(ShortValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Plus _self, final ShortValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(ShortValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Plus _self, final ShortValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(ShortValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static IntegerValue p(final Plus _self, final IntegerValue x, final IntegerValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# IntegerValue p(IntegerValue,IntegerValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.IntegerValue)result;
  }
  
  private static LongValue p(final Plus _self, final IntegerValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(IntegerValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Plus _self, final IntegerValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(IntegerValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Plus _self, final IntegerValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(IntegerValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static LongValue p(final Plus _self, final LongValue x, final LongValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# LongValue p(LongValue,LongValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.LongValue)result;
  }
  
  private static FloatValue p(final Plus _self, final LongValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(LongValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Plus _self, final LongValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(LongValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static FloatValue p(final Plus _self, final FloatValue x, final FloatValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# FloatValue p(FloatValue,FloatValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.FloatValue)result;
  }
  
  private static DoubleValue p(final Plus _self, final FloatValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(FloatValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static DoubleValue p(final Plus _self, final DoubleValue x, final DoubleValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# DoubleValue p(DoubleValue,DoubleValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,x,y);
    };
    return (duc.uscript.execution.DoubleValue)result;
  }
  
  private static ObjectRefValue p(final Plus _self, final State state, final ObjectRefValue x, final ObjectRefValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue p(State,ObjectRefValue,ObjectRefValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_p(_self_, (duc.uscript.uScript.Plus)_self,state,x,y);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue plusGauss(final Plus _self, final State state, final ObjectRefValue x, final ObjectRefValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue plusGauss(State,ObjectRefValue,ObjectRefValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_plusGauss(_self_, (duc.uscript.uScript.Plus)_self,state,x,y);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static ObjectRefValue plusMultPoss(final Plus _self, final State state, final ObjectRefValue x, final ObjectRefValue y) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue plusMultPoss(State,ObjectRefValue,ObjectRefValue)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_plusMultPoss(_self_, (duc.uscript.uScript.Plus)_self,state,x,y);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final Plus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectProperties _self_ = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspectPlusAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.Plus){
    	result = duc.uscript.execution.interpreter.expression.arithmetic.PlusAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.Plus)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final Plus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final PlusAspectPlusAspectProperties _self_, final Plus _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof ByteValue) {
      _matched=true;
      _switchResult = PlusAspect.left_plus(_self, ((ByteValue)left), right);
    }
    if (!_matched) {
      if (left instanceof ShortValue) {
        _matched=true;
        _switchResult = PlusAspect.left_plus(_self, ((ShortValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof IntegerValue) {
        _matched=true;
        _switchResult = PlusAspect.left_plus(_self, ((IntegerValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof LongValue) {
        _matched=true;
        _switchResult = PlusAspect.left_plus(_self, ((LongValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof FloatValue) {
        _matched=true;
        _switchResult = PlusAspect.left_plus(_self, ((FloatValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof DoubleValue) {
        _matched=true;
        _switchResult = PlusAspect.left_plus(_self, ((DoubleValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof CharValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((CharValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof BooleanValue) {
        _matched=true;
        _switchResult = PlusAspect.left_plus(_self, ((BooleanValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof StringValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((StringValue)left), right);
      }
    }
    if (!_matched) {
      if (left instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = PlusAspect.left_plus(_self, state, ((ObjectRefValue)left), right);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ByteValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, left, ((ByteValue)right));
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((ShortValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((IntegerValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof CharValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((CharValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof StringValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((StringValue)right));
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ShortValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((ShortValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((IntegerValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof CharValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((CharValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof StringValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((StringValue)right));
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final IntegerValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((IntegerValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof CharValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((CharValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof StringValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((StringValue)right));
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final LongValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((IntegerValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((LongValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof CharValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((CharValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof StringValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((StringValue)right));
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final FloatValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((IntegerValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((LongValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((FloatValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof CharValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((CharValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof StringValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((StringValue)right));
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final DoubleValue left, final Value right) {
    Value _switchResult = null;
    boolean _matched = false;
    if (right instanceof ByteValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, ((ByteValue)right), left);
    }
    if (!_matched) {
      if (right instanceof ShortValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((ShortValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof IntegerValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((IntegerValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof LongValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((LongValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof FloatValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, ((FloatValue)right), left);
      }
    }
    if (!_matched) {
      if (right instanceof DoubleValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((DoubleValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof CharValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((CharValue)right));
      }
    }
    if (!_matched) {
      if (right instanceof StringValue) {
        _matched=true;
        _switchResult = PlusAspect.p(_self, left, ((StringValue)right));
      }
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final BooleanValue left, final Value right) {
    StringValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof StringValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, left, ((StringValue)right));
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_left_plus(final PlusAspectPlusAspectProperties _self_, final Plus _self, final State state, final ObjectRefValue left, final Value right) {
    ObjectRefValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ObjectRefValue) {
      _matched=true;
      _switchResult = PlusAspect.p(_self, state, left, ((ObjectRefValue)right));
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Add operator not implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static StringValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final StringValue x, final Value y) {
    StringValue _createStringValue = ExecutionFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      String _value = x.getValue();
      String _convertToString = ValueAspect.convertToString(y);
      String _plus = (_value + _convertToString);
      it.setValue(_plus);
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
  
  protected static StringValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final Value x, final StringValue y) {
    StringValue _createStringValue = ExecutionFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      String _convertToString = ValueAspect.convertToString(x);
      String _value = y.getValue();
      String _plus = (_convertToString + _value);
      it.setValue(_plus);
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
  
  protected static StringValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final CharValue x, final Value y) {
    StringValue _createStringValue = ExecutionFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      String _value = x.getValue();
      String _convertToString = ValueAspect.convertToString(y);
      String _plus = (_value + _convertToString);
      it.setValue(_plus);
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
  
  protected static StringValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final Value x, final CharValue y) {
    StringValue _createStringValue = ExecutionFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      String _convertToString = ValueAspect.convertToString(x);
      String _value = y.getValue();
      String _plus = (_convertToString + _value);
      it.setValue(_plus);
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
  
  protected static StringValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final BooleanValue x, final StringValue y) {
    StringValue _createStringValue = ExecutionFactory.eINSTANCE.createStringValue();
    final Procedure1<StringValue> _function = (StringValue it) -> {
      boolean _isValue = x.isValue();
      String _value = y.getValue();
      String _plus = (Boolean.valueOf(_isValue) + _value);
      it.setValue(_plus);
    };
    return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
  }
  
  protected static ByteValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ByteValue x, final ByteValue y) {
    ByteValue _createByteValue = ExecutionFactory.eINSTANCE.createByteValue();
    final Procedure1<ByteValue> _function = (ByteValue it) -> {
      byte _value = x.getValue();
      byte _value_1 = y.getValue();
      int _plus = (_value + _value_1);
      it.setValue(((byte) _plus));
    };
    return ObjectExtensions.<ByteValue>operator_doubleArrow(_createByteValue, _function);
  }
  
  protected static ShortValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ByteValue x, final ShortValue y) {
    ShortValue _createShortValue = ExecutionFactory.eINSTANCE.createShortValue();
    final Procedure1<ShortValue> _function = (ShortValue it) -> {
      byte _value = x.getValue();
      short _value_1 = y.getValue();
      int _plus = (_value + _value_1);
      it.setValue(((short) _plus));
    };
    return ObjectExtensions.<ShortValue>operator_doubleArrow(_createShortValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ByteValue x, final IntegerValue y) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      byte _value = x.getValue();
      int _value_1 = y.getValue();
      int _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ByteValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      byte _value = x.getValue();
      long _value_1 = y.getValue();
      long _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ByteValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      byte _value = x.getValue();
      float _value_1 = y.getValue();
      float _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ByteValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      byte _value = x.getValue();
      double _value_1 = y.getValue();
      double _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static ShortValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ShortValue x, final ShortValue y) {
    ShortValue _createShortValue = ExecutionFactory.eINSTANCE.createShortValue();
    final Procedure1<ShortValue> _function = (ShortValue it) -> {
      short _value = x.getValue();
      short _value_1 = y.getValue();
      int _plus = (_value + _value_1);
      it.setValue(((short) _plus));
    };
    return ObjectExtensions.<ShortValue>operator_doubleArrow(_createShortValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ShortValue x, final IntegerValue y) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      short _value = x.getValue();
      int _value_1 = y.getValue();
      int _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ShortValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      short _value = x.getValue();
      long _value_1 = y.getValue();
      long _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ShortValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      short _value = x.getValue();
      float _value_1 = y.getValue();
      float _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final ShortValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      short _value = x.getValue();
      double _value_1 = y.getValue();
      double _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static IntegerValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final IntegerValue x, final IntegerValue y) {
    IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
    final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
      int _value = x.getValue();
      int _value_1 = y.getValue();
      int _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
  }
  
  protected static LongValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final IntegerValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      int _value = x.getValue();
      long _value_1 = y.getValue();
      long _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final IntegerValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      int _value = x.getValue();
      float _value_1 = y.getValue();
      float _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final IntegerValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      int _value = x.getValue();
      double _value_1 = y.getValue();
      double _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static LongValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final LongValue x, final LongValue y) {
    LongValue _createLongValue = ExecutionFactory.eINSTANCE.createLongValue();
    final Procedure1<LongValue> _function = (LongValue it) -> {
      long _value = x.getValue();
      long _value_1 = y.getValue();
      long _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<LongValue>operator_doubleArrow(_createLongValue, _function);
  }
  
  protected static FloatValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final LongValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      long _value = x.getValue();
      float _value_1 = y.getValue();
      float _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final LongValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      long _value = x.getValue();
      double _value_1 = y.getValue();
      double _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static FloatValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final FloatValue x, final FloatValue y) {
    FloatValue _createFloatValue = ExecutionFactory.eINSTANCE.createFloatValue();
    final Procedure1<FloatValue> _function = (FloatValue it) -> {
      float _value = x.getValue();
      float _value_1 = y.getValue();
      float _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<FloatValue>operator_doubleArrow(_createFloatValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final FloatValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      float _value = x.getValue();
      double _value_1 = y.getValue();
      double _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static DoubleValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final DoubleValue x, final DoubleValue y) {
    DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
    final Procedure1<DoubleValue> _function = (DoubleValue it) -> {
      double _value = x.getValue();
      double _value_1 = y.getValue();
      double _plus = (_value + _value_1);
      it.setValue(_plus);
    };
    return ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function);
  }
  
  protected static ObjectRefValue _privk3_p(final PlusAspectPlusAspectProperties _self_, final Plus _self, final State state, final ObjectRefValue x, final ObjectRefValue y) {
    boolean _isGaussian = TypeConcordance.isGaussian(y.getInstance().getType());
    if (_isGaussian) {
      return PlusAspect.plusGauss(_self, state, x, y);
    } else {
      boolean _isMultPoss = TypeConcordance.isMultPoss(y.getInstance().getType());
      if (_isMultPoss) {
        return PlusAspect.plusMultPoss(_self, state, x, y);
      } else {
        StringConcatenation _builder = new StringConcatenation();
        duc.uscript.uScript.Class _type = x.getInstance().getType();
        _builder.append(_type);
        _builder.append(" + ");
        duc.uscript.uScript.Class _type_1 = y.getInstance().getType();
        _builder.append(_type_1);
        _builder.append(" not yet implemented.");
        throw new RuntimeException(_builder.toString());
      }
    }
  }
  
  protected static ObjectRefValue _privk3_plusGauss(final PlusAspectPlusAspectProperties _self_, final Plus _self, final State state, final ObjectRefValue x, final ObjectRefValue y) {
    final DoubleValue valX = GaussianDoubleUtils.getValue(x);
    final DoubleValue valY = GaussianDoubleUtils.getValue(y);
    final DoubleValue meanX = GaussianDoubleUtils.getMean(x);
    final DoubleValue meanY = GaussianDoubleUtils.getMean(y);
    final DoubleValue varX = GaussianDoubleUtils.getVariance(x);
    final DoubleValue varY = GaussianDoubleUtils.getVariance(y);
    double _value = meanX.getValue();
    double _value_1 = meanY.getValue();
    double _plus = (_value + _value_1);
    double _value_2 = varX.getValue();
    double _value_3 = varY.getValue();
    double _plus_1 = (_value_2 + _value_3);
    double _value_4 = valX.getValue();
    double _value_5 = valY.getValue();
    double _plus_2 = (_value_4 + _value_5);
    final ObjectInstance result = GaussianDoubleUtils.createGaussianDouble(state, _plus, _plus_1, _plus_2, _self);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
  
  protected static ObjectRefValue _privk3_plusMultPoss(final PlusAspectPlusAspectProperties _self_, final Plus _self, final State state, final ObjectRefValue x, final ObjectRefValue y) {
    final double[] probsX = MultPossibilityUtils.extractProbs(x.getInstance());
    final double[] probsY = MultPossibilityUtils.extractProbs(y.getInstance());
    int _length = probsX.length;
    int _length_1 = probsY.length;
    int _plus = (_length + _length_1);
    final double[] probsRes = new double[_plus];
    System.arraycopy(probsX, 0, probsRes, 0, probsX.length);
    System.arraycopy(probsY, 0, probsRes, probsX.length, probsY.length);
    final double[] sum = Computer.compute(probsRes);
    final Injector injector = new UScriptStandaloneSetupGenerated().createInjector();
    final InternalTypeDcl internalTypeDcl = injector.<InternalTypeDcl>getInstance(InternalTypeDcl.class);
    ArrayInstance _createArrayInstance = ExecutionFactory.eINSTANCE.createArrayInstance();
    final Procedure1<ArrayInstance> _function = (ArrayInstance it) -> {
      it.setSize(probsRes.length);
    };
    final ArrayInstance arrayProbs = ObjectExtensions.<ArrayInstance>operator_doubleArrow(_createArrayInstance, _function);
    state.getArraysHeap().add(arrayProbs);
    for (final double pRes : probsRes) {
      EList<Value> _value = arrayProbs.getValue();
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_1 = (DoubleValue it) -> {
        it.setValue(pRes);
      };
      DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_1);
      _value.add(_doubleArrow);
    }
    ArrayInstance _createArrayInstance_1 = ExecutionFactory.eINSTANCE.createArrayInstance();
    final Procedure1<ArrayInstance> _function_2 = (ArrayInstance it) -> {
      it.setSize(sum.length);
    };
    final ArrayInstance possibilitiesInstance = ObjectExtensions.<ArrayInstance>operator_doubleArrow(_createArrayInstance_1, _function_2);
    state.getArraysHeap().add(possibilitiesInstance);
    final duc.uscript.uScript.Class intPossType = internalTypeDcl.getIntPossibilityClass(_self);
    final duc.uscript.uScript.Class possType = internalTypeDcl.getPossibilityClass(_self);
    for (int i = 0; (i < sum.length); i++) {
      {
        ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
        final Procedure1<ObjectInstance> _function_3 = (ObjectInstance it) -> {
          it.setType(intPossType);
        };
        final ObjectInstance probVal = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function_3);
        state.getObjectsHeap().add(probVal);
        final double p = sum[i];
        final int fi = i;
        EList<FieldBinding> _fieldbindings = probVal.getFieldbindings();
        FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
        final Procedure1<FieldBinding> _function_4 = (FieldBinding it) -> {
          final Function1<Field, Boolean> _function_5 = (Field it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equal(_name, "confidence"));
          };
          it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(possType.getMembers(), Field.class), _function_5));
          DoubleValue _createDoubleValue_1 = ExecutionFactory.eINSTANCE.createDoubleValue();
          final Procedure1<DoubleValue> _function_6 = (DoubleValue it_1) -> {
            it_1.setValue(p);
          };
          DoubleValue _doubleArrow_1 = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue_1, _function_6);
          it.setValue(_doubleArrow_1);
        };
        FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_4);
        _fieldbindings.add(_doubleArrow_1);
        EList<FieldBinding> _fieldbindings_1 = probVal.getFieldbindings();
        FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
        final Procedure1<FieldBinding> _function_5 = (FieldBinding it) -> {
          final Function1<Field, Boolean> _function_6 = (Field it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equal(_name, "value"));
          };
          it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(intPossType.getMembers(), Field.class), _function_6));
          IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
          final Procedure1<IntegerValue> _function_7 = (IntegerValue it_1) -> {
            it_1.setValue(fi);
          };
          IntegerValue _doubleArrow_2 = ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function_7);
          it.setValue(_doubleArrow_2);
        };
        FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_5);
        _fieldbindings_1.add(_doubleArrow_2);
        EList<Value> _value_1 = possibilitiesInstance.getValue();
        ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
        final Procedure1<ObjectRefValue> _function_6 = (ObjectRefValue it) -> {
          it.setInstance(probVal);
        };
        ObjectRefValue _doubleArrow_3 = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_6);
        _value_1.add(_doubleArrow_3);
      }
    }
    final duc.uscript.uScript.Class dblMultPossObjType = internalTypeDcl.getMultChoiceDoubleClass(_self);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_3 = (ObjectInstance it) -> {
      it.setType(dblMultPossObjType);
    };
    final ObjectInstance multPossObjIns = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function_3);
    state.getObjectsHeap().add(multPossObjIns);
    EList<FieldBinding> _fieldbindings = multPossObjIns.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_4 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_5 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "possibilities"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(dblMultPossObjType.getMembers(), Field.class), _function_5));
      ArrayRefValue _createArrayRefValue = ExecutionFactory.eINSTANCE.createArrayRefValue();
      final Procedure1<ArrayRefValue> _function_6 = (ArrayRefValue it_1) -> {
        it_1.setInstance(possibilitiesInstance);
      };
      ArrayRefValue _doubleArrow_1 = ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function_6);
      it.setValue(_doubleArrow_1);
    };
    FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_4);
    _fieldbindings.add(_doubleArrow_1);
    final duc.uscript.uScript.Class multPossType = internalTypeDcl.getMultChoiceClass(_self);
    EList<FieldBinding> _fieldbindings_1 = multPossObjIns.getFieldbindings();
    FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_5 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_6 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "rootProbs"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(multPossType.getMembers(), Field.class), _function_6));
      ArrayRefValue _createArrayRefValue = ExecutionFactory.eINSTANCE.createArrayRefValue();
      final Procedure1<ArrayRefValue> _function_7 = (ArrayRefValue it_1) -> {
        it_1.setInstance(arrayProbs);
      };
      ArrayRefValue _doubleArrow_2 = ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function_7);
      it.setValue(_doubleArrow_2);
    };
    FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_5);
    _fieldbindings_1.add(_doubleArrow_2);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_6 = (ObjectRefValue it) -> {
      it.setInstance(multPossObjIns);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_6);
  }
  
  private static SymbolSet super_findDependentVariables(final Plus _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final PlusAspectPlusAspectProperties _self_, final Plus _self, final State state) {
    final SymbolSet result = new SymbolSet();
    result.addAll(ExpressionAspect.findDependentVariables(_self.getLeft(), state));
    result.addAll(ExpressionAspect.findDependentVariables(_self.getRight(), state));
    return result;
  }
}
