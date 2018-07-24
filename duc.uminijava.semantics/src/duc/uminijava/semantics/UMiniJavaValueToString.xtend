package duc.uminijava.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.StringValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance
import uMiniJavaDynamicData.UObjectInstance
import duc.uminijava.uMiniJava.BernoulliRef
import duc.uminijava.uMiniJava.GaussianRef
import org.tetrabox.minijava.xtext.miniJava.IntegerTypeRef
import org.tetrabox.minijava.xtext.miniJava.BooleanTypeRef
import org.tetrabox.minijava.xtext.miniJava.DoubleTypeRef
import org.tetrabox.minijava.xtext.miniJava.FloatTypeRef
import org.tetrabox.minijava.xtext.miniJava.ShortTypeRef
import org.tetrabox.minijava.xtext.miniJava.ByteTypeRef
import org.tetrabox.minijava.xtext.miniJava.LongTypeRef
import org.tetrabox.minijava.xtext.miniJava.CharTypeRef

import static extension duc.uminijava.semantics.PrimitiveTypeToString.*
import uMiniJavaDynamicData.UBooleanValue

@Aspect(className=Value)
class ValueToStringAspect {
	def String customToString() {}
}

class PrimitiveTypeToString {
	def static dispatch primitiveToString(IntegerTypeRef type) {
		return "int"
	}
	
	def static dispatch primitiveToString(BooleanTypeRef type) {
		return "boolean"
	}
	
	def static dispatch primitiveToString(DoubleTypeRef type) {
		return "double"
	}
	
	def static dispatch primitiveToString(FloatTypeRef type) {
		return "float"
	}
	
	def static dispatch primitiveToString(ShortTypeRef type) {
		return "short"
	}
	
	def static dispatch primitiveToString(ByteTypeRef type) {
		return "byte"
	}
	
	def static dispatch primitiveToString(LongTypeRef type) {
		return "long"
	}
	
	def static dispatch primitiveToString(CharTypeRef type) {
		return "char"
	}
}

@Aspect(className=ObjectRefValue)
class ObjectRefValueToStringAspect extends ValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		switch _self.instance {
			UObjectInstance: {
				val casted = _self.instance as UObjectInstance
				if(casted.UType instanceof GaussianRef) {
					return '''Gaussian<«casted.UType.genericType.primitiveToString»> {value=true, confidence=1}'''
				} else if(casted.UType instanceof BernoulliRef) {
					return '''Bernoulli<«casted.UType.genericType.primitiveToString»> {value=true, confidence=1}'''
				} else {
					return casted.UType.getClass().name
				}
			}
			ObjectInstance: {
				return '''«_self.instance.type.name» {«FOR b : _self.instance.fieldbindings SEPARATOR "\n\t"»«b.field.name»: «b.value.customToString »«ENDFOR»}''';
			}
			default: "nothing :("
		}
	}
}

@Aspect(className=IntegerValue)
class IntegerValueToStringAspect extends ValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		return _self.value.toString
	}
}

@Aspect(className=BooleanValue)
class BooleanValueToStringAspect extends ValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		return _self.value.toString
	}
}

@Aspect(className=UBooleanValue)
class UBooleanValueToStringAspect extends BooleanValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		return '''(«_self.value.toString», «_self.confidence.toString»)'''
	}
}

@Aspect(className=StringValue)
class StringValueToStringAspect extends ValueToStringAspect {
	@OverrideAspectMethod
	def String customToString() {
		return _self.value.toString
	}
}
