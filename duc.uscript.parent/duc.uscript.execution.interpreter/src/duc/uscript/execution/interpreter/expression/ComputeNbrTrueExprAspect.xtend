package duc.uscript.execution.interpreter.expression

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.utils.SymbolSet
import duc.uscript.execution.State
import duc.uscript.execution.Value
import duc.uscript.uScript.ComputeNbTrueExpr
import duc.aintea.lib.poissonbinomial.Computer
import duc.uscript.execution.ArrayRefValue
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.interpreter.utils.BernoulliBoolUtils
import duc.uscript.execution.ExecutionFactory
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import duc.uscript.typing.InternalTypeDcl
import org.eclipse.emf.common.util.EList
import duc.uscript.uScript.Field
import duc.uscript.execution.ArrayInstance

@Aspect(className=ComputeNbTrueExpr)
class ComputeNbrTrueExprAspect extends ExpressionAspect {
	
	@OverrideAspectMethod
	def SymbolSet findDependentVariables(State state) {
		return new SymbolSet
	}
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val valueExpr = _self.expr.evaluateExpression(state)
		if(!(valueExpr instanceof ArrayRefValue)) {
			throw new RuntimeException("ComputeNbTrueExpr.evaluateExpression: type of expression not managed. Expected: ArrayRef. Actual: " + valueExpr.class);
		}
		
		val double[] probs = computePb(_self, valueExpr as ArrayRefValue)
		
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjector()
		val internalTypeDcl = injector.getInstance(InternalTypeDcl)
		
		// PoissonBinomialDist
		// double[] initBernProbs;
		val int[] sum = newIntArrayOfSize(1);
		val initBernProbs = bernArrayToDoubleArray(_self, valueExpr as ArrayRefValue, sum)
		state.arraysHeap.add(initBernProbs)
		
		// double[] probabilities;
		val probabilities = ExecutionFactory::eINSTANCE.createArrayInstance => [
			size = probs.length
		]
		state.arraysHeap.add(probabilities)
		for(p: probs) {
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
		state.objectsHeap.add(poissBinInt)
		poissBinInt.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = poissBinTypeClass.members.filter(Field).findFirst[it.name == "confidence"]
			value = ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = dist]
		])
		poissBinInt.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = poissBinIntClass.members.filter(Field).findFirst[it.name == "value"]
			value = ExecutionFactory::eINSTANCE.createIntegerValue => [value = sum.get(0)]
		])
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = poissBinInt]

//		val multPossObjIns = ExecutionFactory::eINSTANCE.createObjectInstance => [
//			type = dblMultPossObjType
//		]
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
//		state.objectsHeap.add(multPossObjIns)
//		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = multPossObjIns];
		
//		val intPossType = internalTypeDcl.getIntPossibilityClass(_self)
//		val possType = internalTypeDcl.getPossibilityClass(_self)
//		for(var i=0; i< probs.length; i++) {
//			val probVal = ExecutionFactory::eINSTANCE.createObjectInstance => [
//				type = intPossType
//			]
//			state.objectsHeap.add(probVal)
//			
//			val p = probs.get(i)
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
		
		// General obj
//		val dblMultPossObjType = internalTypeDcl.getMultChoiceDoubleClass(_self)
//		val multPossObjIns = ExecutionFactory::eINSTANCE.createObjectInstance => [
//			type = dblMultPossObjType
//		]
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
//		state.objectsHeap.add(multPossObjIns)
//		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = multPossObjIns];
	}
	
	private def ArrayInstance bernArrayToDoubleArray(ArrayRefValue bernArray, int[] sum) {
		val EList<Value> array = bernArray.instance.value
		
		val result = ExecutionFactory::eINSTANCE.createArrayInstance => [
			size = array.size
		]
		
		var double tmp_sum = 0;
		for(var i=0; i<array.size; i++) {
			val prob = BernoulliBoolUtils.getProbability(array.get(i) as ObjectRefValue).value
			result.value.add(ExecutionFactory::eINSTANCE.createDoubleValue => [value = prob])
			tmp_sum += prob;
		}
		sum.set(0, Math.round(tmp_sum) as int);
		
		return result
	}
	
	private def double[] computePb(ArrayRefValue valueExpr) {
		val instance = valueExpr.instance
		val array = instance.value
		
		var double[] probs = newDoubleArrayOfSize(instance.size);
		
		for(var i=0;i<instance.size; i++) {
			if(!(array.get(i) instanceof ObjectRefValue)) {
				throw new RuntimeException("ComputeNbTrueExpr.evaluateExpression: type of expression not managed. Expected: ArrayRef. Actual: " + array.get(i).class);
			}
			
			probs.set(i, BernoulliBoolUtils.getProbability(array.get(i) as ObjectRefValue).value)	
		}
		
		return Computer.compute(probs)
	}
}