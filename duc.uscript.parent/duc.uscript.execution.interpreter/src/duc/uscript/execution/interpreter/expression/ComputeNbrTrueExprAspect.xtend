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
import java.util.Arrays
import duc.uscript.execution.ExecutionFactory
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import duc.uscript.typing.InternalTypeDcl
import org.eclipse.emf.common.util.EList
import duc.uscript.uScript.Field

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
		
		// Array of possibilities
		val possibilitiesInstance = ExecutionFactory::eINSTANCE.createArrayInstance => [
			size = probs.length
		]
		state.arraysHeap.add(possibilitiesInstance)
		
		val intPossType = internalTypeDcl.getIntPossibilityClass(_self)
		val possType = internalTypeDcl.getPossibilityClass(_self)
		for(var i=0; i< probs.length; i++) {
			val probVal = ExecutionFactory::eINSTANCE.createObjectInstance => [
				type = intPossType
			]
			state.objectsHeap.add(probVal)
			
			val p = probs.get(i)
			val fi = i
			probVal.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
				field = possType.members.filter(Field).findFirst[ it.name == "confidence"]
				value = ExecutionFactory::eINSTANCE.createDoubleValue => [value = p]
			])
			probVal.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
				field = intPossType.members.filter(Field).findFirst[it.name == "value"]
				value = ExecutionFactory::eINSTANCE.createIntegerValue => [value = fi]
			])
			possibilitiesInstance.value.add(ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = probVal])
		}
		
		
		
		// General obj
		val multPossObjType = internalTypeDcl.getMultChoiceDoubleClass(_self)
		val multPossObjIns = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = multPossObjType
		]
		multPossObjIns.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = multPossObjType.members.filter(Field).findFirst[it.name == "possibilities"]
			value = ExecutionFactory::eINSTANCE.createArrayRefValue => [instance = possibilitiesInstance]
		])
		
		state.objectsHeap.add(multPossObjIns)
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = multPossObjIns];
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