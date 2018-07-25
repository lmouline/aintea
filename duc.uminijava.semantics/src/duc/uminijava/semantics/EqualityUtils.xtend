package duc.uminijava.semantics

import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.NullValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.StringValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import uMiniJavaDynamicData.UBooleanValue

class EqualityUtils {
	def static boolean equals (Value left, Value right) {
		if (left instanceof IntegerValue) {
			left.value === (right as IntegerValue).value
		} else if (left instanceof StringValue) {
			left.value == (right as StringValue).value
		} else if(left instanceof UBooleanValue) {
			if(right instanceof UBooleanValue) {
				if(left.value == right.value) {
					left.confidence == right.confidence
				} else if(left.value) {
					left.confidence == 1-right.confidence
				} else {
					1-left.confidence == right.confidence
				}
			} else {
				if (left.value == (right as BooleanValue).value) {
					left.confidence == 1
				} else {
					left.confidence == 0
				}
			}
		} else if (left instanceof BooleanValue) {
			if(right instanceof UBooleanValue) {
				if (left.value == right.value) {
					right.confidence == 1
				} else {
					right.confidence == 0
				}
			} else {
				left.value === (right as BooleanValue).value
			}
		} else if (left instanceof NullValue) {
			right instanceof NullValue
		} else if (left instanceof ObjectRefValue) {
			(right instanceof ObjectRefValue) && left.instance === (right as ObjectRefValue).instance
		} else {
			throw new RuntimeException('''Type unsupported for equality operator: «left.class»''')
		}
	}
	
	def static boolean notEquals(Value v1, Value v2) {
		!equals(v1,v2)
	}
}