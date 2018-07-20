package duc.uminijava.typing

import org.tetrabox.minijava.xtext.miniJava.TypeDeclaration
import org.tetrabox.minijava.xtext.miniJava.TypeRef

import duc.uminijava.uMiniJava.GaussianRef
import duc.uminijava.uMiniJava.BernoulliRef
import duc.uminijava.uMiniJava.NewUObject
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeComputer
import duc.uminijava.uMiniJava.ArrayTypeRef
import org.tetrabox.minijava.xtext.miniJava.IntegerTypeRef
import org.tetrabox.minijava.xtext.miniJava.BooleanTypeRef
import org.tetrabox.minijava.xtext.miniJava.StringTypeRef
import org.tetrabox.minijava.xtext.miniJava.ClassRef
import org.tetrabox.minijava.xtext.miniJava.Or
import org.tetrabox.minijava.xtext.miniJava.And
import org.tetrabox.minijava.xtext.miniJava.Not
import org.tetrabox.minijava.xtext.miniJava.Equality
import org.tetrabox.minijava.xtext.miniJava.Inequality
import org.tetrabox.minijava.xtext.miniJava.LongTypeRef
import org.tetrabox.minijava.xtext.miniJava.ShortTypeRef
import org.tetrabox.minijava.xtext.miniJava.ByteTypeRef
import org.tetrabox.minijava.xtext.miniJava.DoubleTypeRef
import org.tetrabox.minijava.xtext.miniJava.FloatTypeRef
import com.google.inject.Inject
import org.tetrabox.minijava.xtext.miniJava.SuperiorOrEqual
import org.tetrabox.minijava.xtext.miniJava.InferiorOrEqual
import org.tetrabox.minijava.xtext.miniJava.Superior
import org.tetrabox.minijava.xtext.miniJava.Inferior
import duc.uminijava.uMiniJava.ExistExpr
import org.tetrabox.minijava.xtext.miniJava.Plus

class UMiniJavaTypeComputer extends MiniJavaTypeComputer{
	
	@Inject
	extension UMiniJavaTypeConformance
	
	public static val UNCERTAIN_TYPE = factory.createClass => [name = 'bernoulliType']

	public static val BERNOULLI_TYPE = factory.createClass => [
		name = 'bernoulliType'
		superClass = UNCERTAIN_TYPE
	]
	
	public static val GAUSSIAN_TYPE = factory.createClass => [
		name = 'gaussianType'
		superClass = UNCERTAIN_TYPE
	]
	
	public static val GAUSSIAN_LONG_TYPE = factory.createClass => [
		name = 'gaussianLongType'
		superClass = GAUSSIAN_TYPE
	]
	public static val GAUSSIAN_INT_TYPE = factory.createClass => [
		name = 'gaussianIntType'
		superClass = GAUSSIAN_LONG_TYPE
	]
	public static val GAUSSIAN_SHORT_TYPE = factory.createClass => [
		name = 'gaussianShortType'
		superClass = GAUSSIAN_INT_TYPE
	]
	public static val GAUSSIAN_BYTE_TYPE = factory.createClass => [
		name = 'gaussianByteType'
		superClass = GAUSSIAN_SHORT_TYPE
	]
	
	public static val GAUSSIAN_DOUBLE_TYPE = factory.createClass => [
		name = 'gaussianDoubleType'
		superClass = GAUSSIAN_TYPE
	]
	public static val GAUSSIAN_FLOAT_TYPE = factory.createClass => [
		name = 'gaussianFloatType'
		superClass = GAUSSIAN_DOUBLE_TYPE
	]

	override TypeDeclaration getType(TypeRef r) {
		switch r {
			GaussianRef: {
				switch r.genericType {
					LongTypeRef: GAUSSIAN_LONG_TYPE
					IntegerTypeRef: GAUSSIAN_INT_TYPE
					ShortTypeRef: GAUSSIAN_SHORT_TYPE
					ByteTypeRef: GAUSSIAN_BYTE_TYPE
					DoubleTypeRef: GAUSSIAN_DOUBLE_TYPE
					FloatTypeRef: GAUSSIAN_FLOAT_TYPE
				}
			}
			BernoulliRef: BERNOULLI_TYPE
			ArrayTypeRef: switch(r.typeRef) {
					IntegerTypeRef: INT_ARRAY_TYPE
					BooleanTypeRef: BOOLEAN_ARRAY_TYPE
					StringTypeRef: STRING_ARRAY_TYPE
					ClassRef: getOrCreateClassRefType(r.typeRef as ClassRef)
				}
			default: super.getType(r)
		}
	}

	def dispatch TypeDeclaration typeFor(NewUObject e) {
		getType(e.type)	
	}
	
	def dispatch TypeDeclaration typeFor(Or or) {
		if(or.left.typeFor === BERNOULLI_TYPE || or.right.typeFor === BERNOULLI_TYPE) {
			return BERNOULLI_TYPE
		}
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(And and) {
		if(and.left.typeFor === BERNOULLI_TYPE || and.right.typeFor === BERNOULLI_TYPE) {
			return BERNOULLI_TYPE
		}
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(Equality eq) {
		if(eq.left.typeFor === BERNOULLI_TYPE || eq.right.typeFor === BERNOULLI_TYPE) {
			return BERNOULLI_TYPE
		}
		
		if(eq.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || eq.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(Inequality ineq) {
		if(ineq.left.typeFor === BERNOULLI_TYPE || ineq.right.typeFor === BERNOULLI_TYPE) {
			return BERNOULLI_TYPE
		}
		
		if(ineq.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || ineq.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
			
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(SuperiorOrEqual supEq) {		
		if(supEq.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || supEq.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		if(supEq.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || supEq.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(InferiorOrEqual infEq) {		
		if(infEq.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || infEq.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		if(infEq.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || infEq.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(Superior sup) {		
		if(sup.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || sup.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		if(sup.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || sup.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(Inferior inf) {		
		if(inf.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || inf.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
		
		if(inf.left.typeFor.isSubclassOf(GAUSSIAN_TYPE) || inf.right.typeFor.isSubclassOf(GAUSSIAN_TYPE)) {
			return BERNOULLI_TYPE
		}
			
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(Not not) {
		if(not.expression.typeFor === BERNOULLI_TYPE) {
			return BERNOULLI_TYPE
		}
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(ExistExpr existExpr) {
		BOOLEAN_TYPE
	}
	
	def boolean getIsUncertainType(TypeDeclaration declaration) {
		declaration.isSubclassOf(UNCERTAIN_TYPE)
	}
	
	override dispatch typeFor(Plus plus) {
		val leftType = plus.left.typeFor
		val rightType = plus.right.typeFor
		
		if(leftType === GAUSSIAN_DOUBLE_TYPE || rightType === GAUSSIAN_DOUBLE_TYPE) {
			return GAUSSIAN_DOUBLE_TYPE
		}
		
		if(leftType === GAUSSIAN_FLOAT_TYPE || rightType === GAUSSIAN_FLOAT_TYPE) {
			return GAUSSIAN_FLOAT_TYPE
		}
		
		if(leftType === GAUSSIAN_LONG_TYPE || rightType === GAUSSIAN_LONG_TYPE) {
			return GAUSSIAN_LONG_TYPE
		}
		
		if(leftType === GAUSSIAN_INT_TYPE || rightType === GAUSSIAN_INT_TYPE) {
			return GAUSSIAN_DOUBLE_TYPE
		}
		
		if(leftType === GAUSSIAN_SHORT_TYPE || rightType === GAUSSIAN_SHORT_TYPE) {
			return GAUSSIAN_SHORT_TYPE
		}
		
		if(leftType === GAUSSIAN_BYTE_TYPE || rightType === GAUSSIAN_BYTE_TYPE) {
			return GAUSSIAN_DOUBLE_TYPE
		}
		
		if(leftType === STRING_TYPE || rightType === STRING_TYPE) {
			return STRING_TYPE
		} 
			
		if(leftType === DOUBLE_TYPE || rightType === DOUBLE_TYPE) {
			return DOUBLE_TYPE
		}
		
		if(leftType === FLOAT_TYPE || rightType === FLOAT_TYPE) {
			return FLOAT_TYPE
		}
		
		if(leftType === LONG_TYPE || rightType === LONG_TYPE) {
			return LONG_TYPE
		}
		
		if(leftType === INT_TYPE || rightType === INT_TYPE) {
			return INT_TYPE
		}
		
		if(leftType === SHORT_TYPE || rightType === SHORT_TYPE) {
			return SHORT_TYPE
		}
		
		return BYTE_TYPE
	}
		
}