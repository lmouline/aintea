package duc.uscript.execution.interpreter.utils;

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
import duc.uscript.typing.InternalTypeDcl;
import duc.uscript.uScript.Field;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class BernoulliBoolUtils {
  public static ObjectInstance createBernoulliBool(final State state, final double probValue, final boolean boolVal, final EObject ctx) {
    final Injector injector = new UScriptStandaloneSetupGenerated().createInjector();
    final InternalTypeDcl internalTypeDcl = injector.<InternalTypeDcl>getInstance(InternalTypeDcl.class);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function = (ObjectInstance it) -> {
      it.setType(internalTypeDcl.getBernoulliDistClass(ctx));
    };
    final ObjectInstance dist = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function);
    EList<FieldBinding> _fieldbindings = dist.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_1 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray((Iterables.<Field>filter(dist.getType().getMembers(), Field.class)), Field.class))[0]);
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_2 = (DoubleValue it_1) -> {
        it_1.setValue(probValue);
      };
      DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_2);
      it.setValue(_doubleArrow);
    };
    FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_1);
    _fieldbindings.add(_doubleArrow);
    state.getObjectsHeap().add(dist);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_2 = (ObjectRefValue it) -> {
      it.setInstance(dist);
    };
    final ObjectRefValue refDist = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_2);
    final duc.uscript.uScript.Class finalType = internalTypeDcl.getBernoulliBoolClass(ctx);
    ObjectInstance _createObjectInstance_1 = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_3 = (ObjectInstance it) -> {
      it.setType(finalType);
    };
    final ObjectInstance result = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance_1, _function_3);
    EList<FieldBinding> _fieldbindings_1 = result.getFieldbindings();
    FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_4 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray((Iterables.<Field>filter(internalTypeDcl.getBernoulliClass(ctx).getMembers(), Field.class)), Field.class))[0]);
      it.setValue(refDist);
    };
    FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_4);
    _fieldbindings_1.add(_doubleArrow_1);
    EList<FieldBinding> _fieldbindings_2 = result.getFieldbindings();
    FieldBinding _createFieldBinding_2 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_5 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray((Iterables.<Field>filter(finalType.getMembers(), Field.class)), Field.class))[0]);
      BooleanValue _createBooleanValue = ExecutionFactory.eINSTANCE.createBooleanValue();
      final Procedure1<BooleanValue> _function_6 = (BooleanValue it_1) -> {
        it_1.setValue(boolVal);
      };
      BooleanValue _doubleArrow_2 = ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function_6);
      it.setValue(_doubleArrow_2);
    };
    FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_2, _function_5);
    _fieldbindings_2.add(_doubleArrow_2);
    state.getObjectsHeap().add(result);
    return result;
  }
  
  public static BooleanValue getValue(final ObjectRefValue bernoulliBool) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "value"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(bernoulliBool.getInstance().getFieldbindings(), _function).getValue();
    return ((BooleanValue) _value);
  }
  
  public static DoubleValue getProbability(final ObjectRefValue bernoulliBool) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "confidence"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(bernoulliBool.getInstance().getFieldbindings(), _function).getValue();
    final ObjectRefValue confidence = ((ObjectRefValue) _value);
    final Function1<FieldBinding, Boolean> _function_1 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "probability"));
    };
    Value _value_1 = IterableExtensions.<FieldBinding>findFirst(confidence.getInstance().getFieldbindings(), _function_1).getValue();
    return ((DoubleValue) _value_1);
  }
}
