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
import duc.uscript.validation.CFValidator
import static duc.uscript.typing.InternalTypeDcl.*
import org.eclipse.xtext.diagnostics.Diagnostic
import org.junit.jupiter.api.Assertions

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestCFValidator {
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void testNoErrorIfEmptyCond() {
		val script = '''
			void m() {
				if() {
					
				}
			}
		'''.parse
				
		assertError(script, UScriptPackage.eINSTANCE.ifStatement,Diagnostic.SYNTAX_DIAGNOSTIC)
		val issues = validate(script)
		Assertions.assertEquals(1, issues.length)
	}
	
	@Test
	def void testNoErrorIfBoolCond() {
		val script = '''
			void m() {
				if(true) {
					
				}
			}
		'''.parse
		assertNoError(script, CFValidator.WRONG_COND_TYPE)
	}
	
	@Test
	def void testErrorsIfBoolCond() {
		val args = #["\"a\"", "1", "0.1", "1L", "null", "new A()"]
		val types = #[STRING_TYPE.name, BYTE_TYPE.name, FLOAT_TYPE.name, LONG_TYPE.name, NULL_TYPE.name, "A"]
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val t = types.get(i)
			
			val script = '''
				class A() {}
				void m() {
					if(«a») {
						
					}
				}
			'''.parse
			
			assertError(
				script,
				UScriptPackage.eINSTANCE.ifStatement,
				CFValidator.WRONG_COND_TYPE,
				'''If statement requires a bool expression for the condition. Actual: «t»'''
			)
		}
	}
}