package duc.uminijava.semantics.statements

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import fr.inria.diverse.k3.al.annotationprocessor.Step
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ArrayRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.IntegerValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataFactory
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue
import org.tetrabox.minijava.dynamic.minijavadynamicdata.State
import org.tetrabox.minijava.xtext.miniJava.ArrayAccess
import org.tetrabox.minijava.xtext.miniJava.Assignment
import org.tetrabox.minijava.xtext.miniJava.Field
import org.tetrabox.minijava.xtext.miniJava.FieldAccess
import org.tetrabox.minijava.xtext.miniJava.SymbolRef
import org.tetrabox.minijava.xtext.miniJava.VariableDeclaration

import static extension duc.uminijava.semantics.utils.ContextAspect.*
import static extension duc.uminijava.semantics.expressions.ExpressionAspect.*
import static extension duc.uminijava.semantics.utils.StateAspect.*
import static extension duc.uminijava.semantics.ImplicitConversionUtil.*

@Aspect(className=Assignment)
class AssigmentAspect extends StatementAspect {
	@OverrideAspectMethod
	@Step
	def void evaluateStatement(State state) {
		val context = state.findCurrentContext
		val assignee = _self.assignee
		val right = _self.value.evaluateExpression(state).convert(assignee)
					
		switch (assignee) {
			SymbolRef: {
				val existingBinding = context.findBinding(assignee.symbol)
				existingBinding.value = right
			}
			VariableDeclaration: {
				val binding = MinijavadynamicdataFactory::eINSTANCE.createSymbolBinding => [
					symbol = assignee
					value = right
				]
				context.bindings.add(binding)
			}
			FieldAccess: {
				val f = assignee.field as Field
				val realReceiver = (assignee.receiver.evaluateExpression(state) as ObjectRefValue).instance
				val existingBinding = realReceiver.fieldbindings.findFirst[it.field === f]
				if (existingBinding !== null) {
					existingBinding.value = right
				} else {
					val binding = MinijavadynamicdataFactory::eINSTANCE.createFieldBinding => [
						field = f
						value = right
					]
					realReceiver.fieldbindings.add(binding)
				}
			}
			ArrayAccess: {
				val array = (assignee.object.evaluateExpression(state) as ArrayRefValue).instance
				val index = (assignee.index.evaluateExpression(state) as IntegerValue).value
				array.value.set(index,right) 
			}
			default: throw new Exception("Cannot assign a value to "+assignee)
		}
	}
}