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
import org.tetrabox.minijava.dynamic.minijavadynamicdata.NullValue
import java.util.Map
import java.util.HashMap
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory

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
		val left = (_self.left.evaluateExpression(state) as IntegerValue).value
		val right = (_self.right.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = left - right]
	}
}

@Aspect(className=Multiplication)
class MultiplicationAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = (_self.left.evaluateExpression(state) as IntegerValue).value
		val right = (_self.right.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = left * right]
	}
}

@Aspect(className=Division)
class DivisionAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = (_self.left.evaluateExpression(state) as IntegerValue).value
		val right = (_self.right.evaluateExpression(state) as IntegerValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = left / right]
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
		if (left instanceof BooleanValue) {
			if (right instanceof BooleanValue) {
				return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
					value = left.value || right.value
				]
			}
		}
		throw new RuntimeException('''Unsupported or operands: «left» || «right».''')
	}
}

@Aspect(className=And)
class AndAspect extends ExpressionAspect {
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)
		if (left instanceof BooleanValue) {
			if (right instanceof BooleanValue) {
				return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
					value = left.value && right.value
				]
			}
		}
		throw new RuntimeException('''Unsupported or operands: «left» && «right».''')
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
		val expr = (_self.expression.evaluateExpression(state) as BooleanValue).value
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [
			value = !expr
		]
	}
}

@Aspect(className=Equality)
class EqualityAspect extends ExpressionAspect {

	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val left = _self.left.evaluateExpression(state)
		val right = _self.right.evaluateExpression(state)

		val boolean result = if (left instanceof IntegerValue) {
				left.value === (right as IntegerValue).value
			} else if (left instanceof StringValue) {
				left.value == (right as StringValue).value
			} else if (left instanceof BooleanValue) {
				left.value === (right as BooleanValue).value
			} else if (left instanceof NullValue) {
				right instanceof NullValue
			} else if (left instanceof ObjectRefValue) {
				(right instanceof ObjectRefValue) && left.instance === (right as ObjectRefValue).instance
			} else {
				throw new RuntimeException('''Type unsupported for equality operator: «left.class»''')
			}

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

		val boolean result = if (left instanceof IntegerValue) {
				left.value !== (right as IntegerValue).value
			} else if (left instanceof StringValue) {
				left.value != (right as StringValue).value
			} else if (left instanceof BooleanValue) {
				left.value !== (right as BooleanValue).value
			} else if (left instanceof NullValue) {
				! (right instanceof NullValue)
			} else if (left instanceof ObjectRefValue) {
				!(right instanceof ObjectRefValue) || left.instance !== (right as ObjectRefValue).instance
			} else {
				throw new RuntimeException('''Type unsupported for inequality operator: «left.class»''')
			}
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

	private Map<Class, Method> cache = new HashMap

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
			value = (_self.value as int)
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
		val array = (_self.object.evaluateExpression(state) as ArrayRefValue).instance
		val index = (_self.index.evaluateExpression(state) as IntegerValue).value
		return array.value.get(index).copy
	}

}
