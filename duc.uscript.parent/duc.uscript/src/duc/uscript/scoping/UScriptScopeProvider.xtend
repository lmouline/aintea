/*
 * generated by Xtext 2.16.0
 */
package duc.uscript.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.EReference
import duc.uscript.uScript.UScriptPackage
import duc.uscript.uScript.Method
import org.eclipse.xtext.scoping.Scopes
import duc.uscript.uScript.Block
import duc.uscript.uScript.Class
import duc.uscript.uScript.Assignment
import duc.uscript.uScript.VariableDeclaration
import duc.uscript.uScript.Field
import duc.uscript.uScript.ForStatement
import static duc.uscript.typing.TypeResolver.*
import static duc.uscript.typing.TypeConcordance.*
import duc.uscript.uScript.FieldAccess
import duc.uscript.uScript.MethodCall
import duc.uscript.typing.InternalTypeDcl

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class UScriptScopeProvider extends AbstractUScriptScopeProvider {
	
	val ePackage = UScriptPackage.eINSTANCE
		
	override IScope getScope(EObject context, EReference reference) {		
		InternalTypeDcl.init(context.eResource)
		if (reference === ePackage.symbolRef_Symbol) {
			return getScopeForSymbolRef(context)
		}
		
		if(reference === ePackage.fieldAccess_Field) {
			return getScopeForFieldAccess(context as FieldAccess)
		}
		
		if(reference === ePackage.methodCall_Method) {
			return getScopeForMethodCall(context as MethodCall)
		}
		
		return super.getScope(context, reference)
	}
	
	def private IScope getScopeForMethodCall(MethodCall methodCall) {
		val type = type(methodCall.receiver)
		
		if(!isPrimitive(type)) {
			return getClassMethods(type)
		}
		
		return IScope.NULLSCOPE
		
	}
	
	def private IScope getScopeForFieldAccess(FieldAccess field) {
		val type = type(field.receiver)
		
		if(!isPrimitive(type)) {
			return getClassFields(type)
		}
		
		return IScope.NULLSCOPE
	}
	
	def private IScope getScopeForSymbolRef(EObject ctx) {
		val container = ctx.eContainer
		if(container === null) {
			return IScope.NULLSCOPE
		}
		return switch (container) {
			Class: {
				getClassFields(container)
			}
			Method: {
				Scopes.scopeFor(
					container.params,
					getScopeForSymbolRef(container)
				)
			}
			Block: {
				Scopes.scopeFor(
					container.statements.takeWhile[it != ctx].filter(Assignment)
										.map[it.assignee].filter(VariableDeclaration),
					getScopeForSymbolRef(container)
				)
			}
			ForStatement: {
				Scopes.scopeFor(
					#[container.declaration.assignee],
					getScopeForSymbolRef(container)
				)
				
			}
			default: getScopeForSymbolRef(container)
		}
	}
	
	private def IScope getClassFields(Class c) {
		if(c === null) {
			return IScope.NULLSCOPE
		}
		return Scopes.scopeFor(
					c.members.filter(Field),
					getClassFields(c.superClass)
				)
	}
	
	private def IScope getClassMethods(Class c) {
		if(c === null) {
			return IScope.NULLSCOPE
		}
		return Scopes.scopeFor(
					c.members.filter(Method),
					getClassMethods(c.superClass)
				)
	}

}
