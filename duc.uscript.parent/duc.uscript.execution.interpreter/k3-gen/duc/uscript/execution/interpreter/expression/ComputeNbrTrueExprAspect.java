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
    ArrayInstance _createArrayInstance = ExecutionFactory.eINSTANCE.createArrayInstance();
    final Procedure1<ArrayInstance> _function = (ArrayInstance it) -> {
      it.setSize(probs.length);
    };
    final ArrayInstance possibilitiesInstance = ObjectExtensions.<ArrayInstance>operator_doubleArrow(_createArrayInstance, _function);
    state.getArraysHeap().add(possibilitiesInstance);
    final duc.uscript.uScript.Class intPossType = internalTypeDcl.getIntPossibilityClass(_self);
    final duc.uscript.uScript.Class possType = internalTypeDcl.getPossibilityClass(_self);
    for (int i = 0; (i < probs.length); i++) {
      {
        ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
        final Procedure1<ObjectInstance> _function_1 = (ObjectInstance it) -> {
          it.setType(intPossType);
        };
        final ObjectInstance probVal = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function_1);
        state.getObjectsHeap().add(probVal);
        final double p = probs[i];
        final int fi = i;
        EList<FieldBinding> _fieldbindings = probVal.getFieldbindings();
        FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
        final Procedure1<FieldBinding> _function_2 = (FieldBinding it) -> {
          final Function1<Field, Boolean> _function_3 = (Field it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equal(_name, "confidence"));
          };
          it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(possType.getMembers(), Field.class), _function_3));
          DoubleValue _createDoubleValue = ExecutionFactory.eINSTANCE.createDoubleValue();
          final Procedure1<DoubleValue> _function_4 = (DoubleValue it_1) -> {
            it_1.setValue(p);
          };
          DoubleValue _doubleArrow = ObjectExtensions.<DoubleValue>operator_doubleArrow(_createDoubleValue, _function_4);
          it.setValue(_doubleArrow);
        };
        FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_2);
        _fieldbindings.add(_doubleArrow);
        EList<FieldBinding> _fieldbindings_1 = probVal.getFieldbindings();
        FieldBinding _createFieldBinding_1 = ExecutionFactory.eINSTANCE.createFieldBinding();
        final Procedure1<FieldBinding> _function_3 = (FieldBinding it) -> {
          final Function1<Field, Boolean> _function_4 = (Field it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equal(_name, "value"));
          };
          it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(intPossType.getMembers(), Field.class), _function_4));
          IntegerValue _createIntegerValue = ExecutionFactory.eINSTANCE.createIntegerValue();
          final Procedure1<IntegerValue> _function_5 = (IntegerValue it_1) -> {
            it_1.setValue(fi);
          };
          IntegerValue _doubleArrow_1 = ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function_5);
          it.setValue(_doubleArrow_1);
        };
        FieldBinding _doubleArrow_1 = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding_1, _function_3);
        _fieldbindings_1.add(_doubleArrow_1);
        EList<Value> _value = possibilitiesInstance.getValue();
        ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
        final Procedure1<ObjectRefValue> _function_4 = (ObjectRefValue it) -> {
          it.setInstance(probVal);
        };
        ObjectRefValue _doubleArrow_2 = ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_4);
        _value.add(_doubleArrow_2);
      }
    }
    final duc.uscript.uScript.Class multPossObjType = internalTypeDcl.getMultChoiceDoubleClass(_self);
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function_1 = (ObjectInstance it) -> {
      it.setType(multPossObjType);
    };
    final ObjectInstance multPossObjIns = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function_1);
    EList<FieldBinding> _fieldbindings = multPossObjIns.getFieldbindings();
    FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
    final Procedure1<FieldBinding> _function_2 = (FieldBinding it) -> {
      final Function1<Field, Boolean> _function_3 = (Field it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "possibilities"));
      };
      it.setField(IterableExtensions.<Field>findFirst(Iterables.<Field>filter(multPossObjType.getMembers(), Field.class), _function_3));
      ArrayRefValue _createArrayRefValue = ExecutionFactory.eINSTANCE.createArrayRefValue();
      final Procedure1<ArrayRefValue> _function_4 = (ArrayRefValue it_1) -> {
        it_1.setInstance(possibilitiesInstance);
      };
      ArrayRefValue _doubleArrow = ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function_4);
      it.setValue(_doubleArrow);
    };
    FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_2);
    _fieldbindings.add(_doubleArrow);
    state.getObjectsHeap().add(multPossObjIns);
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_3 = (ObjectRefValue it) -> {
      it.setInstance(multPossObjIns);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_3);
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
