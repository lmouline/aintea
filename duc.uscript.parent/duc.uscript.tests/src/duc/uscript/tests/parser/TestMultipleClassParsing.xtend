package duc.uscript.tests.parser

import com.google.inject.Inject
//import com.google.inject.Provider
import duc.uscript.tests.UScriptInjectorProvider
import duc.uscript.uScript.Class
import duc.uscript.uScript.Script
//import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestMultipleClassParsing {
	@Inject extension ParseHelper<Script>
//	@Inject Provider<ResourceSet> resourceSetProvider
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void testRefFullQualifiedName() {
		
		val firstScript = '''
			package b
			class B extends a.A {}
		'''.parse
		val secondScript = '''
			package a
			class A {
				b.B b;
			}
		'''.parse(firstScript.eResource.resourceSet)
		
		firstScript.assertNoErrors
		secondScript.assertNoErrors
		
		val superClassB = (firstScript.elements.get(0) as Class).superClass
		val classA = (secondScript.elements.get(0) as Class)
		
		
		Assertions.assertSame(superClassB, classA)		
	}
	
	@Test
	def void testImport() {
		val firstScript = '''
			package my.pack.a
			
			class A1{}
			class A2{}
		'''.parse
		
		val secondScript = '''
			package my.pack.b
			
			class B1{}
			class B2{}
		'''.parse(firstScript.eResource.resourceSet)
		
		val thirdScript = '''
			package my.pack.c
			
			import my.pack.a.A2
			import my.pack.b.*
			
			class C1 extends my.pack.a.A1 {
				A2 a2;
				B1 b1;
				B2 b2;
			}
		'''.parse(firstScript.eResource.resourceSet)
		
		assertNoErrors(firstScript)
		assertNoErrors(secondScript)
		assertNoErrors(thirdScript)
		
		
	}
	
}