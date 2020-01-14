package duc.uscript.execution.interpreter.utils;

import com.google.common.base.Objects;
import duc.uscript.execution.ArrayInstance;
import duc.uscript.execution.ArrayRefValue;
import duc.uscript.execution.DoubleValue;
import duc.uscript.execution.FieldBinding;
import duc.uscript.execution.ObjectInstance;
import duc.uscript.execution.Value;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class MultPossibilityUtils {
  public static double[] extractProbs(final ObjectInstance multPossObj) {
    final Function1<FieldBinding, Boolean> _function = (FieldBinding it) -> {
      String _name = it.getField().getName();
      return Boolean.valueOf(Objects.equal(_name, "rootProbs"));
    };
    Value _value = IterableExtensions.<FieldBinding>findFirst(multPossObj.getFieldbindings(), _function).getValue();
    final ArrayInstance rootProbsInst = ((ArrayRefValue) _value).getInstance();
    final double[] result = new double[rootProbsInst.getSize()];
    for (int i = 0; (i < result.length); i++) {
      {
        Value _get = rootProbsInst.getValue().get(i);
        final DoubleValue dblValue = ((DoubleValue) _get);
        result[i] = dblValue.getValue();
      }
    }
    return result;
  }
}
