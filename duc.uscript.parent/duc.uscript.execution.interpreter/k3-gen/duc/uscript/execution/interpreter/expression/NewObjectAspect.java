package duc.uscript.execution.interpreter.expression;

import com.google.common.collect.Iterables;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectProperties;
import duc.uscript.uScript.Expression;
import duc.uscript.uScript.Field;
import duc.uscript.uScript.NewObject;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = NewObject.class)
@SuppressWarnings("all")
public class NewObjectAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final NewObject _self, final State state) {
    final duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Value evaluateExpression(State)
    if (_self instanceof duc.uscript.uScript.NewObject){
    	result = duc.uscript.execution.interpreter.expression.NewObjectAspect._privk3_evaluateExpression(_self_, (duc.uscript.uScript.NewObject)_self,state);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  @OverrideAspectMethod
  public static SymbolSet findDependentVariables(final NewObject _self, final State state) {
    final duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectProperties _self_ = duc.uscript.execution.interpreter.expression.NewObjectAspectNewObjectAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolSet findDependentVariables(State)
    if (_self instanceof duc.uscript.uScript.NewObject){
    	result = duc.uscript.execution.interpreter.expression.NewObjectAspect._privk3_findDependentVariables(_self_, (duc.uscript.uScript.NewObject)_self,state);
    };
    return (duc.uscript.utils.SymbolSet)result;
  }
  
  private static Value super_evaluateExpression(final NewObject _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NewObjectAspectNewObjectAspectProperties _self_, final NewObject _self, final State state) {
    ObjectInstance _createObjectInstance = ExecutionFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function = (ObjectInstance it) -> {
      it.setType(_self.getType());
    };
    final ObjectInstance result = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function);
    state.getObjectsHeap().add(result);
    final Function1<Field, Boolean> _function_1 = (Field it) -> {
      Expression _defaultValue = it.getDefaultValue();
      return Boolean.valueOf((_defaultValue != null));
    };
    final Iterable<Field> fields = IterableExtensions.<Field>filter(Iterables.<Field>filter(_self.getType().getMembers(), Field.class), _function_1);
    for (final Field f : fields) {
      {
        final Value defaultValue = ExpressionAspect.evaluateExpression(f.getDefaultValue(), state);
        EList<FieldBinding> _fieldbindings = result.getFieldbindings();
        FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
        final Procedure1<FieldBinding> _function_2 = (FieldBinding it) -> {
          it.setField(f);
          it.setValue(defaultValue);
        };
        FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_2);
        _fieldbindings.add(_doubleArrow);
      }
    }
    ObjectRefValue _createObjectRefValue = ExecutionFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_2 = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_2);
  }
  
  private static SymbolSet super_findDependentVariables(final NewObject _self, final State state) {
    final duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectProperties _self_ = duc.uscript.execution.interpreter.expression.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  duc.uscript.execution.interpreter.expression.ExpressionAspect._privk3_findDependentVariables(_self_, _self,state);
  }
  
  protected static SymbolSet _privk3_findDependentVariables(final NewObjectAspectNewObjectAspectProperties _self_, final NewObject _self, final State state) {
    final SymbolSet result = new SymbolSet();
    EList<Expression> _args = _self.getArgs();
    for (final Expression arg : _args) {
      result.addAll(ExpressionAspect.findDependentVariables(arg, state));
    }
    return result;
  }
}
