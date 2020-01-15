package duc.uscript.execution.interpreter.expression.arithmetic

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Plus
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import duc.uscript.execution.Value
import duc.uscript.execution.State
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.StringValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.ByteValue
import duc.uscript.execution.ShortValue
import duc.uscript.execution.IntegerValue
import duc.uscript.execution.LongValue
import duc.uscript.execution.FloatValue
import duc.uscript.execution.DoubleValue

import static extension duc.uscript.execution.interpreter.modelstate.ValueAspect.convertToString
import duc.uscript.execution.CharValue
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.interpreter.utils.GaussianDoubleUtils
import duc.uscript.utils.SymbolSet
import static duc.uscript.typing.TypeConcordance.*
import static duc.uscript.execution.interpreter.utils.MultPossibilityUtils.*
import static duc.aintea.lib.poissonbinomial.Computer.compute
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import duc.uscript.typing.InternalTypeDcl
import duc.uscript.uScript.Field

@Aspect(className=Plus)
class PlusAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value left = _self.left.evaluateExpression(state)
		val Value right = _self.right.evaluateExpression(state)
				
		// Left dispatch
		return switch (left) {
			ByteValue: left_plus(_self, left, right)
			ShortValue: left_plus(_self, left, right)
			IntegerValue: left_plus(_self, left, right)
			LongValue: left_plus(_self, left, right)
			FloatValue: left_plus(_self, left, right)
			DoubleValue: left_plus(_self, left, right)
			CharValue: p(_self, left, right)
			BooleanValue: left_plus(_self, left, right)
			StringValue: p(_self, left, right)
			ObjectRefValue: left_plus(_self, state, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + left.class.name)
		}
	}
	
	// Right dispatch
	private static def Value left_plus(ByteValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, left, right)
			ShortValue: p(_self, left, right)
			IntegerValue: p(_self, left, right)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			CharValue: p(_self, left, right)
			StringValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}	
	
	private static def Value left_plus(ShortValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, left, right)
			IntegerValue: p(_self, left, right)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			CharValue: p(_self, left, right)
			StringValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(IntegerValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, left, right)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			CharValue: p(_self, left, right)
			StringValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(LongValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, right, left)
			LongValue: p(_self, left, right)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			CharValue: p(_self, left, right)
			StringValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(FloatValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, right, left)
			LongValue: p(_self, right, left)
			FloatValue: p(_self, left, right)
			DoubleValue: p(_self, left, right)
			CharValue: p(_self, left, right)
			StringValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(DoubleValue left, Value right) {
		return switch(right) {
			ByteValue: p(_self, right, left)
			ShortValue: p(_self, right, left)
			IntegerValue: p(_self, right, left)
			LongValue: p(_self, right, left)
			FloatValue: p(_self, right, left)
			DoubleValue: p(_self, left, right)
			CharValue: p(_self, left, right)
			StringValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(BooleanValue left, Value right) {
		return switch(right) {
			StringValue: p(_self, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
	
	private static def Value left_plus(State state, ObjectRefValue left, Value right) {
		return switch(right) {
			ObjectRefValue: p(_self, state, left, right)
			default: throw new RuntimeException("Add operator not implemented for " + right.class.name)
		}
	}
		
	// All possible combination
	private static def StringValue p(StringValue x, Value y) {
		return ExecutionFactory::eINSTANCE.createStringValue => [
				value = x.value + y.convertToString
			]
	}
	
	private static def StringValue p(Value x, StringValue y) {
		return ExecutionFactory::eINSTANCE.createStringValue => [
				value = x.convertToString + y.value
			]
	}
	
	private static def StringValue p(CharValue x, Value y) {
		return ExecutionFactory::eINSTANCE.createStringValue => [
				value = x.value + y.convertToString
			]
	}
	
	private static def StringValue p(Value x, CharValue y) {
		return ExecutionFactory::eINSTANCE.createStringValue => [
				value = x.convertToString + y.value
			]
	}
	
	private static def StringValue p(BooleanValue x, StringValue y) {
		return ExecutionFactory::eINSTANCE.createStringValue => [
				value = x.value + y.value
			]
	}
		
	private def ByteValue p(ByteValue x, ByteValue y) {
		return ExecutionFactory::eINSTANCE.createByteValue => [
				value = (x.value + y.value) as byte
			]
	}
	
	private def ShortValue p(ByteValue x, ShortValue y) {
		return ExecutionFactory::eINSTANCE.createShortValue => [
				value = (x.value + y.value) as short
			]
	}
	
	private def IntegerValue p(ByteValue x, IntegerValue y) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				value = x.value + y.value
			]
	}
	
	private def LongValue p(ByteValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value + y.value
			]
	}
	
	private def FloatValue p(ByteValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value + y.value
			]
	}
	
	private def DoubleValue p(ByteValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value + y.value
			]
	}
		
	private def ShortValue p(ShortValue x, ShortValue y) {
		return ExecutionFactory::eINSTANCE.createShortValue => [
				value = (x.value + y.value) as short
			]
	}
	
	private def IntegerValue p(ShortValue x, IntegerValue y) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				value = x.value + y.value
			]
	}
	
	private def LongValue p(ShortValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value + y.value
			]
	}
	
	private def FloatValue p(ShortValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value + y.value
			]
	}
	
	private def DoubleValue p(ShortValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value + y.value
			]
	}
	
	private def IntegerValue p(IntegerValue x, IntegerValue y) {
		return ExecutionFactory::eINSTANCE.createIntegerValue => [
				value = x.value + y.value
			]
	}
	
	private def LongValue p(IntegerValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value + y.value
			]
	}
	
	private def FloatValue p(IntegerValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value + y.value
			]
	}
	
	private def DoubleValue p(IntegerValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value + y.value
			]
	}
	
	private def LongValue p(LongValue x, LongValue y) {
		return ExecutionFactory::eINSTANCE.createLongValue => [
				value = x.value + y.value
			]
	}
	
	private def FloatValue p(LongValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value + y.value
			]
	}
	
	private def DoubleValue p(LongValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value + y.value
			]
	}
	
	private def FloatValue p(FloatValue x, FloatValue y) {
		return ExecutionFactory::eINSTANCE.createFloatValue => [
				value = x.value + y.value
			]
	}
	
	private def DoubleValue p(FloatValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value + y.value
			]
	}
	
	private def DoubleValue p(DoubleValue x, DoubleValue y) {
		return ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = x.value + y.value
			]
	}
	
	private def ObjectRefValue p(State state, ObjectRefValue x, ObjectRefValue y) {
		if(isGaussian(y.instance.type)) {
			return plusGauss(_self, state, x, y)
		} else if(isPoissonBinomial(y.instance.type)) {
			return plusPoissBin(_self, state, x, y)
		} else {
			throw new RuntimeException('''«x.instance.type» + «y.instance.type» not yet implemented.''')
		}
	}
	
	
	private def ObjectRefValue plusGauss(State state, ObjectRefValue x, ObjectRefValue y) {
		val valX = GaussianDoubleUtils.getValue(x)
		val valY = GaussianDoubleUtils.getValue(y)
		
		val meanX = GaussianDoubleUtils.getMean(x)
		val meanY = GaussianDoubleUtils.getMean(y)
		
		val varX = GaussianDoubleUtils.getVariance(x)
		val varY = GaussianDoubleUtils.getVariance(y)
		
		val result = GaussianDoubleUtils.createGaussianDouble(state,
															  meanX.value + meanY.value,
															  varX.value + varY.value,
															  valX.value + valY.value,
															  _self)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
	
	private def ObjectRefValue plusPoissBin(State state, ObjectRefValue x, ObjectRefValue y) {
		val double[] probsX = extractProbs(x.instance)
		val double[] probsY = extractProbs(y.instance)
		
		val double[] probsRes = newDoubleArrayOfSize(probsX.length + probsY.length)
		System.arraycopy(probsX, 0, probsRes, 0, probsX.length)
		System.arraycopy(probsY, 0, probsRes, probsX.length, probsY.length)
		
		val double[] plusRes = compute(probsRes)
		
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjector()
		val internalTypeDcl = injector.getInstance(InternalTypeDcl)
		
		// PoissonBinomialDist
		// double[] initBernProbs;
		val initBernProbs = ExecutionFactory::eINSTANCE.createArrayInstance => [
			size = probsRes.length
		]
		state.arraysHeap.add(initBernProbs)
		var double sum = 0;
		for(pRes: probsRes) {
			initBernProbs.value.add(ExecutionFactory::eINSTANCE.createDoubleValue => [value = pRes])
			sum += pRes
		}
		
		// double[] probabilities;
		val probabilities = ExecutionFactory::eINSTANCE.createArrayInstance => [
			size = plusRes.length
		]
		state.arraysHeap.add(probabilities)
		for(p: plusRes) {
			probabilities.value.add(ExecutionFactory::eINSTANCE.createDoubleValue => [value = p])
		}
		
		val distType = internalTypeDcl.getPoissBinDistClass(_self)
		val dist = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = distType
		]
		state.objectsHeap.add(dist)
		dist.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field= distType.members.filter(Field).findFirst[it.name == "initBernProbs"]
			value = ExecutionFactory::eINSTANCE.createArrayRefValue => [instance = initBernProbs]
		])
		
		dist.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = distType.members.filter(Field).findFirst[it.name == "probabilities"]
			value = ExecutionFactory::eINSTANCE.createArrayRefValue => [ instance = probabilities]
		])
		
		// PoissonBinomialInt
		val poissBinIntClass = internalTypeDcl.getPoissBinIntClass(_self)
		val poissBinTypeClass = internalTypeDcl.getPoissBinClass(_self)
		val poissBinInt = ExecutionFactory::eINSTANCE.createObjectInstance => [ type = poissBinIntClass]
		val fSum = sum
		state.objectsHeap.add(poissBinInt)
		poissBinInt.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = poissBinTypeClass.members.filter(Field).findFirst[it.name == "confidence"]
			value = ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = dist]
		])
		poissBinInt.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = poissBinIntClass.members.filter(Field).findFirst[it.name == "value"]
			value = ExecutionFactory::eINSTANCE.createIntegerValue => [value = Math.round(fSum) as int]
		])
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = poissBinInt]
		
//		// Array of probs
//		val arrayProbs = ExecutionFactory::eINSTANCE.createArrayInstance => [
//			size = probsRes.length
//		]
//		state.arraysHeap.add(arrayProbs)
//		for(pRes: probsRes) {
//			arrayProbs.value.add(ExecutionFactory::eINSTANCE.createDoubleValue => [value = pRes])
//		}
//		
//		// Array of possibilities
//		val possibilitiesInstance = ExecutionFactory::eINSTANCE.createArrayInstance => [
//			size = sum.length
//		]
//		state.arraysHeap.add(possibilitiesInstance)
//		
//		val intPossType = internalTypeDcl.getIntPossibilityClass(_self)
//		val possType = internalTypeDcl.getPossibilityClass(_self)
//		for(var i=0; i< sum.length; i++) {
//			val probVal = ExecutionFactory::eINSTANCE.createObjectInstance => [
//				type = intPossType
//			]
//			state.objectsHeap.add(probVal)
//			
//			val p = sum.get(i)
//			val fi = i
//			probVal.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
//				field = possType.members.filter(Field).findFirst[ it.name == "confidence"]
//				value = ExecutionFactory::eINSTANCE.createDoubleValue => [value = p]
//			])
//			probVal.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
//				field = intPossType.members.filter(Field).findFirst[it.name == "value"]
//				value = ExecutionFactory::eINSTANCE.createIntegerValue => [value = fi]
//			])
//			possibilitiesInstance.value.add(ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = probVal])
//		}
//		
//		
//		
//		// General obj
//		val dblMultPossObjType = internalTypeDcl.getMultChoiceDoubleClass(_self)
//		val multPossObjIns = ExecutionFactory::eINSTANCE.createObjectInstance => [
//			type = dblMultPossObjType
//		]
//		state.objectsHeap.add(multPossObjIns)
//		multPossObjIns.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
//			field = dblMultPossObjType.members.filter(Field).findFirst[it.name == "possibilities"]
//			value = ExecutionFactory::eINSTANCE.createArrayRefValue => [instance = possibilitiesInstance]
//		])
//		val multPossType = internalTypeDcl.getMultChoiceClass(_self)
//		multPossObjIns.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
//			field = multPossType.members.filter(Field).findFirst[it.name == "rootProbs"]
//			value = ExecutionFactory::eINSTANCE.createArrayRefValue => [instance = arrayProbs ]
//		])
//		
//		
//		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = multPossObjIns];
	}
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		val result = new SymbolSet
		result.addAll(_self.left.findDependentVariables(state))
		result.addAll(_self.right.findDependentVariables(state))
		return result
	}
	
	
}