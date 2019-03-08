package duc.uscript.execution.interpreter.expression.bool

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.uScript.Not
import duc.uscript.execution.ObjectRefValue
import duc.uscript.execution.DoubleValue
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import duc.uscript.typing.InternalTypeDcl
import duc.uscript.uScript.Field

@Aspect(className=Not)
class NotAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value value = _self.expression.evaluateExpression(state)
		
		//Left dispatch		
		return switch(value) {
			BooleanValue: private_not(_self, value)
			ObjectRefValue: private_not(_self, value, state)
			default: throw new RuntimeException("Not yet implemented for " + value.class.name)
		}
	}
		
	// All possible combination
	private static def BooleanValue private_not(BooleanValue x) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = !x.value
		]
	}
	
	private static def ObjectRefValue private_not(ObjectRefValue x, State state) {
		val fieldBdgX = x.instance.fieldbindings
		
		val valX = fieldBdgX.findFirst[field.name == "value"]
							.value as BooleanValue		
		val confX = fieldBdgX.findFirst[field.name == "confidence"]
							 .value as ObjectRefValue
		val probX = confX.instance
						 .fieldbindings
						 .findFirst[field.name == "probability"]
						 .value as DoubleValue
						 				 
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjector()
		
		val internalTypeDcl = injector.getInstance(InternalTypeDcl)
									 			
		val dist = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = internalTypeDcl.getBernoulliDistClass(_self)
		]
		dist.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = dist.type.members.filter(Field).get(0)
			value = ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = 1 - probX.value
			]
		])
		state.objectsHeap.add(dist)
		
		val refDist = ExecutionFactory::eINSTANCE.createObjectRefValue => [
			instance = dist
		]
		
		val finalType = internalTypeDcl.getBernoulliBoolClass(_self)
		val result = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = finalType
		]
		
		result.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = internalTypeDcl.getBernoulliClass(_self).members.filter(Field).get(0)
			value = refDist
		])
		result.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = finalType.members.filter(Field).get(0)
			value = ExecutionFactory::eINSTANCE.createBooleanValue => [
				value = !valX.value
			]
		])
		state.objectsHeap.add(result)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
}