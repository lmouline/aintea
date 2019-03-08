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
import duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties;
import duc.uscript.typing.InternalTypeDcl;
import duc.uscript.uScript.Field;
import duc.uscript.uScript.Not;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Not.class)
@SuppressWarnings("all")
public class NotAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Not _self, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.Not){
    	result = duc.uscript.execution.interpreter.expression.bool.NotAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.Not)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static BooleanValue private_not(final Not _self, final BooleanValue x) {
    final duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# BooleanValue private_not(BooleanValue)
    if (_self instanceof duc.uscript.uScript.Not){
    	result = duc.uscript.execution.interpreter.expression.bool.NotAspect._privk3_private_not(_self_, (duc.uscript.uScript.Not)_self,x);
    };
    return (duc.uscript.execution.BooleanValue)result;
  }
  
  private static ObjectRefValue private_not(final Not _self, final ObjectRefValue x, final State state) {
    final duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectProperties _self_ = duc.uscript.execution.interpreter.expression.bool.NotAspectNotAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ObjectRefValue private_not(ObjectRefValue,State)
    if (_self instanceof duc.uscript.uScript.Not){
    	result = duc.uscript.execution.interpreter.expression.bool.NotAspect._privk3_private_not(_self_, (duc.uscript.uScript.Not)_self,x,state);
    };
    return (duc.uscript.execution.ObjectRefValue)result;
  }
  
  private static Value super_evaluateExpression(final Not _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NotAspectNotAspectProperties _self_, final Not _self, final State state) {
    final Value value = ExpressionAspect.evaluateExpression(_self.getExpression(), state);
    Value _switchResult = null;
    boolean _matched = false;
    if (value instanceof BooleanValue) {
      _matched=true;
      _switchResult = NotAspect.private_not(_self, ((BooleanValue)value));
    }
    if (!_matched) {
      if (value instanceof ObjectRefValue) {
        _matched=true;
        _switchResult = NotAspect.private_not(_self, ((ObjectRefValue)value), state);
      }
    }
    if (!_matched) {
      String _name = value.getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static BooleanValue _privk3_private_not(final NotAspectNotAspectProperties _self_, final Not _self, final BooleanValue x) {
    BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      boolean _isValue = x.isValue();
      boolean _not = (!_isValue);
      it.setValue(_not);
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
  
  protected static ObjectRefValue _privk3_private_not(final NotAspectNotAspectProperties _self_, final Not _self, final ObjectRefValue x, final State state) {
    final EList<FieldBinding> fieldBdgX = x.getInstance().getFieldbindings();
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "value"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(fieldBdgX, _function).getValue();
    final BooleanValue valX = ((BooleanValue) _value);
    final Function1<FieldBinding, Boolean> _function_1 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "confidence"));
    };
    Value _value_1 = IterableExtensions.<FieldBinding>findFirst(fieldBdgX, _function_1).getValue();
    final ObjectRefValue confX = ((ObjectRefValue) _value_1);
    final Function1<FieldBinding, Boolean> _function_2 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "probability"));
    };
    Value _value_2 = IterableExtensions.<FieldBinding>findFirst(confX.getInstance().getFieldbindings(), _function_2).getValue();
    final DoubleValue probX = ((DoubleValue) _value_2);
    final Injector injector = new UScriptStandaloneSetupGenerated().createInjector();
    final InternalTypeDcl internalTypeDcl = injector.<InternalTypeDcl>getInstance(InternalTypeDcl.class);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_3 = (ObjectInstance it) -> {
      it.setType(internalTypeDcl.getBernoulliDistClass(_self));
    };
    final ObjectInstance dist = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function_3);
    EList<FieldBinding> _fieldbindings = dist.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_4 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(dist.getType().getMembers(), Field.class), Field.class))[0]);
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_5 = (DoubleValue it_1) -> {
        double _value_3 = probX.getValue();
        double _minus = (1 - _value_3);
        it_1.setValue(_minus);
      };
      DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_5);
      it.setValue(_doubleArrow);
    };
    FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_4);
    _fieldbindings.add(_doubleArrow);
    state.getObjectsHeap().add(dist);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_5 = (ObjectRefValue it) -> {
      it.setInstance(dist);
    };
    final ObjectRefValue refDist = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_5);
    final duc.uscript.uScript.Class finalType = internalTypeDcl.getBernoulliBoolClass(_self);
    ObjectInstance _createObjectInstance_1 = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_6 = (ObjectInstance it) -> {
      it.setType(finalType);
    };
    final ObjectInstance result = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance_1, _function_6);
    EList<FieldBinding> _fieldbindings_1 = result.getFieldbindings();
    FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_7 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(internalTypeDcl.getBernoulliClass(_self).getMembers(), Field.class), Field.class))[0]);
      it.setValue(refDist);
    };
    FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_7);
    _fieldbindings_1.add(_doubleArrow_1);
    EList<FieldBinding> _fieldbindings_2 = result.getFieldbindings();
    FieldBinding _createFieldBinding_2 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_8 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(finalType.getMembers(), Field.class), Field.class))[0]);
      BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
      final Procedure1<BooleanValue> _function_9 = (BooleanValue it_1) -> {
        boolean _isValue = valX.isValue();
        boolean _not = (!_isValue);
        it_1.setValue(_not);
      };
      BooleanValue _doubleArrow_2 = ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function_9);
      it.setValue(_doubleArrow_2);
    };
    FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_2, _function_8);
    _fieldbindings_2.add(_doubleArrow_2);
    state.getObjectsHeap().add(result);
    ObjectRefValue _createObjectRefValue_1 = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_9 = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue_1, _function_9);
  }
}
