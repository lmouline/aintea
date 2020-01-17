package duc.uscript.execution.interpreter.utils;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import duc.uscript.UScriptStandaloneSetupGenerated;
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
public class GaussianDoubleUtils {
  public static DoubleValue getValue(final ObjectRefValue gaussianDouble) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "value"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(gaussianDouble.getInstance().getFieldbindings(), _function).getValue();
    return ((DoubleValue) _value);
  }
  
  public static DoubleValue getMean(final ObjectRefValue gaussianDouble) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "confidence"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(gaussianDouble.getInstance().getFieldbindings(), _function).getValue();
    final ObjectRefValue confidence = ((ObjectRefValue) _value);
    final Function1<FieldBinding, Boolean> _function_1 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "mean"));
    };
    Value _value_1 = IterableExtensions.<FieldBinding>findFirst(confidence.getInstance().getFieldbindings(), _function_1).getValue();
    return ((DoubleValue) _value_1);
  }
  
  public static DoubleValue getVariance(final ObjectRefValue gaussianDouble) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "confidence"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(gaussianDouble.getInstance().getFieldbindings(), _function).getValue();
    final ObjectRefValue confidence = ((ObjectRefValue) _value);
    final Function1<FieldBinding, Boolean> _function_1 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "variance"));
    };
    Value _value_1 = IterableExtensions.<FieldBinding>findFirst(confidence.getInstance().getFieldbindings(), _function_1).getValue();
    return ((DoubleValue) _value_1);
  }
  
  public static ObjectInstance createGaussianDouble(final State state, final double mean, final double variance, final double doubleVal, final EObject ctx) {
    final Injector injector = new UScriptStandaloneSetupGenerated().createInjector();
    final InternalTypeDcl internalTypeDcl = injector.<InternalTypeDcl>getInstance(InternalTypeDcl.class);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function = (ObjectInstance it) -> {
      it.setType(internalTypeDcl.getGaussianDistClass(ctx));
    };
    final ObjectInstance dist = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function);
    EList<FieldBinding> _fieldbindings = dist.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_1 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_2 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "mean"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(dist.getType().getMembers(), Field.class), _function_2));
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_3 = (DoubleValue it_1) -> {
        it_1.setValue(mean);
      };
      DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_3);
      it.setValue(_doubleArrow);
    };
    FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_1);
    _fieldbindings.add(_doubleArrow);
    EList<FieldBinding> _fieldbindings_1 = dist.getFieldbindings();
    FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_2 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_3 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "variance"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(dist.getType().getMembers(), Field.class), _function_3));
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_4 = (DoubleValue it_1) -> {
        it_1.setValue(variance);
      };
      DoubleValue _doubleArrow_1 = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_4);
      it.setValue(_doubleArrow_1);
    };
    FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_2);
    _fieldbindings_1.add(_doubleArrow_1);
    state.getObjectsHeap().add(dist);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_3 = (ObjectRefValue it) -> {
      it.setInstance(dist);
    };
    final ObjectRefValue refDist = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_3);
    final duc.uscript.uScript.Class finalType = internalTypeDcl.getGaussianDoubleClass(ctx);
    ObjectInstance _createObjectInstance_1 = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_4 = (ObjectInstance it) -> {
      it.setType(finalType);
    };
    final ObjectInstance result = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance_1, _function_4);
    EList<FieldBinding> _fieldbindings_2 = result.getFieldbindings();
    FieldBinding _createFieldBinding_2 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_5 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray((Iterables.<Field>filter(internalTypeDcl.getBernoulliClass(ctx).getMembers(), Field.class)), Field.class))[0]);
      it.setValue(refDist);
    };
    FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_2, _function_5);
    _fieldbindings_2.add(_doubleArrow_2);
    EList<FieldBinding> _fieldbindings_3 = result.getFieldbindings();
    FieldBinding _createFieldBinding_3 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_6 = (FieldBinding it) -> {
      it.setField(((Field[])Conversions.unwrapArray((Iterables.<Field>filter(finalType.getMembers(), Field.class)), Field.class))[0]);
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_7 = (DoubleValue it_1) -> {
        it_1.setValue(doubleVal);
      };
      DoubleValue _doubleArrow_3 = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_7);
      it.setValue(_doubleArrow_3);
    };
    FieldBinding _doubleArrow_3 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_3, _function_6);
    _fieldbindings_3.add(_doubleArrow_3);
    state.getObjectsHeap().add(result);
    return result;
  }
}
