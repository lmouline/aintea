package duc.uminijava.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import java.util.HashMap
import java.util.Map
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ArrayRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.BooleanValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Call
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Context
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Frame
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.NullValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.dynamic.minijavadynamicdata.StringValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.SymbolBinding
import org.tetrabox.minijava.dynamic.minijavadynamicdata.Value
import org.tetrabox.minijava.xtext.miniJava.Symbol

import static extension duc.uminijava.semantics.ContextAspect.*
import static extension duc.uminijava.semantics.FrameAspect.*
import uMiniJavaDynamicData.UBooleanValue
import uMiniJavaDynamicData.UMiniJavaDynamicDataFactory
import uMiniJavaDynamicData.UIntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.DoubleValue
import uMiniJavaDynamicData.UDoubleValue
import uMiniJavaDynamicData.ULongValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.LongValue
import uMiniJavaDynamicData.UShortValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ShortValue
import uMiniJavaDynamicData.UByteValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ByteValue
import uMiniJavaDynamicData.UFloatValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.FloatValue

@Aspect(className=Context)
class ContextAspect {

	val Map<Symbol, SymbolBinding> cache = new HashMap

	def Context createChildContext() {
		return MinijavadynamicdataFactory::eINSTANCE.createContext => [
			parentContext = _self
		]
	}

	def SymbolBinding findBinding(Symbol symbol) {
		if (!_self.cache.containsKey(symbol)) {
			val binding = _self.bindings.findFirst[it.symbol === symbol]
			if (binding !== null) {
				_self.cache.put(symbol, binding)
			} else if (_self.parentContext !== null) {
				val binding2 = _self.parentContext.findBinding(symbol)
				_self.cache.put(symbol, binding2)
			} else {
				throw new Exception("No binding for symbol " + symbol)
			}
		}
		return _self.cache.get(symbol)
	}

	def Context findCurrentContext() {
		if (_self.childContext !== null) {
			return _self.childContext.findCurrentContext
		} else {
			return _self
		}
	}

}

@Aspect(className=State)
class StateAspect {

	var Frame frameCache
	var Context contextCache

	def Frame findCurrentFrame() {
		if (_self.frameCache === null) {
			_self.frameCache = _self.rootFrame.findCurrentFrame
		}
		return _self.frameCache
	}

	def Context findCurrentContext() {
		if (_self.contextCache === null) {
			_self.contextCache = _self.rootFrame.findCurrentContext
		}
		return _self.contextCache
	}

	def void println(String string) {
		println(string)
		_self.outputStream.stream.add(string)
	}

	def void pushNewContext() {
		val newContext = MinijavadynamicdataFactory::eINSTANCE.createContext
		if (_self.findCurrentContext !== null) {
			_self.findCurrentContext.childContext = newContext
		} else {
			_self.findCurrentFrame.rootContext = newContext
		}
		_self.contextCache = newContext
	}

	def void popCurrentContext() {
		val newCurrent = _self.findCurrentContext.parentContext
		_self.findCurrentContext.parentContext = null
		_self.contextCache = newCurrent
	}

	def void pushNewFrame(ObjectInstance receiver, Call c, Context newContext) {
		val newFrame = MinijavadynamicdataFactory::eINSTANCE.createFrame => [
			instance = receiver
			call = c
			rootContext = newContext
		]
		_self.findCurrentFrame.childFrame = newFrame
		_self.frameCache = newFrame
		_self.contextCache = null

	}

	def void popCurrentFrame() {
		val newCurrent = _self.findCurrentFrame.parentFrame
		_self.findCurrentFrame.parentFrame = null;
		_self.contextCache = null
		_self.frameCache = newCurrent
	}

}

@Aspect(className=Frame)
class FrameAspect {

	def Frame findCurrentFrame() {
		if (_self.childFrame !== null) {
			return _self.childFrame.findCurrentFrame
		} else {
			return _self
		}
	}

	def Context findCurrentContext() {
		if (_self.childFrame !== null) {
			return _self.childFrame.findCurrentContext
		} else if (_self.rootContext !== null) {
			return _self.rootContext.findCurrentContext
		} else {
			return null
		}
	}

}

@Aspect(className=Value)
class ValueAspect {
	def Value copy() { throw new Exception("Must provide a copy method for " + _self) }
}

@Aspect(className=IntegerValue)
class IntegerValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createIntegerValue => [value = _self.value]
	}
}

@Aspect(className=UIntegerValue)
class UIntegerValueAspect extends IntegerValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUIntegerValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}

@Aspect(className=DoubleValue)
class DoubleValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createDoubleValue => [value = _self.value]
	}
}

@Aspect(className=UDoubleValue)
class UDoubleValueAspect extends DoubleValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUDoubleValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}

@Aspect(className=LongValue)
class LongValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createLongValue => [value = _self.value]
	}
}

@Aspect(className=ULongValue)
class ULongValueAspect extends LongValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createULongValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}



@Aspect(className=ShortValue)
class ShortValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createShortValue => [value = _self.value]
	}
}

@Aspect(className=UShortValue)
class UShortValueAspect extends ShortValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUShortValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}


@Aspect(className=ByteValue)
class ByteValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createByteValue => [value = _self.value]
	}
}

@Aspect(className=UByteValue)
class UByteValueAspect extends ByteValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUByteValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}

@Aspect(className=FloatValue)
class FloatValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createFloatValue => [value = _self.value]
	}
}

@Aspect(className=UFloatValue)
class UFloatValueAspect extends FloatValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUFloatValue => [
			value = _self.value
			variance = _self.variance
		]
	}
}



@Aspect(className=BooleanValue)
class BooleanValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createBooleanValue => [value = _self.value]
	}
}

@Aspect(className=UBooleanValue)
class UBooleanValueAspect extends BooleanValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return UMiniJavaDynamicDataFactory::eINSTANCE.createUBooleanValue => [
			value = _self.value
			confidence = _self.confidence
		]
	}
}

@Aspect(className=StringValue)
class StringValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createStringValue => [value = _self.value]
	}

}

@Aspect(className=ObjectRefValue)
class ObjectRefValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createObjectRefValue => [instance = _self.instance]
	}
}

@Aspect(className=ArrayRefValue)
class ArrayRefValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createArrayRefValue => [instance = _self.instance]
	}
}

@Aspect(className=NullValue)
class NullValueAspect extends ValueAspect {
	@OverrideAspectMethod
	def Value copy() {
		return MinijavadynamicdataFactory::eINSTANCE.createNullValue
	}
}

