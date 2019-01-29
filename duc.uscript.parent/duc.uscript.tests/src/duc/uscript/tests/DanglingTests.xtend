package duc.uscript.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import org.junit.jupiter.api.Test
import org.eclipse.xtext.testing.validation.ValidationTestHelper

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class DanglingTests {
	
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
		
	@Test
	def void testDanglind() {
		val script = '''
			void m() {
				Bernoulli<bool> b = null;
				Bernoulli bern = b.confidence;
			}
		'''.parse		
		assertNoErrors(script)
	}
	
}