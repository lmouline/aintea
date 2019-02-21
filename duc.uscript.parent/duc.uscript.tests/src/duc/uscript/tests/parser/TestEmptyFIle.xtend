package duc.uscript.tests.parser

import com.google.inject.Inject
import duc.uscript.uScript.Program
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import duc.uscript.tests.UScriptInjectorProvider
import org.eclipse.xtext.testing.validation.ValidationTestHelper

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestEmptyFIle {
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
	
	@Test
	def void emptyClass() {
		"".parse.assertNoErrors
	}
	
}