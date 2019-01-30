package duc.uscript.tests.validator

import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import duc.uscript.uScript.UScriptPackage
import duc.uscript.validation.UScriptValidator

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestUScriptValidator {
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
	
	@Test
	def void checkUniquenessClass() {
		val script = '''
			package myPack
			class A {}
			class A {}
		'''.parse
		
		script.assertError(UScriptPackage.eINSTANCE.class_, UScriptValidator.DUPLICATE_NAME, '''A class named A already exists.''')
	}
	
	@Test
	def void checkUniquenessFunction() {
		val script = '''
			package myPack
			void A();
			void A();
		'''.parse
		
		script.assertError(UScriptPackage.eINSTANCE.method, UScriptValidator.DUPLICATE_NAME, '''A function named A already exists.''')
	}
	
}