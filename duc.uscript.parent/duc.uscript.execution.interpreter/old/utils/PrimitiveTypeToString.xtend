package duc.uminijava.semantics.utils

import org.tetrabox.minijava.xtext.miniJava.BooleanTypeRef
import org.tetrabox.minijava.xtext.miniJava.ByteTypeRef
import org.tetrabox.minijava.xtext.miniJava.CharTypeRef
import org.tetrabox.minijava.xtext.miniJava.DoubleTypeRef
import org.tetrabox.minijava.xtext.miniJava.FloatTypeRef
import org.tetrabox.minijava.xtext.miniJava.IntegerTypeRef
import org.tetrabox.minijava.xtext.miniJava.LongTypeRef
import org.tetrabox.minijava.xtext.miniJava.ShortTypeRef

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