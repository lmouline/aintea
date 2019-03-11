package duc.uscript.execution.interpreter.utils

import duc.uscript.execution.ObjectInstance
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.Field
import duc.uscript.execution.State
import org.eclipse.emf.ecore.EObject
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import duc.uscript.typing.InternalTypeDcl
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.DoubleValue

class BernoulliBoolUtils {
	
	def static ObjectInstance createBernoulliBool(State state, double probValue, boolean boolVal, EObject ctx) {
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjector()
		val internalTypeDcl = injector.getInstance(InternalTypeDcl)
		
		val dist = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = internalTypeDcl.getBernoulliDistClass(ctx)
		]
		dist.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = dist.type.members.filter(Field).get(0)
			value = ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = probValue
			]
		])
		state.objectsHeap.add(dist)
		
		val refDist = ExecutionFactory::eINSTANCE.createObjectRefValue => [
			instance = dist
		]
		
		val finalType = internalTypeDcl.getBernoulliBoolClass(ctx)
		val result = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = finalType
		]
		
		result.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = internalTypeDcl.getBernoulliClass(ctx).members.filter(Field).get(0)
			value = refDist
		])
		result.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = finalType.members.filter(Field).get(0)
			value = ExecutionFactory::eINSTANCE.createBooleanValue => [
				value = boolVal
			]
		])
		state.objectsHeap.add(result)
		
		return result
	}
	
	def static BooleanValue getValue(ObjectRefValue bernoulliBool) {
		return bernoulliBool.instance
					 .fieldbindings
					 .findFirst[field.name == "value"]
					 .value as BooleanValue
	}
	
	def static DoubleValue getProbability(ObjectRefValue bernoulliBool) {
		val confY = bernoulliBool.instance
								 .fieldbindings
								 .findFirst[field.name == "confidence"]
							 	 .value as ObjectRefValue
		return confY.instance
						 .fieldbindings
						 .findFirst[field.name == "probability"]
						 .value as DoubleValue
	}
	
}