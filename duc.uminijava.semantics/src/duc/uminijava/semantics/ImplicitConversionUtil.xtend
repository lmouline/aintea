package duc.uminijava.semantics

import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Assignee
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.xtext.miniJava.VariableDeclaration
import org.tetrabox.minijava.xtext.miniJava.BooleanTypeRef
import duc.uminijava.uMiniJava.BernoulliRef
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory
import uMiniJavaDynamicData.UBooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import org.tetrabox.minijava.xtext.miniJava.DoubleTypeRef
import duc.uminijava.uMiniJava.GaussianRef
import uMiniJavaDynamicData.UDoubleValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue

class ImplicitConversionUtil {
	
	def static dispatch Value convert(Value actual, Assignee expected) {
		return actual
	}
		
	def static dispatch Value convert(BooleanValue actual, VariableDeclaration expected) {
		if(!(expected.typeRef instanceof BooleanTypeRef)) {
			switch expected.typeRef {
				BernoulliRef: return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					value = actual.value
					confidence = 1
				]
				default: throw new RuntimeException("Unsupported operation.")
			}
		} else {
			return actual
		}
	}
	
	
	def static dispatch Value convert(UBooleanValue actual, VariableDeclaration expected) {
		if(expected.typeRef instanceof BernoulliRef) {
			return actual
		} else {
			return MinijavadynamicdataFactory.eINSTANCE.createBooleanValue => [
				if(actual.confidence >= 0.5) {
					it.value = actual.value
				} else {
					it.value = !actual.value
				}
			]
		}
	}
	
	def static dispatch Value convert(DoubleValue actual, VariableDeclaration expected) {
		if(!(expected.typeRef instanceof DoubleTypeRef)) {
			switch expected.typeRef {
				GaussianRef: return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = actual.value
					variance = 0
				]
				default: throw new RuntimeException("Unsupported operation.")
			}
		} else {
			return actual
		}
	}
	
	def static dispatch Value convert(UDoubleValue actual, VariableDeclaration expected) {
		if(expected.typeRef instanceof GaussianRef) {
			return actual
		} else {
			return MinijavadynamicdataFactory.eINSTANCE.createDoubleValue => [
				it.value = actual.value
			]
		}
	}
	

	def static dispatch BooleanValue toBool(UBooleanValue value) {
		return MinijavadynamicdataFactory.eINSTANCE.createBooleanValue => [
			if(value.confidence >= 0.5) {
				it.value = value.value
			} else {
				it.value = !value.value
			}
		]
	}
	
	def static dispatch BooleanValue toBool(BooleanValue value) {
		return value
	}
	
	def static dispatch BooleanValue toBool(Value value) {
		throw new RuntimeException("Unsupported double conversion for " + value.getClass().name)
	}
	
	
	
	def static dispatch double toDouble(IntegerValue value) {
		return value.value
	}
	
	def static dispatch double toDouble(DoubleValue value) {
		return value.value
	}
	
	def static dispatch double toDouble(Value value) {
		throw new RuntimeException("Unsupported double conversion for " + value.getClass().name)
	}
}