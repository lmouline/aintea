package duc.uscript.execution.interpreter.expression;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import duc.aintea.lib.poissonbinomial.Computer;
import duc.uscript.UScriptStandaloneSetupGenerated;
import duc.uscript.execution.ArrayInstance;
import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils;
import duc.uscript.typing.InternalTypeDcl;
import duc.uscript.uScript.ComputeNbTrueExpr;
import duc.uscript.uScript.Field;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = ComputeNbTrueExpr.class)
@SuppressWarnings("all")
public class ComputeNbrTrueExprAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.ComputeNbTrueExpr){
    	result = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.ComputeNbTrueExpr)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  @OverrideAspectMethod
  public static Value evaluateExpression(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.ComputeNbTrueExpr){
    	result = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.ComputeNbTrueExpr)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  private static ArrayInstance bernArrayToDoubleArray(final ComputeNbTrueExpr _self, final ArrayRefValue bernArray, final int[] sum) {
    final duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# ArrayInstance bernArrayToDoubleArray(ArrayRefValue,int[])
    if (_self instanceof duc.uscript.uScript.ComputeNbTrueExpr){
    	result = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspect._privk3_bernArrayToDoubleArray(_self_, (duc.uscript.uScript.ComputeNbTrueExpr)_self,bernArray,sum);
    };
    return (duc.uscript.execution.ArrayInstance)result;
  }
  
  private static double[] computePb(final ComputeNbTrueExpr _self, final ArrayRefValue valueExpr) {
    final duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspectComputeNbTrueExprAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# double[] computePb(ArrayRefValue)
    if (_self instanceof duc.uscript.uScript.ComputeNbTrueExpr){
    	result = duc.uscript.execution.interpreter.expression.ComputeNbrTrueExprAspect._privk3_computePb(_self_, (duc.uscript.uScript.ComputeNbTrueExpr)_self,valueExpr);
    };
    return (double[])result;
  }
  
  private static SymbolSet super_findDependentVariables(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_, final ComputeNbTrueExpr _self, final State state) {
    return new SymbolSet();
  }
  
  private static Value super_evaluateExpression(final ComputeNbTrueExpr _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_, final ComputeNbTrueExpr _self, final State state) {
    final Value valueExpr = ExpressionAspect.evaluateExpression(_self.getExpr(), state);
    if ((!(valueExpr instanceof ArrayRefValue))) {
      Class<? extends Value> _class = valueExpr.getClass();
      String _plus = ("ComputeNbTrueExpr.evaluateExpression: type of expression not managed. Expected: ArrayRef. Actual: " + _class);
      throw new RuntimeException(_plus);
    }
    final double[] probs = ComputeNbrTrueExprAspect.computePb(_self, ((ArrayRefValue) valueExpr));
    final Injector injector = new UScriptStandaloneSetupGenerated().createInjector();
    final InternalTypeDcl internalTypeDcl = injector.<InternalTypeDcl>getInstance(InternalTypeDcl.class);
    final int[] sum = new int[1];
    final ArrayInstance initBernProbs = ComputeNbrTrueExprAspect.bernArrayToDoubleArray(_self, ((ArrayRefValue) valueExpr), sum);
    state.getArraysHeap().add(initBernProbs);
    ArrayInstance _createArrayInstance = ExecutionFactory.eINSTANCE.createArrayInstance();
    final Procedure1<ArrayInstance> _function = (ArrayInstance it) -> {
      it.setSize(probs.length);
    };
    final ArrayInstance probabilities = ObjectExtensions.<ArrayInstance>operator_doubleArrow(_createArrayInstance, _function);
    state.getArraysHeap().add(probabilities);
    for (final double p : probs) {
      EList<Value> _value = probabilities.getValue();
      DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
      final Procedure1<DoubleValue> _function_1 = (DoubleValue it) -> {
        it.setValue(p);
      };
      DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_1);
      _value.add(_doubleArrow);
    }
    final duc.uscript.uScript.Class distType = internalTypeDcl.getPoissBinDistClass(_self);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_2 = (ObjectInstance it) -> {
      it.setType(distType);
    };
    final ObjectInstance dist = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function_2);
    state.getObjectsHeap().add(dist);
    EList<FieldBinding> _fieldbindings = dist.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_3 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_4 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "initBernProbs"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(distType.getMembers(), Field.class), _function_4));
      ArrayRefValue _createArrayRefValue = ExecutionFactory.eINSTANCE.createArrayRefValue();
      final Procedure1<ArrayRefValue> _function_5 = (ArrayRefValue it_1) -> {
        it_1.setInstance(initBernProbs);
      };
      ArrayRefValue _doubleArrow_1 = ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function_5);
      it.setValue(_doubleArrow_1);
    };
    FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_3);
    _fieldbindings.add(_doubleArrow_1);
    EList<FieldBinding> _fieldbindings_1 = dist.getFieldbindings();
    FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_4 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_5 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "probabilities"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(distType.getMembers(), Field.class), _function_5));
      ArrayRefValue _createArrayRefValue = ExecutionFactory.eINSTANCE.createArrayRefValue();
      final Procedure1<ArrayRefValue> _function_6 = (ArrayRefValue it_1) -> {
        it_1.setInstance(probabilities);
      };
      ArrayRefValue _doubleArrow_2 = ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function_6);
      it.setValue(_doubleArrow_2);
    };
    FieldBinding _doubleArrow_2 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_4);
    _fieldbindings_1.add(_doubleArrow_2);
    final duc.uscript.uScript.Class poissBinIntClass = internalTypeDcl.getPoissBinIntClass(_self);
    final duc.uscript.uScript.Class poissBinTypeClass = internalTypeDcl.getPoissBinClass(_self);
    ObjectInstance _createObjectInstance_1 = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_5 = (ObjectInstance it) -> {
      it.setType(poissBinIntClass);
    };
    final ObjectInstance poissBinInt = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance_1, _function_5);
    state.getObjectsHeap().add(poissBinInt);
    EList<FieldBinding> _fieldbindings_2 = poissBinInt.getFieldbindings();
    FieldBinding _createFieldBinding_2 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_6 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_7 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "confidence"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(poissBinTypeClass.getMembers(), Field.class), _function_7));
      ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
      final Procedure1<ObjectRefValue> _function_8 = (ObjectRefValue it_1) -> {
        it_1.setInstance(dist);
      };
      ObjectRefValue _doubleArrow_3 = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_8);
      it.setValue(_doubleArrow_3);
    };
    FieldBinding _doubleArrow_3 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_2, _function_6);
    _fieldbindings_2.add(_doubleArrow_3);
    EList<FieldBinding> _fieldbindings_3 = poissBinInt.getFieldbindings();
    FieldBinding _createFieldBinding_3 = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_7 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_8 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "value"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(poissBinIntClass.getMembers(), Field.class), _function_8));
      IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
      final Procedure1<IntegerValue> _function_9 = (IntegerValue it_1) -> {
        it_1.setValue(sum[0]);
      };
      IntegerValue _doubleArrow_4 = ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function_9);
      it.setValue(_doubleArrow_4);
    };
    FieldBinding _doubleArrow_4 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_3, _function_7);
    _fieldbindings_3.add(_doubleArrow_4);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_8 = (ObjectRefValue it) -> {
      it.setInstance(poissBinInt);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_8);
  }
  
  protected static ArrayInstance _privk3_bernArrayToDoubleArray(final ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_, final ComputeNbTrueExpr _self, final ArrayRefValue bernArray, final int[] sum) {
    final EList<Value> array = bernArray.getInstance().getValue();
    ArrayInstance _createArrayInstance = ExecutionFactory.eINSTANCE.createArrayInstance();
    final Procedure1<ArrayInstance> _function = (ArrayInstance it) -> {
      it.setSize(array.size());
    };
    final ArrayInstance result = ObjectExtensions.<ArrayInstance>operator_doubleArrow(_createArrayInstance, _function);
    double tmp_sum = 0;
    for (int i = 0; (i < array.size()); i++) {
      {
        Value _get = array.get(i);
        final double prob = BernoulliBoolUtils.getProbability(((ObjectRefValue) _get)).getValue();
        EList<Value> _value = result.getValue();
        DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
        final Procedure1<DoubleValue> _function_1 = (DoubleValue it) -> {
          it.setValue(prob);
        };
        DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_1);
        _value.add(_doubleArrow);
        double _tmp_sum = tmp_sum;
        tmp_sum = (_tmp_sum + prob);
      }
    }
    long _round = Math.round(tmp_sum);
    sum[0] = ((int) _round);
    return result;
  }
  
  protected static double[] _privk3_computePb(final ComputeNbrTrueExprAspectComputeNbTrueExprAspectProperties _self_, final ComputeNbTrueExpr _self, final ArrayRefValue valueExpr) {
    final ArrayInstance instance = valueExpr.getInstance();
    final EList<Value> array = instance.getValue();
    double[] probs = new double[instance.getSize()];
    for (int i = 0; (i < instance.getSize()); i++) {
      {
        Value _get = array.get(i);
        boolean _not = (!(_get instanceof ObjectRefValue));
        if (_not) {
          Class<? extends Value> _class = array.get(i).getClass();
          String _plus = ("ComputeNbTrueExpr.evaluateExpression: type of expression not managed. Expected: ArrayRef. Actual: " + _class);
          throw new RuntimeException(_plus);
        }
        Value _get_1 = array.get(i);
        probs[i] = BernoulliBoolUtils.getProbability(((ObjectRefValue) _get_1)).getValue();
      }
    }
    return Computer.compute(probs);
  }
}
