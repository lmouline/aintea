package duc.uscript.tests.scoping

import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import com.google.inject.Inject
import duc.uscript.scoping.UScriptIndex
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestUScriptIndex {
	
	@Inject extension ParseHelper<Program>
	@Inject extension UScriptIndex
	
	@Test
	def void testExportedEObjectDescriptions() {
		val script = '''
		class A {}
		
		class B {
			A a;
			A f(A p) {
				A v;
				return null;	
		 	}
		}
		
		void C(A p){
			A a;
		}
		'''.parse
		
		val expectedEODec = "A, B, B.a, B.f, B.f.p, B.f.v, C, C.p, C.a"
		val actual = script.exportedEObjectDescriptions.map[qualifiedName].join(", ")
		Assertions.assertEquals(expectedEODec, actual)
		
		val expectedClasses = "A, B"
		val actualClasses = script.exportedClassesEObjectDescriptions.map[qualifiedName].join(", ")
		Assertions.assertEquals(expectedClasses, actualClasses)
		
		val expectedMethods = "C"
		val actualMethods = script.exportedMethodsEObjectDescriptions.map[qualifiedName].join(", ")
		Assertions.assertEquals(expectedMethods, actualMethods)
	}
	
}