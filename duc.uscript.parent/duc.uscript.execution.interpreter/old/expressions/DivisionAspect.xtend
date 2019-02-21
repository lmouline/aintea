package duc.uminijava.semantics.expressions

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Division
import uMiniJavaDynamicData.UDoubleValue
import uMiniJavaDynamicData.UIntegerValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory

@Aspect(className=Division)
class DivisionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		if(left instanceof UIntegerValue) {
			if(right instanceof UIntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = ((left.value/right.value) + (left.value*right.variance)/(right.value*right.value*right.value)) as int
					variance = (left.variance/right.value) + (left.value*left.value*right.variance)/(right.value*right.value*right.value*right.value)
				]
			} else if(right instanceof IntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = left.value / right.value
					variance = (left.variance/right.value)
				]
			} else {
				throw new RuntimeException('''Division operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof UDoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = (left.value/right.value) + (left.value*right.variance)/(right.value*right.value*right.value)
					variance = (left.variance/right.value) + (left.value*left.value*right.variance)/(right.value*right.value*right.value*right.value)
				]
			} else if(right instanceof DoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value / right.value
					variance = (left.variance/right.value)
				]
			} else if(right instanceof IntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value / right.value
					variance = (left.variance/right.value)
				]
			} else {
				throw new RuntimeException('''Division operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof DoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value / right.value
					variance = (left.value*left.value*right.variance)/(right.value*right.value*right.value*right.value)
				]
			} else if(right instanceof DoubleValue) {
				return MinijavadynamicdataFactory.eINSTANCE.createDoubleValue => [
					value = left.value / right.value
				]
			} else {
				throw new RuntimeException('''Division operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [
					value = left.value / right.value
				]
			}
		}
		throw new RuntimeException('''Unsupported Division operands: «left» / «right».''')
	}
}