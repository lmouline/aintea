package duc.uscript.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import org.junit.jupiter.api.Test
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import duc.uscript.UScriptLang
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestDangling {
	
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
	@Inject	extension UScriptLang
	@Inject Provider<ResourceSet> rsp
		
	@Test
	def void testDangling() {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		
		val script = '''
			package a	
			
			import uscript.lang.*
				
			void m() {
				Bernoulli<bool> b = new Bernoulli<bool>(true, 0.5);
				Bernoulli bern = b.confidence;
			}
		'''.parse(resourceSet)
			
		assertNoErrors(script)
	}
	
}