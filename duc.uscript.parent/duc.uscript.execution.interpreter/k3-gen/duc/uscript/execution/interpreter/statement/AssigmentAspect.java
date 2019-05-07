package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.ArrayInstance;
import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.Context;
import duc.uscript.execution.ExecutionFactory;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.State;
import duc.uscript.execution.SymbolBindings;
import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.expression.ExpressionAspect;
import duc.uscript.execution.interpreter.expression.MethodCall2Aspect;
import duc.uscript.execution.interpreter.modelstate.ContextAspect;
import duc.uscript.execution.interpreter.modelstate.StateAspect;
import duc.uscript.execution.interpreter.modelstate.ValueAspect;
import duc.uscript.execution.interpreter.statement.AStatementAspect;
import duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectProperties;
import duc.uscript.uScript.ArrayAccess;
import duc.uscript.uScript.Assignee;
import duc.uscript.uScript.Assignment;
import duc.uscript.uScript.Field;
import duc.uscript.uScript.FieldAccess;
import duc.uscript.uScript.MethodCall2;
import duc.uscript.uScript.Symbol;
import duc.uscript.uScript.SymbolRef;
import duc.uscript.uScript.VariableDeclaration;
import duc.uscript.utils.Range;
import duc.uscript.utils.SymbolSet;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Aspect(className = Assignment.class)
@SuppressWarnings("all")
public class AssigmentAspect extends AStatementAspect {
  @OverrideAspectMethod
  public static void evaluateStatement(final Assignment _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AssigmentAspectAssignmentAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void evaluateStatement(State)
    if (_self instanceof duc.uscript.uScript.Assignment){
    	duc.uscript.execution.interpreter.statement.AssigmentAspect._privk3_evaluateStatement(_self_, (duc.uscript.uScript.Assignment)_self,state);
    };
  }
  
  private static void super_evaluateStatement(final Assignment _self, final State state) {
    final duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectProperties _self_ = duc.uscript.execution.interpreter.statement.AStatementAspectStatementAspectContext.getSelf(_self);
     duc.uscript.execution.interpreter.statement.AStatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final AssigmentAspectAssignmentAspectProperties _self_, final Assignment _self, final State state) {
    try {
      final Context context = StateAspect.findCurrentContext(state);
      final Assignee assignee = _self.getAssignee();
      final Value right = ValueAspect.copy(ExpressionAspect.evaluateExpression(_self.getValue(), state));
      final SymbolSet dependences = ExpressionAspect.findDependentVariables(_self.getValue(), state);
      final Range valueRange = ExpressionAspect.findRange(_self.getValue(), state);
      boolean _matched = false;
      if (assignee instanceof SymbolRef) {
        _matched=true;
        final SymbolBindings existingBinding = ContextAspect.findBinding(context, ((SymbolRef)assignee).getSymbol());
        existingBinding.setValue(right);
        SymbolSet _symbolSet = existingBinding.getSymbolSet();
        boolean _tripleNotEquals = (_symbolSet != null);
        if (_tripleNotEquals) {
          existingBinding.getSymbolSet().clear();
        }
        existingBinding.setSymbolSet(dependences);
        existingBinding.setRange(valueRange);
      }
      if (!_matched) {
        if (assignee instanceof VariableDeclaration) {
          _matched=true;
          SymbolBindings _createSymbolBindings = ExecutionFactory.eINSTANCE.createSymbolBindings();
          final Procedure1<SymbolBindings> _function = (SymbolBindings it) -> {
            it.setSymbol(((Symbol)assignee));
            it.setValue(right);
            it.setSymbolSet(dependences);
            it.setRange(valueRange);
          };
          final SymbolBindings binding = ObjectExtensions.<SymbolBindings>operator_doubleArrow(_createSymbolBindings, _function);
          context.getBindings().add(binding);
        }
      }
      if (!_matched) {
        if (assignee instanceof MethodCall2) {
          _matched=true;
          MethodCall2Aspect.evaluateExpression(((MethodCall2)assignee), state);
        }
      }
      if (!_matched) {
        if (assignee instanceof FieldAccess) {
          _matched=true;
          Field _field = ((FieldAccess)assignee).getField();
          final Field f = ((Field) _field);
          Value _evaluateExpression = ExpressionAspect.evaluateExpression(((FieldAccess)assignee).getReceiver(), state);
          final ObjectInstance realReceiver = ((ObjectRefValue) _evaluateExpression).getInstance();
          final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
            Field _field_1 = it.getField();
            return Boolean.valueOf((_field_1 == f));
          };
          final FieldBinding existingBinding = IterableExtensions.<FieldBinding>findFirst(realReceiver.getFieldbindings(), _function);
          if ((existingBinding != null)) {
            existingBinding.setValue(right);
          } else {
            FieldBinding _createFieldBinding = ExecutionFactory.eINSTANCE.createFieldBinding();
            final Procedure1<FieldBinding> _function_1 = (FieldBinding it) -> {
              it.setField(f);
              it.setValue(right);
            };
            final FieldBinding binding = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_1);
            realReceiver.getFieldbindings().add(binding);
          }
        }
      }
      if (!_matched) {
        if (assignee instanceof ArrayAccess) {
          _matched=true;
          Value _evaluateExpression = ExpressionAspect.evaluateExpression(((ArrayAccess)assignee).getObject(), state);
          final ArrayInstance array = ((ArrayRefValue) _evaluateExpression).getInstance();
          Value _evaluateExpression_1 = ExpressionAspect.evaluateExpression(((ArrayAccess)assignee).getIndex(), state);
          final int index = ((IntegerValue) _evaluateExpression_1).getValue();
          array.getValue().set(index, right);
        }
      }
      if (!_matched) {
        throw new Exception(("Cannot assign a value to " + assignee));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
