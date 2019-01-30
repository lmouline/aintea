package duc.uscript.tests.parser

import com.google.inject.Inject
import com.google.inject.Provider
import duc.uscript.tests.UScriptInjectorProvider
import duc.uscript.uScript.Class
import duc.uscript.uScript.Program
import org.eclipse.emf.ecore.resource.ResourceSet
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
	@Inject extension ParseHelper<Program>
	@Inject Provider<ResourceSet> resourceSetProvider
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void testTwoFiles() {
		
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
	
}