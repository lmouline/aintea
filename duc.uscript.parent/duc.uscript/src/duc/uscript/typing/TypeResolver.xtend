package duc.uscript.typing

import duc.uscript.uScript.Expression
import duc.uscript.uScript.Or
import duc.uscript.uScript.Class

import static duc.uscript.typing.InternalTypeDcl.*
import static duc.uscript.typing.TypeConcordance.*
import duc.uscript.uScript.And
import duc.uscript.uScript.Equality
import duc.uscript.uScript.Inequality
import duc.uscript.uScript.SuperiorOrEqual
import duc.uscript.uScript.InferiorOrEqual
import duc.uscript.uScript.Superior
import duc.uscript.uScript.Inferior
import duc.uscript.uScript.Plus
import duc.uscript.uScript.Minus
import duc.uscript.uScript.Multiplication
import duc.uscript.uScript.Division
import duc.uscript.uScript.ArrayAccess
import duc.uscript.uScript.ArrayLength
import duc.uscript.uScript.Not
import duc.uscript.uScript.Neg
import duc.uscript.uScript.FieldAccess
import duc.uscript.uScript.TypeRef
import duc.uscript.uScript.ClassRef
import duc.uscript.uScript.IntegerTypeRef
import duc.uscript.uScript.BooleanTypeRef
import duc.uscript.uScript.StringTypeRef
import duc.uscript.uScript.VoidTypeRef
import duc.uscript.uScript.FloatTypeRef
import duc.uscript.uScript.CharTypeRef
import duc.uscript.uScript.ShortTypeRef
import duc.uscript.uScript.DoubleTypeRef
import duc.uscript.uScript.ByteTypeRef
import duc.uscript.uScript.LongTypeRef
import duc.uscript.uScript.ArrayTypeRef
import duc.uscript.uScript.MethodCall
import duc.uscript.uScript.IntConstant
import duc.uscript.uScript.LongConstant
import duc.uscript.uScript.DoubleConstant
import duc.uscript.uScript.BoolConstant
import duc.uscript.uScript.StringConstant
import duc.uscript.uScript.Null
import duc.uscript.uScript.NewUObject
import duc.uscript.uScript.GaussianRef
import duc.uscript.uScript.BernoulliRef
import duc.uscript.uScript.RayleighRef
import duc.uscript.uScript.DiracRef
import duc.uscript.uScript.SymbolRef
import duc.uscript.uScript.ExistExpr
import duc.uscript.uScript.NewObject
import duc.uscript.uScript.MethodCall2

class TypeResolver {
		
	def static dispatch Class type(Expression e) {
		throw new RuntimeException('''Expression «e» not condisered in the type resolver''')
	}
	
	def static dispatch Class type(Void e) {
		return NULL_TYPE
	}
	
	private static def Class typeBoolExpr(Class left, Class right) {
		if(left === BERNOULLI_TYPE || right === BERNOULLI_TYPE) {
			return BERNOULLI_TYPE
		}
		
		return BOOLEAN_TYPE
	}
	
	def static dispatch Class type(Or e) {
		typeBoolExpr(e.left.type, e.right.type)
	}
	
	def static dispatch Class type(And e) {
		typeBoolExpr(e.left.type, e.right.type)
	}
	
	def static dispatch Class type(Equality eq) {
		typeBoolExpr(eq.left.type, eq.right.type)
	}
	
	def static dispatch Class type(Inequality ineq) {
		typeBoolExpr(ineq.left.type, ineq.right.type)
	}
	
	private static def Class typeComparisonExpr(Class left, Class right) {
		 if(isCertainNumber(left) && isCertainNumber(right)) {
			return BOOLEAN_TYPE
		}
		
		return BERNOULLI_TYPE
	}
	
	def static dispatch Class type(SuperiorOrEqual comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	def static dispatch Class type(InferiorOrEqual comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	def static dispatch Class type(Superior comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	def static dispatch Class type(Inferior comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	private static def Class certainTypeArth(Class left, Class right) {
		if(left === DOUBLE_TYPE || right === DOUBLE_TYPE) {
			return DOUBLE_TYPE
		}
		
		if(left === FLOAT_TYPE || right === FLOAT_TYPE) {
			return FLOAT_TYPE
		}
		
		if(left === LONG_TYPE || right === LONG_TYPE) {
			return LONG_TYPE
		}
		
		if(left === INT_TYPE || right === INT_TYPE) {
			return INT_TYPE
		}
		
		if(left === SHORT_TYPE || right === SHORT_TYPE) {
			return SHORT_TYPE
		}
		
		return BYTE_TYPE
	}
	
	private static def Class uTypeArth(Class left, Class right) {
		if(is(left, GAUSSIAN_TYPE) || is(right, GAUSSIAN_TYPE)) {
			return GAUSSIAN_TYPE
		}
		
		if(is(left, DIRAC_TYPE)) {
			return getUDistType(right)
		}
		
		if(is(right, DIRAC_TYPE)) {
			return getUDistType(left)
		}
		
		if(is(left, RAYLEIGH_TYPE) || is(right, RAYLEIGH_TYPE)) {
			return RAYLEIGH_TYPE
		}
		
		if(is(left, BINOMIAL_TYPE) || is(right, BINOMIAL_TYPE)) {
			return BINOMIAL_TYPE
		}
		
		throw new RuntimeException('''Uncertain type unknown for arithmetic operation between «left.name» and «right.name»''')	
	}
	
	
	
	private static def Class typeArthExpr(Class left, Class right) {
		// Operation between two certain numbers
		if(isCertainNumber(left) && isCertainNumber(right)) {
			return certainTypeArth(left, right)
		}
		
		// Operation with at least 1 certain number
		if(isCertainNumber(left)) {
			return right
		}
		
		if(isCertainNumber(right)) {
			return left
		}
		
		// Operation with 2 uncertain numbers
		val uType = uTypeArth(left, right)
		val type = 	certainTypeArth(getTypeFromUType(left), getTypeFromUType(right))
		
		if(uType === GAUSSIAN_TYPE) {
			if(type == FLOAT_TYPE) {
				return GAUSSIAN_FLOAT_TYPE
			}
			
			if(type == DOUBLE_TYPE) {
				return GAUSSIAN_DOUBLE_TYPE
			}
		}
		
		if(uType === RAYLEIGH_TYPE) {
			if(type == FLOAT_TYPE) {
				return RAYLEIGH_FLOAT_TYPE
			}
			
			if(type == DOUBLE_TYPE) {
				return RAYLEIGH_DOUBLE_TYPE
			}
		}
	}
	
	def static dispatch Class type(Plus plus) {
		val left = plus.left.type
		val right = plus.right.type
		
		if(left === STRING_TYPE || right === STRING_TYPE) {
			return STRING_TYPE
		}
		typeArthExpr(left, right)
	}
	
	def static dispatch Class type(Minus minus) {
		typeArthExpr(minus.left.type, minus.right.type)
	}
	
	def static dispatch Class type(Multiplication multiplication) {
		typeArthExpr(multiplication.left.type, multiplication.right.type)
	}
	
	def static dispatch Class type(Division division) {
		typeArthExpr(division.left.type, division.right.type)
	}
	
	def static dispatch Class type(ArrayAccess arrayAccess) {
		val typeElmt = type(arrayAccess.object)
		
		if(isUncertain(typeElmt)) {
			return BOOLEAN_TYPE
		}
		
		return switch(typeElmt) {
			case STRING_ARRAY_TYPE: STRING_TYPE
			case BYTE_ARRAY_TYPE: BYTE_TYPE
			case BYTE_ARRAY_TYPE: SHORT_TYPE
			case INT_ARRAY_TYPE: INT_TYPE
			case LONG_ARRAY_TYPE: LONG_TYPE
			case FLOAT_ARRAY_TYPE: FLOAT_TYPE
			case DOUBLE_ARRAY_TYPE: DOUBLE_TYPE
			case CHAR_ARRAY_TYPE: CHAR_TYPE
			case STRING_ARRAY_TYPE: STRING_TYPE
			default: throw new RuntimeException('''type(ArrayAccess arrayAccess) not Implemented for user defined classes or for this one. Actual: «typeElmt.name»''')
		}
		
	}
	
	def static dispatch Class type(ArrayLength arrayLength) {
		return INT_TYPE
	}
	
	def static dispatch Class type(Not not) {
		return BOOLEAN_TYPE
	}
	
	def static dispatch Class type(Neg neg) {
		return typeArthExpr(INT_TYPE, neg.expression.type)
	}
	
	def static dispatch Class type(FieldAccess fieldAccess) {
		return fieldAccess.field.typeRef.type
	}
		
	def static dispatch Class type(MethodCall call) {
		call.method.typeRef.type
	}
	
	def static dispatch Class type(MethodCall2 call2) {
		call2.method.typeRef.type
	}
	
	def static dispatch Class type(IntConstant intCst) {
		if(intCst.value >= Byte.MIN_VALUE && intCst.value <= Byte.MAX_VALUE) {
			return BYTE_TYPE
		}
		if(intCst.value >= Short.MIN_VALUE && intCst.value <= Short.MAX_VALUE) {
			return SHORT_TYPE
		}
		if(intCst.value >= Integer.MIN_VALUE && intCst.value <= Integer.MAX_VALUE) {
			return INT_TYPE
		}
		return LONG_TYPE
	}
	
	def static dispatch Class type(LongConstant longCst) {
		return LONG_TYPE
	}
	
	def static dispatch Class type(DoubleConstant dblCst) {
		if(dblCst.value >= Float.MIN_VALUE && dblCst.value <= Float.MAX_VALUE) {
			return FLOAT_TYPE
		}
		return DOUBLE_TYPE
	}
	
	def static dispatch Class type(BoolConstant boolCst) {
		return BOOLEAN_TYPE
	}
	
	def static dispatch Class type(StringConstant boolCst) {
		return STRING_TYPE
	}
	
	def static dispatch Class type(Null nullCts) {
		return NULL_TYPE
	}
	
	def static dispatch Class type(NewUObject newUObj) {
		newUObj.type.type
	}
	
	def static dispatch Class type(NewObject newUObj) {
		newUObj.type
	}
	
	def static dispatch Class type(SymbolRef symbol) {
		symbol.symbol.typeRef.type
	}
	
	def static dispatch Class type(ExistExpr exist) {
		BOOLEAN_TYPE
	}
	
	
	def static dispatch Class type(TypeRef r) {
		switch r {
			ClassRef: r.referencedClass
			IntegerTypeRef: INT_TYPE
			BooleanTypeRef: BOOLEAN_TYPE
			StringTypeRef: STRING_TYPE
			VoidTypeRef : NULL_TYPE
			FloatTypeRef: FLOAT_TYPE
			CharTypeRef: CHAR_TYPE
			ShortTypeRef: SHORT_TYPE
			DoubleTypeRef: DOUBLE_TYPE
			ByteTypeRef: BYTE_TYPE
			LongTypeRef: LONG_TYPE
			ArrayTypeRef:{
				switch(r.typeRef) {
					IntegerTypeRef: INT_ARRAY_TYPE
					BooleanTypeRef: BOOLEAN_ARRAY_TYPE
					StringTypeRef: STRING_ARRAY_TYPE
					FloatTypeRef: FLOAT_ARRAY_TYPE
					CharTypeRef: CHAR_ARRAY_TYPE
					ShortTypeRef: SHORT_ARRAY_TYPE
					DoubleTypeRef: DOUBLE_ARRAY_TYPE
					ByteTypeRef: BYTE_ARRAY_TYPE
					LongTypeRef: LONG_ARRAY_TYPE
				}
			}
			GaussianRef: {
				switch r.genericType {
					DoubleTypeRef: GAUSSIAN_DOUBLE_TYPE
					FloatTypeRef: GAUSSIAN_FLOAT_TYPE
				}
			}
			RayleighRef: {
				switch r.genericType {
					DoubleTypeRef: RAYLEIGH_DOUBLE_TYPE
					FloatTypeRef: RAYLEIGH_FLOAT_TYPE
				}
			}
			DiracRef: {
				switch r.genericType {
					ByteTypeRef: DIRAC_BYTE_TYPE
					ShortTypeRef: DIRAC_SHORT_TYPE
					IntegerTypeRef: DIRAC_INT_TYPE
					LongTypeRef: DIRAC_LONG_TYPE
					DoubleTypeRef: DIRAC_DOUBLE_TYPE
					FloatTypeRef: DIRAC_FLOAT_TYPE
				}
			}
			BernoulliRef: BERNOULLI_TYPE
			default: UNRECOGNIZED_TYPE
		}
	}
	
	
}