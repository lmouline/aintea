package duc.uscript.execution.interpreter.utils;

import com.google.common.base.Objects;
import duc.uscript.execution.ArrayInstance;
import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.IntegerValue;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.ObjectRefValue;
import duc.uscript.execution.Value;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class MultPossibilityUtils {
  public static double[] extractProbs(final ObjectInstance poissBinIntObj) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "confidence"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(poissBinIntObj.getFieldbindings(), _function).getValue();
    final ObjectInstance dist = ((ObjectRefValue) _value).getInstance();
    final Function1<FieldBinding, Boolean> _function_1 = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "initBernProbs"));
    };
    Value _value_1 = IterableExtensions.<FieldBinding>findFirst(dist.getFieldbindings(), _function_1).getValue();
    final ArrayInstance initBernProbs = ((ArrayRefValue) _value_1).getInstance();
    final double[] result = new double[initBernProbs.getSize()];
    for (int i = 0; (i < result.length); i++) {
      {
        Value _get = initBernProbs.getValue().get(i);
        final DoubleValue dblValue = ((DoubleValue) _get);
        result[i] = dblValue.getValue();
      }
    }
    return result;
  }
  
  public static int extractValue(final ObjectInstance poissBinIntObj) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "value"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(poissBinIntObj.getFieldbindings(), _function).getValue();
    return ((IntegerValue) _value).getValue();
  }
}
