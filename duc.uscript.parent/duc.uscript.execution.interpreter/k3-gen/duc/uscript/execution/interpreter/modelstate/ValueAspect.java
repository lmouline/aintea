package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Value;
import duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = Value.class)
@SuppressWarnings("all")
public class ValueAspect {
  public static String convertToString(final Value _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect
    		if (_self instanceof duc.uscript.execution.ArrayRefValue){
    			result = duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect.convertToString((duc.uscript.execution.ArrayRefValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.BooleanValueAspect
    		if (_self instanceof duc.uscript.execution.BooleanValue){
    			result = duc.uscript.execution.interpreter.modelstate.BooleanValueAspect.convertToString((duc.uscript.execution.BooleanValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.BooleanValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ByteValueAspect
    		if (_self instanceof duc.uscript.execution.ByteValue){
    			result = duc.uscript.execution.interpreter.modelstate.ByteValueAspect.convertToString((duc.uscript.execution.ByteValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ByteValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.DoubleValueAspect
    		if (_self instanceof duc.uscript.execution.DoubleValue){
    			result = duc.uscript.execution.interpreter.modelstate.DoubleValueAspect.convertToString((duc.uscript.execution.DoubleValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.DoubleValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.FloatValueAspect
    		if (_self instanceof duc.uscript.execution.FloatValue){
    			result = duc.uscript.execution.interpreter.modelstate.FloatValueAspect.convertToString((duc.uscript.execution.FloatValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.FloatValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.IntegerValueAspect
    		if (_self instanceof duc.uscript.execution.IntegerValue){
    			result = duc.uscript.execution.interpreter.modelstate.IntegerValueAspect.convertToString((duc.uscript.execution.IntegerValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.IntegerValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.LongValueAspect
    		if (_self instanceof duc.uscript.execution.LongValue){
    			result = duc.uscript.execution.interpreter.modelstate.LongValueAspect.convertToString((duc.uscript.execution.LongValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.LongValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.NullValueAspect
    		if (_self instanceof duc.uscript.execution.NullValue){
    			result = duc.uscript.execution.interpreter.modelstate.NullValueAspect.convertToString((duc.uscript.execution.NullValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.NullValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect
    		if (_self instanceof duc.uscript.execution.ObjectRefValue){
    			result = duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect.convertToString((duc.uscript.execution.ObjectRefValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ShortValueAspect
    		if (_self instanceof duc.uscript.execution.ShortValue){
    			result = duc.uscript.execution.interpreter.modelstate.ShortValueAspect.convertToString((duc.uscript.execution.ShortValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.ShortValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.StringValueAspect
    		if (_self instanceof duc.uscript.execution.StringValue){
    			result = duc.uscript.execution.interpreter.modelstate.StringValueAspect.convertToString((duc.uscript.execution.StringValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#String convertToString() from duc.uscript.execution.interpreter.modelstate.StringValueAspect
    // #DispatchPointCut_before# String convertToString()
    if (_self instanceof duc.uscript.execution.Value){
    	result = duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_convertToString(_self_, (duc.uscript.execution.Value)_self);
    };
    return (java.lang.String)result;
  }
  
  public static Value copy(final Value _self) {
    final duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ValueAspectValueAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect
    		if (_self instanceof duc.uscript.execution.ArrayRefValue){
    			result = duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect.copy((duc.uscript.execution.ArrayRefValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ArrayRefValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.BooleanValueAspect
    		if (_self instanceof duc.uscript.execution.BooleanValue){
    			result = duc.uscript.execution.interpreter.modelstate.BooleanValueAspect.copy((duc.uscript.execution.BooleanValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.BooleanValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ByteValueAspect
    		if (_self instanceof duc.uscript.execution.ByteValue){
    			result = duc.uscript.execution.interpreter.modelstate.ByteValueAspect.copy((duc.uscript.execution.ByteValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ByteValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.DoubleValueAspect
    		if (_self instanceof duc.uscript.execution.DoubleValue){
    			result = duc.uscript.execution.interpreter.modelstate.DoubleValueAspect.copy((duc.uscript.execution.DoubleValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.DoubleValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.FloatValueAspect
    		if (_self instanceof duc.uscript.execution.FloatValue){
    			result = duc.uscript.execution.interpreter.modelstate.FloatValueAspect.copy((duc.uscript.execution.FloatValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.FloatValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.IntegerValueAspect
    		if (_self instanceof duc.uscript.execution.IntegerValue){
    			result = duc.uscript.execution.interpreter.modelstate.IntegerValueAspect.copy((duc.uscript.execution.IntegerValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.IntegerValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.LongValueAspect
    		if (_self instanceof duc.uscript.execution.LongValue){
    			result = duc.uscript.execution.interpreter.modelstate.LongValueAspect.copy((duc.uscript.execution.LongValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.LongValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.NullValueAspect
    		if (_self instanceof duc.uscript.execution.NullValue){
    			result = duc.uscript.execution.interpreter.modelstate.NullValueAspect.copy((duc.uscript.execution.NullValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.NullValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect
    		if (_self instanceof duc.uscript.execution.ObjectRefValue){
    			result = duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect.copy((duc.uscript.execution.ObjectRefValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ObjectRefValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ShortValueAspect
    		if (_self instanceof duc.uscript.execution.ShortValue){
    			result = duc.uscript.execution.interpreter.modelstate.ShortValueAspect.copy((duc.uscript.execution.ShortValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.ShortValueAspect
    	// BeginInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.StringValueAspect
    		if (_self instanceof duc.uscript.execution.StringValue){
    			result = duc.uscript.execution.interpreter.modelstate.StringValueAspect.copy((duc.uscript.execution.StringValue)_self);
    		} else
    		// EndInjectInto duc.uscript.execution.interpreter.modelstate.ValueAspect#Value copy() from duc.uscript.execution.interpreter.modelstate.StringValueAspect
    // #DispatchPointCut_before# Value copy()
    if (_self instanceof duc.uscript.execution.Value){
    	result = duc.uscript.execution.interpreter.modelstate.ValueAspect._privk3_copy(_self_, (duc.uscript.execution.Value)_self);
    };
    return (duc.uscript.execution.Value)result;
  }
  
  protected static String _privk3_convertToString(final ValueAspectValueAspectProperties _self_, final Value _self) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("convertToString is not defined for ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
  
  protected static Value _privk3_copy(final ValueAspectValueAspectProperties _self_, final Value _self) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("copy is not defined for ");
    String _name = _self.getClass().getName();
    _builder.append(_name);
    throw new RuntimeException(_builder.toString());
  }
}
