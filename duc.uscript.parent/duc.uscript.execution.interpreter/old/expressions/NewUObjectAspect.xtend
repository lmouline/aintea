package duc.uminijava.semantics.expressions

import duc.uminijava.uMiniJava.BernoulliRef
import duc.uminijava.uMiniJava.GaussianRef
import duc.uminijava.uMiniJava.NewUObject
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.LongValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.ByteTypeRef
import org.tetrabox.minijava.xtext.miniJava.DoubleTypeRef
import org.tetrabox.minijava.xtext.miniJava.FloatTypeRef
import org.tetrabox.minijava.xtext.miniJava.IntegerTypeRef
import org.tetrabox.minijava.xtext.miniJava.LongTypeRef
import org.tetrabox.minijava.xtext.miniJava.ShortTypeRef
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

import static extension duc.uminijava.semantics.ImplicitConversionUtil.*

@Aspect(className=NewUObject)
class NewUObjectAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val conf = if(_self.args.length == 1) {
			1
		} else {
			(_self.args.get(1).evaluateExpression(state) as DoubleValue).value
		}
				
		if(_self.type instanceof BernoulliRef) {
			return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
				value = (_self.args.get(0).evaluateExpression(state) as BooleanValue).value
				confidence = conf
			]
		} else if(_self.type instanceof GaussianRef) {
			if(_self.type.genericType instanceof IntegerTypeRef) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = (_self.args.get(0).evaluateExpression(state) as IntegerValue).value
					variance = conf
				]
			} else if(_self.type.genericType instanceof DoubleTypeRef) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = _self.args.get(0).evaluateExpression(state).toDouble
					variance = conf
				]
			} else if(_self.type.genericType instanceof LongTypeRef) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createULongValue => [
					value = (_self.args.get(0).evaluateExpression(state) as LongValue).value
					variance = conf
				]
			} else if(_self.type.genericType instanceof ShortTypeRef) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUShortValue => [
					value = ((_self.args.get(0).evaluateExpression(state) as IntegerValue).value) as short
					variance = conf
				]
			} else if(_self.type.genericType instanceof ByteTypeRef) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUByteValue => [
					value = ((_self.args.get(0).evaluateExpression(state) as IntegerValue).value) as byte
					variance = conf
				]
			} else if(_self.type.genericType instanceof FloatTypeRef) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUFloatValue => [
					value = ((_self.args.get(0).evaluateExpression(state) as DoubleValue).value) as float
					variance = conf
				]
			} else {
				throw new RuntimeException("Not yet supported");
			}
		}
		throw new RuntimeException("Not yet supported");
	
	
	}
}
