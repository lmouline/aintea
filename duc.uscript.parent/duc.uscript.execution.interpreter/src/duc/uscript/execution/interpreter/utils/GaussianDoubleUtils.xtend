package duc.uscript.execution.interpreter.utils

import duc.uscript.execution.DoubleValue
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.State
import org.eclipse.emf.ecore.EObject
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import duc.uscript.typing.InternalTypeDcl
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.Field

class GaussianDoubleUtils {
	
	def static DoubleValue getValue(ObjectRefValue gaussianDouble) {
		return gaussianDouble.instance
		                     .fieldbindings
		                     .findFirst[field.name == "value"]
		                     .value as DoubleValue
	}
	
	def static DoubleValue getMean(ObjectRefValue gaussianDouble) {
		val confidence = gaussianDouble.instance
									   .fieldbindings
									   .findFirst[field.name == "confidence"]
									   .value as ObjectRefValue
									   
		return confidence.instance
						 .fieldbindings
						 .findFirst[field.name == "mean"]
						 .value as DoubleValue
	}
	
	def static DoubleValue getVariance(ObjectRefValue gaussianDouble) {
		val confidence = gaussianDouble.instance
									   .fieldbindings
									   .findFirst[field.name == "confidence"]
									   .value as ObjectRefValue
									   
		return confidence.instance
						 .fieldbindings
						 .findFirst[field.name == "variance"]
						 .value as DoubleValue
	}
	
	def static createGaussianDouble(State state, double mean, double variance, double doubleVal, EObject ctx) {
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjector()
		val internalTypeDcl = injector.getInstance(InternalTypeDcl)
		
		val dist = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = internalTypeDcl.getGaussianDistClass(ctx)
		]
		dist.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = dist.type.members.filter(Field).findFirst[ it.name == "mean"]
			value = ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = mean
			]
		])
		dist.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = dist.type.members.filter(Field).findFirst[ it.name == "variance"]
			value = ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = variance
			]
		])
		state.objectsHeap.add(dist)
		
		val refDist = ExecutionFactory::eINSTANCE.createObjectRefValue => [
			instance = dist
		]
		
		val finalType = internalTypeDcl.getGaussianDoubleClass(ctx)
		val result = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = finalType
		]
		
		result.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = internalTypeDcl.getBernoulliClass(ctx).members.filter(Field).get(0)
			value = refDist
		])
		result.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = finalType.members.filter(Field).get(0)
			value = ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = doubleVal
			]
		])
		state.objectsHeap.add(result)
		
		return result
	}
}