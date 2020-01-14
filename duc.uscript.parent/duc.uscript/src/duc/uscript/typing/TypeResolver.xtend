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
import duc.uscript.uScript.BinomialRef
import com.google.inject.Inject
import static extension duc.uscript.UScriptModelHelper.getFullQualifiedNamed
import duc.uscript.scoping.UScriptIndex
import duc.uscript.uScript.This
import org.eclipse.emf.ecore.EObject
import duc.uscript.uScript.VariableDeclaration
import duc.uscript.uScript.NewArray
import java.util.HashMap
import java.util.Map
import duc.uscript.uScript.UScriptFactory
import duc.uscript.uScript.UTypeRef
import duc.uscript.uScript.MultPossibilitiesRef
import duc.uscript.uScript.ComputeNbTrueExpr
import static duc.uscript.UScriptModelHelper.*

class TypeResolver {
	@Inject extension InternalTypeDcl
	@Inject extension UScriptIndex
	
	
	protected static val factory = UScriptFactory.eINSTANCE
	
	///// Dictionary Array<->Class
	// class name -> class array type
	public static val Map<String, Class> CLASS_ARRAY_TYPE = new HashMap
	// class array type name -> class
	public static val Map<String, Class> CLASS_ARRAY_TYPE_REVERSE = new HashMap
			
	def dispatch Class type(Expression e) {
		throw new RuntimeException('''Expression «e» not condisered in the type resolver''')
	}
	
	def dispatch Class type(This t) {
		var EObject current = t;
		while(!(current instanceof Class)) {
			current = current.eContainer
			if(current === null) {
				return t.nullClass
			}
		}
		
		return current as Class
	}
		
	private def Class typeBoolExpr(Class left, Class right) {
		if(left.fullQualifiedNamed == BERNOULLI_BOOL_TYPE || right.fullQualifiedNamed == BERNOULLI_BOOL_TYPE) {
			return left.bernoulliBoolClass
		}
		
		return left.boolClass
	}
	
	def dispatch Class type(Or e) {
		typeBoolExpr(e.left.type, e.right.type)
	}
	
	def dispatch Class type(And e) {
		typeBoolExpr(e.left.type, e.right.type)
	}
	
	def dispatch Class type(Equality eq) {
		typeBoolExpr(eq.left.type, eq.right.type)
	}
	
	def dispatch Class type(Inequality ineq) {
		typeBoolExpr(ineq.left.type, ineq.right.type)
	}
	
	private def Class typeComparisonExpr(Class left, Class right) {
		if(isCertainNumber(left) && isCertainNumber(right)) {
			return left.boolClass
		}
		
		return left.bernoulliBoolClass
	}
	
	def dispatch Class type(SuperiorOrEqual comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	def dispatch Class type(InferiorOrEqual comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	def dispatch Class type(Superior comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	def dispatch Class type(Inferior comp) {
		typeComparisonExpr(comp.left.type, comp.right.type)
	}
	
	private def Class certainTypeArth(Class left, Class right) {
		val leftName = left.fullQualifiedNamed
		val rightName = right.fullQualifiedNamed
		if(leftName == DOUBLE_TYPE || rightName == DOUBLE_TYPE) {
			return left.doubleClass
		}
		
		if(leftName == FLOAT_TYPE || rightName == FLOAT_TYPE) {
			return left.floatClass
		}
		
		if(leftName == LONG_TYPE || rightName == LONG_TYPE) {
			return left.longClass
		}
		
		if(leftName == INT_TYPE || rightName == INT_TYPE) {
			return left.intClass
		}
		
		if(leftName == SHORT_TYPE || rightName == SHORT_TYPE) {
			return left.shortClass
		}
		
		return left.byteClass
	}
	
	private def Class uTypeArth(Class left, Class right) {
		if(is(left, GAUSSIAN_TYPE) || is(right, GAUSSIAN_TYPE)) {
			return left.gaussianClass
		}
		
		if(is(left, DIRAC_TYPE)) {
			return left.getClassFromFqn(getUDistType(right))
		}
		
		if(is(right, DIRAC_TYPE)) {
			return left.getClassFromFqn(getUDistType(left))
		}
		
		if(is(left, RAYLEIGH_TYPE) || is(right, RAYLEIGH_TYPE)) {
			return left.getClassFromFqn(RAYLEIGH_TYPE)
		}
		
		if(is(left, BINOMIAL_TYPE) || is(right, BINOMIAL_TYPE)) {
			return left.getClassFromFqn(BINOMIAL_TYPE)
		}
		
		if(is(left, MULTPOSS_TYPE) && is(right, MULTPOSS_TYPE)) {
			return left.getClassFromFqn(MULTPOSS_TYPE)
		}
		
		throw new RuntimeException('''Uncertain type unknown for arithmetic operation between «left.name» and «right.name»''')	
	}
	
	
	
	private def Class typeArthExpr(Class left, Class right) {
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
		val leftClass = left.getClassFromFqn(getTypeFromUType(left))
		val rightClass = left.getClassFromFqn(getTypeFromUType(right))
		val uTypeName = uTypeArth(left, right).fullQualifiedNamed
		val type = certainTypeArth(leftClass, rightClass).fullQualifiedNamed
		
		if(uTypeName == GAUSSIAN_TYPE) {
			if(type == FLOAT_TYPE) {
				return left.gaussianFloatClass
			}
			
			if(type == DOUBLE_TYPE) {
				return left.gaussianDoubleClass
			}
		} else if(uTypeName == RAYLEIGH_TYPE) {
			if(type == FLOAT_TYPE) {
				return left.rayleighFloatClass
			}
			
			if(type == DOUBLE_TYPE) {
				return left.rayleighDoubleClass
			}
		} else if(uTypeName == MULTPOSS_TYPE) {
			if(type ==  INT_TYPE) {
				return left.multChoiceIntClass
			}
		}
		
		throw new RuntimeException('''Class typeArthExpr(Class, Class) not implemented for utype[«uTypeName»] and type «type» ''')
	}
	
	def dispatch Class type(Plus plus) {
		val left = plus.left.type
		val right = plus.right.type
		
		if(left.fullQualifiedNamed == STRING_TYPE || right.fullQualifiedNamed == STRING_TYPE) {
			return plus.stringClass
		}
		typeArthExpr(left, right)
	}
	
	def dispatch Class type(Minus minus) {
		typeArthExpr(minus.left.type, minus.right.type)
	}
	
	def dispatch Class type(Multiplication multiplication) {
		typeArthExpr(multiplication.left.type, multiplication.right.type)
	}
	
	def dispatch Class type(Division division) {
		typeArthExpr(division.left.type, division.right.type)
	}
	
	def dispatch Class type(ArrayAccess arrayAccess) {
		val typeElmt = type(arrayAccess.object)
		
		if(isUncertain(typeElmt)) {
			return arrayAccess.boolClass
		}
		
		if(typeElmt.fullQualifiedNamed === null) {
			return arrayAccess.nullClass 
		}
		
		return switch(typeElmt.fullQualifiedNamed) {
			case STRING_ARRAY_TYPE: arrayAccess.stringClass
			case BYTE_ARRAY_TYPE: arrayAccess.byteClass
			case SHORT_ARRAY_TYPE: arrayAccess.shortClass
			case INT_ARRAY_TYPE: arrayAccess.intClass
			case LONG_ARRAY_TYPE: arrayAccess.longClass
			case FLOAT_ARRAY_TYPE: arrayAccess.floatClass
			case DOUBLE_ARRAY_TYPE: arrayAccess.doubleClass
			case CHAR_ARRAY_TYPE: arrayAccess.charClass
			default: throw new RuntimeException('''type(ArrayAccess arrayAccess) not Implemented for user defined classes or for this one. Actual: «typeElmt.name»''')
		}
		
	}
	
	def dispatch Class type(ArrayLength arrayLength) {
		return arrayLength.intClass
	}
	
	def dispatch Class type(Not not) {
		return not.boolClass
	}
	
	def dispatch Class type(Neg neg) {
		return typeArthExpr(neg.intClass, neg.expression.type)
	}
	
	def dispatch Class type(FieldAccess fieldAccess) {
		if(fieldAccess.field.typeRef === null) {
			return fieldAccess.nullClass
		}
		return fieldAccess.field.typeRef.type
	}
		
	def dispatch Class type(MethodCall call) {
		call.method.typeRef.type
	}
	
	def dispatch Class type(MethodCall2 call2) {
		call2.method.typeRef.type
	}
	
	def dispatch Class type(IntConstant intCst) {
		if(intCst.value >= Byte.MIN_VALUE && intCst.value <= Byte.MAX_VALUE) {
			return intCst.byteClass
		}
		if(intCst.value >= Short.MIN_VALUE && intCst.value <= Short.MAX_VALUE) {
			return intCst.shortClass
		}
		if(intCst.value >= Integer.MIN_VALUE && intCst.value <= Integer.MAX_VALUE) {
			return intCst.intClass
		}
		return intCst.longClass
	}
	
	def dispatch Class type(LongConstant longCst) {
		return longCst.longClass
	}
	
	def dispatch Class type(DoubleConstant dblCst) {
		if(dblCst.value >= Float.MIN_VALUE && dblCst.value <= Float.MAX_VALUE) {
			return dblCst.floatClass
		}
		return dblCst.doubleClass
	}
	
	def dispatch Class type(BoolConstant boolCst) {
		return boolCst.boolClass
	}
	
	def dispatch Class type(StringConstant stringCst) {
		return stringCst.stringClass
	}
	
	def dispatch Class type(Null nullCts) {
		return nullCts.nullClass
	}
	
	def dispatch Class type(NewUObject newUObj) {
		newUObj.type.type
	}
	
	def dispatch Class type(NewObject newUObj) {
		newUObj.type
	}
	
	def dispatch Class type(SymbolRef symbol) {
		if(symbol.symbol === null) {
			return symbol.nullClass
		}
		if(symbol.symbol.typeRef === null) {
			return symbol.nullClass
		}
		return symbol.symbol.typeRef.type
	}
	
	def dispatch Class type(ExistExpr exist) {
		exist.boolClass
	}
	
	def dispatch Class type(ComputeNbTrueExpr compute) {
		compute.multChoiceIntClass
	}
	
	def dispatch Class type(VariableDeclaration varDcl) {
		return varDcl.typeRef.type
	}
	
	def dispatch Class type(NewArray newArray) {
//		newArray.getType.type
		switch (newArray.getType) {
			ByteTypeRef: newArray.byteArrayClass
			ShortTypeRef: newArray.shortArrayClass
			IntegerTypeRef: newArray.intArrayClass
			LongTypeRef: newArray.longArrayClass
			FloatTypeRef: newArray.floatArrayClass
			DoubleTypeRef: newArray.doubleArrayClass
			BooleanTypeRef: newArray.boolArrayClass
			StringTypeRef: newArray.stringArrayClass
			CharTypeRef: newArray.charArrayClass
			ClassRef: getOrCreateClassRefType(newArray.getType as ClassRef)
			UTypeRef: getOrCreateUClassRefType(newArray.getType as UTypeRef)
			default: throw new RuntimeException('''Array type not managed for «newArray.getType»''')
		}
	}
	
	def dispatch Class type(TypeRef r) {
		switch r {
			ClassRef: r.referencedClass
			IntegerTypeRef: r.intClass
			BooleanTypeRef: r.boolClass
			StringTypeRef: r.stringClass
			VoidTypeRef : r.nullClass
			FloatTypeRef: r.floatClass
			CharTypeRef: r.charClass
			ShortTypeRef: r.shortClass
			DoubleTypeRef: r.doubleClass
			ByteTypeRef: r.byteClass
			LongTypeRef: r.longClass
			ArrayTypeRef:{
				switch(r.typeRef) {
					IntegerTypeRef: r.intArrayClass
					BooleanTypeRef: r.boolArrayClass
					StringTypeRef: r.stringArrayClass
					FloatTypeRef: r.floatArrayClass
					CharTypeRef: r.charArrayClass
					ShortTypeRef: r.shortArrayClass
					DoubleTypeRef: r.doubleArrayClass
					ByteTypeRef: r.byteArrayClass
					LongTypeRef: r.longArrayClass
					ClassRef: getOrCreateClassRefType(r.typeRef as ClassRef)
					UTypeRef: getOrCreateUClassRefType(r.typeRef as UTypeRef)
					default: throw new RuntimeException("type(TypeRef r) not implemented for actual type: " + r.typeRef)
				}
			}
			GaussianRef: {
				switch r.genericType {
					DoubleTypeRef: r.gaussianDoubleClass
					FloatTypeRef: r.gaussianFloatClass
					default: r.gaussianDistClass
				}
			}
			RayleighRef: {
				switch r.genericType {
					DoubleTypeRef: r.rayleighDoubleClass
					FloatTypeRef: r.rayleighFloatClass
					default: r.rayleighDistClass
				}
			}
			DiracRef: {
				switch r.genericType {
					ByteTypeRef: r.diracByteClass
					ShortTypeRef: r.diracShortClass
					IntegerTypeRef: r.diracIntClass
					LongTypeRef: r.diracLongClass
					DoubleTypeRef: r.diracDoubleClass
					FloatTypeRef: r.diracFloatClass
					default: r.diracClass
				}
			}
			BinomialRef: {
				switch r.genericType {
					ByteTypeRef: r.binomialByteClass
					ShortTypeRef: r.binomialShortClass
					IntegerTypeRef: r.binomialIntClass
					LongTypeRef: r.binomialLongClass
					default: r.binomialDistClass
				}
			}
			BernoulliRef: {
				switch r.genericType {
					BooleanTypeRef: r.bernoulliBoolClass
					default: r.bernoulliDistClass
				}
			}
			MultPossibilitiesRef: {
				switch r.genericType {
					ByteTypeRef: r.multChoiceByteClass
					ShortTypeRef: r.multChoiceShortClass
					IntegerTypeRef: r.multChoiceIntClass
					LongTypeRef: r.multChoiceLongClass
					DoubleTypeRef: r.multChoiceDoubleClass
					FloatTypeRef: r.multChoiceFloatClass
					default: r.multChoiceClass
				}
			}
			default: throw new RuntimeException('''Type not implemented in [Class type(TypeRef r)] function: «r»''')
		}
	}
	
	protected def getOrCreateClassRefType(ClassRef typeRef) {
		val className = typeRef.referencedClass.fullQualifiedNamed
		var res = CLASS_ARRAY_TYPE.get(className)
		if (res === null) {
			res = factory.createClass => [ name = '''«className»ArrayType''' ]
			CLASS_ARRAY_TYPE.put(className, res)
			CLASS_ARRAY_TYPE_REVERSE.put('''«className»ArrayType''', typeRef.referencedClass)
		}
	}
	
	protected def getOrCreateUClassRefType(UTypeRef utypeRef) {
		val class = switch(utypeRef) {
			GaussianRef: {
				switch(utypeRef.genericType) {
					DoubleTypeRef: utypeRef.gaussianDoubleClass
					default: throw new RuntimeException('''getOrCreateUClassRefType(UTypeRef utypeRef) not yet implemented for (Gaussian<«utypeRef.genericType»>)''')
				}
			}
			BernoulliRef: {
				switch(utypeRef.genericType) {
					BooleanTypeRef: utypeRef.bernoulliBoolClass
					default: throw new RuntimeException('''getOrCreateUClassRefType(UTypeRef utypeRef) not yet implemented for (Gaussian<«utypeRef.genericType»>)''')
				}
			}
			default: throw new RuntimeException('''getOrCreateUClassRefType(UTypeRef utypeRef) not yet implemented for («utypeRef»)''')
		}
		val className = class.fullQualifiedNamed
		
		var res = CLASS_ARRAY_TYPE.get(className)
		if (res === null) {
			res = factory.createClass => [ name = '''«className»ArrayType''' ]
			CLASS_ARRAY_TYPE.put(className, res)
			CLASS_ARRAY_TYPE_REVERSE.put('''«className»ArrayType''', class)
		}
	}
	
	
}