package duc.uminijava.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.StringValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.And
import org.tetrabox.minijava.xtext.miniJava.BoolConstant
import org.tetrabox.minijava.xtext.miniJava.Class
import org.tetrabox.minijava.xtext.miniJava.ClassRef
import org.tetrabox.minijava.xtext.miniJava.Division
import org.tetrabox.minijava.xtext.miniJava.Equality
import org.tetrabox.minijava.xtext.miniJava.Expression
import org.tetrabox.minijava.xtext.miniJava.Field
import org.tetrabox.minijava.xtext.miniJava.FieldAccess
import org.tetrabox.minijava.xtext.miniJava.Inequality
import org.tetrabox.minijava.xtext.miniJava.Inferior
import org.tetrabox.minijava.xtext.miniJava.InferiorOrEqual
import org.tetrabox.minijava.xtext.miniJava.IntConstant
import org.tetrabox.minijava.xtext.miniJava.Method
import org.tetrabox.minijava.xtext.miniJava.MethodCall
import org.tetrabox.minijava.xtext.miniJava.Minus
import org.tetrabox.minijava.xtext.miniJava.Multiplication
import org.tetrabox.minijava.xtext.miniJava.Neg
import org.tetrabox.minijava.xtext.miniJava.Not
import org.tetrabox.minijava.xtext.miniJava.Null
import org.tetrabox.minijava.xtext.miniJava.Or
import org.tetrabox.minijava.xtext.miniJava.Parameter
import org.tetrabox.minijava.xtext.miniJava.Plus
import org.tetrabox.minijava.xtext.miniJava.StringConstant
import org.tetrabox.minijava.xtext.miniJava.Superior
import org.tetrabox.minijava.xtext.miniJava.SuperiorOrEqual
import org.tetrabox.minijava.xtext.miniJava.SymbolRef
import org.tetrabox.minijava.xtext.miniJava.This
import org.tetrabox.minijava.xtext.miniJava.TypeRef

import static extension duc.uminijava.semantics.BlockAspect.*
import static extension duc.uminijava.semantics.ContextAspect.*
import static extension duc.uminijava.semantics.MethodAspect.*
import static extension duc.uminijava.semantics.ParameterAspect.*
import static extension duc.uminijava.semantics.StateAspect.*
import static extension duc.uminijava.semantics.TypeRefAspect.*
import static extension duc.uminijava.semantics.ValueAspect.*
import static extension duc.uminijava.semantics.ValueToStringAspect.*
import static extension duc.uminijava.semantics.MethodSortofStatementAspect.*
import static extension duc.uminijava.semantics.EqualityUtils.*
import static extension duc.uminijava.semantics.ImplicitConversionUtil.*

import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue
import org.tetrabox.minijava.xtext.miniJava.NewObject
import org.tetrabox.minijava.xtext.miniJava.NewArray
import org.tetrabox.minijava.xtext.miniJava.ArrayLength
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ArrayRefValue
import org.tetrabox.minijava.xtext.miniJava.ArrayAccess
import org.tetrabox.minijava.xtext.miniJava.IntegerTypeRef
import org.tetrabox.minijava.xtext.miniJava.BooleanTypeRef
import org.tetrabox.minijava.xtext.miniJava.StringTypeRef
import java.util.Map
import java.util.HashMap
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import duc.uminijava.uMiniJava.NewUObject
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory
import duc.uminijava.uMiniJava.BernoulliRef
import org.tetrabox.minijava.xtext.miniJava.DoubleConstant
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import uMiniJavaDynamicData.UBooleanValue
import duc.uminijava.uMiniJava.ExistExpr
import duc.uminijava.uMiniJava.GaussianRef
import org.tetrabox.minijava.xtext.miniJava.DoubleTypeRef
import uMiniJavaDynamicData.UIntegerValue
import uMiniJavaDynamicData.UDoubleValue

@Aspect(className=Expression)
class ExpressionAspect {

	def Value evaluateExpression(State state) {
		throw new RuntimeException('''evaluate should be overriden for type «_self.class.name»''')
	}
}

@Aspect(className=Neg)
class NegAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val intabsvalue = (_self.expression.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = -intabsvalue]
	}
}

@Aspect(className=Null)
class NullAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return MinijavadynamicdataFactory::eINSTANCE.createNullValue
	}
}

@Aspect(className=Minus)
class MinusAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		if(left instanceof UIntegerValue) {
			if(right instanceof UIntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = left.value - right.value
					variance = left.variance + right.variance
				]
			} else if(right instanceof IntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = left.value - right.value
					variance = left.variance
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof UDoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value - right.value
					variance = left.variance + right.variance
				]
			} else if(right instanceof DoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value - right.value
					variance = left.variance
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof DoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value - right.value
					variance = right.variance
				]
			} else if(right instanceof DoubleValue) {
				return MinijavadynamicdataFactory.eINSTANCE.createDoubleValue => [
					value = left.value - right.value
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [
					value = left.value - right.value
				]
			}
		}
		throw new RuntimeException('''Unsupported plus operands: «left» + «right».''')
	}
}

@Aspect(className=Multiplication)
class MultiplicationAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		if(left instanceof UIntegerValue) {
			if(right instanceof UIntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = left.value * right.value
					variance = right.value*right.value*left.variance + left.value*left.value*right.variance
				]
			} else if(right instanceof IntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = left.value * right.value
					variance = left.variance
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof UDoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value * right.value
					variance = right.value*right.value*left.variance + left.value*left.value*right.variance
				]
			} else if(right instanceof DoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value * right.value
					variance = left.variance
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof DoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value * right.value
					variance = right.variance
				]
			} else if(right instanceof DoubleValue) {
				return MinijavadynamicdataFactory.eINSTANCE.createDoubleValue => [
					value = left.value * right.value
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [
					value = left.value * right.value
				]
			}
		}
		throw new RuntimeException('''Unsupported plus operands: «left» + «right».''')
	}
}

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
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
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
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
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
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [
					value = left.value / right.value
				]
			}
		}
		throw new RuntimeException('''Unsupported plus operands: «left» + «right».''')
	}
}

@Aspect(className=Plus)
class PlusAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		if (left instanceof StringValue || right instanceof StringValue) {
			return MinijavadynamicdataFactory::eINSTANCE.createStringValue => [
				value = left.customToString + right.customToString
			]
		} else if(left instanceof UIntegerValue) {
			if(right instanceof UIntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = left.value + right.value
					variance = left.variance + right.variance
				]
			} else if(right instanceof IntegerValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUIntegerValue => [
					value = left.value + right.value
					variance = left.variance
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof UDoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value + right.value
					variance = left.variance + right.variance
				]
			} else if(right instanceof DoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value + right.value
					variance = left.variance
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if(left instanceof DoubleValue) {
			if(right instanceof UDoubleValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUDoubleValue => [
					value = left.value + right.value
					variance = right.variance
				]
			} else if(right instanceof DoubleValue) {
				return MinijavadynamicdataFactory.eINSTANCE.createDoubleValue => [
					value = left.value + right.value
				]
			} else {
				throw new RuntimeException('''Plus operation is not implemented between «left.class.name» and «right.class.name»''')
			}
		} else if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [
					value = left.value + right.value
				]
			}
		}
		throw new RuntimeException('''Unsupported plus operands: «left» + «right».''')
	}
}

@Aspect(className=Or)
class OrAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		
		if(left instanceof UBooleanValue) {
			if(right instanceof UBooleanValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as UBooleanValue
					val castedRight = right as UBooleanValue
					
					if(castedLeft.value == true && castedRight.value == true) {
						value = true
						confidence = castedLeft.confidence + castedRight.confidence - castedLeft.confidence * castedRight.confidence
					} else if(castedLeft.value == false && castedRight.value == true) {
						value = false
						val confidenceTrue = (1-castedLeft.confidence)+ castedRight.confidence - (1-castedLeft.confidence)*castedRight.confidence
						confidence = 1- confidenceTrue
						
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = false
						val confidenceTrue = (1-castedRight.confidence)+ castedLeft.confidence - (1-castedRight.confidence)*castedLeft.confidence
						confidence = 1- confidenceTrue
					} else if(castedLeft.value == false && castedRight.value == false) {
						value = false
						val confidenceTrue = 2-castedRight.confidence-castedLeft.confidence - (1-castedRight.confidence)*(1-castedLeft.confidence)
						confidence = 1- confidenceTrue
					}
				]
			} else {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as UBooleanValue
					val castedRight = right as BooleanValue
					
					if(castedLeft.value == true && castedRight.value == true) {
						value = true
						confidence = 1
					} else if(castedLeft.value == false && castedRight.value == true) {
						value = false
						confidence = 0
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = false
						confidence = 1-castedLeft.confidence
					} else if(castedLeft.value == false && castedRight.value == false) {
						value = false
						confidence = castedLeft.confidence
					}
					
				]
			}
			
		} else { //left -> BooleanValue
			if(right instanceof UBooleanValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as BooleanValue
					val castedRight = right as UBooleanValue
					
					if(castedLeft.value == true && castedRight.value == true) {
						value = true
						confidence = 1
					} else if(castedLeft.value == false && castedRight.value == true) {
						value = false
						confidence = 1-castedRight.confidence
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = false
						confidence = 0
					} else if(castedLeft.value == false && castedRight.value == false) {
						value = false
						confidence = castedRight.confidence
					}
					
				]
			} else {//right -> BooleanValue
				return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
					value = (left as BooleanValue).value || (right as BooleanValue).value
				]
			}
		}
		
//		throw new RuntimeException('''Unsupported or operands: «left» || «right».''')
	}
}

@Aspect(className=And)
class AndAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		
		
		if(left instanceof UBooleanValue) {
			if(right instanceof UBooleanValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as UBooleanValue
					val castedRight = right as UBooleanValue
					
					if(castedLeft.value == true && castedRight.value == true) {
						value = true
						confidence = castedLeft.confidence * castedRight.confidence
					} else if(castedLeft.value == true && castedRight.value == false) {
						value = false
						confidence = 1 - (castedLeft.confidence * (1-castedRight.confidence))
					} else if(castedLeft.value == false && castedRight.value ==true) {
						value = false
						confidence = 1- ((1-castedLeft.confidence) *castedRight.confidence)
					} else {
						value = false
						confidence = 1- ((1-castedLeft.confidence) * (1-castedRight.confidence))
					}
				]
			} else {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as UBooleanValue
					val castedRight = right as BooleanValue
					
					if(castedRight.value == false) {
						value=false
						confidence = 1
					} else {
						value = castedLeft.value
						confidence = castedLeft.confidence
					}
				]
			}
		} else {
			if(right instanceof UBooleanValue) {
				return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
					val castedLeft = left as BooleanValue
					val castedRight = right as UBooleanValue
					
					if(castedLeft.value == false) {
						value=false
						confidence = 1
					} else {
						value = castedRight.value
						confidence = castedRight.confidence
					}
				]
			} else {
				return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
					value = (left as BooleanValue).value && (right as BooleanValue).value
				]
			}
		}
//		if (left instanceof BooleanValue) {
//			if (right instanceof BooleanValue) {
//				return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
//					value = left.value && right.value
//				]
//			}
//		}
//		throw new RuntimeException('''Unsupported or operands: «left» && «right».''')
	}
}

@Aspect(className=Inferior)
class InferiorAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = (_self.left.evaluateExpression(state) as IntegerValue).value
		val right = (_self.right.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = left < right
		]
	}
}

@Aspect(className=InferiorOrEqual)
class InferiorOrEqualAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = (_self.left.evaluateExpression(state) as IntegerValue).value
		val right = (_self.right.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = left <= right
		]
	}

}

@Aspect(className=SuperiorOrEqual)
class SuperiorOrEqualAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = (_self.left.evaluateExpression(state) as IntegerValue).value
		val right = (_self.right.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = left >= right
		]
	}
}

@Aspect(className=Superior)
class SuperiorAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = (_self.left.evaluateExpression(state) as IntegerValue).value
		val right = (_self.right.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = left > right
		]
	}
}

@Aspect(className=Not)
class NotAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val exprVal = _self.expression.evaluateExpression(state)
		if(exprVal instanceof UBooleanValue) {
			return UMiniJavaDynamicDataFactory.eINSTANCE.createUBooleanValue => [
				value = !exprVal.value
				confidence = exprVal.confidence
			]
		} else {
			return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
				value = !(exprVal as BooleanValue).value
			]
		}
	}
}

@Aspect(className=Equality)
class EqualityAspect extends ExpressionAspect {

	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		val boolean result =  left.equals(right)
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = result
		]
	}
}

@Aspect(className=Inequality)
class InequalityAspect extends ExpressionAspect {

	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		val boolean result = left.notEquals(right)
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = result
		]
	}
}

@Aspect(className=TypeRef)
class TypeRefAspect {
	def boolean compare(TypeRef other) { return _self.eClass == other.eClass }
}

@Aspect(className=ClassRef)
class ClassRefAspect extends TypeRefAspect {
	@OverrideAspectMethod
	def boolean compare(TypeRef other) {
		if (other instanceof ClassRef) {
			return _self.referencedClass == other.referencedClass
		} else {
			return false;
		}
	}
}

@Aspect(className=Parameter)
class ParameterAspect {
	def boolean compare(Parameter other) {
		return _self.name == other.name && _self.typeRef.compare(other.typeRef)
	}
}

@Aspect(className=Method)
class MethodAspect {

	Map<Class, Method> cache = new HashMap

	def Method findOverride(Class c) {

		if (!_self.cache.containsKey(c)) {
			val result = if (c.members.contains(_self)) {
					_self
				} else {

					val candidate = c.members.filter(Method).findFirst [
						it.name == _self.name && it.params.size == _self.params.size &&
							it.typeRef.compare(_self.typeRef) && it.params.forall [ p1 |
								_self.params.exists [ p2 |
									p1.compare(p2)
								]
							]
					]

					if (candidate !== null) {
						candidate
					} else if (c.superClass !== null) {
						_self.findOverride(c.superClass)
					} else {
						null
					}
				}
			_self.cache.put(c, result)
		}

		return _self.cache.get(c)
	}
}

@Aspect(className=MethodCall)
class MethodCallExpressionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val realReceiver = (_self.receiver.evaluateExpression(state) as ObjectRefValue).instance
		val realMethod = _self.method.findOverride(realReceiver.type as Class)
		val newContext = MinijavadynamicdataFactory::eINSTANCE.createContext
		for (arg : _self.args) {
			val param = realMethod.params.get(_self.args.indexOf(arg))
			val binding = MinijavadynamicdataFactory::eINSTANCE.createSymbolBinding => [
				symbol = param
				value = arg.evaluateExpression(state)
			]
			newContext.bindings.add(binding)
		}

		val call = MinijavadynamicdataFactory::eINSTANCE.createMethodCall2 => [methodcall = _self]
		state.pushNewFrame(realReceiver, call, newContext)
		realMethod.call(state)
		val returnValue = state.findCurrentFrame.returnValue
		state.popCurrentFrame
		return returnValue

	}
}

@Aspect(className=FieldAccess)
class FieldAccessAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val realReceiver = (_self.receiver.evaluateExpression(state) as ObjectRefValue).instance as ObjectInstance
		return realReceiver.fieldbindings.findFirst[it.field === _self.field].value
	}
}

@Aspect(className=This)
class ThisAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val currentInstance = state.findCurrentFrame.instance
		if (currentInstance === null) {
			throw new RuntimeException('''"this" is not valid in the current context''')
		} else {
			return MinijavadynamicdataFactory::eINSTANCE.createObjectRefValue => [instance = currentInstance]
		}
	}
}

@Aspect(className=SymbolRef)
class SymbolRefAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		state.findCurrentContext.findBinding(_self.symbol).value.copy
	}
}

@Aspect(className=NewObject)
class NewObjectAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {

		// Creating instance with default bindings
		val result = MinijavadynamicdataFactory::eINSTANCE.createObjectInstance => [type = _self.type]
		state.objectsHeap.add(result)
		for (f : result.type.members.filter(Field)) {
			if (f.defaultValue !== null) {
				val v = f.defaultValue.evaluateExpression(state)
				result.fieldbindings.add(MinijavadynamicdataFactory::eINSTANCE.createFieldBinding => [
					field = f;
					value = v
				])
			}
		}

		// Find constructor
		val Method constructor = _self.type.members.filter(Method).findFirst [
			it.name === null && it.params.size === _self.args.size
		]

		// If any, call it
		if (constructor !== null) {

			// Create a context with constructor parameters bindings
			val newContext = MinijavadynamicdataFactory::eINSTANCE.createContext
			for (arg : _self.args) {
				val Parameter param = constructor.params.get(_self.args.indexOf(arg))
				val binding = MinijavadynamicdataFactory::eINSTANCE.createSymbolBinding => [
					symbol = param;
					value = (arg as Expression).evaluateExpression(state)
				]
				newContext.bindings.add(binding)
			}

			// Make the constructor call in new frame
			val call = MinijavadynamicdataFactory::eINSTANCE.createNewCall => [^new = _self]
			state.pushNewFrame(result, call, newContext)
			constructor.body.evaluateStatement(state)
			state.popCurrentFrame

		}

		// Return constructed instance
		return MinijavadynamicdataFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
}

@Aspect(className=NewArray)
class NewArrayAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		// Creating array with size
		val result = MinijavadynamicdataFactory::eINSTANCE.createArrayInstance
		result.size = (_self.size.evaluateExpression(state) as IntegerValue).value
		state.arraysHeap.add(result)

		// Filling array with default values
		val defaultValue = switch (_self.type) {
			IntegerTypeRef: MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = 0]
			BooleanTypeRef: MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [value = false]
			StringTypeRef: MinijavadynamicdataFactory::eINSTANCE.createNullValue
			ClassRef: MinijavadynamicdataFactory::eINSTANCE.createNullValue
		}
		for (i : 1 .. result.size) {
			result.value.add(defaultValue.copy)
		}

		// Return constructed array
		return MinijavadynamicdataFactory::eINSTANCE.createArrayRefValue => [instance = result]
	}
}

@Aspect(className=StringConstant)
class StringConstantAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return MinijavadynamicdataFactory::eINSTANCE.createStringValue => [
			value = _self.value
		]
	}
}

@Aspect(className=IntConstant)
class IntConstantAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [
			value = _self.value
		]
	}
}

@Aspect(className=DoubleConstant)
class DoubleConstantAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return MinijavadynamicdataFactory::eINSTANCE.createDoubleValue => [
			value = _self.value
		]
	}
}

@Aspect(className=BoolConstant)
class BoolConstantAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = _self.value.equalsIgnoreCase("true")
		]
	}
}

@Aspect(className=ArrayLength)
class ArrayLengthAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val arrayRef = _self.array.evaluateExpression(state) as ArrayRefValue
		val size = arrayRef.instance.size
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [
			value = size
		]
	}
}

@Aspect(className=ArrayAccess)
class ArrayAccessAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val arrayRef = _self.object.evaluateExpression(state)
		
		if(arrayRef instanceof ArrayRefValue) {
			val index = (_self.index.evaluateExpression(state) as IntegerValue).value
			return arrayRef.instance.value.get(index).copy
		} else if(arrayRef instanceof UBooleanValue){ //UBooleanValue
			val conf = (_self.index.evaluateExpression(state) as DoubleValue).value
					
			return MinijavadynamicdataFactory.eINSTANCE.createBooleanValue => [
				if(arrayRef.value) {
					value = arrayRef.confidence >= conf
				} else {
					value = (1-arrayRef.confidence) >= conf
				}
			]
		} else {
			throw new RuntimeException("Not yet implemented for " + arrayRef.class.name)
		}
		
//		val array = (_self.object.evaluateExpression(state) as ArrayRefValue).instance
//		val index = (_self.index.evaluateExpression(state) as IntegerValue).value
//		return array.value.get(index).copy
	}

}

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
			} else {
				throw new RuntimeException("Not yet supported");
			}
		}
		throw new RuntimeException("Not yet supported");
	
	
	}
}

@Aspect(className=ExistExpr)
class ExistExprAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val double conf = (_self.confidence.evaluateExpression(state) as DoubleValue).value
		val uAtt = _self.expr.evaluateExpression(state)
		if(uAtt instanceof UBooleanValue) {
			MinijavadynamicdataFactory.eINSTANCE.createBooleanValue => [
				value = conf <= uAtt.confidence || conf <= 1 - uAtt.confidence
			]
		} else {
			throw new RuntimeException('''Not yet implemented for «uAtt.class.name»''')
		}
		
	}
}
