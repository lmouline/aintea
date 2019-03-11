package duc.uscript.execution.interpreter.expression;

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
import duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectProperties;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils;
import duc.uscript.typing.InternalTypeDcl;
import duc.uscript.typing.TypeResolver;
import duc.uscript.uScript.BernoulliRef;
import duc.uscript.uScript.BinomialRef;
import duc.uscript.uScript.DiracRef;
import duc.uscript.uScript.Field;
import duc.uscript.uScript.GaussianRef;
import duc.uscript.uScript.NewUObject;
import duc.uscript.uScript.RayleighRef;
import duc.uscript.uScript.UTypeRef;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = NewUObject.class)
@SuppressWarnings("all")
public class NewUObjectAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final NewUObject _self, final State state) {
    final duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.NewUObject){
    	result = duc.uscript.execution.interpreter.expression.NewUObjectAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.NewUObject)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value createDistNumeric(final NewUObject _self, final State state, final InternalTypeDcl typeDcl, final TypeResolver typeResolver) {
    final duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value createDistNumeric(State,InternalTypeDcl,TypeResolver)
    if (_self instanceof duc.uscript.uScript.NewUObject){
    	result = duc.uscript.execution.interpreter.expression.NewUObjectAspect._privk3_createDistNumeric(_self_, (duc.uscript.uScript.NewUObject)_self,state,typeDcl,typeResolver);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value createDistBool(final NewUObject _self, final State state, final InternalTypeDcl typeDcl, final TypeResolver typeResolver) {
    final duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NewUObjectAspectNewUObjectAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value createDistBool(State,InternalTypeDcl,TypeResolver)
    if (_self instanceof duc.uscript.uScript.NewUObject){
    	result = duc.uscript.execution.interpreter.expression.NewUObjectAspect._privk3_createDistBool(_self_, (duc.uscript.uScript.NewUObject)_self,state,typeDcl,typeResolver);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static Value super_evaluateExpression(final NewUObject _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NewUObjectAspectNewUObjectAspectProperties _self_, final NewUObject _self, final State state) {
    final Injector injector = new UScriptStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
    final InternalTypeDcl internalTypeDcl = injector.<InternalTypeDcl>getInstance(InternalTypeDcl.class);
    final TypeResolver typeResolver = injector.<TypeResolver>getInstance(TypeResolver.class);
    Value _switchResult = null;
    UTypeRef _type = _self.getType();
    boolean _matched = false;
    if (_type instanceof GaussianRef) {
      _matched=true;
      _switchResult = NewUObjectAspect.createDistNumeric(_self, state, internalTypeDcl, typeResolver);
    }
    if (!_matched) {
      if (_type instanceof RayleighRef) {
        _matched=true;
        _switchResult = NewUObjectAspect.createDistNumeric(_self, state, internalTypeDcl, typeResolver);
      }
    }
    if (!_matched) {
      if (_type instanceof BinomialRef) {
        _matched=true;
        _switchResult = NewUObjectAspect.createDistNumeric(_self, state, internalTypeDcl, typeResolver);
      }
    }
    if (!_matched) {
      if (_type instanceof DiracRef) {
        _matched=true;
        _switchResult = NewUObjectAspect.createDistNumeric(_self, state, internalTypeDcl, typeResolver);
      }
    }
    if (!_matched) {
      if (_type instanceof BernoulliRef) {
        _matched=true;
        _switchResult = NewUObjectAspect.createDistBool(_self, state, internalTypeDcl, typeResolver);
      }
    }
    if (!_matched) {
      String _name = _self.getType().getClass().getName();
      String _plus = ("Not yet implemented for " + _name);
      throw new RuntimeException(_plus);
    }
    return _switchResult;
  }
  
  protected static Value _privk3_createDistNumeric(final NewUObjectAspectNewUObjectAspectProperties _self_, final NewUObject _self, final State state, final InternalTypeDcl typeDcl, final TypeResolver typeResolver) {
    final Value mean = ExpressionAspect.evaluateExpression(_self.getArgs().get(0), state);
    final Value variance = ExpressionAspect.evaluateExpression(_self.getArgs().get(1), state);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function = (ObjectInstance it) -> {
      it.setType(typeDcl.getDistType(_self.getType()));
    };
    final ObjectInstance dist = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function);
    EList<FieldBinding> _fieldbindings = dist.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_1 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(dist.getType().getMembers(), Field.class), Field.class))[0]);
      it.setValue(mean);
    };
    FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_1);
    _fieldbindings.add(_doubleArrow);
    EList<FieldBinding> _fieldbindings_1 = dist.getFieldbindings();
    FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_2 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(dist.getType().getMembers(), Field.class), Field.class))[1]);
      it.setValue(variance);
    };
    FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_2);
    _fieldbindings_1.add(_doubleArrow_1);
    state.getObjectsHeap().add(dist);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_3 = (ObjectRefValue it) -> {
      it.setInstance(dist);
    };
    final ObjectRefValue refDist = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_3);
    final duc.uscript.uScript.Class finalType = typeResolver.type(_self.getType());
    ObjectInstance _createObjectInstance_1 = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_4 = (ObjectInstance it) -> {
      it.setType(finalType);
    };
    final ObjectInstance result = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance_1, _function_4);
    EList<FieldBinding> _fieldbindings_2 = result.getFieldbindings();
    FieldBinding _createFieldBinding_2 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_5 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(typeDcl.getUType(_self.getType()).getMembers(), Field.class), Field.class))[0]);
      it.setValue(refDist);
    };
    FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_2, _function_5);
    _fieldbindings_2.add(_doubleArrow_2);
    EList<FieldBinding> _fieldbindings_3 = result.getFieldbindings();
    FieldBinding _createFieldBinding_3 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_6 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray(Iterables.<Field>filter(finalType.getMembers(), Field.class), Field.class))[0]);
      it.setValue(ValueAspect.copy(mean));
    };
    FieldBinding _doubleArrow_3 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_3, _function_6);
    _fieldbindings_3.add(_doubleArrow_3);
    state.getObjectsHeap().add(result);
    ObjectRefValue _createObjectRefValue_1 = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_7 = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue_1, _function_7);
  }
  
  protected static Value _privk3_createDistBool(final NewUObjectAspectNewUObjectAspectProperties _self_, final NewUObject _self, final State state, final InternalTypeDcl typeDcl, final TypeResolver typeResolver) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getArgs().get(0), state);
    final BooleanValue uValue = ((BooleanValue) _evaluateExpression);
    Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(_self.getArgs().get(1), state);
    final DoubleValue probability = ((DoubleValue) _evaluateExpression_1);
    boolean _isValue = uValue.isValue();
    boolean _not = (!_isValue);
    if (_not) {
      double _value = probability.getValue();
      double _minus = (1 - _value);
      probability.setValue(_minus);
    }
    final ObjectInstance result = BernoulliBoolUtils.createBernoulliBool(state, probability.getValue(), uValue.isValue(), _self);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
  }
}
