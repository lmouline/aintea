package duc.uminijava.typing

import org.tetrabox.minijava.xtext.miniJava.And
import org.tetrabox.minijava.xtext.miniJava.ArrayAccess
import org.tetrabox.minijava.xtext.miniJava.ArrayLength
import org.tetrabox.minijava.xtext.miniJava.Assignment
import org.tetrabox.minijava.xtext.miniJava.BoolConstant
import org.tetrabox.minijava.xtext.miniJava.BooleanTypeRef
import org.tetrabox.minijava.xtext.miniJava.ClassRef
import org.tetrabox.minijava.xtext.miniJava.Division
import org.tetrabox.minijava.xtext.miniJava.Equality
import org.tetrabox.minijava.xtext.miniJava.Expression
import org.tetrabox.minijava.xtext.miniJava.FieldAccess
import org.tetrabox.minijava.xtext.miniJava.InferiorOrEqual
import org.tetrabox.minijava.xtext.miniJava.IntConstant
import org.tetrabox.minijava.xtext.miniJava.IntegerTypeRef
import org.tetrabox.minijava.xtext.miniJava.Method
import org.tetrabox.minijava.xtext.miniJava.MethodCall
import org.tetrabox.minijava.xtext.miniJava.MiniJavaFactory
import org.tetrabox.minijava.xtext.miniJava.Minus
import org.tetrabox.minijava.xtext.miniJava.Multiplication
import org.tetrabox.minijava.xtext.miniJava.Neg
import org.tetrabox.minijava.xtext.miniJava.NewArray
import org.tetrabox.minijava.xtext.miniJava.NewObject
import org.tetrabox.minijava.xtext.miniJava.Not
import org.tetrabox.minijava.xtext.miniJava.Null
import org.tetrabox.minijava.xtext.miniJava.Or
import org.tetrabox.minijava.xtext.miniJava.Plus
import org.tetrabox.minijava.xtext.miniJava.Return
import org.tetrabox.minijava.xtext.miniJava.StringConstant
import org.tetrabox.minijava.xtext.miniJava.StringTypeRef
import org.tetrabox.minijava.xtext.miniJava.Super
import org.tetrabox.minijava.xtext.miniJava.SuperiorOrEqual
import org.tetrabox.minijava.xtext.miniJava.SymbolRef
import org.tetrabox.minijava.xtext.miniJava.This
import org.tetrabox.minijava.xtext.miniJava.TypeDeclaration
import org.tetrabox.minijava.xtext.miniJava.TypeRef
import org.tetrabox.minijava.xtext.miniJava.VariableDeclaration
import org.tetrabox.minijava.xtext.miniJava.VoidTypeRef
import org.tetrabox.minijava.xtext.miniJava.MiniJavaPackage
import org.tetrabox.minijava.xtext.miniJava.Class

import static extension org.eclipse.xtext.EcoreUtil2.*
import duc.uminijava.uMiniJava.GaussianRef
import duc.uminijava.uMiniJava.BernoulliRef
import duc.uminijava.uMiniJava.NewUObject

class UMiniJavaTypeComputer {
	static val factory = MiniJavaFactory.eINSTANCE
	
	public static val STRING_TYPE = factory.createClass => [name = 'stringType']
	public static val INT_TYPE = factory.createClass => [name = 'intType']
	public static val BOOLEAN_TYPE = factory.createClass => [name = 'booleanType']
	public static val NULL_TYPE = factory.createClass => [name = 'nullType']
	public static val BERNOULLI_TYPE = factory.createClass => [name = 'bernoulliType']
	public static val GAUSSIAN_TYPE = factory.createClass => [name = 'gaussianType']

	static val ep = MiniJavaPackage.eINSTANCE

	def TypeDeclaration getType(TypeRef r) {
		switch r {
			ClassRef: r.referencedClass
			IntegerTypeRef: INT_TYPE
			BooleanTypeRef: BOOLEAN_TYPE
			StringTypeRef: STRING_TYPE
			VoidTypeRef : NULL_TYPE
			GaussianRef: GAUSSIAN_TYPE
			BernoulliRef: BERNOULLI_TYPE
		}
	}

	def dispatch TypeDeclaration typeFor(Expression e) {
		println('''Type? «e»''')
		switch (e) {
			SymbolRef:
				e.symbol.typeRef.type
			FieldAccess:
				e.field.typeRef.type
			MethodCall:
				e.method.typeRef.type
			NewObject:
				e.type
			This:
				e.getContainerOfType(Class)
			Super:
				e.getContainerOfType(Class).superClass
			Null:
				NULL_TYPE
			StringConstant:
				STRING_TYPE
			IntConstant: {
				println("return int")
				return INT_TYPE
			}
			BoolConstant:
				BOOLEAN_TYPE
			Not:
				BOOLEAN_TYPE
			Neg:
				INT_TYPE
			Or:
				BOOLEAN_TYPE
			And:
				BOOLEAN_TYPE
			Equality:
				BOOLEAN_TYPE
			SuperiorOrEqual:
				BOOLEAN_TYPE
			InferiorOrEqual:
				BOOLEAN_TYPE
			Minus:
				INT_TYPE
			Multiplication:
				INT_TYPE
			Division:
				INT_TYPE
			ArrayAccess:
				typeFor(e.object)
			ArrayLength:
				typeFor(e.array)
			NewArray:
				getType(e.type)
			NewUObject:
				getType(e.type)
			default: {
				println("Default")
				null
			}
				
		}
	}
	
	def dispatch TypeDeclaration typeFor(Plus e) {
		val leftType = e.left.typeFor
		val rightType = e.right.typeFor
		
		if(leftType === STRING_TYPE || rightType === STRING_TYPE) {
			return STRING_TYPE
		}
		return INT_TYPE
	}


	def isPrimitive(TypeDeclaration c) {
		c.eResource === null
	}

	def TypeDeclaration expectedType(Expression e) {
		val c = e.eContainer
		val f = e.eContainingFeature
		switch (c) {
			VariableDeclaration:
				c.typeRef.type
			Assignment case f == ep.assignment_Value: {
				val assignee = c.assignee
				switch (assignee) {
					VariableDeclaration: assignee.typeRef.type
					FieldAccess: assignee.typeFor
				}
			}
			Return:
				c.getContainerOfType(Method).typeRef.type
			case f == ep.ifStatement_Expression:
				BOOLEAN_TYPE
			MethodCall case f == ep.methodCall_Args: {
				if (c.method !== null) {
				if (c.method.params.size > c.args.indexOf(e))
					c.method.params.get(c.args.indexOf(e)).typeRef.type
				}
			}
			NewObject case f == ep.newObject_Args: {
				c.type.members.filter(Method).findFirst[it.name === null && it.params.size === c.args.size].params.get(c.args.indexOf(e)).typeRef.type
			}
		}
	}
	
}