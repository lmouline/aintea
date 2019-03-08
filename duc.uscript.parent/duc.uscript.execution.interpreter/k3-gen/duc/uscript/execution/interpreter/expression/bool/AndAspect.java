package duc.uscript.execution.interpreter.expression.bool;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import duc.uscript.UScriptStandaloneSetupGenerated;
import duc.uscript.execution.BooleanValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties;
import duc.uscript.typing.InternalTypeDcl;
import duc.uscript.uScript.And;
import duc.uscript.uScript.Field;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = And.class)
@SuppressWarnings("all")
public class AndAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final And _self, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.And)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue rightDispatch(final And _self, final BooleanValue left, final Value right) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue rightDispatch(BooleanValue,Value)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.And)_self,left,right);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static ObjectRefValue rightDispatch(final And _self, final ObjectRefValue left, final Value right, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue rightDispatch(ObjectRefValue,Value,State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_rightDispatch(_self_, (duc.uscript.uScript.And)_self,left,right,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static BooleanValue private_and(final And _self, final BooleanValue x, final BooleanValue y) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue private_and(BooleanValue,BooleanValue)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_private_and(_self_, (duc.uscript.uScript.And)_self,x,y);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static ObjectRefValue private_and(final And _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.AndAspectAndAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_and(ObjectRefValue,ObjectRefValue,State)
    if (_self instanceof duc.uscript.uScript.And){
    	result = duc.uscript.execution.interpreter.expression.bool.AndAspect._privk3_private_and(_self_, (duc.uscript.uScript.And)_self,x,y,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static Value super_evaluateExpression(final And _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final AndAspectAndAspectProperties _self_, final And _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (left instanceof BooleanValue) {
      _matched=true;
      _switchResult = AndAspect.rightDispatch(_self, ((BooleanValue)left), right);
    }
    if (!_matched) {
      if (left instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = AndAspect.rightDispatch(_self, ((ObjectRefValue)left), right, state);
      }
    }
    if (!_matched) {
      String _name = left.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_rightDispatch(final AndAspectAndAspectProperties _self_, final And _self, final BooleanValue left, final Value right) {
    BooleanValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof BooleanValue) {
      _matched=true;
      _switchResult = AndAspect.private_and(_self, left, ((BooleanValue)right));
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static ObjectRefValue _privk3_rightDispatch(final AndAspectAndAspectProperties _self_, final And _self, final ObjectRefValue left, final Value right, final State state) {
    ObjectRefValue _switchResult = null;
    boolean _matched = false;
    if (right instanceof ObjectRefValue) {
      _matched=true;
      _switchResult = AndAspect.private_and(_self, left, ((ObjectRefValue)right), state);
    }
    if (!_matched) {
      String _name = right.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_private_and(final AndAspectAndAspectProperties _self_, final And _self, final BooleanValue x, final BooleanValue y) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue((x.isValue() && y.isValue()));
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static ObjectRefValue _privk3_private_and(final AndAspectAndAspectProperties _self_, final And _self, final ObjectRefValue x, final ObjectRefValue y, final State state) {
    final EList<FieldBinding> fieldBdgX = x.getInstance().getFieldbindings();
    final EList<FieldBinding> fieldBdgY = y.getInstance().getFieldbindings();
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "value"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(fieldBdgX, _function).getValue();
    final BooleanValue valX = ((BooleanValue) _value);
    final Function1<FieldBinding, Boolean> _function_1 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "value"));
    };
    Value _value_1 = IterableExtensions.<FieldBinding>findFirst(fieldBdgY, _function_1).getValue();
    final BooleanValue valY = ((BooleanValue) _value_1);
    final Function1<FieldBinding, Boolean> _function_2 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "confidence"));
    };
    Value _value_2 = IterableExtensions.<FieldBinding>findFirst(fieldBdgX, _function_2).getValue();
    final ObjectRefValue confX = ((ObjectRefValue) _value_2);
    final Function1<FieldBinding, Boolean> _function_3 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "probability"));
    };
    Value _value_3 = IterableExtensions.<FieldBinding>findFirst(confX.getInstance().getFieldbindings(), _function_3).getValue();
    final DoubleValue probX = ((DoubleValue) _value_3);
    final Function1<FieldBinding, Boolean> _function_4 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "confidence"));
    };
    Value _value_4 = IterableExtensions.<FieldBinding>findFirst(fieldBdgY, _function_4).getValue();
    final ObjectRefValue confY = ((ObjectRefValue) _value_4);
    final Function1<FieldBinding, Boolean> _function_5 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "probability"));
    };
    Value _value_5 = IterableExtensions.<FieldBinding>findFirst(confY.getInstance().getFieldbindings(), _function_5).getValue();
    final DoubleValue probY = ((DoubleValue) _value_5);
    final Injector injector = new UScriptStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
    final InternalTypeDcl internalTypeDcl = injector.<InternalTypeDcl>getInstance(InternalTypeDcl.class);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_6 = (ObjectInstance it) -> {
      it.setType(internalTypeDcl.getBernoulliDistClass(_self));
    };
    final ObjectInstance dist = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function_6);
    EList<FieldBinding> _fieldbindings = dist.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_7 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(dist.getType().getMembers(), Field.class), Field.class))[0]);
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_8 = (DoubleValue it_1) -> {
        double _value_6 = probX.getValue();
        double _value_7 = probY.getValue();
        double _multiply = (_value_6 * _value_7);
        it_1.setValue(_multiply);
      };
      DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_8);
      it.setValue(_doubleArrow);
    };
    FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_7);
    _fieldbindings.add(_doubleArrow);
    state.getObjectsHeap().add(dist);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_8 = (ObjectRefValue it) -> {
      it.setInstance(dist);
    };
    final ObjectRefValue refDist = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_8);
    final duc.uscript.uScript.Class finalType = internalTypeDcl.getBernoulliBoolClass(_self);
    ObjectInstance _createObjectInstance_1 = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_9 = (ObjectInstance it) -> {
      it.setType(finalType);
    };
    final ObjectInstance result = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance_1, _function_9);
    EList<FieldBinding> _fieldbindings_1 = result.getFieldbindings();
    FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_10 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(internalTypeDcl.getBernoulliClass(_self).getMembers(), Field.class), Field.class))[0]);
      it.setValue(refDist);
    };
    FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_10);
    _fieldbindings_1.add(_doubleArrow_1);
    EList<FieldBinding> _fieldbindings_2 = result.getFieldbindings();
    FieldBinding _createFieldBinding_2 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_11 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(finalType.getMembers(), Field.class), Field.class))[0]);
      BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
      final Procedure1<BooleanValue> _function_12 = (BooleanValue it_1) -> {
        it_1.setValue((valX.isValue() && valY.isValue()));
      };
      BooleanValue _doubleArrow_2 = ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function_12);
      it.setValue(_doubleArrow_2);
    };
    FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_2, _function_11);
    _fieldbindings_2.add(_doubleArrow_2);
    state.getObjectsHeap().add(result);
    ObjectRefValue _createObjectRefValue_1 = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_12 = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue_1, _function_12);
  }
}
