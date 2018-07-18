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

class UMiniJavaTypeComputer extends MiniJavaTypeComputer{

	public static val BERNOULLI_TYPE = factory.createClass => [name = 'bernoulliType']
	public static val GAUSSIAN_TYPE = factory.createClass => [name = 'gaussianType']

	override TypeDeclaration getType(TypeRef r) {
		switch r {
			GaussianRef: GAUSSIAN_TYPE
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
		BOOLEAN_TYPE
	}
	
	def dispatch TypeDeclaration typeFor(Inequality ineq) {
		if(ineq.left.typeFor === BERNOULLI_TYPE || ineq.right.typeFor === BERNOULLI_TYPE) {
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
		
}