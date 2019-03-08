package duc.uscript.execution.interpreter.expression.bool

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.And
import duc.uscript.execution.interpreter.expression.ExpressionAspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import duc.uscript.execution.Value
import duc.uscript.execution.State
import duc.uscript.execution.BooleanValue
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.ObjectRefValue
import duc.uscript.uScript.Field
import duc.uscript.execution.DoubleValue
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import duc.uscript.typing.InternalTypeDcl
import duc.uscript.typing.TypeResolver

@Aspect(className=And)
class AndAspect extends ExpressionAspect{
	
	@OverrideAspectMethod
	def Value evaluateExpression(State state) {
		val Value left = _self.left.evaluateExpression(state)
		val Value right = _self.right.evaluateExpression(state)
		
		//Left dispatch		
		return switch(left) {
			BooleanValue: rightDispatch(_self, left, right)
			ObjectRefValue: rightDispatch(_self, left, right, state)
			default: throw new RuntimeException("Not yet implemented for " + left.class.name)
		}
	}
	
	//Right dispatch
	private static def BooleanValue rightDispatch(BooleanValue left, Value right) {
		return switch(right) {
			BooleanValue: private_and(_self, left, right)
			default: throw new RuntimeException("Not yet implemented for " + right.class.name)
		}
	}
	
	//Bernoulli<bool>
	private static def ObjectRefValue rightDispatch(ObjectRefValue left, Value right, State state) {
		return switch(right) {
			ObjectRefValue: private_and(_self, left, right, state)
			default: throw new RuntimeException("Not yet implemented for " + right.class.name)
		}
	}
	
	// All possible combination
	private static def BooleanValue private_and(BooleanValue x, BooleanValue y) {
		return ExecutionFactory::eINSTANCE.createBooleanValue => [
			value = x.value && y.value
		]
	}
	
	private static def ObjectRefValue private_and(ObjectRefValue x, ObjectRefValue y, State state) {
		val fieldBdgX = x.instance.fieldbindings
		val fieldBdgY = y.instance.fieldbindings
		
		val valX = fieldBdgX.findFirst[field.name == "value"]
							.value as BooleanValue
		val valY = fieldBdgY.findFirst[field.name == "value"]
		                    .value as BooleanValue
		
		val confX = fieldBdgX.findFirst[field.name == "confidence"]
							 .value as ObjectRefValue
		val probX = confX.instance
						 .fieldbindings
						 .findFirst[field.name == "probability"]
						 .value as DoubleValue
						 
		val confY = fieldBdgY.findFirst[field.name == "confidence"]
							 .value as ObjectRefValue
		val probY = confY.instance
						 .fieldbindings
						 .findFirst[field.name == "probability"]
						 .value as DoubleValue
						 
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		
		val internalTypeDcl = injector.getInstance(InternalTypeDcl)
									 			
		val dist = ExecutionFactory::eINSTANCE.createObjectInstance => [
			type = internalTypeDcl.getBernoulliDistClass(_self)
		]
		dist.fieldbindings.add(ExecutionFactory::eINSTANCE.createFieldBinding => [
			field = dist.type.members.filter(Field).get(0)
			value = ExecutionFactory::eINSTANCE.createDoubleValue => [
				value = probX.value * probY.value
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
				value = valX.value && valY.value
			]
		])
		state.objectsHeap.add(result)
		
		return ExecutionFactory::eINSTANCE.createObjectRefValue => [instance = result]
	}
}